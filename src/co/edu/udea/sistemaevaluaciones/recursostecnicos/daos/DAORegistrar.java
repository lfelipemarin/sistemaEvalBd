/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.sistemaevaluaciones.recursostecnicos.daos;

import beans.AreaDeConocimiento;
import beans.Contexto;
import beans.Cuestionario;
import beans.Grupo;
import beans.Materia;
import beans.Pregunta;
import beans.Respuesta;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.dbutil.ConexionDb;
import java.sql.PreparedStatement;

/**
 *
 * @author dx
 */
public class DAORegistrar {
    
    public DAORegistrar(){
        
    }
    
        public void registrarAreaConocimiento(AreaDeConocimiento ac) {
        String sentencia = "INSERT INTO area_conocimiento values(?,?,?,?)";

        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (ac.getCodigo() != 0) {
                pstm.setInt(numAtrib, ac.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (ac.getNombre() != null) {
                pstm.setString(numAtrib, ac.getNombre());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (ac.getDescripcion() != null) {
                pstm.setString(numAtrib, ac.getDescripcion());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (ac.getAreaPadre() != null) {
                pstm.setInt(numAtrib, ac.getAreaPadre().getCodigo());
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

    public void registrarAreaConocimientoDePregunta(AreaDeConocimiento ac, Pregunta p) {
        String sentencia = "INSERT INTO area_conocimiento_x_pregunta values(?,?)";

        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (ac.getCodigo() != 0) {
                pstm.setInt(numAtrib, ac.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (p.getCodigo() != 0) {
                pstm.setString(numAtrib, ac.getNombre());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registrarPregunta(Pregunta p) {
        String sentencia = "INSERT INTO pregunta values(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (p.getCodigo() != 0) {
                pstm.setInt(numAtrib, p.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (p.getEnunciado() != null) {
                pstm.setString(numAtrib, p.getEnunciado());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (p.getTipoPregunta() != null) {
                pstm.setInt(numAtrib, p.getTipoPregunta().getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (p.getMateria().getCodigo() != 0) {
                pstm.setInt(numAtrib, p.getMateria().getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (p.isHabilitado() != false) {
                pstm.setBoolean(numAtrib, p.isHabilitado());
                numAtrib++;
            } else {
                pstm.setBoolean(numAtrib, false);
                numAtrib++;
            }

            if (p.getFechaCreacion() != null) {
                pstm.setString(numAtrib, p.getFechaCreacion());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (p.getContexto().getCodigo() != 0) {
                pstm.setInt(numAtrib, p.getContexto().getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (p.getAutor().getCodigo() != 0) {
                pstm.setInt(numAtrib, p.getAutor().getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (p.getGradoDificultad().getCodigo() != 0) {
                pstm.setInt(numAtrib, p.getGradoDificultad().getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (p.getImagen() != null) {
                pstm.setString(numAtrib, p.getImagen());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (p.getNivelEvaluativo() != null) {
                pstm.setString(numAtrib, p.getNivelEvaluativo().toString()); // Si es a String el campo en la DB es INT
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registrarRespuesta(Respuesta r) {
        String sentencia = "INSERT INTO respuesta values(?,?,?,?,?)";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (r.getCodigo() != 0) {
                pstm.setInt(numAtrib, r.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (r.getTexto() != null) {
                pstm.setString(numAtrib, r.getTexto());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (r.isCorrecta()) {
                pstm.setBoolean(numAtrib, r.isCorrecta());
                numAtrib++;
            } else {
                pstm.setBoolean(numAtrib, r.isCorrecta());
                numAtrib++;
            }

            if (r.getPregunta() != null) {
                pstm.setInt(numAtrib, r.getPregunta().getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (r.getImagen() != null) {
                pstm.setString(numAtrib, r.getImagen());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registrarContexto(Contexto c) {
        String sentencia = "INSERT INTO contexto values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (c.getCodigo() != 0) {
                pstm.setInt(numAtrib, c.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (c.getEnunciado() != null) {
                pstm.setString(numAtrib, c.getEnunciado());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (c.getImagen() != null) {
                pstm.setString(numAtrib, c.getImagen());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (c.getFechaCreacion() != null) {
                pstm.setString(numAtrib, c.getFechaCreacion());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (c.getAutor() != null) {
                pstm.setInt(numAtrib, c.getAutor().getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            if (c.getTitulo() != null) {
                pstm.setString(numAtrib, c.getTitulo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "");
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
        public void registrarGrupo(Grupo g){
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

    public void registrarMateria(Materia m) {
        String sentencia = "INSERT INTO materia values(?,?,?)";
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;
            if (m.getCodigo() != 0) {
                pstm.setInt(numAtrib, m.getCodigo());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (m.getNombre() != null) {
                pstm.setString(numAtrib, m.getNombre());
                numAtrib++;
            } else {
                pstm.setNull(numAtrib, java.sql.Types.NULL);
                numAtrib++;
            }

            if (m.getAreaConocimiento() != null) {
                pstm.setInt(numAtrib, m.getAreaConocimiento().getCodigo());
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

    
}