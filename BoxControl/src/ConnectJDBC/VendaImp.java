package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import dao.VendaDAO;
import entity.Telefone;
import entity.Venda;

public class VendaImp implements VendaDAO {
	private Connection conn = null; 
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Venda venda) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String data = venda.getData(); 
		Date dataAtt = formatter.parse(data);

		sttm = conn.createStatement();

		rs = sttm.executeQuery("select nextval('pessoa_cdpessoa_seq')");
		rs.next();
		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into pessoa(cdvenda, data) VALUES (?, ?)");
		stm.setInt(1, id);
		stm.setDate(2, new java.sql.Date(dataAtt.getTime()));
		stm.executeUpdate();		
	}

	@Override
	public void read(Integer cdVenda) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from venda where cdvenda = (?) order by cdvenda");
		stm.setInt(1, cdVenda);

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
	public void update(Integer cdVenda, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String data = toUpdate; 
		Date dataAtt = formatter.parse(data);
		
		stm = conn.prepareStatement("UPDATE venda SET data = (?) where cdvenda = (?)");
		stm.setDate(1, new java.sql.Date(dataAtt.getTime()));
		stm.setInt(2, cdVenda);
		stm.executeUpdate();		
	}

	@Override
	public void delete(Integer cdVenda) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from venda where cdvenda = (?)");
		stm.setInt(1, cdVenda);
		stm.executeUpdate();
	}		

	@Override
	public Collection<Venda> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from venda order by cdvenda");
		rs = stm.executeQuery();

		Collection<Venda> vendas = new ArrayList<>();

		while(rs.next()) {
			Integer cdVenda = rs.getInt("CDVENDA");
			String data = rs.getString("DATA");
			
			vendas.add(new Venda(cdVenda, data));
		}
		return vendas;
	}

}
