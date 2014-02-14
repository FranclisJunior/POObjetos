
package com.jeco.io;

import com.jeco.dao.DaoOcorrencia;
import com.jeco.dao.DaoOcorrenciaTipo;
import com.jeco.dao.DaoOvino;
import com.jeco.dao.DaoPeso;
import com.jeco.dao.DaoRaca;
import com.jeco.dao.DaoUsuario;
 
public interface JECOPersistencia extends DaoOvino,DaoPeso,DaoRaca,DaoOcorrenciaTipo, DaoOcorrencia,DaoUsuario {
	   
}
