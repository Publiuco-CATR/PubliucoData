package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.ComentarioRevisorEntity;

public interface ComentarioRevisorDAO {
	
	void create(ComentarioRevisorEntity entity);

	List<ComentarioRevisorEntity> read(ComentarioRevisorEntity entity);

	void update(ComentarioRevisorEntity entity);

	void delete(UUID entityId);

}