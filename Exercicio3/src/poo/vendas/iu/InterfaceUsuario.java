package poo.vendas.iu;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import poo.vendas.Cliente;
import poo.vendas.ControleDeVendas;
import poo.vendas.Pedido;
import poo.vendas.Produto;
import poo.vendas.SCVException;
import poo.vendas.SCVRuntimeException;


public class InterfaceUsuario {
	
	public static void main(String [] args){
		InterfaceUsuario.menu();
		
	}
	
	public static void menu(){
		
		ControleDeVendas controle = new ControleDeVendas();
		
		boolean cnd=true;		
		while(cnd){	
							
			int op = Integer.parseInt( JOptionPane.showInputDialog(null,"Sistema de Controle de Vendas\n\n  Digite uma Opçao: \n\n 1-Gerenciar Clientes \n 2-Gerenciar Produtos" +
					"\n 3-Gerenciar Pedidos\n\n 0-Sair"));
			
			switch(op){
			case(1):
				
				boolean cnd1 = true;
				while(cnd1){
					int op11=Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma Opcao: \n\n 1-Adcionar Cliente \n 2-Perquisar Cliente" +
						" \n\n 0-Voltar "));
					
					switch(op11){
					case(1):
						Cliente cliente = new Cliente();						
						String nome = JOptionPane.showInputDialog(null,"Digite o nome do Cliente:");
						String cpf = JOptionPane.showInputDialog(null,"Digite o CPF do Cliente:");
						String telefone =  JOptionPane.showInputDialog(null,"Digite o telefone do Cliente:");
						cliente.setNome(nome);
						cliente.setCpf(cpf);						
						cliente.setTelefone(telefone);
						try{							
							controle.addCliente(cliente);													
						} catch (SCVException ex) {
							JOptionPane.showMessageDialog(null,"Ocorreu um problema, procure o suporte");
						} catch (SCVRuntimeException e) {
							JOptionPane.showMessageDialog(null,e.getMessage());
						}
					break;
					case(2):
						String cpfs = JOptionPane.showInputDialog(null,"Digite o CPF do Cliente:");
						try {
							
							Cliente client = controle.getCliente(cpfs);
							if(client!=null){
								JOptionPane.showMessageDialog(null,"Dados do Cliente\n Nome: "+client.getNome()+ "\n CPF: "+ client.getCpf()+"\n Telefone: "+client.getTelefone());
							}else{
								JOptionPane.showMessageDialog(null, "Nao existe Cliente com esse cpf");
							}
						} catch (SCVException e) {
							JOptionPane.showMessageDialog(null,"Ocorreu um problema, procure o suporte");
						}
					break;
					case(0):	
						cnd1 = false;
						break;
					}					
				}
			break;
			case(2):
				int cnd2 = 1;
				while(cnd2!=0){
					int op21= Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma Opcao: \n\n 1-Adcionar Produto \n 2-Perquisar Produto" +
							" \n\n 0-Voltar "));
					switch(op21){
					case(1):					
						String nome = JOptionPane.showInputDialog(null,"Digite o nome do Produto:");
						int cod = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o codigo do Produto:"));
						String descricao = JOptionPane.showInputDialog(null,"Digite a descriçao do Produto:");
						Double preco = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o preco do Produto:"));
											
						Produto produtoPerecivel = new Produto(nome,cod,descricao,preco);		
						
						try{
							controle.addProduto(produtoPerecivel);
						}catch(SCVRuntimeException ex){
							JOptionPane.showMessageDialog(null, ex.getMessage());
						} catch (SCVException e) {
							JOptionPane.showMessageDialog(null,"Ocorreu um problema, procure o suporte");
						}
					break;
					case(2):
						int codProduto = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o codigo do Produto:"));
						try {
							Produto produto = controle.getProduto(codProduto);
							if(produto!=null){
								JOptionPane.showMessageDialog(null,"Dados do Produto\n  Nome:"+produto.getNome()+"\n  Codigo: "+produto.getId()+"\n  Preco: "+produto.getPreco());
							}else{
								JOptionPane.showMessageDialog(null,"Nao existe produto com esse codigo");
							}
						} catch (SCVException e) {
							JOptionPane.showMessageDialog(null,"Ocorreu um problema, procure o suporte");
						}
					break;
					case(0):
						cnd2=0;
						break;
					}	
				}
			break;	
			case(3):
				int cnd3 = 1;
				while(cnd3!=0){
					int op21= Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma Opcao: \n\n 1-Novo Pedido \n 2-Ver Pedidos por Data \n 3-Ver Pedidos por Cliente" +
							" \n\n 0-Voltar "));
					switch(op21){
					case(1):
						String cpfs = JOptionPane.showInputDialog(null,"Digite o CPF do Cliente:");
						try {							
							Cliente c = controle.getCliente(cpfs);
							if(c!=null){
								JOptionPane.showMessageDialog(null,"Cliente: "+c.getNome());
								controle.novoPedido(c);								
							}else{
								JOptionPane.showMessageDialog(null, "Nao existe Cliente com esse cpf");
							}
						} catch (SCVException e) {
							JOptionPane.showMessageDialog(null,"Ocorreu um problema, procure o suporte");						
						} catch (SCVRuntimeException e) {
							JOptionPane.showMessageDialog(null,e.getMessage());
						}
					break;
					case(2):
						String data = JOptionPane.showInputDialog(null,"Digite a data do Pedido");
						try {
							ArrayList<Pedido> pedidosData = controle.listarPedidos(data);
							if(pedidosData!=null){
								StringBuilder detalhespedido= controle.mostrarDetalhesPedido(pedidosData);
								JOptionPane.showMessageDialog(null,"Pedidos na Data:"+data+"\n\n"+detalhespedido);
							}else{
								JOptionPane.showMessageDialog(null,"Nao existe pedido nessa data");
							}
						} catch (SCVException e) {
							JOptionPane.showMessageDialog(null,"Ocorreu um problema, procure o suporte");
						}
					break;
					case(3):
						String cpf = JOptionPane.showInputDialog(null,"Digite o CPF do Cliente: ");
						try{
							Cliente cliente = controle.getCliente(cpf);
							ArrayList<Pedido> pedidosCliente = controle.listarPedidos(cliente);
							if(pedidosCliente!=null){
								StringBuilder detalhesPedidoCliente = controle.mostrarDetalhesPedido(pedidosCliente);
								JOptionPane.showMessageDialog(null,"Pedidos do Cliente:"+cliente.getNome()+"\n\n"+detalhesPedidoCliente);
							}else{
								JOptionPane.showMessageDialog(null,"Nao existe pedido deste cliente");
							}
						}catch(SCVException ex){
							
						}
					break;	
					case(4):						
						try {
							ArrayList<Pedido> lPedidos = controle.getPedidos();
							StringBuilder detalhes = new StringBuilder();
							for(Pedido p: lPedidos){								
								detalhes.append("Nome do Cliente: "+p.getCliente().getNome()+"\nCodigo Pedido: "+p.getCodigoPedido()+"\nData: "+p.getData()+"\nValor do Pedido: "+p.totalPedido()+"\n\n");								
							}
							JOptionPane.showMessageDialog(null, detalhes);						
						} catch (SCVException e) {							
							JOptionPane.showMessageDialog(null,"Ocorreu um problema, procure o suporte");
						}						
					break;
					case(0):
						cnd3=0;
						break;
					}					
				}	
			break;				
			case(0):
				cnd=false;
				break;			
			}						
		}		
	}
}
