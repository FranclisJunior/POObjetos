package poo.vendas;

public class ProdutoPerecivel extends Produto {
	private String vecimento;
	
	public ProdutoPerecivel(String n,int id,String d, double p){
		super(n,id,d,p);		
	}
	
	public ProdutoPerecivel() {
		
	}

	public String getVecimento() {
		return vecimento;
	}

	public void setVecimento(String vecimento) {
		this.vecimento = vecimento;
	}
	
	
	
}
