package Main;

import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;
import ConnectJDBC.CargoImp;
import ConnectJDBC.FuncionarioImp;
import ConnectJDBC.PessoaImp;
import GetConnection.GetConnection;
import entity.Cargo;
import entity.Funcionario;
import entity.Pessoa;
import entity.UsuarioSenha;
import menu.MenuMercado;

public class Main {

	public static void main(String[] args) {
		GetConnection getConnection = new GetConnection();
		MenuMercado menuMercado = new MenuMercado();
		menuMercado.callMenu();
		
		try {
			getConnection.getConnection();
			System.out.println("Connected to database !");
			
			/*
			 * Criando a entidade Pessoa
			 * e inserindo dentro do banco de dados.
			 */
			
			Pessoa pessoaTeste = new Pessoa("7288827","Bernardo","25/10/1999");
			PessoaImp pessoaImp = new PessoaImp();
			pessoaImp.create(pessoaTeste);
			System.out.println("Pessoa CD: " + pessoaTeste.getCdPessoa());

			/*
			 * Criando entidade Cargo
			 * e inserindo no banco de dados.
			 */
			
			Cargo cargoTeste = new Cargo(45,"DBA");
			CargoImp cargoImp = new CargoImp();
			cargoImp.create(cargoTeste);
			System.out.println("Cargo CD: " + cargoTeste.getCdCargo());
			
			
			/*
			 * Criando entidade Usuario Senha
			 * e inserindo no banco de dados.
			 */
			
			//UsuarioSenha usuarioSenha = new UsuarioSenha("teste", "1234");
			
			/*
			 * Criando entidade Funcionario
			 * e inserindo no banco de dados.
			 */		
			/*
			Funcionario funcionarioTeste = new Funcionario(2800, pessoaTeste.getCdPessoa(), cargoTeste.getCdCargo(), usuarioSenha.getcdUsuarioSenha(), pessoaTeste.getCpf(), pessoaTeste.getNome(), pessoaTeste.getDataNascimento());
			FuncionarioImp funcionarioImp = new FuncionarioImp();
			funcionarioImp.create(funcionarioTeste);
			funcionarioImp.list();
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
