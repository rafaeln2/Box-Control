package entity;

public class UsuarioSenha {

	private Integer cdUsuarioSenha;
	private String usuario;
	private String senha;
	
	public UsuarioSenha() {
		
	}

	public UsuarioSenha(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

	public UsuarioSenha(Integer cdUsuarioSenha, String usuario, String senha) {
		super();
		this.cdUsuarioSenha = cdUsuarioSenha;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Integer getcdUsuarioSenha() {
		return cdUsuarioSenha;
	}

	public void setcdUsuarioSenha(Integer cdUsuarioSenha) {
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
