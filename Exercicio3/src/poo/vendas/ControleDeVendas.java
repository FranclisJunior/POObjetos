package poo.vendas;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import poo.vendas.io.SCVPersistencia;
import poo.vendas.io.SCVPersistenciaArquivo;
import poo.vendas.io.SCVPersistenciaException;

public class ControleDeVendas {
	
	SCVPersistencia persistencia = new SCVPersistenciaArquivo();	
	
	public void addProduto(Produto p)throws SCVException, SCVRuntimeException{		
		try{		
			if(existeCodProduto(p.getId())==true){
				throw new SCVRuntimeException("Ja Existe Produto com esse codigo");				
			}			
			persistencia.salvar(p);			
		}catch (SCVPersistenciaException e) {			
			throw new SCVException("Erro ao ler o arquivo");
		}		
	}
	
	public void addCliente(Cliente c)throws SCVException, SCVRuntimeException{
		try{
			if(getCliente(c.getCpf())!=null){
				throw new SCVRuntimeException("Ja existe cliente com esse CPF");			
			}
			persistencia.salvar(c);
		}catch(SCVPersistenciaException ex){			
			throw new SCVException("Erro ao salvar");
			
		}
	}
	
	public Cliente getCliente(String cpf)throws SCVException{		
		try {
			Iterator<Cliente> it = persistencia.recuperarClientes().iterator();
			while(it.hasNext()){
				Cliente c = it.next();
				if(c.getCpf().equals(cpf)){
					return c;
				}				
			}			
		}catch (SCVPersistenciaException e) {
			throw new SCVException("Erro ao ler o arquivo");
		}		
		return null;
	}
	
	public boolean existeCodProduto(int cod) throws SCVPersistenciaException{
		try {
			ArrayList<Produto> produtos = persistencia.recuperarProdutos();
			for(Produto p : produtos){
				if(p.getId()==cod){
					return true;
				}
			}
		}catch (SCVPersistenciaException e) {
			throw new SCVPersistenciaException("Erro ao ler o arquivo");
		}			
		return false;
	}
	
}
