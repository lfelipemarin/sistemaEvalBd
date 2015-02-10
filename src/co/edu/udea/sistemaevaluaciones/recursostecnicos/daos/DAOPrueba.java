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

    /**
     * LOS METODOS FUERON SACADOS Y ORGANIZADOS TEMPORALMENTE EN REGISTRAR, GETID O COMPUESTO
     */
    public DAOPrueba() {
    }   

    public ArrayList<Cuestionario> getCuestionarioOr(Cuestionario c) {
        ArrayList<Cuestionario> cuestionarios = new ArrayList<>();
        String sentencia = "SELECT * FROM cuestionario WHERE codigo = ? OR "
                + "autor = ?";

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

            if (c.getAutor() != null) {
                pstm.setInt(numAtrib, c.getAutor().getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                Cuestionario cc = new Cuestionario();
                Usuario u = new Usuario();
                u.setCodigo(res.getInt("autor"));
                cc.setAutor(getUsuarioOr(u).get(0));
                cc.setCodigo(res.getInt("codigo"));
                cc.setFechaCreacion(res.getString("fecha_creacion"));
                cc.setNombre(res.getString("nombre"));
                cc.setNumeroPreguntas(res.getInt("numero_preguntas"));
                cuestionarios.add(cc);
            }
            pstm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cuestionarios;
    }

    public ArrayList<Usuario> getUsuarioOr(Usuario u) {
        String sentencia = "SELECT u.codigo AS ucodigo, u.nombre AS unombre, "
                + "u.apellido AS uapellido, u.passwd AS upasswd, r.codigo AS"
                + " rcodigo, r.nombre AS rnombre FROM usuario u join rol r on u.rol = r.codigo WHERE u.codigo = ?";
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {

            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, u.getCodigo());

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                Usuario uu = new Usuario();
                uu.setCodigo(res.getInt("ucodigo"));
                uu.setNombre(res.getString("unombre"));
                uu.setApellido(res.getString("uapellido"));
                uu.setPassword(res.getString("upasswd"));
                Rol r = new Rol();
                r.setCodigo(res.getInt("rcodigo"));
                r.setNombre(res.getString("rnombre"));
                uu.setRol(r);
                usuarios.add(uu);
            }
            pstm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuarios;

    }

    private ArrayList<Rol> getRolOr(Rol r) {
        String sentencia = "SELECT * FROM rol WHERE codigo = ?";
        ArrayList<Rol> roles = new ArrayList<>();

//        try {
//            
//            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
//            
//            int numAtrib = 1;
//            
//            if (u.getCodigo() != 0) {
//                pstm.setInt(numAtrib, u.getCodigo());
//                numAtrib++;
//            } else {
//                pstm.setNull(numAtrib, java.sql.Types.NULL);
//                numAtrib++;
//            }
//            
//            if (u.getRol() != null) {
//                pstm.setInt(numAtrib, u.getRol().getCodigo());
//                numAtrib++;
//            } else {
//                pstm.setNull(numAtrib, java.sql.Types.NULL);
//                numAtrib++;
//            }
//            
//            System.out.println("consulta :" + pstm);
//            
//            ResultSet res = pstm.executeQuery();
//            
//            while (res.next()) {
//                Usuario uu = new Usuario();
//                uu.setCodigo(res.getInt("codigo"));
//                uu.setNombre(res.getString("nombre"));
//                uu.setApellido(res.getString("apellido"));
//                uu.setPassword(res.getString("passwd"));
//                Rol r = new Rol();
//                r.setCodigo(res.getInt("rol"));
//                uu.setRol(getRolOr(r));
//                usuarios.add(uu);
//            }
//            pstm.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        return roles;
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
}
