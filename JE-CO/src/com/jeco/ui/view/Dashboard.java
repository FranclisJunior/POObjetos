package com.jeco.ui.view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ocorrencia;
import com.jeco.Ovino;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.auxilares.TableCria;
import com.jeco.ui.auxilares.TableOcorrencia;
import com.jeco.ui.auxilares.TableOvino;
import com.jeco.ui.validaFormulario.Campo;
import com.jeco.ui.validaFormulario.CampoCodigoExistente;


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
public class Dashboard extends JPanel{
	private JPanel informacoesDireita;
	private JPanel informacoesEsquerda;
	private JPanel menu;
	public JButton jBVisualizar;
	private JButton jButtPesquisar;
	private Campo jTextFPesquisarOvino;
	private JPanel jPanelOcorrencias;
	private JPanel jPanelCrias;
	private JPanel jPanelOvinos;
	private JButton jBTVisualizarGrafico;
	private JPanel jPPalco;
	private GraficoPeso graficoPeso;
	private JTable tabelaOcorrencias;
	private JTable tabelaCrias;
	private JTable tabelaOvinos;
	private TableOcorrencia ocrTableModel;
	private TableCria criaTableModel;
	private TableOvino ovinosTableModel;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JScrollPane scroll2;
	private JECOFacade facade;	
	private Action actionListener;
	private JLabel jLabelValorRaca;
	private JLabel jLabelValorPesoAtual;
	private JLabel jLabelValorValorAtual;
	private JLabel jLabelValorQuantCria;
	private JLabel jLabelValorSexo;
	private JLabel jLabelValorCod;
	private JLabel jLabelValor;
	private JLabel jLabelPesoatual;
	private JLabel jLabelQauntCrias;
	private JLabel jLabelRaca;
	private JLabel jLabSexo;
	private JLabel jLabelCod;
	private JPanel jPDadosDoOvino;
	private Dashboard dashboard;
	private Ovino ovino;
	
	
	public Dashboard(Ovino ovino) {
		this.ovino = ovino;
		
		init(ovino);
		
		facade = new JECOFacade();
		this.dashboard = this;
		atualizar();
		
	}
	private void init(Ovino ovino){
		actionListener = new Action();
		this.setPreferredSize(new java.awt.Dimension(800, 567));
		this.setSize(800, 567);
		
		BorderLayout jPMatherLayout = new BorderLayout();
		
		setLayout(jPMatherLayout);
		this.setBackground(new java.awt.Color(255,255,255));

			jPPalco = new JPanel();
			BorderLayout jPPalcoLayout = new BorderLayout();
			jPPalco.setLayout(jPPalcoLayout);
			add(jPPalco, BorderLayout.CENTER);
			jPPalco.setPreferredSize(new java.awt.Dimension(800, 562));
			jPPalco.setBackground(new java.awt.Color(255,255,255));
			{
				menu = new JPanel();
				menu.setLayout(null);
				jPPalco.add(menu, BorderLayout.NORTH);
				menu.setPreferredSize(new java.awt.Dimension(800, 44));
				menu.setBackground(new java.awt.Color(255,255,255));
				menu.setBorder(BorderFactory.createTitledBorder("Pesquisar por código"));
				{
					jBVisualizar = new JButton();
					menu.add(jBVisualizar);
					jBVisualizar.setText("Visualizar em outra Janela");
					jBVisualizar.setPreferredSize(new java.awt.Dimension(211, 24));
					jBVisualizar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/openewWindow.png")));
					jBVisualizar.setBounds(575, 14, 211, 24);
					jBVisualizar.addActionListener(actionListener);
				}
				{
					jButtPesquisar = new JButton();
					menu.add(jButtPesquisar);
					jButtPesquisar.setBounds(116, 15, 84, 23);
					jButtPesquisar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/pesquisa.png")));
					jButtPesquisar.addActionListener(actionListener);
				}
				{
					jTextFPesquisarOvino = new CampoCodigoExistente();
					menu.add(jTextFPesquisarOvino);
					jTextFPesquisarOvino.setPreferredSize(new java.awt.Dimension(84, 23));
					jTextFPesquisarOvino.setBounds(27, 16, 84, 23);
				}
			}
			{
				informacoesDireita = new JPanel();
				BorderLayout informacoesDireitaLayout = new BorderLayout();
				informacoesDireita.setLayout(informacoesDireitaLayout);
				jPPalco.add(informacoesDireita, BorderLayout.EAST);
				informacoesDireita.setPreferredSize(new java.awt.Dimension(392, 458));
				informacoesDireita.setBackground(new java.awt.Color(255,255,255));
				informacoesDireita.setSize(392, 436);
				informacoesDireita.setBorder(BorderFactory.createTitledBorder(""));
				{
					graficoPeso = new GraficoPeso(ovino);
					informacoesDireita.add(graficoPeso, BorderLayout.CENTER);
					
				}
				{
					jPanelOcorrencias = new JPanel();
					BorderLayout jPanelOcorrenciasLayout = new BorderLayout();
					jPanelOcorrencias.setLayout(jPanelOcorrenciasLayout);
					informacoesDireita.add(jPanelOcorrencias, BorderLayout.SOUTH);
					jPanelOcorrencias.setPreferredSize(new java.awt.Dimension(390, 159));
					jPanelOcorrencias.setBackground(new java.awt.Color(255,255,255));
					jPanelOcorrencias.setBorder(BorderFactory.createTitledBorder("Ocorrencias deste ovino"));
				}
				{
					scroll = new JScrollPane();					
					scroll.setBounds(14, 28, 377, 280);
					scroll.setPreferredSize(new java.awt.Dimension(226, 131));
					scroll.setBackground(new java.awt.Color(255,255,255));
					ocrTableModel = new TableOcorrencia();
					tabelaOcorrencias = new JTable();
					jPanelOcorrencias.add(tabelaOcorrencias);
					tabelaOcorrencias.setModel(ocrTableModel);
					tabelaOcorrencias.setBounds(13, 49, 392, 53);
					tabelaOcorrencias.addMouseListener(actionListener);
					tabelaOcorrencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
					scroll.setViewportView(tabelaOcorrencias);
					jPanelOcorrencias.add(scroll);

				}
				
				
				
			}
			{
				informacoesEsquerda = new JPanel();
				jPPalco.add(informacoesEsquerda, BorderLayout.WEST);
				informacoesEsquerda.setPreferredSize(new java.awt.Dimension(392, 458));
				informacoesEsquerda.setBackground(new java.awt.Color(255,255,255));
				informacoesEsquerda.setSize(392, 436);
				informacoesEsquerda.setBorder(BorderFactory.createTitledBorder(""));
				{
					jPDadosDoOvino = new JPanel();
					
					jPDadosDoOvino.setLayout(null);
					informacoesEsquerda.add(jPDadosDoOvino);
					jPDadosDoOvino.setPreferredSize(new java.awt.Dimension(386, 88));
					jPDadosDoOvino.setForeground(new java.awt.Color(117,58,0));
					jPDadosDoOvino.setBackground(new java.awt.Color(170,213,213));
					jPDadosDoOvino.setBorder(BorderFactory.createTitledBorder("Dados do Ovino Selecionado"));
					{
						jLabelQauntCrias = new JLabel();
						jPDadosDoOvino.add(jLabelQauntCrias);
						jLabelQauntCrias.setText("Quant.Crias:");
						jLabelQauntCrias.setBounds(254, 13, 84, 22);
						jLabelQauntCrias.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelQauntCrias.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabelRaca = new JLabel();
						jPDadosDoOvino.add(jLabelRaca);
						jLabelRaca.setText("Raça:");
						jLabelRaca.setBounds(12, 62, 40, 20);
						jLabelRaca.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelRaca.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabSexo = new JLabel();
						jPDadosDoOvino.add(jLabSexo);
						jLabSexo.setText("Sexo:");
						jLabSexo.setBounds(129, 12, 45, 24);
						jLabSexo.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabSexo.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabelCod = new JLabel();
						jPDadosDoOvino.add(jLabelCod);
						jLabelCod.setText("Código:");
						jLabelCod.setBounds(12, 13, 57, 22);
						jLabelCod.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelCod.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabelPesoatual = new JLabel();
						jPDadosDoOvino.add(jLabelPesoatual);
						jLabelPesoatual.setText("Peso Atual:");
						jLabelPesoatual.setBounds(13, 41, 88, 16);
						jLabelPesoatual.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelPesoatual.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabelValor = new JLabel();
						jPDadosDoOvino.add(jLabelValor);
						jLabelValor.setText("Valor Atual :");
						jLabelValor.setBounds(174, 41, 93, 16);
						jLabelValor.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelValor.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabelValorCod = new JLabel();
						jPDadosDoOvino.add(jLabelValorCod);
						jLabelValorCod.setText("00");
						jLabelValorCod.setBounds(66, 16, 63, 16);
						jLabelValorCod.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelValorCod.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabelValorSexo = new JLabel();
						jPDadosDoOvino.add(jLabelValorSexo);
						jLabelValorSexo.setText("sexo");
						jLabelValorSexo.setBounds(168, 16, 81, 16);
						jLabelValorSexo.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelValorSexo.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabelValorQuantCria = new JLabel();
						jPDadosDoOvino.add(jLabelValorQuantCria);
						jLabelValorQuantCria.setText("0");
						jLabelValorQuantCria.setBounds(338, 16, 43, 16);
						jLabelValorQuantCria.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelValorQuantCria.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabelValorValorAtual = new JLabel();
						jPDadosDoOvino.add(jLabelValorValorAtual);
						jLabelValorValorAtual.setBounds(279, 38, 75, 23);
						jLabelValorValorAtual.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelValorValorAtual.setForeground(new java.awt.Color(0,64,128));
						
					}
					{
						jLabelValorPesoAtual = new JLabel();
						jPDadosDoOvino.add(jLabelValorPesoAtual);
						jLabelValorPesoAtual.setText("0.0");
						jLabelValorPesoAtual.setBounds(95, 41, 37, 16);
						jLabelValorPesoAtual.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelValorPesoAtual.setForeground(new java.awt.Color(0,64,128));
					}
					{
						jLabelValorRaca = new JLabel();
						jPDadosDoOvino.add(jLabelValorRaca);
						jLabelValorRaca.setText("Não informada");
						jLabelValorRaca.setBounds(70, 64, 304, 16);
						jLabelValorRaca.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelValorRaca.setForeground(new java.awt.Color(0,64,128));
					}
				}
			}
			{
				jPanelCrias = new JPanel();
				BorderLayout jPanelCriasLayout = new BorderLayout();
				jPanelCrias.setLayout(jPanelCriasLayout);
				informacoesEsquerda.add(jPanelCrias, BorderLayout.SOUTH);
				jPanelCrias.setPreferredSize(new java.awt.Dimension(390, 159));
				jPanelCrias.setBackground(new java.awt.Color(255,255,255));
				jPanelCrias.setBorder(BorderFactory.createTitledBorder("Crias deste ovino"));
			}
			{
				scroll = new JScrollPane();					
				scroll.setBounds(14, 28, 377, 280);
				scroll.setPreferredSize(new java.awt.Dimension(226, 131));
				scroll.setBackground(new java.awt.Color(255,255,255));
				criaTableModel = new TableCria();
				tabelaCrias = new JTable();
				jPanelCrias.add(tabelaCrias );
				tabelaCrias.setModel(criaTableModel);
				tabelaCrias.setBounds(13, 49, 392, 53);
				tabelaCrias.addMouseListener(actionListener);
				tabelaCrias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
				scroll.setViewportView(tabelaCrias);
				tabelaCrias.setPreferredSize(new java.awt.Dimension(377, 110));
				jPanelCrias.add(scroll);
				

			}
			{
				
				jPanelOvinos = new JPanel();
				BorderLayout jPanelOvinosLayout = new BorderLayout();
				jPanelOvinos.setLayout(jPanelOvinosLayout);
				informacoesEsquerda.add(jPanelOvinos, BorderLayout.SOUTH);
				jPanelOvinos.setPreferredSize(new java.awt.Dimension(390, 256));
				jPanelOvinos.setBackground(new java.awt.Color(255,255,255));
				jPanelOvinos.setBorder(BorderFactory.createTitledBorder("Ovinos cadastrados"));
			}
			{
				
				scroll2 = new JScrollPane();					
				scroll2.setBounds(14, 28, 377, 280);
				scroll2.setPreferredSize(new java.awt.Dimension(226, 131));
				scroll2.setBackground(new java.awt.Color(255,255,255));
				ovinosTableModel = new TableOvino();
				tabelaOvinos = new JTable();
				jPanelOvinos.add(tabelaOvinos );
				tabelaOvinos.setModel(ovinosTableModel);
				tabelaOvinos.setBounds(13, 49, 392, 53);
				tabelaOvinos.addMouseListener(actionListener);
				tabelaOvinos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
				scroll2.setViewportView(tabelaOvinos);
				tabelaOvinos.setPreferredSize(new java.awt.Dimension(377, 206));
				jPanelOvinos.add(scroll2);
				

			}
			{
				jBTVisualizarGrafico = new JButton();
				informacoesDireita.add(jBTVisualizarGrafico, BorderLayout.NORTH);
				jBTVisualizarGrafico.setText("Visualizar grafico em uma nova janela");
				jBTVisualizarGrafico.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/openewWindow.png")));
				jBTVisualizarGrafico.setPreferredSize(new java.awt.Dimension(390, 24));
				jBTVisualizarGrafico.addActionListener(actionListener);
			}
	}
	
	
	
