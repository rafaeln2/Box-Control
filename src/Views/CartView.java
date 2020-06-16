package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import CreateEntity.CreateEntityInDataBase;
import Entity.Carrinho;
import Entity.Produto;
import Entity.Venda;
import EntityImp.EstoqueImp;
import GetConnection.GetConnection;
import InterfaceView.InterfaceView;

public class CartView extends JPanel implements InterfaceView {
	
	private static final long serialVersionUID = 1L;
	private PreparedStatement stm;
	private ResultSet rs;
	
	private JScrollPane scrollPane = new JScrollPane();

	private JTable table;
	
	private JLabel lblTipoPagamento;
	private JLabel lblQuantity;
	private JLabel lblTotalAPagar;
	private JLabel lblTotalItens;
	
	private Venda venda;
	
	private JTextField productField;
	private JTextField cdFuncField;
	private JTextField typePagField;

	private JButton btnAddCart;
	private JButton btnRemoverItem;
	private JButton btnFinalizar;
	
	private JSpinner quantitySpinner;
	
	private double totalValue = 0.00;
	private int totalItems = 0;
	private DefaultTableModel model;
	private ArrayList<Carrinho> listaCarrinho = new ArrayList<Carrinho>();

	public CartView() {
		setTable();
		setSettingsView();
		setBtnListeners();
	}
	
	@Override
	public void setBtnListeners() {
		
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(productField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione um produto");
				} else if(Integer.parseInt(quantitySpinner.getValue().toString()) == 0) {
					JOptionPane.showMessageDialog(null, "Selecione quantidade");
				} else {
					
					int qtdEmEstoque = 0;
					int qtdCompra = Integer.parseInt(quantitySpinner.getValue().toString());

					try {
						qtdEmEstoque = Integer.parseInt(isProductAvailable(productField.getText()));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					if (qtdEmEstoque >= qtdCompra) {
						CreateEntityInDataBase createEntityInDataBase = new CreateEntityInDataBase();
						try {
							
							Date date = new Date();
							venda = new Venda (date);	
							
							createEntityInDataBase.create(venda);
							
							int spinnerValue = Integer.parseInt(quantitySpinner.getValue().toString());
							
							ArrayList <Produto> produtos = getInfoProduct(productField.getText());
							
							double price = produtos.get(0).getValor() * Double.parseDouble(quantitySpinner.getValue().toString());
							
							model.addRow(new Object [] {quantitySpinner.getValue(), produtos.get(0).getDesc(), price});	
							
							Carrinho carrinho = new Carrinho (Integer.parseInt(cdFuncField.getText()), venda.getcdVenda(), Integer.parseInt(productField.getText()), spinnerValue, typePagField.getText());
							System.out.println("Carrinho" + carrinho);
							listaCarrinho.add(carrinho);

							getSum(table, lblTotalAPagar);
							getItems(table, lblTotalItens);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Item indisponivel no momento.");

					}
				}
			}
		});
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateEntityInDataBase createEntityInDataBase = new CreateEntityInDataBase();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				EstoqueImp estoqueImp = new EstoqueImp();
								
