package com.jeco.ui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Usuario;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.TableUsuario;
import com.jeco.ui.butons.BtEditar;
import com.jeco.ui.butons.BtNovo;
import com.jeco.ui.butons.BtRemover;
import com.jeco.ui.butons.BtSalvar;
import com.jeco.ui.controler.EnumNomeBotoes;
import com.jeco.ui.validaFormulario.CampoNome;




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
public class JanelaCriarUsuario extends PanelDefault {
	private static final long serialVersionUID = 1L;
	private JPanel jPanelBotoes;
	private JButton jButtonNovo;
	private JButton jButtonRemove;
	private JTable jTableValues;
	private JButton jButtonEditar;
	private CampoNome ctNome;
	private JButton jButtonSalvar;
	private JECOFacade facade;
	private Action actionListener;
	private JLabel rNivel;
	private JComboBox comboBox;
	private JTextField ctSenha;
	private JLabel rSenha;
	private JLabel rNome;
	private TableUsuario tableModel;	
	private boolean editar;
	private javax.swing.JScrollPane scroll;
	
	public JanelaCriarUsuario() {	
		super("CADASTRO DE USUARIO", EnumNomeBotoes.CADASTRO_USUARIO_CLOSE);
		this.facade = new JECOFacade();
		initGUI();
		atualizarTable();
		this.setSize(new java.awt.Dimension(369, 396));
		run();
	}
	
	
	private void initGUI() {
		try {
			this.actionListener = new Action();
			this.setPreferredSize(new java.awt.Dimension(369, 396));
			this.setLayout(null);
			{
				jPanelBotoes = new JPanel();
				this.add(jPanelBotoes);
				jPanelBotoes.setBounds(6, 231, 356, 153);
				jPanelBotoes.setLayout(null);
				jPanelBotoes.setBorder(BorderFactory.createTitledBorder(""));
				{
					jButtonNovo = new BtNovo();
					jPanelBotoes.add(jButtonNovo);
					jButtonNovo.setBounds(6, 113, 101, 32);
					jButtonNovo.addActionListener(actionListener);
				}
				{
					jButtonRemove = new BtRemover();
					jPanelBotoes.add(jButtonRemove);
					jButtonRemove.setBounds(123, 113, 101, 32);
					jButtonRemove.addActionListener(actionListener);
				}
				{
					jButtonEditar = new BtEditar();
					jPanelBotoes.add(jButtonEditar);
					jButtonEditar.setBounds(240, 113, 101, 32);
					jButtonEditar.addActionListener(actionListener);
				}
				{
					ctNome = new CampoNome();
					jPanelBotoes.add(ctNome);
					ctNome.setBounds(6, 20, 175, 32);
				}
				{
					jButtonSalvar = new BtSalvar();
					jPanelBotoes.add(jButtonSalvar);
					jButtonSalvar.setBounds(240, 67, 101, 32);
					jButtonSalvar.addActionListener(actionListener);
				}
				{
					rNome = new JLabel();
					jPanelBotoes.add(rNome);
					rNome.setText("Nome do Usuario:");
					rNome.setBounds(13, 6, 110, 16);
					rNome.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					rSenha = new JLabel();
					jPanelBotoes.add(rSenha);
					rSenha.setText("Senha:");
					rSenha.setBounds(13, 51, 45, 16);
					rSenha.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					ctSenha = new JTextField();
					jPanelBotoes.add(ctSenha);
					ctSenha.setBounds(6, 67, 175, 32);
				}
				{
					ComboBoxModel comboBoxModel = 
							new DefaultComboBoxModel(
									new String[] { "Um", "Dois", "Tres" });
					comboBox = new JComboBox();
					jPanelBotoes.add(comboBox);
					comboBox.setModel(comboBoxModel);
					comboBox.setBounds(240, 22, 103, 32);
				}
				{
					rNivel = new JLabel();
					jPanelBotoes.add(rNivel);
					rNivel.setText("Nivel de Acesso:");
					rNivel.setBounds(240, 6, 103, 16);
					rNivel.setFont(new java.awt.Font("Segoe UI",1,12));
				}
			}
			{
				scroll = new JScrollPane();					
				this.add(scroll);
				tableModel = new TableUsuario();
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
			List<Usuario> lista = facade.buscarUsuarios();
			if(!lista.isEmpty()){
				exibirNaTabela(lista);
				enabledButtons(true);
			}else{
				tableModel.limpar();
				enabledButtons(false);
			}
		}catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ",JanelaInformacao.ERRO);
		}
	}
	
