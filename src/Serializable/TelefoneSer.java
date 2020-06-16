package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.TelefoneDAO;
import Entity.Telefone;

public class TelefoneSer implements TelefoneDAO {
	ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	Telefone telefone;
	
	@Override
	public void create(Telefone telefone) throws Exception {
		ArrayList<Telefone> objects = new ArrayList<Telefone>();
		
		//resgatando todos os dados que estão salvos no arquivo: Telefones.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Telefones.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Telefone>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: Telefones.txt
		try {
			telefones.removeAll(telefones);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Telefones.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			telefones = objects;
			
			telefones.add(telefone);
			oos.writeObject(telefones);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + telefones.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdTelefone) throws Exception {
		ArrayList<Telefone> objects = new ArrayList<Telefone>();
		try {
			telefones.removeAll(telefones);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Telefones.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Telefone>) ois.readObject();
			for(Telefone telefone : objects) {
				if(telefone.getCdTelefone() == cdTelefone) {
					telefones.add(telefone);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + telefones.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdTelefone, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdTelefone) throws Exception {
		ArrayList<Telefone> objects = new ArrayList<Telefone>();
		
		//resgatando todos os dados que estão salvos no arquivo: Telefones.txt
		try {
			telefones.removeAll(telefones);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Telefones.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Telefone>) ois.readObject();
			for(Telefone telefone : objects) {
				if(telefone.getCdTelefone() == cdTelefone) {
					telefones.remove(telefone);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Telefones.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(telefones);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Telefone removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Telefone> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
