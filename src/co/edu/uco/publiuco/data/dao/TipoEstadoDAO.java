package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.TipoEstadoEntity;

public interface TipoEstadoDAO {
	
	List<TipoEstadoEntity> read(TipoEstadoEntity entity);

}
