package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.VersionEntity;

public interface VersionDAO {

	void create(VersionEntity entity);

	List<VersionEntity> read(VersionEntity entity);

	void update(VersionEntity entity);

	void delete(UUID entityId);

}