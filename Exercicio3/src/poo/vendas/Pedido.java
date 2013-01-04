package poo.vendas;

import java.util.ArrayList;
import java.util.Map;

public class Pedido {
	private String data;
	private Cliente cliente;
	private int codigoPedido;	
	ArrayList<ItemPedido> listaItens = new ArrayList<ItemPedido>();
	Map<Produto,ItemPedido> mapItens;
	
	public ArrayList<ItemPedido> getListaItens() {
		return listaItens;
	}

	public void setListaItens(ArrayList<ItemPedido> listaItens) {
		this.listaItens = listaItens;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public void addProduto(Produto p){
		ItemPedido pedido = new ItemPedido();
		pedido.setProduto(p);
		pedido.setQuantidade(1);
		listaItens.add(pedido);
	}
	
	public void addProduto(Produto p, int qtd){
		ItemPedido pedido = new ItemPedido();
		pedido.setProduto(p);
		pedido.setQuantidade(qtd);
		listaItens.add(pedido);
	}
	
	public double totalPedido(){
		double total=0;
		for(ItemPedido p : listaItens){
			total += p.getProduto().getPreco()*p.getQuantidade();
		}
		return total;
	}
	
	public ArrayList<ItemPedido> listarItensPedido(){
		return listaItens;
	}
	
	public Produto somarQuant(int quant){
		return null;
	}

}
