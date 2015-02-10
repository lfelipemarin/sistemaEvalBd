/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.sistemaevaluaciones.recursostecnicos.daos;

import co.edu.udea.sistemaevaluaciones.recursostecnicos.dbutil.ConexionDb;
import beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FelipeWin
 */
public class DAOGenericoOR {

//    public void getUsuario(Usuario u, String param, ConexionDb c) {
//
//        String sentencia = "SELECT * FROM usuario u WHERE codigo = ? OR "
//                + "nombre = ? OR apellido = ? OR rol = ?";
//
//        try {
//            PreparedStatement pstm = c.getConnection().prepareStatement(sentencia);
//            int numAtrib = 1;
//
//            if (u.getCodigo() != 0) {
//                pstm.setInt(numAtrib, u.getCodigo());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            if (u.getNombre() != null && !u.getNombre().equals("")) {
//                pstm.setString(numAtrib, u.getNombre());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            if (u.getApellido() != null && !u.getApellido().equals("")) {
//                pstm.setString(numAtrib, u.getApellido());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            if (u.getRol() != 0) {
//                pstm.setInt(numAtrib, u.getCodigo());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            System.out.println("consulta :" + pstm);
//            ResultSet res = pstm.executeQuery();
//            while (res.next()) {
//                System.out.println("Codigo: " + res.getString("codigo"));
//                System.out.println("Nombre: " + res.getString("nombre"));
//                System.out.println("Apelido: " + res.getString("apellido"));
//                System.out.println("Rol: " + res.getString("rol"));
//                System.out.println("Pass: " + res.getString("passwd"));
//            }
//            pstm.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
}
