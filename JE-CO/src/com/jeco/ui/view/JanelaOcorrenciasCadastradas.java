package com.jeco.ui.view;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ocorrencia;
import com.jeco.Ovino;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.TableOcorrencia;
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
public class JanelaOcorrenciasCadastradas extends PanelDefault {

	private JTable tabelaOcorrencias;
	private TableOcorrencia ocrTableModel;
	private javax.swing.JScrollPane scroll;
	private JECOFacade facade;	
	private JButton bRemover;
	private JPanel painelSecundario;
	private JButton bFechar;
	private JButton bEditar;
	private JButton bVerDetalhes;
	private Action action;
	

	public JanelaOcorrenciasCadastradas() {
		super("OCORRENCIAS CADASTRADAS", EnumNomeBotoes.VISUALIZAR_OCORRENCIAS_CLOSE);
		action = new Action();
		facade = new JECOFacade();		
		initGUI();		
		atualizarTable();
		run();
			
	}
	

	//Mostra os dados da array na tabela
    public void exibirNaTabela(List<Ocorrencia> ocorrencias) {
    	ocrTableModel.limpar();    	
		if(ocorrencias.size()>0){			
			ocrTableModel.addLista(ocorrencias);
			tabelaOcorrencias.addRowSelectionInterval(0,0);
		}
    }
	
	private void initGUI() {
		try {
			this.setSize(new java.awt.Dimension(632, 334));
			this.setLayout(null);			
			{
				bVerDetalhes = new BtView();
				this.add(bVerDetalhes);
				bVerDetalhes.setText("Detalhes");
				bVerDetalhes.setBounds(505, 73, 116, 32);
			}
			{
				bEditar = new BtEditar();
				this.add(bEditar);
				
				bEditar.setBounds(505, 123, 116, 32);
				bEditar.addActionListener(action);
			}
			{
				bRemover = new BtRemover();
				this.add(bRemover);
				
				bRemover.setBounds(505, 175, 116, 32);
				bRemover.addActionListener(action);
			}
			{
				bFechar = new BtCancelar();
				this.add(bFechar);
				
				bFechar.setBounds(505, 282, 116, 32);
				bFechar.addActionListener(action);
			}
			{
				painelSecundario = new JPanel();
				this.add(painelSecundario);				
				painelSecundario.setBounds(6, 6, 487, 322);
				painelSecundario.setBorder(BorderFactory.createTitledBorder(null, "Registros de Ocorrencias", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
				painelSecundario.setLayout(null);
				{
					scroll = new JScrollPane();					
					painelSecundario.add(scroll);
					scroll.setBounds(14, 28, 459, 280);
					ocrTableModel = new TableOcorrencia();
					tabelaOcorrencias = new JTable();
					this.add(tabelaOcorrencias);
					tabelaOcorrencias.setModel(ocrTableModel);
					tabelaOcorrencias.setBounds(13, 49, 440, 53);
					tabelaOcorrencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
					scroll.setViewportView(tabelaOcorrencias);
				}
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}
	
	private	void atualizarTable(){
    	try {
			List<Ocorrencia> lista = facade.buscarOcorrencias();
			
			if(!lista.isEmpty()){
				exibirNaTabela(lista);
				enabledButtons(true);
			}else{
				ocrTableModel.limpar();
				enabledButtons(false);
			}
		}catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ",JanelaInformacao.ERRO);
		}
    }
	
	private void enabledButtons(boolean v){
		bEditar.setEnabled(v);
		bRemover.setEnabled(v);
		bVerDetalhes.setEnabled(v);
	}
	
	private void atualizarStatus(){
		try {
			Ovino ov = facade.buscaOvino(ocrTableModel.get(tabelaOcorrencias.getSelectedRow()).getCodigoOvino());
			ov.setStatus("1");
			facade.updateOvino(ov);
		} catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}
	
	//classe que controla as acoes dos botoes
    private class Action extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {   
    		if(e.getSource().equals(bFechar)) {
    			close();
    		}  		
			if(e.getSource().equals(bEditar)) {
				if(!ocrTableModel.isEmpty()){
					Ocorrencia oc = ocrTableModel.get(tabelaOcorrencias.getSelectedRow());
	    			new JanelaEditarOcorrencia(oc);
	    			atualizarTable();   
				}
    		}	    		
    		if(e.getSource().equals(bRemover)) {			
				if(!ocrTableModel.isEmpty()){
					try {
						Ocorrencia oc = ocrTableModel.get(tabelaOcorrencias.getSelectedRow());
						if(new JanelaConfirmacao("Realemente deseja remover a ocorrencia?").resposta()){
							facade.apagarOcorrencia(oc);
							atualizarStatus();
							atualizarTable();
							new JanelaInformacao("Ocorrencia removida",JanelaInformacao.SUCESSO);	
						}
					} catch (JECOException ex) {
						JECOLogger.getInstance().log(ex);
						new JanelaInformacao("Erro ao remover, Por favor procure o suporte.",JanelaInformacao.ERRO);
						
					}
				}							
    		}     		    		
    	}
    }
}
