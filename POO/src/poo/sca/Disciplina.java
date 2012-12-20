package poo.sca;


public class Disciplina  {
	
	private int codigo;
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		if(codigo>99999 || codigo<=0){
				throw new SCARuntimeException("numero menor que 0 ou maior que 99999");				
		}else{
			this.codigo = codigo;
		}		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
