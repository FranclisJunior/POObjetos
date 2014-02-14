package com.jeco.dao;

import java.util.List;

import com.jeco.io.JECOPersistenciaException;

public interface Dao <T>{
	
	public boolean salvar(T t)throws JECOPersistenciaException;
	public boolean apagar(T t)throws JECOPersistenciaException;
	public  boolean update(T t)throws JECOPersistenciaException;
	public List<T> buscaTodos()throws JECOPersistenciaException;
	public T busca(String arg)throws JECOPersistenciaException;

}
