package com.jeco.ui.auxilares;

import java.util.ArrayList;
import java.util.List;
import com.jeco.Pesagem;


public class TablePeso extends JECOTableModel {
	
	private static List<Pesagem> linhas = new ArrayList<Pesagem>();    
    private static String[] colunas = new String[] {"Codigo Ovino","Peso","Data da Pesagem"};    
    
	public TablePeso(){
    	super(linhas,colunas);
    }
   
	@Override
	public Class getColumnClass(int columnIndex) {		
		switch (columnIndex) {    
        case 0:     
            return String.class; 
        case 1:     
            return String.class; 
        case 2:     
            return String.class; 
        default:            
            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
        }    
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex){		
			Pesagem pesagem = linhas.get(rowIndex);			
					
			switch (columnIndex) {    
	        case 0:     
	            return pesagem.getCodOvino();	
	        case 1:     
	            return pesagem.getPeso();	
	        case 2:     
	            return pesagem.getData();	    
	        default:            
	            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
	        }		
	}
	

	@Override
	public Pesagem get(int indiceLinha) {		
		return linhas.get(indiceLinha);  
	}
	
}
