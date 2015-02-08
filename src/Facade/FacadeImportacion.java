package Facade;

import beans.*;
import java.util.ArrayList;

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
     * @return
     */
    public ArrayList<Grupo> listarGruposAnd(Grupo grupo);

    /**
     *
     * @param grupo
     * @return 
     */
    public ArrayList<Grupo> listarGruposOr(Grupo grupo);

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
