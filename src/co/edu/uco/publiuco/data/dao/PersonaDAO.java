package co.edu.uco.publiuco.data.dao;

import java.util.List;

import co.edu.uco.publiuco.entities.PersonaEntity;

public interface PersonaDAO {
	
	void create(PersonaEntity entity);

	List<PersonaEntity> read(PersonaEntity entity);

	void update(PersonaEntity entity);

	void delete(PersonaEntity entity);

}