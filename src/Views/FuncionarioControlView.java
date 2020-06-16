package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import CreateEntity.DeleteEntityInDataBase;
import Entity.Funcionario;
import EntityImp.FuncionarioImp;
import InterfaceView.InterfaceView;
import RelatorioEntity.RelatorioEstoqueEntity;
import RelatorioEntity.RelatorioFuncionarioEntity;
import RelatorioEntity.RelatorioFuncionarioVendaEntity;
import RelatorioEntity.RelatorioProdutoEntity;
import RelatorioEntity.RelatorioVendaEntity;
import Relatorios.RelatorioDeFuncionario;

public class FuncionarioControlView extends JPanel implements InterfaceView{

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	
	private JButton btnFind = new JButton("Pesquisar");
	private JButton btnRemove = new JButton("Excluir");
	private JButton btnEdit = new JButton("Editar");
	private JButton btnSave = new JButton("Salvar");

    private int selectedCdData;
    private float selectedSalData;

	ListSelectionModel cellSelectionModel;
	
	ArrayList<RelatorioEstoqueEntity> relatorioEstoqueArrayList = new ArrayList<>();
	ArrayList<RelatorioVendaEntity> relatorioVendaArray = new ArrayList<>();
	ArrayList<RelatorioFuncionarioVendaEntity> relatorioFuncionarioArray = new ArrayList<>();
	ArrayList<RelatorioProdutoEntity> relatorioProdutoArray = new ArrayList<>();

	private JScrollPane scrollPane = new JScrollPane();
	
	private JLabel lblCadastroDeProdutos = new JLabel("Funcionarios");

	public FuncionarioControlView() {
		setTable();
		feedTableWithData();
		setSettingsView();
		setBtnListeners();

	}
	
	public int getDataOnClick () {
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		  public void valueChanged(ListSelectionEvent e) {
		    int[] selectedRow = table.getSelectedRows();
		    int[] selectedColumns = table.getSelectedColumns();
		   
		    for (int i = 0; i < selectedRow.length; i++) {
		      for (int j = 0; j < selectedColumns.length; j++) {
	    		  selectedCdData = (int) table.getValueAt(selectedRow[i], selectedColumns[j]);
		        System.out.println("Data selected: "+ selectedCdData);
		      }
		    }
		  }
		});
		return selectedCdData;
	}
	
	@SuppressWarnings("serial")
	@Override
	public void setTable() {
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Salário", "Nome Cargo", "CD Cargo"
			}) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
						String.class, String.class, Double.class, String.class, Integer.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
						false, false, true, false , false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrollPane.setViewportView(table);
	}
	
	public void feedTableWithData() {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		clearRow(model);
		cellSelectionModel = table.getSelectionModel();
		RelatorioDeFuncionario relatorioDeFuncionario = new RelatorioDeFuncionario();
		try {
			ArrayList<RelatorioFuncionarioEntity> arrayFuncionario = relatorioDeFuncionario.callRelatorioFuncionario();
			System.out.println("ArrayFuncionario" + arrayFuncionario);
			int i = 0;
			for(i = 0; i < arrayFuncionario.size() ; i++){
				model.addRow(new Object [] {arrayFuncionario.get(i).getNome(), arrayFuncionario.get(i).getCpf(), arrayFuncionario.get(i).getSalario()
						, arrayFuncionario.get(i).getNomeCargo(), arrayFuncionario.get(i).getCdCargo()});
			}
			System.out.println("Relatorios funcionario" + arrayFuncionario);	
			getDataOnClick();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void setSettingsView() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblCadastroDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProdutos.setFont(new Font("Roboto", Font.BOLD, 24));
		lblCadastroDeProdutos.setBounds(338, 28, 259, 52);
		add(lblCadastroDeProdutos);
		
		scrollPane.setBounds(12, 88, 900, 300);
		add(scrollPane);
		
		btnSave.setBounds(12, 420, 117, 25);
		add(btnSave);
		
		btnEdit.setBounds(151, 420, 117, 25);
		add(btnEdit);
		
		btnRemove.setBounds(293, 420, 117, 25);
		add(btnRemove);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(471, 420, 312, 25);
		add(textField);
		
		btnFind.setBounds(795, 420, 117, 25);
		add(btnFind);
	}
	
	@Override
	public void setBtnListeners() {
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteEntityInDataBase deleteEntityInDataBase = new DeleteEntityInDataBase();
				deleteEntityInDataBase.unactivatedFunc(selectedCdData);
				feedTableWithData();
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				feedTableWithData();
			}
		});
		
	}
	
	public void feedTableEstoque (DefaultTableModel model, ArrayList<RelatorioEstoqueEntity> relatorioArrayList) {
		int i = 0;
		for(i = 0; i < relatorioArrayList.size() ; i++){
			model.addRow(new Object [] {relatorioArrayList.get(i).getCdProduto(), relatorioArrayList.get(i).getNomeProduto(), relatorioArrayList.get(i).getQuantidadeProduto()});
		}
		System.out.println("Estoque list" + relatorioArrayList);
	}
	
	public void clearRow (DefaultTableModel model) {
		//relatorioArrayList.clear();
		
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}	
	}
}
