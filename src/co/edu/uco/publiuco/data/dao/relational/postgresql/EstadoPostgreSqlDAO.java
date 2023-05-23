package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.EstadoEntity;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.utils.Messages;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;
//import co.edu.uco.publiuco.

public final class EstadoPostgreSqlDAO extends SqlDAO<EstadoEntity>  implements EstadoDAO{
	
	public EstadoPostgreSqlDAO(final Connection connection) {
		super(connection);
	}


	@Override
	public final List<EstadoEntity> read(EstadoEntity entity) {
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
		return "SELECT e.identificador, e.nombre, e.descripcion, te.identificador, te.nombre, te.descripcion ";
	}

	@Override
	protected final String preparedFrom() {
		return "FROM \"Estado\" e JOIN \"TipoEstado\" te ON te.identificador = e.\"tipoEstado\" ";
	}

	@Override
	protected final String preparedWhere(final EstadoEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>()); //por referencia
		var setWhere = true;
		
		if (!UtilObject.isNull(entity)){
			
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE e.identificador = ? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("e.nombre = ? ");
				setWhere = false;
			}
			if (UtilObject.isNull(entity.getTipo().getIdentificador()) && !UtilUUID.isDefault(entity.getTipo().getIdentificador())){
				parameters.add(entity.getTipo().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append(" te.identificador = ? ");
				setWhere = false;
			}
			if (!UtilObject.isNull(entity.getTipo().getNombre()) && UtilText.isEmpty(entity.getTipo().getNombre())) {
				parameters.add(entity.getTipo().getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("te.nombre = ? ");
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
	protected final List<EstadoEntity> executeQuery(PreparedStatement preparedStatement) {
		
		final List<EstadoEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()){
			while(resultSet.next()) {
				var entityTmp = new EstadoEntity(
						resultSet.getObject(1, UUID.class), 
						resultSet.getString(2),
						TipoEstadoEntity.create().setIdentificador(resultSet.getObject(4, UUID.class)).setNombre(resultSet.getString(5)).setDescripcion(resultSet.getString(6)),
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
