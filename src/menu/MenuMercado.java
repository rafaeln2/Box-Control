package menu;

import ConnectJDBC.PessoaImp;
import entity.Pessoa;
import java.util.Scanner;

public class MenuMercado {
	Scanner scannerMenu = new Scanner(System.in);

	public void callMenu() {
		int opMenu = 1 ;		
		while(opMenu != 0) {
			
			System.out.println("Olá, bem vindo ao nosso mercado, escolha uma opção !\n");
			System.out.println("[1]Criar Pessoa\n[2]Criar funcionario\n[3]Cadastrar produto\n[4]Fazer compra\n[0]Sair");
			System.out.println("\nOpção selecionada:");
			opMenu = scannerMenu.nextInt();
						
			switch(opMenu) {
				case 1:
					callCreatePerson();
					break;
				case 2:
					callCreateFuncionario();
					break;
				case 3:
					callCreateProduto();
					break;
				case 4:
					callFazerCompras();
					break;
				case 0:
					System.out.println("Muito obrigado por utilizar nossos serviços, volte sempre !");
					break;
			}	
		}
	}
	
	public void callCreatePerson() {
		int op = 1;
		CreateEntityInDataBase createEntityInDataBase = new CreateEntityInDataBase();
		while(op != 0) {
			createEntityInDataBase.createPerson();	
			System.out.println("\nDeseja Criar outra pessoa?\n\n[1]Sim\n[0]Não");
			System.out.println("\nOpção selecionada:");
			op = scannerMenu.nextInt();
		}
	}
	
	public void callCreateFuncionario() {
		int op = 1;
		CreateEntityInDataBase createEntityInDataBase = new CreateEntityInDataBase();

		while(op != 0) {
			createEntityInDataBase.createFuncionario();	
			System.out.println("\nDeseja Criar outro funcionario?\n\n[1]Sim\n[0]Não");
			System.out.println("\nOpção selecionada:");
			op = scannerMenu.nextInt();
		}
	}
	
	public void callCreateProduto() {
		int op = 1;
		CreateEntityInDataBase createEntityInDataBase = new CreateEntityInDataBase();

		while(op != 0) {
			createEntityInDataBase.createProduto();	
			System.out.println("\nDeseja Criar outro produto?\n\n[1]Sim\n[0]Não");
			System.out.println("\nOpção selecionada:");
			op = scannerMenu.nextInt();
		}
	}
	
	public void callFazerCompras() {
		int op = 1;
		CreateEntityInDataBase createEntityInDataBase = new CreateEntityInDataBase();

		while(op != 0) {
			createEntityInDataBase.fazerCompras();	
			System.out.println("\nDeseja continuar fazendo compras?\n\n[1]Sim\n[0]Não");
			System.out.println("\nOpção selecionada:");
			op = scannerMenu.nextInt();
		}
	}
}
