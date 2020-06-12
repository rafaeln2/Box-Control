package Serializable;

import Entity.*;

public class SerializableController {
	private CargoSer cargoSer = new CargoSer();
	private CarrinhoSer carrinhoSer = new CarrinhoSer();
	private EnderecoSer enderecoSer = new EnderecoSer();
	private EstoqueSer estoqueSer = new EstoqueSer();
	private FuncionarioSer funcionarioSer = new FuncionarioSer();
	private PessoaSer pessoaSer = new PessoaSer();
	private ProdutoSer produtoSer = new ProdutoSer();
	private TelefoneSer telefoneSer = new TelefoneSer();
	private UsuarioSenhaSer usuarioSenhaSer = new UsuarioSenhaSer();
	private VendaSer vendaSer = new VendaSer();
	
	//creates
	public void createCargo(Cargo cargo) throws Exception {
		cargoSer.create(cargo);
	}
	
	public void createCarrinho(Carrinho carrinho) throws Exception {
		carrinhoSer.create(carrinho);
	}
	
	public void createEndereco(Endereco endereco) throws Exception {
		enderecoSer.create(endereco);
	}
	
	public void createEstoque(Estoque estoque) throws Exception {
		estoqueSer.create(estoque);
	}
	
	public void createFuncionario(Funcionario funcionario) throws Exception {
		funcionarioSer.create(funcionario);
	}
	
	public void createPessoa(Pessoa pessoa) throws Exception {
		pessoaSer.create(pessoa);
	}
	
	public void createProduto(Produto produto) throws Exception {
		produtoSer.create(produto);
	}
	
	public void createTelefone(Telefone telefone) throws Exception {
		telefoneSer.create(telefone);
	}
	
	public void createUsuarioSenha(UsuarioSenha usuarioSenha) throws Exception {
		usuarioSenhaSer.create(usuarioSenha);
	}
	
	public void createVenda(Venda venda) throws Exception {
		vendaSer.create(venda);
	}
	
	//reads
	public void readCargo(int cdCargo) throws Exception {
		cargoSer.read(cdCargo);
	}
	
	public void readCarrinho(int cdCarrinho) throws Exception {
		carrinhoSer.read(cdCarrinho);
	}
	
	public void readEndereco(int cdEndereco) throws Exception {
		enderecoSer.read(cdEndereco);
	}
	
	public void readEstoque(int cdEstoque) throws Exception {
		estoqueSer.read(cdEstoque);
	}
	
	public void readFuncionario(int cdFuncionario) throws Exception {
		funcionarioSer.read(cdFuncionario);
	}
	
	public void readPessoa(int cdPessoa) throws Exception {
		pessoaSer.read(cdPessoa);
	}
	
	public void readProduto(int cdProduto) throws Exception {
		produtoSer.read(cdProduto);
	}
	
	public void readTelefone(int cdTelefone) throws Exception {
		telefoneSer.read(cdTelefone);
	}
	
	public void readUsuarioSenha(int cdUsuarioSenha) throws Exception {
		usuarioSenhaSer.read(cdUsuarioSenha);
	}
	
	public void readVenda(int cdVenda) throws Exception {
		vendaSer.read(cdVenda);
	}
	
	//deletes
	public void deleteCargo(int cdCargo) throws Exception {
		cargoSer.delete(cdCargo);
	}
	
	public void deleteCarrinho(int cdCarrinho) throws Exception {
		carrinhoSer.delete(cdCarrinho);
	}
	
	public void deleteEndereco(int cdEndereco) throws Exception {
		enderecoSer.delete(cdEndereco);
	}
	
	public void deleteEstoque(int cdEstoque) throws Exception {
		estoqueSer.delete(cdEstoque);
	}
	
	public void deleteFuncionario(int cdFuncionario) throws Exception {
		funcionarioSer.delete(cdFuncionario);
	}
	
	public void deletePessoa(int cdPessoa) throws Exception {
		pessoaSer.delete(cdPessoa);
	}
	
	public void deleteProduto(int cdProduto) throws Exception {
		produtoSer.delete(cdProduto);
	}
	
	public void deleteTelefone(int cdTelefone) throws Exception {
		telefoneSer.delete(cdTelefone);
	}
	
	public void deleteUsuarioSenha(int cdUsuarioSenha) throws Exception {
		usuarioSenhaSer.delete(cdUsuarioSenha);
	}
	
	public void deleteVenda(int cdVenda) throws Exception {
		vendaSer.delete(cdVenda);
	}
}
