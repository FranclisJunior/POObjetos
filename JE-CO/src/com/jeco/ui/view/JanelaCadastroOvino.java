package com.jeco.ui.view;


import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ovino;
import com.jeco.Pesagem;
import com.jeco.Raca;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.Data;
import com.jeco.ui.auxilares.MyBoxModel;
import com.jeco.ui.butons.BtCancelar;
import com.jeco.ui.butons.BtNovo;
import com.jeco.ui.butons.BtSalvar;
import com.jeco.ui.controler.EnumNomeBotoes;
import com.jeco.ui.validaFormulario.Campo;
import com.jeco.ui.validaFormulario.CampoCodigoGenitora;
import com.jeco.ui.validaFormulario.CampoCodigoOvino;
import com.jeco.ui.validaFormulario.CampoData;
import com.jeco.ui.validaFormulario.CampoPeso;
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
public class JanelaCadastroOvino extends PanelDefault{	
	

	
	private static final long serialVersionUID = 1L;
	private JPanel painelSecundario;
	private JLabel rCodigo;
	private ButtonGroup grupoBotoes;
	private JButton bNovo;
	private JButton bGravar;
	private JButton bFechar;
	private Campo ctPreco;
	private Campo ctDataAdmc;
	private JLabel rDataNasc;
	private JLabel rPreco;
	private Campo ctGenitora;
	private JLabel rGenitora;
	private JRadioButton bsFemea;
	private JRadioButton bsMacho;
	private JLabel rSexo;
	private Campo ctCodigo;
	private JLabel rRaca;
	private ActionOvelha actionListen;
	private Ovino ovino;
	private JECOFacade facade;
	private MyBoxModel boxModel ;
	private JComboBox<String> jComboBox;
	
	
	
