package poo.sca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Turma implements Serializable {
	private Disciplina disciplina;
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Curso> cursos = new  ArrayList<Curso>();
	private String horario;
	private int numero;
	private String periodo;
	
	public Turma(String periodo, Disciplina disciplina, int num){
		this.periodo=periodo;
		this.disciplina=disciplina;
		this.numero=num;
	}
	
	public Turma() {		
		
	}

	public void addProfessor(Professor professor){
		professores.add(professor);
	}
	
	public Iterator<Professor> getProfessor(){
		return professores.iterator();
		
	}
	public Iterator<Curso> getCurso(){
		return cursos.iterator();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}
