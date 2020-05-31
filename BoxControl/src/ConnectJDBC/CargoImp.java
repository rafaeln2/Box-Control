package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import DAO.CargoDAO;
import Entity.Cargo;

public class CargoImp implements CargoDAO {
	private Connection conn = null; 
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Cargo cargo) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		sttm = conn.createStatement();
		rs = sttm.executeQuery("select nextval('cargo_cdcargo_seq')");
		rs.next();

		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into cargo(cdcargo, nivelacesso, nm_cargo) VALUES (?, ?, ?)");

		stm.setInt(1, id);
		stm.setInt(2, cargo.getNivelAcesso());
		stm.setString(3, cargo.getNmCargo());

		cargo.setCdCargo(id);		

		stm.executeUpdate();

	}

	@Override
	public Cargo read(Integer cdCargo) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");
		stm = conn.prepareStatement("select * from cargo where cdcargo = (?)");
		stm.setInt(1, cdCargo);

		rs = stm.executeQuery();

		while(rs.next()) {
			System.out.println("cdcargo: " + rs.getInt("cdcargo") + ", ");
			System.out.println("nivelacesso: " + rs.getInt("nivelacesso")+ ", ");
			System.out.println("nm_cargo: " + rs.getString("nm_cargo")+", ");
		};
		return null;
	}

	@Override
	public void update(Integer cdCargo, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE cargo SET nm_cargo = (?) where cdcargo = (?)");

		stm.setString(1, toUpdate);
		stm.setInt(2, cdCargo);

		stm.executeUpdate();
	}

	@Override
	public void delete(Integer cdCargo) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from cargo where cdcargo = (?)");
		stm.setInt(1, cdCargo);
		stm.executeUpdate();
	}

	@Override
	public Collection<Cargo> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from cargo order by cdcargo");

		rs = stm.executeQuery();

		Collection<Cargo> cargos= new ArrayList<>();

		while(rs.next()) {
			Integer cdcargo = rs.getInt("cdcargo");
			Integer nivelacesso = rs.getInt("nivelacesso");
			String nm_cargo = rs.getString("nm_cargo");

			cargos.add(new Cargo(cdcargo, nivelacesso, nm_cargo));
		}
		return cargos;	
	}
}
