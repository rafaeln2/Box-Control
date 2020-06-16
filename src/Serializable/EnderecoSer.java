package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.EnderecoDAO;
import Entity.Endereco;

public class EnderecoSer implements EnderecoDAO {
	ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	Endereco endereco;
	
	@Override
	public void create(Endereco endereco) throws Exception {
		ArrayList<Endereco> objects = new ArrayList<Endereco>();
		
		//resgatando todos os dados que estão salvos no arquivo: Enderecos.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Enderecos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Endereco>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: Enderecos.txt
		try {
			enderecos.removeAll(enderecos);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Enderecos.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			enderecos = objects;
			
			enderecos.add(endereco);
			oos.writeObject(enderecos);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + enderecos.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdEndereco) throws Exception {
		ArrayList<Endereco> objects = new ArrayList<Endereco>();
		try {
			enderecos.removeAll(enderecos);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Enderecos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Endereco>) ois.readObject();
			for(Endereco endereco : objects) {
				if(endereco.getCdEndereco() == cdEndereco) {
					enderecos.add(endereco);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + enderecos.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdEndereco, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdEndereco) throws Exception {
		ArrayList<Endereco> objects = new ArrayList<Endereco>();
		
		//resgatando todos os dados que estão salvos no arquivo: Enderecos.txt
		try {
			enderecos.removeAll(enderecos);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Enderecos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Endereco>) ois.readObject();
			for(Endereco endereco : objects) {
				if(endereco.getCdEndereco() == cdEndereco) {
					enderecos.remove(endereco);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Enderecos.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(enderecos);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Endereco removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Endereco> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
