package com.jeco.ui.auxilares;

import java.util.ArrayList;
import java.util.List;

import com.jeco.JECOFacade;
import com.jeco.Ocorrencia;
import com.jeco.Ovino;

public class TableOcorrencia extends JECOTableModel<Ocorrencia> {	

	private static final long serialVersionUID = 1L;
	private JECOFacade facade = new JECOFacade();
	private static List<Ocorrencia> linhas = new ArrayList<Ocorrencia>();    
    private static String[] colunas = new String[] {"Tipo","Data","Custo","Codigo Ovino","Raca","Sexo"};
    
    
	public TableOcorrencia(){
    	super(linhas,colunas);
    }
   
	@Override
	public Class<String> getColumnClass(int columnIndex) {		
		switch (columnIndex) {    
        case 0:     
            return String.class;    
        case 1:    
            return String.class;    
        case 2:    
            return String.class;
        case 3:   
            return String.class;   
        case 4: 
            return String.class; 
        case 5: 
            return String.class; 
        default:            
            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
        }    
	}
	
	
	@Override	
	public Object getValueAt(int rowIndex, int columnIndex){
		try{
			Ocorrencia ocr = linhas.get(rowIndex);			
			Ovino ovino = facade.buscaOvino(ocr.getCodigoOvino());
					
			switch (columnIndex) {    
	        case 0:     
	            return ocr.getTipo();    
	        case 1:     
	            return ocr.getData();   
	        case 2:
	        	return ocr.getCusto();
	        case 3:    
	            return ovino.getCodigo();
	        case 4:
	        	return  ovino.getRaca();
	        case 5:
	        	return ovino.getSexo();                
	        default:            
	            throw new IndexOutOfBoundsException("columnIndex out of bounds");    
	        }
		}catch(Exception ex){
			return "Erro";
		}
			
	}
	
	@Override
	public Ocorrencia get(int indiceLinha) {		
		return linhas.get(indiceLinha);  
	}	
	

}
