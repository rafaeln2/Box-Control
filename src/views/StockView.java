package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ConnectJDBC.EstoqueEntityViewImpl;
import entity.EstoqueEntityView;

public class StockView extends JPanel {
	private JTable table;
	private JTextField textField;
	ArrayList<EstoqueEntityView> estoqueArrayList = new ArrayList<>();

	public StockView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblCadastroDeProdutos = new JLabel("Estoque de Produtos");
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Roboto", Font.BOLD, 24));
		lblCadastroDeProdutos.setBounds(338, 28, 259, 52);
		add(lblCadastroDeProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 88, 900, 300);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C�digo", "Produto", "Quantidade"
			}) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, Integer.class
				};
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
	
		JButton btnSave = new JButton("Salvar");
		btnSave.setBounds(12, 420, 117, 25);
		add(btnSave);
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.setBounds(151, 420, 117, 25);
		add(btnEdit);
		
		JButton btnRemove = new JButton("Excluir");
		btnRemove.setBounds(293, 420, 117, 25);
		add(btnRemove);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(471, 420, 312, 25);
		add(textField);
		
		JButton btnFind = new JButton("Pesquisar");
		btnFind.setBounds(795, 420, 117, 25);
		add(btnFind);
		
		btnFind.addActionListener(new ActionListener() {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			EstoqueEntityViewImpl estoqueList = new EstoqueEntityViewImpl();

			public void actionPerformed(ActionEvent arg0) {
				try {
					estoqueArrayList = estoqueList.list();
					int i = 0;
					for(i = 0; i < estoqueArrayList.size() ; i++){
						model.addRow(new Object [] {estoqueArrayList.get(i).getCdProduto(),estoqueArrayList.get(i).getNomeProduto(),estoqueArrayList.get(i).getQuantidadeProduto()});
					}
					System.out.println("estoque list" + estoqueArrayList);
					System.out.println("For executado true");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
