package views;

import javax.swing.*;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemView extends JFrame {

	private JLayeredPane layeredPane = new JLayeredPane();;
	private JMenuBar menuBar = new JMenuBar();
	
	private RegisterProductView registerProductView = new RegisterProductView();
	private CartView cartView = new CartView();
	private StockView stockView = new StockView();
	private RegisterPersonView personView = new RegisterPersonView();
	
	
	public SystemView() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(960, 600);
		
		menuBar.setBounds(0, 0, 960, 21);
		contentPane.add(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmPessoa = new JMenuItem("Pessoa");
		mnCadastro.add(mntmPessoa);
		
		JMenuItem mntmFuncionrio = new JMenuItem("Funcionário");
		mnCadastro.add(mntmFuncionrio);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mnCadastro.add(mntmProduto);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmVendaDeProdutos = new JMenuItem("Venda de Produtos");
		mnVendas.add(mntmVendaDeProdutos);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmEstoque = new JMenuItem("Estoque");
		mnConsulta.add(mntmEstoque);
		
		layeredPane.setBounds(10, 32, 940, 560);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
				
		layeredPane.add(personView, "personView");
		layeredPane.add(registerProductView, "registerView");
		layeredPane.add(cartView, "cartView");
		layeredPane.add(stockView, "stockView");	
		
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
		
		getContentPane().add(contentPane);
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();		
	}		
}
