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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ovino;
import com.jeco.Raca;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.Data;
import com.jeco.ui.auxilares.MyBoxModel;
import com.jeco.ui.butons.BtCancelar;
import com.jeco.ui.butons.BtSalvar;
import com.jeco.ui.validaFormulario.Campo;
import com.jeco.ui.validaFormulario.CampoCodigoGenitora;
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
public class JanelaEditarOvino extends PanelDefault {


	private static final long serialVersionUID = 1L;
	private JPanel painelSecundario;
	private JLabel rCodigo;
	private ButtonGroup grupoBotoes;
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
	
		
	public JanelaEditarOvino(Ovino ovino) {	
		super("ATUALIZAR DADOS DO OVINO", null);
		if(!(ovino == null)){
			this.ovino = ovino;
			try {
				actionListen= new ActionOvelha();
				facade = new JECOFacade();				
				showCombo();
				inicializaCamposCamposValidar();
				preencheCampos();				
				run();		
			} catch (JECOException e) {
				JECOLogger.getInstance().log(e);
				new JanelaInformacao("Erro no sistema, Por favor procure o suporte.",JanelaInformacao.ERRO);
			}
		}else 
			new JanelaInformacao("Ocorreu un problema, tente novamente. ",JanelaInformacao.ERRO);
	}
	
