package com.jeco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.jeco.Ocorrencia;
import com.jeco.io.ConnectionManager;
import com.jeco.io.JECOPersistenciaException;
import com.jeco.logger.JECOLogger;

public class DaoOcorrenciaJDBC implements DaoOcorrencia {
	private Connection conn;
    private Statement stm;

	public DaoOcorrenciaJDBC() throws Exception{
		this.conn =  ConnectionManager.getConnection();
		this.stm = this.conn.createStatement();
	}
	
	@Override
	public void salvarOcorrencia(Ocorrencia oc)	throws JECOPersistenciaException {	
		if(oc== null) throw new JECOPersistenciaException("Não é posivel cadastrar Ocorrencia null");		
		try {				
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("INSERT INTO ocorrencia VALUES ("
					+ "null"+ ",'"
	                + oc.getTipo()+ "','"
	                + oc.getCodigoOvino()+ "','"
	                + oc.getDescricao()+ "','"
	                + oc.getData()+"',"
	                + oc.getCusto()+")");	                        
		} catch (SQLException e) {
			JECOLogger.getInstance().log(e);			
			throw new JECOPersistenciaException("Não é posivel cadastrar Ocorrencia "+e.getMessage());
		}
	}

	@Override
	public void apagarOcorrencia(Ocorrencia oc)	throws JECOPersistenciaException {		
		if(oc== null) throw new JECOPersistenciaException("Não é posivel cadastrar raca null");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("DELETE FROM ocorrencia WHERE OCORRENCIA_ID ="+oc.getCodigoOcr());	        
		} catch (SQLException e) {
			throw new JECOPersistenciaException("Não é posivel apagar Ocorrencia"+e.getMessage());
		}
		
	}


	@Override
	public void updateOcorrencia(Ocorrencia oc) throws JECOPersistenciaException {
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("UPDATE  ocorrencia SET "
					
	               + "OCORRENCIA_TIPO ='"+ oc.getTipo()+ "',"
	               + "OCORRENCIA_CODOVELHA ='"+ oc.getCodigoOvino()+ "',"
	               + "OCORRENCIA_DESCRICAO ='"+ oc.getDescricao()+ "',"
	               + "OCORRENCIA_DATA ='"+ oc.getData()+ "',"
	               + "OCORRENCIA_PRECO ='"+oc.getCusto()+"' WHERE OCORRENCIA_ID = '"+oc.getCodigoOcr()+"'");	                        
		} catch (SQLException e) {
			JECOLogger.getInstance().log(e);			
			throw new JECOPersistenciaException("Não é posivel Atualizar Ocorrencia "+e.getMessage());
		}
				
	}

	@Override
	public List<Ocorrencia> buscaTodasOcorrencia()throws JECOPersistenciaException {
		List<Ocorrencia> allOcr = new LinkedList<Ocorrencia>();
		String sql ="SELECT * FROM ocorrencia";
		try {
			ResultSet rs;			
			rs = stm.executeQuery(sql);
			while(rs.next()){
				Ocorrencia oc = new Ocorrencia();
				oc.setCodigoOcr(rs.getString(1));
				oc.setTipo(rs.getString(2));
				oc.setCodigoOvino(rs.getString(3));
				oc.setDescricao(rs.getString(4));
				oc.setData(rs.getString(5));	
				oc.setCusto(rs.getFloat(6));
				allOcr.add(oc);				
			}			
			return allOcr;			
		} catch (Exception e) {	
			JECOLogger.getInstance().log(e);
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta das Ocorrencias.\n"+e.getMessage());
		}		
	}

}
