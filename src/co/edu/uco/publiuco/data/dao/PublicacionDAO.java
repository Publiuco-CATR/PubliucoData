package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.PublicacionEntity;

public interface PublicacionDAO {
	
	void create(PublicacionEntity entity);

	List<PublicacionEntity> read(PublicacionEntity entity);

	void update(PublicacionEntity entity);

	void delete(UUID entityId);

}