package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.*;
import java.util.ArrayList;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:07 p.m.
 */
public interface FacadeInformes {

    public ArrayList<Grupo> getGruposPorProfesor(Usuario usuario);

    public ArrayList<Evaluacion> getEvaluacionesPorGrupo(Grupo grupo);

    public ArrayList<Respuesta> getRespuestasPorEstudiantePorEvaluacion(Grupo grupo);

}
