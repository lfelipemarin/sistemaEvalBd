package RecursosTecnicos.daos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import RecursosTecnicos.dbUtilConeccionDB.ConexionDb;
import java.sql.ResultSet;
import beans.*;
/**
 * @author FelipeWin
 * @version 1.0
 */
public class DAOUsuario {

	public DAOUsuario(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param estudiante
	 */
	public <Collection>Usuario getEstudianteAnd(Usuario estudiante){
		return null;
	}

	/**
	 * 
	 * @param estudiante
	 */
	public <Collection>Usuario getEstudiantesOr(Usuario estudiante){
		return null;
	}

	/**
	 * 
	 * @param usuario
	 */
	public Usuario getUsuarioAnd(Usuario usuario){
		return null;
	}

	/**
	 * 
	 * @param grupo
	 */
//	public guardarGrupo(Grupo grupo){
//
//	}

	/**
	 * 
	 * @param materia
	 */
//	public guardarMateria(Materia materia){
//
//	}

	/**
	 * 
	 * @param usuario
	 */
//	public guardarUsuario(Usuario usuario){
//
//	}

	/**
	 * 
	 * @param grupo
	 */
	public <Collection>Grupo listarGruposAnd(Grupo grupo){
		return null;
	}

	/**
	 * 
	 * @param grupo
	 */
	public <Collection>Grupo listarGruposOr(Grupo grupo){
		return null;
	}

	/**
	 * 
	 * @param estudiante
	 * @param grupo
	 */
//	public registrarEstudianteGrupo(Usuario estudiante, Grupo grupo){
//
//	}

	/**
	 * 
	 * @param profesor
	 * @param grupo
	 */
//	public registrarProfesorGrupo(Usuario profesor, Grupo grupo){
//
//	}

}