package com.jeco.ui.auxilares;

import java.util.ArrayList;
import java.util.List;
import com.jeco.Usuario;

public class TableUsuario extends JECOTableModel{
	
	private static List<Usuario> linhas = new ArrayList<Usuario>();    
    private static String[] colunas = new String[] {"Usuarios","Nivel"};
    
    public TableUsuario(){
    	super(linhas,colunas);
    }
    
    
	@Override
	public Class getColumnClass(int columnIndex) {
		switch (columnIndex) {    
        case 0:     
            return String.class;
        case 1:
        	return String.class;
        default:            
            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
        }
	}
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario us= linhas.get(rowIndex);			
		
		switch (columnIndex) {    
        case 0:     
            return us.getNome();
        case 1: 
        	return us.getNivel();
        default:            
            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
        }	
	}
	
	@Override
	public Usuario get(int indiceLinha) {
		return linhas.get(indiceLinha); 
	}
}
