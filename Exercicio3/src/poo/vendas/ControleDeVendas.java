package poo.vendas;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import poo.vendas.io.SCVPersistencia;
import poo.vendas.io.SCVPersistenciaArquivo;
import poo.vendas.io.SCVPersistenciaException;

public class ControleDeVendas {
	
	SCVPersistencia persistencia = new SCVPersistenciaArquivo();		
	
	public String getDateAtual() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = new Date();
	    return dateFormat.format(date);
	}

	public ArrayList<Pedido> listarPedidos(Cliente c) throws  SCVException{
		ArrayList<Pedido> pedidosCliente = new ArrayList<Pedido>();
		try{
			ArrayList<Pedido> todosPedidos = persistencia.recuperarPedidos();		
			for(Pedido pedido : todosPedidos){
				if(c.getCpf().equals(pedido.getCliente().getCpf())){
					pedidosCliente.add(pedido);
				}
			}
			return pedidosCliente;
		}catch(SCVPersistenciaException ex){
			throw new SCVException("Erro no arquivo");
		}		
	}		
	
	public ArrayList<Pedido> listarPedidos(String data) throws  SCVException{
		ArrayList<Pedido> pedidosData = new ArrayList<Pedido>();		
		try{
			ArrayList<Pedido> todosPedidos = persistencia.recuperarPedidos();		
			for(Pedido pedido : todosPedidos){
				if(data.equals(pedido.getData())){
					pedidosData.add(pedido);
				}
			}
			return pedidosData;
		}catch(SCVPersistenciaException ex){
			throw new SCVException("Erro no arquivo");
		}		
		
	}	
	
	public Pedido novoPedido(Cliente c) throws SCVRuntimeException, SCVException{		
		int cnd = 1;		
		try{
			Pedido pedido = new Pedido();		
			pedido.setData(getDateAtual());
			pedido.setCliente(c);
			pedido.setCodigoPedido(geraCodigo());
			do{
				int codProduto = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Cod do Produto"));
				int qntd =Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o quantidade"));
				Produto produto = getProduto(codProduto);
				if(produto!=null){
					pedido.addProduto(produto, qntd);
					int op = Integer.parseInt(JOptionPane.showInputDialog(null,"Produto adicionado com sucesso!\n\n Deseja adcionar outro Produto? \n1-Sim\n0-Nao"));
					if(op==0){
						JOptionPane.showMessageDialog(null,"Sr "+pedido.getCliente().getNome()+"\nValor total a pagar: R$"+pedido.totalPedido());
						cnd = 0;
					}
				}else{
					JOptionPane.showMessageDialog(null,"Nao existe produto com esse codigo");
				}			
			}while(cnd!=0);
			pedido.setListaItens(pedido.getListaItens());
			persistencia.salvar(pedido);
			return pedido;
		}catch(SCVPersistenciaException ex){
			throw new SCVException("Erro ao Salvar");
		}
	}	
	
	public void addProduto(Produto p)throws SCVException, SCVRuntimeException{		
		try{		
			if(getProduto(p.getId())!=null){
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
	
	public Produto getProduto(int cod) throws SCVException{
		try {
			ArrayList<Produto> produtos = persistencia.recuperarProdutos();
			for(Produto p : produtos){
				if(p.getId()==cod){
					return p;
				}
			}
		}catch (SCVPersistenciaException e) {
			throw new SCVException("Erro ao ler o arquivo");
		}			
		return null;
	}
	
	public int geraCodigo()throws SCVPersistenciaException {
		try {
			int codPedido = persistencia.recuperaCodPedido();
			codPedido+=1;
			persistencia.salvar(codPedido);
			return codPedido;
		} catch (SCVPersistenciaException e) {
			throw new SCVPersistenciaException("Erro de arquivo");
		}
	}
	
	public StringBuilder mostrarDetalhesPedido(ArrayList<Pedido> pedidos){
		StringBuilder detalhes = new StringBuilder();			
		for(Pedido p : pedidos ){
			detalhes.append("Nome do Cliente: "+p.getCliente().getNome()+"\nCodigo do Pedido: "+p.getCodigoPedido()+"\nData do Pedido"+p.getData()+"\nValor do Pedido: "+p.totalPedido()+"\n\n");
		}
		return detalhes;
	}
	
	public ArrayList<Pedido> getPedidos() throws SCVException{		
		try{		
			return persistencia.recuperarPedidos();	
		}catch(SCVPersistenciaException ex){
			throw new SCVException("Erro ao ler");
		}
	}
}
