package com.jeco.ui.auxilares;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends FullResizibleFrame{

	public Home(Dimension initialDimension, Point initialLocation) {
		super(initialDimension, initialLocation);
		// TODO Auto-generated constructor stub
	}
	
	 Home() {
		 
		 	Toolkit toolkit =  Toolkit.getDefaultToolkit ();  
	        int frameWidth = 800;  
	        int frameHeight = 600;            
	            
	        Point initialLocation = new Point((int)toolkit.getScreenSize().getWidth()/2 - frameWidth/2,         
	                (int)toolkit.getScreenSize().getHeight()/2 - frameHeight/2);  
	        Dimension initialDimension = new Dimension(frameWidth, frameHeight);  
	        Home home = new Home(initialDimension, initialLocation);
	        JPanel viewContainer=(JPanel)home.getContentPane();           
	        JPanel headerPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));       
	      	headerPanel.add(new JLabel(new ImageIcon(home.getClass().getClassLoader().getResource("com/jeco/image/head.png"))));//src/br/soletrando/images/topo.png
	      	//adiciona   MouseListener ao painel superior     
	      	headerPanel.addMouseListener(home);  	
	      	headerPanel.addMouseMotionListener(home); 
	        viewContainer.add(headerPanel, BorderLayout.NORTH);      
	   
	        home.setVisible(true); 
		
		
		
	}
	
	public static void main(String [] args){
		new Home();
		
		
	}

}
