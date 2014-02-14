package com.jeco.ui.view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Raca;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.TableRaca;
import com.jeco.ui.butons.BtEditar;
import com.jeco.ui.butons.BtNovo;
import com.jeco.ui.butons.BtRemover;
import com.jeco.ui.butons.BtSalvar;
import com.jeco.ui.controler.ControlEvent;
import com.jeco.ui.controler.ControlerHomeListener;
import com.jeco.ui.controler.ControllHomeAddListener;
import com.jeco.ui.controler.EnumNomeBotoes;
import com.jeco.ui.validaFormulario.CampoRacaOvino;

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
public class JanelaCriarRaca extends PanelDefault {

	
	private static final long serialVersionUID = 1L;
	private JPanel panelBotoes;
	private JButton jButtonNovo;
	private JButton jButtonRemove;
	private JTable jTableValues;
	private JButton jButtonEditar;
	private CampoRacaOvino ctNome;
	private JButton jButtonSalvar;
	private JECOFacade facade;
	private Action actionListener;
	private TableRaca tableModel;	
	private boolean editar;
	private javax.swing.JScrollPane scroll;
	
	
	public JanelaCriarRaca() {
		super("CADASTRAR RAÇA", EnumNomeBotoes.CADASTRO_RACA_CLOSE);
		this.facade = new JECOFacade();
		initGUI();
		atualizarTable();
		run();		
	}
		
	private void initGUI() {
		try {
			this.actionListener = new Action();
			this.setPreferredSize(new java.awt.Dimension(363, 343));
			this.setSize(new java.awt.Dimension(363, 343));
			this.setLayout(null);
			{
				panelBotoes = new JPanel();
				this.add(panelBotoes);
				panelBotoes.setBounds(6, 231, 351, 106);
				panelBotoes.setLayout(null);
				panelBotoes.setBorder(BorderFactory.createTitledBorder(""));
				panelBotoes.setBackground(SystemColor.activeCaption);
			}
				{
					jButtonNovo = new BtNovo();
					panelBotoes.add(jButtonNovo);
					jButtonNovo.setBounds(10, 69, 106, 32);
					jButtonNovo.addActionListener(actionListener);
				}
				{
					jButtonRemove = new BtRemover();
					panelBotoes.add(jButtonRemove);
					jButtonRemove.setBounds(119, 69, 112, 32);
					jButtonRemove.addActionListener(actionListener);
				}
				{
					jButtonEditar = new BtEditar();
					panelBotoes.add(jButtonEditar);
					jButtonEditar.setBounds(234, 69, 107, 32);
					jButtonEditar.addActionListener(actionListener);
				}
				
				{
					jButtonSalvar = new BtSalvar();
					panelBotoes.add(jButtonSalvar);
					jButtonSalvar.setBounds(234, 18, 107, 32);
					jButtonSalvar.addActionListener(actionListener);
				}
				{
					ctNome = new CampoRacaOvino();
					panelBotoes.add(ctNome);
					ctNome.setBounds(4, 18, 224, 33);
				}
				
			
			{	
				scroll = new JScrollPane();					
				this.add(scroll);
				tableModel = new TableRaca();
				jTableValues = new JTable();
				this.add(jTableValues);
				jTableValues.setModel(tableModel);
				jTableValues.setBounds(6, 6, 351, 213);
				jTableValues.setFont(new java.awt.Font("Arial",1,14));
				jTableValues.setForeground(new java.awt.Color(33,67,67));
				jTableValues.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
				scroll.setBounds(jTableValues.getBounds());
				scroll.setViewportView(jTableValues);
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	 }
	
	private void atualizarTable(){
		try {
			List<Raca> lista = facade.buscaRaca();
			if(!lista.isEmpty()){
				enabledButtons(true);
				exibirNaTabela(lista);				
			}else{
				enabledButtons(false);
				tableModel.limpar();			
			}
		}catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ",JanelaInformacao.ERRO);
		}
	}
	
	private void exibirNaTabela(List<Raca> racas) {
    	tableModel.limpar();	    	
		if(!racas.isEmpty()){			
				tableModel.addLista(racas);
				jTableValues.setRowSelectionInterval(0, 0);
		}
	}
	 
	private void salvar(){
		Raca rc;
		 try {
			 if(editar){
				rc = tableModel.get(jTableValues.getSelectedRow());
		 		rc.setRacaName(ctNome.getText().toUpperCase());
		 		facade.updateRaca(rc);		    		
	    		new JanelaInformacao("Atualizado com sucesso.",JanelaInformacao.SUCESSO);		    		
			 	enableCampos(false);
			 }else{				 
				rc = new Raca(ctNome.getText().toUpperCase());
				facade.salvarRaca(rc);
				atualizarTable();
				if(new JanelaConfirmacao("Cadastrado com Sucesso, Deseja cadastrar outro ?").resposta()){
					editar = false;
					ctNome.setText(null);
					ctNome.requestFocus();
					enableCampos(true);
				}else{
					enableCampos(false);
				}			
			}
			atualizarTable();
		} catch (JECOException e1) {				
			if(new JanelaConfirmacao("Ocorreu um erro, Deseja tentar novamente?").resposta()){
				editar= false;
				ctNome.setText(null);
				ctNome.requestFocus();
				enableCampos(true);
			}else{
				enableCampos(false);
			}
		}		 
	}
	
	private void enabledButtons(boolean v){
		jButtonEditar.setEnabled(v);
		jButtonRemove.setEnabled(v);		
	}	
	 
	private void enableCampos(boolean valor){
		ctNome.setVisible(valor);
		jButtonSalvar.setVisible(valor);		
	}	 
	
	//classe que controla as acoes dos botoes
    private class Action extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(jButtonSalvar)) {    			
    			if(ctNome.validar()){    				
    				salvar();
    				ctNome.setText(null);
    			}else{
    				new JanelaInformacao("Nome da raça é invalido ou ja existe",JanelaInformacao.ATENCAO);
    			}   			
    		}   
    		
    		else if(e.getSource().equals(jButtonNovo)){    			
    			editar=false;
    			ctNome.setText(null);
    			enableCampos(true);
    			ctNome.requestFocus();    			
    		}
    		
    		else if(e.getSource().equals(jButtonEditar)) {
    			if(!tableModel.isEmpty()){
	    			editar = true;		
					Raca rac = tableModel.get(jTableValues.getSelectedRow());
	    			enableCampos(true);
	    			ctNome.setText(rac.getRacaName());
	    			ctNome.requestFocus(); 	    			
    			}
    		}else if(e.getSource().equals(jButtonRemove)) {	 		
				if(!tableModel.isEmpty()){
					try { 
						Raca raca = tableModel.get(jTableValues.getSelectedRow());
	    				if(new JanelaConfirmacao("Realmente deseja apagar?").resposta()){	    				
							facade.apagarRaca(raca);
							new JanelaInformacao("Removido com sucesso",JanelaInformacao.SUCESSO);
							atualizarTable();
	    				}	    				 
					} catch (JECOException ex) {
						JECOLogger.getInstance().log(ex);
						new JanelaInformacao("Erro ao remover, procure o suporte",JanelaInformacao.ERRO);
					}
				}		
    		}    	
    	}
    }
}
