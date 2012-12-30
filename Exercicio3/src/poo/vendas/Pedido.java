package poo.vendas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

public class Pedido {
	private Date data;
	private Cliente cliente;
	private int codigoPedido;	
	ArrayList<ItemPedido> listaItens = new ArrayList<ItemPedido>();
	Map<Produto,ItemPedido> mapItens;
	
	
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
