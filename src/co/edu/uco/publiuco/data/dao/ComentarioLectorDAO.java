package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.ComentarioLectorEntity;

public interface ComentarioLectorDAO {
	
	void create(ComentarioLectorEntity entity);

	List<ComentarioLectorEntity> read(ComentarioLectorEntity entity);

	void update(ComentarioLectorEntity entity);

	void delete(UUID entityId);

}