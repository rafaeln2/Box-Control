package Entity;

public class Funcionario {

	private Integer idFuncionario;
	private Double salario;
	private Integer cdCargo;
	private Integer idUsuarioSenha;

	private Funcionario() {

	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getCdCargo() {
		return cdCargo;
	}

	public void setCdCargo(Integer cdCargo) {
		this.cdCargo = cdCargo;
	}

	public Integer getIdUsuarioSenha() {
		return idUsuarioSenha;
	}

	public void setIdUsuarioSenha(Integer idUsuarioSenha) {
		this.idUsuarioSenha = idUsuarioSenha;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", salario=" + salario + ", cdCargo=" + cdCargo
				+ ", idUsuarioSenha=" + idUsuarioSenha + "]";
	}


}
