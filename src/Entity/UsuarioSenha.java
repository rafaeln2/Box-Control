package Entity;

public class UsuarioSenha {

	private int cdUsuarioSenha = 0;
	private String usuario;
	private String senha;
	
	public UsuarioSenha(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

	public int getcdUsuarioSenha() {
		return cdUsuarioSenha;
	}

	public void setcdUsuarioSenha(int cdUsuarioSenha) {
		this.cdUsuarioSenha = cdUsuarioSenha;
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
		return "UsuarioSenha [cdUsuarioSenha=" + cdUsuarioSenha + ", usuario=" + usuario + ", senha=" + senha + "]";
	}
	
	
}
