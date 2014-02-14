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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Pesagem;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.TablePeso;
import com.jeco.ui.butons.BtCancelar;
import com.jeco.ui.butons.BtEditar;
import com.jeco.ui.butons.BtRemover;
import com.jeco.ui.butons.BtView;
import com.jeco.ui.controler.EnumNomeBotoes;
import com.jeco.ui.validaFormulario.CampoPeso;



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
public class JanelaPesosCadastrados extends PanelDefault {

	private JTable tabelaPesos;
	private TablePeso pesoTableModel;
	private javax.swing.JScrollPane scroll;
	private JECOFacade facade;	
	private JButton bRemover;
	private JButton bPerquisar;
	private ButtonGroup grupoSelecao;
	private JLabel rKg2;
	private CampoPeso ctY;
	private JLabel rE;
	private JLabel rKg;
	private CampoPeso ctX;
	private JRadioButton bsEntre;
	private CampoPeso ctAcima;
	private JRadioButton bsAcima;
	private JRadioButton bsCodigo;
	private JTextField ctBuscaPorCodigo;
	private JPanel painelSecundario;
	private JButton bFechar;
	private JButton bEditar;
	private Action action;
	

	public JanelaPesosCadastrados() {
		super("PESOS CADASTRADOS",EnumNomeBotoes.VISUALIZAR_PESO_CLOSE);
		action = new Action();
		facade = new JECOFacade();
		initGUI();		
		atualizarTable();
		//chama a inicialização da janela enviando este para a janela padrão
		super.run();
	}
	
	public JanelaPesosCadastrados(boolean evento) {
		super("PESOS CADASTRADOS",EnumNomeBotoes.VISUALIZAR_PESO_CLOSE);
		action = new Action();
		facade = new JECOFacade();
		initGUI();
		pesoTableModel.limpar();
		event();		
		super.run();
	}

