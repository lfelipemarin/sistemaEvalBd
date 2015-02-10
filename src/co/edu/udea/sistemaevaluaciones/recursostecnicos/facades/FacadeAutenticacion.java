/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.sistemaevaluaciones.recursostecnicos.facades;

import beans.Usuario;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOUsuarioFinal;

/**
 *
 * @author FelipeWin
 */
public class FacadeAutenticacion {

    public FacadeAutenticacion() {

    }

    public Usuario getUsuario(Usuario usuario) {
        DAOUsuarioFinal dAOUsuarioFinal = new DAOUsuarioFinal();
        return dAOUsuarioFinal.getUsuario(usuario);

    }
}