	private void exibirNaTabela(List<Usuario> us) {
    	tableModel.limpar();	    	
		if(!us.isEmpty()){			
			tableModel.addLista(us);
			jTableValues.setRowSelectionInterval(0, 0);
		}			
	}
	public void enabledButtons(boolean v){
		jButtonEditar.setEnabled(v);
		jButtonRemove.setEnabled(v);
	}
	
	public void enableCampos(boolean v){
		ctNome.setVisible(v);
		jButtonSalvar.setVisible(v);
		ctSenha.setVisible(v);
		comboBox.setVisible(v);
		rNivel.setVisible(v);
		rNome.setVisible(v);
		rSenha.setVisible(v);
	}
	private void limparCampos(){
		ctNome.setText(null);
		ctSenha.setText(null);
		comboBox.setSelectedIndex(0);			
	}
	
	private void salvar(){
		try {
			if(editar){	
				Usuario us = tableModel.get(jTableValues.getSelectedRow());
		 		if(!ctSenha.getText().equals("*****")){
		 			us.setSenha(ctSenha.getText());			 			
		 		}	
		 		us.setNome(ctNome.getText());
		 		us.setNivel(comboBox.getSelectedItem().toString());
		 		facade.updateUsuario(us);	    		
	    		new JanelaInformacao("Atualizado com sucesso.",JanelaInformacao.SUCESSO);		    		
	    		limparCampos();			 			 	
			}else{
				Usuario us = new Usuario();
				us.setNome(ctNome.getText());
				us.setSenha(ctSenha.getText());
				us.setNivel(comboBox.getSelectedItem().toString());
				facade.salvarUsuario(us);	
				atualizarTable();
				limparCampos();
				if(new JanelaConfirmacao("Cadastrado com Sucesso, Deseja cadastrar outro ?").resposta()){
					editar= false;
					enableCampos(true);
				}else
					enableCampos(false);								
			}
			atualizarTable();
		} catch (JECOException ex) {	
			JECOLogger.getInstance().log(ex);
			if(new JanelaConfirmacao("Ocorreu um erro, Deseja tentar novamente?").resposta()){
				enableCampos(true);
				limparCampos();
			}else
				enableCampos(false);			
		}	 
	}
	
	//classe que controla as acoes dos botoes
    private class Action extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(jButtonSalvar)) {
    			if(ctNome.validar()){
    				if(ctSenha.getText().length()!=0)
    						salvar();    
    				else
    					new JanelaInformacao("Senha Invalida",JanelaInformacao.ATENCAO);
    			}else
    				new JanelaInformacao("Nome Invalido",JanelaInformacao.ATENCAO);    			
    		}
    		else if(e.getSource().equals(jButtonNovo)) {
    			editar=false;
    			enableCampos(true);
    			limparCampos();    			  			
    		}
    		
    		else if(e.getSource().equals(jButtonEditar)) {   
    			if(!tableModel.isEmpty()){
	    			editar = true;    			
					Usuario user = tableModel.get(jTableValues.getSelectedRow());
	    			enableCampos(true); 
	    			ctNome.requestFocus(); 
	    			ctNome.setText(user.getNome());
	    			ctSenha.setText("*****");
	    			String nivel = user.getNivel();    			
	    			switch (nivel) {
					case "Um":
						comboBox.setSelectedIndex(0);
						break;
					case "Dois":
						comboBox.setSelectedIndex(1);
						break;
					default:
						comboBox.setSelectedIndex(2);
						break;
					} 
    			}
    			
    		}else if(e.getSource().equals(jButtonRemove)) {    			
				if(!tableModel.isEmpty()){
					try {
	    				Usuario user = tableModel.get(jTableValues.getSelectedRow());
	    				if(new JanelaConfirmacao("Realmente deseja apagar?").resposta()){
							facade.apagarUsuario(user);
							new JanelaInformacao("Apagado com Sucesso",JanelaInformacao.SUCESSO);
							atualizarTable();
	    				}
					} catch (JECOException ex) {
						JECOLogger.getInstance().log(ex);
						new JanelaInformacao("Não foi possível remover Usuario",JanelaInformacao.ERRO);
					} 
				} 			
    		}    	
    	}
    } 
}
