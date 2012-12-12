package poo.sca.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public class SCAPersistenciaArquivo1 implements SCAPersistencia{
	private ArrayList<Turma> turmas;
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<Curso> cursos;
	private ArrayList<Professor> professores;	
	
	
	public void salvar(Turma turma) {
		turmas.add(turma);
		gravarArquivos(turmas,"Arquivos/turmas.ser");
	}

	public void salvar(Disciplina disciplina) {
		disciplinas.add(disciplina);
		gravarArquivos(disciplinas,"Arquivos/disciplinas.ser");
	}

	public void salvar(Professor professor) {
		professores.add(professor);
		gravarArquivos(professores, "Arquivos/professores.ser");
	}
	
	public void salvar(Curso curso) {
		cursos.add(curso);
		gravarArquivos(cursos,"Arquivos/cursos.ser");
		
	}

	public ArrayList<Turma> recuperarTurmas() throws SCAPersistenciaException {
		String caminho = "Arquivos/turmas.ser";
		FileInputStream fis = null; 
		ObjectInputStream ois = null;
		turmas = new ArrayList<Turma>();		
		try{
			fis = new FileInputStream(caminho);
			ois = new ObjectInputStream(fis);			
			turmas = (ArrayList<Turma>) ois.readObject();			
			ois.close();
		}catch(StreamCorruptedException erro){
			JOptionPane.showMessageDialog(null, "Stream Corrupted Error!");
		}catch(InvalidClassException erro){
			JOptionPane.showMessageDialog(null, "Erro de Classe no Arquivo");
		}catch(FileNotFoundException erro1){
			JOptionPane.showMessageDialog(null, "Arquivo Não Encontrado!");
		}catch (IOException e){
			JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo!");
		} catch (ClassNotFoundException e) {			
			JOptionPane.showMessageDialog(null,"Nenhuma classe encontrada!");		
		}		
		return turmas;
	}


	public ArrayList<Disciplina> recuperarDisciplinas(){			
		ObjectInputStream in;
		disciplinas = new ArrayList<Disciplina>();
		try {
			in = new ObjectInputStream(new FileInputStream("Arquivos/disciplinas.ser"));
			disciplinas = (ArrayList<Disciplina>) in.readObject();
			in.close();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null,"Arquivo não encontrado!");
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			JOptionPane.showMessageDialog(null,"Nenhuma classe encontrada!");			
		}
		
		return disciplinas;
	}

	
	

	
	public ArrayList<Professor> recuperarProfessores(){
		ObjectInputStream in;
		professores = new ArrayList<Professor>();
		try {
			in = new ObjectInputStream(new FileInputStream("Arquivos/professores.ser"));
			professores = (ArrayList<Professor>) in.readObject();
			in.close();
		} catch (IOException ec) {
			JOptionPane.showMessageDialog(null,"Arquivo não encontrado!");
			
		} catch (ClassNotFoundException e2) {
			JOptionPane.showMessageDialog(null,"Nenhuma classe encontrada!");
			e2.printStackTrace();
		}
		
		return professores;	
	}

	
	
	public ArrayList<Curso> recuperarCursos() {
		ObjectInputStream in;
		cursos = new ArrayList<Curso>();
		try {
			in = new ObjectInputStream(new FileInputStream("Arquivos/cursos.ser"));
			cursos = (ArrayList<Curso>) in.readObject();
			in.close();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null,"Arquivo não encontrado!");			
		} catch (ClassNotFoundException e2) {
			JOptionPane.showMessageDialog(null,"Nenhuma classe encontrada!");			
		}
		return cursos;
	}
	
	public static void gravarArquivos(ArrayList array, String local) { 
		ObjectOutputStream out;
		try {
			FileOutputStream arquivo = new FileOutputStream(local);			
			out = new ObjectOutputStream(arquivo);
			boolean file = new File("Arquivos").mkdirs();			
			out.writeObject(array);
			out.flush();
			out.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo!");		
		}
	}
}
