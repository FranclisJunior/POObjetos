package poo.sca;

import java.io.Serializable;

public class Curso {
	private int codigo;
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.equals(null)|| nome.equals("")|| nome.equals("null")){
			throw new SCARuntimeException("Nome da Curso é invalido "+nome);
		}
		this.nome = nome;
	}
	
}
