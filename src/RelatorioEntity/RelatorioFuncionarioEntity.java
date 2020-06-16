package RelatorioEntity;

import Entity.Funcionario;

public class RelatorioFuncionarioEntity extends Funcionario {
	
	private String nomeCargo;
	
	public RelatorioFuncionarioEntity(float salario, int cdPessoa, int cdCargo, String cpf, String nome,
			String dataNascimento) {
		super(salario, cdPessoa, cdCargo, cpf, nome, dataNascimento);
		// TODO Auto-generated constructor stub
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}


	@Override
	public int getcdfuncionario() {
		// TODO Auto-generated method stub
		return super.getcdfuncionario();
	}

	@Override
	public void setCdFuncionario(int cdfuncionario) {
		// TODO Auto-generated method stub
		super.setCdFuncionario(cdfuncionario);
	}

	@Override
	public float getSalario() {
		// TODO Auto-generated method stub
		return super.getSalario();
	}

	@Override
	public int getCdPessoa() {
		// TODO Auto-generated method stub
		return super.getCdPessoa();
	}

	@Override
	public void setCdPessoa(int cdPessoa) {
		// TODO Auto-generated method stub
		super.setCdPessoa(cdPessoa);
	}

	@Override
	public void setSalario(float salario) {
		// TODO Auto-generated method stub
		super.setSalario(salario);
	}

	@Override
	public int getCdCargo() {
		// TODO Auto-generated method stub
		return super.getCdCargo();
	}

	@Override
	public void setCdCargo(int cdCargo) {
		// TODO Auto-generated method stub
		super.setCdCargo(cdCargo);
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
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}
