package co.edu.uco.publiuco.data.dao.factory.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.crosscutting.exception.PubliucoDataException;
import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.EstadoSqlServerDAO;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.TipoEstadoSqlServerDAO;
import co.edu.uco.publiuco.utils.Messages.UtilSqlMessages;
import co.edu.uco.publiuco.utils.UtilSql;

public class PostgresSqlDaoFactory extends DAOFactory{

	private static Connection connection;
	private static String JDBCURL = "jdbc:postgresql://mahmud.db.elephantsql.com:5432/chiwqhoc";
	private static String USERNAME = "chiwqhoc";
	private static String PASSWORD = "JnwYqKUX1N9Skfs1WfetoscUE431ULfU";	
	
	public PostgresSqlDaoFactory() {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {
		connection = UtilSql.openConnection(JDBCURL, USERNAME, PASSWORD);
	}

	@Override
	public void cerrarConexion() {
		UtilSql.closeConnection(connection);
	}

	@Override
    public void iniciarTransaccion() {
        if (UtilSql.connectionIsOpen(connection)) {
        	try {
                connection.setAutoCommit(false);
            }  catch (SQLException exception) {
                var userMessage = UtilSqlMessages.BEGIN_TRANSACTION_USER_MESSAGE;
                var technicalMessage = UtilSqlMessages.BEGIN_TRANSACTION_TECHNICAL_MESSAGE;
                throw PubliucoDataException.create(technicalMessage, userMessage, exception);
            }
        }
    }

    @Override
    public void confirmarTransaccion() {
        if (UtilSql.connectionIsOpen(connection)) {
        	try {
                connection.commit();
            } catch (SQLException e) {
            	cancelarTransaccion();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void cancelarTransaccion() {
        if (UtilSql.connectionIsOpen(connection)) {
        	try {
                connection.rollback();
            } catch (SQLException exception) {
                var userMessage = UtilSqlMessages.CANCEL_TRANSACTION_USER_MESSAGE;
                var technicalMessage = UtilSqlMessages.CANCEL_TRANSACTION_TECHNICAL_MESSAGE;
                throw PubliucoDataException.create(technicalMessage, userMessage, exception);
            }
        }
    }


	@Override
	public TipoEstadoDAO getTipoEstadoDAO() {
		// TODO Auto-generated method stub
		return new TipoEstadoSqlServerDAO(connection);
	}

	@Override
	public EstadoDAO geEstadoDAO() {
		// TODO Auto-generated method stub
		return new EstadoSqlServerDAO(connection);
	}
	
	public List<String> getTiposEstados() {
	    List<String> tipos = new ArrayList<>();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        iniciarTransaccion();
	        ps = connection.prepareStatement("SELECT \"TipoEstado\".nombre FROM \"Estado\" JOIN \"TipoEstado\" ON \"TipoEstado\".identificador = \"Estado\".tipo;");
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            tipos.add(rs.getString("nombre"));
	        }
	        confirmarTransaccion();
	    } catch (SQLException ex) {
	        cancelarTransaccion();
	        ex.printStackTrace();
	    } finally {
	        UtilSql.closeResultSet(rs);
	        UtilSql.closePreparedStatement(ps);
	    }

	    return tipos;
	}


	public static void main(String[] args) throws SQLException {
				
		PostgresSqlDaoFactory intento = new PostgresSqlDaoFactory();
		System.out.println(intento.getTiposEstados());
		intento.cerrarConexion();
	}

}
