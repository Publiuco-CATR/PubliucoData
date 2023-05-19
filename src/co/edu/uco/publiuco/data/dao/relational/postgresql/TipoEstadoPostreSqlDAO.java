package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.utils.Messages;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class TipoEstadoPostreSqlDAO extends SqlDAO<TipoEstadoEntity> implements TipoEstadoDAO{
	
	public TipoEstadoPostreSqlDAO(final Connection connection) {
		super(connection);
	}
	
	@Override
	public void create(TipoEstadoEntity entity) {
		
		var sqlStatement = "INSERT INTO \"TipoEstado\"( identificador, nombre, descripcion) VALUES (?, ?, ?);";
		
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setString(2, entity.getNombre());
			preparedStatement.setString(3, entity.getDescripcion());
			
			preparedStatement.executeUpdate();
			
		}catch (SQLException exception) {
			var userMessage = Messages.TipoEstadoSql.USER_MESSAGE_CREATE;
			var technicalMessage = Messages.TipoEstadoSql.TECHNICAL_MESSAGE_CREATE;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
			
		}catch (Exception exception) {
			var userMessage = Messages.TipoEstadoSql.USER_MESSAGE_CREATE;
			var technicalMessage = Messages.TipoEstadoSql.TECHNICAL_MESSAGE_CREATE_JAVA_EXCEPTION;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}		
	}


	@Override
	public List<TipoEstadoEntity> read(TipoEstadoEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();
		
		sqlStatement.append(preparedSelect());
		sqlStatement.append(preparedFrom());
		sqlStatement.append(preparedWhere(entity, parameters));
		sqlStatement.append(preparedOrderBy());
		
		try (var preparedstatement = getConnection().prepareStatement(sqlStatement.toString())){
			
			
		} catch (SQLException exception) {
			var userMessage = Messages.TipoEstadoSql.USER_MESSAGE_CREATE;
			var technicalMessage = Messages.TipoEstadoSql.TECHNICAL_MESSAGE_CREATE;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
			
		}catch (Exception exception) {
			var userMessage = Messages.TipoEstadoSql.USER_MESSAGE_CREATE;
			var technicalMessage = Messages.TipoEstadoSql.TECHNICAL_MESSAGE_CREATE_JAVA_EXCEPTION;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}
		
		return null;
	}
	
	@Override
	public void update(TipoEstadoEntity entity) {
		var sqlStatement = "UPDATE \"TipoEstado\" SET nombre=?, descripcion = ? WHERE identificador = ?;";
		
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setString(1, entity.getNombre());
			preparedStatement.setString(2, entity.getDescripcion());
			preparedStatement.setObject(3, entity.getIdentificador());
			
			preparedStatement.executeUpdate();
			
		}catch (SQLException exception) {
			var userMessage = Messages.TipoEstadoSql.USER_MESSAGE_READ;
			var technicalMessage = Messages.TipoEstadoSql.TECHNICAL_MESSAGE_READ;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
			
		}catch (Exception exception) {
			var userMessage = Messages.TipoEstadoSql.USER_MESSAGE_READ;
			var technicalMessage = Messages.TipoEstadoSql.TECHNICAL_MESSAGE_READ_JAVA_EXCEPTION;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}		
		
	}

	@Override
	public void delete(UUID entityid) {
		var sqlStatement = "DELETE FROM \"TipoEstado\" WHERE identificador = ?;";
		
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entityid);
			
			preparedStatement.executeUpdate();
			
		}catch (SQLException exception) {
			var userMessage = Messages.TipoEstadoSql.USER_MESSAGE_DELETE;
			var technicalMessage = Messages.TipoEstadoSql.TECHNICAL_MESSAGE_DELETE;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
			
		}catch (Exception exception) {
			var userMessage = Messages.TipoEstadoSql.USER_MESSAGE_DELETE;
			var technicalMessage = Messages.TipoEstadoSql.TECHNICAL_MESSAGE_DELETE_JAVA_EXCEPTION;
			throw PubliucoDataException.create(technicalMessage, userMessage, exception);
		}		
	}

	@Override
	protected final String preparedSelect() {
		return "SELECT identificador, nombre, descripcion";
	}

	@Override
	protected final String preparedFrom() {
		return "FROM \"TipoEstado\"";
	}

	@Override
	protected final String preparedWhere(final TipoEstadoEntity entity, List<Object> parameters) {
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
		}
		
		return where.toString();
	}

	@Override
	protected final String preparedOrderBy() {
		return "ORDER BY nombre ASC";
	}


}
