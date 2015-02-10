package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.*;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOPruebaFinal;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOUsuarioFinal;
import java.util.ArrayList;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:07 p.m.
 */
public class FacadeInformes {

    public ArrayList<Grupo> getGruposPorProfesor(Usuario usuario) {
        DAOUsuarioFinal dAOUsuarioFinal = new DAOUsuarioFinal();
        return dAOUsuarioFinal.getGruposPorProfesor(usuario);
    }

    public ArrayList<Evaluacion> getEvaluacionesPorGrupo(Grupo grupo) {
        DAOPruebaFinal dAOPruebaFinal = new DAOPruebaFinal();
        return dAOPruebaFinal.getEvaluacionesPorGrupo(grupo);
    }

    public ArrayList<Evaluacion> getEvaluacionesPorEstudiante(Usuario u) {
        DAOPruebaFinal dAOPruebaFinal = new DAOPruebaFinal();
        return dAOPruebaFinal.getEvaluacionesPorEstudiante(u);
    }

    public ArrayList<Respuesta> getRespuestasPorEstudiantePorEvaluacion(Usuario u, Evaluacion e) {
        DAOPruebaFinal dAOPruebaFinal = new DAOPruebaFinal();
        return dAOPruebaFinal.getRespuestasPorEstudiantePorEvaluacion(u, e);
    }

}
