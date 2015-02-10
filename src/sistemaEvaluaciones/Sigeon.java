/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaEvaluaciones;

import beans.Evaluacion;
import beans.Grupo;
import beans.Usuario;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.extras.DAOPrueba;
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
//        Usuario profe = new Usuario();
//        profe.setCodigo(1);
//        Contexto c = new Contexto();
////        c.setAutor(profe);
////        c.setCodigo(2);
//        c.setEnunciado("dos");
////        c.setFechaCreacion("2014-01-01 00:00:00");
////        c.setImagen("");
////        c.setTitulo("titulo dos");
//        DAOPreguntaMauro daopm = new DAOPreguntaMauro();
////        daopm.registrarContexto(c);
//        daopm.buscarContextoOR(c);
//        Respuesta r = new Respuesta();
//        r.setCodigo(1);
//        r.setCorrecta(true);
//        r.setImagen(null);
//        Pregunta p = new Pregunta();
//        p.setCodigo(1);
//        r.setPregunta(p);
//        r.setTexto("texto rta 1 preg 1");
//        AreaDeConocimiento ac = new AreaDeConocimiento();
//        AreaDeConocimiento ac1 = new AreaDeConocimiento();
//        ac1.setCodigo(1);
//        ac.setCodigo(3);
//        ac.setDescripcion("desc ac tres");
//        ac.setNombre("nom ac tres");
////        ac.setAreaPadre(ac1);
//        DAOPreguntaMauro daopm = new DAOPreguntaMauro();
//        daopm.registrarAreaConocimiento(ac);
//        Cuestionario c = new Cuestionario();
//        Usuario u = new Usuario();
//        u.setCodigo(1);
//        c.setAutor(u);
//        c.setCodigo(2);
//        c.setFechaCreacion("2014-01-01 00:00:00");
//        c.setNombre("nom cues dos");
//        c.setNumeroPreguntas(1);
//        DAOPrueba daop = new DAOPrueba();
//        daop.registrarCuestionario(c);
//        Usuario u = new Usuario();
//        u.setCodigo(1);
//        DAOPrueba daop = new DAOPrueba();
//        daop.getUsuarioOr(u);
        DAOPrueba daop = new DAOPrueba();
        Grupo g = new Grupo();
        g.setCodigo(1);
        Usuario u = new Usuario();
        u.setCodigo(3);
        Evaluacion e = new Evaluacion();
        e.setCodigo(1);
//        daop.getRespuestasPorEstudiantePorEvaluacion(null, e);

    }

}
