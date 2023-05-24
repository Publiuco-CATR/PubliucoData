package co.edu.uco.publiuco.data.dao.factory.relational.postgresql;

import java.sql.Connection;

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
import co.edu.uco.publiuco.data.dao.relational.postgresql.AdministradorCategoriaPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.CalificacionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.CategoriaAdministradorCategoriaPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.CategoriaPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.ComentarioLectorPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.ComentarioRevisorPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.EscritorPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.EscritorPublicacionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.EstadoPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.HistorialAccesoPublicacionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.LectorPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.ObservacionRevisionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PaisPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PalabraClavePublicacionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PerfilPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PersonaPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PlanCategoriaPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PlanPublicacionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PreferenciaCategoriaPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PreferenciaEscritorPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.PublicacionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.ReportePostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.RespuestaPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.RevisionPosgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.RevisorPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.RevisorRevisionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.SuscripcionCategoriaPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.SuscripcionPublicacionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.TipoAccesoPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.TipoComentarioRevisorPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.TipoEscritorPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.TipoEstadoPostreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.TipoIdentificacionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.TipoRelacionInstitucionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.TipoReportePostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.TipoRevisionPostgreSqlDAO;
import co.edu.uco.publiuco.data.dao.relational.postgresql.VersionPostgreSqlDAO;
import co.edu.uco.publiuco.utils.UtilSql;

public class PostgresSqlDaoFactory extends DAOFactory {

	private static Connection connection;
	private static String JDBCURL = "jdbc:postgresql://mahmud.db.elephantsql.com:5432/nfjaiiyr";
	private static String USERNAME = "nfjaiiyr";
	private static String PASSWORD = "hFdpP8B7-CxwFNh4IuZ3NXdqnJbegOcf";

	public PostgresSqlDaoFactory() {
		openConnection();
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
	public EstadoDAO getEstadoDAO() {
		return new EstadoPostgreSqlDAO(connection);
	}

	@Override
	public PreferenciaCategoriaDAO getPreferenciaCategoriaDAO() {
		return new PreferenciaCategoriaPostgreSqlDAO(connection);
	}

	@Override
	public TipoRelacionInstitucionDAO getTipoRelacionInstitucionDAO() {
		return new TipoRelacionInstitucionPostgreSqlDAO(connection);
	}

	@Override
	public AdministradorCategoriaDAO getAdministradorCategoriaDAO() {
		return new AdministradorCategoriaPostgreSqlDAO(connection);
	}

	@Override
	public CalificacionDAO getCalificacionDAO() {
		return new CalificacionPostgreSqlDAO(connection);
	}

	@Override
	public CategoriaAdministradorCategoriaDAO getCategoriaAdministradorCategoriaDAO() {
		return new CategoriaAdministradorCategoriaPostgreSqlDAO(connection);
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaPostgreSqlDAO(connection);
	}

	@Override
	public ComentarioLectorDAO getComentarioLectorDAO() {
		return new ComentarioLectorPostgreSqlDAO(connection);
	}

	@Override
	public ComentarioRevisorDAO getComentarioRevisorDAO() {
		return new ComentarioRevisorPostgreSqlDAO(connection);
	}

	@Override
	public EscritorDAO getEscritorDAO() {
		return new EscritorPostgreSqlDAO(connection);
	}

	@Override
	public EscritorPublicacionDAO getEscritorPublicacionDAO() {
		return new EscritorPublicacionPostgreSqlDAO(connection);
	}

	@Override
	public HistorialAccesoPublicacionDAO getHistorialAccesoPublicacionDAO() {
		return new HistorialAccesoPublicacionPostgreSqlDAO(connection);
	}

	@Override
	public LectorDAO getLectorDAO() {
		return new LectorPostgreSqlDAO(connection);
	}

	@Override
	public ObservacionRevisionDAO getObservacionRevisionDAO() {
		return new ObservacionRevisionPostgreSqlDAO(connection);
	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PaisPostgreSqlDAO(connection);
	}

	@Override
	public PalabraClavePublicacionDAO getPalabraClavePublicacionDAO() {
		return new PalabraClavePublicacionPostgreSqlDAO(connection);
	}

	@Override
	public PerfilDAO getPerfilDAO() {
		return new PerfilPostgreSqlDAO(connection);
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		return new PersonaPostgreSqlDAO(connection);
	}

	@Override
	public PlanCategoriaDAO getPlanCategoriaDAO() {
		return new PlanCategoriaPostgreSqlDAO(connection);
	}

	@Override
	public PlanPublicacionDAO getPlanPublicacionDAO() {
		return new PlanPublicacionPostgreSqlDAO(connection);
	}

	@Override
	public PreferenciaEscritorDAO getPreferenciaEscritorDAO() {
		return new PreferenciaEscritorPostgreSqlDAO(connection);
	}

	@Override
	public PublicacionDAO getPublicacionDAO() {
		return new PublicacionPostgreSqlDAO(connection);
	}

	@Override
	public ReporteDAO getReporteDAO() {
		return new ReportePostgreSqlDAO(connection);
	}

	@Override
	public RespuestaDAO getRespuestaDAO() {
		return new RespuestaPostgreSqlDAO(connection);
	}

	@Override
	public RevisionDAO getRevisionDAO() {
		return new RevisionPosgreSqlDAO(connection);
	}

	@Override
	public RevisorDAO getRevisorDAO() {
		return new RevisorPostgreSqlDAO(connection);
	}

	@Override
	public RevisorRevisionDAO getRevisorRevisionDAO() {
		return new RevisorRevisionPostgreSqlDAO(connection);
	}

	@Override
	public SuscripcionCategoriaDAO getuSuscripcionCategoriaDAO() {
		return new SuscripcionCategoriaPostgreSqlDAO(connection);
	}

	@Override
	public SuscripcionPublicacionDAO getSuscripcionPublicacionDAO() {
		return new SuscripcionPublicacionPostgreSqlDAO(connection);
	}

	@Override
	public TipoAccesoDAO getTipoAccesoDAO() {
		return new TipoAccesoPostgreSqlDAO(connection);
	}

	@Override
	public TipoComentarioRevisorDAO getTipoComentarioRevisorDAO() {
		return new TipoComentarioRevisorPostgreSqlDAO(connection);
	}

	@Override
	public TipoEscritorDAO getTipoEscritorDAO() {
		return new TipoEscritorPostgreSqlDAO(connection);
	}

	@Override
	public TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return new TipoIdentificacionPostgreSqlDAO(connection);
	}

	@Override
	public TipoReporteDAO getTipoReporteDAO() {
		return new TipoReportePostgreSqlDAO(connection);
	}

	@Override
	public TipoRevisionDAO getTipoRevisionDAO() {
		return new TipoRevisionPostgreSqlDAO(connection);
	}

	@Override
	public VersionDAO getVersionDAO() {
		return new VersionPostgreSqlDAO(connection);
	}

	public static void main(String[] args) {
		// UtilSql.openConnection(JDBCURL, USERNAME, PASSWORD);
		// UtilSql.closeConnection(connection);
		PostgresSqlDaoFactory intentoultimoomesuicido = new PostgresSqlDaoFactory();
		intentoultimoomesuicido.closeConnection();
	}
}
