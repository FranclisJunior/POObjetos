package poo.sca.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public class SCAPersistenciaArquivo implements SCAPersistencia {

	private File arquivoDisciplina;
	private File arquivoCurso;
	private File arquivoTurma;
	private File arquivoProfessor;

	public SCAPersistenciaArquivo() {
		arquivoDisciplina = new File("Arquivos/disciplinas.txt");
		arquivoTurma = new File("Arquivos/turmas.txt");
		arquivoProfessor = new File("Arquivos/professores.txt");
		arquivoCurso = new File("Arquivos/cursos.txt");
	}

	
	public void salvar(Disciplina disciplina) throws SCAPersistenciaException {
		StringBuilder linha = new StringBuilder();
		linha.append(disciplina.getCodigo() + ":" + disciplina.getNome() + "\r\n");
		try {
			FileWriter out = new FileWriter(arquivoDisciplina, true);
			boolean file = new File("Arquivos").mkdirs();
			out.write(linha.toString());
			out.close();
		} catch (IOException e) {
			throw new SCAPersistenciaException("Arquivo nao Encotrando");
		}
	}
	
	public void salvar(Curso curso) throws SCAPersistenciaException {
		StringBuilder linha = new StringBuilder();
		linha.append(curso.getCodigo() + ":" + curso.getNome() + "\r\n");
		try {
			FileWriter out = new FileWriter(arquivoCurso, true);
			boolean file = new File("Arquivos").mkdirs();
			out.write(linha.toString());
			out.close();
		} catch (IOException e) {
			throw new SCAPersistenciaException("Arquivo nao Encotrando");
		}
		
	}
	
	public void salvar(Professor prof) throws SCAPersistenciaException {
		StringBuilder linha = new StringBuilder();
		linha.append(prof.getMatricula() + ":" + prof.getNome() + "\r\n");
		try {
			FileWriter out = new FileWriter(arquivoProfessor, true);
			boolean file = new File("Arquivos").mkdirs();
			out.write(linha.toString());
			out.close();
		} catch (IOException e) {
			throw new SCAPersistenciaException("Arquivo nao Encotrando");
		}
	}
	
	public void salvar(Turma turma)throws SCAPersistenciaException{
		StringBuilder linha = new StringBuilder();
		linha.append(turma.getPeriodo()+ ":" +turma.getNumero()+ ":" +turma.getHorario()+ ":" +turma.getDisciplina().getCodigo()+":"+turma.getDisciplina().getNome()+"\r\n");
		
		ArrayList<Professor> prof = turma.getProfessor();		
		for(Professor p : prof){
			linha.append(p.getMatricula()+":"+p.getNome());
		}
		linha.append("\r\n");
		
		ArrayList<Curso> curso = turma.getCurso();		
		for(Curso c : curso){
			linha.append(c.getCodigo()+":"+c.getNome());
		}
		linha.append(System.getProperty("line.separator"));
		
		try {
			FileWriter out = new FileWriter(arquivoTurma, true);
			boolean file = new File("Arquivos").mkdirs();
			out.write(linha.toString());			
			out.close();
		} catch (IOException e) {
			throw new SCAPersistenciaException("Arquivo nao Encotrando");
		}
	}
	

	@Override
	public ArrayList<Disciplina> recuperarDisciplinas() throws SCAPersistenciaException {
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		if (!arquivoDisciplina.exists())
			return disciplinas;

		FileInputStream in;
		int nlinha = 0;
		try {
			in = new FileInputStream(arquivoDisciplina);
			BufferedReader reader = new BufferedReader(	new InputStreamReader(in));

			String linha;
			
			while ((linha = reader.readLine()) != null) {
				nlinha++;
				StringTokenizer tokens = new StringTokenizer(linha,":");
				if(tokens.countTokens() != 2)
					throw new SCAPersistenciaException();
				Disciplina disc = new Disciplina();
				disc.setCodigo(Integer.parseInt(tokens.nextToken()));
				disc.setNome(tokens.nextToken());
				disciplinas.add(disc);
			}
			reader.close();
		} catch (Exception e) {
			throw new SCAPersistenciaException();
		}
		return disciplinas;
	}

	public ArrayList<Professor> recuperarProfessores() throws SCAPersistenciaException {
		ArrayList<Professor> prof = new ArrayList<Professor>();
		if (!arquivoProfessor.exists())
			return prof;

		FileInputStream in;
		int nlinha = 0;
		try {
			in = new FileInputStream(arquivoProfessor);
			BufferedReader reader = new BufferedReader(	new InputStreamReader(in));

			String linha;
			while ((linha = reader.readLine()) != null) {
				nlinha++;
				StringTokenizer tokens = new StringTokenizer(linha,":");
				if(tokens.countTokens() != 2)
					throw new SCAPersistenciaException();
				Professor professor = new Professor();
				professor.setMatricula(Integer.parseInt(tokens.nextToken()));
				professor.setNome(tokens.nextToken());
				prof.add(professor);
			}
			reader.close();
		} catch (Exception e) {
			throw new SCAPersistenciaException();
		}
		return prof;
	}


	@Override
	public ArrayList<Turma> recuperarTurmas() throws SCAPersistenciaException {
		ArrayList<Turma> turma = new ArrayList<Turma>();
		if (!arquivoTurma.exists())
			return turma;

		FileInputStream in;
		int nlinha = 0;
		try {
			in = new FileInputStream(arquivoTurma);
			BufferedReader reader = new BufferedReader(	new InputStreamReader(in));

			String linha,linha2,linha3;	
			
		while((linha = reader.readLine())!=null){
			Turma t = new Turma();
			StringTokenizer tokens = new StringTokenizer(linha,":");	
			t.setPeriodo(tokens.nextToken());
			t.setNumero(Integer.parseInt(tokens.nextToken()));
			t.setHorario(tokens.nextToken());
			Disciplina d = new Disciplina();
			d.setCodigo(Integer.parseInt(tokens.nextToken()));
			d.setNome(tokens.nextToken());
			t.setDisciplina(d);	
			
			
			linha2 = reader.readLine();
				ArrayList<Professor> professor = new ArrayList<Professor>();
				StringTokenizer tokens2 = new StringTokenizer(linha2,":");				
				Professor p = new Professor();
				p.setMatricula(Integer.parseInt(tokens2.nextToken()));
				p.setNome(tokens2.nextToken());
				professor.add(p);			
				t.setProfessor(professor);
			
			
			
				
			linha3 = reader.readLine();
				ArrayList<Curso> curso = new ArrayList<Curso>();
				StringTokenizer tokens3 = new StringTokenizer(linha3,":");				
				Curso c = new Curso();
				c.setCodigo(Integer.parseInt(tokens3.nextToken()));
				c.setNome(tokens3.nextToken());
				curso.add(c);
				t.setCurso(curso);
											
		turma.add(t);			
		}					
		reader.close();
		} catch (Exception e) {
			throw new SCAPersistenciaException();
		}
		return turma;
	
	}
	
	
	@Override
	public ArrayList<Curso> recuperarCursos() throws SCAPersistenciaException {
		ArrayList<Curso> curso = new ArrayList<Curso>();
		if (!arquivoCurso.exists())
			return curso;

		FileInputStream in;
		int nlinha = 0;
		try {
			in = new FileInputStream(arquivoCurso);
			BufferedReader reader = new BufferedReader(	new InputStreamReader(in));

			String linha;
			while ((linha = reader.readLine()) != null) {
				nlinha++;
				StringTokenizer tokens = new StringTokenizer(linha,":");
				if(tokens.countTokens() != 2)
					throw new SCAPersistenciaException();
				Curso c = new Curso();
				c.setCodigo(Integer.parseInt(tokens.nextToken()));
				c.setNome(tokens.nextToken());
				curso.add(c);
			}
			reader.close();
		} catch (Exception e) {
			throw new SCAPersistenciaException();
		}
		return curso;
	}
	
}