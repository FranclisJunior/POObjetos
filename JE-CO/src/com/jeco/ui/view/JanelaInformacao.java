package com.jeco.ui.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import com.jeco.logger.JECOLogger;
import com.jeco.ui.controler.TipoInformacaoEnum;





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
public class JanelaInformacao extends  javax.swing.JDialog {
	private JLabel icone;
	private JTextField ctMensagem;
	private JButton bOk;
	private JDialog dialog = this;
	private JPanel panel;
	private ActionOvelha action = new ActionOvelha();
	public static Enum<?>  ATENCAO = TipoInformacaoEnum.ATENCAO ;
	public static Enum<?> ERRO  = TipoInformacaoEnum.ERRO;
	public static Enum<?> SUCESSO = TipoInformacaoEnum.SUCESSO;
	

	public JanelaInformacao(String msg,	Enum<?> opc) {	
		initGUI();
		
		if(opc == SUCESSO){
			icone.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/success.png")));
		}else if(opc == ATENCAO){
			icone.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/atencao.png")));
		}
		ctMensagem.setText(msg);				
		setVisible(true);
	}
	public JanelaInformacao(String msg) {	
		initGUI();
		ctMensagem.setText(msg);	
		setVisible(true);		
	}
	
	private void initGUI() {
		try {
			setSize(new java.awt.Dimension(400, 158));
			setUndecorated(true);
			setModal(true);	
			//setResizable(false);							
			setLocationRelativeTo(null);
			
			{
				panel = new JPanel();
				panel.setPreferredSize(new java.awt.Dimension(400, 158));
				panel.setSize(new java.awt.Dimension(400, 158));
				panel.setLayout(null);
				getContentPane().add(panel);
				panel.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				panel.setBackground(new java.awt.Color(164,209,255));
			}
			
			{
				icone = new JLabel();
				panel.add(icone);
				icone.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/erro.png")));
				icone.setBounds(172, 9, 64, 64);
			}
			{
				ctMensagem = new JTextField();
				ctMensagem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
				panel.add(ctMensagem);
				ctMensagem.setBounds(12, 72, 376, 29);
				ctMensagem.setEditable(false);
				ctMensagem.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				bOk = new JButton();
				panel.add(bOk);
				bOk.setText("OK");
				bOk.setBounds(165, 119, 78, 28);
				bOk.addActionListener(action);
			}			
		} catch (Exception e) {
			JECOLogger.getInstance().log(e);		
		}
	}
	
private class ActionOvelha  implements ActionListener{
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bOk)){
				dialog.dispose();    			
    		}			
		}
	}
}
