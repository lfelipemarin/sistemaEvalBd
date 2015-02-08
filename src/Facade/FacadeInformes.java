package Facade;

import beans.*;
import java.util.ArrayList;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:07 p.m.
 */
public interface FacadeInformes {

    /**
     *
     * @param estudiante
     * @return 
     */
    public ArrayList<Usuario> getEstudiantesAnd(Usuario estudiante);

    /**
     *
     * @param estudiante
     * @return 
     */
    public ArrayList<Usuario> getEstudiantesOr(Usuario estudiante);

    /**
     *
     * @param evaluacion
     * @return 
     */
    public ArrayList<Evaluacion> getEvaluacionesAnd(Evaluacion evaluacion);

    /**
     *
     * @param evaluacion
     * @return 
     */
    public ArrayList<Evaluacion> getEvaluacionesOr(Evaluacion evaluacion);

    /**
     *
     * @param materia
     * @return 
     */
    public ArrayList<Evaluacion> getEvaluacionesPorMateria(Materia materia);

}
