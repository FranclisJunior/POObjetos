package com.jeco.ui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ocorrencia;
import com.jeco.OcorrenciaTipo;
import com.jeco.Ovino;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.Data;
import com.jeco.ui.auxilares.MyBoxModel;
import com.jeco.ui.butons.BtCancelar;
import com.jeco.ui.butons.BtNovo;
import com.jeco.ui.butons.BtSalvar;
import com.jeco.ui.butons.BtView;
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
public class JanelaAddOcorrencia extends PanelDefault  {

	
	private static final long serialVersionUID = 1L;
	private CampoCodigoExistente ctCodigo;
	private JLabel rCodigo;
	private JButton bFechar;
	private CampoData ctData;
	private JButton bVerRegistros;
	private JButton bCriarNovaOC;
	private JButton bSalvar;
	private JComboBox<String> comboBox;
	private JLabel rOcorrencia;
	private JPanel painelSecundario;
	private MyBoxModel boxModel;
	private JECOFacade facade;	
	private Action actionListener;
	private CampoPreco ctValor;
	private JLabel rValor;
	private JLabel rData;
	private JTextArea ctDescricao;
	private JLabel rDescricao;
	private javax.swing.JScrollPane scroll;
	

	
	public JanelaAddOcorrencia() {
		super("CADASTRAR OCORRENCIA", EnumNomeBotoes.CADASTRO_OCORRENCIA_CLOSE);
		facade = new JECOFacade();
		actionListener = new Action();
		showComboBox();
		inicializarCampos();
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
			this.setPreferredSize(new java.awt.Dimension(599, 334));
			this.setSize(599, 334);
			this.setLayout(null);
			{
				painelSecundario = new JPanel();
				this.add(painelSecundario);
				painelSecundario.setBounds(12, 12, 400, 310);
				painelSecundario.setLayout(null);
				painelSecundario.setBorder(BorderFactory.createTitledBorder("Adicionar Ocorrencia"));
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
					rOcorrencia.setBounds(234, 22, 82, 16);
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
						rValor = new JLabel();
						painelSecundario.add(rValor);
						rValor.setText("Valor: ");
						rValor.setBounds(234, 81, 45, 16);
						rValor.setFont(new java.awt.Font("Segoe UI",1,12));
					}
					{						
						painelSecundario.add(ctValor);
						ctValor.setBounds(227, 97, 156, 28);
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
			{
				bCriarNovaOC = new BtNovo();
				this.add(bCriarNovaOC);
				bCriarNovaOC.setText("Novo Tipo Ocorrencia");
				bCriarNovaOC.setBounds(428, 53, 161, 32);
				bCriarNovaOC.setToolTipText("Criar novo tipo de ocorrencia");
				bCriarNovaOC.addActionListener(actionListener);
			}
			{
				bVerRegistros = new BtView();
				this.add(bVerRegistros);
				bVerRegistros.setText("Ver Registros");
				bVerRegistros.setBounds(428, 106, 161, 32);
				bVerRegistros.setToolTipText("Ver Registros de Ocorrencias");
				bVerRegistros.addActionListener(actionListener);
			}
			{
				bFechar = new BtCancelar();
				this.add(bFechar);
				bFechar.setText("Cancelar");
				bFechar.setBounds(428, 278, 161, 32);
				bFechar.addActionListener(actionListener);
			}
			{
				bSalvar = new BtSalvar();
				this.add(bSalvar);
				bSalvar.setBounds(428, 154, 161, 32);
				bSalvar.addActionListener(actionListener);
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}
	
	public void inicializarCampos(){
		if(!(painelSecundario == null))
			painelSecundario.removeAll();
		this.removeAll();		
		ctDescricao = new JTextArea();
		ctDescricao.setPreferredSize(new java.awt.Dimension(235, 75));
		ctData = new CampoData();
		ctCodigo = new CampoCodigoExistente();
		ctData.setText(Data.atual());
		ctValor = new CampoPreco();
		ctValor.setText("0");
		this.initGUI();	
	}
	
	private boolean camposValidos(){
		ctCodigo.requestFocus();
		ctData.requestFocus();
		ctValor.requestFocus();
		bSalvar.requestFocus();
		return ctCodigo.validar() & ctData.validar() & ctValor.validar();
	}
	
	private void limparCampos(){
		ctCodigo.setText(null);
		ctDescricao.setText(null);		
	}
	
	
	private void atualizarStatus(){
		try {
			Ovino ovino = facade.buscaOvino(ctCodigo.getText().toUpperCase());
			if(boxModel.getSelectedItem().toString().equals("MORTE")){
				ovino.setStatus("0");
			}
			if(boxModel.getSelectedItem().toString().equals("VENDA")){
				ovino.setStatus("0");
			}
			facade.updateOvino(ovino);		
		} catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}
	
	private class Action extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(bSalvar)) {    			
    			if(camposValidos()){
    				try{    			   				
		    			Ocorrencia oc = new Ocorrencia();
		    			oc.setCodigoOcr(null);
		    			oc.setCodigoOvino(ctCodigo.getText().toUpperCase());
		    			oc.setTipo(boxModel.getSelectedItem().toString());
		    			oc.setDescricao(ctDescricao.getText());
		    			oc.setData(ctData.getText());
		    			float valor = Float.parseFloat(ctValor.getText().replace("." ,"").replace(",", "."));
		    			oc.setCusto(valor);
		    			atualizarStatus();
		    			facade.salvarOcorrencia(oc);
		    			new JanelaInformacao("Salvo com sucesso",JanelaInformacao.SUCESSO);
		    			limparCampos();
    				}catch(JECOException ex){
    					JECOLogger.getInstance().log(ex);	
    					new JanelaInformacao("Nao foi Possível salvar, procure o suporte ",JanelaInformacao.ERRO);
    				}
    			}else{
    				new JanelaInformacao("Por favor, Verifique os campos invalidos",JanelaInformacao.ATENCAO);
    			}
    		}
    		if(e.getSource().equals(bCriarNovaOC)) {
    			new JanelaCriarOcorrenciaTipo();
    		}
    		if(e.getSource().equals(bVerRegistros)) {
    			new JanelaOcorrenciasCadastradas();
    		}  
    		if(e.getSource().equals(bFechar)) {
    			close();
    		} 
    	}
	}
}
