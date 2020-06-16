package Views;

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

import CreateEntity.CreateEntityInDataBase;
import Entity.Endereco;
import Entity.Pessoa;
import Entity.Telefone;
import InterfaceView.InterfaceView;

@SuppressWarnings("serial")
public class RegisterPersonView extends JPanel implements InterfaceView{
	
	JButton btnRegister = new JButton("Cadastrar");
	
	private JTextField nameField;
	private JTextField birthField;
	private JTextField cpfField;
	private JTextField streetField;
	private JTextField numField;
	private JTextField neighborhoodField;
	private JTextField cityField;
	private JTextField countryField;
	private JTextField cepField;
	private JTextField phoneField;
	private JTextField dddField;
	private JTextField phoneTypeField;
	private static boolean creatingFuncionario;
	
	public RegisterPersonView() {
		setBtnListeners();
		setSettingsView();
	}
	
	@Override
	public void setTable() {
		
	}
	
	@Override
	public void setBtnListeners () {
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cpfField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Existem campos em branco, favor completar");
				} else {		
					Pessoa pessoa = new Pessoa(cpfField.getText(),nameField.getText(),birthField.getText());
					
					CreateEntityInDataBase createEntityInDataBase = new CreateEntityInDataBase();
					createEntityInDataBase.create(pessoa);
					
					Endereco endereco = new Endereco(streetField.getText(), numField.getText(), neighborhoodField.getText(), 
							cityField.getText(), countryField.getText(), cepField.getText(), pessoa.getCdPessoa());
					createEntityInDataBase.create(endereco, pessoa.getCdPessoa());
					
					Telefone telefone = new Telefone(phoneTypeField.getText(), dddField.getText(), phoneField.getText(), pessoa.getCdPessoa());
					createEntityInDataBase.create(telefone);
					
					if (RegisterPersonView.creatingFuncionario) {
						System.out.println("Pessoa"+pessoa);
						RegisterFuncView.createFuncionario(pessoa);
					}
					
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso !");
					resetForm();
				}
			}
		});
	}
	
	public void resetForm () {
		nameField.setText("");
		birthField.setText("");
		cpfField.setText("");
		streetField.setText("");
		numField.setText("");
		neighborhoodField.setText("");
		cityField.setText("");
		countryField.setText("");
		cepField.setText("");
		phoneField.setText("");
		dddField.setText("");
		phoneTypeField.setText("");
	}
	
	@Override
	public void setSettingsView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		nameField = new JTextField();
		nameField.setToolTipText("Digite nome...");
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		nameField.setFont(new Font("Roboto", Font.PLAIN, 14));
		nameField.setColumns(10);
		nameField.setBounds(159, 90, 702, 30);
		add(nameField);
		
		JLabel lblProduto = new JLabel("Nome");
		lblProduto.setFont(new Font("Roboto", Font.BOLD, 18));
		lblProduto.setBounds(47, 95, 127, 20);
		add(lblProduto);
		
		btnRegister.setBounds(410, 480, 117, 25);
		add(btnRegister);
		
		JLabel lblCadastroDeProdutos_1 = new JLabel("Cadastro de Pessoa");
		lblCadastroDeProdutos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos_1.setFont(new Font("Roboto", Font.BOLD, 24));
		lblCadastroDeProdutos_1.setBounds(339, 12, 259, 52);
		add(lblCadastroDeProdutos_1);
		
		birthField = new JTextField();
		birthField.setToolTipText("Digite sua data de nascimento...");
		birthField.setColumns(10);
		birthField.setBounds(159, 144, 219, 30);
		add(birthField);
		
		JLabel lblMarca = new JLabel("Nascimento");
		lblMarca.setFont(new Font("Roboto", Font.BOLD, 18));
		lblMarca.setBounds(48, 149, 127, 20);
		add(lblMarca);
		
		JLabel lblUnidade = new JLabel("CPF");
		lblUnidade.setFont(new Font("Roboto", Font.BOLD, 18));
		lblUnidade.setBounds(426, 149, 47, 20);
		add(lblUnidade);
		
		cpfField = new JTextField();
		cpfField.setToolTipText("Digite CPF...");
		cpfField.setColumns(10);
		cpfField.setBounds(510, 144, 351, 30);
		add(cpfField);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Roboto", Font.BOLD, 18));
		lblRua.setBounds(47, 210, 127, 20);
		add(lblRua);
		
		streetField = new JTextField();
		streetField.setToolTipText("Digite sua Rua...");
		streetField.setHorizontalAlignment(SwingConstants.LEFT);
		streetField.setFont(new Font("Roboto", Font.PLAIN, 14));
		streetField.setColumns(10);
		streetField.setBounds(159, 205, 702, 30);
		add(streetField);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNumero.setBounds(48, 264, 127, 20);
		add(lblNumero);
		
		numField = new JTextField();
		numField.setToolTipText("Digite numero da rua ...");
		numField.setColumns(10);
		numField.setBounds(159, 259, 219, 30);
		add(numField);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Roboto", Font.BOLD, 18));
		lblBairro.setBounds(426, 264, 69, 20);
		add(lblBairro);
		
		neighborhoodField = new JTextField();
		neighborhoodField.setToolTipText("Digite seu Bairro...");
		neighborhoodField.setColumns(10);
		neighborhoodField.setBounds(510, 259, 351, 30);
		add(neighborhoodField);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Roboto", Font.BOLD, 18));
		lblCidade.setBounds(47, 320, 127, 20);
		add(lblCidade);
		
		cityField = new JTextField();
		cityField.setToolTipText("Digite sua Cidade...");
		cityField.setColumns(10);
		cityField.setBounds(159, 315, 219, 30);
		add(cityField);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Roboto", Font.BOLD, 18));
		lblEstado.setBounds(426, 320, 69, 20);
		add(lblEstado);
		
		countryField = new JTextField();
		countryField.setToolTipText("Digite seu estado...");
		countryField.setColumns(10);
		countryField.setBounds(509, 315, 351, 30);
		add(countryField);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Roboto", Font.BOLD, 18));
		lblCep.setBounds(47, 376, 127, 20);
		add(lblCep);
		
		cepField = new JTextField();
		cepField.setToolTipText("Digite seu CEP...");
		cepField.setColumns(10);
		cepField.setBounds(159, 371, 219, 30);
		add(cepField);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Roboto", Font.BOLD, 18));
		lblTelefone.setBounds(426, 433, 90, 20);
		add(lblTelefone);
		
		phoneField = new JTextField();
		phoneField.setToolTipText("Digite CPF...");
		phoneField.setColumns(10);
		phoneField.setBounds(509, 428, 351, 30);
		add(phoneField);
		
		JLabel lblDdd = new JLabel("DDD");
		lblDdd.setFont(new Font("Roboto", Font.BOLD, 18));
		lblDdd.setBounds(47, 433, 60, 20);
		add(lblDdd);
		
		dddField = new JTextField();
		dddField.setToolTipText("Digite sua data de nascimento...");
		dddField.setColumns(10);
		dddField.setBounds(159, 428, 60, 30);
		add(dddField);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Roboto", Font.BOLD, 18));
		lblTipo.setBounds(237, 433, 90, 20);
		add(lblTipo);
		
		phoneTypeField = new JTextField();
		phoneTypeField.setToolTipText("Digite sua data de nascimento...");
		phoneTypeField.setColumns(10);
		phoneTypeField.setBounds(292, 428, 116, 30);
		add(phoneTypeField);
	}

	public static boolean isCreatingFuncionario() {
		return creatingFuncionario;
	}

	public static void setCreatingFuncionario(boolean creatingFuncionario) {
		RegisterPersonView.creatingFuncionario = creatingFuncionario;
	}
}
