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

	public void setProfessor(ArrayList<Professor> professor){
		this.professores = professor;
	}
	
	public ArrayList getProfessor(){
		return professores;		
	}
	
	public void setCurso(ArrayList<Curso> curso){
		this.cursos=curso;
	}
	
	public ArrayList getCurso(){
		return cursos;		
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
