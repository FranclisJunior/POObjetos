
package com.jeco;


import java.util.List;

import com.jeco.io.JECOPersistencia;
import com.jeco.io.JECOPersistenciaException;
import com.jeco.io.JECOPersistenciaJDBC;

public class JECOFacade {

	private JECOPersistencia pessistJDBC ;
	
	public JECOFacade() {
		pessistJDBC = new JECOPersistenciaJDBC();
	}	
	
	public Ovino criarOvino(){		
		return Factory.createOvino();
	}
	
	public Ocorrencia criarOcorrencia(){
		return Factory.createOcorrencia();		
	}
	
	
	/**################################################################
	 *Metodos crud Ocorrencia
	 *_################################################################
	 */
	
	public void apagarOcorrencia(Ocorrencia oc)	throws  JECOException {
		try {
			pessistJDBC.apagarOcorrencia(oc);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao apagar Ocorrencia: "+e.getMessage());
		}
		
	}

	
	public void updateOcorrencia(Ocorrencia oc)	throws  JECOException {
		try {
			pessistJDBC.updateOcorrencia(oc);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao Atualizar Ocorrecia: "+e.getMessage());
		}		
	}
	
	public List<Ocorrencia> buscarOcorrencias() throws JECOException{
		try {
			return pessistJDBC.buscaTodasOcorrencia();
		} catch (JECOPersistenciaException e) {
			
			throw new JECOException("erro ao buscar Ocorrencias: "+e.getMessage());
		}
	}
	
	public boolean salvarOcorrencia(Ocorrencia oc) throws  JECOException{
		try {
			
			pessistJDBC.salvarOcorrencia(oc);
			return true;
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro salvar Ocorrecia: "+e.getMessage());
		}
	}//Fim dos Metodos para Ocorrencia	
	
	


	/**################################################################
	 *Metodos crud OcorrenciaTipo
	 *_################################################################
	 */

	public void apagarOcorrenciaTipo(OcorrenciaTipo oct)
			throws  JECOException {
		try {
			pessistJDBC.apagarOcorrenciaTipo(oct);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao apagar OcorreciaTipo: "+e.getMessage());
		}
		
	}

	
	public void updateOcorrenciaTipo(OcorrenciaTipo oct)
			throws  JECOException {
		try {
			pessistJDBC.updateOcorrenciaTipo(oct);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao Atualizar OcorreciaTipo: "+e.getMessage());
		}
		
	}

	
	public List<OcorrenciaTipo> buscarOcorrenciasTipo() throws  JECOException{
		try {
			return pessistJDBC.buscaTodasOcorrenciaTipo();
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao buscar OcorrenciasTipo: "+e.getMessage());
		}
	}
	
	public boolean salvarOcorrenciaTipo(OcorrenciaTipo oc) throws  JECOException{
		try {
			pessistJDBC.salvarOcorrenciaTipo(oc);
			return true;
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro salvar OcorrenciasTipo: "+e.getMessage());
		}
	}//Fim dos Metodos para Ocorrencia Tipo
		
	
	/**################################################################
	 *Metodos crud Peso
	 *_################################################################
	 */
	public boolean salvarPeso(Pesagem pesagem)  throws  JECOException  {
		try {
			pessistJDBC.salvarPeso(pesagem);
			return true;
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro salvar Peso: "+e.getMessage());
		}				
	}	
	public void apagarPeso(Pesagem pesagem)  throws  JECOException {
		try {
			pessistJDBC.apagarPeso(pesagem);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao Apagar peso: "+e.getMessage());
		}
				
	}	
	public List<Pesagem> buscaTodosPeso()  throws  JECOException {		
		try {
			return pessistJDBC.buscaTodosPeso();
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao buscar all pesos: "+e.getMessage());
		}
	}	
	
	public List<Pesagem> buscaPesoEntre(float x, float y) throws JECOException{
		try {
			return pessistJDBC.buscaPesoEntre(x,y);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao buscar all pesos: "+e.getMessage());
		}
	}
	
	public Pesagem buscaPeso(String codigo)  throws  JECOException {		
		try {
			return pessistJDBC.buscaPeso(codigo);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao buscar peso: "+e.getMessage());
		}
	}	
	public List<Pesagem> buscaPeso(String arg, String where)  throws  JECOException {		
		try {
			return pessistJDBC.buscaPeso(arg, where);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao buscar  peso: "+e.getMessage());
		}
	}
	
	public void updatePeso(Pesagem pesagem)throws  JECOException{	
		try {
			 pessistJDBC.updatePeso(pesagem);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao atualizar peso: "+e.getMessage());
		}
		
	}
	//Fim dos Metodos para Peso

	
	
