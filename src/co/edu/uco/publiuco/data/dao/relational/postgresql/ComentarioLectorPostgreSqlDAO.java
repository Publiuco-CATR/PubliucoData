package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.data.dao.ComentarioLectorDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.CategoriaEntity;
import co.edu.uco.publiuco.entities.ComentarioLectorEntity;
import co.edu.uco.publiuco.entities.EstadoEntity;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.utils.Messages;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class ComentarioLectorPostgreSqlDAO extends SqlDAO<ComentarioLectorEntity> implements ComentarioLectorDAO {

	public ComentarioLectorPostgreSqlDAO(final Connection connection) {
		super(connection);
	}
	
	@Override
	public void create(ComentarioLectorEntity entity) {
		var sqlStatement = "INSERT INTO public.\"ComentarioLector\"(identificador, lector, publicacion, \"tienePadre\", \"comentarioPadre\", \"fechaComentario\", estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setObject(2, entity.getLector().getIdentificador()); 
			preparedStatement.setObject(3, entity.getPublicacion().getIdentificador());
			preparedStatement.setBoolean(4, entity.tienePadre());
			preparedStatement.setObject(5, entity.tienePadre() ? entity.getComentarioPadre().getIdentificador() : null);
			preparedStatement.setTimestamp(6, Timestamp.valueOf(entity.getFechaComentario() ));
			preparedStatement.setObject(7, entity.getEstado().getIdentificador());

			preparedStatement.executeUpdate();

		}catch (SQLException exception) {
			throw PubliucoDataException.create(Messages.ComentarioLectorSql.TECHNICAL_MESSAGE_CREATE, Messages.ComentarioLectorSql.USER_MESSAGE_CREATE, exception);

		}catch (Exception exception) {
			throw PubliucoDataException.create(Messages.ComentarioLectorSql.TECHNICAL_MESSAGE_CREATE_JAVA_EXCEPTION, Messages.ComentarioLectorSql.USER_MESSAGE_CREATE, exception);
		}
	}

	@Override
	public List<ComentarioLectorEntity> read(ComentarioLectorEntity entity) {
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
			throw PubliucoDataException.create(Messages.ComentarioLectorSql.TECHNICAL_MESSAGE_READ, Messages.ComentarioLectorSql.USER_MESSAGE_READ, exception);
			
		}catch (Exception exception) {
			throw PubliucoDataException.create(Messages.ComentarioLectorSql.TECHNICAL_MESSAGE_READ_JAVA_EXCEPTION, Messages.ComentarioLectorSql.USER_MESSAGE_READ, exception);
		}
	}

	@Override
	public final void update(ComentarioLectorEntity entity) {
		final var sqlStatement = "UPDATE \"ComentarioLector\" SET estado = ? WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getEstado().getIdentificador());
			preparedStatement.setObject(2, entity.getIdentificador());

			preparedStatement.executeUpdate();

		}catch (SQLException exception) {
			throw PubliucoDataException.create(Messages.ComentarioLectorSql.TECHNICAL_MESSAGE_UPDATE, Messages.ComentarioLectorSql.USER_MESSAGE_UPDATE, exception);

		}catch (Exception exception) {
			throw PubliucoDataException.create(Messages.ComentarioLectorSql.TECHNICAL_MESSAGE_UPDATE_JAVA_EXCEPTION, Messages.ComentarioLectorSql.USER_MESSAGE_UPDATE, exception);
		}
	}

	@Override
	public void delete(UUID entityId) {
		var sqlStatement = "DELETE FROM \"ComentarioLector\" WHERE identificador = ?";

		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entityId);

			preparedStatement.executeUpdate();

		}catch (SQLException exception) {
			throw PubliucoDataException.create(Messages.ComentarioLectorSql.TECHNICAL_MESSAGE_DELETE, Messages.ComentarioLectorSql.USER_MESSAGE_DELETE, exception);
		}catch (Exception exception) {
			throw PubliucoDataException.create(Messages.ComentarioLectorSql.TECHNICAL_MESSAGE_DELETE_JAVA_EXCEPTION, Messages.ComentarioLectorSql.USER_MESSAGE_DELETE, exception);
		}
		
	}

	@Override
	protected final String preparedSelect() {
		return "SELECT p.identificador identificador, c.identificador identificadorcategoria, c.nombre nombrecategoria, ec.identificador idestcat, ec.nombre nomestcat, teec.identificador teidescat, teec.nombre tenomescat, p.\"fechaPublicacion\" fechapublicacion, v.identificador identificadorversion, v.titulo titulo, v.resumen resumen, v.cuerpo cuerpo, ev.identificador idestv, ev.nombre nomestv, teev.identificador teidestv, teev.nombre tenomestv, e.identificador estadoidentificador, e.nombre estadonombre, tee.identificador teides, tee.nombre tenomes";
	}

	@Override
	protected final String preparedFrom() {
		return "FROM \"Publicacion\" p JOIN \"Categoria\" c ON c.identificador = p.categoria JOIN \"Estado\" ec ON ec.identificador = c.estado JOIN \"TipoEstado\" teec ON teec.identificador = ec.\"tipoEstado\" JOIN \"Version\" v ON v.identificador = p.\"versionPublicada\" JOIN \"Estado\" ev ON ev.identificador = v.estado JOIN \"TipoEstado\" teev ON teev.identificador = ev.\"tipoEstado\" JOIN \"Estado\" e ON e.identificador = p.estado JOIN \"TipoEstado\" tee ON tee.identificador = e.\"tipoEstado\"";
	}

	@Override
	protected final String preparedWhere(final ComentarioLectorEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>()); //por referencia
		var setWhere = true;
		
		if (!UtilObject.isNull(entity)){
			
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE e.identificador = ? ");
				setWhere = false;
			}
