package com.jeco;

public class OcorrenciaTipo {
	private String nome;
	private String codigo;
	
	public OcorrenciaTipo(String cod, String nome){
		this.codigo=cod;
		this.nome=nome;
	}
	
	public OcorrenciaTipo() {
		
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	
	
}
