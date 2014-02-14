package com.jeco.ui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import com.jeco.IniciarTestes;
import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.LogarListener;
import com.jeco.Usuario;
import com.jeco.logger.JECOLogger;



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
public class JanelaLogar extends JPanel implements ActionListener{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel background;
	private JPasswordField jPSenha;
	private JLabel jLSenha;
	private JLabel rAvisoNick;
	private JLabel jLabel1;
	private JLabel jLimgUp2;
	private JLabel jLimgSup;
	private JButton jButtonCancelar;
	private static JLabel jLInformacoes;
	private JButton jBEntrar;
	private JLabel jLUsuario;
	private JTextField jTUsuario;
	private JPanel jPanellogin;
	private JLabel jLIcon;
	private static List<LogarListener> listener;
	private static JanelaPadrao janelaPadrao;
	private JECOFacade facade;
	private boolean primeiroAcesso;
	
	

	public JanelaLogar(){		
		facade = new JECOFacade();
		primeiroAcesso = true;
		init();	
		janelaPadrao = new JanelaPadrao("Login", this);		
		rAvisoNick.setVisible(false);
	}

	private void init(){
		this.setSize(522, 419); 
		this.setLayout(null);
		{
			background = new JPanel();
			this.add(background);
			background.setBounds(0, 0, 522, 419);
			background.setLayout(null);
			background.setBackground(new java.awt.Color(255,255,255));
			{
				jLIcon = new JLabel(); 
				background.add(jLIcon);
				jLIcon.setVisible(false);

				jLIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/carregando.gif")));
				jLIcon.setBounds(163, 144, 200, 83);
			}
			{
				jPanellogin = new JPanel();
				background.add(jPanellogin);
				jPanellogin.setBounds(106, 116, 308, 215);
				jPanellogin.setBorder(BorderFactory.createTitledBorder(""));
				jPanellogin.setBackground(new java.awt.Color(250,249,248));
				jPanellogin.setLayout(null);
				jPanellogin.setVisible(true);
				{
					rAvisoNick = new JLabel();
					jPanellogin.add(rAvisoNick);
					rAvisoNick.setText("login ou senha invalidos");
					rAvisoNick.setBounds(80, 195, 172, 14);
					rAvisoNick.setBackground(new java.awt.Color(255,72,72));
					rAvisoNick.setFont(new java.awt.Font("Tahoma",1,12));
				}
				{
					jTUsuario = new JTextField();
					jPanellogin.add(jTUsuario);
					jTUsuario.setBounds(87, 73, 140, 30);
					jTUsuario.setFont(new java.awt.Font("Georgia",1,12));
					jTUsuario.setHorizontalAlignment(SwingConstants.CENTER);
					jTUsuario.setForeground(new java.awt.Color(128,128,128));
				}
				{
					jPSenha = new JPasswordField();
					jPanellogin.add(jPSenha);
					jPSenha.setBounds(87, 116, 141, 29);
					jPSenha.setHorizontalAlignment(SwingConstants.CENTER);
					jPSenha.setFont(new java.awt.Font("Georgia",1,12));
					jPSenha.setForeground(new java.awt.Color(128,128,128));
				}
				{
					jLUsuario = new JLabel();
					jPanellogin.add(jLUsuario);
					jLUsuario.setBounds(53, 67, 33, 36);
					jLUsuario.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/usu.png")));
				}
				{
					jLSenha = new JLabel();
					jPanellogin.add(jLSenha);
					jLSenha.setBounds(51, 116, 34, 36);
					jLSenha.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/change_password.png")));
				}
				{
					jBEntrar = new JButton();
					jPanellogin.add(jBEntrar);
					jBEntrar.setText("Entrar");
					jBEntrar.setBounds(155, 155, 114, 31);
					jBEntrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/door_in.png")));
					jBEntrar.addActionListener(this);
				}
				{
					jButtonCancelar = new JButton();
					jPanellogin.add(jButtonCancelar);
					jButtonCancelar.setText("Cancelar");
					jButtonCancelar.setBounds(36, 155, 114, 31);
					jButtonCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/1362751689_Close.png")));
					jButtonCancelar.addActionListener(this);
				}
				{
					jLimgSup = new JLabel();
					jPanellogin.add(jLimgSup);
					jLimgSup.setBounds(102, -70, 100, 129);
					jLimgSup.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/Login Manager.png")));
				}

			}
			{
				jLInformacoes = new JLabel();
				background.add(jLInformacoes);
				jLInformacoes.setText("");
				jLInformacoes.setBounds(119, 233, 284, 16);
				jLInformacoes.setFont(new java.awt.Font("Arial",0,10));
				jLInformacoes.setForeground(new java.awt.Color(0,51,102));
				jLInformacoes.setHorizontalAlignment(SwingConstants.CENTER);
				jLInformacoes.setVisible(false);
			}
			{
				jLimgUp2 = new JLabel();
				background.add(jLimgUp2);
				jLimgUp2.setText("jLabel1");
				jLimgUp2.setBounds(207, 43, 100, 130);
				jLimgUp2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/Login Manager.png")));
			}
			{
				jLabel1 = new JLabel();
				background.add(jLabel1);
				jLabel1.setBounds(0, 0, 522, 419);
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/backgroud_login.png")));
			}
		}
			listener = new LinkedList<>();
			try {
				javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				JECOLogger.getInstance().log(e);
			}
	}
	
	public void addLogarListener(LogarListener comp){
		listener.add(comp);
	}
	public static void setStatus(String msg){
		if (!(jLInformacoes == null))
			jLInformacoes.setText(msg);
		if(msg.equalsIgnoreCase("Sucesso")){
			for(LogarListener lo :listener){				
				lo.termino();
				
			}
			janelaPadrao.dispose();
			
		}else if( msg.equalsIgnoreCase("fim"))
			janelaPadrao.dispose();
	}
	
	
	private boolean autenticar(){
		try {
			String senha = new String(jPSenha.getPassword());
			String userNome = jTUsuario.getText();						
			List<Usuario> users = facade.buscarUsuarios();
			for(Usuario usuario : users){
				if(usuario.getNome().equals(userNome)&& usuario.getSenha().equals(senha)){
					Home.user = usuario;
					return true;
				}
			}
			
			if(!users.isEmpty()){
				primeiroAcesso = false;					
			}			
			return false;
		} catch (JECOException e) {
			return false;
		}				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jBEntrar)){
			if(autenticar()|| primeiroAcesso){
				jLInformacoes.setVisible(true);
				jLIcon.setVisible(true);
				jLimgUp2.setVisible(false);
				jPanellogin.setVisible(false);				 
				new IniciarTestes(this);
			}else{
				rAvisoNick.setVisible(true);
			}
		}else if(e.getSource().equals(jButtonCancelar)){
			System.exit(0);			
		}		
	}
}
