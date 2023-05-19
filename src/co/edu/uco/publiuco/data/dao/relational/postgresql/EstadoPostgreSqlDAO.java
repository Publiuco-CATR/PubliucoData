package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.EstadoEntity;
import co.edu.uco.publiuco.entities.TipoEscritorEntity;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.utils.Messages;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;
//import co.edu.uco.publiuco.

public final class EstadoPostgreSqlDAO extends SqlDAO<EstadoEntity>  implements EstadoDAO{
	Connection connection;
	
	public EstadoPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<EstadoEntity> read(EstadoEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();
		
		sqlStatement.append(preparedSelect());
		sqlStatement.append(preparedFrom());
		sqlStatement.append(preparedWhere(entity, parameters));
		sqlStatement.append(preparedOrderBy());
		
		try (var preparedstatement = getConnection().prepareStatement(sqlStatement.toString())){
			
			
		} catch (SQLException exception) {
			var userMessage = Messages.EstadoSql.USER_MESSAGE_READ;
			var technicalMessage = Messages.EstadoSql.TECHNICAL_MESSAGE_CREATE;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
			
		}catch (Exception exception) {
			var userMessage = Messages.EstadoSql.USER_MESSAGE_READ;
			var technicalMessage = Messages.EstadoSql.TECHNICAL_MESSAGE_READ_JAVA_EXCEPTION;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}
		
		return null;
	}

	@Override
	protected final String preparedSelect() {
		return "SELECT identificador, nombre, descripcion, \"tipoEstado\"";
	}

	@Override
	protected final String preparedFrom() {
		return "FROM \"Estado\"";
	}

	@Override
	protected final String preparedWhere(final EstadoEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>()); //por referencia
		var setWhere = true;
		
		if (!UtilObject.isNull(entity)){
			
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador = ? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("nombre = ? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("descripcion = ? ");
				setWhere = false;
			}
			if (!UtilObject.isDefault(entity.getTipoEstado().getIdentificador(), entity.getTipoEstado().getDefaultObject())) {
				parameters.add(entity.getTipoEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append(" \"tipoEstado\" = ? ");
				setWhere = false;
			}
		}
		
		return where.toString();
	}

	@Override
	protected final String preparedOrderBy() {
		return "ORDER BY nombre ASC";
	}


}
