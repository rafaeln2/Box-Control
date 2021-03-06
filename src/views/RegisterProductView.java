package views;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterProductView extends JPanel{
	private JTextField productField;
	private JTextField codField;
	
	JButton btnSave = new JButton("Cadastrar");
	private JTextField brandField;
	private JTextField valueField;
	private JTextField unitField;
	
	public RegisterProductView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		productField = new JTextField();
		productField.setToolTipText("Digite o nome do produto...");
		productField.setHorizontalAlignment(SwingConstants.LEFT);
		productField.setFont(new Font("Roboto", Font.PLAIN, 14));
		productField.setColumns(10);
		productField.setBounds(148, 127, 713, 30);
		add(productField);
		
		JLabel lblProduto = new JLabel("Descrição");
		lblProduto.setFont(new Font("Roboto", Font.BOLD, 18));
		lblProduto.setBounds(48, 137, 127, 20);
		add(lblProduto);
		
		JLabel lblQuantity = new JLabel("Quantidade");
		lblQuantity.setFont(new Font("Roboto", Font.BOLD, 18));
		lblQuantity.setBounds(687, 81, 111, 20);
		add(lblQuantity);
		
		JSpinner quantitySpinner = new JSpinner();
		quantitySpinner.setToolTipText("Selecione a quantidade do produto...");
		quantitySpinner.setFont(new Font("Roboto", Font.BOLD, 18));
		quantitySpinner.setBounds(804, 76, 57, 30);
		add(quantitySpinner);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Roboto", Font.BOLD, 18));
		lblCodigo.setBounds(48, 81, 84, 20);
		add(lblCodigo);
		
		codField = new JTextField();
		codField.setBounds(148, 76, 219, 30);
		add(codField);
		codField.setColumns(10);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(codField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione um produto");
				} else if(Integer.parseInt(quantitySpinner.getValue().toString()) == 0) {
					JOptionPane.showMessageDialog(null, "Selecione quantidade");
				} else {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.addRow(new Object [] {codField.getText(), productField.getText(), quantitySpinner.getValue()});
					codField.setText("");
					productField.setText("");
					quantitySpinner.setValue(0);								
				}
			}
		});
		btnSave.setBounds(745, 490, 117, 25);
		add(btnSave);
		
		JLabel lblCadastroDeProdutos_1 = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos_1.setFont(new Font("Roboto", Font.BOLD, 24));
		lblCadastroDeProdutos_1.setBounds(334, 12, 259, 52);
		add(lblCadastroDeProdutos_1);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Roboto", Font.BOLD, 18));
		lblValor.setBounds(569, 184, 67, 20);
		add(lblValor);
		
		brandField = new JTextField();
		brandField.setColumns(10);
		brandField.setBounds(148, 179, 219, 30);
		add(brandField);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Roboto", Font.BOLD, 18));
		lblMarca.setBounds(48, 184, 84, 20);
		add(lblMarca);
		
		valueField = new JTextField();
		valueField.setColumns(10);
		valueField.setBounds(643, 179, 219, 30);
		add(valueField);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setFont(new Font("Roboto", Font.BOLD, 18));
		lblUnidade.setBounds(430, 81, 84, 20);
		add(lblUnidade);
		
		unitField = new JTextField();
		unitField.setColumns(10);
		unitField.setBounds(510, 76, 75, 30);
		add(unitField);
	}
}



