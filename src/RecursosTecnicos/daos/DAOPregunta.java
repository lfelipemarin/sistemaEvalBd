package RecursosTecnicos.daos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import RecursosTecnicos.dbUtilConeccionDB.ConexionDb;
import java.sql.ResultSet;
import beans.*;
/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:57:56 p.m.
 */
public class DAOPregunta {

	public DAOPregunta(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param contexto
	 */
	public Contexto buscarContexto(Contexto contexto){
		return null;
	}

	/**
	 * 
	 * @param area
	 */
	public guardarAreaDeConocimiento(AreaDeConocimiento area){

	}

	/**
	 * 
	 * @param area
	 * @param pregunta
	 */
	public guardarAreaDeConocimientoDePregunta(AreaDeConocimiento area, Pregunta pregunta){

	}

	/**
	 * 
	 * @param pregunta
	 */
	public guardarPregunta(Pregunta pregunta){

	}

	public <Collection>Pregunta listarPreguntas(){
		return null;
	}

	/**
	 * 
	 * @param pregunta
	 */
	public <Collection>Pregunta listarPreguntasAnd(Pregunta pregunta){
		return null;
	}

	/**
	 * 
	 * @param pregunta
	 */
	public <Collection>Pregunta listarPreguntasOr(Pregunta pregunta){
		return null;
	}

}