				int i = 0 ;
				try {						
					System.out.println("Tipo pagamento: "+ typePagField.getText());
															
					for(i = 0; i < listaCarrinho.size(); i++){
						createEntityInDataBase.create(listaCarrinho.get(i));
						
						String cdProdutoString = String.valueOf(listaCarrinho.get(i).getCdProduto());
						int qtdEmEstoque = Integer.parseInt(isProductAvailable(cdProdutoString));

						System.out.println("Carrinho criado" + listaCarrinho.get(i));
						estoqueImp.updateEstoque(listaCarrinho.get(i).getCdProduto(), (qtdEmEstoque - listaCarrinho.get(i).getQuantidade()) );
					}	
					
					clearRow(model);
					clearTextField();
				} catch (Exception e) {
					e.printStackTrace();	
				}
			}
		});
		
		btnRemoverItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.removeRow(table.getSelectedRow());	
					getSum(table, lblTotalAPagar);
					getItems(table, lblTotalItens);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um item na tabela");
				}
			}
		});
		
	}
	
	public void clearTextField() {
		productField.setText("");
		typePagField.setText("");
		cdFuncField.setText("");
		quantitySpinner.setValue(0);
	}
	
	public void clearRow (DefaultTableModel model) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}	
	}
	
	public ArrayList<Produto> getInfoProduct(String cdProduto) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select descr,valor from produto where cdproduto = (?)");
		stm.setInt(1, Integer.parseInt(cdProduto));
		rs = stm.executeQuery();

		ArrayList<Produto> produtos = new ArrayList<>();

		while(rs.next()) {
			String descr = rs.getString("DESCR");
			Float valor = rs.getFloat("VALOR");
			produtos.add(new Produto(descr, valor, "teste"));
		}
		return produtos;
	}
	
	public String isProductAvailable(String cdProduto) throws Exception {
		String result = "";
		GetConnection conexao = new GetConnection ();
		int cdProdutoToInt = Integer.parseInt(cdProduto);
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("SELECT QUANTIDADE FROM ESTOQUE WHERE CDPRODUTO = (?)");
		stm.setInt(1, cdProdutoToInt);

		rs = stm.executeQuery();
		
		ResultSetMetaData rsmd = rs.getMetaData();

		int columnsNumber = rsmd.getColumnCount();

		while(rs.next()) {
			for(int i = 1; i <= columnsNumber; i++) {
				System.out.printf("{%s: %s} %n", rsmd.getColumnName(i), rs.getString(i));
				result = rs.getString(i);
			}
		}
		return result;
	}
	
	@Override
	public void setTable () {
		table = new JTable();
		table.setFont(new Font("Courier New", Font.PLAIN, 12));
		table.setBackground(new Color(255, 255, 153));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Qtde", "Produto", "Preço"
			}
		) {
			private static final long serialVersionUID = 8400256977919727622L;
			
			@SuppressWarnings({ "rawtypes" })
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setMinWidth(250);
		table.getColumnModel().getColumn(1).setMaxWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		
		scrollPane.setViewportView(table);
		model = (DefaultTableModel)table.getModel();
	}
	
	@Override
	public void setSettingsView(){
		btnAddCart = new JButton("Adicionar ao carrinho");
		btnAddCart.setBounds(30, 380, 400, 40);
		this.add(btnAddCart);
		
		btnAddCart.setBounds(30, 380, 400, 40);
		this.add(btnAddCart);
		
		this.setBackground(Color.WHITE);
		this.setFont(new Font("Roboto", Font.PLAIN, 12));
		this.setBounds(100, 100, 960, 540);
		setLayout(null);
		
		lblTipoPagamento = new JLabel("Tipo Pagamento:");
		lblTipoPagamento.setFont(new Font("Roboto", Font.BOLD, 28));
		lblTipoPagamento.setBounds(30, 229, 400, 43);
		this.add(lblTipoPagamento);
		
		typePagField = new JTextField();
		typePagField.setToolTipText("Digite a forma de pagamento...");
		typePagField.setFont(new Font("Roboto", Font.PLAIN, 14));
		typePagField.setBounds(30, 276, 400, 30);
		this.add(typePagField);
		typePagField.setColumns(10);
		
		JLabel lblProduto = new JLabel("Cod Produto:");
		lblProduto.setFont(new Font("Roboto", Font.BOLD, 28));
		lblProduto.setBounds(30, 138, 400, 43);
		this.add(lblProduto);
		
		productField = new JTextField();
		productField.setToolTipText("Digite o nome do produto...");
		productField.setHorizontalAlignment(SwingConstants.LEFT);
		productField.setFont(new Font("Roboto", Font.PLAIN, 14));
		productField.setBounds(30, 193, 400, 30);
		this.add(productField);
		productField.setColumns(10);
		
		lblQuantity = new JLabel("Quantidade:");
		lblQuantity.setFont(new Font("Roboto", Font.BOLD, 28));
		lblQuantity.setBounds(30, 324, 400, 43);
		this.add(lblQuantity);
		
		quantitySpinner = new JSpinner();
		quantitySpinner.setToolTipText("Selecione a quantidade do produto...");
		quantitySpinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		quantitySpinner.setFont(new Font("Roboto", Font.BOLD, 18));
		quantitySpinner.setBounds(373, 324, 57, 43);
		this.add(quantitySpinner);
		
		btnRemoverItem = new JButton("Remover Item");
		btnRemoverItem.setFont(new Font("Roboto", Font.BOLD, 14));
		btnRemoverItem.setForeground(new Color(255, 255, 255));
		btnRemoverItem.setBackground(new Color(255, 0, 51));
		btnRemoverItem.setBounds(30, 432, 190, 30);
		this.add(btnRemoverItem);
		
		btnFinalizar = new JButton("Finalizar compra");
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnFinalizar.setBackground(new Color(0, 204, 51));
		btnFinalizar.setBounds(240, 432, 190, 30);
		this.add(btnFinalizar);
		
		lblTotalAPagar = new JLabel("Total a pagar: R$ " + String.format("%.2f", totalValue));
		lblTotalAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAPagar.setFont(new Font("Roboto", Font.BOLD, 24));
		lblTotalAPagar.setBounds(640, 467, 286, 33);
		this.add(lblTotalAPagar);
		
		lblTotalItens = new JLabel("Total itens: " + totalItems);
		lblTotalItens.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalItens.setFont(new Font("Roboto", Font.BOLD, 24));
		lblTotalItens.setBounds(473, 467, 198, 33);
		this.add(lblTotalItens);
		
		scrollPane.setBounds(473, 40, 453, 422);
		this.add(scrollPane);
		
		JLabel lblCodFuncionario = new JLabel("Cod. Funcionário:");
		lblCodFuncionario.setFont(new Font("Roboto", Font.BOLD, 28));
		lblCodFuncionario.setBounds(30, 40, 400, 43);
		add(lblCodFuncionario);
		
		cdFuncField = new JTextField();
		cdFuncField.setToolTipText("Digite o nome do produto...");
		cdFuncField.setHorizontalAlignment(SwingConstants.LEFT);
		cdFuncField.setFont(new Font("Roboto", Font.PLAIN, 14));
		cdFuncField.setColumns(10);
		cdFuncField.setBounds(30, 95, 400, 30);
		add(cdFuncField);
	}
	
	public void getSum(JTable table, JLabel label) {
		double sum = 0;
		if(table.getRowCount() > 0) {
			for(int i = 0; i < table.getRowCount(); i++) {
				sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
			}
			totalValue = sum;
			label.setText("Total a pagar: R$ " + String.format("%.2f", totalValue));
		} else {
			label.setText("Total a pagar: R$ " + String.format("%.2f", 0.00));
		}
	}

	public void getItems(JTable table, JLabel label) {
		int sum = 0;
		if(table.getRowCount() > 0) {
			for(int i = 0; i < table.getRowCount(); i++) {
				sum = sum + Integer.parseInt(table.getValueAt(i, 0).toString());
			}
			totalItems = sum;
			label.setText("Total itens: " + totalItems);
		} else {
			label.setText("Total itens: " + 0);
		}
	}
	
	public void errorMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
