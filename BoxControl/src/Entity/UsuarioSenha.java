package Entity;

public class UsuarioSenha {

	private Integer idUsuarioSenha;
	private String usuario;
	private String senha;
	
	public UsuarioSenha() {
		
	}

	public Integer getIdUsuarioSenha() {
		return idUsuarioSenha;
	}

	public void setIdUsuarioSenha(Integer idUsuarioSenha) {
		this.idUsuarioSenha = idUsuarioSenha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioSenha [idUsuarioSenha=" + idUsuarioSenha + ", usuario=" + usuario + ", senha=" + senha + "]";
	}
	
	
}
