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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dx
 */
public class DAOGenericoAND {

    public static final String OR_PARAM = "OR";
    public static final String AND_PARAM = "AND";

    public DAOGenericoAND() {
    }

    public void getUsuario(Usuario u, String param, ConexionDb c) {
        String sentencia = "SELECT * FROM usuario u WHERE";

        try {
            Connection conexion = c.getConnection();
            int numAtrib = 1;
            int cont = 0;

            if (u.getCodigo() != 0) {
                sentencia += " codigo = ? ";
                cont++;
            }

            if (u.getNombre() != null && !u.getNombre().equals("")) {
                if (cont > 0) {
                    sentencia += "AND nombre = ? ";
                } else {
                    sentencia += " nombre = ? ";
                    cont++;
                }
            }
            if (u.getApellido() != null && !u.getApellido().equals("")) {
                if (cont > 0) {
                    sentencia += "AND apellido = ? ";
                } else {
                    sentencia += " apellido = ? ";
                    cont++;
                }
            }
            if (u.getRol() != 0) {
                if (cont > 0) {
                    sentencia += "AND rol = ? ";
                } else {
                    sentencia += " rol = ? ";
                    cont++;
                }
            }

            PreparedStatement pstm = conexion.prepareStatement(sentencia);

            if (u.getCodigo() != 0) {
                pstm.setInt(numAtrib, u.getCodigo());
                numAtrib++;
            }

            if (u.getNombre() != null && !u.getNombre().equals("")) {
                pstm.setString(numAtrib, u.getNombre());
                numAtrib++;
            }
            if (u.getApellido() != null && !u.getApellido().equals("")) {
                pstm.setString(numAtrib, u.getApellido());
                numAtrib++;
            }
            if (u.getRol() != 0) {
                pstm.setInt(numAtrib, u.getRol());
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                System.out.println("Codigo: " + res.getString("codigo"));
                System.out.println("Nombre: " + res.getString("nombre"));
                System.out.println("Apelido: " + res.getString("apellido"));
                System.out.println("Rol: " + res.getString("rol"));
                System.out.println("Pass: " + res.getString("passwd"));
            }
            pstm.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) throws IOException {
        Usuario u = new Usuario();
        u.setCodigo(1);
        u.setNombre("mauricio");
//        u.setRol(1);
        DAOGenericoAND dao = new DAOGenericoAND();
        ConexionDb con = new ConexionDb();
        dao.getUsuario(u, null, con);

    }

}
