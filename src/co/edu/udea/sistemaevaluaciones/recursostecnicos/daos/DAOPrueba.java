package co.edu.udea.sistemaevaluaciones.recursostecnicos.daos;

import beans.*;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.dbutil.ConexionDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author FelipeWin
 * @version 1.0
 */
public class DAOPrueba {

    public DAOPrueba() {
    }

    public void registrarCuestionario(Cuestionario c) {
        String sentencia = "INSERT INTO cuestionario values(?,?,?,?,?)";

        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (c.getCodigo() != 0) {
                pstm.setInt(numAtrib, c.getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (c.getNombre() != null) {
                pstm.setString(numAtrib, c.getNombre());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (c.getNumeroPreguntas() != 0) {
                pstm.setInt(numAtrib, c.getNumeroPreguntas());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (c.getFechaCreacion() != null) {
                pstm.setString(numAtrib, c.getFechaCreacion());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (c.getAutor() != null) {
                pstm.setInt(numAtrib, c.getAutor().getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @param evaluacion
     * @return
     */
    public ArrayList<Evaluacion> getEvaluacionesAnd(Evaluacion evaluacion) {

        return null;
    }

    /**
     *
     * @param e
     */
    public void getEvaluacionesOr(Evaluacion e) {

        String sentencia = "SELECT * FROM evaluacion WHERE codigo = ? OR "
                + "prueba = ? OR estudiante = ? OR calificacion = ?";

        try {

            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (e.getCodigo() != 0) {
                pstm.setInt(numAtrib, e.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (e.getPrueba() != null) {
                pstm.setInt(numAtrib, e.getPrueba().getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (e.getEstudiante() != null) {
                pstm.setInt(numAtrib, e.getEstudiante().getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (e.getCalificacion() != 0.0) {
                pstm.setDouble(numAtrib, e.getCalificacion());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                System.out.println("Codigo: " + res.getString("codigo"));
                System.out.println("Prueba: " + res.getString("prueba"));
                System.out.println("Estudiante: " + res.getString("estudiante"));
                System.out.println("Califiacion: " + res.getString("calificacion"));
                System.out.println("Umbral: " + res.getString("valor_aprobacion"));
            }
            pstm.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    /**
     *
     * @param <Collection>
     * @return
     */
    public <Collection> Evaluacion getEvaluacionesPorMateria(Materia materia) {
        return null;
    }

    /**
     *
     * @param cuestionario
     */
    public void guardarCuestionario(Cuestionario cuestionario) {

    }

    /**
     *
     * @param evaluacion
     */
    public void guardarEvaluacion(Evaluacion evaluacion) {

    }

    /**
     *
     * @param prueba
     */
    public void guardarPrueba(Prueba prueba) {

    }

}
