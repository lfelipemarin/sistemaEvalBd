package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.*;
import java.util.ArrayList;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:02 p.m.
 */
public interface FacadeBancoPreguntas {

    /**
     *
     * @param contexto
     * @return
     */
    public Contexto buscarContexto(Contexto contexto);

    /**
     *
     * @param area
     */
    public void guardarAreaDeConocimiento(AreaDeConocimiento area);

    /**
     *
     * @param area
     * @param pregunta
     */
    public void guardarAreaDeConocimientoDePregunta(AreaDeConocimiento area, Pregunta pregunta);

    /**
     *
     * @param pregunta
     */
    public void guardarPregunta(Pregunta pregunta);

    public ArrayList<Pregunta> listarPreguntas();

}
