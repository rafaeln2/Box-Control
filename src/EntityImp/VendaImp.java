package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import Entity.Venda;
import EntityDAO.VendaDAO;
import GetConnection.GetConnection;

public class VendaImp implements VendaDAO {
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;
	
	@Override
	public void create(Venda venda) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		Date data = venda.getData(); 

		stm = conn.prepareStatement("insert into venda(data) VALUES (?)");
		stm.setDate(1, new java.sql.Date(data.getTime()));
		stm.executeUpdate();	
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdvenda) from venda;");
		rs.next();
		int cdVenda = rs.getInt(1);
		venda.setcdVenda(cdVenda);
	}

	@Override
	public void read(int cdVenda) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
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
	public void update(int cdVenda, String toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String data = toUpdate; 
		Date dataAtt = formatter.parse(data);
		
		stm = conn.prepareStatement("UPDATE venda SET data = (?) where cdvenda = (?)");
		stm.setDate(1, new java.sql.Date(dataAtt.getTime()));
		stm.setInt(2, cdVenda);
		stm.executeUpdate();		
	}

	@Override
	public void delete(int cdVenda) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("delete from venda where cdvenda = (?)");
		stm.setInt(1, cdVenda);
		stm.executeUpdate();
	}		

	@Override
	public Collection<Venda> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from venda order by cdvenda");
		rs = stm.executeQuery();

		Collection<Venda> vendas = new ArrayList<>();

		while(rs.next()) {
			Date data = rs.getDate("DATA");
			vendas.add(new Venda(data));
		}
		return vendas;
	}

}
