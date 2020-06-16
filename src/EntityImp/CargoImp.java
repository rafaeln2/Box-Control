package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Entity.Cargo;
import EntityDAO.CargoDAO;
import GetConnection.GetConnection;

public class CargoImp implements CargoDAO {

	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;
	
	@Override
	public void create(Cargo cargo) throws Exception {
	
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		
		stm = conn.prepareStatement("insert into cargo(nivelacesso, nm_cargo) VALUES (?, ?)");
		stm.setInt(1, cargo.getNivelAcesso());
		stm.setString(2, cargo.getNmCargo());
		stm.executeUpdate();
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdcargo) from cargo;");
		rs.next();
		int cdCargo = rs.getInt(1);
		cargo.setCdCargo(cdCargo);
		
	}
	
	public String readCdByCargo (String nomeCargo) {
		GetConnection conexao = new GetConnection ();
		String retornoCargoCd = "";
		Connection conn;
		try {
			conn = conexao.getConnection();
			stm = conn.prepareStatement("SELECT CDCARGO FROM CARGO WHERE NM_CARGO = (?)");
			stm.setString(1, nomeCargo);

			rs = stm.executeQuery();
			
			while(rs.next()) {
				retornoCargoCd = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return retornoCargoCd;		
	}
	
	@Override
	public void read(int cdCargo) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();		
		stm = conn.prepareStatement("select * from cargo c JOIN funcionario f ON c.cdcargo = f.cdcargo where f.cdcargo = (?)");
		stm.setInt(1, cdCargo);

		rs = stm.executeQuery();

		ResultSetMetaData rsmd = rs.getMetaData();

		int columnsNumber = rsmd.getColumnCount();

		while(rs.next()) {
			for(int i = 1; i <= columnsNumber; i++) {
				System.out.printf("{%s: %s} %n", rsmd.getColumnName(i), rs.getString(i));
			}
		}
	}
			@Override
			public void update(int cdCargo, String toUpdate) throws Exception {
				GetConnection conexao = new GetConnection ();
				Connection conn = conexao.getConnection();
				stm = conn.prepareStatement("UPDATE cargo SET nm_cargo = (?) where cdcargo = (?)");

				stm.setString(1, toUpdate);
				stm.setInt(2, cdCargo);

				stm.executeUpdate();
			}

			@Override
			public void delete(int cdCargo) throws Exception {
				GetConnection conexao = new GetConnection ();
				Connection conn = conexao.getConnection();
				stm = conn.prepareStatement("delete from cargo where cdcargo = (?)");
				stm.setInt(1, cdCargo);
				stm.executeUpdate();
			}

			@Override
			public Collection<Cargo> list() throws Exception {
				GetConnection conexao = new GetConnection ();
				Connection conn = conexao.getConnection();
				stm = conn.prepareStatement("select * from cargo order by cdcargo");

				rs = stm.executeQuery();

				Collection<Cargo> cargos= new ArrayList<>();

				while(rs.next()) {
					int nivelacesso = rs.getInt("nivelacesso");
					String nm_cargo = rs.getString("nm_cargo");

					cargos.add(new Cargo(nivelacesso, nm_cargo));
				}
				return cargos;	
			}
		}
