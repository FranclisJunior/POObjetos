package com.jeco.ui.view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.OcorrenciaTipo;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.TableOcorrenciaTipo;
import com.jeco.ui.butons.BtEditar;
import com.jeco.ui.butons.BtNovo;
import com.jeco.ui.butons.BtRemover;
import com.jeco.ui.butons.BtSalvar;
import com.jeco.ui.controler.ControllHomeAddListener;
import com.jeco.ui.controler.EnumNomeBotoes;
import com.jeco.ui.validaFormulario.CampoOcorrenciaTipo;

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
public class JanelaCriarOcorrenciaTipo extends PanelDefault {

	private javax.swing.JScrollPane scroll;
	private JTable tabelaOcorrencias;
	private TableOcorrenciaTipo tableModel;
	private JPanel painelBotoes;
	private CampoOcorrenciaTipo ctNome;
	private JButton jButtonSalvar;
	private JButton jButtonEditar;
	private JButton jButtonRemove;
	private JButton jButtonNovo;
	private Action actionListener;
	private JECOFacade facade;
	private boolean editar;
	

	public JanelaCriarOcorrenciaTipo() {
		super("CADASTRAR TIPO DE OCORRENCIA", EnumNomeBotoes.CADASTRO_TIPO_OCORRENCIA_CLOSE);
		facade = new JECOFacade();
		initGUI();
		atualizarTable();
		run();
							
	}
	
	
	
	
	private void initGUI() {
		try {
			this.setSize(new java.awt.Dimension(363, 343));			
			this.setLayout(null);
			actionListener = new Action();
			{
				painelBotoes = new JPanel();
				this.add(painelBotoes);
				painelBotoes.setBounds(6, 231, 351, 106);
				painelBotoes.setBorder(BorderFactory.createTitledBorder(""));
				painelBotoes.setLayout(null);
				painelBotoes.setBackground(SystemColor.activeCaption);
				{
					jButtonNovo = new BtNovo();
					painelBotoes.add(jButtonNovo);
					jButtonNovo.setBounds(10, 69, 106, 32);
					jButtonNovo.addActionListener(actionListener);
				}
				{
					jButtonRemove = new BtRemover();
					painelBotoes.add(jButtonRemove);
					jButtonRemove.setBounds(119, 69, 112, 32);
					jButtonRemove.addActionListener(actionListener);
				}
				{
					jButtonEditar = new BtEditar();
					painelBotoes.add(jButtonEditar);
					jButtonEditar.setBounds(234, 69, 107, 32);
					jButtonEditar.addActionListener(actionListener);
				}
				{
					ctNome = new CampoOcorrenciaTipo();
					painelBotoes.add(ctNome);
					ctNome.setBounds(10, 16, 218, 32);
				}
				{
					jButtonSalvar = new BtSalvar();
					painelBotoes.add(jButtonSalvar);
					jButtonSalvar.setBounds(234, 18, 107, 32);
					jButtonSalvar.addActionListener(actionListener);
				}
			}
			{	
				scroll = new JScrollPane();					
				this.add(scroll);
				tableModel = new TableOcorrenciaTipo();
				tabelaOcorrencias = new JTable();
				this.add(tabelaOcorrencias);
				tabelaOcorrencias.setModel(tableModel);
				tabelaOcorrencias.setBounds(6, 6, 351, 213);
				tabelaOcorrencias.setFont(new java.awt.Font("Segoe UI",1,16));
				tabelaOcorrencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
				scroll.setBounds(tabelaOcorrencias.getBounds());
				scroll.setViewportView(tabelaOcorrencias);
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}
	
	private void atualizarTable(){
		try {
			List<OcorrenciaTipo> lista = facade.buscarOcorrenciasTipo();
			if(!lista.isEmpty()){
				exibirNaTabela(lista);
				enableButtons(true);
			}else{				
				tableModel.limpar();
				enableButtons(false);
			}
		}catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ",JanelaInformacao.ERRO);
		}
	}
	
	private void exibirNaTabela(List<OcorrenciaTipo> oc) {
		tableModel.limpar();	    	
		if(!oc.isEmpty())			
			tableModel.addLista(oc);
			tabelaOcorrencias.addRowSelectionInterval(0,0);
	}
	
	private void enableCampos(boolean valor){
		ctNome.setVisible(valor);
		jButtonSalvar.setVisible(valor);
	}
	private void enableButtons(boolean v){
		jButtonRemove.setEnabled(v);
		jButtonEditar.setEnabled(v);
	}
	
	
	private void salvar(){
		OcorrenciaTipo ocTipo;
		 try {
			if(editar){
				ocTipo = tableModel.get(tabelaOcorrencias.getSelectedRow());
			 	ocTipo.setNome(ctNome.getText().toUpperCase().replace("Ç", "C"));
		 		facade.updateOcorrenciaTipo(ocTipo);		    		
	    		new JanelaInformacao("Atualizado com sucesso",JanelaInformacao.SUCESSO);		    		
			 	enableCampos(true);
			}else{	
				ocTipo = new OcorrenciaTipo();
				ocTipo.setNome(ctNome.getText().toUpperCase().replace("Ç", "C"));
				facade.salvarOcorrenciaTipo(ocTipo);
				atualizarTable();
				if(new JanelaConfirmacao("Cadastrado com Sucesso, Deseja cadastrar outro ?").resposta()){
					editar= false;
					ctNome.requestFocus();
					ctNome.setText(null);
					enableCampos(true);
				}else{
					enableCampos(false);
				}				
			}
			atualizarTable();
		} catch (JECOException e1) {				
			if(new JanelaConfirmacao("Ocorreu um erro, Deseja tentar novamente?").resposta()){
				editar = false;
				ctNome.requestFocus();
				ctNome.setText(null);
				enableCampos(true);
			}else{
				enableCampos(false);
			}
		}		 
	 }
	
	
	//classe que controla as acoes dos botoes
    private class Action extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(jButtonSalvar)) {    			 
    			if(ctNome.validar())  {  				
    				salvar();
    				ctNome.setText(null);
    			}else
    				new JanelaInformacao("Nome do tipo de ocorrencia é invalido ou ja existe",JanelaInformacao.ATENCAO);
       		}
    		if(e.getSource().equals(jButtonNovo)) {
    			editar = false;
    			ctNome.setText(null);
    			enableCampos(true);
    			ctNome.requestFocus();
    		} 
    		if(e.getSource().equals(jButtonRemove)) {    			
    			try {    
    				if(!tableModel.isEmpty()){
						OcorrenciaTipo ocTipo = tableModel.get(tabelaOcorrencias.getSelectedRow());
	    				if(new JanelaConfirmacao("Realmente deseja apagar?").resposta()){	    				
							facade.apagarOcorrenciaTipo(ocTipo);
							atualizarTable();
							new JanelaInformacao("Removido com sucesso",JanelaInformacao.SUCESSO);
	    				}    					
    				}  				
				} catch (JECOException ex) {
					JECOLogger.getInstance().log(ex);
					new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ",JanelaInformacao.ERRO);
				}   			
    		} 
    		if(e.getSource().equals(jButtonEditar)) { 
    			if(!tableModel.isEmpty()){
	    			editar = true; 	    						
	    			OcorrenciaTipo ocTipo = tableModel.get(tabelaOcorrencias.getSelectedRow());	    			
	    			enableCampos(true);
	    			ctNome.setText(ocTipo.getNome());
	    			ctNome.requestFocus();
    			}
       		}
    	}
    }
}
