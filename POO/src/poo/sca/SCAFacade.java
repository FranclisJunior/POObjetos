package poo.sca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import poo.sca.io.SCAPersistencia;
import poo.sca.io.SCAPersistenciaArquivo;
import poo.sca.io.SCAPersistenciaException;
import poo.sca.io.SCAPersistenciaMemoria;

public class SCAFacade {	
	
	public SCAPersistencia persistencia =  new SCAPersistenciaArquivo();
	
	public Turma criarTurma(String periodo,int num,String hor) throws SCAException, SCARuntimeException{
		Turma turma = new Turma();
		ArrayList<Professor> professores= new ArrayList<Professor>();
		ArrayList<Curso> cursos =new ArrayList<Curso>();
		
		
		//Adiciona uma disciplina na turma
		int numD = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Disciplina"));
		boolean z = true;
		do{
			Disciplina d = verificaCodDisciplina(numD);			
			if(d!=null){
				turma.setDisciplina(d);				
				z = false;
			}else{
				JOptionPane.showMessageDialog(null,"Nao existe Disciplina com esse codigo na lista de Disciplinas");
				numD = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Numero da Disciplina"));
			}
		}while(z);
		
		// Adiciona professores na turma
		boolean y =true;
		int numMatricula = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a matricula do Professor"));
		do{ 			
			Professor p = verificaMatriculaProfessor(numMatricula);
			if(p!=null){				
				professores.add(p);
				int adP = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja Adcionar Outro Professor?\n 1-Sim\n 0-Nao"));
				if(adP==0){
					y = false;
				}if(adP==1){
					numMatricula = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a matricula do Professor"));				
				}
			}else{
				JOptionPane.showMessageDialog(null, "Nao existe professor com essa matricula na lista de Professores");
				numMatricula = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a matricula do Professor"));
			}		
		}while(y);
		
		
		
		//Adciona Cursos na turma
		boolean w = true;
		int codCurso = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo do Curso"));
		do{			
			Curso curso = verificaCodCurso(codCurso);
			if(curso!=null){
				cursos.add(curso);
				int adC = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja Adcionar Outro Curso?\n 1-Sim\n 0-Nao"));
				if(adC==0){
					w = false;
				}if(adC==1){
					codCurso = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo do Curso"));
				}
			}else{
				JOptionPane.showMessageDialog(null,"Nao existe Curso com esse codigo na lista de Cursos");
				codCurso = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo do Curso"));
			}			
		}while(w);
		
		
		try{
			//verifica se existe dados iguais na turma; 
			ArrayList<Turma> turm = persistencia.recuperarTurmas();
			for(Turma t : turm){
				if(periodo.equals(t.getPeriodo()) && num==t.getNumero()){
					throw new SCAException();
				}
			}
			
			//seta os dados da turma e depois salva no arquivo
			turma.setPeriodo(periodo);			
			turma.setNumero(num);
			turma.setHorario(hor);
			turma.setProfessor(professores);
			turma.setCurso(cursos);
			persistencia.salvar(turma);			
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro ao salvar");
		}
		return turma;
	}
	

	public Disciplina criarDisciplina()throws SCAException, SCARuntimeException {
		boolean c = true;
		int cod= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo da Disciplina"));
		
		//verifica se o codigo da disciplina é maior que 9999
		do{
			if(cod>9999){
				JOptionPane.showMessageDialog(null,"Erro interno do sistema. Por favor procure o suporte.");
				cod= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo da Disciplina"));
			}else{
				c=false;
			}
			
		}while(c);
		
		String nome= JOptionPane.showInputDialog(null,"Digite o Nome da Disciplina");
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(cod);
		disciplina.setNome(nome);
		
		// Testa se ja tem disciplina com o mesmo codigo na lista antes salvar no arquivo.	
		try{		
			ArrayList<Disciplina> disc = persistencia.recuperarDisciplinas();		
			for(Disciplina d : disc){
				if(cod==d.getCodigo()){
					throw new SCAException();
				}
			}		
			persistencia.salvar(disciplina);			
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro ao salvar");
		}
		return disciplina;
	}
	
	public Professor criarProfessor()throws SCAException, SCARuntimeException{
		int matricula= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Matricula do Professor(a)"));
		String n= JOptionPane.showInputDialog(null,"Digite o Nome do Professor(a)");
		Professor professor = new Professor();
		professor.setMatricula(matricula);
		professor.setNome(n);
		
		// testa se ja existe professor com a mesma matricula na lista antes de salvar no arquivo	
		try{ 		
			ArrayList<Professor> prof = persistencia.recuperarProfessores();		
			for(Professor p:prof){
				if(matricula==p.getMatricula()){
					throw new SCAException();
				}
			}			
			persistencia.salvar(professor);
		
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro ao salvar");
		}
		
		return professor;
	}
	
