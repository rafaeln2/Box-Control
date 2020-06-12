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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Entity.EstoqueEntityView;
import EntityImp.EstoqueEntityViewImpl;
import InterfaceView.InterfaceView;

@SuppressWarnings("serial")
public class StockView extends JPanel implements InterfaceView{
	
	private JTable table;
	private JTextField textField;
	
	private JButton btnFind = new JButton("Pesquisar");
	private JButton btnRemove = new JButton("Excluir");
	private JButton btnEdit = new JButton("Editar");
	private JButton btnSave = new JButton("Salvar");
	
	private JScrollPane scrollPane = new JScrollPane();
	
	private JLabel lblCadastroDeProdutos = new JLabel("Estoque de Produtos");

	private ArrayList<EstoqueEntityView> estoqueArrayList = new ArrayList<>();

	public StockView() {
		setTable();
		setSettingsView();
		setBtnListeners();
	}
	
	@Override
	public void setTable() {
		
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
		
		btnSave.setBounds(12, 420, 117, 25);
		add(btnSave);
		
		btnEdit.setBounds(151, 420, 117, 25);
		add(btnEdit);
		
		btnRemove.setBounds(293, 420, 117, 25);
		add(btnRemove);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(471, 420, 312, 25);
		add(textField);
		
		btnFind.setBounds(795, 420, 117, 25);
		add(btnFind);
	}
	
	@Override
	public void setBtnListeners() {
		btnFind.addActionListener(new ActionListener() {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			EstoqueEntityViewImpl estoqueList = new EstoqueEntityViewImpl();

			public void actionPerformed(ActionEvent arg0) {
				try {
					clearRow(model);
					estoqueArrayList = estoqueList.list();
					feedTable(model, estoqueArrayList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public void feedTable (DefaultTableModel model, ArrayList<EstoqueEntityView> estoqueArrayList) {
		int i = 0;
		for(i = 0; i < estoqueArrayList.size() ; i++){
			model.addRow(new Object [] {estoqueArrayList.get(i).getCdProduto(), estoqueArrayList.get(i).getNomeProduto(), estoqueArrayList.get(i).getQuantidadeProduto()});
		}
		System.out.println("Estoque list" + estoqueArrayList);
	}
	
	public void clearRow (DefaultTableModel model) {
		estoqueArrayList.clear();
		
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}	
	}
}
