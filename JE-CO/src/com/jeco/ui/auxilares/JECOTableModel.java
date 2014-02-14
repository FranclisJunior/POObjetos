package com.jeco.ui.auxilares;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class JECOTableModel<T> extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Lista de Ovelhas que representam as linhas. */    
    private List<T> linhas;    
    
    /* Array de Strings com o nome das colunas. */    
    private String[] colunas;
    
    
    /* Cria um TableModel vazio. */    
    public JECOTableModel() {    
        linhas = new ArrayList<T>();    
    }
    
    
    /* Cria um TableModel carregado com  
     * a lista  especificada. */    
    public JECOTableModel(List<T> lista,String[] col) {   
    	colunas = col;
        linhas = lista;    
    }   
    
 


	/* Retorna a quantidade de colunas. */    
    @Override    
    public int getColumnCount() {    
        // Esta retornando o tamanho do array "colunas".    
        // Mas como o array e fixo, vai sempre retornar 4.    
        return colunas.length;    
    }    
    
    /* Retorna a quantidade de linhas. */    
    @Override    
    public int getRowCount() {    
        // Retorna o tamanho da lista de Ovelhas.    
        return linhas.size();    
    }    
    
    /* Retorna o nome da coluna no indice especificado.  
     * Este metodo e usado pela JTable para saber o texto do cabecalho. */    
    @Override    
    public String getColumnName(int columnIndex) {    
        // Retorna o conteudo do Array que possui o nome das colunas    
        // no indice especificado.    
        return colunas[columnIndex];    
    };    
    
    /* Retorna a classe dos elementos da coluna especificada.  
     * Este metodo e usado pela JTable na hora de definir o editor da celula. */    
    @Override    
    public abstract Class<?> getColumnClass(int columnIndex);
    
    /* Retorna o valor da celula especificada  
     * pelos �ndices da linha e da coluna. */    
    @Override    
    public abstract Object getValueAt(int rowIndex, int columnIndex);
    
    /* Seta o valor da celula especificada  
     * pelos indices da linha e da coluna.  
     * Aqui ele esta implementado para nao fazer nada,  
     * ate porque este table model nao e editavel. */    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {};    
    
    /* Retorna um valor booleano que define se a celula em questao  
     * pode ser editada ou nao.  
     * Este metodo e utilizado pela JTable na hora de definir o editor da celula.  
     * Neste caso, estara sempre retornando false, nao permitindo que nenhuma  
     * celula seja editada. */    
    @Override    
    public boolean isCellEditable(int rowIndex, int columnIndex) {    
        return false;    
    }    
    
    	    
    /* Retorna o t da linha especificada. */    
    public abstract T get(int indiceLinha);
        
    /* Adiciona um registro. */    
    public void add(T t) {    
        // Adiciona o registro.    
        linhas.add(t);	    
        // Pega a quantidade de registros e subtrai um para achar    
        // o ultimo indice. e preciso subtrair um, pois os indices    
        // comecam pelo zero.    
        int ultimoIndice = getRowCount() - 1;    
    
        // Reporta a mudanca. O JTable recebe a notificacao    
        // e se redesenha permitindo que visualizemos a atualizacao.    
        fireTableRowsInserted(ultimoIndice, ultimoIndice);    
    }    
    
    /* Remove a linha especificada. */    
    public void remove(int indiceLinha) {    
        // Remove o ovelha da linha especificada.            
        linhas.remove(indiceLinha);    
    
        // Reporta a mudanca. O JTable recebe a notificacao    
        // e se redesenha permitindo que visualizemos a atualizacao.    
        fireTableRowsDeleted(indiceLinha, indiceLinha);    
    }    
    
    /* Adiciona uma lista de t ao final dos registros. */    
    public void addLista(List<T> lista) {    
        // Pega o tamanho antigo da tabela.    
        int tamanhoAntigo = getRowCount();    
    
        // Adiciona os registros.    
        linhas.addAll(lista);    
    
        // Reporta a mudanca. O JTable recebe a notificacao    
        // e se redesenha permitindo que visualizemos a atualizacao.    
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);    
    }    
    
    /* Remove todos os registros. */    
    public void limpar() {    
        // Remove todos os elementos da lista de Ovelhas.    
        linhas.clear();    
    
        // Reporta a mudanca. O JTable recebe a notificacao    
        // e se redesenha permitindo que visualizemos a atualizacao.    
        fireTableDataChanged();    
    }    
    
    /* Verifica se este table model estc vazio. */    
    public boolean isEmpty() {    
        return linhas.isEmpty();    
    }  

}
