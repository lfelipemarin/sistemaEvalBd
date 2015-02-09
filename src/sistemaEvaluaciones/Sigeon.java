/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaEvaluaciones;

import beans.AreaDeConocimiento;
import beans.Contexto;
import beans.Evaluacion;
import beans.Pregunta;
import beans.Prueba;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOGenericoAND;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.dbutil.ConexionDb;
import beans.Usuario;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOPreguntaMauro;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOPrueba;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.DAOUsuario;
import java.io.IOException;

/**
 *
 * @author dx
 */
public class Sigeon {

    public static void main(String[] args) throws IOException {
//        ConexionDb conecta = new ConexionDb();
//        DAOGenericoAND daoGen = new DAOGenericoAND();
//        Usuario u = new Usuario();
//        u.setCodigo(123456);
//        u.setNombre("username1");
//        u.setApellido("userlastname1");
//        u.setRol(1);
//        daoGen.getUsuario(u, DAOGenericoAND.OR_PARAM, (ConexionDb) conecta.getConnection());

        //        Usuario u = new Usuario();
//        //u.setCodigo(2);
//        u.setNombre("mauricio");
//        DAOGenericoOR dao = new DAOGenericoOR();
//        ConexionDb con = ConexionDb.getInstancia();
//        dao.getUsuario(u, null, con);
//        Usuario u = new Usuario();
////        u.setCodigo(2);
////        u.setNombre("mauricio");
//        u.setRol(1);
////        DAOGenericoAND dao = new DAOGenericoAND();
//        DAOUsuario us = new DAOUsuario();
//        ConexionDb con = new ConexionDb();
//        us.getEstudianteAnd(u, null, con);
////        dao.getUsuario(u, null, con);
        
//                Pregunta p = new Pregunta();
//        Contexto c = new Contexto();
//        AreaDeConocimiento a = new AreaDeConocimiento();
//        p.setCodigo(10);
//        a.setCodigo(1);
//        c.setCodigo(1);
//        DAOPreguntaMauro dao = new DAOPreguntaMauro();
//        ConexionDb con = new ConexionDb();
//        dao.buscarContexto(c, con);

        
//                Usuario u = new Usuario();
////        u.setCodigo(1);
////        u.setNombre("edwin");
//        u.setRol(1);
//        DAOUsuario dao = new DAOUsuario();
//        ConexionDb con = new ConexionDb();
//        dao.getEstudianteAnd(u, null, con);
        
//        Usuario estudiante = new Usuario();
//        estudiante.setCodigo(2);
//        Prueba prueba = new Prueba();
//        prueba.setCodigo(1);
//        Evaluacion e = new Evaluacion();
//        e.setCodigo(1);
//        e.setEstudiante(estudiante);
//        e.setPrueba(prueba);
//        DAOPrueba x = new DAOPrueba();
//        x.getEvaluacionesOr(e);
        
        Usuario profe = new Usuario();
        profe.setCodigo(1);
        Contexto c = new Contexto();
        c.setAutor(profe);
        c.setCodigo(2);
        c.setEnunciado("enun dos");
        c.setFechaCreacion("2014-01-01 00:00:00");
        c.setImagen("");
        c.setTitulo("titulo dos");
        DAOPreguntaMauro daopm = new DAOPreguntaMauro();
        daopm.registrarContexto(c);
        

    }

}
