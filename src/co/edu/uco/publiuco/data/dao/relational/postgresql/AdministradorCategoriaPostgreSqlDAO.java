package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.data.dao.AdministradorCategoriaDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.AdministradorCategoriaEntity;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.utils.Messages;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class AdministradorCategoriaPostgreSqlDAO extends SqlDAO<AdministradorCategoriaEntity> implements AdministradorCategoriaDAO {

	public AdministradorCategoriaPostgreSqlDAO(final Connection connection) {
		super(connection);
	}
	
	@Override
	public void create(AdministradorCategoriaEntity entity) {
		
		var sqlStatement = "INSERT INTO public.\"AdministradorCategoria\"(identificador, \"datosPersona\", estado) VALUES (?, ?, ?);";
		
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			preparedStatement.setObject(1, entity.getIdentificador());
			preparedStatement.setObject(2, entity.getDatosPersona());
			preparedStatement.setObject(3, entity.getEstado());
			
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
	public List<AdministradorCategoriaEntity> read(AdministradorCategoriaEntity entity) {
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
	public void update(AdministradorCategoriaEntity entity) {
		var sqlStatement = "UPDATE \"TipoEstado\" SET nombre=?, descripcion = ? WHERE identificador = ?;";
		
		try (var preparedStatement = getConnection().prepareStatement(sqlStatement)) {
			//preparedStatement.setString(1, entity.getNombre());
			//preparedStatement.setString(2, entity.getDescripcion());
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
		var sqlStatement = "DELETE FROM \"AdministradorCategoria\" WHERE identificador = ?;";
		
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
		return "SELECT admc.identificador, p.identificador, p.\"primerNombre\", p.\"segundoNombre\", p.\"primerApellido\", p.\"segundoApellido\", p.\"correoElectronico\", tip.identificador, tip.nombre, tip.descripcion, eti.identificador, eti.nombre, eti.descripcion, pais.identificador, pais.nombre, pais.\"indicadorPais\", p.\"numeroTelefono\", tri.identificador, tri.nombre, tri.nombre, tri.descripcion, etri.identificador, etri.nombre, etri.descripcion, e.identificador, e.nombre, e.descripcion ";
	}

	@Override
	protected final String preparedFrom() {
		return "FROM \"AdministradorCategoria\" admc JOIN \"Persona\" p ON p.identificador = admc.\"datosPersona\" JOIN \"TipoIdentificacion\" tip ON tip.identificador = p.\"tipoIdentificacion\" JOIN \"Estado\" eti ON tip.estado = eti.identificador JOIN \"Pais\" pais ON pais.identificador = p.\"paisTelefono\" JOIN \"TipoRelacionInstitucion\" tri ON tri.identificador = p.\"relacionInstitucion\" JOIN \"Estado\" etri ON etri.identificador = tri.estado JOIN \"Estado\" e ON e.identificador = admc.estado ";
	}

	@Override
	protected final String preparedWhere(final AdministradorCategoriaEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>());
		var setWhere = true;
		
		if (!UtilObject.isNull(entity)){
			
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append("WHERE identificador = ? ");
				setWhere = false;
			}
			/*if (!UtilText.getUtilText().isEmpty(entity.getDatosPersona().getIdentificador())) {
				parameters.add(entity.getDatosPersona().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("nombre = ? ");
				setWhere = false;
			}
			if (!UtilText.getUtilText().isEmpty(entity.getDescripcion())) {
				parameters.add(entity.getDescripcion());
				where.append(setWhere ? "WHERE " : "AND ").append("descripcion = ? ");
				setWhere = false;
			}*/
		}
		
		return where.toString();
	}

	@Override
	protected final String preparedOrderBy() {
		return "ORDER BY nombre ASC";
	}

	@Override
	protected void setParameters(PreparedStatement preparedStatement, List<Object> parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<AdministradorCategoriaEntity> executeQuery(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
