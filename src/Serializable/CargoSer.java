package Serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import EntityDAO.CargoDAO;
import Entity.Cargo;

public class CargoSer implements CargoDAO {
	ArrayList<Cargo> cargos = new ArrayList<Cargo>();
	Cargo cargo;
	
	@Override
	public void create(Cargo cargo) throws Exception {
		ArrayList<Cargo> objects = new ArrayList<Cargo>();
		
		//resgatando todos os dados que estão salvos no arquivo: Cargos.txt
		try {
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Cargos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Cargo>) ois.readObject();
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//recolocando os dados, incluindo o dado recebido como parâmetro, no arquivo: Cargos.txt
		try {
			cargos.removeAll(cargos);
			
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Cargos.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			cargos = objects;
			
			cargos.add(cargo);
			oos.writeObject(cargos);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Feito!\nQuantidade de arquivos: " + cargos.size());
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cdCargo) throws Exception {
		ArrayList<Cargo> objects = new ArrayList<Cargo>();
		try {
			cargos.removeAll(cargos);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Cargos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Cargo>) ois.readObject();
			for(Cargo cargo : objects) {
				if(cargo.getCdCargo() == cdCargo) {
					cargos.add(cargo);
				}
			}
			//concatenar de acordo com o front-end para exibir os dados na tela
			System.out.println("Resultado do read: " + cargos.toString());
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void update(int cdCargo, String toUpdate) throws Exception {
		
	}

	@Override
	public void delete(int cdCargo) throws Exception {
		ArrayList<Cargo> objects = new ArrayList<Cargo>();
		
		//resgatando todos os dados que estão salvos no arquivo: Cargos.txt
		try {
			cargos.removeAll(cargos);
			//variaveis de leitura
			FileInputStream fin = new FileInputStream("/Users/vitorcosta/Documents/APS/Cargos.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			objects = (ArrayList<Cargo>) ois.readObject();
			for(Cargo cargo : objects) {
				if(cargo.getCdCargo() == cdCargo) {
					cargos.remove(cargo);
				}
			}
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			//variaveis de escrita
			FileOutputStream fout = new FileOutputStream("/Users/vitorcosta/Documents/APS/Cargos.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.writeObject(cargos);
			oos.close();
			
			//exibir mensagem de êxito
			System.out.println("Cargo removido com sucesso!");
		} catch(Exception e) {
			//exibir mensagem de falha
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Cargo> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
