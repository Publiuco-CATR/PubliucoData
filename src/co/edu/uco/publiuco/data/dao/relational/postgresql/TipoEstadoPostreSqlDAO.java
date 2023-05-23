package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.TipoEscritorEntity;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.utils.Messages;
import co.edu.uco.publiuco.utils.Messages.TipoEstadoSql;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class TipoEstadoPostreSqlDAO extends SqlDAO<TipoEstadoEntity> implements TipoEstadoDAO{
	
	public TipoEstadoPostreSqlDAO(final Connection connection) {
		super(connection);
	}
	
	@Override
	public final List<TipoEstadoEntity> read(TipoEstadoEntity entity) {
		var sqlStatement = new StringBuilder();
		var parameters = new ArrayList<>();
		
		sqlStatement.append(preparedSelect());
		sqlStatement.append(preparedFrom());
		sqlStatement.append(preparedWhere(entity, parameters));
		sqlStatement.append(preparedOrderBy());
		
		try (var preparedstatement = getConnection().prepareStatement(sqlStatement.toString())){
			setParameters(preparedstatement, parameters);
			
			return executeQuery(preparedstatement);
			
		} catch (SQLException exception) {
			throw PubliucoDataException.create(Messages.TipoEstadoSql.TECHNICAL_MESSAGE_CREATE, Messages.TipoEstadoSql.USER_MESSAGE_CREATE, exception);
			
		}catch (Exception exception) {
			throw PubliucoDataException.create(Messages.TipoEstadoSql.TECHNICAL_MESSAGE_CREATE_JAVA_EXCEPTION, Messages.TipoEstadoSql.USER_MESSAGE_CREATE, exception);
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
	
	@Override
	protected final void setParameters(final PreparedStatement preparedStatement, final List<Object> parameters) {
		try {
			if (!UtilObject.isNull(parameters) && !UtilObject.isNull(preparedStatement))  {
				for(int index = 0; index < parameters.size(); index ++) {
					preparedStatement.setObject(index + 1, parameters.get(index));
				}
			}	
		}catch(final SQLException exception) {
			throw PubliucoDataException.create(Messages.TipoEstadoSql.TECHNICAL_MESSAGE_SET_PARAMETERS, Messages.TipoEstadoSql.USER_MESSAGE_SET_PARAMETERS, exception);
			
		}catch(final Exception exception) {			
			throw PubliucoDataException.create(Messages.TipoEstadoSql.TECHNICAL_MESSAGE_SET_PARAMETERS_JAVA_EXCEPTION, Messages.TipoEstadoSql.USER_MESSAGE_SET_PARAMETERS, exception);

		}
	}

	@Override
	protected final List<TipoEstadoEntity> executeQuery(PreparedStatement preparedStatement) {
		
		final List<TipoEstadoEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()){
			while(resultSet.next()) {
				var entityTmp = new TipoEstadoEntity(
						resultSet.getObject(1, UUID.class), 
						resultSet.getString(2), 
						resultSet.getString(3));
				result.add(entityTmp);
			}
			return result;
			
		} catch(final SQLException exception) {			
			throw PubliucoDataException.create(Messages.TipoEstadoSql.TECHNICAL_MESSAGE_EXECUTE, Messages.TipoEstadoSql.USER_MESSAGE_EXECUTE, exception);
			
		}catch(final Exception exception) {			
			throw PubliucoDataException.create(Messages.TipoEstadoSql.TECHNICAL_MESSAGE_EXECUTE_JAVA_EXCEPTION, Messages.TipoEstadoSql.USER_MESSAGE_EXECUTE, exception);

		}		
	}
}
