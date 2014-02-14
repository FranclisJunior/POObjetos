package com.jeco;

public class Ocorrencia {
	
	private String codigoOcr;	
	private String tipo;
	private String codigoOvino;
	private String descricao;
	private String data;
	private float custo;
	
	
	public Ocorrencia(String cOcr,String t,String cOvino, String de, String dt){
		codigoOcr = cOcr;
		codigoOvino=cOvino;
		tipo=t;
		descricao = de;
		data = dt;
	}

	public Ocorrencia() {		
	}



	public String getCodigoOcr() {
		return codigoOcr;
	}



	public void setCodigoOcr(String codigoOcr) {
		this.codigoOcr = codigoOcr;
	}



	public float getCusto() {
		return custo;
	}



	public void setCusto(float custo) {
		this.custo = custo;
	}



	public String getCodigoOvino() {
		return codigoOvino;
	}



	public void setCodigoOvino(String codigoOvino) {
		this.codigoOvino = codigoOvino;
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
