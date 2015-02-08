/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursosTecnicos.daos;

import beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dx
 */
public class DAOGenerico {

    public static final String OR_PARAM = "OR";
    public static final String AND_PARAM = "AND";

    public DAOGenerico() {
    }

    public void getUsuario(Usuario u, String param, Connection c) {
        String sentencia = "SELECT * FROM usuario u WHERE ";

        try {
            Connection conexion = c;
            PreparedStatement pstm = conexion.prepareStatement(sentencia);
            int numAtrib = 1;

            if (u.getCodigo() != 0) {
                sentencia += " codigo = ? ";
                pstm.setInt(numAtrib, u.getCodigo());
                numAtrib++;
            }

            if (!u.getNombre().equals("") && u.getNombre() != null) {
                sentencia += "AND nombre = ? ";
                pstm.setString(numAtrib, u.getNombre());
                numAtrib++;
            }
            if (!u.getApellido().equals("") && u.getApellido() != null) {
                sentencia += "AND apellido = ? ";
                pstm.setString(numAtrib, u.getApellido());
                numAtrib++;
            }
            if (u.getRol() != 0) {
                sentencia += "AND rol = ? ";
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
