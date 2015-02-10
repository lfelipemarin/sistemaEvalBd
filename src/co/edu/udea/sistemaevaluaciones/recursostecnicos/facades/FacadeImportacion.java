package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.*;

/**
 * @author FelipeWin
 * @version 1.0
 * @created 07-feb-2015 03:58:05 p.m.
 */
public interface FacadeImportacion {

    /**
     *
     * @param grupo
     */
    public void guardarGrupo(Grupo grupo);

    /**
     *
     * @param materia
     */
    public void guardarMateria(Materia materia);

    /**
     *
     * @param usuario
     */
    public void guardarUsuario(Usuario usuario);

    /**
     *
     * @param grupo
     * @param estudiante
     */
    public void registrarEstudianteGrupo (Grupo grupo, Usuario estudiante);

    /**
     *
     * @param grupo
     * @param profesor
     */
    public void registrarProfesorGrupo (Grupo grupo, Usuario profesor);

}
