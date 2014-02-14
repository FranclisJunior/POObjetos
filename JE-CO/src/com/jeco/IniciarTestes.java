package com.jeco;

import java.sql.Connection;

import com.jeco.io.ConnectionManager;
import com.jeco.ui.controler.ControlerHome;
import com.jeco.ui.view.Home;
import com.jeco.ui.view.JanelaLogar;


public class IniciarTestes implements Runnable,LogarListener{
	
	
	public IniciarTestes(JanelaLogar log) {
		
		log.addLogarListener(this);
		
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {			
			mostrar("Iniciando serviços...");
			Connection  con = new ConnectionManager().getConnection();
			con.close();
			mostrar("Conecção com com o banco criada com sucesso...");
			mostrar("Criando janelas...");
			mostrar("Carregando a janela principal...");
			mostrar("Serviços carregados com sucesso...");			
			JanelaLogar.setStatus("Sucesso");
		} catch (Exception e) {
			JanelaLogar.setStatus("fim");
		}
		
		
	}
	private void  mostrar(String msg){
		try {
			Thread.sleep(400);
			JanelaLogar.setStatus(msg);
		} catch (InterruptedException e) {			
			JanelaLogar.setStatus("erro");
		}		
	}

	@Override
	public void termino() {
		new ControlerHome();
			
	}
}
