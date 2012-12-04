package poo.sca.ui;


import java.util.Iterator;
import javax.swing.JOptionPane;
import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.SCAException;
import poo.sca.SCAFacade;
import poo.sca.SCARuntimeException;
import poo.sca.Turma;

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
			case(9):
				try {
					Disciplina disciplina = facade.criarDisciplina();
				} catch (SCARuntimeException e) {					
					e.printStackTrace();
				} catch (SCAException e) {					
					e.printStackTrace();
				}
				break;
			case(1): //Gerenciar Cursos
				
				boolean cnd1 = true;
				while(cnd1){
					int op1=Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha uma Opcao: \n\n 1-Adcionar Curso \n 2-Ver" +
							" Curso \n\n 0-Voltar "));
					
					switch(op1){
					case (1): // Adcionar Curso
						int op11= 1;
						do{
							try{
								Curso curso = facade.criarCurso();				
								JOptionPane.showMessageDialog(null,"Curso Criado");
								op11 = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja criar outro Curso? \n1-Sim \n0-Nao"));
							}catch(SCAException ex){						
								op11=0;
							}					
						}while(op11==1);	
						break;
						
					case(2): //Ver Cursos				
						String cursos="Cursos: \n";				
						Iterator<Curso> it = facade.getCursosItetator();					
						while(it.hasNext()){
							Curso c = it.next();				
							cursos+= "Nome : "+c.getNome()+" "+"\nCodigo : "+c.getCodigo()+"\n\n";
						}
						JOptionPane.showMessageDialog(null,cursos);
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
						int op21=1;
						do{
							try{	
								Professor professor = facade.criarProfessor();												
								JOptionPane.showMessageDialog(null,"Professor Criado");
								op21 = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja Criar Outro Professor? \n1-Sim \n0-Nao"));
							}catch(SCAException ex){
								op21=0;
								JOptionPane.showMessageDialog(null,"Ja Existe Professor com essa matricula");
							}
							
						}while(op21==1);	
						break;
						
					case(2): //Ver Professores
						String professores="Professores: \n";
						Iterator<Professor> it2 = facade.getProfessoresIterator();			
						while (it2.hasNext()) {
							Professor p = it2.next();
							professores += " Mátricula: " + p.getMatricula() + " \n Nome: " + p.getNome()  + "\n";
						}
						JOptionPane.showMessageDialog(null, professores);
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
								op31=0;
								JOptionPane.showMessageDialog(null,"Ja Existe Disciplina com esse Codigo");
							}
							
						}while(op31==1);	
						break;
					case(2): //Ver Disciplinas
						
						String disciplinas ="Disciplinas: \n\n";
						Iterator<Disciplina> it2 = facade.getDisciplinasIterator();			
						while (it2.hasNext()) {
							Disciplina d = it2.next();
							disciplinas += " Codigo: " + d.getCodigo() + " \n Nome: " + d.getNome()  + "\n\n";
						}
						JOptionPane.showMessageDialog(null,disciplinas);
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
					
					int op4 = Integer.parseInt( JOptionPane.showInputDialog(null,"Escolha um Opçao: \n" +
							"1-Adicionar Turma \n 2-Ver Turmas \n 3-Remover Turma \n 4-Perquisar Turma \n\n 0-Voltar "));
					
					switch(op4){				
					case(1): //Adcionar Turma
						int op41 = 1;
						do{
							String periodo= JOptionPane.showInputDialog(null,"Digite o Periodo");						
							int num= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Turma"));
							int numD = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Disciplina"));
							try{						
								Disciplina d = facade.verificaDisciplina(numD);
								if(d!=null){
									facade.criarTurma(periodo,d,num);
									JOptionPane.showMessageDialog(null,"Turma Criada");
								}else{
									JOptionPane.showMessageDialog(null,"Nao existe Disciplina com esse Codigo");
								}					
								op41 = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja criar outra Turma? \n1-Sim \n0-Nao"));
							}catch(SCAException ex){
								op41=0;
								JOptionPane.showMessageDialog(null,"Ja existe Turma com esses dados");
							}
						
						}while(op41==1);
						break;
						
					case(2): //Ver Turmas
						
						int numero;
						String prd;	
						String disci_nome;
						String disci_cod; 
						String turmas="Turmas: \n";
						Iterator<Turma> it3 = facade.getTurmasIterator();				
						while(it3.hasNext()){
							Turma t = it3.next();
							numero= t.getNumero();
							prd= t.getPeriodo();
							disci_nome ="Nome da Disciplina: "+ t.getDisciplina().getNome()+" ";
							disci_cod ="Cod: "+t.getDisciplina().getCodigo();
							turmas+= "Numero : "+numero+" "+"\nPeriodo : "+prd+"\n"+disci_nome+" "+disci_cod+"\n\n";
						}
						JOptionPane.showMessageDialog(null,turmas);					
						break;
						
					case(3): //Remover Turma
						String p2= JOptionPane.showInputDialog(null,"Digite o Periodo da Turma");	
						int codD2= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo da Disciplian"));
						int n2= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Turma"));
						Turma turma2 = facade.getTurma(p2, codD2, n2);
						if(turma2==null){
							JOptionPane.showMessageDialog(null,"Nao existe Turma com esses Dados");
						}
						else{
							JOptionPane.showMessageDialog(null,"A Turma removida foi: \n"+"Periodo :"+turma2.getPeriodo()+"\nCodigo Disciplina :"+turma2.getDisciplina().getCodigo()+"\nNome Disciplina: "+turma2.getDisciplina().getNome()+"\nNumero: "+turma2.getNumero());
						}
						break;	
						
					case(4): //Perquisar Turmas
						
						String p= JOptionPane.showInputDialog(null,"Digite o Periodo da Turma");	
						int codD= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo da Disciplian"));
						int n= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Turma"));
						Turma turma = facade.getTurma(p, codD, n);
						if(turma==null){
							JOptionPane.showMessageDialog(null,"Nao existe Turma com esses Dados");
						}
						else{
							JOptionPane.showMessageDialog(null,"Periodo :"+turma.getPeriodo()+"\nCodigo Disciplina :"+turma.getDisciplina().getCodigo()+"\nNome Disciplina: "+turma.getDisciplina().getNome()+"\nNumero: "+turma.getNumero());
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
			}			
		}
	}
}
