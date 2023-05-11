package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.EstadoEntity;

public interface EstadoDAO {
	
	void create(EstadoEntity entity);
	
	List<EstadoEntity> read(EstadoEntity entity);
	
	void update(EstadoEntity entity);
	
	void delete(UUID id_entity);
}
