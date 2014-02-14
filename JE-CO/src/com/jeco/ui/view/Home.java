package com.jeco.ui.view;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.jeco.Ovino;
import com.jeco.Usuario;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.butons.SeparadorDeBotao;
import com.jeco.ui.controler.ControlEvent;
import com.jeco.ui.controler.ControlerHome;
import com.jeco.ui.controler.ControlerHomeListener;
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
public class Home extends JFrame {
	
	private JSeparator jSeparator1;
	private JButton butCadastroOvino;
	private JButton butSair;
	private JButton butPeso;
	private JButton butOcorrencia;
	private JButton buCadTipoOcorrencia;
	private JButton butRaca;
	private JButton butVisualizarOvino ;
	private JButton butVisualizarOcorrencia ;
	private JButton butVisualizarPeso ;
	private	JButton butVisualizarEventos;
	private JButton butUsuario;
	public static Usuario user;
	private JButton butConfig;
	private JButton butBackup;
	private JToolBar toolBar3_Outros;
	private JToolBar toolBar2_Exibir;
	private JToolBar toolBar1_Principal;
	private List<ControlerHomeListener> listeners;
	private JPanel rodape;
	private JPanel jPanelMenuSuper;
	private JPanel jPanelMenuOutros;
	private JPanel jPanelMenuExibir;
	private JPanel jPanelMenuCadastros;
	private JPanel jPanelDashboard;
	private JLabel jLabelLogado;
	private JPanel dashBoard;
	private JTabbedPane jTabbedPane1;
	private List<Ovino> ovinos;
	
	
	
