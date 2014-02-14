package com.jeco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.jeco.OcorrenciaTipo;
import com.jeco.io.ConnectionManager;
import com.jeco.io.JECOPersistenciaException;

public class DaoOcorrenciaTipoJDBC implements DaoOcorrenciaTipo{	
	
	private Connection conn;
    private Statement stm;
    
    public DaoOcorrenciaTipoJDBC() throws Exception{
		this.conn =  ConnectionManager.getConnection();
		this.stm = this.conn.createStatement();
	}
    
    @Override
	public void salvarOcorrenciaTipo(OcorrenciaTipo oc)	throws JECOPersistenciaException {
		if(oc== null) throw new JECOPersistenciaException("Não é posivel cadastrar ocorrencia null");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("INSERT INTO ocorrenciaTipo VALUES (" 
					+ "null"+ ",'"
	                + oc.getNome() + 
	                 "')");	        
		} catch (SQLException e) {						
			throw new JECOPersistenciaException("Não é posivel cadastrar Ocorrencia Tipo "+e.getMessage());
		}		
	}

	@Override
	public void apagarOcorrenciaTipo(OcorrenciaTipo oct)	throws JECOPersistenciaException {
		if(oct== null) throw new JECOPersistenciaException("Não é posivel cadastrar raca null");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("DELETE FROM ocorrenciaTipo WHERE OCORRENCIA_TIPO_ID ="+oct.getCodigo());	        
		} catch (SQLException e) {
			throw new JECOPersistenciaException("Não é posivel apagar ocorrenciaTipo  "+e.getMessage());
		}
		
	}

	@Override
	public List<OcorrenciaTipo> buscaTodasOcorrenciaTipo() throws JECOPersistenciaException {
		List<OcorrenciaTipo> allOcor = new LinkedList<OcorrenciaTipo>();
		String sql ="SELECT * FROM ocorrenciaTipo";
		try {
			ResultSet rs;			
			rs = stm.executeQuery(sql);
			while(rs.next()){
				OcorrenciaTipo ocr = new OcorrenciaTipo(rs.getString(1),rs.getString(2));
				allOcor.add(ocr);
			}
			return allOcor;			
		} catch (Exception e) {	
			
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta das ocorrencias.\n"+e.getMessage());
		}
	}

	@Override
	public void updateOcorrenciaTipo(OcorrenciaTipo oc)throws JECOPersistenciaException {
		if(oc== null) throw new JECOPersistenciaException("Não é posivel atualizar raca ");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("UPDATE ocorrenciaTipo SET  " 
					+ "OCORRENCIA_TIPO_NOME = '"+ oc.getNome() + 
	                 "' WHERE OCORRENCIA_TIPO_ID ="+oc.getCodigo());	        
		} catch (SQLException e) {
						
			throw new JECOPersistenciaException("Não é posivel fazer update em ocorrenciatipo "+e.getMessage());
		}
	}

}
