package EntityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Entity.UsuarioSenha;
import EntityDAO.UsuarioSenhaDAO;
import GetConnection.GetConnection;

public class UsuarioSenhaImp implements UsuarioSenhaDAO {
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;
	
	@Override
	public void create(UsuarioSenha usuarioSenha) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();

		stm = conn.prepareStatement("insert into usuario_senha(usuario, senha) VALUES (?, ?)");
		stm.setString(1, usuarioSenha.getUsuario());
		stm.setString(2, usuarioSenha.getSenha());
		stm.executeUpdate();
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdus) from usuario_senha;");
		rs.next();
		int cdUsuarioSenha = rs.getInt(1);
		usuarioSenha.setcdUsuarioSenha(cdUsuarioSenha);
	}

	@Override
	public void read(int cdUsuarioSenha) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
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
	public void update(int cdUsuarioSenha, String toUpdate) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("UPDATE usuario_senha SET usuario = (?) where cdus = (?)");
		stm.setString(1, toUpdate);
		stm.setInt(2, cdUsuarioSenha);
		stm.executeUpdate();
	}

	@Override
	public void delete(int cdUsuarioSenha) throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("delete from usuario_senha where cdus = (?)");
		stm.setInt(1, cdUsuarioSenha);
		stm.executeUpdate();
	}

	@Override
	public Collection<UsuarioSenha> list() throws Exception {
		GetConnection conexao = new GetConnection ();
		Connection conn = conexao.getConnection();
		stm = conn.prepareStatement("select * from usuario_senha order by cdus");
		rs = stm.executeQuery();

		Collection<UsuarioSenha> acesso = new ArrayList<>();

		while(rs.next()) {
			int cdus = rs.getInt("CDUS");
			String usuario = rs.getString("USUARIO");
			String senha = rs.getString("SENHA");

			acesso.add(new UsuarioSenha(usuario, senha));
		}
		return acesso;
	}

}
