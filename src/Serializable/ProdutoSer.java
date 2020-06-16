package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.ProdutoDAO;
import Entity.Produto;

public class ProdutoSer implements ProdutoDAO {
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	Produto produto;
	
	@Override
	public void create(Produto produto) throws Exception {
		ArrayList<Produto> objects = new ArrayList<Produto>();
		
		//resgatando todos os dados que estão salvos no arquivo: Produtos.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Produtos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Produto>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: Produtos.txt
		try {
			produtos.removeAll(produtos);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Produtos.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			produtos = objects;
			
			produtos.add(produto);
			oos.writeObject(produtos);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + produtos.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdProduto) throws Exception {
		ArrayList<Produto> objects = new ArrayList<Produto>();
		try {
			produtos.removeAll(produtos);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Produtos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Produto>) ois.readObject();
			for(Produto produto : objects) {
				if(produto.getcdProduto() == cdProduto) {
					produtos.add(produto);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + produtos.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdProduto, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdProduto) throws Exception {
		ArrayList<Produto> objects = new ArrayList<Produto>();
		
		//resgatando todos os dados que estão salvos no arquivo: Produtos.txt
		try {
			produtos.removeAll(produtos);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Produtos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Produto>) ois.readObject();
			for(Produto produto : objects) {
				if(produto.getcdProduto() == cdProduto) {
					produtos.remove(produto);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Produtos.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(produtos);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Produto removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Produto> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
