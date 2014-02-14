package com.jeco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.jeco.Ovino;
import com.jeco.io.ConnectionManager;
import com.jeco.io.JECOPersistenciaException;

public class DaoOvinoJDBC implements DaoOvino{
	private Connection conn;
    private Statement stm;
    

	public DaoOvinoJDBC() throws Exception {
		this.conn =  ConnectionManager.getConnection();
		this.stm = this.conn.createStatement();		
	}
	
	@Override
	public void salvarOvino(Ovino ovino) throws JECOPersistenciaException {		
		if(ovino== null) throw new JECOPersistenciaException("Não é posivel cadastrar ovino null");		
		try {
			ovino.setStatus("1");
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("INSERT INTO ovino VALUES (" 
					+ "null"+ ",'"
	                + ovino.getCodigo() + "','"
	                + ovino.getSexo() + "','"
	                + ovino.getData() + "','"
	                + ovino.getRaca() + "','"
	                + ovino.getStatus() + "','"
	                + ovino.getCodGenitora() + "',"
	                + ovino.getPreco()+ ")");	        
		} catch (SQLException e) {			
			throw new JECOPersistenciaException("Não é posivel cadastrar ovino "+e.getMessage());
		}
	}

	
	@Override
	public void apagarOvino(Ovino ovino) throws JECOPersistenciaException {
		if(ovino == null) throw new JECOPersistenciaException("Não é posivel cadastrar ovino null");
		try {
			this.stm = this.conn.createStatement();
			if(ovino.getCodGenitora().equalsIgnoreCase("Desconhecido"))
				this.stm.executeUpdate("DELETE FROM OVINO WHERE OVINO_CODIGO = '"+ovino.getCodigo()+"'");	 
			else
				this.stm.executeUpdate("UPDATE OVINO SET  " 
						+ "OVINO_STATUS = 0"+
		                 " WHERE OVINO_CODIGO = '"+ovino.getCodigo()+"'");	 
		} catch (SQLException e) {			
			throw new JECOPersistenciaException("Não é posivel apagar ovino "+e.getMessage());
		}		
	}
	
	@Override
	public List<Ovino> buscaTodosOvinosAtivos() throws JECOPersistenciaException {
				
		List<Ovino> allOvino = new LinkedList<Ovino>();
		String sql ="SELECT * FROM OVINO WHERE OVINO_STATUS ='1'";
		try {
			ResultSet rs = stm.executeQuery(sql);			
			while(rs.next()){
				Ovino ovino = new Ovino();
				ovino.setCodigo(rs.getString(2));
				ovino.setSexo(rs.getString(3));
				ovino.setData(rs.getString(4));
				ovino.setRaca(rs.getString(5));
				ovino.setStatus(rs.getString(6));
				ovino.setCodGenitora(rs.getString(7));
				ovino.setPreco(rs.getFloat(8));
				allOvino.add(ovino);
			}
			return allOvino;			
		} catch (Exception e) {				
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos ovinos.\n"+e.getMessage());
		}
		
	}

	@Override
	public Ovino buscaOvino(String codigo) throws JECOPersistenciaException {		
		String sql ="SELECT * FROM OVINO WHERE OVINO_CODIGO  = '"+codigo+"'";
		
		try {
			ResultSet rs= stm.executeQuery(sql);
			Ovino ovino =null;			
			while(rs.next()){
				ovino = new Ovino();
				ovino.setCodigo(rs.getString(2));
				ovino.setSexo(rs.getString(3));
				ovino.setData(rs.getString(4));
				ovino.setRaca(rs.getString(5));
				ovino.setStatus(rs.getString(6));
				ovino.setCodGenitora(rs.getString(7));
				ovino.setPreco(rs.getFloat(8));				
			}			
			return ovino;			
		} catch (Exception e) {			
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos ovinos.\n"+e.getMessage());
		}
	}
	
	
	@Override
	public List<Ovino> buscaCrias(String codigo) throws JECOPersistenciaException {		
		String sql ="SELECT * FROM OVINO WHERE OVINO_COD_GENITORA  = '"+codigo+"'";
		List<Ovino> ovinos = new LinkedList<>();
		try {
			ResultSet rs= stm.executeQuery(sql);
			Ovino ovino =null;			
			while(rs.next()){
				ovino = new Ovino();
				ovino.setCodigo(rs.getString(2));
				ovino.setSexo(rs.getString(3));
				ovino.setData(rs.getString(4));
				ovino.setRaca(rs.getString(5));
				ovino.setStatus(rs.getString(6));
				ovino.setCodGenitora(rs.getString(7));
				ovino.setPreco(rs.getFloat(8));	
				ovinos.add(ovino);
			}			
			return ovinos;			
		} catch (Exception e) {			
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos ovinos.\n"+e.getMessage());
		}
	}
		
	@Override
	public List<Ovino> buscaOvino(String arg, String where)	throws JECOPersistenciaException {		
		List<Ovino> allOvino = new LinkedList<Ovino>();
		String sql ="SELECT * FROM OVINO WHERE "+arg+" = '"+where+"'"+"AND OVINO_STATUS = '1'";
		
		try {
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Ovino ovino = new Ovino();
				ovino.setCodigo(rs.getString(2));
				ovino.setSexo(rs.getString(3));
				ovino.setData(rs.getString(4));
				ovino.setRaca(rs.getString(5));
				ovino.setStatus(rs.getString(6));
				ovino.setCodGenitora(rs.getString(7));
				ovino.setPreco(rs.getFloat(8));
				allOvino.add(ovino);				
			}			
			return allOvino;			
		} catch (Exception e) {				
			throw new  JECOPersistenciaException("Não foi possivel fazer a consulta dos ovinos.\n"+e.getMessage());
		}
	}

	
	@Override
	public void updateOvino(Ovino ovino) throws JECOPersistenciaException {
		if(ovino== null) throw new JECOPersistenciaException("Não é posivel cadastrar ovino null");		
		try {			
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate("UPDATE  ovino SET " 
					
	                +"OVINO_SEXO ='"+ ovino.getSexo() + "',"
	                +"OVINO_DATA='"+ ovino.getData() + "',"
	                +"OVINO_RACA='" + ovino.getRaca() + "',"
	                +"OVINO_STATUS='"+ ovino.getStatus() + "',"
	                +"OVINO_COD_GENITORA='"+ ovino.getCodGenitora() + "',"
	                +"OVINO_PRECO='"+ ovino.getPreco()+"' where OVINO_CODIGO = '"+ovino.getCodigo()+"'");	        
		} catch (SQLException e) {			
			throw new JECOPersistenciaException("Não é posivel atualizar ovino "+e.getMessage());
		}				
	}	
}
