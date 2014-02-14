package com.jeco.ui.view;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ocorrencia;
import com.jeco.OcorrenciaTipo;
import com.jeco.Ovino;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.MyBoxModel;
import com.jeco.ui.butons.BtSalvar;
import com.jeco.ui.controler.EnumNomeBotoes;
import com.jeco.ui.validaFormulario.CampoCodigoExistente;
import com.jeco.ui.validaFormulario.CampoData;
import com.jeco.ui.validaFormulario.CampoPreco;


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
public class  JanelaEditarOcorrencia extends PanelDefault {

	private static final long serialVersionUID = 1L;
	private CampoCodigoExistente ctCodigo;
	private JLabel rCodigo;
	private CampoPreco ctCusto;
	private JLabel rPreco;
	private CampoData ctData;
	private JButton bSalvar;
	private JComboBox<String> comboBox;
	private JLabel rOcorrencia;
	private JPanel painelSecundario;
	private MyBoxModel boxModel;
	private JECOFacade facade;	
	private Action actionListener;
	private JLabel rData;
	private JTextArea ctDescricao;
	private JLabel rDescricao;
	private javax.swing.JScrollPane scroll;
	private Ocorrencia oc;	
	
	public JanelaEditarOcorrencia (Ocorrencia ocorrencia) {
		super("EDITAR OCORRENCIA", null);
		oc = ocorrencia;
		facade = new JECOFacade();
		actionListener = new Action();
		showComboBox();			
		inicializarCampos();
		preencheCampos();
		run();
	}
	
	public void showComboBox(){
		try{
			Iterator<OcorrenciaTipo> rc = facade.buscarOcorrenciasTipo().iterator();
			List<String> racas = new LinkedList<String>();		
			while (rc.hasNext()) {
				racas.add(rc.next().getNome());
				boxModel = new MyBoxModel(racas.iterator());
			}	
		}catch(JECOException e){
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}
	
	private void initGUI() {
		try {
			this.setSize(new java.awt.Dimension(424, 334));
			this.setLayout(null);
			{
				painelSecundario = new JPanel();
				this.add(painelSecundario);
				painelSecundario.setBounds(12, 12, 400, 310);
				painelSecundario.setLayout(null);
				painelSecundario.setBorder(BorderFactory.createTitledBorder(null, "Editar Ocorrencia", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
				{
					rCodigo = new JLabel();
					painelSecundario.add(rCodigo);
					rCodigo.setText("Codigo do Ovino:");
					rCodigo.setBounds(22, 22, 102, 16);
					rCodigo.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{						
					painelSecundario.add(ctCodigo);
					ctCodigo.setBounds(17, 38, 155, 28);
					ctCodigo.setFont(new java.awt.Font("Segoe UI",0,12));
				}
				{
					rOcorrencia = new JLabel();
					painelSecundario.add(rOcorrencia);
					rOcorrencia.setText("Ocorrencia:");
					rOcorrencia.setBounds(233, 22, 82, 16);
					rOcorrencia.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{			
					comboBox = new JComboBox<String>();
					painelSecundario.add(comboBox);
					comboBox.setModel(boxModel);
					comboBox.setBounds(227, 37, 155, 29);
					comboBox.setFont(new java.awt.Font("Segoe UI",0,12));
				}
				{
					rDescricao = new JLabel();
					painelSecundario.add(rDescricao);
					rDescricao.setText("Descriçao:");
					rDescricao.setBounds(22, 136, 76, 16);
					rDescricao.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					scroll = new JScrollPane();					
					painelSecundario.add(scroll);
					scroll.setBounds(17, 152, 366, 93);
					scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				}						
				{
					rData = new JLabel();
					painelSecundario.add(rData);
					rData.setText("Data da Ocorrencia:");
					rData.setBounds(22, 81, 117, 16);
					rData.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{					
					painelSecundario.add(ctData);
					{
						bSalvar = new BtSalvar();
						painelSecundario.add(bSalvar);
						bSalvar.setBounds(144, 264, 101, 28);
						bSalvar.addActionListener(actionListener);
					}
					{
						rPreco = new JLabel();
						painelSecundario.add(rPreco);
						rPreco.setText("Custo:");
						rPreco.setBounds(233, 81, 42, 16);
						rPreco.setFont(new java.awt.Font("Segoe UI",1,12));
					}
					{						
						painelSecundario.add(ctCusto);
						ctCusto.setBounds(227, 97, 155, 28);
					}
					ctData.setBounds(17, 97, 155, 28);
				}
				{						
					painelSecundario.add(ctDescricao);
					scroll.setViewportView(ctDescricao);
					ctDescricao.setLineWrap(true);
					ctDescricao.setColumns(10);
					ctDescricao.setBounds(17, 157, 263, 71);
					ctDescricao.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));						
					ctDescricao.setFont(new java.awt.Font("Segoe UI",0,14));

				}					
				}			
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}
	
	private void inicializarCampos(){
		ctCodigo = new CampoCodigoExistente();
		ctDescricao = new JTextArea();
		ctData = new CampoData();
		ctCusto = new CampoPreco();
		this.initGUI();	
	}
	
	private void preencheCampos(){		
		ctCodigo.setText(oc.getCodigoOvino());
		ctCodigo.setEditable(false);
		ctData.setText(oc.getData());
		ctDescricao.setText(oc.getDescricao());		
		String valor = (NumberFormat.getCurrencyInstance().format(oc.getCusto()).replace("R$", "").replace(",", "").replaceAll(" ", ""));
		ctCusto.setText(valor);
		comboBox.setSelectedItem(oc.getTipo());		
	}
	
	private void atualizarStatus(){
		try {
			Ovino ovino = facade.buscaOvino(ctCodigo.getText());
			if(boxModel.getSelectedItem().toString().equals("MORTE") || boxModel.getSelectedItem().toString().equals("VENDA")){
				ovino.setStatus("0");
			}else{
				ovino.setStatus("1");
			}		
			facade.updateOvino(ovino);		
		} catch (JECOException e) {			
			
		}
	}
	
	private boolean camposValidos(){		
		ctData.requestFocus();
		ctCusto.requestFocus();
		bSalvar.requestFocus();
		return  ctData.validar() & ctCusto.validar();
	}
	
	private class Action extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(bSalvar)) {    			
				try{  
					if(camposValidos()){
		    			oc.setCodigoOvino(ctCodigo.getText());
		    			oc.setTipo(boxModel.getSelectedItem().toString());
		    			oc.setDescricao(ctDescricao.getText());
		    			oc.setData(ctData.getText());
		    			float valor = Float.parseFloat(ctCusto.getText().replace(".", "").replace(",", "."));
		    			oc.setCusto(valor);
		    			atualizarStatus();
		    			facade.updateOcorrencia(oc);
		    			close();
		    			new JanelaInformacao("Salvo com sucesso",JanelaInformacao.SUCESSO);
					}else
						new JanelaInformacao("Verifique os campos invalidos",JanelaInformacao.ATENCAO);
				}catch(JECOException ex){
					JECOLogger.getInstance().log(ex);	
					new JanelaInformacao("Nao foi Possível salvar, procure o suporte ",JanelaInformacao.ERRO);
				}    			
    		}    		
    	}
	}
}
