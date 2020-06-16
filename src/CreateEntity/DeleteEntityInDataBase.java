package CreateEntity;

import EntityImp.FuncionarioImp;
import EntityImp.PessoaImp;

public class DeleteEntityInDataBase {
	
	public void deletePessoa(int cdPessoa) {
		PessoaImp pessoaImp = new PessoaImp();
		try {
			pessoaImp.delete(cdPessoa);
			System.out.println("\nPessoa deletada no banco: " + cdPessoa);
			System.out.println("\n-------------------------------------------");
		} 	
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void unactivatedFunc (int cdFuncionario) {
		FuncionarioImp funcionarioImp = new FuncionarioImp();
		try {
			funcionarioImp.changeIsActive(cdFuncionario);
			System.out.println("\nFuncionario deletada no banco: " + cdFuncionario);
			System.out.println("\n-------------------------------------------");
		} 	
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
