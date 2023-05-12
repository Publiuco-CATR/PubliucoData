package co.edu.uco.publiuco.data.dao.factory.relational.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.data.dao.AdministradorCategoriaDAO;
import co.edu.uco.publiuco.data.dao.CalificacionDAO;
import co.edu.uco.publiuco.data.dao.CategoriaAdministradorCategoriaDAO;
import co.edu.uco.publiuco.data.dao.CategoriaDAO;
import co.edu.uco.publiuco.data.dao.ComentarioLectorDAO;
import co.edu.uco.publiuco.data.dao.ComentarioRevisorDAO;
import co.edu.uco.publiuco.data.dao.EscritorDAO;
import co.edu.uco.publiuco.data.dao.EscritorPublicacionDAO;
import co.edu.uco.publiuco.data.dao.EstadoDAO;
import co.edu.uco.publiuco.data.dao.HistorialAccesoPublicacionDAO;
import co.edu.uco.publiuco.data.dao.LectorDAO;
import co.edu.uco.publiuco.data.dao.ObservacionRevisionDAO;
import co.edu.uco.publiuco.data.dao.PaisDAO;
import co.edu.uco.publiuco.data.dao.PalabraClavePublicacionDAO;
import co.edu.uco.publiuco.data.dao.PerfilDAO;
import co.edu.uco.publiuco.data.dao.PersonaDAO;
import co.edu.uco.publiuco.data.dao.PlanCategoriaDAO;
import co.edu.uco.publiuco.data.dao.PlanPublicacionDAO;
import co.edu.uco.publiuco.data.dao.PreferenciaCategoriaDAO;
import co.edu.uco.publiuco.data.dao.PreferenciaEscritorDAO;
import co.edu.uco.publiuco.data.dao.PublicacionDAO;
import co.edu.uco.publiuco.data.dao.ReporteDAO;
import co.edu.uco.publiuco.data.dao.RespuestaDAO;
import co.edu.uco.publiuco.data.dao.RevisionDAO;
import co.edu.uco.publiuco.data.dao.RevisorDAO;
import co.edu.uco.publiuco.data.dao.RevisorRevisionDAO;
import co.edu.uco.publiuco.data.dao.SuscripcionCategoriaDAO;
import co.edu.uco.publiuco.data.dao.SuscripcionPublicacionDAO;
import co.edu.uco.publiuco.data.dao.TipoAccesoDAO;
import co.edu.uco.publiuco.data.dao.TipoComentarioRevisorDAO;
import co.edu.uco.publiuco.data.dao.TipoEscritorDAO;
import co.edu.uco.publiuco.data.dao.TipoEstadoDAO;
import co.edu.uco.publiuco.data.dao.TipoIdentificacionDAO;
import co.edu.uco.publiuco.data.dao.TipoRelacionInstitucionDAO;
import co.edu.uco.publiuco.data.dao.TipoReporteDAO;
import co.edu.uco.publiuco.data.dao.TipoRevisionDAO;
import co.edu.uco.publiuco.data.dao.VersionDAO;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.relational.postgresql.TipoEstadoPostreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.sqlserver.EstadoSqlServerDAO;
import co.edu.uco.publiuco.utils.UtilSql;

public class PostgresSqlDaoFactory extends DAOFactory{
	
	public static PostgresSqlDaoFactory INSTANCE = new PostgresSqlDaoFactory();
	private static Connection connection;
	private static String JDBCURL = "jdbc:postgresql://mahmud.db.elephantsql.com:5432/chiwqhoc";
	private static String USERNAME = "chiwqhoc";
	private static String PASSWORD = "JnwYqKUX1N9Skfs1WfetoscUE431ULfU";	
	
	public PostgresSqlDaoFactory() {
		openConnection();
	}
	
	public static PostgresSqlDaoFactory getInstance() {
		return INSTANCE;
	}

	@Override
	protected void openConnection() {
		connection = UtilSql.openConnection(JDBCURL, USERNAME, PASSWORD);
	}

	@Override
	public void closeConnection() {
		UtilSql.closeConnection(connection);
	}

	@Override
    public void initTransaction() {
        UtilSql.initTransaction(connection);
    }

    @Override
    public void commitTransaction() {
        UtilSql.commitTransaction(connection);
    }

    @Override
    public void rollbackTransaction() {
        UtilSql.rollbackTransaction(connection);
    }


	@Override
	public TipoEstadoDAO getTipoEstadoDAO() {
		return new TipoEstadoPostreSqlDAO(connection);
	}

	@Override
	public EstadoDAO geEstadoDAO() {
		// CAMBIAR CAMBIAR CAMBIAR CAMBIAR CAMBIAR
		return new EstadoSqlServerDAO(connection);
	}
	
	/*public List<String> getTiposEstados() {
	    List<String> tipos = new ArrayList<>();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        initTransaction();
	        ps = connection.prepareStatement("SELECT \"TipoEstado\".nombre FROM \"Estado\" JOIN \"TipoEstado\" ON \"TipoEstado\".identificador = \"Estado\".tipo;");
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            tipos.add(rs.getString("nombre"));
	        }
	        commitTransaction();
	    } catch (SQLException ex) {
	        rollbackTransaction();
	        ex.printStackTrace();
	    } finally {
	        UtilSql.closeResultSet(rs);
	        UtilSql.closePreparedStatement(ps);
	    }

	    return tipos;
	}
	*/

	@Override
	public PreferenciaCategoriaDAO getPreferenciaCategoriaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoRelacionInstitucionDAO getTipoRelacionInstitucionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdministradorCategoriaDAO getAdministradorCategoriaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalificacionDAO getCalificacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaAdministradorCategoriaDAO getCategoriaAdministradorCategoriaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComentarioLectorDAO getComentarioLectorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComentarioRevisorDAO getComentarioRevisorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EscritorDAO getEscritorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EscritorPublicacionDAO getEscritorPublicacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoDAO getEstadoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistorialAccesoPublicacionDAO getHistorialAccesoPublicacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LectorDAO getLectorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservacionRevisionDAO getObservacionRevisionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDAO getPaisDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PalabraClavePublicacionDAO getPalabraClavePublicacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PerfilDAO getPerfilDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanCategoriaDAO getPlanCategoriaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanPublicacionDAO getPlanPublicacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreferenciaEscritorDAO getPreferenciaEscritorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PublicacionDAO getPublicacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReporteDAO getReporteDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespuestaDAO getRespuestaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RevisionDAO getRevisionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RevisorDAO getRevisorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RevisorRevisionDAO getRevisorRevisionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuscripcionCategoriaDAO getuSuscripcionCategoriaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuscripcionPublicacionDAO getSuscripcionPublicacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoAccesoDAO getTipoAccesoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoComentarioRevisorDAO getTipoComentarioRevisorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoEscritorDAO getTipoEscritorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoIdentificacionDAO getTipoIdentificacionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoReporteDAO getTipoReporteDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoRevisionDAO getTipoRevisionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VersionDAO getVersionDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