	private void initGUI() {
		try {
			this.setSize(new java.awt.Dimension(630, 334));
			this.setLayout(null);
			
			{
				bEditar = new BtEditar();
				this.add(bEditar);
				bEditar.setBounds(499, 147, 125, 32);
				bEditar.addActionListener(action);
			}
			{
				bRemover = new BtRemover();
				this.add(bRemover);
				bRemover.setBounds(499, 190, 125, 32);
				bRemover.addActionListener(action);
			}
			{
				bPerquisar = new JButton();
	    		bPerquisar.setText("Perquisar");
	    		bPerquisar.setBounds(499, 50, 125, 32);
	    		bPerquisar.setFont(new java.awt.Font("Segoe UI",1,12));
	    		bPerquisar.addActionListener(action);
			}
			{
				bFechar = new BtCancelar();
				this.add(bFechar);
				this.add(bPerquisar);
				bPerquisar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/Search32x32.png")));
				bFechar.setBounds(499, 283, 125, 32);
				bFechar.addActionListener(action);
			}
			{
				painelSecundario = new JPanel();
				this.add(painelSecundario);				
				painelSecundario.setBounds(6, 6, 487, 322);
				painelSecundario.setBorder(BorderFactory.createTitledBorder(null, "Busca peso por:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,12)));
				painelSecundario.setLayout(null);
				{
					scroll = new JScrollPane();					
					painelSecundario.add(scroll);
					scroll.setBounds(14, 86, 459, 222);
					pesoTableModel = new TablePeso();
					tabelaPesos = new JTable();
					this.add(tabelaPesos);
					tabelaPesos.setModel(pesoTableModel);
					tabelaPesos.setBounds(13, 49, 440, 53);
					tabelaPesos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
					scroll.setViewportView(tabelaPesos);
				}
				{
					grupoSelecao = new ButtonGroup();
				}
				{
					bsCodigo = new JRadioButton();
					painelSecundario.add(bsCodigo);
					bsCodigo.setSelected(true);
					bsCodigo.setText("Codigo Ovino:");
					bsCodigo.setBounds(17, 18, 112, 20);
					bsCodigo.setFont(new java.awt.Font("Segoe UI",1,12));
					grupoSelecao.add(bsCodigo);
				}
				{
					bsAcima = new JRadioButton();
					painelSecundario.add(bsAcima);
					bsAcima.setText("Peso acima de:");
					bsAcima.setBounds(189, 18, 121, 20);
					bsAcima.setFont(new java.awt.Font("Segoe UI",1,12));
					grupoSelecao.add(bsAcima);
				}
				{
					bsEntre = new JRadioButton();
					painelSecundario.add(bsEntre);
					bsEntre.setText("Peso entre:");
					bsEntre.setBounds(345, 18, 100, 20);
					bsEntre.setFont(new java.awt.Font("Segoe UI",1,12));
					grupoSelecao.add(bsEntre);
				}
				{
					ctBuscaPorCodigo = new JTextField();
					painelSecundario.add(ctBuscaPorCodigo);
					ctBuscaPorCodigo.setBounds(17, 43, 103, 28);
					ctBuscaPorCodigo.addKeyListener(action);
				}
				{
					ctAcima = new CampoPeso();
					painelSecundario.add(ctAcima);
					ctAcima.setBounds(191, 43, 81, 28);
					ctAcima.addKeyListener(action);					
				}
				{
					ctX = new CampoPeso();
					painelSecundario.add(ctX);
					ctX.setBounds(344, 43, 47, 28);
					ctX.addKeyListener(action);
				}
				{
					ctY = new CampoPeso();
					painelSecundario.add(ctY);
					ctY.setBounds(403, 43, 47, 28);
					ctY.addKeyListener(action);
				}
				{
					rKg = new JLabel();
					painelSecundario.add(rKg);
					rKg.setText("Kg.");
					rKg.setBounds(272, 48, 29, 16);
					rKg.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				
				{
					rE = new JLabel();
					painelSecundario.add(rE);
					rE.setText("e");
					rE.setBounds(392, 48, 13, 16);
				}
				{
					rKg2 = new JLabel();
					painelSecundario.add(rKg2);
					rKg2.setText("Kg.");
					rKg2.setBounds(452, 48, 25, 16);
					rKg2.setFont(new java.awt.Font("Segoe UI",1,12));
				}
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.");
		}
	}
	
	//Mostra os dados da array na tabela
    private void exibirNaTabela(List<Pesagem> pesagems) {
    	pesoTableModel.limpar();    	
		if(!pesagems.isEmpty())			
			pesoTableModel.addLista(pesagems);	
    }
    
    private void event(){
    	bsAcima.setSelected(true);
    	bsAcima.setVisible(false);
    	bsCodigo.setVisible(false);
		bsEntre.setVisible(false);
		ctBuscaPorCodigo.setVisible(false);
		ctX.setVisible(false);
		ctY.setVisible(false);
		rE.setVisible(false);		
		rKg2.setVisible(false);
		ctAcima.setBounds(15, 35, 103, 28);
		rKg.setBounds(120, 43, 29, 16);
		painelSecundario.setBorder(BorderFactory.createTitledBorder(null, "Ovino com peso acima de:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,12)));
    }
    
    private	void atualizarTable(){
    	try {
			List<Pesagem> lista = facade.buscaTodosPeso();
			if(!lista.isEmpty()){
				exibirNaTabela(lista);
				tabelaPesos.addRowSelectionInterval(0,0);
				enabledButtons(true);
			}	
			else{				
				pesoTableModel.limpar();
				enabledButtons(false);
			}
		}catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ");
		}
    }
    
    private void enabledButtons(boolean v){
    	bEditar.setEnabled(v);
    	bRemover.setEnabled(v);
    }
    
    private void pesquisar(){
    	try{
	    	if(bsAcima.isSelected()){
	    		if(ctAcima.getText().length()!=0){
		    		float acima = Float.parseFloat(ctAcima.getText().replace("." ,"").replace(",", "."));
		    		List<Pesagem> listAcima = facade.buscaPesoEntre(acima,1000);
		    		exibirNaTabela(listAcima);
	    		}
	    	}
	    	if(bsEntre.isSelected()){
	    		if(ctX.getText().length()!=0 && ctY.getText().length()!=0){
		    		float x = Float.parseFloat(ctX.getText().replace("." ,"").replace(",", "."));
		    		float y = Float.parseFloat(ctY.getText().replace("." ,"").replace(",", "."));
		    		List<Pesagem> listEntre = facade.buscaPesoEntre(x,y);
		    		exibirNaTabela(listEntre);
	    		}
	    	}
	    	if(bsCodigo.isSelected()){
	    		if(ctBuscaPorCodigo.getText().length()!=0)
	    			exibirNaTabela(facade.buscaPeso("PESO_COD_OVINO",ctBuscaPorCodigo.getText().toUpperCase()));
	    		else
	    			atualizarTable();
	    	}
	    	
    	}catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ");
		}	
    }    
   
      

	//classe que controla as acoes dos botoes
    private class Action extends MouseAdapter implements ActionListener,KeyListener{

    	@Override
    	public void actionPerformed(ActionEvent e) { 	    		
    		if(e.getSource().equals(bFechar)) {
    	    	close();
    		}   
    		if(e.getSource().equals(bPerquisar)){
    			pesquisar();
    		}
			if(e.getSource().equals(bEditar)) {
				if(!pesoTableModel.isEmpty()){
					Pesagem pesagem = pesoTableModel.get(tabelaPesos.getSelectedRow());
        			new JanelaEditarPeso(pesagem);
        			atualizarTable();
				} 
    		}
    		if(e.getSource().equals(bRemover)) {    			
				if(!pesoTableModel.isEmpty()){
					try {
	    				Pesagem pesagem = pesoTableModel.get(tabelaPesos.getSelectedRow());
	    				if(new JanelaConfirmacao("Realmente deseja apagar").resposta()){
	    					facade.apagarPeso(pesagem);
	    					new JanelaInformacao("Apagado com sucesso",JanelaInformacao.SUCESSO);
	    					atualizarTable();
	    				}	    				
					} catch (JECOException ex) {
						JECOLogger.getInstance().log(ex);
						new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ");
					} 
				}				  
    		}    		      		
    	}
    	
    	
    	public void mouseClicked(java.awt.event.MouseEvent e) {
            if ( e.getClickCount() == 2 ) {
            	new JanelaEditarPeso(pesoTableModel.get(tabelaPesos.getSelectedRow())) ;
            	atualizarTable();
            }  
            if(e.getSource().equals(ctAcima))				
				bsAcima.setSelected(true);
    	}    	
    	
    	@Override
    	public void keyPressed(KeyEvent arg0) {			
			if(arg0.getSource().equals(ctBuscaPorCodigo)){
				bsCodigo.setSelected(true);
				ctAcima.setText(null);
				ctX.setText(null);
				ctY.setText(null);			
			}
			else if(arg0.getSource().equals(ctX) || arg0.getSource().equals(ctY)){
				bsEntre.setSelected(true);
				ctBuscaPorCodigo.setText(null);
				ctAcima.setText(null);
			}
			else if(arg0.getSource().equals(ctAcima)){				
				bsAcima.setSelected(true);
				ctBuscaPorCodigo.setText(null);
				ctX.setText(null);
				ctY.setText(null);
			}
		} 

		@Override
		public void keyReleased(KeyEvent arg0) {			
		
		}
		@Override
		public void keyTyped(KeyEvent arg0) {			
			
		}
    }
}
