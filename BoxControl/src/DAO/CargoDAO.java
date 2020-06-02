package dao;
import java.util.Collection;

import entity.Cargo;


public interface CargoDAO {

		public void create(Cargo cargo) throws Exception;
		
		public void read(Integer cdCargo)throws Exception;

		public void update(Integer cdCargo, String toUpdate)throws Exception;
		
		public void delete(Integer cdCargo)throws Exception;
		
		Collection<Cargo> list()throws Exception;
		
	}
