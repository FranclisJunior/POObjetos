package poo.vendas.iu;

import java.awt.Menu;

import javax.swing.JOptionPane;

import poo.vendas.Cliente;
import poo.vendas.ControleDeVendas;
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
					"\n\n 0-Sair"));
			
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
							
							Cliente c = controle.getCliente(cpfs);
							if(c!=null){
								JOptionPane.showMessageDialog(null,"Dados do Cliente\n Nome: "+c.getNome()+ "\n CPF: "+ c.getCpf()+"\n Telefone: "+c.getTelefone());
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
					int op21= Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma Opcao: \n\n 1-Adcionar Produto \n 2-Perquisar Cliente" +
							" \n\n 0-Voltar "));
					switch(op21){
					case(1):					
						String nome = JOptionPane.showInputDialog(null,"Digite o nome do Produto:");
						int cod = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o codigo do Produto:"));
						String descricao = JOptionPane.showInputDialog(null,"Digite a descriçao do Produto:");
						Double preco = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o codigo do Produto:"));
						Produto p = new Produto(nome,cod,descricao,preco);
						try{
							controle.addProduto(p);
						}catch(SCVRuntimeException ex){
							JOptionPane.showMessageDialog(null, ex.getMessage());
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
			case(0):
				cnd=false;
				break;			
			}						
		}		
	}
}
