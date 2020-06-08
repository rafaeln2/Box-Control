package menu;

import java.util.Scanner;

import ConnectJDBC.CargoImp;
import ConnectJDBC.EnderecoImp;
import ConnectJDBC.FuncionarioImp;
import ConnectJDBC.PessoaImp;
import ConnectJDBC.UsuarioSenhaImp;
import entity.Cargo;
import entity.Endereco;
import entity.Funcionario;
import entity.Pessoa;
import entity.UsuarioSenha;

public class CreateEntityInDataBase {
	Scanner scannerMenu = new Scanner(System.in);
	int opMenu = 1 ;		

	public Pessoa createPerson() {
		System.out.println("Digite o CPF: ");
		String cpf = scannerMenu.next();
		System.out.println("Digite o nome: ");
		String nome = scannerMenu.next();
		System.out.println("Data sua data de nascimento: ");
		String dataNascimento = scannerMenu.next();
		
		Pessoa pessoaTeste = new Pessoa(cpf,nome,dataNascimento);
		PessoaImp pessoaImp = new PessoaImp();
		
		try {
			pessoaImp.create(pessoaTeste);
		} 	
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nCD da Pessoa Criada: " + pessoaTeste.getCdPessoa());
		System.out.println("\n-------------------------------------------");
		createEndereco(pessoaTeste.getCdPessoa());
		return pessoaTeste;
		}
	
	public void createEndereco (int cdPessoa) {
		System.out.println("Digite a Rua: ");
		String rua = scannerMenu.next();
		System.out.println("Digite o numero do endereço: ");
		String numeroEndereco = scannerMenu.next();
		System.out.println("Digite o bairro: ");
		String bairro = scannerMenu.next();
		System.out.println("Digite a cidade: ");
		String cidade = scannerMenu.next();
		System.out.println("Digite a unidade federal: ");
		String uf = scannerMenu.next();
		System.out.println("Data o cep: ");
		String cep = scannerMenu.next();
	
		Endereco enderecoEntity = new Endereco (rua,numeroEndereco,bairro,cidade,uf,cep,cdPessoa);
		EnderecoImp enderecoImp = new EnderecoImp();
		
		try {
			enderecoImp.create(enderecoEntity);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nCD do Endereco Criado: " + enderecoEntity.getIdEndereco());
		System.out.println("\n-------------------------------------------");
	}
	
	public void createFuncionario() {
		System.out.println("Deseja criar um cargo novo ou atribuir o funcionario a um cargo existente?\n");
		System.out.println("[1]Criar cargo novo\n[2]Atribuir a um cargo existente\n[0]Sair");
		System.out.println("\nOpção selecionada:");
		opMenu = scannerMenu.nextInt();	
		while(opMenu != 0) {
			if(opMenu == 2) {
				
				System.out.println("Digite o codigo atribuido ao cargo:\n");
				int codigoCargo = scannerMenu.nextInt();
				
				Pessoa pessoa = createPerson();
				
				System.out.println("Digite o seu salario:\n");
				float salario = scannerMenu.nextFloat();
				
				UsuarioSenha usuarioSenha =  createUsuarioSenha();
				
				Funcionario funcionario = new Funcionario(salario, pessoa.getCdPessoa(), codigoCargo, usuarioSenha.getcdUsuarioSenha(), 
						pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento());
				FuncionarioImp funcionarioImp = new FuncionarioImp();
				
				try {
					funcionarioImp.create(funcionario);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else if(opMenu == 1){
				Cargo cargo = createCargo();
				Pessoa pessoa = createPerson();
				
				System.out.println("Digite o seu salario:\n");
				float salario = scannerMenu.nextFloat();
				
				UsuarioSenha usuarioSenha =  createUsuarioSenha();
				
				Funcionario funcionario = new Funcionario(salario, pessoa.getCdPessoa(), cargo.getCdCargo(), usuarioSenha.getcdUsuarioSenha(), 
						pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento());
				FuncionarioImp funcionarioImp = new FuncionarioImp();
			}else {
				System.out.println("Opção não encontrada, tente novamente.");
				createFuncionario();
				break;
			}
		}
	}
	
	public void createProduto() {
		System.out.println("Digite o CPF: ");
		String cpf = scannerMenu.next();
		System.out.println("Digite o nome: ");
		String nome = scannerMenu.next();
		System.out.println("Data sua data de nascimento: ");
		String dataNascimento = scannerMenu.next();
		
		Pessoa pessoaTeste = new Pessoa(cpf,nome,dataNascimento);
		PessoaImp pessoaImp = new PessoaImp();
		
		try {
			pessoaImp.create(pessoaTeste);
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nCD da Pessoa Criada: " + pessoaTeste.getCdPessoa());
		System.out.println("\n-------------------------------------------");
	}
	
	public Cargo createCargo() {
		System.out.println("Digite o nome do cargo: ");
		String nomeDoCargo = scannerMenu.next();
		System.out.println("Digite o nivel de acesso do cargo: ");
		int nivelDeAcessoDoCargo = scannerMenu.nextInt();
		
		Cargo cargoTeste = new Cargo(nivelDeAcessoDoCargo,nomeDoCargo);
		CargoImp cargoImp = new CargoImp();
		try {
			cargoImp.create(cargoTeste);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Cargo CD: " + cargoTeste.getCdCargo());
		return cargoTeste;
	}
	
	public UsuarioSenha createUsuarioSenha() {
		System.out.println("Digite o usuario ");
		String usuario = scannerMenu.next();
		System.out.println("Digite a senha: ");
		String senha = scannerMenu.next();
		
		UsuarioSenha usuarioSenha = new UsuarioSenha(usuario, senha);
		UsuarioSenhaImp usuarioSenhaImpl = new UsuarioSenhaImp();
		try {
			usuarioSenhaImpl.create(usuarioSenha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Usuario e senha CD: " + usuarioSenha.getcdUsuarioSenha());
		return usuarioSenha;
	}
	
	public void fazerCompras() {

	}
}
