package DAO;
import Entity.Cargo;

import java.util.Collection;


public interface CargoDAO {

		public void createEntity(Cargo cargo) throws Exception;
		
		public void updateEntity(Cargo cargo)throws Exception;
		
		public Cargo findEntity(Cargo cargo)throws Exception;
		
		public void dropEntity(Cargo cargo)throws Exception;
		
		Collection<Cargo> list()throws Exception;
		
	}
