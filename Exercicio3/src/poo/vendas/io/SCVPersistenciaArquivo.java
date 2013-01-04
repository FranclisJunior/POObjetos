package poo.vendas.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import poo.vendas.Cliente;
import poo.vendas.ItemPedido;
import poo.vendas.Pedido;
import poo.vendas.Produto;
import poo.vendas.SCVException;


public class SCVPersistenciaArquivo implements SCVPersistencia{

	private File arquivoPedido;
	private File arquivoCliente;
	private File arquivoProduto;
	private File arquivoCod;

	public SCVPersistenciaArquivo() {
		arquivoPedido = new File("Arquivos/pedidos.txt");
		arquivoCliente = new File("Arquivos/clientes.txt");
		arquivoProduto = new File("Arquivos/produtos.txt");		
		arquivoCod = new File("Arquivos/codigos.txt");	
	}
	
	public void salvar(Pedido p )throws SCVPersistenciaException{
		StringBuilder linha = new StringBuilder();
		linha.append(p.getData()+"*"+p.getCliente().getCpf()+"*"+p.getCodigoPedido()+"\r\n");
		ArrayList<ItemPedido> listaItens = p.getListaItens();
		for(ItemPedido item : listaItens){
			linha.append(item.getProduto().getId()+":"+item.getQuantidade()+":");
		}
		linha.append(System.getProperty("line.separator"));
		try {
			FileWriter out = new FileWriter(arquivoPedido, true);
			boolean file = new File("Arquivos").mkdirs();
			out.write(linha.toString());
			out.close();
		} catch (IOException e) {			
			throw new SCVPersistenciaException("Arquivo nao Encotrando");
		}		
	}
	
	public void salvar(int codDoPedido) throws SCVPersistenciaException{		
		try {			
			FileWriter out = new FileWriter(arquivoCod, false);
			boolean file = new File("Arquivos").mkdirs();
			out.write(Integer.toString(codDoPedido));
			out.close();
		} catch (IOException e) {			
			throw new SCVPersistenciaException("Arquivo nao Encotrando");
		}
	}
	
	public void salvar(Cliente cliente) throws SCVPersistenciaException {
		StringBuilder linha = new StringBuilder();
		linha.append(cliente.getCpf()+":"+cliente.getNome()+":"+cliente.getTelefone()+"\r\n");
		try {
			FileWriter out = new FileWriter(arquivoCliente, true);
			boolean file = new File("Arquivos").mkdirs();
			out.write(linha.toString());
			out.close();
		} catch (IOException e) {			
			throw new SCVPersistenciaException("Arquivo nao Encotrando");
		}
	}	
	
	public void salvar(Produto p) throws SCVPersistenciaException {
		StringBuilder linha = new StringBuilder();
		linha.append(p.getNome()+":"+p.getId()+":"+p.getDescricao()+":"+p.getPreco()+"\r\n");
		try {
			FileWriter out = new FileWriter(arquivoProduto, true);
			boolean file = new File("Arquivos").mkdirs();
			out.write(linha.toString());
			out.close();
		} catch (IOException e) {			
			throw new SCVPersistenciaException("Arquivo nao Encotrando");
		}		
	}
	
	public ArrayList<Cliente> recuperarClientes() throws SCVPersistenciaException {
		ArrayList<Cliente> lClientes = new ArrayList<Cliente>();
		
		if (!arquivoCliente.exists()){
			return lClientes;
		}
		FileInputStream in;
		try{
			in = new FileInputStream(arquivoCliente);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String linha;
			while((linha = reader.readLine())!=null){
				StringTokenizer tokens = new StringTokenizer(linha,":");
				if(tokens.countTokens() != 3){
					throw new SCVPersistenciaException("Erro");
				}	
				Cliente cliente = new Cliente();
				cliente.setCpf(tokens.nextToken());
				cliente.setNome(tokens.nextToken());
				cliente.setTelefone(tokens.nextToken());
				lClientes.add(cliente);				
			}
			reader.close();
			return lClientes;
		}catch(IOException ex){
			throw new SCVPersistenciaException("Arquivo nao encontrado");
		}		
	}
	
	public int recuperaCodPedido()throws SCVPersistenciaException{
		int codPedido = 1000;		
		if (!arquivoCod.exists()){
			return codPedido;
		}
		FileInputStream in;
		try{
			in = new FileInputStream(arquivoCod);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String linha=reader.readLine();			
			codPedido = Integer.parseInt(linha);			
			reader.close();
			return codPedido;
		}catch(IOException ex){
			throw new  SCVPersistenciaException("Erro");
		}		
	}
		
	public ArrayList<Produto> recuperarProdutos()throws SCVPersistenciaException{
		ArrayList<Produto> lProdutos = new ArrayList<Produto>();
		
		if (!arquivoProduto.exists()){
			return lProdutos;
		}
		FileInputStream in;
		try{
			in = new FileInputStream(arquivoProduto);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String linha;
			while((linha = reader.readLine())!=null){
				StringTokenizer tokens = new StringTokenizer(linha,":");
				if(tokens.countTokens() != 4){
					return lProdutos;
				}
				Produto produto = new Produto();
				produto.setNome(tokens.nextToken());
				produto.setId(Integer.parseInt(tokens.nextToken()));
				produto.setDescricao(tokens.nextToken());
				produto.setPreco(Double.parseDouble(tokens.nextToken()));				
				lProdutos.add(produto);
			}
			reader.close();
			return lProdutos;
		}catch(IOException ex){
			throw new SCVPersistenciaException("Arquivo nao Encotrando");
		}
	}	
	
	public ArrayList<Pedido> recuperarPedidos() throws  SCVPersistenciaException, SCVException{
		ArrayList<Pedido> lPedidos = new ArrayList<Pedido>();				
				if (!arquivoPedido.exists())
					return lPedidos;
				
				FileInputStream in;
				try{
					in = new FileInputStream(arquivoPedido);
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String linha,linha2;
					
					while((linha = reader.readLine())!=null){
						StringTokenizer tokens = new StringTokenizer(linha,"*");
						Pedido p = new Pedido();
						p.setData(tokens.nextToken());
						
						
						String cpf = tokens.nextToken();
						ArrayList<Cliente> clientes = recuperarClientes();
						for(Cliente c: clientes){
							if(c.getCpf().equals(cpf)){
								p.setCliente(c);
							}
						}						
						p.setCodigoPedido(Integer.parseInt(tokens.nextToken()));
						
						linha2 = reader.readLine();
						StringTokenizer tokens2 = new StringTokenizer(linha2,":");
						ArrayList<ItemPedido> listaItens = new ArrayList<ItemPedido>();						
						ArrayList<Produto> produtos = recuperarProdutos();
						while(tokens2.hasMoreElements()){
							ItemPedido item = new ItemPedido();
							int codProduto = Integer.parseInt(tokens2.nextToken());							
							for(Produto prod : produtos){
								if(prod.getId()==codProduto){
									item.setProduto(prod);
								}
							}
							item.setQuantidade(Integer.parseInt(tokens2.nextToken()));
							listaItens.add(item);
						}
						p.setListaItens(listaItens);
						lPedidos.add(p);
					}
					reader.close();
					return lPedidos;
				}catch(IOException ex){
					throw new SCVPersistenciaException("Arquivo nao Encotrando");
				}
	}		
}	

