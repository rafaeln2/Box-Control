package CreateEntity;

import java.util.Scanner;

import Entity.Cargo;
import Entity.Carrinho;
import Entity.Endereco;
import Entity.Estoque;
import Entity.Funcionario;
import Entity.Pessoa;
import Entity.Produto;
import Entity.Telefone;
import Entity.Venda;
import EntityImp.CargoImp;
import EntityImp.CarrinhoImp;
import EntityImp.EnderecoImp;
import EntityImp.EstoqueImp;
import EntityImp.FuncionarioImp;
import EntityImp.PessoaImp;
import EntityImp.ProdutoImp;
import EntityImp.TelefoneImp;
import EntityImp.VendaImp;

public class CreateEntityInDataBase {
	Scanner scannerMenu = new Scanner(System.in);

	public void create(Pessoa pessoa) {
		PessoaImp pessoaImp = new PessoaImp();
		try {
			pessoaImp.create(pessoa);
			System.out.println("\nPessoa criada no banco: " + pessoa.toString());
			System.out.println("\n-------------------------------------------");
			
		} 	
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void create (Endereco endereco, int cdPessoa) {
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
	
	public void create (Venda venda) {
		VendaImp vendaImp = new VendaImp();
		try {
			vendaImp.create(venda);
			System.out.println("\nVenda criado no banco: " + venda.toString());
			System.out.println("\n-------------------------------------------");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void create (Carrinho carrinho) {
		CarrinhoImp carrinhoImp = new CarrinhoImp();
		try {
			carrinhoImp.create(carrinho);
			System.out.println("\nCarrinho criado no banco: " + carrinho.toString());
			System.out.println("\n-------------------------------------------");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void create(Telefone telefone) {
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
	
	public void create(Cargo cargo) {
		CargoImp cargoImp = new CargoImp();
		try {
			cargoImp.create(cargo);
			System.out.println("\nCargo criado no banco: " + cargo.toString());
			System.out.println("\n-------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void create(Funcionario funcionario) {
		FuncionarioImp funcionarioImp = new FuncionarioImp();
		System.out.println("Entrou");
		try {
			funcionarioImp.create(funcionario);
			System.out.println("\nFuncionario criado no banco: " + funcionario.toString());
			System.out.println("\n-------------------------------------------");
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void create(Produto produto) {
		ProdutoImp produtoImp = new ProdutoImp();
		try {
			produtoImp.create(produto);
			System.out.println("\nProduto criado no banco: " + produto.toString());
			System.out.println("\n-------------------------------------------");
		} 	
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Porduto criado" + produto.toString());
	}
	
	public void create (Estoque estoque) {
		EstoqueImp estoqueImp = new EstoqueImp();
		try {
			estoqueImp.create(estoque);
			System.out.println("\nEstoque criado no banco: " + estoque.toString());
			System.out.println("\n-------------------------------------------");
		} 	
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Porduto criado" + estoque.toString());
	}
}
