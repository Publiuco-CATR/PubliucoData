package co.edu.uco.publiuco.data.dao.factory;

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
import co.edu.uco.publiuco.data.dao.factory.relational.postgresql.PostgresSqlDaoFactory;
import co.edu.uco.publiuco.data.dao.factory.relational.sqlserver.SqlServerDaoFactory;

public abstract class DAOFactory {
	
	public static DAOFactory getFactory(final Factory factory) {
		
		DAOFactory daoFactory;
		switch (factory) {			
			case SQLSERVER: {
				daoFactory = new SqlServerDaoFactory();
				break;
			}
			case POSTGRESQL: {
				daoFactory = new PostgresSqlDaoFactory();
				break;
			}
			default: {
				throw new IllegalArgumentException("Unexpected value: " + factory);
			}
		}
		
		return daoFactory;
	}
	
	protected abstract void openConnection();
	
	public abstract void closeConnection();
	
	public abstract void initTransaction();
	
	public abstract void commitTransaction();
	
	public abstract void rollbackTransaction();
	
	public abstract PreferenciaCategoriaDAO getPreferenciaCategoriaDAO();
	
	public abstract TipoRelacionInstitucionDAO getTipoRelacionInstitucionDAO();

	public abstract AdministradorCategoriaDAO getAdministradorCategoriaDAO();
	
	public abstract CalificacionDAO getCalificacionDAO();

	public abstract CategoriaAdministradorCategoriaDAO getCategoriaAdministradorCategoriaDAO();

	public abstract CategoriaDAO getCategoriaDAO();
	
	public abstract ComentarioLectorDAO getComentarioLectorDAO();
	
	public abstract ComentarioRevisorDAO getComentarioRevisorDAO();

	public abstract EscritorDAO getEscritorDAO();
	
	public abstract EscritorPublicacionDAO getEscritorPublicacionDAO();
	
	public abstract EstadoDAO getEstadoDAO();
	
	public abstract HistorialAccesoPublicacionDAO getHistorialAccesoPublicacionDAO();
	
	public abstract LectorDAO getLectorDAO();

	public abstract ObservacionRevisionDAO getObservacionRevisionDAO();
	
	public abstract PaisDAO getPaisDAO();
	
	public abstract PalabraClavePublicacionDAO getPalabraClavePublicacionDAO();
	
	public abstract PerfilDAO getPerfilDAO();

	public abstract PersonaDAO getPersonaDAO();
	
	public abstract PlanCategoriaDAO getPlanCategoriaDAO();
	
	public abstract PlanPublicacionDAO getPlanPublicacionDAO();
	
	public abstract PreferenciaEscritorDAO getPreferenciaEscritorDAO();
	
	public abstract PublicacionDAO getPublicacionDAO();
	
	public abstract ReporteDAO getReporteDAO();
	
	public abstract RespuestaDAO getRespuestaDAO();

	public abstract RevisionDAO getRevisionDAO();

	public abstract RevisorDAO getRevisorDAO();

	public abstract RevisorRevisionDAO getRevisorRevisionDAO();

	public abstract SuscripcionCategoriaDAO getuSuscripcionCategoriaDAO();

	public abstract SuscripcionPublicacionDAO getSuscripcionPublicacionDAO();

	public abstract TipoAccesoDAO getTipoAccesoDAO();
	
	public abstract TipoComentarioRevisorDAO getTipoComentarioRevisorDAO();

	public abstract TipoEscritorDAO getTipoEscritorDAO();

	public abstract TipoEstadoDAO getTipoEstadoDAO();

	public abstract TipoIdentificacionDAO getTipoIdentificacionDAO();

	public abstract TipoReporteDAO getTipoReporteDAO();

	public abstract TipoRevisionDAO getTipoRevisionDAO();

	public abstract VersionDAO getVersionDAO();
	
}
