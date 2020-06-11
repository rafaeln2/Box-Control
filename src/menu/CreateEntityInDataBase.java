package menu;

import java.util.Scanner;

import ClearBuffer.ClearBuffer;
import ConnectJDBC.CargoImp;
import ConnectJDBC.EnderecoImp;
import ConnectJDBC.EstoqueImp;
import ConnectJDBC.FuncionarioImp;
import ConnectJDBC.PessoaImp;
import ConnectJDBC.ProdutoImp;
import ConnectJDBC.TelefoneImp;
import ConnectJDBC.UsuarioSenhaImp;
import entity.Cargo;
import entity.Endereco;
import entity.Estoque;
import entity.Funcionario;
import entity.Pessoa;
import entity.Produto;
import entity.Telefone;
import entity.UsuarioSenha;

public class CreateEntityInDataBase {
	Scanner scannerMenu = new Scanner(System.in);
	ClearBuffer clearBuffer = new ClearBuffer();

	int opMenu = 1 ;		

	public Pessoa createPerson(Pessoa pessoa) {
		PessoaImp pessoaImp = new PessoaImp();
		
		try {
			pessoaImp.create(pessoa);
			System.out.println("\nPessoa criada no banco: " + pessoa.toString());
			System.out.println("\n-------------------------------------------");
			
		} 	
		catch (Exception e) {
			e.printStackTrace();
		}
		return pessoa;
		}
	
	public void createEndereco (Endereco endereco, int cdPessoa) {
		EnderecoImp enderecoImp = new EnderecoImp();
		endereco.setCdPessoa(cdPessoa);
		try {
			enderecoImp.create(endereco);
			System.out.println("\nEndereco criado no banco: " + endereco.toString());
			System.out.println("\n-------------------------------------------");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void createPhone(Pessoa pessoa) {
		
		System.out.println("Tipo do telefone: ");
		String tipoTelefone = scannerMenu.nextLine();
		
		System.out.println("Digite o DDD: ");
		String dddTelefone = scannerMenu.next();
		clearBuffer.clearBuffer(scannerMenu);

		System.out.println("Digite o numero do telefone: ");
		String numeroTelefone = scannerMenu.nextLine();
		
		Telefone telefone = new Telefone(tipoTelefone, dddTelefone, numeroTelefone, pessoa.getCdPessoa());
		TelefoneImp telefoneImp = new TelefoneImp();
		
		try {
			telefoneImp.create(telefone);
			System.out.println("\nTelefone criado no banco: " + telefone.toString());
			System.out.println("\n-------------------------------------------");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createFuncionario() {
		System.out.println("Deseja criar um cargo novo ou atribuir o funcionario a um cargo existente?\n");
		System.out.println("[1]Criar cargo novo\n[2]Atribuir a um cargo existente\n[0]Sair");
		System.out.println("\nOpção selecionada:");
		opMenu = scannerMenu.nextInt();	
		
		while(opMenu != 0) {
			if(opMenu == 2) {
				
				int codigoCargo = scannerMenu.nextInt();
				System.out.println("Digite o codigo atribuido ao cargo:\n");

				//Pessoa pessoa = createPerson();
				
				float salario = scannerMenu.nextFloat();
				System.out.println("Digite o seu salario:\n");

				UsuarioSenha usuarioSenha =  createUsuarioSenha();
				
				//Funcionario funcionario = new Funcionario(salario, pessoa.getCdPessoa(), codigoCargo, usuarioSenha.getcdUsuarioSenha(), 
						//pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento());
				//FuncionarioImp funcionarioImp = new FuncionarioImp();
				
				try {
					//funcionarioImp.create(funcionario);
					//System.out.println("\nFuncionario criado no banco: " + funcionario.toString());
					System.out.println("\n-------------------------------------------");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else if(opMenu == 1){
				Cargo cargo = createCargo();
				//Pessoa pessoa = createPerson();
				
				float salario = scannerMenu.nextFloat();
				System.out.println("Digite o seu salario:\n");

				UsuarioSenha usuarioSenha =  createUsuarioSenha();
				
				//Funcionario funcionario = new Funcionario(salario, pessoa.getCdPessoa(), cargo.getCdCargo(), usuarioSenha.getcdUsuarioSenha(), 
						//pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento());
				//FuncionarioImp funcionarioImp = new FuncionarioImp();
				
				try {
					//funcionarioImp.create(funcionario);
					//System.out.println("\nFuncionario criado no banco: " + funcionario.toString());
					System.out.println("\n-------------------------------------------");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else {
				System.out.println("Opção não encontrada, tente novamente.");
				createFuncionario();
				break;
			}
		}
	}
	
	public void createProduto(Produto produto) {
		ProdutoImp produtoImp = new ProdutoImp();
		
		try {
			produtoImp.create(produto);
		} 	
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Porduto criado" + produto.toString());
	}
	
	
	public Cargo createCargo() {
		
		System.out.println("Digite o nome do cargo: ");
		String nomeDoCargo = scannerMenu.nextLine();
		
		clearBuffer.clearBuffer(scannerMenu);
		
		System.out.println("Digite o nivel de acesso do cargo: ");
		int nivelDeAcessoDoCargo = scannerMenu.nextInt();
		
		Cargo cargoTeste = new Cargo(nivelDeAcessoDoCargo, nomeDoCargo);
		CargoImp cargoImp = new CargoImp();
		
		try {
			cargoImp.create(cargoTeste);
			System.out.println("Cargo CD: " + cargoTeste.getCdCargo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cargoTeste;
	}
	
	public Estoque createEstoque(Estoque estoque) {
		EstoqueImp estoqueImp = new EstoqueImp();
		
		try {
			estoqueImp.create(estoque);
			System.out.println("Estoque criado: " + estoque.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return estoque;
	}
	
	public UsuarioSenha createUsuarioSenha() {
		String usuario = scannerMenu.next();
		System.out.println("Digite o usuario ");

		String senha = scannerMenu.next();
		System.out.println("Digite a senha: ");
		
		UsuarioSenha usuarioSenha = new UsuarioSenha(usuario, senha);
		UsuarioSenhaImp usuarioSenhaImpl = new UsuarioSenhaImp();
		
		try {
			usuarioSenhaImpl.create(usuarioSenha);
			System.out.println("Usuario e senha CD: " + usuarioSenha.getcdUsuarioSenha());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarioSenha;
	}
	
	public void fazerCompras() {

	}
}
