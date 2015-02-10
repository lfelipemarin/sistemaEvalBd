/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.sistemaevaluaciones.recursostecnicos.daos;

import beans.AreaDeConocimiento;
import beans.Contexto;
import beans.Cuestionario;
import beans.Evaluacion;
import beans.GradoDeDificultad;
import beans.Grupo;
import beans.Materia;
import beans.NivelEvaluativo;
import beans.Pregunta;
import beans.Prueba;
import beans.Respuesta;
import beans.Rol;
import beans.TipoPregunta;
import beans.Usuario;
import co.edu.udea.sistemaevaluaciones.recursostecnicos.dbUtil.ConexionDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dx
 */
public class DAOGetId {
    
    public DAOGetId(){
        
    }
    
    public Evaluacion getEvaluacionPorId(int id) {
        String sentencia = "SELECT * FROM evaluacion WHERE codigo = ?";
        Evaluacion e = new Evaluacion();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                e.setCalificacion(res.getInt("calificacion"));
                e.setCodigo(res.getInt("codigo"));
                e.setEstudiante(getUsuarioPorId(res.getInt("estudiante")));
                e.setPrueba(getPruebaPorId(res.getInt("prueba")));
                e.setValorAprobacion(res.getInt("valor_aprobacion"));
            }
            return e;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public Prueba getPruebaPorId(int id) {
        String sentencia = "SELECT * FROM prueba WHERE codigo = ?";
        Prueba p = new Prueba();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                p.setCodigo(res.getInt("codigo"));
                p.setCuestionario(getCuestionarioPorId(res.getInt("cuestionario")));
                p.setDuracion(res.getInt("duracion"));
                p.setFechaAplicacion(res.getString("fecha_aplicacion"));
                p.setFechaCreacion(res.getString("fecha_creacion"));
                p.setGrupo(getGrupoPorId(res.getInt("grupo")));
                p.setUsuarioProgramador(getUsuarioPorId(res.getInt("usuario_programador")));
            }
            return p;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Cuestionario getCuestionarioPorId(int id) {
        String sentencia = "SELECT * FROM cuestionario WHERE codigo = ?";
        Cuestionario c = new Cuestionario();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                c.setAutor(getUsuarioPorId(res.getInt("autor")));
                c.setCodigo(res.getInt("codigo"));
                c.setFechaCreacion(res.getString("fecha_creacion"));
                c.setNombre(res.getString("nombre"));
                c.setNumeroPreguntas(res.getInt("numero_preguntas"));
            }
            return c;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Grupo getGrupoPorId(int id) {
        String sentencia = "SELECT * FROM grupo WHERE codigo = ?";
        Grupo g = new Grupo();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                g.setCodigo(res.getInt("codigo"));
                g.setMateria(getMateriaPorId(res.getInt("materia")));
                g.setProfesor(getUsuarioPorId(res.getInt("profesor")));
                g.setSemestre(res.getString("semestre"));
            }
            return g;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Respuesta getRespuestaPorId(int id) {
        String sentencia = "SELECT * FROM respuesta WHERE codigo = ?";
        Respuesta r = new Respuesta();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                r.setCodigo(res.getInt("codigo"));
                r.setCorrecta(res.getBoolean("correcta"));
                r.setImagen(res.getString("imagen"));
                r.setPregunta(getPreguntaPorId(res.getInt("codigo_pregunta")));
                r.setTexto(res.getString("texto"));
            }
            return r;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Pregunta getPreguntaPorId(int id) {
        String sentencia = "SELECT * FROM pregunta WHERE codigo = ?";
        Pregunta p = new Pregunta();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                p.setAutor(getUsuarioPorId(res.getInt("autor")));
                p.setCodigo(res.getInt("codigo"));
                p.setContexto(getContextoPorId(res.getInt("contexto")));
                p.setEnunciado(res.getString("enunciado"));
                p.setFechaCreacion(res.getString("fecha_creacion"));
                p.setGradoDificultad(getGradoDeDificultadPorId(res.getInt("grado_dificultad")));
                p.setHabilitado(res.getBoolean("habilitado"));
                p.setImagen(res.getString("imagen"));
                p.setNivelEvaluativo(getNivelEvaluativoPorId(res.getInt("nivel_evaluativo")));
                p.setTipoPregunta(getTipoPreguntaPorId(res.getInt("tipo")));
            }
            return p;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Materia getMateriaPorId(int id) {
        String sentencia = "SELECT * FROM materia WHERE codigo = ?";
        Materia m = new Materia();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                m.setCodigo(res.getInt("codigo"));
                m.setNombre(res.getString("nombre"));
                m.setAreaConocimiento(getAreaDeConocimientoPorId(res.getInt("area_conocimiento")));
            }
            return m;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public AreaDeConocimiento getAreaDeConocimientoPorId(int id) {
        String sentencia = "SELECT * FROM area_conocimiento WHERE codigo = ?";
        AreaDeConocimiento ac = new AreaDeConocimiento();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                ac.setCodigo(res.getInt("codigo"));
                ac.setNombre(res.getString("nombre"));
                ac.setNombre(res.getString("descripcion"));
            }
            return ac;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Contexto getContextoPorId(int id) {
        String sentencia = "SELECT * FROM contexto WHERE codigo = ?";
        Contexto c = new Contexto();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                c.setAutor(getUsuarioPorId(res.getInt("autor")));
                c.setCodigo(res.getInt("codigo"));
                c.setEnunciado(res.getString("enunciado"));
                c.setFechaCreacion(res.getString("fecha_creacion"));
                c.setImagen(res.getString("imagen"));
                c.setTitulo(res.getString("titulo"));
            }
            return c;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public NivelEvaluativo getNivelEvaluativoPorId(int id) {
        String sentencia = "SELECT * FROM nivel_evaluativo WHERE codigo = ?";
        NivelEvaluativo ne = new NivelEvaluativo();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                ne.setCodigo(res.getInt("codigo"));
                ne.setNombre(res.getString("nombre"));
                ne.setDescripcion(res.getString("decripcion"));
            }
            return ne;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public GradoDeDificultad getGradoDeDificultadPorId(int id) {
        String sentencia = "SELECT * FROM grado_dificultad WHERE codigo = ?";
        GradoDeDificultad gd = new GradoDeDificultad();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                gd.setCodigo(res.getInt("codigo"));
                gd.setDescripcion(res.getString("descripcion"));
                gd.setNombre(res.getString("nombre"));
            }
            return gd;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public TipoPregunta getTipoPreguntaPorId(int id) {
        String sentencia = "SELECT * FROM tipo_pregunta WHERE codigo = ?";
        TipoPregunta tp = new TipoPregunta();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                tp.setCodigo(res.getInt("codigo"));
                tp.setTipo(res.getString("tipo"));
            }
            return tp;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Rol getRolPorId(int id) {
        String sentencia = "SELECT * FROM rol WHERE codigo = ?";
        Rol rol = new Rol();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                rol.setCodigo(res.getInt("codigo"));
                rol.setNombre(res.getString("nombre"));
            }
            return rol;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public Usuario getUsuarioPorId(int id) {
        String sentencia = "SELECT * FROM usuario WHERE codigo = ?";
        Usuario u = new Usuario();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, id);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                u.setCodigo(res.getInt("codigo"));
                u.setNombre(res.getString("nombre"));
                u.setApellido(res.getString("apellido"));
                u.setPassword(res.getString("passwd"));
                u.setRol(getRolPorId(res.getInt("rol")));
            }
            return u;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
}