	/**################################################################
	 *Metodos crud Ovino
	 *_################################################################
	 */
	public boolean salvarOvino(Ovino ovino)  throws  JECOException {		
		try {
			pessistJDBC.salvarOvino(ovino);
			return true;
		} catch (JECOPersistenciaException e) {
			
			throw new JECOException("erro salvar Ovino: "+e.getMessage());
		}
	}	
	
	public void apagarOvino(Ovino ovino)  throws  JECOException {
		try {
			pessistJDBC.apagarOvino(ovino);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro apagar ovino: "+e.getMessage());
		}
			
	}
	
	public List<Ovino> buscaTodosOvino()  throws  JECOException {
		try {
			return pessistJDBC.buscaTodosOvinosAtivos();
		} catch (JECOPersistenciaException e) {			
			throw new JECOException("erro ao buscar ovinos: "+e.getMessage());
		}
	}	
	
	public Ovino buscaOvino(String codigo)  throws  JECOException {
		try {
			return pessistJDBC.buscaOvino(codigo);
		} catch (JECOPersistenciaException e) {			
			throw new JECOException("erro ao buscar ovinos: "+e.getMessage());
		}
	}	
	
	public List<Ovino> buscaCrias(String codigo)  throws  JECOException {
		try {
			return pessistJDBC.buscaCrias(codigo);
		} catch (JECOPersistenciaException e) {			
			throw new JECOException("erro ao buscar ovinos: "+e.getMessage());
		}
	}	
	
	public List<Ovino> buscaOvino(String arg, String where)  throws  JECOException {
		try{
			return pessistJDBC.buscaOvino(arg, where);
		} catch (JECOPersistenciaException e) {			
			throw new JECOException("erro ao buscar ovinos: "+e.getMessage());
		}
	}
	
	
	public void updateOvino(Ovino ovino)throws  JECOException{	
		try{
			pessistJDBC.updateOvino(ovino);
		}catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao atualizar ovino: "+e.getMessage());
		}		
	}//Fim dos Metodos para Ovino   
	
	/**################################################################
	 *Metodos crud Raca
	 *_################################################################
	 */
	
	public List<Raca> buscaRaca()  throws  JECOException {
		try{
			return pessistJDBC.buscaTodosRaca();
		} catch (JECOPersistenciaException e) {
			
			throw new JECOException("erro ao buscar racas: "+e.getMessage());
		}
	}
	
	public void updateRaca(Raca raca)throws  JECOException{	
		try {
			pessistJDBC.updateRaca(raca);
		} catch (JECOPersistenciaException e) {
			
			throw new JECOException("erro ao atualizar raca: "+e.getMessage());
		}		
	}

	public boolean salvarRaca(Raca raca)  throws  JECOException {		
		try {
			pessistJDBC.salvarRaca(raca);
			return true;
		} catch (JECOPersistenciaException e) {
			
			throw new JECOException("erro salvar Raca: "+e.getMessage());
		}		
	}

	public Raca buscaRaca(String cod) throws  JECOException {
		try {
			return pessistJDBC.buscaRaca(cod);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao buscar Raca: "+e.getMessage());
		}
	}

	
	public void apagarRaca(Raca raca) throws  JECOException {
		try {
			pessistJDBC.apagarRaca(raca);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao apagar Raca: "+e.getMessage());
		}
		
	}
	
	
	/**################################################################
	 *Metodos crud Usuario
	 *_################################################################
	 */
	public void apagarUsuario(Usuario us) throws  JECOException {
		try {
			pessistJDBC.apagarUsuario(us);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao apagar Usuario: "+e.getMessage());
		}
		
	}

	
	public void updateUsuario(Usuario us) throws  JECOException {
		try {
			pessistJDBC.updateUsuario(us);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao Atualizar Usuario: "+e.getMessage());
		}
		
	}
	
	public List<Usuario> buscarUsuarios() throws  JECOException{
		try {
			return pessistJDBC.buscaTodosUsuarios();
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao buscar Usuario: "+e.getMessage());
		}
	}
	
	public boolean salvarUsuario(Usuario us) throws  JECOException{
		try {
			pessistJDBC.salvarUsuario(us);
			return true;
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro salvar Usuario: "+e.getMessage());
		}
	}
	public Usuario buscaUsuario(String user, String senha) throws JECOException{
		try {
			return pessistJDBC.buscaUsuario(user,senha);
		} catch (JECOPersistenciaException e) {
			throw new JECOException("erro ao buscar Usuario: "+e.getMessage());
		}
	}
	
	
	
}
