package com.jeco.ui.butons;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author Ezequiel
 * */

@SuppressWarnings("serial")
public class BtCancelar extends JButton{
	private JLabel jLabel_IL;

	public BtCancelar() {
		
		
		setSize(new Dimension(120, 38));
		this.setLayout(null);  
		ImageIcon  icone = new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/1362751689_Close.png")); 
		setToolTipText("Click para Cancelar");  
		setFont(new java.awt.Font("Segoe UI",0,12));
		this.setPreferredSize(new java.awt.Dimension(101, 32));
		{
			jLabel_IL = new JLabel(icone);

			jLabel_IL.setBounds(0, 0, 101, 32);
			jLabel_IL.setText("Cancelar");
			add(jLabel_IL);
			jLabel_IL.setFont(new java.awt.Font("Segoe UI",1,12));
		}
		

	}
	public void setText(String text){
		jLabel_IL.setText(text);
	}

}
