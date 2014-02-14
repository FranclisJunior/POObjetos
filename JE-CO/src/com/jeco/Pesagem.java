
package com.jeco;

public class Pesagem {
	private int id;
    private float peso;
    private String data;
    private String codOvino;

    public Pesagem(String cod ,float p, String d){
        this.peso = p;
        this.data = d;
        this.codOvino = cod;
    }
    
    public Pesagem(){
        
    }    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPeso() {
        return peso;
    }
 
    public void setPeso(float peso) {
        this.peso = peso;
    }
 
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

	public String getCodOvino() {
		return codOvino;
	}

	public void setCodOvino(String codOvino) {
		this.codOvino = codOvino;
	}
    
    
    
    
}
