package poo.sca.io;

import java.io.IOException;
import java.util.ArrayList;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public interface SCAPersistencia {
	public void salvar(Turma turma)throws SCAPersistenciaException;
	public ArrayList<Turma> recuperarTurmas()throws SCAPersistenciaException;
	public void salvar(Disciplina disciplina)throws SCAPersistenciaException;
	public ArrayList<Disciplina> recuperarDisciplinas()throws SCAPersistenciaException ;
	public void salvar(Professor professor) throws SCAPersistenciaException;
	public ArrayList<Professor> recuperarProfessores() throws SCAPersistenciaException ;
	public void salvar(Curso curso)throws SCAPersistenciaException;
	public ArrayList<Curso> recuperarCursos() throws SCAPersistenciaException;
}
