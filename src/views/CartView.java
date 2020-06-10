package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.CartModel;

public class CartView extends JPanel {
	
	private JTable table;
	
	private JLabel lblPrice;
	private JLabel lblQuantity;
	private JLabel lblTotalAPagar;
	private JLabel lblTotalItens;
	
	private JTextField productField;
	private JTextField priceField;
	
	private JButton btnAddCart;
	private JButton btnRemoverItem;
	private JButton btnFinalizar;
	
	private JSpinner quantitySpinner;
	
	private CartModel cartModel = new CartModel();	
	
	public CartView() {
		this.setBackground(Color.WHITE);
		this.setFont(new Font("Roboto", Font.PLAIN, 12));
		this.setBounds(100, 100, 960, 540);
		setLayout(null);
		
		lblPrice = new JLabel("Preço:");
		lblPrice.setFont(new Font("Roboto", Font.BOLD, 32));
		lblPrice.setBounds(30, 229, 95, 43);
		this.add(lblPrice);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setFont(new Font("Roboto", Font.BOLD, 32));
		lblProduto.setBounds(30, 138, 127, 43);
		this.add(lblProduto);
		
		productField = new JTextField();
		productField.setToolTipText("Digite o nome do produto...");
		productField.setHorizontalAlignment(SwingConstants.LEFT);
		productField.setFont(new Font("Roboto", Font.PLAIN, 14));
		productField.setBounds(30, 193, 400, 30);
		this.add(productField);
		productField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setToolTipText("Digite o valor do produto...");
		priceField.setFont(new Font("Roboto", Font.PLAIN, 14));
		priceField.setColumns(10);
		priceField.setBounds(30, 276, 400, 30);
		this.add(priceField);
		
		lblQuantity = new JLabel("Quantidade:");
		lblQuantity.setFont(new Font("Roboto", Font.BOLD, 32));
		lblQuantity.setBounds(30, 324, 179, 43);
		this.add(lblQuantity);
		
		quantitySpinner = new JSpinner();
		quantitySpinner.setToolTipText("Selecione a quantidade do produto...");
		quantitySpinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		quantitySpinner.setFont(new Font("Roboto", Font.BOLD, 18));
		quantitySpinner.setBounds(373, 324, 57, 43);
		this.add(quantitySpinner);
		
		// BOTÂO ADICIONAR CARRINHO
		btnAddCart = new JButton("Adicionar ao carrinho");
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(productField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione um produto");
				} else if(Integer.parseInt(quantitySpinner.getValue().toString()) == 0) {
					JOptionPane.showMessageDialog(null, "Selecione quantidade");
				} else {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					double price = Double.parseDouble(priceField.getText()) * Double.parseDouble(quantitySpinner.getValue().toString());
					model.addRow(new Object [] {quantitySpinner.getValue(), productField.getText(), price});	
					cartModel.getSum(table, lblTotalAPagar);
					cartModel.getItems(table, lblTotalItens);
					productField.setText("");
					priceField.setText("");
					quantitySpinner.setValue(0);								
				}
			}
		});
		btnAddCart.setBounds(30, 380, 400, 40);
		this.add(btnAddCart);
		
		//BOTÂO REMOVER ITEM
		btnRemoverItem = new JButton("Remover Item");
		btnRemoverItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.removeRow(table.getSelectedRow());	
					cartModel.getSum(table, lblTotalAPagar);
					cartModel.getItems(table, lblTotalItens);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um item na tabela");
				}
			}
		});
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
		
		lblTotalAPagar = new JLabel("Total a pagar: R$ " + String.format("%.2f", cartModel.getTotalValue()));
		lblTotalAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAPagar.setFont(new Font("Roboto", Font.BOLD, 24));
		lblTotalAPagar.setBounds(640, 467, 286, 33);
		this.add(lblTotalAPagar);
		
		lblTotalItens = new JLabel("Total itens: "+ cartModel.getTotalItems());
		lblTotalItens.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalItens.setFont(new Font("Roboto", Font.BOLD, 24));
		lblTotalItens.setBounds(473, 467, 198, 33);
		this.add(lblTotalItens);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(473, 40, 453, 422);
		this.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Courier New", Font.PLAIN, 12));
		table.setBackground(new Color(255, 255, 153));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Qtde", "Produto", "Pre\u00E7o"
			}
		) {
			private static final long serialVersionUID = 8400256977919727622L;
			
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/media/guilherme/HD-EG5/HD Guilherme/_FACUL C-COMPUTACAO/3SEM_APS/APS/bin/download.png"));
		label.setBounds(93, -16, 272, 185);
		this.add(label);
	}
	
	public void errorMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
