package com.jeco.ui.view;


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
import com.jeco.ui.butons.BtCancelar;
import com.jeco.ui.butons.BtSalvar;
import com.jeco.ui.validaFormulario.CampoCodigoExistente;
import com.jeco.ui.validaFormulario.CampoData;
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
public class JanelaEditarPeso extends PanelDefault {

	private static final long serialVersionUID = 1L;
	private CampoCodigoExistente ctCodigo;
	private JLabel rCodigo;
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
	

	public JanelaEditarPeso (Pesagem pesagem) {
		super("ATUALIZAR PESO", null);
		this.pesagem = pesagem ;
		facade = new JECOFacade();
		actionListener = new Action();		
		inicializarCampos();
		run();
	}
	
	private void initGUI() {
		try {
			this.setSize(new java.awt.Dimension(301, 325));
			this.setLayout(null);
			{
				painelSecundario = new JPanel();
				this.add(painelSecundario);
				painelSecundario.setBounds(25, 19, 246, 234);
				painelSecundario.setLayout(null);
				painelSecundario.setBorder(BorderFactory.createTitledBorder("Editar Peso"));
				{
					rCodigo = new JLabel();
					painelSecundario.add(rCodigo);
					rCodigo.setText("Codigo do Ovino:");
					rCodigo.setBounds(47, 32, 106, 16);
					rCodigo.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{						
					painelSecundario.add(ctCodigo);
					ctCodigo.setBounds(40, 47, 155, 28);
					ctCodigo.setFont(new java.awt.Font("Segoe UI",0,12));
				}
				{
					rPeso = new JLabel();
					painelSecundario.add(rPeso);
					rPeso.setText("Peso:");
					rPeso.setBounds(47, 92, 82, 16);
					rPeso.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					rData = new JLabel();
					painelSecundario.add(rData);
					rData.setText("Data da Pesagem:");
					rData.setBounds(47, 153, 117, 16);
					rData.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{					
					painelSecundario.add(ctData);
					{
						painelSecundario.add(ctPeso);
						ctPeso.setBounds(40, 107, 155, 28);
						ctPeso.setFont(new java.awt.Font("Segoe UI",0,12));
					}
					ctData.setBounds(40, 168, 155, 28);
				}
				}			
			{
				bSalvar = new BtSalvar();
				this.add(bSalvar);
				bSalvar.setBounds(170, 279, 101, 34);
				bSalvar.addActionListener(actionListener);
			}
			{
				bFechar = new BtCancelar();
				this.add(bFechar);
				bFechar.setBounds(64, 280, 101, 34);
				bFechar.addActionListener(actionListener);
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}
	
	public boolean camposValidos(){	
		ctPeso.requestFocus();
		ctData.requestFocus();	
		ctCodigo.requestFocus();
		bSalvar.requestFocus();
		return (ctPeso.validar() & ctCodigo.validar() & ctData.validar());	
	}
	
	private void inicializarCampos(){
		ctData = new CampoData();
		ctCodigo = new CampoCodigoExistente();
		ctPeso = new CampoPeso();
		ctData.setText(pesagem.getData());
		ctCodigo.setText(pesagem.getCodOvino());
		ctPeso.setText(Float.toString(pesagem.getPeso()).replace("." ,""));
		ctCodigo.setEditable(false);
		this.initGUI();	
	}
		
	private void salvar(){
		try{    				
			if(camposValidos()){
				String cod = ctCodigo.getText();
				float ps = Float.parseFloat(ctPeso.getText().replace("." ,"").replace(",", "."));
				String data  = ctData.getText();	    				
				pesagem.setCodOvino(cod);
				pesagem.setPeso(ps);
				pesagem.setData(data);
				facade.updatePeso(pesagem);
				close();
				new JanelaInformacao("Editado com sucesso",JanelaInformacao.SUCESSO);				
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
    	}
	}

}
