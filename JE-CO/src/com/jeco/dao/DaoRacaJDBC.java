/**
 * 
 */
package com.jeco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.jeco.Raca;
import com.jeco.io.ConnectionManager;
import com.jeco.io.JECOPersistenciaException;

/**
 * @author Ezequiel Severiano
 *
 */
public class DaoRacaJDBC implements DaoRaca{
	private Connection conn;
    private Statement stm;
    
    
    /**
	 * 
	 */
	public DaoRacaJDBC() throws Exception{
		this.conn =  ConnectionManager.getConnection();
		this.stm = this.conn.createStatement();
	}

	@Override
	public void salvarRaca(Raca raca) throws JECOPersistenciaException {
		if(raca== null) throw new JECOPersistenciaException("Não é posivel cadastrar raca null");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("INSERT INTO raca VALUES (" 
					+ "null"+ ",'"
	                + raca.getRacaName() + 
	                 "')");	        
		} catch (SQLException e) {
			throw new JECOPersistenciaException("Não é posivel cadastrar raca "+e.getMessage());
		}
		
	}

	
	@Override
	public void apagarRaca(Raca raca) throws JECOPersistenciaException {
		if(raca== null) throw new JECOPersistenciaException("Não é posivel cadastrar raca null");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("DELETE FROM raca WHERE RACA_ID ="+raca.getRacaCod() );	        
		} catch (SQLException e) {
			throw new JECOPersistenciaException("Não é posivel apagar raca "+e.getMessage());
		}
		
	}

	
	@Override
	public List<Raca> buscaTodosRaca() throws JECOPersistenciaException {
		List<Raca> allRaca = new LinkedList<Raca>();
		String sql ="SELECT * FROM raca";
		try {
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Raca raca = new Raca(rs.getString(1),rs.getString(2));
				allRaca.add(raca);
			}
			return allRaca;			
		} catch (Exception e) {	
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos racas.\n"+e.getMessage());
		}
		
	}

	
	@Override
	public void updateRaca(Raca raca) throws JECOPersistenciaException {
		if(raca== null) throw new JECOPersistenciaException("Não é posivel atualizar raca ");		
		try {	
			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("UPDATE raca SET  " 
					+ "RACA_NOME = '"+ raca.getRacaName() + 
	                 "' WHERE RACA_ID ="+raca.getRacaCod());	        
		} catch (SQLException e) {
			
			throw new JECOPersistenciaException("Não é posivel cadastrar raca "+e.getMessage());
		}
		
	}

	@Override
	public Raca buscaRaca(String cod) throws JECOPersistenciaException {
		Raca raca=null ;
		String sql ="SELECT * FROM raca where RACA_NOME='"+cod+"'";
		try {
			ResultSet rs;
			
			rs = stm.executeQuery(sql);
			while(rs.next()){
				
				raca = new Raca(rs.getString(1),rs.getString(2));
				
			}
			return raca;
			
		} catch (Exception e) {	
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos racas.\n"+e.getMessage());
		}
	}

}
