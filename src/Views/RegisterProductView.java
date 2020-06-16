package Views;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import CreateEntity.CreateEntityInDataBase;

import javax.swing.JSpinner;

import Entity.Estoque;
import Entity.Produto;
import InterfaceView.InterfaceView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegisterProductView extends JPanel implements InterfaceView{
	
	private JTextField productField;
	private JTextField brandField;
	private JTextField valueField;
	
	private JButton btnSave = new JButton("Cadastrar");

	private JSpinner quantitySpinner = new JSpinner();

	public RegisterProductView() {
		
		setSettingsView();
		setBtnListeners();

	}
	
	@Override
	public void setTable() {
		
	}
	
	public void resetForm() {
		productField.setText("");
		brandField.setText("");
		valueField.setText("");
		quantitySpinner.setValue(0);		
	}
	
	@Override
	public void setBtnListeners() {
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(brandField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione um produto");
				} 
				
				else if(Integer.parseInt(quantitySpinner.getValue().toString()) == 0) {
					JOptionPane.showMessageDialog(null, "Selecione quantidade");
				} 
				
				else {
					Produto produto = new Produto(productField.getText(), Float.parseFloat(valueField.getText()), brandField.getText());
					CreateEntityInDataBase createEntityInDataBase = new CreateEntityInDataBase();
					createEntityInDataBase.create(produto);
					
					Estoque estoque = new Estoque(produto.getcdProduto(), 2);
					createEntityInDataBase.create(estoque);

					resetForm();
				}
				
			}
		});
		
	}
	@Override
	public void setSettingsView() {
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		productField = new JTextField();
		productField.setToolTipText("Digite o nome do produto...");
		productField.setHorizontalAlignment(SwingConstants.LEFT);
		productField.setFont(new Font("Roboto", Font.PLAIN, 14));
		productField.setColumns(10);
		productField.setBounds(120, 127, 713, 30);
		add(productField);
		
		JLabel lblProduto = new JLabel("Descrição");
		lblProduto.setFont(new Font("Roboto", Font.BOLD, 18));
		lblProduto.setBounds(20, 137, 127, 20);
		add(lblProduto);
		
		JLabel lblQuantity = new JLabel("Quantidade");
		lblQuantity.setFont(new Font("Roboto", Font.BOLD, 18));
		lblQuantity.setBounds(659, 81, 111, 20);
		add(lblQuantity);
		
		quantitySpinner.setToolTipText("Selecione a quantidade do produto...");
		quantitySpinner.setFont(new Font("Roboto", Font.BOLD, 18));
		quantitySpinner.setBounds(776, 76, 57, 30);
		add(quantitySpinner);
		
		btnSave.setBounds(405, 270, 117, 25);
		add(btnSave);
		
		JLabel lblCadastroDeProdutos_1 = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos_1.setFont(new Font("Roboto", Font.BOLD, 24));
		lblCadastroDeProdutos_1.setBounds(334, 12, 259, 52);
		add(lblCadastroDeProdutos_1);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Roboto", Font.BOLD, 18));
		lblValor.setBounds(541, 184, 67, 20);
		add(lblValor);
		
		brandField = new JTextField();
		brandField.setColumns(10);
		brandField.setBounds(120, 179, 219, 30);
		add(brandField);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Roboto", Font.BOLD, 18));
		lblMarca.setBounds(20, 184, 84, 20);
		add(lblMarca);
		
		valueField = new JTextField();
		valueField.setColumns(10);
		valueField.setBounds(615, 179, 219, 30);
		add(valueField);	
	}
}



