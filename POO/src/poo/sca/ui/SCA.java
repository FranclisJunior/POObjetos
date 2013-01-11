package poo.sca.ui;


import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

import poo.logger.Logger;
import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.SCAException;
import poo.sca.SCAFacade;
import poo.sca.SCARuntimeException;
import poo.sca.Turma;
import poo.sca.io.SCAPersistenciaException;

public class SCA {
	private static SCAFacade facade = new SCAFacade();	

	public static void main(String [] args){		
		SCA.exibirMenu();		
	}	
	
	public static void exibirMenu(){		
		
		boolean cnd=true;		
		while(cnd){	
							
			int op = Integer.parseInt( JOptionPane.showInputDialog(null,"Digite uma Opçao: \n\n 1-Gerenciar Cursos \n " +
					"2-Gerenciar Professores \n 3-Gerenciar Disciplinas \n 4-Gerenciar Turmas \n\n 0-Sair"));
			
			switch(op){
			
			case(1): //Gerenciar Cursos
				
				boolean cnd1 = true;
				while(cnd1){
					int op1=Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma Opcao: \n\n 1-Adcionar Curso \n 2-Ver" +
							" Curso \n\n 0-Voltar "));
					
					switch(op1){
					case (1): // Adcionar Curso
						int op11= 2;
						do{
							try{
								Curso curso = facade.criarCurso();				
								JOptionPane.showMessageDialog(null,"Curso Criado");
								op11 = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja criar outro Curso? \n1-Sim \n0-Nao"));
							}catch(SCAException ex){
								Logger.getInstance().log(ex);
								JOptionPane.showMessageDialog(null, "Erro interno do sistema. Por favor procure o suporte.");
								op11=0;
							}catch(SCARuntimeException ex){
								Logger.getInstance().log(ex);
								JOptionPane.showMessageDialog(null, ex.getMessage());								
								--op11;
							}
						}while(op11==1);	
						break;
						
					case(2): //Ver Cursos				
						String cursos="Cursos: \n";
						try{
							Iterator<Curso> it = facade.getCursosIterator();					
							while(it.hasNext()){
								Curso c = it.next();				
								cursos+= "Nome : "+c.getNome()+" "+"\nCodigo : "+c.getCodigo()+"\n\n";
							}
							JOptionPane.showMessageDialog(null,cursos);
						}catch(SCAException ex)	{
							Logger.getInstance().log(ex);
							JOptionPane.showMessageDialog(null,"Erro interno do sistema. Por favor procure o suporte.");
						}
						break;
					case(0):  //Sair Menu Gerenciar Cursos
						cnd1 = false;
						break;
					}
				}
				break;
			
			case(2): //Gerenciar Professor
				
				boolean cnd2 = true;
				while(cnd2){
					int op2=Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma Opcao: \n\n 1-Adcionar Professor \n 2-Ver Professores \n\n 0-Voltar "));
					
					switch(op2){
					case(1): //Adcionar Professor
						int op21=2;
						do{
							try{	
								Professor professor = facade.criarProfessor();												
								JOptionPane.showMessageDialog(null,"Professor Criado");
								op21 = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja Criar Outro Professor? \n1-Sim \n0-Nao"));
							}catch(SCARuntimeException ex){
								Logger.getInstance().log(ex);
								--op21;
								JOptionPane.showMessageDialog(null,ex.getMessage());
							}catch(SCAException ex){
								Logger.getInstance().log(ex);
								op21= 0;
								JOptionPane.showMessageDialog(null,"Erro interno do sistema. Por favor procure o suporte.");
							} 
							
						}while(op21==1);	
						break;
						
					case(2): //Ver Professores
						String professores="Professores: \n\n";
						try{
							Iterator<Professor> it2 = facade.getProfessoresIterator();			
							while (it2.hasNext()) {
								Professor p = it2.next();
								professores += " Mátricula: " + p.getMatricula() + " \n Nome: " + p.getNome()  + "\n\n";
							}
							JOptionPane.showMessageDialog(null, professores);
						}catch(SCAException ex){
							Logger.getInstance().log(ex);
							JOptionPane.showMessageDialog(null, "Erro interno do sistema. Por favor procure o suporte.");
						}
						break;
					case(0):  //Sair Menu Gerenciar Professores
						cnd2=false;
						break;
					}
				}	
				break;
				
			case(3): //Gerenciar Disciplinas
				
				boolean cnd3 = true;
				while(cnd3){
					int op3=Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma Opcao: \n\n 1-Adcionar Disciplina \n 2-Ver Disciplina \n\n 0-Voltar "));
					
					switch(op3){
					case(1): //Adcionar Disciplinas
						int op31=1;
						do{
							try{	
								Disciplina disciplina = facade.criarDisciplina();												
								JOptionPane.showMessageDialog(null,"Disciplina Criada");
								op31 = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja criar Outra Disciplina? \n1-Sim \n0-Nao"));
							}catch(SCAException ex){
								Logger.getInstance().log(ex);
								op31=0;
								JOptionPane.showMessageDialog(null,"Erro interno do sistema. Por favor procure o suporte.");
							}catch(SCARuntimeException ex2){
								//tenta mas uma vez criar a Disciplina
								JOptionPane.showMessageDialog(null,ex2.getMessage());								
								try{									
									Disciplina	disciplina2 = facade.criarDisciplina();
								}catch(SCARuntimeException ex){
									op31=0;
									// nao teve jeito usuario nao sabe ler
									Logger.getInstance().log(ex);
									JOptionPane.showMessageDialog(null,"Erro interno do sistema. Por favor procure o suporte.");
									
								} catch (SCAException e) {
									Logger.getInstance().log(e);
									JOptionPane.showMessageDialog(null,"Erro interno do sistema. Por favor procure o suporte.");
								}								
							}							
						}while(op31==1);	
						break;
					case(2): //Ver Disciplinas
						
						String disciplinas ="Disciplinas: \n\n";
						try{
							Iterator<Disciplina> it2 = facade.getDisciplinasIterator();			
							while (it2.hasNext()) {
								Disciplina d = it2.next();
								disciplinas += " Codigo: " + d.getCodigo() + " \n Nome: " + d.getNome()  + "\n\n";
							}
							JOptionPane.showMessageDialog(null,disciplinas);
						}catch(SCAException ex)	{
							Logger.getInstance().log(ex);
							JOptionPane.showMessageDialog(null, "Erro interno do sistema. Por favor procure o suporte.");
						}
						break;
						
						
					case(0):  //Sair Menu Gerenciar Disciplinas	
						cnd3 = false;
						break;
					}
				}
					break;
				
			case(4): //Gerenciar Turmas
				
				boolean cnd4 = true;
				while(cnd4){
					
					int op4 = Integer.parseInt( JOptionPane.showInputDialog(null,"Escolha um Opçao: \n"+
							" 1-Adicionar Turma \n 2-Ver Turmas \n 3-Remover Turma \n 4-Perquisar Turma \n\n 0-Voltar "));
					
					switch(op4){				
					case(1): //Adcionar Turma
						int op41 = 1;
						do{
							String periodo= JOptionPane.showInputDialog(null,"Digite o Periodo");						
							int num= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Turma"));							
							String horario = JOptionPane.showInputDialog(null,"Digite o Horario");
							
							try{																		
								facade.criarTurma(periodo,num,horario);
								JOptionPane.showMessageDialog(null,"Turma Criada");
								op41 = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja criar outra Turma? \n1-Sim \n0-Nao"));
							}catch(SCAException ex){
								Logger.getInstance().log(ex);
								op41=0;
								JOptionPane.showMessageDialog(null,"Erro interno do sistema. Por favor procure o suporte.");
							}
						
						}while(op41==1);
						break;
						
					case(2): //Ver Turmas
						
						int numero;
						String prd,disci_nome,disci_cod,horario;						 
						String turmas="Para mais detalhes digite o numero da Turma!\n\nTurmas: \n";
						try{
							Iterator<Turma> it3 = facade.getTurmasIterator();				
							while(it3.hasNext()){
								Turma t = it3.next();
								numero= t.getNumero();
								prd= t.getPeriodo();
								disci_nome =t.getDisciplina().getNome()+" ";					
								turmas+= "Numero :"+numero+"  "+"Periodo :"+ prd +"  "+"Disciplina :"+disci_nome+"\n";
							}
							int numeroT = Integer.parseInt(JOptionPane.showInputDialog(null,turmas+"\n0-Voltar"));
							if(numeroT!=0){
								facade.verDetalhes(numeroT);							
							}
						}catch(SCAException ex){
							Logger.getInstance().log(ex);
							JOptionPane.showMessageDialog(null,"Erro interno do sistema. Por favor procure o suporte.");
						}catch(SCARuntimeException ex){
							Logger.getInstance().log(ex);
							JOptionPane.showMessageDialog(null,ex.getMessage());
						}
						break;
						
					case(3): //Remover Turma
						String p2= JOptionPane.showInputDialog(null,"Digite o Periodo da Turma");	
						int codD2= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo da Disciplian"));
						int n2= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Turma"));
						try{
							Turma turma2 = facade.getTurma(p2, codD2, n2);
							if(turma2!=null){
								JOptionPane.showMessageDialog(null,"A Turma removida foi: \n"+"Periodo :"+turma2.getPeriodo()+"\nCodigo Disciplina :"+turma2.getDisciplina().getCodigo()+"\nNome Disciplina: "+turma2.getDisciplina().getNome()+"\nNumero: "+turma2.getNumero());
								
							}else{
								JOptionPane.showMessageDialog(null,"Nao existe Turma com esses Dados");
							}
						}catch(SCAException ex){
							Logger.getInstance().log(ex);
							JOptionPane.showMessageDialog(null, "Erro interno do sistema. Por favor procure o suporte.");
						}
						break;	
						
					case(4): //Perquisar Turmas
						
						String p= JOptionPane.showInputDialog(null,"Digite o Periodo da Turma");	
						int codD= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo da Disciplian"));
						int n= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Turma"));
						try{
							Turma turma = facade.getTurma(p, codD, n);
							if(turma!=null){
								facade.verDetalhes(n);							
							}
							else{
								JOptionPane.showMessageDialog(null,"Nao existe Turma com esses Dados");							
							}
						}catch(SCAException ex){
							Logger.getInstance().log(ex);
							JOptionPane.showMessageDialog(null, "Erro interno do sistema. Por favor procure o suporte.");
						}
						break;
					case(0): //Sair Menu Gerenciar Turmas
						cnd4=false;
						break;
					}
				}
				break;
					
			
			case(0): //Sair do Programa				
				cnd=false;
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Opcao Invalida");
				break;	
			}			
		}
	}
}
