/**
 * 
 */
package com.jeco.dao;

/**
 * @author Ezequiel Severiano
 *
 */
public class DaoFactory {
	
	public static DaoOvinoJDBC creatJdbcOvinoDao() throws Exception{		
		return new DaoOvinoJDBC();
	}
	
	public static DaoPesoJDBC creatJdbcPesoDao() throws Exception{		
		return new DaoPesoJDBC();
	}
	
	public static DaoRacaJDBC creatJdbcRacaDao() throws Exception{		
		return new DaoRacaJDBC();
	}
	
	public static DaoOcorrenciaTipoJDBC creatJdbcOcorrenciaTipoDao() throws Exception{		
		return new DaoOcorrenciaTipoJDBC();
	}
	
	public static DaoOcorrenciaJDBC creatJdbcOcorrenciaDao() throws Exception{		
		return new DaoOcorrenciaJDBC();
	}
	
	public static DaoUsuarioJDBC creatJdbcUsuarioDao() throws Exception{		
		return new DaoUsuarioJDBC();
	}

}
