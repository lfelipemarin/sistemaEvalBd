/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaEvaluaciones;

import RecursosTecnicos.daos.DAOGenerico;
import RecursosTecnicos.dbUtilConeccionDB.ConexionDb;
import beans.Usuario;
import java.io.IOException;

/**
 *
 * @author dx
 */
public class Sigeon {

    public static void main(String[] args) throws IOException {
        ConexionDb conecta = new ConexionDb();
        DAOGenerico daoGen = new DAOGenerico();
        Usuario u = new Usuario();
        u.setCodigo(123456);
        u.setNombre("username1");
        u.setApellido("userlastname1");
        u.setRol(1);
        daoGen.getUsuario(u, DAOGenerico.OR_PARAM, conecta.getConnection());

    }

}