	private void  atualizar(){//carrega os paineis com od dados do ovino
		int quantcrias=0;
		float valorAtual = 0 ;
		informacoesDireita.remove(graficoPeso);
		informacoesDireita.repaint();
		informacoesDireita.revalidate();
		graficoPeso = new GraficoPeso(ovino);
		informacoesDireita.add(graficoPeso);
		informacoesDireita.repaint();
		informacoesDireita.revalidate();
		
		
		try {
			if(!(ovino == null)){
				ocrTableModel.limpar();
				criaTableModel.limpar();
				ovinosTableModel.limpar();
				List<Ocorrencia>  lOc =facade.buscarOcorrencias();
				if(!lOc.isEmpty()){
					for(Ocorrencia ocorrencia: lOc ){
						if(ocorrencia.getCodigoOvino().equals(ovino.getCodigo())){
							ocrTableModel.add(ocorrencia);
							valorAtual+=ocorrencia.getCusto();
							tabelaOcorrencias.addRowSelectionInterval(0,0);
						}
					}
				}
				List<Ovino> lCrias =  facade.buscaCrias(ovino.getCodigo());
				if(!lCrias.isEmpty()){
					for(Ovino ovi : lCrias){
						quantcrias++;
						criaTableModel.add(ovi);
						tabelaCrias.addRowSelectionInterval(0,0);						
					}
				}
				List<Ovino> lOvinos =  facade.buscaTodosOvino();
				if(!lOvinos.isEmpty()){
					for(Ovino ovin:lOvinos){					
						ovinosTableModel.add(ovin);
						tabelaOvinos.addRowSelectionInterval(0,0);				
					}
				}
				jLabelValorCod.setText(ovino.getCodigo());
				if(ovino.getHistoricoPesos().size()>0)
					jLabelValorPesoAtual.setText(String.valueOf(ovino.getHistoricoPesos().get(ovino.getHistoricoPesos().size()-1).getPeso()));
				jLabelValorQuantCria.setText(String.valueOf(quantcrias));
				jLabelValorRaca.setText(ovino.getRaca());
				jLabelValorSexo.setText(ovino.getSexo());
				valorAtual+=ovino.getPreco();
				
				setavalor(NumberFormat.getCurrencyInstance().format(valorAtual));
			}
			
		} catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			
		}
	}
	private  void setavalor(String valor){
		
		jLabelValorValorAtual.setText(valor);
		

	}
	
	public void ocultarbotao(){//oculta o botao de visualizar quando abrir em uma nova janela
		this.jBVisualizar.setEnabled(false);
	}
	
	private class Action extends MouseAdapter implements ActionListener{

    	@Override
    	public void actionPerformed(ActionEvent e) {    		
    		if(e.getSource().equals(jBTVisualizarGrafico)) { 
    			GraficoPeso grafico = new GraficoPeso(ovino);
    			grafico.setSize(850, 600);
    			
    			new JanelaPadrao("Gráfico de Peso Ovino "+ovino.getCodigo(), grafico);
    		}
    		if(e.getSource().equals(jButtPesquisar)&& jTextFPesquisarOvino.validar()) {
    			try {
    				ovino  = facade.buscaOvino(jTextFPesquisarOvino.getText().toUpperCase());
    				atualizar();
					
				} catch (JECOException e1) {
					JECOLogger.getInstance().log(e1);
				}
    			
    		}
    		if(e.getSource().equals(jBVisualizar)) {
    			dashboard = new Dashboard(ovino);
    			dashboard.ocultarbotao();
    			new JanelaPadrao("Dashboard",dashboard );
    		} 
    		
    		 
    	}
    	
    	
    	public void mouseClicked(java.awt.event.MouseEvent e) {
            if ( e.getClickCount() == 2 && e.getComponent().equals(tabelaCrias)) {
            	if(tabelaCrias.getRowCount()!=0){
            		Ovino ovin = criaTableModel.get( tabelaCrias.getSelectedRow()) ;            	
            		new JanelaPadrao("Dados do ovino  "+ovin.getCodigo(),new Dashboard(ovin) );
            	}
            }
            else if ( e.getClickCount() == 2 && e.getComponent().equals(tabelaOvinos)) {
            	if(tabelaOvinos.getRowCount()!=0){
            		Ovino ovin = ovinosTableModel.get( tabelaOvinos.getSelectedRow()) ;            	
            		new JanelaPadrao("Dados do ovino  "+ovin.getCodigo(),new Dashboard(ovin) );
            	}
            }
            else if ( e.getClickCount() == 2 && e.getComponent().equals(tabelaOcorrencias)) {
            	if(tabelaOcorrencias.getRowCount()!=0){
            		Ocorrencia oc = ocrTableModel.get( tabelaOcorrencias.getSelectedRow());
            		new JanelaEditarOcorrencia(oc);
            	}
            }
    	}    
    	
    	
	}
	
	
	
	

}
