package com.jeco.ui.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ovino;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.TableOvino;
import com.jeco.ui.butons.BtCancelar;
import com.jeco.ui.butons.BtEditar;
import com.jeco.ui.butons.BtRemover;
import com.jeco.ui.butons.BtView;
import com.jeco.ui.controler.EnumNomeBotoes;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class JanelaOvinosCadastrados extends PanelDefault {

		
	private JPanel painelPesquisa;
	private JTable tbDados;
	private TableOvino tableModel;
	private javax.swing.JScrollPane scroll;
	private ActionOvelha actionListen;
	private JRadioButton bRaca;
	private ButtonGroup grupoBotaoPesquisa;
	private JRadioButton bsCodigo;
	private JButton bFechar;
	private JButton bRemover;
	private JButton bEditar;
	private JButton bVisualizar;
	private JTextField ctBusca;
	private JButton bPesquisar;
	private JPanel painelBusca;
	private JButton bTodos;
	private JECOFacade facade;

	public JanelaOvinosCadastrados() {
		super("OVINOS CADASTRADOS",EnumNomeBotoes.VISUALIZAR_OVINOS_CLOSE);
		actionListen = new ActionOvelha();
		facade = new JECOFacade();			
		initGUI();
		atualizarTable();
		run();		
	}	
	
	
	private void initGUI() {
		try {
			this.setSize(new java.awt.Dimension(631, 334));
			this.setLayout(null);			
			{
				painelPesquisa = new JPanel();
				this.add(painelPesquisa);				
				painelPesquisa.setBounds(12, 6, 481, 322);
				painelPesquisa.setBorder(BorderFactory.createTitledBorder(""));
				painelPesquisa.setLayout(null);
				{
					grupoBotaoPesquisa = new ButtonGroup();
				}					
				{	
					scroll = new JScrollPane();					
					painelPesquisa.add(scroll);
					scroll.setBounds(13, 99, 458, 207);
					tableModel = new TableOvino();							
					tbDados = new JTable(tableModel);
					tbDados.addMouseListener(actionListen);
					tbDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
			       
					painelPesquisa.add(tbDados);
					tbDados.setBounds(7, 47, 411, 191);
					scroll.setViewportView(tbDados);
				}
				{
					{
						painelBusca = new JPanel();
						painelPesquisa.add(painelBusca);
						painelBusca.setBounds(13, 4, 323, 89);
						painelBusca.setLayout(null);
						painelBusca.setBorder(BorderFactory.createTitledBorder(null, "Perquisar Por:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
						{
							ctBusca = new JTextField();
							painelBusca.add(ctBusca);
							ctBusca.setBounds(20, 49, 286, 28);
							ctBusca.addKeyListener(actionListen);
						}
						{
							bsCodigo = new JRadioButton();
							painelBusca.add(bsCodigo);
							bsCodigo.setText("Codigo");
							bsCodigo.setBounds(20, 24, 71, 18);
							bsCodigo.setSelected(true);
							grupoBotaoPesquisa.add(bsCodigo);
							bsCodigo.setFont(new java.awt.Font("Segoe UI",1,12));
						}
						{
							bRaca = new JRadioButton();
							painelBusca.add(bRaca);
							bRaca.setText("Raca");
							bRaca.setBounds(116, 24, 56, 18);
							grupoBotaoPesquisa.add(bRaca);
							bRaca.setFont(new java.awt.Font("Segoe UI",1,12));
						}
					}
					{
						bTodos = new BtView();
						painelPesquisa.add(bTodos);
						bTodos.setText("Listar Todos");
						bTodos.setBounds(342, 13, 127, 32);
						bTodos.addActionListener(actionListen);
					}
					{
						bPesquisar = new JButton();
						painelPesquisa.add(bPesquisar);
						bPesquisar.setText("Pesquisar");
						bPesquisar.setBounds(342, 56, 127, 32);
						bPesquisar.setFont(new java.awt.Font("Segoe UI",1,12));
						bPesquisar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/Search32x32.png")));
						bPesquisar.addActionListener(actionListen);
					}
				}
			}
			{
				bVisualizar = new BtView();
				this.add(bVisualizar);
				bVisualizar.setText("Visualizar");
				bVisualizar.setBounds(505, 129, 115, 32);
				bVisualizar.addActionListener(actionListen);
			}
			{
				bEditar = new BtEditar();
				this.add(bEditar);
				bEditar.setBounds(505, 168, 115, 32);
				bEditar.addActionListener(actionListen);
			}
			{
				bRemover = new BtRemover();
				this.add(bRemover);
				bRemover.setBounds(505, 207, 115, 32);
				bRemover.addActionListener(actionListen);
			}
			{
				bFechar = new BtCancelar();
				this.add(bFechar);
				bFechar.setBounds(505, 283, 115, 32);
				bFechar.addActionListener(actionListen);
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ");
		}
	}
	
	//Mostra os dados da array na tabela
	private void exibirNaTabela(List<Ovino> lista) {
		tableModel.limpar();
		if(!lista.isEmpty())
			tableModel.addLista(lista);	
			tbDados.addRowSelectionInterval(0,0);		
    }
    
    private	void atualizarTable(){
    	try {
			List<Ovino> lista = facade.buscaTodosOvino();
			if(!lista.isEmpty()){
				exibirNaTabela(lista);
				enabledButtons(true);
			}else{
				tableModel.limpar();	
				enabledButtons(false);
    		}
		}catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ");
		}
    }
    
    private void fechar(){
    	close();
    }
    
    private void enabledButtons(boolean v){
    	bEditar.setEnabled(v);
		bRemover.setEnabled(v);
		bVisualizar.setEnabled(v);
    }
    private String escolhaDeBusca(){    	    		
    	if(bRaca.isSelected()){
    		return "OVINO_RACA";
    	}    	
    	return "OVINO_CODIGO";
    }
          

	//classe que controla as acoes dos botoes
    private class ActionOvelha extends MouseAdapter implements ActionListener,KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {	
			if(e.getSource().equals(bTodos)){
				atualizarTable();				
			}
			if(e.getSource().equals(bFechar)){
				fechar();
    		}											
			if(e.getSource().equals(bEditar)){
				if(!tableModel.isEmpty()){
					Ovino ovino = tableModel.get(tbDados.getSelectedRow());
					new JanelaEditarOvino(ovino);
				}				
			}						
			if(e.getSource().equals(bVisualizar)){
				if(!tableModel.isEmpty()){
					Ovino ovino = tableModel.get(tbDados.getSelectedRow());
					new JanelaEditarOvino(ovino);		
				}
			}
			if(e.getSource().equals(bPesquisar)){
				try {
					List<Ovino> list = facade.buscaOvino(escolhaDeBusca(),ctBusca.getText().toUpperCase());
					if(!list.isEmpty())
						exibirNaTabela(list);
					else
						tableModel.limpar();
				} catch (JECOException ex) {
					JECOLogger.getInstance().log(ex);
					new JanelaInformacao("Erro no sistema, Por favor procure o suporte.");
				} 	
			}
			if(e.getSource().equals(bRemover)){				
				if(!tableModel.isEmpty()){
					try{
						Ovino ovino = tableModel.get(tbDados.getSelectedRow());
						if(new JanelaConfirmacao("Realmente deseja apagar?").resposta()){
							facade.apagarOvino(ovino);
							new JanelaInformacao("Apagado com sucesso",JanelaInformacao.SUCESSO);
							atualizarTable();
						}						
					}catch(JECOException ex){
						JECOLogger.getInstance().log(ex);
						new JanelaInformacao("Erro ao remover, tente novamente");
					}
				}				 
			}			
		}	
		@Override
		public void keyPressed(KeyEvent e) {			
//			if(e.getSource().equals(ctBusca)){
//				try {					
//					exibirNaTabela(facade.buscaOvino(escolhaDeBusca(),ctBusca.getText()));				
//				} catch (JECOException ex) {
//					JECOLogger.getInstance().log(ex);
//					new JanelaInformacao("Erro no sistema, Por favor procure o suporte.");
//				} 				
//			}			
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
						
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
						
		}

    	//visualiza a ovelha correspondente a linha selecionada na tabela
        @Override
    	public void mouseClicked(java.awt.event.MouseEvent e) {
            if ( e.getClickCount() == 2 ) {
            	new JanelaEditarOvino(tableModel.get(tbDados.getSelectedRow())) ;
            }
    	}    	
    }
}
