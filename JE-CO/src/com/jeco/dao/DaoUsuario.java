package com.jeco.dao;

import java.util.List;
import com.jeco.Usuario;
import com.jeco.io.JECOPersistenciaException;

public interface DaoUsuario {
	public void salvarUsuario(Usuario us) throws JECOPersistenciaException;
	public void apagarUsuario(Usuario us)throws JECOPersistenciaException;
	public List<Usuario> buscaTodosUsuarios()throws JECOPersistenciaException;
	public void updateUsuario(Usuario us) throws JECOPersistenciaException;
	public Usuario buscaUsuario(String user, String senha) throws JECOPersistenciaException;
}
