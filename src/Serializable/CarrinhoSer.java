package Serializable;

import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.CarrinhoDAO;
import Entity.Carrinho;
import Entity.Carrinho;

public class CarrinhoSer implements CarrinhoDAO {
	ArrayList<Carrinho> Carrinhos = new ArrayList<Carrinho>();
	Carrinho carrinho;
	
	@Override
	public void create(Carrinho carrinho) throws Exception {
		ArrayList<Carrinho> objects = new ArrayList<Carrinho>();
		
		//resgatando todos os dados que estão salvos no arquivo: Carrinhos.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Carrinhos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Carrinho>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: Carrinhos.txt
		try {
			Carrinhos.removeAll(Carrinhos);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Carrinhos.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			Carrinhos = objects;
			
			Carrinhos.add(carrinho);
			oos.writeObject(Carrinhos);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + Carrinhos.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdCarrinho) throws Exception {
		ArrayList<Carrinho> objects = new ArrayList<Carrinho>();
		try {
			Carrinhos.removeAll(Carrinhos);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Carrinhos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Carrinho>) ois.readObject();
			for(Carrinho carrinho : objects) {
				if(carrinho.getCdcarrinho() == cdCarrinho) {
					Carrinhos.add(carrinho);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + Carrinhos.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdCarrinho, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdCarrinho) throws Exception {
		ArrayList<Carrinho> objects = new ArrayList<Carrinho>();
		
		//resgatando todos os dados que estão salvos no arquivo: Carrinhos.txt
		try {
			Carrinhos.removeAll(Carrinhos);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Carrinhos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Carrinho>) ois.readObject();
			for(Carrinho carrinho : objects) {
				if(carrinho.getCdcarrinho() == cdCarrinho) {
					Carrinhos.remove(carrinho);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Carrinhos.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(Carrinhos);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Carrinho removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Carrinho> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
