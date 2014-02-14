package com.jeco.ui.auxilares;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;


public class MyBoxModel implements ComboBoxModel<String>{
	ArrayList<String> data = new ArrayList<String>();
    
    String selected_item = null;
    
    public MyBoxModel(Iterator<String> racas ){
    	
        try{            
            while(racas.hasNext()){
                data.add(racas.next());
            }
          //tenta selecionar o primeiro item do array 
           if(data.size()>0)
        	   selected_item = data.get(0);
                               
                
            
            
        }catch(Exception e){
            e.printStackTrace();
            
            //trate sua exeção
        }
    }

    public void setSelectedItem(Object anItem) {   		
        selected_item = data.get(data.indexOf(anItem));   	
    }

    public Object getSelectedItem() {
       return selected_item;
    }

    public int getSize() {
        return data.size();
    }

    public String getElementAt(int index) {
        return data.get(index);
    }

    public void addListDataListener(ListDataListener l) {
     
    }

    public void removeListDataListener(ListDataListener l) {
        //TO DO NOTHING
    }
    
}