//			if (!UtilText.isEmpty(entity.getNombre())) {
//				parameters.add(entity.getNombre());
//				where.append(setWhere ? "WHERE " : "AND ").append("e.nombre = ? ");
//				setWhere = false;
//			}
			if (!UtilUUID.isDefault(entity.getComentarioPadre().getIdentificador())) {
				parameters.add(entity.getComentarioPadre().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ");
				setWhere = false;
			}
			if (UtilUUID.isDefault(entity.getEstado().getIdentificador())) {
				parameters.add(entity.getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ");
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
			throw PubliucoDataException.create(Messages.CategoriaSql.TECHNICAL_MESSAGE_SET_PARAMETERS, Messages.CategoriaSql.USER_MESSAGE_SET_PARAMETERS, exception);
			
		}catch(final Exception exception) {			
			throw PubliucoDataException.create(Messages.CategoriaSql.TECHNICAL_MESSAGE_SET_PARAMETERS_JAVA_EXCEPTION, Messages.CategoriaSql.USER_MESSAGE_SET_PARAMETERS, exception);

		}
	}

	@Override
	protected final List<ComentarioLectorEntity> executeQuery(PreparedStatement preparedStatement) {
		
		final List<ComentarioLectorEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()){
			while(resultSet.next()) {
				final ComentarioLectorDAO entityTmp = ComentarioLectorEntity.create()
						.setIdentificador(resultSet.getObject("identificador", UUID.class))
						.setNombre(resultSet.getString("nombre"))
						.setDescripcion(resultSet.getString("descripcion"))
						.setTienePadre(resultSet.getBoolean("tienePadre"))
						.setEstado(EstadoEntity.create().setIdentificador(resultSet.getObject("identificadorestado", UUID.class)).setNombre(resultSet.getString("nombreestado"))
								.setTipo(TipoEstadoEntity.create().setIdentificador(resultSet.getObject("identificadortipoestado", UUID.class)).setNombre(resultSet.getString("nombretipoestado"))))
						.setCategoriaPadre(UtilUUID.isDefault(resultSet.getObject("identificadorCategoriaPadre", UUID.class)) ? read(CategoriaEntity.create().setIdentificador(resultSet.getObject("identificadorCategoriaPadre", UUID.class))).get(0) : null);
						
//				if (UtilUUID.isDefault(resultSet.getObject("identificadorCategoriaPadre", UUID.class))) {
//					entityTmp.setCategoriaPadre(read(CategoriaEntity.create().setIdentificador(resultSet.getObject("identificadorCategoriaPadre", UUID.class))).get(0));
//				}
				result.add(entityTmp);
			}
			return result;
			
		} catch(final SQLException exception) {			
			throw PubliucoDataException.create(Messages.CategoriaSql.TECHNICAL_MESSAGE_EXECUTE, Messages.CategoriaSql.USER_MESSAGE_EXECUTE, exception);
			
		}catch(final Exception exception) {			
			throw PubliucoDataException.create(Messages.CategoriaSql.TECHNICAL_MESSAGE_EXECUTE_JAVA_EXCEPTION, Messages.CategoriaSql.USER_MESSAGE_EXECUTE, exception);

		}
	}
}