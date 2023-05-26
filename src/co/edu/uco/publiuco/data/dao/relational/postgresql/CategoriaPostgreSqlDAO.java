package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.data.dao.CategoriaDAO;
import co.edu.uco.publiuco.data.dao.relational.SqlDAO;
import co.edu.uco.publiuco.entities.CategoriaEntity;
import co.edu.uco.publiuco.entities.EstadoEntity;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.utils.Messages;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class CategoriaPostgreSqlDAO extends SqlDAO<CategoriaEntity> implements CategoriaDAO {

	public CategoriaPostgreSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final List<CategoriaEntity> read(CategoriaEntity entity) {
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
			throw PubliucoDataException.create(Messages.CategoriaSql.TECHNICAL_MESSAGE_READ, Messages.CategoriaSql.USER_MESSAGE_READ, exception);
			
		}catch (Exception exception) {
			throw PubliucoDataException.create(Messages.CategoriaSql.TECHNICAL_MESSAGE_READ_JAVA_EXCEPTION, Messages.CategoriaSql.USER_MESSAGE_READ, exception);
		}
	}


	@Override
	protected final String preparedSelect() {
		return "SELECT c.identificador identificador, c.nombre nombre, c.descripcion descripcion, c.\"tienePadre\" tienePadre, c.\"categoriaPadre\" identificadorCategoriaPadre, ec.identificador identificadorestado, ec.nombre nombreestado, teec.identificador identificadortipoestado, teec.nombre nombretipoestado ";
	}

	@Override
	protected final String preparedFrom() {
		return "FROM \"Categoria\" c JOIN \"Estado\" ec ON ec.identificador = c.estado JOIN \"TipoEstado\" teec ON teec.identificador = ec.\"tipoEstado\" ";
	}

	@Override
	protected final String preparedWhere(final CategoriaEntity entity, List<Object> parameters) {
		final var where = new StringBuilder("");
		parameters = UtilObject.getDefault(parameters, new ArrayList<>()); //por referencia
		var setWhere = true;
		
		if (!UtilObject.isNull(entity)){
			
			if (!UtilUUID.isDefault(entity.getIdentificador())) {
				parameters.add(entity.getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append("c.identificador = ? ");
				setWhere = false;
			}
			if (!UtilText.isEmpty(entity.getNombre())) {
				parameters.add(entity.getNombre());
				where.append(setWhere ? "WHERE " : "AND ").append("c.nombre = ? ");
				setWhere = false;
			}
			if (!UtilObject.isNull(entity.getCategoriaPadre()) &&  (!UtilUUID.isDefault(entity.getCategoriaPadre().getIdentificador()))) {
					parameters.add(entity.getCategoriaPadre().getIdentificador());
					where.append(setWhere ? "WHERE " : "AND ").append("c.\"categoriaPadre\"  = ? ");
					setWhere = false;
				
			}
			if (!UtilUUID.isDefault(entity.getEstado().getIdentificador())) {
				parameters.add(entity.getEstado().getIdentificador());
				where.append(setWhere ? "WHERE " : "AND ").append(" ec.identificador = ? ");
				setWhere = false; 
			}
		}	
		return where.toString();
	}

	@Override
	protected final String preparedOrderBy() {
		return "ORDER BY c.nombre ASC";
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
	protected final List<CategoriaEntity> executeQuery(PreparedStatement preparedStatement) {
		
		final List<CategoriaEntity> result = new ArrayList<>();
		
		try (var resultSet = preparedStatement.executeQuery()){
			while(resultSet.next()) {
				System.out.println(resultSet.getObject("identificador", UUID.class));
				final CategoriaEntity entityTmp = CategoriaEntity.create()
						.setIdentificador(resultSet.getObject("identificador", UUID.class))
						.setNombre(resultSet.getString("nombre"))
						.setDescripcion(resultSet.getString("descripcion"))
						.setTienePadre(resultSet.getBoolean("tienePadre"))
						.setEstado(EstadoEntity.create().setIdentificador(resultSet.getObject("identificadorestado", UUID.class)).setNombre(resultSet.getString("nombreestado"))
								.setTipo(TipoEstadoEntity.create().setIdentificador(resultSet.getObject("identificadortipoestado", UUID.class)).setNombre(resultSet.getString("nombretipoestado"))));
				if (!UtilObject.isNull(resultSet.getObject("identificadorCategoriaPadre", UUID.class)) && !UtilUUID.isDefault(resultSet.getObject("identificadorCategoriaPadre", UUID.class))) {
					entityTmp.setCategoriaPadre(read(CategoriaEntity.create().setIdentificador(resultSet.getObject("identificadorCategoriaPadre", UUID.class))).get(0));
				}
				System.out.println(UtilObject.getInstanceInString(entityTmp));
				result.add(entityTmp);
				
				
			}
			System.out.println(result);
			return result;
			
		} catch(final SQLException exception) {			
			throw PubliucoDataException.create(Messages.CategoriaSql.TECHNICAL_MESSAGE_EXECUTE, Messages.CategoriaSql.USER_MESSAGE_EXECUTE, exception);
			
		}catch(final Exception exception) {			
			throw PubliucoDataException.create(Messages.CategoriaSql.TECHNICAL_MESSAGE_EXECUTE_JAVA_EXCEPTION, Messages.CategoriaSql.USER_MESSAGE_EXECUTE, exception);

		}		
	}	
	
	public static void main(String[] args) {
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://mahmud.db.elephantsql.com:5432/nfjaiiyr", "nfjaiiyr","hFdpP8B7-CxwFNh4IuZ3NXdqnJbegOcf");
			var ensayo =  new CategoriaPostgreSqlDAO(connection);
			System.out.println(ensayo.read(CategoriaEntity.create()).toString());;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}