package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.FuncionarioDAO;
import Entity.Funcionario;

public class FuncionarioSer implements FuncionarioDAO {
	ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	Funcionario funcionario;
	
	@Override
	public void create(Funcionario funcionario) throws Exception {
		ArrayList<Funcionario> objects = new ArrayList<Funcionario>();
		
		//resgatando todos os dados que estão salvos no arquivo: Funcionarios.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Funcionarios.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Funcionario>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: Funcionarios.txt
		try {
			funcionarios.removeAll(funcionarios);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Funcionarios.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			funcionarios = objects;
			
			funcionarios.add(funcionario);
			oos.writeObject(funcionarios);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + funcionarios.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdFuncionario) throws Exception {
		ArrayList<Funcionario> objects = new ArrayList<Funcionario>();
		try {
			funcionarios.removeAll(funcionarios);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Funcionarios.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Funcionario>) ois.readObject();
			for(Funcionario funcionario : objects) {
				if(funcionario.getcdfuncionario() == cdFuncionario) {
					funcionarios.add(funcionario);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + funcionarios.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdFuncionario, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdFuncionario) throws Exception {
		ArrayList<Funcionario> objects = new ArrayList<Funcionario>();
		
		//resgatando todos os dados que estão salvos no arquivo: Funcionarios.txt
		try {
			funcionarios.removeAll(funcionarios);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Funcionarios.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Funcionario>) ois.readObject();
			for(Funcionario funcionario : objects) {
				if(funcionario.getcdfuncionario() == cdFuncionario) {
					funcionarios.remove(funcionario);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Funcionarios.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(funcionarios);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Funcionario removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Funcionario> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
