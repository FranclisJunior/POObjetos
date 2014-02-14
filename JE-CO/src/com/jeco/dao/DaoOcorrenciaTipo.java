package com.jeco.dao;

import java.util.List;

import com.jeco.OcorrenciaTipo;
import com.jeco.io.JECOPersistenciaException;

public interface DaoOcorrenciaTipo {		
		public void salvarOcorrenciaTipo(OcorrenciaTipo oct) throws JECOPersistenciaException;
		public void apagarOcorrenciaTipo(OcorrenciaTipo oct)throws JECOPersistenciaException;
		public List<OcorrenciaTipo> buscaTodasOcorrenciaTipo()throws JECOPersistenciaException;
		public void updateOcorrenciaTipo(OcorrenciaTipo oct) throws JECOPersistenciaException;
		
}
