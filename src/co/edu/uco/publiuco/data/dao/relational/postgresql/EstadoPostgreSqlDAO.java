package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.entities.EstadoEntity;
import co.edu.uco.publiuco.entities.TipoEscritorEntity;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;
//import co.edu.uco.publiuco.

public final class EstadoPostgreSqlDAO implements EstadoDAO{
	Connection connection;
	
	public EstadoPostgreSqlDAO(final Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(final EstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final List<EstadoEntity> read(final EstadoEntity entity) {
		try {
			PreparedStatement preparedStatementEstado = connection.prepareStatement("SELECT * FROM \"Estado\"");
			ResultSet resultSetEstado = preparedStatementEstado.executeQuery();
			List<EstadoEntity> result = new ArrayList<>();
			while (resultSetEstado.next()) {
				UUID identificador = UtilUUID.generateUUIDFromString(resultSetEstado.getString("identificador"));
				String nombre = resultSetEstado.getString("nombre");
				//TipoEscritorEntity descripcion = UtilObject.getDefault(null, null);
				EstadoEntity resultEntity = new EstadoEntity(identificador, nombre, TipoEstadoEntity.DEFAULT_OBJECT);
				result.add(resultEntity);
				System.out.println(identificador + nombre + TipoEstadoEntity.getDefaultObject());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public final void update(final EstadoEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void delete(final UUID entityId) {
		// TODO Auto-generated method stub
		
	}

}
