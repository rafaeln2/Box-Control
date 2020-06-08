package menu;

import ConnectJDBC.PessoaImp;
import entity.Pessoa;
import java.util.Scanner;

public class MenuMercado {
	public void callMenu() {
		int opMenu = 1 ;
		Scanner scannerMenu = new Scanner(System.in);
		while(opMenu != 0) {
			System.out.println("Escolha a Opçao:");
			System.out.println("1-Criar Pessoa\n2- Criar funcionario\n3-Cadastrar produto\n4-Fazer compra\n0-Sair");
			opMenu = scannerMenu.nextInt();
			int op = 1;
			switch(opMenu) {
			case 1:
				while(op != 0) {
					System.out.println("Digite o CPF,Nome e data de nascimento a seguir");
					
					String cpf = scannerMenu.next();
					String nome = scannerMenu.next();
					String dataN = scannerMenu.next();
					
					Pessoa pessoaTeste = new Pessoa(cpf,nome,dataN);
					PessoaImp pessoaImp = new PessoaImp();
					
					try {
						pessoaImp.create(pessoaTeste);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("CD da Pessoa Criada: " + pessoaTeste.getCdPessoa());
					System.out.println("Deseja Criar outra pessoa? 0- nao, 1-sim");
					
					op = scannerMenu.nextInt();
				}
				break;
				
			case 2:
			
			}	
		}
	}
}
