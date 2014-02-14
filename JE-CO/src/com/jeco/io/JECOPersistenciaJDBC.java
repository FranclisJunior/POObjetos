package com.jeco.io;

import java.util.LinkedList;
import java.util.List;

import com.jeco.Ocorrencia;
import com.jeco.OcorrenciaTipo;
import com.jeco.Ovino;
import com.jeco.Pesagem;
import com.jeco.Raca;
import com.jeco.Usuario;
import com.jeco.dao.DaoFactory;


public class JECOPersistenciaJDBC implements JECOPersistencia {
	
	
	@Override
	public void salvarOvino(Ovino ovino) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcOvinoDao().salvarOvino(ovino);
			for(Pesagem p :ovino.getHistoricoPesos())
				DaoFactory.creatJdbcPesoDao().salvarPeso(p);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}		
	}
	
	@Override
	public void apagarOvino(Ovino ovino) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcOvinoDao().apagarOvino(ovino);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}		
	}

	@Override
	public List<Ovino> buscaTodosOvinosAtivos() throws JECOPersistenciaException {
		try {
			List<Ovino> ovinos =DaoFactory.creatJdbcOvinoDao().buscaTodosOvinosAtivos();
			for(Ovino ovino : ovinos){				
				for(Pesagem p : DaoFactory.creatJdbcPesoDao().buscaPeso("PESO_COD_OVINO", ovino.getCodigo())){					
					ovino.setPeso(p);
				}
			}
			return ovinos;
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
	}
		
	
	@Override
	public Ovino buscaOvino(String codigo) throws JECOPersistenciaException {
		try {
			Ovino ovino = DaoFactory.creatJdbcOvinoDao().buscaOvino(codigo);
			if(!(ovino==null)){
				for(Pesagem p : DaoFactory.creatJdbcPesoDao().buscaPeso("PESO_COD_OVINO", codigo)){
					ovino.setPeso(p);
				}
			}
			return ovino;
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
	}
	@Override
	public List<Ovino> buscaCrias(String codigo)
			throws JECOPersistenciaException {
		try {
			List<Ovino> ovinos =DaoFactory.creatJdbcOvinoDao().buscaCrias(codigo);			
			for(Ovino ovino : ovinos){				
				for(Pesagem p : DaoFactory.creatJdbcPesoDao().buscaPeso("PESO_COD_OVINO", ovino.getCodigo())){					
					ovino.setPeso(p);
				}					
			}
			return ovinos;			 
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}	
	}
	
	@Override
	public List<Ovino> buscaOvino(String arg, String where)	throws JECOPersistenciaException {
		try {
			List<Ovino> ovinos =DaoFactory.creatJdbcOvinoDao().buscaOvino(arg, where);			
			for(Ovino ovino : ovinos){				
				for(Pesagem p : DaoFactory.creatJdbcPesoDao().buscaPeso("PESO_COD_OVINO", ovino.getCodigo())){					
					ovino.setPeso(p);
				}					
			}
			return ovinos;			 
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}		
	}

	@Override
	public void updateOvino(Ovino ovino) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcOvinoDao().updateOvino(ovino);
			for(Pesagem p:ovino.getHistoricoPesos())
				DaoFactory.creatJdbcPesoDao().updatePeso(p);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}		
	}// Fim Metodos Ovinos

	
	//Metodos Peso
	@Override
	public void salvarPeso(Pesagem pesagem) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcPesoDao().salvarPeso(pesagem);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
	
	}

	@Override
	public void apagarPeso(Pesagem pesagem) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcPesoDao().apagarPeso(pesagem);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
	
	}

	@Override
	public List<Pesagem> buscaTodosPeso() throws JECOPersistenciaException {
		try {
			return DaoFactory.creatJdbcPesoDao().buscaTodosPeso();
		} catch (Exception e) {
			throw new JECOPersistenciaException(e.getMessage());
		}
	}

	@Override
	public Pesagem buscaPeso(String codigo) throws JECOPersistenciaException {
		try {
			return DaoFactory.creatJdbcPesoDao().buscaPeso(codigo);
		} catch (Exception e) {
			throw new JECOPersistenciaException(e.getMessage());
		}
	}

	@Override
	public List<Pesagem> buscaPeso(String arg, String where)throws JECOPersistenciaException {
		try {
			return DaoFactory.creatJdbcPesoDao().buscaPeso(arg, where);
		} catch (Exception e) {
			throw new JECOPersistenciaException(e.getMessage());
		}
	}

	@Override
	public void updatePeso(Pesagem pesagem) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcPesoDao().updatePeso(pesagem);
		} catch (Exception e) {
			throw new JECOPersistenciaException(e.getMessage());
		}

	}
	@Override
	public List<Pesagem> buscaPesoEntre(float x, float y) throws JECOPersistenciaException {
		try {
			return DaoFactory.creatJdbcPesoDao().buscaPesoEntre(x,y);
		} catch (Exception e) {
			throw new JECOPersistenciaException(e.getMessage());
		}
	}//Fim Metodos Peso

	
	//Metodos Raças
	@Override
	public void salvarRaca(Raca raca) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcRacaDao().salvarRaca(raca);
		} catch (Exception e) {
			throw new JECOPersistenciaException(e.getMessage());
		}		
	}	
	@Override
	public void apagarRaca(Raca raca) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcRacaDao().apagarRaca(raca);
		} catch (Exception e) {
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}
	
	@Override
	public List<Raca> buscaTodosRaca() throws JECOPersistenciaException {
		
		try {
			return DaoFactory.creatJdbcRacaDao().buscaTodosRaca();
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}
	
	@Override
	public Raca buscaRaca(String cod) throws JECOPersistenciaException {
		try {
			return DaoFactory.creatJdbcRacaDao().buscaRaca(cod);
		} catch (Exception e) {
			
			throw new JECOPersistenciaException(e.getMessage());
		}		
	}
	
	@Override
	public void updateRaca(Raca raca) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcRacaDao().updateRaca(raca);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}//Fim Metodos Raças

	//Metodos OcorrenciaTipo
	@Override
	public void salvarOcorrenciaTipo(OcorrenciaTipo oc)	throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcOcorrenciaTipoDao().salvarOcorrenciaTipo(oc);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}

	@Override
	public void apagarOcorrenciaTipo(OcorrenciaTipo oc)	throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcOcorrenciaTipoDao().apagarOcorrenciaTipo(oc);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
				
	}

	@Override
	public List<OcorrenciaTipo> buscaTodasOcorrenciaTipo()	throws JECOPersistenciaException {
		try {
			return DaoFactory.creatJdbcOcorrenciaTipoDao().buscaTodasOcorrenciaTipo();
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
	}

	@Override
	public void updateOcorrenciaTipo(OcorrenciaTipo oc) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcOcorrenciaTipoDao().updateOcorrenciaTipo(oc);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}//Fim Metodos Ocorrencia Tipo

	
	//Metodos Ocorrencia
	@Override
	public void salvarOcorrencia(Ocorrencia oc)	throws JECOPersistenciaException {		
		try {
			DaoFactory.creatJdbcOcorrenciaDao().salvarOcorrencia(oc);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}

	@Override
	public void apagarOcorrencia(Ocorrencia oc)	throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcOcorrenciaDao().apagarOcorrencia(oc);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}

	@Override
	public void updateOcorrencia(Ocorrencia oc)	throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcOcorrenciaDao().updateOcorrencia(oc);
		} catch (Exception e) {				
			throw new JECOPersistenciaException(e.getMessage());
		}
	}

	@Override
	public List<Ocorrencia> buscaTodasOcorrencia() throws JECOPersistenciaException {
		try {
			return DaoFactory.creatJdbcOcorrenciaDao().buscaTodasOcorrencia();
		} catch (Exception e) {
			
			throw new JECOPersistenciaException(e.getMessage());
		}
	}// Fim Metodos Ocorrencia

	
	//Metodos Usuarios
	@Override
	public void salvarUsuario(Usuario us) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcUsuarioDao().salvarUsuario(us);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}

	@Override
	public void apagarUsuario(Usuario us) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcUsuarioDao().apagarUsuario(us);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}

	@Override
	public List<Usuario> buscaTodosUsuarios() throws JECOPersistenciaException {
		try {
			return DaoFactory.creatJdbcUsuarioDao().buscaTodosUsuarios();
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
	}

	@Override
	public void updateUsuario(Usuario us) throws JECOPersistenciaException {
		try {
			DaoFactory.creatJdbcUsuarioDao().updateUsuario(us);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
		
	}

	@Override
	public Usuario buscaUsuario(String user, String senha) throws JECOPersistenciaException {
		try {
			return DaoFactory.creatJdbcUsuarioDao().buscaUsuario(user, senha);
		} catch (Exception e) {			
			throw new JECOPersistenciaException(e.getMessage());
		}
	}

	

	

}
