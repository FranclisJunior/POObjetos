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
	
	public Turma criarTurma(String periodo,Disciplina disciplina,int num,String hor) throws SCAException, SCARuntimeException{
		Turma turma = new Turma();
		try{
			ArrayList<Turma> turm = persistencia.recuperarTurmas();
			for(Turma t : turm){
				if(periodo.equals(t.getPeriodo()) && num==t.getNumero() && disciplina.getCodigo()== t.getDisciplina().getCodigo()){
					throw new SCAException();
				}
			}
			
			turma.setPeriodo(periodo);
			turma.setDisciplina(disciplina);
			turma.setNumero(num);
			turma.setHorario(hor);
			persistencia.salvar(turma);			
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro quase impossivel!Erro ao salvar na memoria");
		}
		return turma;
	}
	

	public Disciplina criarDisciplina()throws SCAException, SCARuntimeException {
		int cod= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Codigo da Disciplina"));
		String nome= JOptionPane.showInputDialog(null,"Digite o Nome da Disciplina");
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(cod);
		disciplina.setNome(nome);
		try{
			
			ArrayList<Disciplina> disc = persistencia.recuperarDisciplinas();		
			for(Disciplina d : disc){
				if(cod==d.getCodigo()){
					throw new SCAException();
				}
			}		
			persistencia.salvar(disciplina);
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro quase impossivel!Erro ao salvar na memoria");
		}
		return disciplina;
	}
	
	public Professor criarProfessor()throws SCAException, SCARuntimeException{
		int matricula= Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o Matricula do Professor(a)"));
		String n= JOptionPane.showInputDialog(null,"Digite o Nome do Professor(a)");
		Professor professor = new Professor();
		professor.setMatricula(matricula);
		professor.setNome(n);
		try{			
			ArrayList<Professor> prof = persistencia.recuperarProfessores();		
			for(Professor p:prof){
				if(matricula==p.getMatricula()){
					throw new SCAException();
				}
			}			
			persistencia.salvar(professor);
		
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro quase impossivel!Erro ao salvar na memoria");
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
				}
			}
			
			curso.setCodigo(cod);
			curso.setNome(nome);
			persistencia.salvar(curso);
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro quase impossivel!Erro ao salvar na memoria");
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
			JOptionPane.showMessageDialog(null,"Erro quase impossivel!Erro ao salvar na memoria");
		}		
		return null;
	}
	
	public Iterator<Curso> getCursosItetator(){
		try{
			return persistencia.recuperarCursos().iterator();
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro quase impossivel!Erro ao salvar na memoria");
		}
		return null;
	}
	
	public Iterator<Disciplina> getDisciplinasIterator(){
		try{	
			return persistencia.recuperarDisciplinas().iterator();
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro quase impossivel!Erro ao salvar na memoria");
		}
		return null;
	}
	
	public Iterator<Professor> getProfessoresIterator(){
		Iterator<Professor> it = null;
		try{
			it= persistencia.recuperarProfessores().iterator();
		}catch(SCAPersistenciaException ex){
			JOptionPane.showMessageDialog(null,"Erro quase impossivel!Erro ao salvar na memoria");
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
	
	public Disciplina verificaDisciplina(int cod){		
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
	
}
