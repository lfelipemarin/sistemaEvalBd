package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.*;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOPreguntaFinal;
import java.util.ArrayList;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:02 p.m.
 */
public class FacadeBancoPreguntas {

    /**
     *
     * @param area
     */
    public void guardarAreaDeConocimiento(AreaDeConocimiento area) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        dAOPreguntaFinal.registrarAreaConocimiento(area);
    }

    /**
     *
     * @param area
     * @param pregunta
     */
    public void guardarAreaDeConocimientoDePregunta(AreaDeConocimiento area, Pregunta pregunta) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        dAOPreguntaFinal.registrarAreaConocimientoDePregunta(area, pregunta);
    }

    /**
     *
     * @param pregunta
     */
    public void guardarPregunta(Pregunta pregunta) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        dAOPreguntaFinal.registrarPregunta(pregunta);

    }

    public ArrayList<Pregunta> listarPreguntas() {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        return dAOPreguntaFinal.listarPreguntas();
    }

    public void guardarRespuesta(Respuesta r) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        dAOPreguntaFinal.registrarRespuesta(r);
    }

}
