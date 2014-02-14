/**
 * 
 */
package com.jeco.dao;

import java.util.List;

import com.jeco.Ovino;
import com.jeco.io.JECOPersistenciaException;

/**
 * @author Ezequiel Severiano
 *
 */
public interface DaoOvino {
	public void salvarOvino(Ovino ovino) throws JECOPersistenciaException;
	public void apagarOvino(Ovino ovino)throws JECOPersistenciaException;
	public List<Ovino> buscaTodosOvinosAtivos()throws JECOPersistenciaException;
	public Ovino buscaOvino(String codigo)throws JECOPersistenciaException;
	public List<Ovino> buscaOvino(String arg,String where)throws JECOPersistenciaException;
	public void updateOvino(Ovino ovino) throws JECOPersistenciaException;
	public List<Ovino> buscaCrias(String codigo) throws JECOPersistenciaException;
	

}
