package co.edu.uco.publiuco.data.dao.relational.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.data.dao.PublicacionDAO;
import co.edu.uco.publiuco.entities.PublicacionEntity;

public class PublicacionPostgreSqlDAO implements PublicacionDAO {

	public PublicacionPostgreSqlDAO(final Connection connection) {
		
	}
	
	@Override
	public void create(PublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PublicacionEntity> read(PublicacionEntity entity) {
		/*
		 * --SELECT p.identificador identificador, c.identificador identificadorcategoria, c.nombre nombrecategoria, ec.identificador idestcat, ec.nombre nomestcat, teec.identificador teidescat, teec.nombre tenomescat, p."fechaPublicacion" fechapublicacion, v.identificador identificadorversion, v.titulo titulo, v.resumen resumen, v.cuerpo cuerpo, ev.identificador idestv, ev.nombre nomestv, teev.identificador teidestv, teev.nombre tenomestv, e.identificador estadoidentificador, e.nombre estadonombre, tee.identificador teides, tee.nombre tenomes
		--FROM "Publicacion" p JOIN "Categoria" c ON c.identificador = p.categoria JOIN "Estado" ec ON ec.identificador = c.estado JOIN "TipoEstado" teec ON teec.identificador = ec."tipoEstado" JOIN "Version" v ON v.identificador = p."versionPublicada" JOIN "Estado" ev ON ev.identificador = v.estado JOIN "TipoEstado" teev ON teev.identificador = ev."tipoEstado" JOIN "Estado" e ON e.identificador = p.estado JOIN "TipoEstado" tee ON tee.identificador = e."tipoEstado"
		 * */
		return null;
	}

	@Override
	public void update(PublicacionEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID entityId) {
		// TODO Auto-generated method stub
		
	}
	
}