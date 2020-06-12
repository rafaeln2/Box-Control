package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterFuncView extends JPanel {
	
private JTextField cargoField;
	
	JButton btnRegister = new JButton("Cadastrar");
	private JTextField salarioField;
	private JTextField nivelField;
	
	private RegisterPersonView personView = new RegisterPersonView();
	
	public RegisterFuncView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		cargoField = new JTextField();
		cargoField.setToolTipText("Digite nome...");
		cargoField.setHorizontalAlignment(SwingConstants.LEFT);
		cargoField.setFont(new Font("Roboto", Font.PLAIN, 14));
		cargoField.setColumns(10);
		cargoField.setBounds(159, 90, 702, 30);
		add(cargoField);
		
		JLabel lblProduto = new JLabel("Cargo");
		lblProduto.setFont(new Font("Roboto", Font.BOLD, 18));
		lblProduto.setBounds(47, 95, 127, 20);
		add(lblProduto);
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nivelField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Há campos em branco, complete todos campos.");
				} else {
					
					//aqui entra a logica para gravar no banco
					SystemView.pessoaClick();			
				}
			}
		});
		btnRegister.setBounds(745, 490, 117, 25);
		add(btnRegister);
		
		JLabel lblCadastroDeProdutos_1 = new JLabel("Cadastro de Funcionário");
		lblCadastroDeProdutos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos_1.setFont(new Font("Roboto", Font.BOLD, 24));
		lblCadastroDeProdutos_1.setBounds(272, 13, 379, 52);
		add(lblCadastroDeProdutos_1);
		
		salarioField = new JTextField();
		salarioField.setToolTipText("Digite sua data de nascimento...");
		salarioField.setColumns(10);
		salarioField.setBounds(159, 144, 249, 30);
		add(salarioField);
		
		JLabel lblMarca = new JLabel("Salário");
		lblMarca.setFont(new Font("Roboto", Font.BOLD, 18));
		lblMarca.setBounds(48, 149, 127, 20);
		add(lblMarca);
		
		JLabel lblUnidade = new JLabel("Nivel de acesso");
		lblUnidade.setFont(new Font("Roboto", Font.BOLD, 18));
		lblUnidade.setBounds(426, 149, 165, 20);
		add(lblUnidade);
		
		nivelField = new JTextField();
		nivelField.setToolTipText("Digite CPF...");
		nivelField.setColumns(10);
		nivelField.setBounds(590, 144, 271, 30);
		add(nivelField);
	}	

}
