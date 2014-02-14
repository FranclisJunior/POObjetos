 
package com.jeco;

import java.util.LinkedList;
import java.util.List;



public class Ovino {
    
    private String codigo;
    private String sexo;
    private String data;
    private String raca;
    private String status;
    private String codGenitora;
    private double preco;
    private List<Pesagem> historicoPesos;
    private List<Cria> crias ;
    
    public Ovino() {
    	historicoPesos = new LinkedList<Pesagem>();
       crias = new LinkedList<Cria>();
	}

    public String getCodigo() {
        return codigo;
    }

    public List<Cria> getCrias() {
        return crias;
    }

    public void setCrias(List<Cria> crias) {
        this.crias = crias;
    }

    public List<Pesagem> getHistoricoPesos() {
        return historicoPesos;
    }

    public void setPeso(Pesagem pesagem) {
        this.historicoPesos.add(pesagem);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    public void addPeso(Pesagem p){
        this.historicoPesos.add(p);        
    }

    public void setCodGenitora(String g) {
        this.codGenitora=g;
    }
    
    public String getCodGenitora(){
        return codGenitora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
    
    
    
}
