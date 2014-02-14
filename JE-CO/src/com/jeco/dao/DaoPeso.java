/**
 * 
 */
package com.jeco.dao;

import java.util.List;

import com.jeco.Pesagem;
import com.jeco.io.JECOPersistenciaException;


/**
 * @author Ezequiel Severiano
 *
 */
public interface DaoPeso  {
	public void salvarPeso(Pesagem ovino)throws JECOPersistenciaException;
	public void apagarPeso(Pesagem pesagem)throws JECOPersistenciaException;
	public List<Pesagem> buscaTodosPeso()throws JECOPersistenciaException;
	public Pesagem buscaPeso(String codigo)throws JECOPersistenciaException;
	public List<Pesagem> buscaPeso(String arg,String where)throws JECOPersistenciaException;
	public void updatePeso(Pesagem pesagem) throws JECOPersistenciaException;
	public List<Pesagem> buscaPesoEntre(float x, float y) throws JECOPersistenciaException;


}
