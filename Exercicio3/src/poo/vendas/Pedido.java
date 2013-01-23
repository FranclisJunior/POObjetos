package poo.vendas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
	private String data;
	private Cliente cliente;
	private int codigoPedido;	
	ArrayList<ItemPedido> listaItens = new ArrayList<ItemPedido>();
	Map<Produto,ItemPedido> mapItens = new HashMap<Produto,ItemPedido>();
	
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
		if(mapItens.containsKey(p)){
			int novaQtd = mapItens.get(p).getQuantidade()+1;
			ItemPedido pedido = new ItemPedido(p,novaQtd);			
			mapItens.put(p, pedido);
		}else{
			ItemPedido pedido = new ItemPedido(p,1);		
			listaItens.add(pedido);
			mapItens.put(p, pedido);
		}
	}
	
	public void addProduto(Produto p, int qtd){
		if(mapItens.containsKey(p)){
			int novaQtd = (mapItens.get(p).getQuantidade())+qtd;
			ItemPedido pedido = new ItemPedido(p,novaQtd);			
			mapItens.put(p, pedido);
		}else{
			ItemPedido pedido = new ItemPedido(p,qtd);		
			listaItens.add(pedido);
			mapItens.put(p, pedido);
		}
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