	private void initGUI() {
		try {				
			this.setSize(new java.awt.Dimension(620, 334));
			this.setLayout(null);
			this.setBackground(new java.awt.Color(153,180,209));
			this.setPreferredSize(new java.awt.Dimension(625, 334));
			{
				painelSecundario = new JPanel();
				this.add(painelSecundario);				
				painelSecundario.setBounds(25, 12, 576, 249);
				painelSecundario.setBorder(BorderFactory.createTitledBorder(null, "Dados do Ovino", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
				painelSecundario.setLayout(null);
				painelSecundario.setBackground(new java.awt.Color(153,180,209));
				{
					rCodigo = new JLabel();
					painelSecundario.add(rCodigo);
					rCodigo.setText("Codigo:");
					rCodigo.setBounds(32, 57, 55, 16);
					rCodigo.setFont(new java.awt.Font("Segoe UI",1,12));
				}			
				{
					
					painelSecundario.add(ctCodigo);
					ctCodigo.setBounds(99, 52, 123, 28);
				}}
		
				{
					rSexo = new JLabel();
					painelSecundario.add(rSexo);
					rSexo.setText("Sexo :");
					rSexo.setBounds(356, 57, 41, 16);
					rSexo.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					rGenitora = new JLabel();
					painelSecundario.add(rGenitora);
					rGenitora.setText("Genitora:");
					rGenitora.setBounds(29, 121, 58, 16);
					rGenitora.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					grupoBotoes = new ButtonGroup();
				}
				{
					bsMacho = new JRadioButton();
					painelSecundario.add(bsMacho);
					bsMacho.setText("Macho");
					bsMacho.setBounds(415, 56, 65, 18);
					grupoBotoes.add(bsMacho);
					bsMacho.setFont(new java.awt.Font("Segoe UI",1,12));
					bsMacho.setOpaque(false);
				}
				{
					bsFemea = new JRadioButton();
					painelSecundario.add(bsFemea);
					bsFemea.setText("Femea");
					bsFemea.setBounds(479, 56, 75, 18);
					grupoBotoes.add(bsFemea);
					bsFemea.setFont(new java.awt.Font("Segoe UI",1,12));
					bsFemea.setOpaque(false);
				}
				{
					
					painelSecundario.add(ctGenitora);
					ctGenitora.setBounds(99, 116, 123, 28);
				}
				{
					rPreco = new JLabel();
					painelSecundario.add(rPreco);
					rPreco.setText("Preço:");
					rPreco.setBounds(356, 186, 35, 16);
					rPreco.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					rDataNasc = new JLabel();
					painelSecundario.add(rDataNasc);
					rDataNasc.setText("Data de Admição:");
					rDataNasc.setBounds(29, 186, 97, 16);
					rDataNasc.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					
					painelSecundario.add(ctDataAdmc);
					ctPreco.setBounds(415, 181, 123, 28);
					ctDataAdmc.setBounds(138, 181, 82, 28);
				}
				{					
				painelSecundario.add(ctPreco);
				{
						rRaca = new JLabel();
						painelSecundario.add(rRaca);
						rRaca.setText("Raça: ");
						rRaca.setBounds(356, 121, 35, 16);
						rRaca.setFont(new java.awt.Font("Segoe UI",1,12));
				}
				{
					jComboBox = new JComboBox<String>();
					painelSecundario.add(jComboBox);
					jComboBox.setModel(boxModel);
					jComboBox.setBounds(415, 114, 124, 30);				
				}					
				}
			
			{
				bFechar = new BtCancelar();
				this.add(bFechar);
				
				bFechar.setBounds(389, 284, 101, 34);
				bFechar.addActionListener(actionListen);
			}
			{
				bGravar = new BtSalvar();
				this.add(bGravar);
				bGravar.setBounds(495, 284, 101, 34);
				bGravar.addActionListener(actionListen);
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
		ctCodigo = new Campo();		
		ctCodigo.setEditable(false);
		ctDataAdmc = new CampoData();
		ctDataAdmc.setText(Data.atual());
		this.initGUI();	
	}
	
	private void preencheCampos(){
		
		if(!(ovino == null)){	       
	        jComboBox.setSelectedItem(ovino.getRaca());
	    
	        ctDataAdmc.setText(ovino.getData());
	        ctGenitora.setText(ovino.getCodGenitora());
	        ctPreco.setText(NumberFormat.getCurrencyInstance().format(ovino.getPreco()).replace("R$", "").replace(",", "").replaceAll(" ", ""));
	        ctCodigo.setText(ovino.getCodigo());
	        
	        switch (ovino.getSexo()) {
				case "FEMEA":
					bsFemea.setSelected(true);
					break;					
				case "MACHO":
					 bsMacho.setSelected(true);
					break;					
				default:
					break;
			}	        
		}
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
			racas.add(ovino.getRaca());
			while (rc.hasNext()) {
				String raca = rc.next().getRacaName();
				if(!ovino.getRaca().equals(raca))
					racas.add(raca);				
			}
			boxModel = new MyBoxModel(racas.iterator());			
	}
	
	private void salvarOvino(){
		if(validar()&& !(ctCodigo.getText().equals(ctGenitora.getText().toUpperCase()))){
			try {
				ovino.setCodigo(ctCodigo.getText().toUpperCase());	        
		        ovino.setRaca(boxModel.getSelectedItem().toString());	        
		               	               
		        ovino.setSexo(escolheSexo());
		        ovino.setData(ctDataAdmc.getText());
		        if(ctGenitora.getText().length()==0)
		        	ovino.setCodGenitora("Desconhecido");
		        else
		        	ovino.setCodGenitora(ctGenitora.getText().toUpperCase());
		        	        
		        float preco = Float.parseFloat(ctPreco.getText().replace(".", "").replace(",", "."));
		        ovino.setPreco(preco);	        		        	
	    		facade.updateOvino(ovino);
	    		new JanelaInformacao("Atualizado com sucesso. ",JanelaInformacao.SUCESSO);    	
			} catch (JECOException e) {
				JECOLogger.getInstance().log(e);	
				new JanelaInformacao("Nao foi Possível salvar, procure o suporte ",JanelaInformacao.ERRO);
			}
		}else
			new JanelaInformacao("Por favor verifique o campos inválidos",JanelaInformacao.ATENCAO);
	}
	
	//Verifica se todos os campos sao validos.  
	public boolean validar(){
		return  ctDataAdmc.validar()  & ctGenitora.validar();
	}

	//classe que controla as acoes dos botoes
    private class ActionOvelha extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(bFechar)) {
    			close();
    		}else if(e.getSource().equals(bGravar)){    			
    			salvarOvino();    			
    		}
    	}
    }
}
