package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.VendaDAO;
import Entity.Venda;

public class VendaSer implements VendaDAO {
	ArrayList<Venda> vendas = new ArrayList<Venda>();
	Venda venda;
	
	@Override
	public void create(Venda venda) throws Exception {
		ArrayList<Venda> objects = new ArrayList<Venda>();
		
		//resgatando todos os dados que estão salvos no arquivo: Vendas.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Vendas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Venda>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: Vendas.txt
		try {
			vendas.removeAll(vendas);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Vendas.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			vendas = objects;
			
			vendas.add(venda);
			oos.writeObject(vendas);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + vendas.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdVenda) throws Exception {
		ArrayList<Venda> objects = new ArrayList<Venda>();
		try {
			vendas.removeAll(vendas);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Vendas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Venda>) ois.readObject();
			for(Venda venda : objects) {
				if(venda.getcdVenda() == cdVenda) {
					vendas.add(venda);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + vendas.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdVenda, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdVenda) throws Exception {
		ArrayList<Venda> objects = new ArrayList<Venda>();
		
		//resgatando todos os dados que estão salvos no arquivo: Vendas.txt
		try {
			vendas.removeAll(vendas);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Vendas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Venda>) ois.readObject();
			for(Venda venda : objects) {
				if(venda.getcdVenda() == cdVenda) {
					vendas.remove(venda);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Vendas.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(vendas);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Venda removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Venda> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
