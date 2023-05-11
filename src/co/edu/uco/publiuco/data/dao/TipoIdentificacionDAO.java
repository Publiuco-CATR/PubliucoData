
package co.edu.uco.publiuco.data.dao;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.entities.TipoIdentificacionEntity;

public interface TipoIdentificacionDAO {
	
	void create(TipoIdentificacionEntity entity);

	List<TipoIdentificacionEntity> read(TipoIdentificacionEntity entity);
	
	void update(TipoIdentificacionEntity entity);

	void delete(UUID entityId);

}