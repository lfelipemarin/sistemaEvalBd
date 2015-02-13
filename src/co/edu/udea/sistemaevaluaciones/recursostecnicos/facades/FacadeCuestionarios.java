package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.*;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOPreguntaFinal;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOPruebaFinal;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOUsuarioFinal;
import java.util.ArrayList;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:03 p.m.
 */
public class FacadeCuestionarios {

    public FacadeCuestionarios() {

    }

    public ArrayList<CuestionarioVariacion> listarVariaciones(Cuestionario c) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        return dAOPreguntaFinal.getVariacionesCuestionario(c);
    }

    public void actualizarCuestionario(Cuestionario c) {
        //no implementado aún; que parametros necesitan modificar?
    }

    public void guardarPreguntaCuestionario(PreguntaPorCuestionario pc) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        dAOPreguntaFinal.registrarPreguntaPorCuestionario(pc);
    }

    public void guardarVariacionCuestionario(CuestionarioVariacion cv) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        dAOPreguntaFinal.registrarCuestionarioVariacion(cv);
    }

    public CuestionarioVariacion getUltimaVariacionCuestionario(Cuestionario c) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        return dAOPreguntaFinal.getUltimaVariacionCuestionario(c);
    }

    /**
     *
     * @param cuestionario
     */
    public void guardarCuestionario(Cuestionario cuestionario) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        dAOPreguntaFinal.registrarCuestionario(cuestionario);
    }

    /**
     *
     * @param prueba
     */
    public void guardarPrueba(Prueba prueba) {
        DAOPruebaFinal dAOPruebaFinal = new DAOPruebaFinal();
        dAOPruebaFinal.guardarPrueba(prueba);
    }

    /**
     *
     * @param pregunta
     * @return
     */
    public ArrayList<Pregunta> listarPreguntas(Pregunta pregunta) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        return dAOPreguntaFinal.listarPreguntas();
    }

    public ArrayList<Cuestionario> getCuestionariosPorProfesor(Usuario u) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        return dAOPreguntaFinal.getCuestionariosPorProfesor(u);
    }

    public ArrayList<Grupo> getGruposPorProfesor(Usuario u) {
        DAOUsuarioFinal dAOUsuarioFinal = new DAOUsuarioFinal();
        return dAOUsuarioFinal.getGruposPorProfesor(u);
    }
}
