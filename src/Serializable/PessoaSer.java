package Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.PessoaDAO;
import Entity.Pessoa;

public class PessoaSer implements PessoaDAO {
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	Pessoa pessoa;
	
	@Override
	public void create(Pessoa pessoa) throws Exception {
		ArrayList<Pessoa> objects = new ArrayList<Pessoa>();
		
		//resgatando todos os dados que estão salvos no arquivo: Pessoas.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Pessoas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Pessoa>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: Pessoas.txt
		try {
			pessoas.removeAll(pessoas);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Pessoas.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			pessoas = objects;
			
			pessoas.add(pessoa);
			oos.writeObject(pessoas);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + pessoas.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdPessoa) throws Exception {
		ArrayList<Pessoa> objects = new ArrayList<Pessoa>();
		try {
			pessoas.removeAll(pessoas);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Pessoas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Pessoa>) ois.readObject();
			for(Pessoa pessoa : objects) {
				if(pessoa.getCdPessoa() == cdPessoa) {
					pessoas.add(pessoa);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + pessoas.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdPessoa, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdPessoa) throws Exception {
		ArrayList<Pessoa> objects = new ArrayList<Pessoa>();
		
		//resgatando todos os dados que estão salvos no arquivo: Pessoas.txt
		try {
			pessoas.removeAll(pessoas);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Pessoas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Pessoa>) ois.readObject();
			for(Pessoa pessoa : objects) {
				if(pessoa.getCdPessoa() == cdPessoa) {
					pessoas.remove(pessoa);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Pessoas.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(pessoas);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Pessoa removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Pessoa> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
