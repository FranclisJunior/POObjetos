package com.jeco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.jeco.Ovino;
import com.jeco.Usuario;
import com.jeco.io.ConnectionManager;
import com.jeco.io.JECOPersistenciaException;
import com.jeco.logger.JECOLogger;

public class DaoUsuarioJDBC implements DaoUsuario {
	
	private Connection conn;
    private Statement stm;
    
    public DaoUsuarioJDBC() throws Exception{
    	this.conn =  ConnectionManager.getConnection();
		this.stm = this.conn.createStatement();
    }

    
    
	@Override
	public void salvarUsuario(Usuario us) throws JECOPersistenciaException {
		if(us== null) throw new JECOPersistenciaException("Não é posivel cadastrar Usuario null");		
		try {				
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("INSERT INTO usuario VALUES ("
					+ "null"+ ",'"
	                + us.getNome() + "','"
	                + us.getSenha() +"','"
	                + us.getNivel()+"')");	                        
		} catch (SQLException e) {						
			throw new JECOPersistenciaException("Não é posivel cadastrar Usuario "+e.getMessage());
		}
		
	}
	
	@Override
	public void apagarUsuario(Usuario us) throws JECOPersistenciaException {
		if(us== null) throw new JECOPersistenciaException("Não é posivel apagar usuario null");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("DELETE FROM usuario WHERE USUARIO_ID ="+us.getId());	        
		} catch (SQLException e) {
			throw new JECOPersistenciaException("Não é posivel apagar usuario "+e.getMessage());
		}
		
	}

	@Override
	public List<Usuario> buscaTodosUsuarios() throws JECOPersistenciaException {
		List<Usuario> allUser = new LinkedList<Usuario>();
		String sql ="SELECT * FROM usuario";
		try {
			ResultSet rs;			
			rs = stm.executeQuery(sql);
			while(rs.next()){
				Usuario us = new Usuario();
				us.setId(rs.getString(1));
				us.setNome(rs.getString(2));
				us.setSenha(rs.getString(3));
				us.setNivel(rs.getString(4));
				allUser.add(us);				
			}			
			return allUser;			
		} catch (Exception e) {	
			JECOLogger.getInstance().log(e);
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos usuarios.\n"+e.getMessage());
		}
	}

	@Override
	public void updateUsuario(Usuario us) throws JECOPersistenciaException {
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("UPDATE  usuario SET "					
	               + "USUARIO_NOME ='"+ us.getNome()+ "',"
	               + "USUARIO_SENHA ='"+ us.getSenha()+"',"
	               + "USUARIO_NIVEL ='"+us.getNivel()+ "' WHERE USUARIO_ID = "+us.getId());	                        
		} catch (SQLException e) {
			JECOLogger.getInstance().log(e);			
			throw new JECOPersistenciaException("Não é posivel Atualizar Usuario "+e.getMessage());
		}				
	}
	
	@Override
	public Usuario buscaUsuario(String user, String senha) throws JECOPersistenciaException{
		String sql ="SELECT * FROM usuario WHERE USUARIO_NOME = '"+user+"' AND USUARIO_SENHA = '"+senha+"'";
		Usuario us = null;
			
		try {
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				us.setId(rs.getString(1));
				us.setNome(rs.getString(2));
				us.setSenha(rs.getString(3));
				us.setNivel(rs.getString(4));						
			}
			return us;
		} catch (SQLException e) {
			JECOLogger.getInstance().log(e);			
			throw new JECOPersistenciaException("Não foi possivel fazer a consulta do usuario.\n"+e.getMessage());
		}		
	}

}
