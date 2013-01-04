package poo.vendas.io;

import java.util.ArrayList;
import poo.vendas.Cliente;
import poo.vendas.Pedido;
import poo.vendas.Produto;
import poo.vendas.SCVException;

public interface SCVPersistencia {
	public void salvar(Produto p) throws SCVPersistenciaException;
	public void salvar(Cliente c) throws SCVPersistenciaException;
	public void salvar(int cod) throws SCVPersistenciaException;
	public void salvar(Pedido p )throws SCVPersistenciaException;
	public int recuperaCodPedido()throws SCVPersistenciaException;
	public ArrayList<Produto> recuperarProdutos()throws SCVPersistenciaException;
	public ArrayList<Cliente> recuperarClientes() throws SCVPersistenciaException;
	public ArrayList<Pedido> recuperarPedidos() throws  SCVPersistenciaException, SCVException;
	
	
	
}
