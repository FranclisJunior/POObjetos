package com.jeco.ui.view;

import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Pesagem;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.Data;
import com.jeco.ui.butons.BtCancelar;
import com.jeco.ui.butons.BtSalvar;
import com.jeco.ui.controler.ControllHomeAddListener;
import com.jeco.ui.controler.EnumNomeBotoes;
import com.jeco.ui.validaFormulario.CampoCodigoExistente;
import com.jeco.ui.validaFormulario.CampoData;
import com.jeco.ui.validaFormulario.CampoPeso;
import java.awt.Dimension;




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
public class JanelaAddPeso extends PanelDefault {

	private static final long serialVersionUID = 1L;
	private CampoCodigoExistente ctCodigo;
	private JLabel rCodigo;
	private JButton bHistorico;
	private CampoPeso ctPeso;
	private CampoData ctData;
	private JButton bSalvar;
	private JLabel rPeso;
	private JPanel painelSecundario;
	private JECOFacade facade;	
	private Action actionListener;
	private JLabel rData;
	private Pesagem pesagem;
	private JButton bFechar;
	private JanelaPadrao comp;

	public JanelaAddPeso () {
		super("CADASTRAR PESO", EnumNomeBotoes.CADASTRO_PESO_CLOSE);
		pesagem = new Pesagem();
		facade = new JECOFacade();
		actionListener = new Action();		
		inicializarCampos();
		this.setSize(424, 330);
		run();
		
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new Dimension(424, 330));
			this.setLayout(null);
			{
				painelSecundario = new JPanel();
				this.add(painelSecundario);
				painelSecundario.setBounds(11, 24, 401, 234);
				painelSecundario.setLayout(null);
				painelSecundario.setBorder(BorderFactory.createTitledBorder("Adicionar Peso"));
				painelSecundario.setBackground(SystemColor.activeCaption);
				{
					rCodigo = new JLabel();
					painelSecundario.add(rCodigo);
					rCodigo.setText("Codigo do Ovino:");
					rCodigo.setBounds(22, 30, 106, 16);
					rCodigo.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{						
					painelSecundario.add(ctCodigo);
					ctCodigo.setBounds(17, 47, 155, 28);
					ctCodigo.setFont(new java.awt.Font("Segoe UI",0,12));
				}
				{
					rPeso = new JLabel();
					painelSecundario.add(rPeso);
					rPeso.setText("Peso:");
					rPeso.setBounds(22, 93, 82, 16);
					rPeso.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					rData = new JLabel();
					painelSecundario.add(rData);
					rData.setText("Data da Pesagem:");
					rData.setBounds(22, 159, 117, 16);
					rData.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{					
					painelSecundario.add(ctData);
					{
						painelSecundario.add(ctPeso);
						{
							bHistorico = new JButton();
							painelSecundario.add(bHistorico);
							bHistorico.setText("Historico de Pesagens");
							bHistorico.setBounds(230, 48, 155, 28);
							bHistorico.setFont(new java.awt.Font("Segoe UI",1,12));
							bHistorico.addActionListener(actionListener);
						}
						ctPeso.setBounds(17, 109, 155, 28);
						ctPeso.setFont(new java.awt.Font("Segoe UI",0,12));
					}
					ctData.setBounds(17, 175, 155, 28);
				}
				}			
			{
				bSalvar = new BtSalvar();
				this.add(bSalvar);
				bSalvar.setBounds(307, 284, 101, 30);
				bSalvar.addActionListener(actionListener);
			}
			{
				bFechar = new BtCancelar();
				this.add(bFechar);
				bFechar.setBounds(195, 284, 101, 30);
				bFechar.addActionListener(actionListener);
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}
	
	public boolean camposValidos(){	
		ctData.requestFocus();
		ctPeso.requestFocus();
		ctCodigo.requestFocus();
		bSalvar.requestFocus();
		return (ctPeso.validar() & ctCodigo.validar() & ctData.validar());	
	}
	
	private void inicializarCampos(){
		ctData = new CampoData();
		ctCodigo = new CampoCodigoExistente();
		ctPeso = new CampoPeso();
		ctData.setText(Data.atual());
		this.initGUI();	
	}
	
	private void limparCampos(){		
		ctCodigo.setText(null);
		ctPeso.setText(null);
	}
	
	private void salvar(){
		try{    				
			if(camposValidos()){
				String cod = ctCodigo.getText().toUpperCase();
				float ps = Float.parseFloat(ctPeso.getText().replace("." ,"").replace(",", "."));
				String data  = ctData.getText();	    				
				pesagem.setCodOvino(cod);
				pesagem.setPeso(ps);
				pesagem.setData(data);
				if(facade.salvarPeso(pesagem)){
	        		if(new JanelaConfirmacao("Salvo com sucesso. Deseja cadastrar outro? ").resposta()){
	        			limparCampos();	        				
	        			pesagem = new Pesagem();
	        		}else{
	        			close();  
	        		}
			    }     				
			}else{
				new JanelaInformacao("Verifique os campos invalidos",JanelaInformacao.ATENCAO);
			}	    			
		}catch(JECOException ex){
			JECOLogger.getInstance().log(ex);	
			new JanelaInformacao("Nao foi Possível salvar, procure o suporte ",JanelaInformacao.ERRO);
		}
	}
	
		
	private class Action extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(bSalvar)) {   			
				salvar();   			
    		}
    		if(e.getSource().equals(bFechar)) {
    			close();
    		}
    		if(e.getSource().equals(bHistorico)) {
    			new JanelaPesosCadastrados();
    		}
    	}
	}
}
