/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.sistemaevaluaciones.recursostecnicos.daos;

import beans.Cuestionario;
import beans.Evaluacion;
import beans.Grupo;
import beans.Pregunta;
import beans.Prueba;
import beans.Respuesta;
import beans.Usuario;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.dbutil.ConexionDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dx
 */
public class DAOCompuestos {

    private final DAOGetId dAOGetId;

    public DAOCompuestos() {
        this.dAOGetId = new DAOGetId();
    }

    /**
     * PARA EL MODULO 2 DE CUESTIONARIOS CREAMOS UN METODO QUE PUEDEN NECESITAR
     * PARA DISPONER DE LAS PREGUNTAS PARA CREAR LOS CUESTIONARIOS:
     * ArrayList<Pregunta> listarPreguntas()
     */
    public ArrayList<Pregunta> listarPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList();
        String sentencia = "SELECT * FROM pregunta";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            System.out.println("consulta :" + pstm);
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                preguntas.add(dAOGetId.getPreguntaPorId(res.getInt("codigo")));
            }
            return preguntas;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * PARA EL MODULO 6 DE AUTENTICACION SE CREA EL METODO: Usuario
     * getUsuario(Usuario u)
     */
    public Usuario getUsuario(Usuario u) {
        return dAOGetId.getUsuarioPorId(u.getCodigo());
    }

    /**
     * PARCE TE HABLO DEL MODULO 3-PRUEBAS ESTOS SON LOS METODOS CON LOS QUE
     * ACCEDEMOS A LA BASE DE DATOS, IGUAL TE ADJUNTE LA CLASE SIMULADORINTERFAZ
     * QUE USAMOS EN EL PROYECTO Y TAMBIEN EL PROYECTO YA TERMINADO POR SI
     * CUALQUIER COSA
     *
     * https://github.com/joluditru/MOD03-Pruebas/tree/ultimo nota: en el branch
     * "ultimo"
     *
     * CUALQUIER COSA ME ESCRIBES POR ESTE MEDIO
     *
     * public static Estudiante getEstudiante() (HECHO)
     *
     * public static void setEvaluacion(Evaluacion eval) (HECHO)
     *
     * public static Date getFechaServidor() (HECHO)
     *
     * public static List<Prueba> getPruebas(Estudiante estudiante) (HECHO-> UN
     * ESTUDIANTE NO TIENE PRUEBAS, TIENE EVALUACIONES)
     *
     * public static void setEstadoPrueba(boolean estado) (que estados tiene una
     * prueba?)
     */
    public ArrayList<Evaluacion> getEvaluacionesPorEstudiante(Usuario u) {
        String sentencia = "SELECT * FROM evaluacion WHERE estudiante = ?";
        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, u.getCodigo());

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                evaluaciones.add(dAOGetId.getEvaluacionPorId(res.getInt("codigo")));
            }
            return evaluaciones;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public String getFechaServidor() {
        String sentencia = "SELECT NOW()";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            ResultSet res = pstm.executeQuery();
            res.first();
            return res.getString(1);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void registrarEvaluacion(Evaluacion e) {
        String sentencia = "INSERT INTO evaluacion values(?,?,?,?,?)";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            int numAtrib = 1;

            if (e.getCodigo() != 0) {
                pstm.setInt(numAtrib, e.getCodigo());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (e.getPrueba() != null) {
                pstm.setInt(numAtrib, e.getPrueba().getCodigo());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (e.getEstudiante() != null) {
                pstm.setInt(numAtrib, e.getEstudiante().getCodigo());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (e.getCalificacion() != 0) {
                pstm.setDouble(numAtrib, e.getCalificacion());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (e.getValorAprobacion() == 0) {
                pstm.setDouble(numAtrib, e.getValorAprobacion());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }
            System.out.println("consulta :" + pstm);
            pstm.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Usuario getEstudiante(Usuario u) {
        return dAOGetId.getUsuarioPorId(u.getCodigo());
    }

    /**
     * Buenas noches, del Modulo #2, Cuestionarios, Caso de Uso Programar
     * Cuestionarios hacemos uso de las siguientes consultas: 1.
     * Collection<MateriaXGrupoXProfesor> getGruposPorProfesor(Profesor
     * profesor): Dado un profesor, retorna una colección con todos los grupos
     * asociados a éste. (HECHO)
     *
     * 2. Collection<Cuestionario> getCuestionariosPorProfesor(Profesor
     * profesor): Dado un profesor, retorna una colección con todos los
     * cuestionarios creados por éste. (HECHO)
     *
     * 3. Boolean guardarPrueba(Prueba prueba): Dada prueba, la almacena en la
     * base de datos. (HECHO)
     */
    public void guardarPrueba(Prueba p) {
        String sentencia = "INSERT INTO prueba values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            int numAtrib = 1;

            if (p.getCodigo() != 0) {
                pstm.setInt(numAtrib, p.getCodigo());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (p.getFechaCreacion() != null) {
                pstm.setString(numAtrib, p.getFechaCreacion());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (p.getCuestionario() != null) {
                pstm.setInt(numAtrib, p.getCuestionario().getCodigo());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (p.getFechaAplicacion() != null) {
                pstm.setString(numAtrib, p.getFechaAplicacion());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (p.getDuracion() != 0) {
                pstm.setInt(numAtrib, p.getDuracion());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (p.getGrupo() != null) {
                pstm.setInt(numAtrib, p.getGrupo().getCodigo());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (p.getUsuarioProgramador() != null) {
                pstm.setInt(numAtrib, p.getUsuarioProgramador().getCodigo());
                numAtrib++;
            } else {
                pstm.setInt(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }
            System.out.println("consulta :" + pstm);
            pstm.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Cuestionario> getCuestionariosPorProfesor(Usuario u) {
        String sentencia = "SELECT * FROM cuestionario WHERE autor = ?";
        ArrayList<Cuestionario> cuestionarios = new ArrayList<>();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, u.getCodigo());

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                cuestionarios.add(dAOGetId.getCuestionarioPorId(res.getInt("codigo")));
            }
            return cuestionarios;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }


    /*
     hehco***** 1. getGruposPorProfesor(usuario): Recibe un objeto Usuario (en este caso con rol de profesor) y nos retorna una colección con todos los grupos pertenecientes a él (los que él esté dictando).

     hecho***** 2. getEvaluacionesPorGrupo(grupo): Recibe un objeto Grupo y retorna una colección con todas las evaluaciones que pertenezcan a este grupo.

     hehco***** 3. getRespuestasPorEstudiantePorEvaluacion(usuario, evaluación): Recibe un objeto Usuario (en este caso con rol de estudiante) y un objeto Evaluación y retorna una lista con los objetos "Respuesta" de ese usuario a esa evaluación.
     */
    public ArrayList<Respuesta> getRespuestasPorEstudiantePorEvaluacion(Usuario u, Evaluacion e) {
        String sentencia = "SELECT * FROM respuesta_estudiante WHERE evaluacion = ?";
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, e.getCodigo());

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                respuestas.add(dAOGetId.getRespuestaPorId(res.getInt("respuesta")));
            }
            return respuestas;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<Grupo> getGruposPorProfesor(Usuario u) {
        String sentencia = "SELECT * FROM grupo WHERE profesor = ?";
        ArrayList<Grupo> grupos = new ArrayList<>();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, u.getCodigo());

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                grupos.add(dAOGetId.getGrupoPorId(res.getInt("codigo")));
            }
            return grupos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<Evaluacion> getEvaluacionesPorGrupo(Grupo g) {
        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
        ArrayList<Prueba> pruebas = getPruebasPorGrupo(g);

        for (Prueba p : pruebas) {
            evaluaciones.addAll(getEvaluacionesPorPrueba(p));
        }
        return evaluaciones;
    }

    public ArrayList<Evaluacion> getEvaluacionesPorPrueba(Prueba p) {
        String sentencia = "SELECT * FROM evaluacion WHERE prueba = ?";
        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, p.getCodigo());

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                evaluaciones.add(dAOGetId.getEvaluacionPorId(res.getInt("codigo")));
            }
            return evaluaciones;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<Prueba> getPruebasPorGrupo(Grupo g) {
        ArrayList<Prueba> pruebas = new ArrayList<>();

        String sentencia = "SELECT * FROM prueba WHERE grupo = ?";

        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            pstm.setInt(1, g.getCodigo());
            System.out.println("consulta :" + pstm);
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                Prueba p = new Prueba();
                p.setCodigo(res.getInt("codigo"));
                p.setCuestionario(dAOGetId.getCuestionarioPorId(res.getInt("cuestionario")));
                p.setDuracion(res.getInt("duracion"));
                p.setFechaAplicacion(res.getString("fecha_aplicacion"));
                p.setFechaCreacion(res.getString("fecha_creacion"));
                p.setGrupo(dAOGetId.getGrupoPorId(res.getInt("grupo")));
                p.setUsuarioProgramador(dAOGetId.getUsuarioPorId(res.getInt("usuario_programador")));
                pruebas.add(p);
            }
            return pruebas;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
