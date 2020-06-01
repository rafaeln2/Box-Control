package Entity;

public class Funcionario {

	private Integer cdfuncionario;
	private Float salario;
	private Integer cdPessoa;
	private Integer cdCargo;
	private Integer cdUs;

	public Funcionario() {

	}
	
	
	public Funcionario(Float salario, Integer cdPessoa, Integer cdCargo, Integer cdUs) {
		super();
		this.salario = salario;
		this.cdPessoa = cdPessoa;
		this.cdCargo = cdCargo;
		this.cdUs = cdUs;
	}


	public Funcionario(Integer cdfuncionario, Float salario, Integer cdPessoa, Integer cdCargo, Integer cdUs) {
		super();
		this.cdfuncionario = cdfuncionario;
		this.salario = salario;
		this.cdPessoa = cdPessoa;
		this.cdCargo = cdCargo;
		this.cdUs = cdUs;
	}


	public Integer getcdfuncionario() {
		return cdfuncionario;
	}

	public void setcdfuncionario(Integer cdfuncionario) {
		this.cdfuncionario = cdfuncionario;
	}

	public Float getSalario() {
		return salario;
	}
	

	public Integer getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(Integer cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public Integer getCdCargo() {
		return cdCargo;
	}

	public void setCdCargo(Integer cdCargo) {
		this.cdCargo = cdCargo;
	}

	public Integer getcdUs() {
		return cdUs;
	}

	public void setcdUs(Integer cdUs) {
		this.cdUs = cdUs;
	}

	@Override
	public String toString() {
		return "Funcionario [cdfuncionario=" + cdfuncionario + ", salario=" + salario + ", cdCargo=" + cdCargo
				+ ", cdUs=" + cdUs + "]";
	}

}
