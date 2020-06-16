package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import InterfaceView.InterfaceView;
import RelatorioEntity.RelatorioEstoqueEntity;
import RelatorioEntity.RelatorioFuncionarioVendaEntity;
import RelatorioEntity.RelatorioProdutoEntity;
import RelatorioEntity.RelatorioVendaEntity;
import Relatorios.RelatorioDeEstoque;
import Relatorios.RelatorioDeFuncionarioVenda;
import Relatorios.RelatorioDeProduto;
import Relatorios.RelatorioDeVendas;

public class RelatorioView extends JPanel implements InterfaceView{

	private static final long serialVersionUID = 1L;
	private JTable table;
	
	private JButton btnEstoque = new JButton("Estoque");
	private JButton btnVendas = new JButton("Vendas");
	private JButton btnFuncionario = new JButton("Funcionario");
	private JButton btnProduto = new JButton("Produto");

	ArrayList<RelatorioEstoqueEntity> relatorioEstoqueArrayList = new ArrayList<>();
	ArrayList<RelatorioVendaEntity> relatorioVendaArray = new ArrayList<>();
	ArrayList<RelatorioFuncionarioVendaEntity> relatorioFuncionarioArray = new ArrayList<>();
	ArrayList<RelatorioProdutoEntity> relatorioProdutoArray = new ArrayList<>();

	private JScrollPane scrollPane = new JScrollPane();
	
	private JLabel lblCadastroDeProdutos = new JLabel("Relatórios");

	public RelatorioView() {
		setTable();
		setSettingsView();
		setBtnListeners();
	}
	
	@SuppressWarnings("serial")
	@Override
	public void setTable() {
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "", ""
			}) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, Integer.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
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
		scrollPane.setViewportView(table);
	}
	
	@SuppressWarnings("serial")
	public void setEstoqueTable() {
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Produto", "Quantidade"
			}) {
			
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, Integer.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
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
		scrollPane.setViewportView(table);
	}
	
	@SuppressWarnings("serial")
	public void setVendasTable() {
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Data", "Descrição", "Quantidade"
			}) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, Integer.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
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
		scrollPane.setViewportView(table);
	}
	
	@SuppressWarnings("serial")
	public void setFuncionarioTable() {
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Funcionario", "Vendas"
			}) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
						String.class, Integer.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
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
		scrollPane.setViewportView(table);
	}
	
	@SuppressWarnings("serial")
	public void setProdutoTable() {
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produto", "Vendas"
			}) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
						String.class, Integer.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
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
		scrollPane.setViewportView(table);
	}
	
	@Override
	public void setSettingsView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Roboto", Font.BOLD, 24));
		lblCadastroDeProdutos.setBounds(338, 28, 259, 52);
		add(lblCadastroDeProdutos);
		
		scrollPane.setBounds(12, 88, 900, 300);
		add(scrollPane);
		
		btnEstoque.setBounds(12, 420, 117, 25);
		add(btnEstoque);

		btnVendas.setBounds(151, 420, 117, 25);
		add(btnVendas);

		btnFuncionario.setBounds(293, 420, 117, 25);
		add(btnFuncionario);

		btnProduto.setBounds(435, 420, 117, 25);
		add(btnProduto);
		
	}
	
	@Override
	public void setBtnListeners() {
		
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					setEstoqueTable();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					//clearRow(model);
					RelatorioDeEstoque relatorioestoque = new RelatorioDeEstoque();
					relatorioEstoqueArrayList = relatorioestoque.callRelatorioEstoque();
					feedTableEstoque(model, relatorioEstoqueArrayList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					setVendasTable();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					//clearRow(model);
					RelatorioDeVendas relatorioVenda = new RelatorioDeVendas();
					relatorioVendaArray = relatorioVenda.callRelatorioVendas();
					feedTableVendas(model, relatorioVendaArray);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					setFuncionarioTable();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					//clearRow(model);
					RelatorioDeFuncionarioVenda relatorioDeFuncionario = new RelatorioDeFuncionarioVenda();
					relatorioFuncionarioArray = relatorioDeFuncionario.callRelatorioFuncionario();
					feedTableFuncionario(model, relatorioFuncionarioArray);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					setProdutoTable();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					//clearRow(model);
					RelatorioDeProduto relatorioDeProduto = new RelatorioDeProduto();
					relatorioProdutoArray = relatorioDeProduto.callRelatorioProduto();
					feedTableProduto(model, relatorioProdutoArray);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void feedTableEstoque (DefaultTableModel model, ArrayList<RelatorioEstoqueEntity> relatorioArrayList) {
		int i = 0;
		for(i = 0; i < relatorioArrayList.size() ; i++){
			model.addRow(new Object [] {relatorioArrayList.get(i).getCdProduto(), relatorioArrayList.get(i).getNomeProduto(), relatorioArrayList.get(i).getQuantidadeProduto()});
		}
		System.out.println("Estoque list" + relatorioArrayList);
	}
	
	public void feedTableVendas (DefaultTableModel model, ArrayList<RelatorioVendaEntity> relatorioArrayList) {
		int i = 0;
		for(i = 0; i < relatorioArrayList.size() ; i++){
			model.addRow(new Object [] {relatorioArrayList.get(i).getNome(), relatorioArrayList.get(i).getData(), 
					relatorioArrayList.get(i).getDescr(), relatorioArrayList.get(i).getQuantidade()});
		}
		System.out.println("Relatorios venda" + relatorioArrayList);
	}
	
	public void feedTableFuncionario (DefaultTableModel model, ArrayList<RelatorioFuncionarioVendaEntity> relatorioArrayList) {
		int i = 0;
		for(i = 0; i < relatorioArrayList.size() ; i++){
			model.addRow(new Object [] {relatorioArrayList.get(i).getNome(),relatorioArrayList.get(i).getQuantidade()});
		}
		System.out.println("Relatorios funcionario" + relatorioArrayList);
	}
	
	public void feedTableProduto (DefaultTableModel model, ArrayList<RelatorioProdutoEntity> relatorioArrayList) {
		int i = 0;
		for(i = 0; i < relatorioArrayList.size() ; i++){
			model.addRow(new Object [] {relatorioArrayList.get(i).getNome(),relatorioArrayList.get(i).getQuantidade()});
		}
		System.out.println("Relatorios produto" + relatorioArrayList);
	}
	
	public void clearRow (DefaultTableModel model) {
		//relatorioArrayList.clear();
		
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}	
	}
}
