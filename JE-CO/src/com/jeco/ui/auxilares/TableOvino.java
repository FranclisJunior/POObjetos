package com.jeco.ui.auxilares;

import java.util.ArrayList;
import java.util.List;

import com.jeco.Ovino;

public class TableOvino extends JECOTableModel<Ovino> {
	  
	private static final long serialVersionUID = 1L;
	private static List<Ovino> linhas = new ArrayList<Ovino>();   
    private static String[] colunas = new String[] { "Codigo","Raca","Sexo"};  
    
    public TableOvino(){    	
    	super(linhas,colunas);    	
    }
  
    
    public Class<?> getColumnClass(int columnIndex) {   
        
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
    
    public Object getValueAt(int rowIndex, int columnIndex) {            
    	Ovino ovelha = linhas.get(rowIndex);    	
        switch (columnIndex) {    
        case 0:     
            return ovelha.getCodigo();    
        case 1:    
            return ovelha.getRaca();    
        case 2:   
            return ovelha.getSexo();                       
        default:            
            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
        }    
    } 
    
    public Ovino get(int indiceLinha) {    
        return linhas.get(indiceLinha);    
    } 
    

}
