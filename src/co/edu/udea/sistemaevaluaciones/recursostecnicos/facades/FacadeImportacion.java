package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.*;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOPreguntaFinal;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOUsuarioFinal;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:05 p.m.
 */
public class FacadeImportacion {

    /**
     *
     * @param grupo
     */
    public void guardarGrupo(Grupo g) {
        DAOUsuarioFinal dAOUsuarioFinal = new DAOUsuarioFinal();
        dAOUsuarioFinal.registrarGrupo(g);
    }

    /**
     *
     * @param materia
     */
    public void guardarMateria(Materia m) {
        DAOPreguntaFinal dAOPreguntaFinal = new DAOPreguntaFinal();
        dAOPreguntaFinal.registrarMateria(m);
    }

    /**
     *
     * @param usuario
     */
    public void guardarUsuario(Usuario u) {
        DAOUsuarioFinal dAOUsuarioFinal = new DAOUsuarioFinal();
        dAOUsuarioFinal.registrarUsuario(u);
    }

    /**
     *
     * @param grupo
     * @param estudiante
     */
    public void registrarEstudianteGrupo(Grupo grupo, Usuario estudiante) {
        DAOUsuarioFinal dAOUsuarioFinal = new DAOUsuarioFinal();
        dAOUsuarioFinal.registrarEstudianteGrupo(estudiante, grupo);
    }

    /**
     *
     * @param grupo
     * @param profesor
     */
    public void registrarProfesorGrupo(Grupo grupo, Usuario profesor){
        guardarGrupo(grupo);
    }

}
