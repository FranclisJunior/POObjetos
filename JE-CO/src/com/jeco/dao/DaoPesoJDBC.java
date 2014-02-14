
package com.jeco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.jeco.Pesagem;
import com.jeco.io.ConnectionManager;
import com.jeco.io.JECOPersistenciaException;


public class DaoPesoJDBC implements DaoPeso{
	
	private Connection conn;
    private Statement stm;
      
	public DaoPesoJDBC() throws Exception {
		this.conn =  ConnectionManager.getConnection();
		this.stm = this.conn.createStatement();
	}

	@Override
	public void salvarPeso(Pesagem pesagem) throws JECOPersistenciaException {		
		if(pesagem== null) throw new JECOPersistenciaException("Não é posivel cadastrar peso null");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("INSERT INTO peso VALUES (" 
					+ "null"+ ",'"
	                + pesagem.getCodOvino() + "','"
	                + pesagem.getData() + "',"
	                + pesagem.getPeso() 
	                + ")");	        
		} catch (SQLException e) {			
			throw new JECOPersistenciaException("Não é posivel cadastrar peso "+e.getMessage());
		}		
	}

	@Override
	public void apagarPeso(Pesagem pesagem) throws JECOPersistenciaException {
		if(pesagem == null) throw new JECOPersistenciaException("Não é posivel cadastrar raca null");
		try {
			this.stm = this.conn.createStatement();			
			this.stm.executeUpdate("DELETE FROM peso WHERE PESO_ID ="+pesagem.getId());			
		} catch (SQLException e) {			
			throw new JECOPersistenciaException("Não é posivel apagar Peso "+e.getMessage());
		}
		
	}

	@Override
	public List<Pesagem> buscaTodosPeso() throws JECOPersistenciaException {
		List<Pesagem> allPeso = new LinkedList<Pesagem>();
		String sql ="SELECT * FROM PESO ";
		
		try {
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Pesagem pesagem = new Pesagem();
				pesagem.setId(rs.getInt(1));
				pesagem.setCodOvino(rs.getString(2));
				pesagem.setData(rs.getString(3));
				pesagem.setPeso(rs.getFloat(4));
				allPeso.add(pesagem);				
			}			
			return allPeso;			
		} catch (Exception e) {				
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos pesos.\n"+e.getMessage());
		}
	}
	
	public List<Pesagem> buscaPesoEntre(float x, float y) throws JECOPersistenciaException {		
		List<Pesagem> lPeso = new LinkedList<Pesagem>();					
		String sql ="SELECT * FROM PESO ";
	
		try {
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				float pesoAtual = rs.getFloat(4);
				if(pesoAtual>=x && pesoAtual<=y){
					Pesagem pesagem = new Pesagem();
					pesagem.setId(rs.getInt(1));
					pesagem.setCodOvino(rs.getString(2));
					pesagem.setData(rs.getString(3));
					pesagem.setPeso(rs.getFloat(4));
					
					existeNaList(lPeso, rs.getString(2));
					lPeso.add(pesagem);		
				}						
			}			
			return lPeso;			
		} catch (Exception e) {				
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos pesos.\n"+e.getMessage());
		}		
	}
	
	private void existeNaList(List<Pesagem> list , String cod){
		if(!list.isEmpty()){		
			for(Pesagem p : list)
				if(p.getCodOvino().equals(cod))
					list.remove(p);		
		}		
	}

	@Override
	public Pesagem buscaPeso(String codigo) throws JECOPersistenciaException {
		Pesagem pesagem=null ;
		String sql ="SELECT * FROM PESO WHERE  PESO_ID=" +codigo;
		
		try {
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()){
				pesagem = new Pesagem();
				pesagem.setId(rs.getInt(1));
				pesagem.setCodOvino(rs.getString(2));
				pesagem.setData(rs.getString(3));
				pesagem.setPeso(rs.getFloat(4));
			}			
			return pesagem;			
		} catch (Exception e) {			
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta do peso.\n"+e.getMessage());
		}
	}

	
	@Override
	public List<Pesagem> buscaPeso(String arg, String where) throws JECOPersistenciaException {		
		List<Pesagem> allPeso = new LinkedList<Pesagem>();
		String sql ="SELECT * FROM PESO WHERE "+arg+"='"+where+"'";
		
		try {
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Pesagem pesagem = new Pesagem();
				pesagem.setId(rs.getInt(1));
				pesagem.setCodOvino(rs.getString(2));
				pesagem.setData(rs.getString(3));
				pesagem.setPeso(rs.getFloat(4));				
				allPeso.add(pesagem);								
			}			
			return allPeso;			
		} catch (Exception e) {
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos Pesos.\n"+e.getMessage());
		}
	}

	
	@Override
	public void updatePeso(Pesagem pesagem) throws JECOPersistenciaException {
		if(pesagem== null) throw new JECOPersistenciaException("Não é posivel atualizar peso null");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("UPDATE  peso SET " 
	               +"PESO_DATA='" + pesagem.getData() + "',"
	               +"PESO_PESO="+ pesagem.getPeso()+" where PESO_ID ="+pesagem.getId());	
			
		} catch (SQLException e) {			
			throw new JECOPersistenciaException("Não é posivel atualizar peso "+e.getMessage());
		}	
	}
}