	public Curso criarCurso()throws SCAException, SCARuntimeException {
		Curso curso = new Curso();
		try{
			int cod= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo do Curso"));
			String nome= JOptionPane.showInputDialog(null,"Digite o Nome do Curso");
			ArrayList<Curso> curs = persistencia.recuperarCursos();
			for(Curso crs: curs){
				if(cod==crs.getCodigo()){
					throw new SCAException();
				}
			}
			
			curso.setCodigo(cod);
			curso.setNome(nome);
			persistencia.salvar(curso);
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro ao salvar");
		}
		return curso;	
	}
	
	public Turma getTurma(String per,int codDisciplina, int num){
		Turma turma=null;
		String periodo;
		int cod;
		int numero;		
		Iterator<Turma> it = getTurmasIterator();
		while(it.hasNext()){
			Turma t = it.next();
			periodo = t.getPeriodo();
			cod = t.getDisciplina().getCodigo();
			numero = t.getNumero();
			
			if(periodo.equals(per) && cod==codDisciplina && numero==num){
				turma = t;
			}
			
		}
		return turma;
		
	}
	
	public Iterator<Turma> getTurmasIterator(){
		try{
			return persistencia.recuperarTurmas().iterator();
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro ao salvar");
		}		
		return null;
	}
	
	public Iterator<Curso> getCursosIterator(){
		try{
			return persistencia.recuperarCursos().iterator();
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro ao salvar ");
		}
		return null;
	}
	
	public Iterator<Disciplina> getDisciplinasIterator(){
		try{	
			return persistencia.recuperarDisciplinas().iterator();
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro ao salvar ");
		}
		return null;
	}
	
	public Iterator<Professor> getProfessoresIterator(){
		Iterator<Professor> it = null;
		try{
			it= persistencia.recuperarProfessores().iterator();
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro salvar");
		}
		return it;
			
	}
	
	public Turma removerTurma(String per,int codDisciplina, int num){
		Turma turma=null;
		String periodo;
		int cod;
		int numero;		
		Iterator<Turma> it = getTurmasIterator();
		while(it.hasNext()){
			Turma t = it.next();
			periodo = t.getPeriodo();
			cod = t.getDisciplina().getCodigo();
			numero = t.getNumero();
			
			if(periodo.equals(per) && cod==codDisciplina && numero==num){
				turma = t;
				it.remove();				
			}
			
		}
		
		return turma;
	}
	
	// verifica se tem uma disciplina na lista de disciplinas com o codigo passado antes de adicionar na turma.	
	public Disciplina verificaCodDisciplina(int cod){	
		Iterator<Disciplina> itD = getDisciplinasIterator();
		Disciplina dis = null;
		while(itD.hasNext()){
			Disciplina d = itD.next();
			if(d.getCodigo()==cod){
				dis=d;								
			}
		}
		return dis;
	}
	
	// verifica se tem um professor na lista de professores com a matricula passada antes de adicionar na turma;
	public Professor verificaMatriculaProfessor(int matric){ 	
		Professor prof = null;
		Iterator<Professor> itP = getProfessoresIterator();
		while(itP.hasNext()){
			Professor p = itP.next();
			if(p.getMatricula()==matric){
				prof=p;
			}
		}
		return prof;
	}
	
	public Curso verificaCodCurso(int cod){
		Curso curso = null;
		Iterator<Curso> itC = getCursosIterator();
		while(itC.hasNext()){
			Curso c = itC.next();
			if(c.getCodigo()==cod){
				curso = c;
			}
		}
		return curso;
	}
	
	//Metodo para ver mais detalhes da Turma selecionada
		public  void verDetalhes(int num){
			int numero;		
			Iterator<Turma> it3 = getTurmasIterator();
			Turma turma = null;
			while(it3.hasNext()){
				Turma t = it3.next();
				numero= t.getNumero();			
				if(numero==num){
					turma = t;
				}		
			}
			if(turma!=null){
				String turmas="Dados da Turma: \n\n";
				String prd,disci_nome,disci_cod,horario;
				
				//recupera os professores da turma
				ArrayList<Professor> prof = turma.getProfessor();
				String nomesProf="Professores: \n";
				for(Professor p: prof){
					nomesProf += p.getNome()+"\n";
				}
				
				//recupera os cursos da turmma
				ArrayList<Curso> crs = turma.getCurso();
				String nomesCursos= "Cursos: \n";
				for(Curso c : crs){
					nomesCursos+=c.getNome()+"\n";
				}
							
				numero= turma.getNumero();
				prd= turma.getPeriodo();
				disci_nome =turma.getDisciplina().getNome()+" ";
				disci_cod =""+turma.getDisciplina().getCodigo();
				horario = "Horario : "+turma.getHorario();
				turmas+= "Numero : "+numero+" "+"\nPeriodo : "+prd+"\n"+"Nome Disciplina : "+disci_nome+"\nCodigo Disciplina :"+disci_cod+"\n"+horario+"\n\n"+nomesProf+"\n"+nomesCursos;
				JOptionPane.showMessageDialog(null,turmas);	
			}else{
				JOptionPane.showMessageDialog(null,"Nao existe turma com esse numero");
			}		
		}
}
