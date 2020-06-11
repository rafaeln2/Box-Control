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
import views.SystemView;

public class Main {

	public static void main(String[] args) {
		
		//codigo para instanciar as views...
		SystemView systemView = new SystemView();
		systemView.setVisible(true);		
		
		GetConnection getConnection = new GetConnection();
		MenuMercado menuMercado = new MenuMercado();
		
		try {
			getConnection.getConnection();
			System.out.println("Connected to database !");
			menuMercado.callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
