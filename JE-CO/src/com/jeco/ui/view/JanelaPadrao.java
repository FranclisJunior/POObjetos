package com.jeco.ui.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class JanelaPadrao extends FullResizibleFrame {
	
	private JLabel close;
	private JLabel minimizer;
	private JLabel jLabelTitulo;
	private JPanel panel;
	

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @author Ezequiel
	 * @wbp.parser.constructor
	 */
	public JanelaPadrao(Point initialLocation, Dimension initialDimension) {
		super(initialLocation,  initialDimension);
	}
	 
	
	public JanelaPadrao(String titulo, final JPanel panel ) {
		this.panel = panel;
		jLabelTitulo = new JLabel();
    	jLabelTitulo.setText(titulo);
    	init();
		
	}
	
	private void init(){
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/logoTipo_64X64.png"));
		close = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("com/jeco/image/fechar.png")));
		minimizer = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("com/jeco/image/minimize.png")));
		
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();  
        int frameWidth = panel.getWidth();  
        int frameHeight = panel.getHeight()+25; 
        //label minimizar
        minimizer.setBounds(frameWidth-50,0,25,25);
        minimizer.addMouseListener(this);
        //label close
        close.setBounds(frameWidth-26,0,25,25);
        close.addMouseListener(this);
       
            
        Point initialLocation = new Point((int)toolkit.getScreenSize().getWidth()/2 - frameWidth/2,         
                (int)toolkit.getScreenSize().getHeight()/2 - frameHeight/2);  
        Dimension initialDimension = new Dimension(frameWidth, frameHeight); 
        this.setSize(initialLocation, initialDimension);
        
        panel.setBounds(0, 25, frameWidth, frameHeight-25);
        
        panel.setBorder( new LineBorder(new java.awt.Color(0,0,0), 1, false));
        panel.setBackground(SystemColor.activeCaption);
        //panel.setBorder()
        JPanel viewContainer=(JPanel) this.getContentPane(); 
        viewContainer.setLayout(null);
       
        JPanel headerPanel=new JPanel();
       
        headerPanel.setLayout(null);
        headerPanel.setSize(frameWidth,25);
        {
        	jLabelTitulo.setPreferredSize(new java.awt.Dimension(frameWidth-75, 25));
        	jLabelTitulo.setForeground(new java.awt.Color(255,255,255));
        	jLabelTitulo.setFont(new java.awt.Font("Segoe UI",1,18));
        	jLabelTitulo.setSize(frameWidth-75, 25);
        	ImageIcon icon2 =new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/logoTipo.png"));
        	icon2.setImage(icon.getImage().getScaledInstance(35, 25, 100));
        	jLabelTitulo.setIcon(icon2);
        	
        	
        	headerPanel.add(jLabelTitulo);
        	
        }
        headerPanel.add(minimizer);
        headerPanel.add(close);
        close.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/jeco/image/close.png")));

      	headerPanel.setBackground(Color.gray);
      	
      	headerPanel.addMouseListener(this);  	
      	headerPanel.addMouseMotionListener(this); 
      	// seta o painel superior
        viewContainer.add(headerPanel);
        /* Seta o painel recebido na parte debaixo*/
        viewContainer.add(panel,BorderLayout.SOUTH);
        this.setVisible(true); 
        this.setIconImage(icon.getImage());
        
        
        
        this.addWindowListener(new WindowListener(){  
  		  
            @Override  
            public void windowActivated(WindowEvent arg0) {  
                // TODO Auto-generated method stub  
                  
            }  

            @Override  
            public void windowClosed(WindowEvent arg0) {  
                 
                  
            }  

            @Override  
            public void windowClosing(WindowEvent arg0) {  
            	panel.validate();
                  
            }  

            @Override  
            public void windowDeactivated(WindowEvent arg0) {  
                // TODO Auto-generated method stub  
                  
            }  

            @Override  
            public void windowDeiconified(WindowEvent arg0) {  
                  
                  
            }  

            @Override  
            public void windowIconified(WindowEvent arg0) {  
                
                  
            }  

            @Override  
            public void windowOpened(WindowEvent arg0) {  
                  
                  
            }  
              
        });   

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		/*Avisa para o panel que chamou para fechar*/
		if(e.getSource().equals(close)){
			this.panel.validate();
			this.dispose();
		}else if(e.getSource().equals(minimizer)){
			this.setExtendedState(JFrame.ICONIFIED);
		}
		
	}
	
	
}
