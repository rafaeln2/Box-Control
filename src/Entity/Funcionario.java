package Entity;

public class Funcionario extends Pessoa {

	private int cdfuncionario;
	private float salario;
	private int cdPessoa;
	private int cdCargo;
	
	public Funcionario(float salario, int cdPessoa, int cdCargo, String cpf, String nome, String dataNascimento) {
		super(cpf, nome, dataNascimento);
		this.salario = salario;
		this.cdPessoa = cdPessoa;
		this.cdCargo = cdCargo;
	}

	public int getcdfuncionario() {
		return cdfuncionario;
	}

	public void setCdFuncionario(int cdfuncionario) {
		this.cdfuncionario = cdfuncionario;
	}

	public float getSalario() {
		return salario;
	}

	public int getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getCdCargo() {
		return cdCargo;
	}

	public void setCdCargo(int cdCargo) {
		this.cdCargo = cdCargo;
	}

	@Override
	public String getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}


	@Override
	public void setCpf(String cpf) {
		// TODO Auto-generated method stub
		super.setCpf(cpf);
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}


	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		super.setNome(nome);
	}


	@Override
	public String getDataNascimento() {
		// TODO Auto-generated method stub
		return super.getDataNascimento();
	}


	@Override
	public void setDataNascimento(String dataNascimento) {
		// TODO Auto-generated method stub
		super.setDataNascimento(dataNascimento);
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}


	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Funcionario [cdfuncionario=" + cdfuncionario + ", salario=" + salario + ", cdPessoa=" + cdPessoa
				+ ", cdCargo=" + cdCargo + "]";
	}	

}
