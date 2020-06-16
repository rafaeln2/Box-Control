package EntityDAO;
import java.util.Collection;

import Entity.Cargo;


public interface CargoDAO {

		public void create(Cargo cargo) throws Exception;
		
		public void read(int cdCargo)throws Exception;

		public void update(int cdCargo, String toUpdate)throws Exception;
		
		public void delete(int cdCargo)throws Exception;
		
		Collection<Cargo> list()throws Exception;
		
	}
