package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.LectorEntity;

public interface LectorDAO {
	
	void create(LectorEntity entity);

	List<LectorEntity> read(LectorEntity entity);

	void update(LectorEntity entity);

	void delete(UUID entityid);

}