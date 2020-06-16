package Views;

import javax.swing.*;

import InterfaceView.InterfaceView;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemView extends JFrame implements InterfaceView{

	private static final long serialVersionUID = 1L;
	private static JLayeredPane layeredPane = new JLayeredPane();;
	private JMenuBar menuBar = new JMenuBar();
	
	private CartView cartView = new CartView();
	private RelatorioView stockView = new RelatorioView();

	private RegisterProductView registerProductView = new RegisterProductView();
	private static RegisterPersonView personView = new RegisterPersonView();
	private RegisterFuncView funcView = new RegisterFuncView();
	private FuncionarioControlView funcControllView = new FuncionarioControlView();
	
	private JMenuItem mntmFuncionrio = new JMenuItem("Funcionário");
	private JMenuItem mntmProduto = new JMenuItem("Produto");
	private JMenuItem mntmVendaDeProdutos = new JMenuItem("Venda de Produtos");
	private JMenuItem mntmEstoque = new JMenuItem("Relatórios");
	private JMenuItem mntmFuncionario = new JMenuItem("Funcionario");
	private JMenuItem mntmPessoa;

	private JMenu mnCadastro = new JMenu("Cadastro");
	private JMenu mnVendas = new JMenu("Vendas");
	private JMenu mnConsulta = new JMenu("Consulta");
	
	public SystemView() {
		setSettingsView();
		setBtnListeners();
	}
	
	@Override
	public void setTable() {
		
	}
	
	@Override
	public void setSettingsView () {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(960, 600);
		
		menuBar.setBounds(0, 0, 960, 21);
		contentPane.add(menuBar);
		
		menuBar.add(mnCadastro);
		
		mntmPessoa = new JMenuItem("Pessoa");
		mnCadastro.add(mntmPessoa);
		
		mnCadastro.add(mntmFuncionrio);
		
		mnCadastro.add(mntmProduto);
		
		menuBar.add(mnVendas);
		
		mnVendas.add(mntmVendaDeProdutos);
		
		menuBar.add(mnConsulta);
		
		mnConsulta.add(mntmEstoque);
		mnConsulta.add(mntmFuncionario);
		
		layeredPane.setBounds(10, 32, 940, 560);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
				
		layeredPane.add(cartView, "cartView");
		layeredPane.add(personView, "personView");
		layeredPane.add(registerProductView, "registerView");
		layeredPane.add(stockView, "stockView");	
		layeredPane.add(funcView, "funcView");
		
		getContentPane().add(contentPane);
	}
	
	@Override
	public void setBtnListeners () {
		mntmProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(registerProductView);
				
			}
		});		
		
		mntmVendaDeProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(cartView);				
			}
		});
		
		mntmEstoque.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(stockView);				
			}
		});
		
		mntmPessoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(personView);				
			}
		});
		
		mntmFuncionrio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(funcView);				
			}
		});
		
		mntmFuncionario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(funcControllView);				
			}
		});
	}
	
	public static void pessoaClick() {
		switchPanels(personView);			
	}
	
	public static void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();		
	}		
}
