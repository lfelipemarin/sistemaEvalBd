package co.edu.udea.sistemaevaluaciones.recursostecnicos.daos.extras;

import co.edu.udea.sistemaevaluaciones.recursostecnicos.dbUtil.ConexionDb;
import java.sql.ResultSet;
import beans.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUsuario {
//
//    public static final String OR_PARAM = "OR";
//    public static final String AND_PARAM = "AND";
//
//    public DAOUsuario() {
//
//    }
//
//    public void finalize() throws Throwable {
//
//    }
//
//    //public Object [][] getEstudianteAnd(ConexionDb conn, Usuario usuario){
//    public ArrayList<Usuario> getEstudianteAnd(Usuario u, String param, ConexionDb c) {
//        String sentencia = "SELECT * FROM usuario u WHERE";
//        Usuario usuarioRetorno;
//        ArrayList<Usuario> arregloUsuarios = new ArrayList<>();
//        try {
//            Connection conexion = c.getConnection();
//            int numAtrib = 1;
//            int cont = 0;
//            if (u.getCodigo() != 0) {
//                sentencia += " codigo = ? ";
//                cont++;
//            }
//            if (u.getNombre() != null && !u.getNombre().equals("")) {
//                if (cont > 0) {
//                    sentencia += "AND nombre = ? ";
//                } else {
//                    sentencia += " nombre = ? ";
//                    cont++;
//                }
//            }
//            if (u.getApellido() != null && !u.getApellido().equals("")) {
//                if (cont > 0) {
//                    sentencia += "AND apellido = ? ";
//                } else {
//                    sentencia += " apellido = ? ";
//                    cont++;
//                }
//            }
//            if (u.getRol() != 0) {
//                if (cont > 0) {
//                    sentencia += "AND rol = ? ";
//                } else {
//                    sentencia += " rol = ? ";
//                    cont++;
//                }
//            }
//            PreparedStatement pstm = conexion.prepareStatement(sentencia);
//            if (u.getCodigo() != 0) {
//                pstm.setInt(numAtrib, u.getCodigo());
//                numAtrib++;
//            }
//            if (u.getNombre() != null && !u.getNombre().equals("")) {
//                pstm.setString(numAtrib, u.getNombre());
//                numAtrib++;
//            }
//            if (u.getApellido() != null && !u.getApellido().equals("")) {
//                pstm.setString(numAtrib, u.getApellido());
//                numAtrib++;
//            }
//            if (u.getRol() != 0) {
//                pstm.setInt(numAtrib, u.getRol());
//                numAtrib++;
//            }
//            System.out.println("consulta :" + pstm);
//            ResultSet res = pstm.executeQuery();
//            while (res.next()) {
//                usuarioRetorno = new Usuario();
//
//                usuarioRetorno.setCodigo(res.getInt("codigo"));
//                usuarioRetorno.setNombre(res.getString("nombre"));
//                usuarioRetorno.setApellido(res.getString("apellido"));
//                usuarioRetorno.setRol(res.getInt("rol"));
//                usuarioRetorno.setPassword(res.getString("passwd"));
//
//                arregloUsuarios.add(usuarioRetorno);
//
//                System.out.println("Codigo: " + res.getString("codigo"));
//                System.out.println("Nombre: " + res.getString("nombre"));
//                System.out.println("Apelido: " + res.getString("apellido"));
//                System.out.println("Rol: " + res.getString("rol"));
//                System.out.println("Pass: " + res.getString("passwd"));
//            }
//            pstm.close();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return arregloUsuarios;
//    }
////	public <Collection>Usuario getEstudiantesOr(Usuario estudiante){
////		return null;
////	}
//
//    public ArrayList<Usuario> getEstudiantesOr(Usuario u, String param, ConexionDb c) {
//        String sentencia = "SELECT * FROM usuario u WHERE codigo = ? OR "
//                + "nombre = ? OR apellido = ? OR rol = ?";
//        Usuario usuarioRetorno;
//        ArrayList<Usuario> arregloUsuarios = new ArrayList<>();
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
//                usuarioRetorno = new Usuario();
//
//                usuarioRetorno.setCodigo(res.getInt("codigo"));
//                usuarioRetorno.setNombre(res.getString("nombre"));
//                usuarioRetorno.setApellido(res.getString("apellido"));
//                usuarioRetorno.setRol(res.getInt("rol"));
//                usuarioRetorno.setPassword(res.getString("passwd"));
//
//                arregloUsuarios.add(usuarioRetorno);
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
//        return arregloUsuarios;
//    }
//
////	public Usuario getUsuarioAnd(Usuario usuario){
////		return null;
////	}
//    public void getUsuarioAnd(Usuario u, String param, ConexionDb c) {
//        String sentencia = "SELECT * FROM usuario u WHERE";
//
//        try {
//            Connection conexion = c.getConnection();
//            int numAtrib = 1;
//            int cont = 0;
//            if (u.getCodigo() != 0) {
//                sentencia += " codigo = ? ";
//                cont++;
//            }
//            if (u.getNombre() != null && !u.getNombre().equals("")) {
//                if (cont > 0) {
//                    sentencia += "AND nombre = ? ";
//                } else {
//                    sentencia += " nombre = ? ";
//                    cont++;
//                }
//            }
//            if (u.getApellido() != null && !u.getApellido().equals("")) {
//                if (cont > 0) {
//                    sentencia += "AND apellido = ? ";
//                } else {
//                    sentencia += " apellido = ? ";
//                    cont++;
//                }
//            }
//            if (u.getRol() != 0) {
//                if (cont > 0) {
//                    sentencia += "AND rol = ? ";
//                } else {
//                    sentencia += " rol = ? ";
//                    cont++;
//                }
//            }
//            PreparedStatement pstm = conexion.prepareStatement(sentencia);
//            if (u.getCodigo() != 0) {
//                pstm.setInt(numAtrib, u.getCodigo());
//                numAtrib++;
//            }
//            if (u.getNombre() != null && !u.getNombre().equals("")) {
//                pstm.setString(numAtrib, u.getNombre());
//                numAtrib++;
//            }
//            if (u.getApellido() != null && !u.getApellido().equals("")) {
//                pstm.setString(numAtrib, u.getApellido());
//                numAtrib++;
//            }
//            if (u.getRol() != 0) {
//                pstm.setInt(numAtrib, u.getRol());
//                numAtrib++;
//            }
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
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    public void guardarGrupo(ConexionDb conn, Grupo grupo) {
//
//        int codigo = grupo.getCodigo();
//        int materia = grupo.getMateria();
//        String semestre = grupo.getSemestre();
//        int profesor = grupo.getProfesor();
//
//        System.out.println("grupo a insertar : " + codigo + "-" + materia + "-" + semestre + "-" + profesor);
//
//        try {
//
//            PreparedStatement pstm = conn.getConnection().prepareStatement("insert into " + "grupo(codigo, materia, semestre, profesor) " + " values(?,?,?,?)");
//
//            pstm.setInt(1, codigo);
//            pstm.setInt(2, materia);
//            pstm.setString(3, semestre);
//            pstm.setInt(4, profesor);
//
//            System.out.println("consulta :" + pstm);
//            pstm.execute();
//            pstm.close();
//            System.out.println("error2 :" + pstm);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    /**
//     *
//     * @param conn
//     * @param materia
//     */
////	public guardarMateria(Materia materia){
////
////	}
//    public void guardarMateria(ConexionDb conn, Materia materia) {
//
//        int codigo = materia.getCodigo();
//        String nombre = materia.getNombre();
//        int areaConocimiento = materia.getArea_conocimiento();
//
//        System.out.println("grupo a insertar : " + codigo + "-" + nombre + "-" + areaConocimiento);
//
//        try {
//
//            PreparedStatement pstm = conn.getConnection().prepareStatement("insert into " + "materia(codigo, nombre, area_conocimiento) " + " values(?,?,?)");
//
//            pstm.setInt(1, codigo);
//            pstm.setString(2, nombre);
//            pstm.setInt(3, areaConocimiento);
//
//            System.out.println("consulta :" + pstm);
//            pstm.execute();
//            pstm.close();
//            System.out.println("error2 :" + pstm);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public void guardarUsuario(ConexionDb conn, Usuario usuario) {
//
//        int codigo = usuario.getCodigo();
//        String nombre = usuario.getNombre();
//        String apellido = usuario.getApellido();
//        int rol = usuario.getRol();
//        String password = usuario.getPassword();
//
//        System.out.println("xxxxxxxxxxxxxxxx codigo: " + codigo);
//
//        try {
//
//            PreparedStatement pstm = conn.getConnection().prepareStatement("insert into " + "usuario(codigo, nombre, apellido, rol, passwd) " + " values(?,?,?,?,?)");
//
//            pstm.setInt(1, codigo);
//            pstm.setString(2, nombre);
//            pstm.setString(3, apellido);
//            pstm.setInt(4, rol);
//            pstm.setString(5, password);
//            System.out.println("consulta :" + pstm);
//            pstm.execute();
//            pstm.close();
//            System.out.println("error2 :" + pstm);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
////	public <Collection>Grupo listarGruposAnd(Grupo grupo){
////		return null;
////	}
//    public void listarGruposAnd(Grupo u, String param, ConexionDb c) {
//        String sentencia = "SELECT * FROM grupo u WHERE";
//        try {
//            Connection conexion = c.getConnection();
//            int numAtrib = 1;
//            int cont = 0;
//            if (u.getCodigo() != 0) {
//                sentencia += " codigo = ? ";
//                cont++;
//            }
//            if (u.getMateria() != 0) {
//                sentencia += " materia = ? ";
//                cont++;
//            }
//            if (u.getSemestre() != null && !u.getSemestre().equals("")) {
//                if (cont > 0) {
//                    sentencia += "AND semestre = ? ";
//                } else {
//                    sentencia += " semestre = ? ";
//                    cont++;
//                }
//            }
//            if (u.getProfesor() != 0) {
//                if (cont > 0) {
//                    sentencia += "AND profesor = ? ";
//                } else {
//                    sentencia += " profesor = ? ";
//                    cont++;
//                }
//            }
//            PreparedStatement pstm = conexion.prepareStatement(sentencia);
//            if (u.getCodigo() != 0) {
//                pstm.setInt(numAtrib, u.getCodigo());
//                numAtrib++;
//            }
//            if (u.getMateria() != 0) {
//                pstm.setInt(numAtrib, u.getMateria());
//                numAtrib++;
//            }
//            if (u.getSemestre() != null && !u.getSemestre().equals("")) {
//                pstm.setString(numAtrib, u.getSemestre());
//                numAtrib++;
//            }
//            if (u.getProfesor() != 0) {
//                pstm.setInt(numAtrib, u.getProfesor());
//                numAtrib++;
//            }
//            System.out.println("consulta :" + pstm);
//            ResultSet res = pstm.executeQuery();
//            while (res.next()) {
//                System.out.println("Codigo: " + res.getString("codigo"));
//                System.out.println("Materia: " + res.getString("materia"));
//                System.out.println("Semestre: " + res.getString("semestre"));
//                System.out.println("Profesor: " + res.getString("profesor"));
//
//            }
//            pstm.close();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
////	public <Collection>Grupo listarGruposOr(Grupo grupo){
////		return null;
////	}
//    public void listarGruposOr(Grupo u, String param, ConexionDb c) {
//        String sentencia = "SELECT * FROM grupo u WHERE codigo = ? OR "
//                + "materia = ? OR semestre = ? OR profesor = ?";
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
//            if (u.getMateria() != 0) {
//                pstm.setInt(numAtrib, u.getMateria());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            if (u.getSemestre() != null && !u.getSemestre().equals("")) {
//                pstm.setString(numAtrib, u.getSemestre());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
//
//            if (u.getProfesor() != 0) {
//                pstm.setInt(numAtrib, u.getProfesor());
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
//                System.out.println("materia: " + res.getString("materia"));
//                System.out.println("semestre: " + res.getString("semestre"));
//                System.out.println("profesor: " + res.getString("profesor"));
//
//            }
//            pstm.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
////	public registrarEstudianteGrupo(Usuario estudiante, Grupo grupo){
////
////	}
//
//    public void registrarEstudianteGrupo(ConexionDb conn, Usuario usuario, Grupo grupo, int codigo) {
//
//        int codigoUsuarioGrupo = codigo;
//        int codigoUsuario = usuario.getCodigo();
//        int codigoGrupo = grupo.getCodigo();
//
//        System.out.println("codigo estudiante: " + codigo + " " + "codigo grupo: " + codigoGrupo + " " + codigoUsuario);
//
//        try {
//
//            PreparedStatement pstm = conn.getConnection().prepareStatement("insert into " + "estudiante_x_grupo(codigo, estudiante, grupo) " + " values(?,?,?)");
//
//            pstm.setInt(1, codigo);
//            pstm.setInt(2, codigoUsuarioGrupo);
//            pstm.setInt(3, codigoGrupo);
//
//            System.out.println("consulta :" + pstm);
//            pstm.execute();
//            pstm.close();
//            System.out.println("error2 :" + pstm);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
////	
//    //prueba insertgar grupo
////  public static void main(String[] args) throws IOException {        
//// 
////        Grupo grupo = new Grupo();
////        grupo.setCodigo(1);
////        grupo.setMateria(1);
////        grupo.setSemestre("primero");
////        grupo.setProfesor(1);
////        
////        System.out.println("holla llegue a insertar grupo");
////        ConexionDb conn;
////        conn = new ConexionDb();
////        System.out.println("creada la coneccion");
////        
////  
////        DAOUsuario odaousuario = new DAOUsuario();
////        odaousuario.guardarGrupo(conn, grupo);
////                
////    }
//             //prueba insertgar materia
////  public static void main(String[] args) throws IOException {        
////        Materia materi = new Materia();
////        
////        materi.setCodigo(2);
////        materi.setNombre("estadistica");
////        materi.setArea_conocimiento(1);
////      
////        
////        System.out.println("holla llegue a insertar materia");
////        ConexionDb conn;
////        conn = new ConexionDb();
////        System.out.println("creada la coneccion");
////        
////  
////        DAOUsuario odaousuario = new DAOUsuario();
////        odaousuario.guardarMateria(conn, materi);
////                
////    }
////prueba insertgar usuario
//////  public static void main(String[] args) {        
//////        
//////        Usuario usu = new Usuario();
//////        usu.setApellido("agudelo");
//////        usu.setNombre("edwin");
//////        usu.setCodigo(1);
//////        usu.setPassword("12345");
//////        usu.setRol(2);
//////        System.out.println("holla llegue");
//////        conectate conn;
//////        conn = new ConexionDb();
//////        System.out.println("creada la coneccion");
//////        //DAOUsuario.insertarUsuario(con, usu);
//////  
//////        daoMuestraNoBorarra odaousuario = new daoMuestraNoBorarra();
//////        odaousuario.insertarUsuario(conn, usu);
/////        
////prueba insertgar usuario
////  public static void main(String[] args) throws IOException {        
////        
////        Usuario usu = new Usuario();
////        usu.setApellido("agudelo");
////        usu.setNombre("edwin");
////        usu.setCodigo(4);
////        usu.setPassword("12345");
////        usu.setRol(2);
////        System.out.println("holla llegue");
////        ConexionDb conn;
////        conn = new ConexionDb();
////        System.out.println("creada la coneccion");
////        //DAOUsuario.insertarUsuario(con, usu);
////  
////        DAOUsuario odaousuario = new DAOUsuario();
////        odaousuario.guardarUsuario(conn, usu);
////  }
////prueba listar grupos and
////public static void main(String[] args) throws IOException {
////        Grupo u = new Grupo();
////        //u.setCodigo(1);
////        u.setMateria(1);
////        
////        DAOUsuario dao = new DAOUsuario();
////        ConexionDb con = new ConexionDb();
////        dao.listarGruposAnd(u, null, con);
////    }
////prueba listar grupoOr
////    public static void main(String[] args) throws IOException {
////        
////        Grupo grupo = new Grupo();
////        
////        grupo.setMateria(1);
////        
////        DAOUsuario dao = new DAOUsuario();
////        ConexionDb con = new ConexionDb();
////        dao.listarGruposOr(grupo, null, con);
////
////    }
//    //insertar registrarEstudianteGrupo
////    public static void main(String[] args) throws IOException {
////        Usuario usuario = new Usuario();
////        Grupo grupo = new Grupo();
////        int codigo = 3;
////        
////        grupo.setCodigo(1);
////        usuario.setCodigo(1);
////        
////        
////        DAOUsuario dao = new DAOUsuario();
////        ConexionDb con = new ConexionDb();
////        dao.registrarEstudianteGrupo(con, usuario, grupo, codigo);
////
////    }      
//    //prueba registrarProfesorGrupo
////    public static void main(String[] args) throws IOException{
////    Grupo grupo = new Grupo();
////    Usuario usuario = new Usuario();
////    grupo.setCodigo(1);
////    usuario.setCodigo(2);
////    ConexionDb conn = new ConexionDb();
////    DAOUsuario odaousuario = new DAOUsuario();
//    odaousuario.registrarProfesorGrupo(conn,usuario,grupo);}
}
