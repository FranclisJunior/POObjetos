package com.jeco.ui.controler;

import java.awt.Component;

import com.jeco.JECOException;
import com.jeco.JECOFacade;
import com.jeco.Ovino;
import com.jeco.Pesagem;
import com.jeco.logger.JECOLogger;
import com.jeco.ui.view.BackupDB;
import com.jeco.ui.view.Home;
import com.jeco.ui.view.JanelaAddOcorrencia;
import com.jeco.ui.view.JanelaAddPeso;
import com.jeco.ui.view.JanelaCadastroOvino;
import com.jeco.ui.view.JanelaConfirmacao;
import com.jeco.ui.view.JanelaCriarOcorrenciaTipo;
import com.jeco.ui.view.JanelaCriarRaca;
import com.jeco.ui.view.JanelaCriarUsuario;
import com.jeco.ui.view.JanelaEventos;
import com.jeco.ui.view.JanelaInformacao;
import com.jeco.ui.view.JanelaLogar;
import com.jeco.ui.view.JanelaOcorrenciasCadastradas;
import com.jeco.ui.view.JanelaOvinosCadastrados;
import com.jeco.ui.view.JanelaPesosCadastrados;

public class ControlerHome implements ControlerHomeListener {
	private Home home;
	private Component btBackup;
	private Component btCOvino;
	private Component btCPeso;
	private Component btCTipoOcorrencia;
	private Component btCRaca;
	private Component btCOcorrencia;
	private Component btVisualizarOcorrencia;
	private Component btVisualizarOvinos;
	private Component btCUsuaio;
	private Component btVisualizarPeso;
	private Component btVisualizarEventos;
	private static JECOFacade facade;
	
	
	//recebo como parametro a Home de onde vai vir os eventos
	public ControlerHome() {
		facade = new JECOFacade();
		try {
			this.home = new Home(facade.buscaTodosOvino());
		} catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Ocorreu um erro ao Iniciar Sistema",JanelaInformacao.ERRO);
		}
		if(!(home == null) )
			home.add(this);
	}


	@Override
	public void event(ControlEvent ev) {
		
		if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_OVINO){
			btCOvino = ev.getComponent();
			try {
				if(facade.buscaRaca().size() < 1){
					if(new JanelaConfirmacao("Nao existe raca cadastrada, Deseja cadastrar agora?").resposta())
						new JanelaCriarRaca().add(this);
					else
						new JanelaInformacao("É necessario cadastrar pelo menos uma raca para continuar",JanelaInformacao.ATENCAO);
				}else{
					setEnabled(btCOvino);
					new JanelaCadastroOvino().add(this);
				}
			} catch (JECOException e) {
				JECOLogger.getInstance().log(e);
				new JanelaInformacao("Ocorreu um erro ao cadastrar Ovino",JanelaInformacao.ERRO);
			}
		}else if(ev.getButonEnum()== EnumNomeBotoes.BACKUP){
			btBackup = ev.getComponent();
			setEnabled(btBackup);
			new BackupDB().add(this);
		
		}
		else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_PESO){
			btCPeso = ev.getComponent();
			setEnabled(btCPeso);
			new JanelaAddPeso().add(this);
		
		}else if(ev.getButonEnum()== EnumNomeBotoes.VISUALIZAR_OVINOS){
			btVisualizarOvinos = ev.getComponent();
			setEnabled(btVisualizarOvinos);
			new JanelaOvinosCadastrados().add(this);
			
		}else if(ev.getButonEnum()== EnumNomeBotoes.VISUALIZAR_OCORRENCIAS){
			btVisualizarOcorrencia = ev.getComponent();
			setEnabled(btVisualizarOcorrencia);
			new JanelaOcorrenciasCadastradas().add(this);
		
		}else if(ev.getButonEnum()== EnumNomeBotoes.VISUALIZAR_PESO){
			btVisualizarPeso = ev.getComponent();
			setEnabled(btVisualizarPeso);
			new JanelaPesosCadastrados().add(this);			
		}
		else if(ev.getButonEnum()== EnumNomeBotoes.VISUALIZAR_EVENTOS){
			btVisualizarEventos = ev.getComponent();
			setEnabled(btVisualizarEventos);
			new JanelaEventos().add(this);				
		}
		else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_TIPO_OCORRENCIA){			
			btCTipoOcorrencia = ev.getComponent();
			setEnabled(btCTipoOcorrencia);
			new JanelaCriarOcorrenciaTipo().add(this);		
		}
		else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_OCORRENCIA){
			try{
				if(facade.buscarOcorrenciasTipo().size() < 1){
						if(new JanelaConfirmacao("Nao existe tipo de ocorrencia cadastrada, Deseja cadastrar agora?").resposta())
							new JanelaCriarOcorrenciaTipo().add(this);
						else
							new JanelaInformacao("É necessario cadastrar pelo menos um tipo de ocorrencia",JanelaInformacao.ATENCAO);					
				}else{						
					btCOcorrencia = ev.getComponent();
					setEnabled(btCOcorrencia);
					new JanelaAddOcorrencia().add(this);
				}
			} catch (JECOException e) {
				JECOLogger.getInstance().log(e);
				new JanelaInformacao("Ocorreu um erro ao cadastrar Ocorrência",JanelaInformacao.ERRO);
			}	
		}
		
		else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_RACA){
			btCRaca = ev.getComponent();
			setEnabled(btCRaca);
			new JanelaCriarRaca().add(this);		
		}
		else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_USUARIO){
			btCUsuaio = ev.getComponent();
			setEnabled(btCUsuaio);
			new JanelaCriarUsuario().add(this);		
		}
		else if(ev.getButonEnum()== EnumNomeBotoes.LOGOFF){
			home.dispose();
			new JanelaLogar();			
		}
		else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_OVINO_CLOSE){			
			setEnabled(btCOvino);
		
		}else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_PESO_CLOSE){
			setEnabled(btCPeso);
		
		}else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_TIPO_OCORRENCIA_CLOSE){
			setEnabled(btCTipoOcorrencia);
		
		}else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_RACA_CLOSE){
			setEnabled(btCRaca);
		
		}else if(ev.getButonEnum()== EnumNomeBotoes.CADASTRO_OCORRENCIA_CLOSE){
			setEnabled(btCOcorrencia);
		
		}else if(ev.getButonEnum()== EnumNomeBotoes.VISUALIZAR_OCORRENCIAS_CLOSE){
			setEnabled(btVisualizarOcorrencia);
		
		}else if(ev.getButonEnum()== EnumNomeBotoes.VISUALIZAR_OVINOS_CLOSE){
			setEnabled(btVisualizarOvinos);
			
		}else if(ev.getButonEnum()== EnumNomeBotoes.VISUALIZAR_PESO_CLOSE){
			setEnabled(btVisualizarPeso);
		
		}else if(ev.getButonEnum()== EnumNomeBotoes.VISUALIZAR_EVENTOS_CLOSE){
			setEnabled(btVisualizarEventos);			
			
		} else if (ev.getButonEnum() == EnumNomeBotoes.CADASTRO_USUARIO_CLOSE){
			setEnabled(btCUsuaio);		
		}else if(ev.getButonEnum()== EnumNomeBotoes.BACKUP_CLOSE){
			setEnabled(btBackup);
		
		}
	}
	private void setEnabled(Component comp){
		if(!(comp == null)){
			if(comp.isEnabled())
				comp.setEnabled(false);
			else
				comp.setEnabled(true);
			
		}
	}
	
	public static Ovino ovinoComMaiorPeso(){
		if(facade == null)
			facade = new JECOFacade();
		
		Pesagem pesagem = new Pesagem("", 0, "");
		try {
			for(Ovino ov: facade.buscaTodosOvino())
				
				for(Pesagem p: ov.getHistoricoPesos())
					if(p.getPeso() > pesagem.getPeso())
						pesagem =p;
			
			return facade.buscaOvino(pesagem.getCodOvino());
		} catch (JECOException e) {
			JECOLogger.getInstance().log(e);
			new JanelaInformacao("Ocorreu um erro no Sistema",JanelaInformacao.ERRO);
		}
		return null;
	}
	
}
