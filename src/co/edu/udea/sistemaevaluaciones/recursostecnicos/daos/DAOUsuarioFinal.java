/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.sistemaevaluaciones.recursostecnicos.daos;

import beans.Grupo;
import beans.Usuario;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.dbUtil.ConexionDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dx
 */
public class DAOUsuarioFinal {

    private DAOGetId dAOGetId;

    public DAOUsuarioFinal() {
        this.dAOGetId = new DAOGetId();
    }

    public void registrarEstudianteGrupo(Usuario u, Grupo g) {
        String sentencia = "INSERT INTO estudiante_x_grupo values(?,?,?)";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;
            if (u.getCodigo() != 0 && g.getCodigo() != 0) {
                pstm.setInt(numAtrib, u.getCodigo() + g.getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (u.getCodigo() != 0) {
                pstm.setInt(numAtrib, u.getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (g.getCodigo() != 0) {
                pstm.setInt(numAtrib, g.getCodigo());
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

    public void registrarUsuario(Usuario u) {
        String sentencia = "INSERT INTO usuario values(?,?,?,?,?)";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;
            if (u.getCodigo() != 0) {
                pstm.setInt(numAtrib, u.getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (u.getNombre() != null) {
                pstm.setString(numAtrib, u.getNombre());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (u.getApellido() != null) {
                pstm.setString(numAtrib, u.getApellido());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (u.getRol() != null) {
                pstm.setInt(numAtrib, u.getRol().getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (u.getPassword() != null) {
                pstm.setString(numAtrib, u.getPassword());
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
     * PARA EL MODULO 6 DE AUTENTICACION SE CREA EL METODO: Usuario
     * getUsuario(Usuario u)
     */
    public Usuario getUsuario(Usuario u) {
        return dAOGetId.getUsuarioPorId(u.getCodigo());
    }

    public Usuario getEstudiante(Usuario u) {
        return dAOGetId.getUsuarioPorId(u.getCodigo());
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

    public void registrarGrupo(Grupo g) {
        String sentencia = "INSERT INTO grupo values(?,?,?,?)";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;
            if (g.getCodigo() != 0) {
                pstm.setInt(numAtrib, g.getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (g.getMateria() != null) {
                pstm.setInt(numAtrib, g.getMateria().getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (g.getSemestre() != null) {
                pstm.setString(numAtrib, g.getSemestre());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (g.getProfesor() != null) {
                pstm.setInt(numAtrib, g.getProfesor().getCodigo());
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

}
