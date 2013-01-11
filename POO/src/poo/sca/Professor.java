package poo.sca;

import java.io.Serializable;

public class Professor  {
	private int matricula;
	private String nome;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.equals(null)|| nome.equals("")|| nome.equals("null")){
			throw new SCARuntimeException("Nome da Professor é invalido: "+nome);
		}
		this.nome = nome;
	}
	
	
}
