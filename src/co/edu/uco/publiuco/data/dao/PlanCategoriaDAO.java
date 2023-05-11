package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.PlanCategoriaEntity;

public interface PlanCategoriaDAO {
	
	void create(PlanCategoriaEntity entity);

	List<PlanCategoriaEntity> read(PlanCategoriaEntity entity);

	void update(PlanCategoriaEntity entity);

	void delete(UUID entityId);

}