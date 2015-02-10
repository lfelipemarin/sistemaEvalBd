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
    
    
    /*
     1. getGruposPorProfesor(usuario): Recibe un objeto Usuario (en este caso con rol de profesor) y nos retorna una colección con todos los grupos pertenecientes a él (los que él esté dictando).

    hecho***** 2. getEvaluacionesPorGrupo(grupo): Recibe un objeto Grupo y retorna una colección con todas las evaluaciones que pertenezcan a este grupo.

     3. getRespuestasPorEstudiantePorEvaluacion(usuario, evaluación): Recibe un objeto Usuario (en este caso con rol de estudiante) y un objeto Evaluación y retorna una lista con los objetos "Respuesta" de ese usuario a esa evaluación.
     */

    public ArrayList<Evaluacion> getEvaluacionesPorGrupo(Grupo g) {
        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
        ArrayList<Prueba> pruebas = getPruebasPorGrupo(g);

        for (Prueba p : pruebas) {
            evaluaciones.addAll(getEvaluacionesPorPrueba(p));
        }
        return evaluaciones;
    }

    public ArrayList<Evaluacion> getEvaluacionesPorPrueba(Prueba p) {
        String sentencia = "SELECT * FROM evaluacion WHERE prueba = ?";
        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            pstm.setInt(1, p.getCodigo());

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                evaluaciones.add(getEvaluacionPorId(res.getInt("codigo")));
            }
            return evaluaciones;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<Prueba> getPruebasPorGrupo(Grupo g) {
        ArrayList<Prueba> pruebas = new ArrayList<>();

        String sentencia = "SELECT * FROM prueba WHERE grupo = ?";

        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);
            pstm.setInt(1, g.getCodigo());
            System.out.println("consulta :" + pstm);
            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                Prueba p = new Prueba();
                p.setCodigo(res.getInt("codigo"));
                p.setCuestionario(getCuestionarioPorId(res.getInt("cuestionario")));
                p.setDuracion(res.getInt("duracion"));
                p.setFechaAplicacion(res.getString("fecha_aplicacion"));
                p.setFechaCreacion(res.getString("fecha_creacion"));
                p.setGrupo(getGrupoPorId(res.getInt("grupo")));
                p.setUsuarioProgramador(getUsuarioPorId(res.getInt("usuario_programador")));
                pruebas.add(p);
            }
            return pruebas;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
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

    public ArrayList<Evaluacion> getEvaluaciones(Evaluacion e) {

        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();

        String sentencia = "SELECT eval.codigo AS evalcodigo, p.codigo AS pcodigo, "
                + "p.fecha_creacion AS pfecha_creacion, p.cuestionario AS "
                + "pcuestionario, p.fecha_aplicacion AS pfecha_aplicacion, "
                + "p.duracion AS pduracion, p.grupo AS pgrupo, "
                + "p.usuario_programador AS pusuario_programador, u.nombre AS "
                + "unombre, u.apellido AS uapellido, u.rol AS urol, u.passwd AS"
                + " upasswd, eval.calificacion AS evalcalifiacion, "
                + "eval.valor_aprobacion AS evalvalor_aprobacion FROM evaluacion"
                + " eval join prueba p on eval.prueba = p.codigo join usuario u on eval.estudiante = u.codigo";

        try {
            PreparedStatement pstm = ConexionDb.getInstancia().getConnection().prepareStatement(sentencia);

            System.out.println("consulta :" + pstm);

            ResultSet res = pstm.executeQuery();

            while (res.next()) {
                Evaluacion ee = new Evaluacion();
                ee.setCodigo(res.getInt("evalcodigo"));
                ee.setCalificacion(res.getInt("evalcalificacion"));
                ee.setValorAprobacion(res.getInt("evalvalor_aprobacion"));
                Prueba p = new Prueba();

                ee.setPrueba(null);
                evaluaciones.add(ee);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return evaluaciones;
    }



    /*
     metodo necesario para ejecutar getPruebasPorGrupo
     */
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

    /*
     metodo necesario para ejecutar getPruebasPorGrupo
     */
    public ArrayList<Grupo> getGruposOr(Grupo g) {
        return null;
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
