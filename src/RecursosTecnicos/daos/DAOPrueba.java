package RecursosTecnicos.daos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import RecursosTecnicos.dbUtilConeccionDB.ConexionDb;
import java.sql.ResultSet;
import beans.*;
/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:57:59 p.m.
 */
public class DAOPrueba {

	public DAOPrueba(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param evaluacion
	 */
	public <Collection>Evaluacion getEvaluacionesAnd(Evaluacion evaluacion){
		return null;
	}

	/**
	 * 
	 * @param evaluacion
	 */
	public <Collection>Evaluacion getEvaluacionesOr(Evaluacion evaluacion){
		return null;
	}

	/**
	 * 
	 * @param materia
	 */
	public <Collection>Evaluacion getEvaluacionesPorMateria(Materia materia){
		return null;
	}

	/**
	 * 
	 * @param cuestionario
	 */
	public guardarCuestionario(Cuestionario cuestionario){

	}

	/**
	 * 
	 * @param evaluacion
	 */
	public guardarEvaluacion(Evaluacion evaluacion){

	}

	/**
	 * 
	 * @param prueba
	 */
	public guardarPrueba(Prueba prueba){

	}

}