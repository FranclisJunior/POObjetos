package com.jeco.ui.auxilares;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
/**
 *
 * @author guilherme
 */
public class PainelTrasnparente extends javax.swing.JPanel {

    private Robot robot;
    private BufferedImage fundo;
    private JButton jButton1;
    private JTextField jTextField1;

    public PainelTrasnparente(JFrame pai) {
        initGUI();

        try {
            robot = new Robot();

            setBounds(0,0,pai.getWidth(),pai.getHeight());//faz o painel ficar do tamanho do Frame

            //tira um print screen da tela, de acordo com as coordenadas do retângulo que foi passado como parâmetro
            fundo=robot.createScreenCapture(new Rectangle(pai.getX(),pai.getY(),pai.getWidth(),pai.getHeight()));
            
        } catch (AWTException ex) {}
        
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //sobrescreve o metodo paintComponent para poder tornar o printScreen o fundo do Painel
        g.drawImage(fundo, 0,0, null);
    }
    
    private void initGUI() {
    	try {
    		{
	    		
	    		
	    		{
	    			jButton1 = new JButton();
	    			this.add(jButton1);
	    			jButton1.setText("jButton1");
	    			jButton1.setBounds(68, 215, 59, 23);
	    		}
	    		{
	    			jTextField1 = new JTextField();
	    			this.add(jTextField1);
	    			jTextField1.setText("jTextField1");
	    			jTextField1.setBounds(202, 82, 186, 23);
	    		}
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}

