package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.EstoqueDAO;
import Entity.Estoque;

public class EstoqueSer implements EstoqueDAO {
	ArrayList<Estoque> estoques = new ArrayList<Estoque>();
	Estoque estoque;
	
	@Override
	public void create(Estoque estoque) throws Exception {
		ArrayList<Estoque> objects = new ArrayList<Estoque>();
		
		//resgatando todos os dados que estão salvos no arquivo: Estoque.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Estoque.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Estoque>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: Estoque.txt
		try {
			estoques.removeAll(estoques);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Estoque.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			estoques = objects;
			
			estoques.add(estoque);
			oos.writeObject(estoques);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + estoques.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdEstoque) throws Exception {
		ArrayList<Estoque> objects = new ArrayList<Estoque>();
		try {
			estoques.removeAll(estoques);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Estoque.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Estoque>) ois.readObject();
			for(Estoque estoque : objects) {
				if(estoque.getCdEstoque() == cdEstoque) {
					estoques.add(estoque);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + estoques.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdEstoque, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdEstoque) throws Exception {
		ArrayList<Estoque> objects = new ArrayList<Estoque>();
		
		//resgatando todos os dados que estão salvos no arquivo: Estoque.txt
		try {
			estoques.removeAll(estoques);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Estoque.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Estoque>) ois.readObject();
			for(Estoque estoque : objects) {
				if(estoque.getCdEstoque() == cdEstoque) {
					estoques.remove(estoque);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Estoque.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(estoques);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Estoque removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Estoque> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
