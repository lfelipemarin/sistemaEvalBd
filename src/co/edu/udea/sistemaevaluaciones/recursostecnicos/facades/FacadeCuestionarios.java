package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.*;
import java.util.ArrayList;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:03 p.m.
 */
public interface FacadeCuestionarios {

    /**
     *
     * @param cuestionario
     */
    public void guardarCuestionario(Cuestionario cuestionario);

    /**
     *
     * @param prueba
     */
    public void guardarPrueba(Prueba prueba);

    /**
     *
     * @param pregunta
     * @return
     */
    public ArrayList<Pregunta> listarPreguntasAnd(Pregunta pregunta);

    /**
     *
     * @param pregunta
     * @return
     */
    public ArrayList<Pregunta> listarPreguntasOr(Pregunta pregunta);

}
