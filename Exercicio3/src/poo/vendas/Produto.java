package poo.vendas;

public class Produto {
	private String nome;
	private int id;
	private double preco;
	private String descricao;
	
	
	public Produto(String n, int id, String d, double p) {
		this.nome = n;
		this.id=id;
		this.descricao=d;
		this.preco = p;
		
	}
	public Produto() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPreco() {
		return preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
