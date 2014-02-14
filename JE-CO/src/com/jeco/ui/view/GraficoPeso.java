package com.jeco.ui.view;

import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.jeco.Ovino;
import com.jeco.Pesagem;



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
public class GraficoPeso extends JPanel { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChartPanel chartPanel;
    
    public GraficoPeso( Ovino ovino) {   
    	drawGrafico(ovino);
    }    
    
    
    public void setSize(int x, int y){
    	super.setSize(x, y);
    	this.remove(chartPanel);
    	chartPanel.setPreferredSize(new Dimension(x-2, y-7));
    	this.add(chartPanel);
    	
    }
    
    public void drawGrafico(Ovino ovino){
    	if(ovino == null){
    		ovino = new Ovino();
    		ovino.setCodigo("00");
    	}
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        
	    for(Pesagem pesagem:ovino.getHistoricoPesos()){
	    	ds.addValue(pesagem.getPeso(),"Peso",pesagem.getData());	        
        }
        
      //cria o grafico..
        JFreeChart data = ChartFactory.createBarChart("" ,"Data", "Peso do Ovino "+ovino.getCodigo(),ds, 
                      PlotOrientation.VERTICAL, true, true, false);
              
        ChartPanel chartPanel = new ChartPanel(data);     
        this.chartPanel = chartPanel;
        chartPanel.setPreferredSize(new java.awt.Dimension(378, 260));
        this.setBackground(new java.awt.Color(255,255,255));
        this.remove(chartPanel);
        this.repaint();
        this.add(chartPanel);
        chartPanel.setBackground(new java.awt.Color(255,255,255));
        this.repaint();
    }
    
    
}    







      



