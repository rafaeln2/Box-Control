package Serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.*;
import Entity.*;

public class UsuarioSenhaSer implements UsuarioSenhaDAO {
	ArrayList<UsuarioSenha> usuarioSenhas = new ArrayList<UsuarioSenha>();
	UsuarioSenha usuarioSenha;
	
	@Override
	public void create(UsuarioSenha usuarioSenha) throws Exception {
		ArrayList<UsuarioSenha> objects = new ArrayList<UsuarioSenha>();
		
		//resgatando todos os dados que estão salvos no arquivo: UsuarioSenhas.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/UsuarioSenhas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<UsuarioSenha>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: UsuarioSenhas.txt
		try {
			usuarioSenhas.removeAll(usuarioSenhas);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/UsuarioSenhas.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			usuarioSenhas = objects;
			
			usuarioSenhas.add(usuarioSenha);
			oos.writeObject(usuarioSenhas);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + usuarioSenhas.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdUsuarioSenha) throws Exception {
		ArrayList<UsuarioSenha> objects = new ArrayList<UsuarioSenha>();
		try {
			usuarioSenhas.removeAll(usuarioSenhas);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/UsuarioSenhas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<UsuarioSenha>) ois.readObject();
			for(UsuarioSenha usuarioSenha : objects) {
				if(usuarioSenha.getcdUsuarioSenha() == cdUsuarioSenha) {
					usuarioSenhas.add(usuarioSenha);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + usuarioSenhas.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdUsuarioSenha, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdUsuarioSenha) throws Exception {
		ArrayList<UsuarioSenha> objects = new ArrayList<UsuarioSenha>();
		
		//resgatando todos os dados que estão salvos no arquivo: UsuarioSenhas.txt
		try {
			usuarioSenhas.removeAll(usuarioSenhas);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/UsuarioSenhas.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<UsuarioSenha>) ois.readObject();
			for(UsuarioSenha usuarioSenha : objects) {
				if(usuarioSenha.getcdUsuarioSenha() == cdUsuarioSenha) {
					usuarioSenhas.remove(usuarioSenha);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/UsuarioSenhas.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(usuarioSenhas);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("UsuarioSenha removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<UsuarioSenha> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
