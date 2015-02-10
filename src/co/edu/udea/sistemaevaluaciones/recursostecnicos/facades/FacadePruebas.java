package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.*;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOPruebaFinal;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOUsuarioFinal;
import java.util.ArrayList;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:04 p.m.
 */
public class FacadePruebas {

    /**
     *
     * @param evaluacion
     */
    public void guardarEvaluacion(Evaluacion evaluacion) {
        DAOPruebaFinal dAOPruebaFinal = new DAOPruebaFinal();
        dAOPruebaFinal.registrarEvaluacion(evaluacion);
    }

    public ArrayList<Evaluacion> listarEvaluacionesPorEstudiante(Usuario u) {
        DAOPruebaFinal dAOPruebaFinal = new DAOPruebaFinal();
        return dAOPruebaFinal.getEvaluacionesPorEstudiante(u);
    }

    public Usuario getEstudiante(Usuario u) {
        DAOUsuarioFinal dAOUsuarioFinal = new DAOUsuarioFinal();
        return dAOUsuarioFinal.getEstudiante(u);
    }

    public void setEvaluacion(Evaluacion e) {
        DAOPruebaFinal dAOPruebaFinal = new DAOPruebaFinal();
        dAOPruebaFinal.registrarEvaluacion(e);
    }

    public String getFechaServidor() {
        DAOPruebaFinal dAOPruebaFinal = new DAOPruebaFinal();
        return dAOPruebaFinal.getFechaServidor();
    }

    public ArrayList<Evaluacion> getPruebas(Usuario u) {
        DAOPruebaFinal dAOPruebaFinal = new DAOPruebaFinal();
        return dAOPruebaFinal.getEvaluacionesPorEstudiante(u);
    }

    public void setEstadoPrueba(boolean estado) {
    }

}
