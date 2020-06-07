package ConnectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import GetConnection.GetConnection;
import dao.UsuarioSenhaDAO;
import entity.UsuarioSenha;

public class UsuarioSenhaImp implements UsuarioSenhaDAO {
	private Connection conn = null; 
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;
	
	@Override
	public void create(UsuarioSenha usuarioSenha) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		sttm = conn.createStatement();

		rs = sttm.executeQuery("select nextval('usuario_senha_cdus_seq')");
		rs.next();
		Integer id = rs.getInt(1);

		stm = conn.prepareStatement("insert into usuario_senha(cdus, usuario, senha) VALUES (?, ?, ?)");
		stm.setInt(1, id);
		stm.setString(2, usuarioSenha.getUsuario());
		stm.setString(3, usuarioSenha.getSenha());
		stm.executeUpdate();
	}

	@Override
	public void read(Integer cdUsuarioSenha) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from usuario_senha where cdus = (?) order by cdus");
		stm.setInt(1, cdUsuarioSenha);

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
	public void update(Integer cdUsuarioSenha, String toUpdate) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("UPDATE usuario_senha SET usuario = (?) where cdus = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdUsuarioSenha);
		stm.executeUpdate();
	}

	@Override
	public void delete(Integer cdUsuarioSenha) throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("delete from usuario_senha where cdus = (?)");
		stm.setInt(1, cdUsuarioSenha);
		stm.executeUpdate();
	}

	@Override
	public Collection<UsuarioSenha> list() throws Exception {
		conn = DriverManager.getConnection("jdbc:postgresql://localhost/aulapostgres", "admin", "admin");

		stm = conn.prepareStatement("select * from usuario_senha order by cdus");
		rs = stm.executeQuery();

		Collection<UsuarioSenha> acesso = new ArrayList<>();

		while(rs.next()) {
			Integer cdus = rs.getInt("CDUS");
			String usuario = rs.getString("USUARIO");
			String senha = rs.getString("SENHA");

			acesso.add(new UsuarioSenha(cdus, usuario, senha));
		}
		return acesso;
	}

}
