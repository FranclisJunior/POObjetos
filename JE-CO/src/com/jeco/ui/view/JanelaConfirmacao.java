package com.jeco.ui.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
public class JanelaConfirmacao extends javax.swing.JPanel {
	private JLabel icone;
	private JTextField ctMensagem;
	private JButton bSim;
	private JButton bNao;
	private JDialog dialog;
	private ActionOvelha action = new ActionOvelha();
	private boolean resposta;
	private JDialog dl;

	public JanelaConfirmacao(String msg) {
		dl = new JDialog();	
		dl.setUndecorated(true);
		dl.getContentPane().setBackground(new java.awt.Color(212,208,200));
		initGUI();
		dl.setResizable(false);	
		dl.getContentPane().add(this);
		dl.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
		dl.pack();		
		dl.setLocationRelativeTo(null);
		dl.setModal(true);
			
		ctMensagem.setText(msg);
		ctMensagem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		dialog = dl;	
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(400, 158));
			this.setLayout(null);
			this.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
		
			{
				icone = new JLabel();
				this.add(icone);
				icone.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/icon.png")));
				icone.setBounds(172, 12, 50, 50);
			}
			{
				ctMensagem = new JTextField();
				this.add(ctMensagem);
				ctMensagem.setBounds(12, 72, 376, 29);
				ctMensagem.setEditable(false);
				ctMensagem.setFont(new java.awt.Font("Segoe UI",1,12));
				ctMensagem.setBackground(new java.awt.Color(212,208,200));
			}
			{
				bSim = new JButton();
				this.add(bSim);
				bSim.setText("Sim");
				bSim.setBounds(122, 113, 58, 28);
				bSim.setFont(new java.awt.Font("Segoe UI",1,12));
				bSim.addActionListener(action);
			}
			{
				bNao = new JButton();
				this.add(bNao);
				bNao.setText("Nao");
				bNao.setBounds(216, 113, 59, 28);
				bNao.setFont(new java.awt.Font("Segoe UI",1,12));
				bNao.addActionListener(action);
			}
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Erro no sistema, Por favor procure o suporte. ",JanelaInformacao.ERRO);
		}
	}
	
	public boolean resposta(){
		dl.setVisible(true);
		return resposta;
	}
	
private class ActionOvelha  implements ActionListener{    	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bSim)){
				resposta =true;
				dialog.dispose();    			
    		}
			if(e.getSource().equals(bNao)){
				resposta =false;
				dialog.dispose();    			
    		}
		}
	}
}
