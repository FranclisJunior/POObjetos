/**
 * 
 */
package com.jeco.dao;

import java.util.List;

import com.jeco.Raca;
import com.jeco.io.JECOPersistenciaException;

/**
 * @author Ezequiel Severiano
 *
 */
	public interface DaoRaca {
		public void salvarRaca(Raca raca) throws JECOPersistenciaException;
		public void apagarRaca(Raca raca)throws JECOPersistenciaException;
		public List<Raca> buscaTodosRaca()throws JECOPersistenciaException;
		public void updateRaca(Raca raca) throws JECOPersistenciaException;
		public Raca buscaRaca(String cod) throws JECOPersistenciaException;

	

}
