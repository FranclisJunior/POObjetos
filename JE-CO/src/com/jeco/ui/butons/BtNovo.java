package com.jeco.ui.butons;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 * @author Ezequiel
 * */
@SuppressWarnings("serial")
public class BtNovo extends JButton{
	private JLabel jLabel_IL;

	public BtNovo() {
		
		
		setSize(new Dimension(120, 38));
		this.setLayout(null);  
		ImageIcon  icone = new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/document-new.png")); 
		setToolTipText("Click para um Novo");  
		setFont(new java.awt.Font("Segoe UI",0,12));
		this.setPreferredSize(new java.awt.Dimension(101, 32));
		{
			jLabel_IL = new JLabel(icone);
			jLabel_IL.setBounds(0, 0, this.getWidth(), this.getHeight());
			jLabel_IL.setText("Novo");
			add(jLabel_IL);
			jLabel_IL.setFont(new java.awt.Font("Segoe UI",1,12));
		}
		
	}
	public void setText(String text){
		jLabel_IL.setBounds(0, 0, this.getWidth(), this.getHeight());
		jLabel_IL.setText(text);
	}

}
