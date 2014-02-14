package com.jeco.ui.auxilares;

import java.util.ArrayList;
import java.util.List;

import com.jeco.OcorrenciaTipo;

public class TableOcorrenciaTipo extends JECOTableModel<OcorrenciaTipo> {	

	private static final long serialVersionUID = 1L;
	private static List<OcorrenciaTipo> linhas = new ArrayList<OcorrenciaTipo>();   
    private static String[] colunas = new String[] {"Tipo de Ocorrencia"};  
    
    public TableOcorrenciaTipo(){    	
    	super(linhas,colunas);    	
    }
  
    
    public Class<?> getColumnClass(int columnIndex) {   
        
        switch (columnIndex) {    
        case 0: 
            return String.class; 
        default:             
            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
        }    
    }  
    
    public Object getValueAt(int rowIndex, int columnIndex) {            
    	OcorrenciaTipo oc = linhas.get(rowIndex);    	
        switch (columnIndex) {    
        case 0:     
            return oc.getNome();                 
        default:            
            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
        }    
    } 
    
    public OcorrenciaTipo get(int indiceLinha) {    
        return linhas.get(indiceLinha);    
    }    

}


