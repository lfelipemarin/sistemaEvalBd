package co.edu.udea.sistemaevaluaciones.recursostecnicos.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.dbutil.ConexionDb;
import java.sql.ResultSet;
import beans.*;

/**
 * @author FelipeWin
 * @version 1.0
 */
public class DAOPreguntaMauro {

    public DAOPreguntaMauro() {

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

            if (p.getTipo() != 0) {
                pstm.setInt(numAtrib, p.getTipo());
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
            
            if (p.isHabilitado() != false ) {
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
             
            if (p.getAutor().getCodigo()!= 0) {
                pstm.setInt(numAtrib, p.getAutor().getCodigo());
                numAtrib++;
            } else {
                  pstm.setString(numAtrib, "");
                numAtrib++;
            }
               
            if (p.getGradoDificultad().getCodigo()!= 0) {
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
              
            if (p.getNivelEvaluativo()!= null) {
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

    /**
     *
     * @param c
     * @return
     */
    public Contexto buscarContextoOR(Contexto c) {
        String sentencia = "SELECT * FROM contexto c WHERE codigo = ? OR "
                + "enunciado LIKE ? OR imagen = ? OR fecha_creacion = ? OR autor = ? OR titulo = ?";

        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (c.getCodigo() != 0) {
                pstm.setInt(numAtrib, c.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (c.getEnunciado() != null) {
                pstm.setString(numAtrib, c.getEnunciado());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (c.getImagen() != null) {
                pstm.setString(numAtrib, c.getImagen());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (c.getFechaCreacion() != null) {
                pstm.setString(numAtrib, c.getFechaCreacion());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (c.getAutor() != null) {
                pstm.setInt(numAtrib, c.getAutor().getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (c.getTitulo() != null) {
                pstm.setString(numAtrib, c.getTitulo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            System.out.println("consulta :" + pstm);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                System.out.println("Codigo: " + res.getString("codigo"));
                System.out.println("enunciado: " + res.getString("enunciado"));
                System.out.println("fecha Creacion: " + res.getString("fecha_creacion"));
                System.out.println("autor: " + res.getString("autor"));
                System.out.println("titulo: " + res.getString("titulo"));

            }
            pstm.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

//	/**
//	 * 
//	 * @param area
//	 */
//    public void guardarAreaDeConocimiento(AreaDeConocimiento area, ConexionDb conn) {
//        String sentencia = "INSERT INTO `area_conocimiento` (`codigo`, `nombre`, `descripcion`, `area_padre` ) VALUES (?,?,?,?)";
//        int cod_area = area.getCodigo();
//        String nombre = area.getNombre();
//        String descripcion = area.getDescripcion();
//        int area_padre = area.getAreaPadre();
//        try {
//
//            PreparedStatement pstm = conn.getConnection().prepareStatement(sentencia);
//
//            pstm.setInt(1, cod_area);
//            pstm.setString(2, nombre);
//            pstm.setString(3, descripcion);
//            pstm.setInt(4, area_padre);
//
//            System.out.println("consulta :" + pstm);
//            pstm.execute();
//            pstm.close();
//            System.out.println("error2 :" + pstm);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//    }
//
//    /**
//     *
//     * @param area
//     * @param pregunta
//     * @param conn
//     */
//    public void guardarAreaDeConocimientoDePregunta(AreaDeConocimiento area, Pregunta pregunta, ConexionDb conn) {
//        String sentencia = "INSERT INTO `area_conocimiento_x_pregunta` (`area_conocimiento`, `pregunta`) VALUES (?,?)";
//        int cod_area = area.getCodigo();
//        int cod_pregunta = pregunta.getCodigo();
//        try {
//
//            PreparedStatement pstm = conn.getConnection().prepareStatement(sentencia);
//
//            pstm.setInt(1, cod_area);
//            pstm.setInt(2, cod_pregunta);
//
//            System.out.println("consulta :" + pstm);
//            pstm.execute();
//            pstm.close();
//            System.out.println("error2 :" + pstm);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//    }
//
//	/**
//	 * 
//	 * @param pregunta
//	 */

//    public void guardarPregunta(Pregunta p, ConexionDb conn) {
//        p.setCodigo(10);
//        p.setEnunciado("El enunciado 3");
//        p.setTipo(1);
//        p.setMateria(1);
//        p.setHabilitado(true);
//        p.setFechaCreacion("2015-10-25");
//        p.setContexto(1);
//        p.setAutor(1055831540);
//        p.setGradoDificultad(1);
//        p.setImagen(null);
//        p.setNivelEvaluativo(1);
//
//        int codigo = p.getCodigo();
//        String enunciado = p.getEnunciado();
//        int tipo = p.getTipo();
//        int materia = p.getMateria();
//        boolean habilitado = p.isHabilitado();
//        Date fecha_creacion = p.getFecha_creacion();
//        int contexto = p.getContexto();
//        int autor = p.getAutor();
//        int grado_dificultad = p.getGradoDificultad();
//        String imagen = p.getImagen();
//        int nivel_evaluativo = p.getNivelEvaluativo();
//
//        String sentencia = "INSERT INTO `pregunta` (`codigo`, `enunciado`, `tipo`, `materia`, `habilitado`, `fecha_creacion`, `contexto`, `autor`, `grado_dificultad`, `imagen`, `nivel_evaluativo`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//
//        try {
//
//            PreparedStatement pstm = conn.getConnection().prepareStatement(sentencia);
//
//            pstm.setInt(1, codigo);
//            pstm.setString(2, enunciado);
//            pstm.setInt(3, tipo);
//            pstm.setInt(4, materia);
//            pstm.setBoolean(5, habilitado);
//            pstm.setDate(6, (java.sql.Date) fecha_creacion);
//            pstm.setInt(7, contexto);
//            pstm.setInt(8, autor);
//            pstm.setInt(9, grado_dificultad);
//            pstm.setString(10, imagen);
//            pstm.setInt(11, nivel_evaluativo);
//
//            System.out.println("consulta :" + pstm);
//            pstm.execute();
//            pstm.close();
//            System.out.println("error2 :" + pstm);
//         }catch(SQLException e){
//         System.out.println(e);
//      }
//   }
//    public ArrayList<AreaDeConocimiento> listarAreaDeConocimientos(AreaDeConocimiento a, ConexionDb c) {
//
//        String sentencia = "SELECT * FROM area_conocimiento a";
//        AreaDeConocimiento areasRetorno;
//        ArrayList<AreaDeConocimiento> arregloAreas = new ArrayList<>();
//        try {
//            PreparedStatement pstm = c.getConnection().prepareStatement(sentencia);
//            int numAtrib = 1;
//
//            System.out.println("consulta :" + pstm);
//            ResultSet res = pstm.executeQuery();
//            while (res.next()) {
//                areasRetorno = new AreaDeConocimiento();
//
//                areasRetorno.setCodigo(res.getInt("codigo"));
//                areasRetorno.setNombre(res.getString("nombre"));
//                areasRetorno.setDescripcion(res.getString("descripcion"));
//                areasRetorno.setAreaPadre(res.getInt("area_padre"));
//
//                arregloAreas.add(areasRetorno);
//                //Prueba de impresion en consola............
//                System.out.println("codigo: " + res.getInt("codigo"));
//                System.out.println("nombre: " + res.getString("nombre"));
//                System.out.println("Descripcio: " + res.getString("descripcion"));
//                System.out.println("Area padre: " + res.getInt("area_padre"));
//            }
//            pstm.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return arregloAreas;
//    }

//	public <Collection>Pregunta listarPreguntas(){
//		return null;
//	}
//
//	/**
//	 * 
//	 * @param pregunta
//	 */
//	public <Collection>Pregunta listarPreguntasAnd(Pregunta pregunta){
//		return null;
//	}
    /**
     *
     * @param p
     * @param param
     * @param c
     * @return
     */
//    public ArrayList<Pregunta> listarPreguntasOr(Pregunta p, String param, ConexionDb c) {
//
//        String sentencia = "SELECT * FROM pregunta p WHERE fecha_creacion = ? OR "
//                + "tipo = ? OR contexto = ? OR grado_dificultad = ? OR habilitado = ?";
//        //En el modulo 1 segun el prototipo tambien pueden buscar por area del conocimiento 
//        //por lo que se pide un segundo parametro que sea area de conocimiento
//        Pregunta preguntaRetorno;
//        ArrayList<Pregunta> arregloPreguntas = new ArrayList<>();
//        try {
//            PreparedStatement pstm = c.getConnection().prepareStatement(sentencia);
//            int numAtrib = 1;
//
//            if (p.getFechaCreacion() != null) {
//                pstm.setDate(numAtrib, p.getFechaCreacion());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");  //al ser fecha no se puede convertira Date a sTRING
//                numAtrib++;
//            }
//
//            if (p.getTipo() != 0) {
//                pstm.setInt(numAtrib, p.getTipo());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            if (p.getContexto() != 0) {
//                pstm.setInt(numAtrib, p.getContexto());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            if (p.getGradoDificultad() != 0) {
//                pstm.setInt(numAtrib, p.getGradoDificultad());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            if (p.isHabilitado() != false) {
//                pstm.setInt(numAtrib, p.getGradoDificultad());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            System.out.println("consulta :" + pstm);
//            ResultSet res = pstm.executeQuery();
//            while (res.next()) {
//                preguntaRetorno = new Pregunta();
//                preguntaRetorno.setFecha_creacion(res.getDate("fecha_creacion"));
//                preguntaRetorno.setTipo(res.getInt("tipo"));
//                preguntaRetorno.setContexto(res.getInt("contexto"));
//                preguntaRetorno.setEnunciado(res.getString("enunciado"));
//                preguntaRetorno.setGradoDificultad(res.getInt("grado_dificultad"));
//                preguntaRetorno.setHabilitado(res.getBoolean("habilitado"));
//
//                arregloPreguntas.add(preguntaRetorno);
//                //Prueba de impresion en consola............
//                System.out.println("fecha de creacion: " + res.getString("fecha_creacion"));
//                System.out.println("Tipo: " + res.getString("tipo"));
//                System.out.println("Contexto: " + res.getString("contexto"));
//                System.out.println("Enunciado: " + res.getString("enunciado"));
//                System.out.println("Grado de Dificultad: " + res.getString("grado_dificultad"));
//                System.out.println("Estado: " + res.getString("habilitado"));
//            }
//            pstm.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return arregloPreguntas;
//    }
}
