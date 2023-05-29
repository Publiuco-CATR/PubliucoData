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
import co.edu.uco.publiuco.entities.LectorEntity;
import co.edu.uco.publiuco.entities.PublicacionEntity;
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
		return "SELECT cl.identificador identificador, cl.lector idlector, el.nombre estlector, l.\"datosPersona\" idpersonalector, pl.\"primerNombre\" nombre1, pl.\"segundoNombre\" nombre2,pl.\"primerApellido\" apellido1, pl.\"segundoApellido\" apellido2, pl.\"correoElectronico\" correo, epl.nombre estpersonalector, cl.publicacion idpublicacion, p.\"versionPublicada\" idversion, p.\"fechaPublicacion\", vp.titulo tituloversion, ep.nombre estpublicacion, cl.\"tienePadre\" tienepadre, cl.\"comentarioPadre\" idpadre, cl.\"fechaComentario\" fechacomentario, cl.contenido contenido, cl.estado est, ecl.nombre estcomentario ";
	}

	@Override
	protected final String preparedFrom() {
		return "FROM \"ComentarioLector\" cl LEFT JOIN \"Lector\" l ON l.identificador = cl.lector LEFT JOIN \"Persona\" pl ON pl.identificador = l.\"datosPersona\" LEFT JOIN \"Estado\" epl ON epl.identificador = pl.estado LEFT JOIN \"TipoEstado\" teepl ON teepl.identificador = epl.\"tipoEstado\" LEFT JOIN \"Estado\" el ON el.identificador = l.estado LEFT JOIN \"TipoEstado\" teel ON teel.identificador = el.\"tipoEstado\" LEFT JOIN \"Publicacion\" p ON p.identificador = cl.publicacion LEFT JOIN \"Categoria\" cp ON cp.identificador = p.categoria LEFT JOIN \"TipoAcceso\" tacp ON tacp.identificador = p.\"tipoAcceso\" LEFT JOIN \"Version\" vp ON vp.identificador = p.\"versionPublicada\" LEFT JOIN \"Estado\" ep ON ep.identificador = p.estado LEFT JOIN \"TipoEstado\" teep ON teepl.identificador = ep.\"tipoEstado\" LEFT JOIN \"Estado\" ecl ON ecl.identificador = cl.estado LEFT JOIN \"TipoEstado\" teecl ON teecl.identificador = ecl.\"tipoEstado\" ";
	}

	@Override
	protected final String preparedWhere(final ComentarioLectorEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		var setWhere = true;
		
		if (!UtilObject.isNull(entity)){
			
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE e.identificador = ? ");
				setWhere = false;
			}
			if (!UtilText.isEmpty(entity.getCotenido())) {
				parameters.add(entity.getCotenido());
				where.append(setWhere ? "WHERE " : "AND ").append("e.nombre = ? ");
				setWhere = false;
			}
			if (entity.tienePadre()? !UtilUUID.isDefault(entity.getComentarioPadre().getIdentificador()):false) {
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
				final ComentarioLectorEntity entityTmp = ComentarioLectorEntity.create()
						.setIdentificador(resultSet.getObject("identificador", UUID.class))
						.setLector(
								LectorEntity.create())
						.setPublicacion(PublicacionEntity.create())
						.setTienePadre(resultSet.getBoolean("tienepadre"))
						.setComentarioPadre(resultSet.getBoolean("tienepadre") ? ComentarioLectorEntity.create() : (ComentarioLectorEntity) UtilObject.getNullValue())
						.setFechaComentario(resultSet.getTimestamp("fechacomentario").toLocalDateTime())
						.setContenido(resultSet.getString("contenido"))
						.setEstado(EstadoEntity.create());
						

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