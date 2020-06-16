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
import Entity.Cargo;
import Entity.Funcionario;
import Entity.Pessoa;
import EntityImp.CargoImp;
import InterfaceView.InterfaceView;

@SuppressWarnings("serial")
public class RegisterFuncView extends JPanel implements InterfaceView{
	
	private JButton btnRegister = new JButton("Cadastrar");

	private static JTextField cargoField;
	private static JTextField salarioField;
	private static JTextField nivelField;
	

	public RegisterFuncView() {
		setSettingsView();
		setBtnListeners();
	}
	
	@Override
	public void setTable() {
		
	}
	
	@Override
	public void setBtnListeners() {
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nivelField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Há campos em branco, complete todos campos.");
				} else {
					SystemView.pessoaClick();
					RegisterPersonView.setCreatingFuncionario(true);
				}
			}
		});
	}
	
	public static void resetForm () {
		cargoField.setText("");
		salarioField.setText("");
		nivelField.setText("");
	}
	
	public static void createFuncionario(Pessoa pessoa) {
		CreateEntityInDataBase createEntityInDataBase = new CreateEntityInDataBase();

		CargoImp cargoImp = new CargoImp();
		String cargoCd = cargoImp.readCdByCargo(cargoField.getText());
		System.out.println("Teste 0");

		if(cargoCd != "") {
			System.out.println("Teste 1");
			Funcionario funcionario = new Funcionario(Float.parseFloat(salarioField.getText()), pessoa.getCdPessoa(), Integer.parseInt(cargoCd), pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento());
			System.out.println("Teste 2" + funcionario);
			try {
				createEntityInDataBase.create(funcionario);
				System.out.println("Cargo já existente no banco: "+ cargoCd);
				System.out.println("Funcionario criado no banco"+funcionario);
				resetForm();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			Cargo cargo = new Cargo(Integer.parseInt(nivelField.getText()), cargoField.getText());
			try {
				createEntityInDataBase.create(cargo);
				System.out.println("Cargo criado no banco: "+ cargo);
				Funcionario funcionario = new Funcionario(Float.parseFloat(salarioField.getText()), pessoa.getCdPessoa(), cargo.getCdCargo(), pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento());
				createEntityInDataBase.create(funcionario);
				System.out.println("Funcionario criado no banco: "+ funcionario);
				resetForm();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void setSettingsView(){
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