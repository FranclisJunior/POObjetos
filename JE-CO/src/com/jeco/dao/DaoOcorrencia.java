package com.jeco.dao;

import java.util.List;

import com.jeco.Ocorrencia;
import com.jeco.io.JECOPersistenciaException;

public interface DaoOcorrencia {	
	public void salvarOcorrencia(Ocorrencia oc) throws JECOPersistenciaException;
	public void apagarOcorrencia(Ocorrencia oc)throws JECOPersistenciaException;
	public List<Ocorrencia> buscaTodasOcorrencia()throws JECOPersistenciaException;
	public void updateOcorrencia(Ocorrencia oc) throws JECOPersistenciaException;
	

}
