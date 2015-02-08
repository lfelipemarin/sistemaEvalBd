/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursosTecnicos.daos;

import RecursosTecnicos.dbUtilConeccionDB.ConexionDb;
import beans.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author FelipeWin
 */
public class DAOMestraFelipe {

    public void getUsuario(Usuario u, String param, ConexionDb c) {
        String sentencia = "SELECT * FROM usuario u WHERE codigo = ? AND "
                + "nombre = ? AND apellido = ? AND rol = ?";

        try {
            PreparedStatement pstm = c.getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (u.getCodigo() != 0) {
                pstm.setInt(numAtrib, u.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
            }

            if (u.getNombre() != null && !u.getNombre().equals("")) {
                pstm.setString(numAtrib, u.getNombre());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (u.getApellido() != null && !u.getApellido().equals("")) {
                pstm.setString(numAtrib, u.getApellido());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (u.getRol() != 0) {
                pstm.setInt(numAtrib, u.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) throws IOException {
        Usuario u = new Usuario();
        u.setCodigo(2);
        DAOMestraFelipe dao = new DAOMestraFelipe();
        ConexionDb con = new ConexionDb();
        dao.getUsuario(u, null, con);

    }
}
