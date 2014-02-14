package com.jeco.ui.auxilares;

import java.util.ArrayList;
import java.util.List;
import com.jeco.Raca;

public class TableRaca extends JECOTableModel{	
	
	private static List<Raca> linhas = new ArrayList<Raca>();    
    private static String[] colunas = new String[] {"Raças"};    
    
	public TableRaca(){
    	super(linhas,colunas);
    }
   
	@Override
	public Class getColumnClass(int columnIndex) {		
		switch (columnIndex) {    
        case 0:     
            return String.class;        
        default:            
            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
        }    
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex){		
			Raca rc = linhas.get(rowIndex);			
					
			switch (columnIndex) {    
	        case 0:     
	            return rc.getRacaName();	                        
	        default:            
	            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
	        }		
	}
	

	@Override
	public Raca get(int indiceLinha) {		
		return linhas.get(indiceLinha);  
	}
	
}
