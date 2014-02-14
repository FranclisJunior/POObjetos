package com.jeco.ui.view;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import com.jeco.ui.controler.ControlEvent;
import com.jeco.ui.controler.ControlerHomeListener;
import com.jeco.ui.controler.ControllHomeAddListener;
import com.jeco.ui.controler.EnumNomeBotoes;


public abstract class PanelDefault extends javax.swing.JPanel implements ControllHomeAddListener {

	
	private static final long serialVersionUID = 1L;
	
		
	private List<ControlerHomeListener> listeners;
	private JFrame comp;
	private EnumNomeBotoes tipoJanela;
	private String tituloJanela;
	
	public PanelDefault(String tituloJanela, EnumNomeBotoes tipoJanela) {
		this.tipoJanela = tipoJanela;
		listeners = new LinkedList<>();
		this.tituloJanela = tituloJanela;
		
		  
		
	}
	public void run(){
		//utiliza-se esta thread para pegar o evento do System.exit(0); 
		
//				Runtime.getRuntime().addShutdownHook(new Thread() {          
//		            public void run() {
//		            	
//		            	close();
//		            }  
//					}  
//				);
		comp = new JanelaPadrao(tituloJanela,this);
	}
	
	
	
		
	 /** Adciona os listeners */
		@Override
		public void add(ControlerHomeListener listener) {
			listeners.add(listener);
			
		}
		/*pecorre os listeners para enviar a acao*/
		public void enviarListeners(ControlEvent ev){
			for(ControlerHomeListener lis: listeners)
				lis.event(ev);
		}
		
		//usado para fechar a janela;
		public void close(){			
			enviarListeners(new ControlEvent(tipoJanela));
			comp.dispose();		
		}
		
		//usado para fechar a janela quando clicado na parte superior do janela padrão;
		//o janela padrão utiliza este metoodo para fechar qualquer panel que extend este;
		public void validate(){
			close();
		}
		
    
	
	
	
    
    
    
}
