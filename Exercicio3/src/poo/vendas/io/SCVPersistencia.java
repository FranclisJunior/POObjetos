package poo.vendas.io;

import java.util.ArrayList;
import poo.vendas.Cliente;
import poo.vendas.Produto;

public interface SCVPersistencia {
	public void salvar(Produto p) throws SCVPersistenciaException;
	public void salvar(Cliente c) throws SCVPersistenciaException;
	public ArrayList<Produto> recuperarProdutos()throws SCVPersistenciaException;
	public ArrayList<Cliente> recuperarClientes() throws SCVPersistenciaException;
	
	
}