	public JanelaCadastroOvino() {
		super("CADASTRO DE OVINO", EnumNomeBotoes.CADASTRO_OVINO_CLOSE);
		this.ovino = new Ovino();
		try {
			actionListen= new ActionOvelha();
			facade = new JECOFacade();				
			showCombo();
			inicializaCamposCamposValidar();
			run();
		} catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
		}
	}

	
	private void initGUI() {
		try {	
			
			this.setPreferredSize(new java.awt.Dimension(620, 334));
			this.setSize(new java.awt.Dimension(620, 334));
			this.setLayout(null);
			this.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			this.setBackground(new java.awt.Color(153,180,209));
			this.setOpaque(true);
			{
				painelSecundario = new JPanel();
				this.add(painelSecundario);				
				painelSecundario.setBounds(25, 21, 571, 240);
				painelSecundario.setBorder(BorderFactory.createTitledBorder(null, "Dados do Ovino", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",1,12)));
				painelSecundario.setLayout(null);
				painelSecundario.setBackground(SystemColor.activeCaption);
				{
					rCodigo = new JLabel();
					painelSecundario.add(rCodigo);
					rCodigo.setText("Codigo:");
					rCodigo.setBounds(23, 59, 48, 16);
					rCodigo.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					
					painelSecundario.add(ctCodigo);
					ctCodigo.setBounds(81, 54, 123, 28);
				}
				}
				{
					rSexo = new JLabel();
					painelSecundario.add(rSexo);
					rSexo.setText("Sexo :");
					rSexo.setBounds(356, 59, 35, 16);
					rSexo.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					rGenitora = new JLabel();
					painelSecundario.add(rGenitora);
					rGenitora.setText("Genitora:");
					rGenitora.setBounds(23, 120, 58, 16);
					rGenitora.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					grupoBotoes = new ButtonGroup();
				}
				{
					bsMacho = new JRadioButton();
					painelSecundario.add(bsMacho);
					bsMacho.setText("Macho");
					bsMacho.setBounds(414, 59, 70, 18);
					grupoBotoes.add(bsMacho);
					bsMacho.setFont(new java.awt.Font("Segoe UI",1,12));
					bsMacho.setOpaque(false);
				}
				{
					bsFemea = new JRadioButton();
					painelSecundario.add(bsFemea);
					bsFemea.setText("Femea");
					bsFemea.setBounds(484, 58, 69, 18);
					grupoBotoes.add(bsFemea);
					bsFemea.setSelected(true);
					bsFemea.setFont(new java.awt.Font("Segoe UI",1,12));
					bsFemea.setOpaque(false);
				}
				{
					
					painelSecundario.add(ctGenitora);
					ctGenitora.setBounds(81, 115, 123, 28);
				}
				{
					rPreco = new JLabel();
					painelSecundario.add(rPreco);
					rPreco.setText("Preço:");
					rPreco.setBounds(356, 179, 35, 16);
					rPreco.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					rDataNasc = new JLabel();
					painelSecundario.add(rDataNasc);
					rDataNasc.setText("Data de Admição:");
					rDataNasc.setBounds(24, 179, 97, 16);
					rDataNasc.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					
					painelSecundario.add(ctDataAdmc);
					ctPreco.setBounds(421, 174, 123, 28);
					ctDataAdmc.setBounds(121, 174, 82, 28);
				}
				{
					
				painelSecundario.add(ctPreco);
				{
						rRaca = new JLabel();
						painelSecundario.add(rRaca);
						rRaca.setText("Raça: ");
						rRaca.setBounds(356, 120, 35, 16);
						rRaca.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					jComboBox = new JComboBox<String>();
					painelSecundario.add(jComboBox);
					jComboBox.setModel(boxModel);
					jComboBox.setBounds(421, 114, 123, 29);				
				}
					
				}
			
			{
				bFechar = new BtCancelar();
				this.add(bFechar);
				bFechar.setBounds(495, 282, 101, 32);
				bFechar.addActionListener(actionListen);
			}
			{
				bGravar = new BtSalvar();
				this.add(bGravar);
				bGravar.setBounds(389, 282, 101, 32);
				bGravar.addActionListener(actionListen);
			}
			{
				bNovo = new BtNovo();
				this.add(bNovo);
				bNovo.setBounds(283, 282, 101, 32);
				bNovo.addActionListener(actionListen);
			}			
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ",JanelaInformacao.ERRO);
		}
	}
	 
	private void inicializaCamposCamposValidar(){
		if(!(painelSecundario == null))
			painelSecundario.removeAll();
		this.removeAll();
		ctPreco = new CampoPreco();
		ctGenitora = new CampoCodigoGenitora();
		ctCodigo = new CampoCodigoOvino();		
		ctDataAdmc = new CampoData();
		ctDataAdmc.setText(Data.atual());	
		ctPreco.setText("0");
		
		this.initGUI();	
	}
	
	
	private void limparCampos(){  
        ctDataAdmc.setText(null);
        bsMacho.setSelected(false);
        bsFemea.setSelected(false);        
    }	
	
	//retorna o sexo conforme o selecionado
	public String escolheSexo() {			 
		if (bsMacho.isSelected())
			return "MACHO";			 
		else 
			return "FEMEA";
	}
	
	private void showCombo() throws JECOException{
		Iterator<Raca> rc = facade.buscaRaca().iterator();		
		List<String> racas = new LinkedList<String>();			
		while (rc.hasNext()) {
			racas.add(rc.next().getRacaName());				
		}
		boxModel = new MyBoxModel(racas.iterator());			
	}
	
	private void salvarOvino(){
		if(validar()){
			try {
				ovino.setCodigo(ctCodigo.getText().toUpperCase());	        
		        ovino.setRaca(boxModel.getSelectedItem().toString());	        
		        ovino.setSexo(escolheSexo());
		        ovino.setData(ctDataAdmc.getText());
		        if(ctGenitora.getText().length()==0)
		        	ovino.setCodGenitora("Desconhecido");
		        else
		        	ovino.setCodGenitora(ctGenitora.getText().toUpperCase());
		        
		        float preco = Float.parseFloat(ctPreco.getText().replace("." ,"").replace(",", "."));
		        ovino.setPreco(preco);		        	        		        	
		        if(facade.salvarOvino(ovino)){
	        		if(new JanelaConfirmacao("Salvo com sucesso. Deseja cadastrar outro? ").resposta()){
	        			limparCampos();
	        			inicializaCamposCamposValidar();
	        			ovino = new Ovino();
	        		}else 
	        			close();
		        }        	
			} catch (JECOException e) {
				JECOLogger.getInstance().log(e);	
				new JanelaInformacao("Nao foi Possível salvar, procure o suporte ",JanelaInformacao.ERRO);
			}
		}else
			new JanelaInformacao("Por favor verifique o campos inválidos",JanelaInformacao.ATENCAO);
	}
	
	//Verifica se todos os campos sao validos.  
	public boolean validar(){		
		ctDataAdmc.requestFocus();
		ctGenitora.requestFocus();			
		bGravar.requestFocus();
		return(ctDataAdmc.validar() & ctGenitora.validar() & ctCodigo.validar());
	}

	//classe que controla as acoes dos botoes
    private class ActionOvelha extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(bFechar)){ 
    			close();
    		}
    		else if(e.getSource().equals(bNovo)){    			
    			limparCampos();
    			inicializaCamposCamposValidar();
    			ctCodigo.requestFocus();    			
    		}else if(e.getSource().equals(bGravar))
    			salvarOvino();    		
    	}
    }
   
}
