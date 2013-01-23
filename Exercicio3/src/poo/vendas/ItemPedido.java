package poo.vendas;

public class ItemPedido {
	private Produto produto;
	private int quantidade;
	
	public ItemPedido(Produto p, int quant){
		this.produto = p;
		this.quantidade=quant;
	}
	public ItemPedido(){
		
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
		
}