	public Home(List<Ovino> ovinos) {
		this.ovinos = ovinos;
		this.setPreferredSize(new java.awt.Dimension(900, 670));
		this.setSize(900, 670);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			jTabbedPane1 = new JTabbedPane();
			getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
			jTabbedPane1.setPreferredSize(new java.awt.Dimension(884, 609));
			
			jPanelDashboard = new JPanel();
			jTabbedPane1.addTab("Dashboard", null, jPanelDashboard, null);
			
			jPanelMenuCadastros = new JPanel();
			jTabbedPane1.addTab("Cadastrar", null, jPanelMenuCadastros, null);
			
			jPanelMenuExibir = new JPanel();
			jTabbedPane1.addTab("Exibir", null, jPanelMenuExibir, null);
						
			jPanelMenuOutros = new JPanel();
			jTabbedPane1.addTab("Outros", null, jPanelMenuOutros, null);
			{				
				BorderLayout jPanelDashboardLayout = new BorderLayout();
				jPanelDashboard.setLayout(jPanelDashboardLayout);				
				jPanelDashboard.setPreferredSize(new java.awt.Dimension(879, 587));
				{
					dashBoard = new Dashboard(ControlerHome.ovinoComMaiorPeso());
					jPanelDashboard.add(dashBoard, BorderLayout.CENTER);
					dashBoard.setPreferredSize(new java.awt.Dimension(879, 598));
					dashBoard.setBackground(new java.awt.Color(255,255,255));
				}
			}
			{				
				BorderLayout jpanelMenuExibirLayout = new BorderLayout();
				jPanelMenuExibir.setLayout(jpanelMenuExibirLayout);
				
			}
			{				
				BorderLayout jPanelMenuCadastrosLayout = new BorderLayout();
				jPanelMenuCadastros.setLayout(jPanelMenuCadastrosLayout);
				{
					
					BorderLayout jPanelMenuOutrosLayout = new BorderLayout();
					jPanelMenuOutros.setLayout(jPanelMenuOutrosLayout);
					
					{
						toolBar1_Principal = new JToolBar();
						jPanelMenuCadastros.add(toolBar1_Principal, BorderLayout.NORTH);
						toolBar1_Principal.setBorderPainted(false);
						toolBar1_Principal.setBackground(SystemColor.activeCaption);
						toolBar1_Principal.setFloatable(true);
						toolBar1_Principal.setRollover(true);
						toolBar1_Principal.setPreferredSize(new java.awt.Dimension(879, 79));
						{
							butCadastroOvino = new JButton();
							toolBar1_Principal.add(butCadastroOvino);
							butCadastroOvino.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ovino", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butCadastroOvino.setToolTipText("Cadastrar Ovino");
							butCadastroOvino.setIcon(new ImageIcon(Home.class.getResource("/com/jeco/image/Sheep.png")));
							butCadastroOvino.addActionListener(new eventosListener());
						}
						{
							toolBar1_Principal.add(new SeparadorDeBotao());
						}
						{
							butPeso = new JButton("");
							toolBar1_Principal.add(butPeso);
							butPeso.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pesagem", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butPeso.setIcon(new ImageIcon(Home.class.getResource("/com/jeco/image/balance.png")));
							butPeso.addActionListener(new eventosListener());
							butPeso.setToolTipText("Cadastrar Pesagem");							
						}
						{
							toolBar1_Principal.add(new SeparadorDeBotao());
						}
						{
							butRaca = new JButton();
							toolBar1_Principal.add(butRaca);
							butRaca.setIcon(new ImageIcon(Home.class.getResource("/com/jeco/image/racas.png")));
							butRaca.setBorder(new TitledBorder(null, "Ra\u00E7a", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butRaca.addActionListener(new eventosListener());
							butRaca.setToolTipText("Cadastrar Raça");
						}
						{
							
							toolBar1_Principal.add(new SeparadorDeBotao());
							
						}
						{
							butOcorrencia = new JButton();
							toolBar1_Principal.add(butOcorrencia);
							butOcorrencia.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/iWarning.png")));
							butOcorrencia.setBorder(new TitledBorder(null, "Ocorr\u00EAncia", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butOcorrencia.addActionListener(new eventosListener());
							butOcorrencia.setToolTipText("Cadastrar Ocorrencia");
						}
						{
							jSeparator1 = new JSeparator();
							toolBar1_Principal.add(jSeparator1);
							jSeparator1.setOrientation(SwingConstants.VERTICAL);
							jSeparator1.setMaximumSize(new java.awt.Dimension(3356, 0));
							
						}
					{
					toolBar2_Exibir = new JToolBar();
					jPanelMenuExibir.add(toolBar2_Exibir, BorderLayout.NORTH);
					toolBar2_Exibir.setBorderPainted(false);
					toolBar2_Exibir.setBackground(new java.awt.Color(128,191,255));
					toolBar2_Exibir.setSize(124, 79);		
					toolBar2_Exibir.setPreferredSize(new java.awt.Dimension(879, 79));
						
						{
							butVisualizarOvino = new JButton("");
							butVisualizarOvino.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/_Sheep.png")));
							butVisualizarOvino.setBorder(new TitledBorder(null, "Ovinos", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butVisualizarOvino.addActionListener(new eventosListener());
							butVisualizarOvino.setToolTipText("Ovinos Cadastrados");
							toolBar2_Exibir.add(butVisualizarOvino);
						}
						toolBar2_Exibir.add(new SeparadorDeBotao());
						{
							butVisualizarOcorrencia= new JButton("");
							butVisualizarOcorrencia.setBorder(new TitledBorder(null, "Ocorrencias", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butVisualizarOcorrencia.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/iWarning.png")));
							butVisualizarOcorrencia.setToolTipText("Ocorrencias Cadastradas");
							butVisualizarOcorrencia.addActionListener(new eventosListener());
							toolBar2_Exibir.add(butVisualizarOcorrencia);
						}
						toolBar2_Exibir.add(new SeparadorDeBotao());
						{
							butVisualizarPeso = new JButton("");
							butVisualizarPeso.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/balance.png")));
							butVisualizarPeso.setBorder(new TitledBorder(null, "Pesagens", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butVisualizarPeso.addActionListener(new eventosListener());
							butVisualizarPeso.setToolTipText("Pesos Cadastrados");
							toolBar2_Exibir.add(butVisualizarPeso);
						}
						toolBar2_Exibir.add(new SeparadorDeBotao());
						{
							butVisualizarEventos = new JButton("");
							butVisualizarEventos.setIcon(new ImageIcon(Home.class.getResource("/com/jeco/image/report.png")));
							butVisualizarEventos.setBorder(new TitledBorder(null, "Eventos", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butVisualizarEventos.addActionListener(new eventosListener());
							butVisualizarEventos.setToolTipText("Visualizar Eventos");
							toolBar2_Exibir.add(butVisualizarEventos);
						}
					}
					{					
					toolBar3_Outros = new JToolBar();
					jPanelMenuOutros.add(toolBar3_Outros, BorderLayout.NORTH);
					toolBar3_Outros.setBorderPainted(false);
					toolBar3_Outros.setBackground(new java.awt.Color(166,210,255));	
					toolBar3_Outros.setSize(124, 79);
					toolBar3_Outros.setPreferredSize(new java.awt.Dimension(879, 79));
						
						{
							butUsuario = new JButton("");
							butUsuario.setBorder(new TitledBorder(null, "Usu\u00E1rio", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butUsuario.setIcon(new ImageIcon(Home.class.getResource("/com/jeco/image/user.png")));
							butUsuario.setToolTipText("Cadastrar Usuario");
							butUsuario.addActionListener(new eventosListener());
							toolBar3_Outros.add(butUsuario);
						}
						toolBar3_Outros.add(new SeparadorDeBotao());
						{
							butBackup = new JButton("");
							butBackup.setIcon(new ImageIcon(Home.class.getResource("/com/jeco/image/db.png")));
							butBackup.setBorder(new TitledBorder(null, "Banco de Dados", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							toolBar3_Outros.add(butBackup);
							butBackup.setFont(new java.awt.Font("Segoe UI",0,11));
							butBackup.addActionListener(new eventosListener());								
						}
						toolBar3_Outros.add(new SeparadorDeBotao());
						{
							butConfig = new JButton("");
							butConfig.setBorder(new TitledBorder(null, "Config. Sistema", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							butConfig.setIcon(new ImageIcon(Home.class.getResource("/com/jeco/image/Preferences-System-64.png")));
							butConfig.setToolTipText("Configura\u00E7oes");
							toolBar3_Outros.add(butConfig);	
						}
						toolBar3_Outros.add(new SeparadorDeBotao());
						{
							buCadTipoOcorrencia = new JButton("");
							buCadTipoOcorrencia.setBorder(new TitledBorder(null, "Tipo Ocorrência", TitledBorder.CENTER, TitledBorder.BELOW_BOTTOM, null, null));
							buCadTipoOcorrencia.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/iWarning.png")));
							buCadTipoOcorrencia.setToolTipText("Cadastrar tipo de ocorrencia");
							buCadTipoOcorrencia.addActionListener(new eventosListener());
							toolBar3_Outros.add(buCadTipoOcorrencia);
						}
					
					}
						
					}
				}
			}		
			{
				this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				setLocationRelativeTo(null);			
				this.setVisible(true);
				
			}
		}
		{
			rodape = new JPanel();
			getContentPane().add(rodape, BorderLayout.SOUTH);
			rodape.setPreferredSize(new java.awt.Dimension(784, 22));
			rodape.setBackground(new java.awt.Color(244,255,244));
			{
				jLabelLogado = new JLabel();
				rodape.add(jLabelLogado);
				if(!(user==null)){
					jLabelLogado.setText("Logado como: "+ user.getNome());
				}else
					jLabelLogado.setText("Logado como: Anônimo ");
				jLabelLogado.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/logado.png")));
				jLabelLogado.setPreferredSize(new java.awt.Dimension(777, 17));
				jLabelLogado.setFont(new java.awt.Font("Segoe UI",0,14));
				jLabelLogado.setHorizontalAlignment(SwingConstants.CENTER);
				jLabelLogado.setForeground(new java.awt.Color(128,128,128));
			}
		}
		{
			jPanelMenuSuper = new JPanel();
			BorderLayout jPanelMenuSuperLayout = new BorderLayout();
			jPanelMenuSuper.setLayout(jPanelMenuSuperLayout);
			getContentPane().add(jPanelMenuSuper, BorderLayout.NORTH);
			jPanelMenuSuper.setPreferredSize(new java.awt.Dimension(884, 21));
			jPanelMenuSuper.setBackground(new java.awt.Color(232,243,255));
			{
				butSair = new JButton();
				jPanelMenuSuper.add(butSair, BorderLayout.EAST);
				butSair.setToolTipText("Sair do Sistema");
				butSair.setPreferredSize(new java.awt.Dimension(163, 21));
				butSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/botao-sair.jpg")));
				butSair.addActionListener(new eventosListener());
			}
		}
		listeners = new LinkedList<>();
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/logoTipo_64X64.png"));
		this.setIconImage(icon.getImage());
		initGUI();
	}
	
	private void initGUI() {
		try {
			listeners = new LinkedList<>();
		} catch(Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro grave no sistema, Por favor procure o suporte. ",JanelaInformacao.ERRO);
		}
	}
	public void add(ControlerHomeListener listner){
		listeners.add(listner);
	}
	
	private void enviarListeners(ControlEvent ev){
		for(ControlerHomeListener lis: listeners)
			lis.event(ev);
	}	
	
	private class eventosListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(butCadastroOvino))				
				enviarListeners(new ControlEvent(butCadastroOvino, EnumNomeBotoes.CADASTRO_OVINO, 1));
						
			else if(e.getSource().equals(butOcorrencia))
				enviarListeners(new ControlEvent(butOcorrencia, EnumNomeBotoes.CADASTRO_OCORRENCIA, 5));
			
			else if(e.getSource().equals(butPeso))
				enviarListeners(new ControlEvent(butPeso, EnumNomeBotoes.CADASTRO_PESO, 5));
			
			else if(e.getSource().equals(butRaca))
				enviarListeners(new ControlEvent(butRaca, EnumNomeBotoes.CADASTRO_RACA, 5));
			
			else if(e.getSource().equals(butVisualizarOvino))
				enviarListeners(new ControlEvent(butVisualizarOvino, EnumNomeBotoes.VISUALIZAR_OVINOS, 5));
			
			else if(e.getSource().equals(butVisualizarOcorrencia))
				enviarListeners(new ControlEvent(butVisualizarOcorrencia, EnumNomeBotoes.VISUALIZAR_OCORRENCIAS, 5));
			
			else if(e.getSource().equals(butVisualizarPeso))
				enviarListeners(new ControlEvent(butVisualizarPeso, EnumNomeBotoes.VISUALIZAR_PESO, 5));
			
			else if(e.getSource().equals(butVisualizarEventos))
				enviarListeners(new ControlEvent(butVisualizarEventos, EnumNomeBotoes.VISUALIZAR_EVENTOS, 5));
			
			else if(e.getSource().equals(butUsuario))
				enviarListeners(new ControlEvent(butUsuario, EnumNomeBotoes.CADASTRO_USUARIO, 5));
			
			else if(e.getSource().equals(buCadTipoOcorrencia))
				enviarListeners(new ControlEvent(buCadTipoOcorrencia, EnumNomeBotoes.CADASTRO_TIPO_OCORRENCIA, 5));
			
			else if(e.getSource().equals(butSair))				
				enviarListeners(new ControlEvent(butSair, EnumNomeBotoes.LOGOFF, 5));
			
			else if(e.getSource().equals(butBackup))				
				enviarListeners(new ControlEvent(butBackup, EnumNomeBotoes.BACKUP, 5));				
			
		
		}
	}
	
	public static void main(String[] args) {
		 new JanelaLogar();		
	}
}
