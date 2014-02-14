package com.jeco.ui.auxilares;


	

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

	import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.jeco.JECOException;
import com.jeco.io.ConnectionManager;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.controler.TipoInformacaoEnum;
import com.jeco.ui.view.JanelaInformacao;

	public class BuscaDB{
		private JFileChooser chooser;
		
		private String caminho = "";
		private File fileIn = null;

		public BuscaDB() {
			
			chooser = new JFileChooser();
			chooser.setDialogTitle("Buscar db");
			//buscaDB(nomeDB);
			
		}
		
		
		public boolean backupDB(String nomeDB) throws JECOException {
			
			chooser.setName(nomeDB);
			chooser.setFileFilter(new ExtensionFileFilter("Arquivos de Banco de Dados", "db")); // AKI ! eu passo como parametro a extensão e o tipo de dado que eu quer que apareça no chooser. o resto do codigo continua intacto.
			int retorno = chooser.showSaveDialog(null); // showSaveDialog retorna um inteiro , e ele ira determinar que o chooser será para salvar.
			if (retorno==JFileChooser.APPROVE_OPTION){
			      caminho = chooser.getSelectedFile().getAbsolutePath();  // o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endereço.
			      
			}
			if(!caminho.equals("") ){
			   fileIn = new File(caminho);
			   try {
				ConnectionManager.backupDatabase(fileIn);
				return true;
				} catch (Exception e1) {
					throw new JECOException("não foi possivel fazer backup do db"+e1);
								
				}
			  
			}
			return false;
			
		}
		
		
		
		public boolean restoryDB(String nomeDB) {
			boolean retorn=false;
			
			try{
				chooser.setName(nomeDB);
				chooser.setFileFilter(new ExtensionFileFilter("Arquivos de Banco de Dados", "db")); // AKI ! eu passo como parametro a extensão e o tipo de dado que eu quer que apareça no chooser. o resto do codigo continua intacto.
				int retorno = chooser.showOpenDialog(null); // showSaveDialog retorna um inteiro , e ele ira determinar que o chooser será para salvar.
				if (retorno==JFileChooser.APPROVE_OPTION){
				      caminho = chooser.getSelectedFile().getAbsolutePath();  // o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endereço.
				      
				}
				if(!caminho.equals("") && caminho.endsWith(".db")){
				   fileIn = new File(caminho);
				   ConnectionManager.recoverBackupDatabase(fileIn);
					retorn = true; 
				}
				else{
					new JanelaInformacao("Formato de arquivo invalido");
				}
				
			} catch (Exception e) {
				new JanelaInformacao("Erro ao Restaurar DB ",TipoInformacaoEnum.ATENCAO);
				JECOLogger.getInstance().log(e);
				
			}
			
			
			
			return retorn;
		}
		
		
	}


