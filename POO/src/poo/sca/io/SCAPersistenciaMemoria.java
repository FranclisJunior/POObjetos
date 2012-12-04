package poo.sca.io;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public class SCAPersistenciaMemoria implements SCAPersistencia {
	
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	private ArrayList<Disciplina> disciplinas= new ArrayList<Disciplina>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Curso> cursos=new ArrayList<Curso>();
		
	
	public void salvar(Turma turma)throws SCAPersistenciaException  {
		turmas.add(turma);
	}

	
	public ArrayList<Turma> recuperarTurmas()throws SCAPersistenciaException  {	
		return turmas;
	}

	
	public void salvar(Disciplina disciplina)throws SCAPersistenciaException {
		disciplinas.add(disciplina);
		
	}

	
	public ArrayList<Disciplina> recuperarDisciplinas()throws SCAPersistenciaException  {
		return disciplinas;
	}

	
	public void salvar(Professor professor) throws SCAPersistenciaException {
		professores.add(professor);
				
	}

	
	public ArrayList<Professor> recuperarProfessores() throws SCAPersistenciaException {		
		return professores;
	}

	
	public void salvar(Curso curso) throws SCAPersistenciaException{
		cursos.add(curso);		
	}

	
	public ArrayList<Curso> recuperarCursos() throws SCAPersistenciaException {
		return cursos;		
	}

}
