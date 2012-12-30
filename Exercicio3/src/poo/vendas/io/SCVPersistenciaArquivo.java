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
import poo.vendas.Produto;


public class SCVPersistenciaArquivo implements SCVPersistencia{

	private File arquivoCliente;
	private File arquivoProduto;

	public SCVPersistenciaArquivo() {
		arquivoCliente = new File("Arquivos/clientes.txt");
		arquivoProduto = new File("Arquivos/produtos.txt");		
		
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
	
	
	
}
