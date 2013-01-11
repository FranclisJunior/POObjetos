package poo.sca;


public class Disciplina  {
	
	private int codigo;
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {		
		if(codigo>99999 || codigo<=0){
			throw new SCARuntimeException("codigo da disciplina menor que 0 ou maior que 99999");				
		}
		this.codigo = codigo;		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.equals(null)|| nome.equals("")|| nome.equals("null")){
			throw new SCARuntimeException("Nome da Disciplina é invalido: "+nome);
		}
		this.nome = nome;
	}
}
