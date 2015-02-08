/*
 * To change this license header, cho   ose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursosTecnicos.daos;


import beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import RecursosTecnicos.dbUtilConeccionDB.ConexionDb;
import java.sql.ResultSet;
    
/**
 *
 * @author eaagudelr
 */
public class daoMuestraNoBorarra {
     //conectate conn;
    
    
public daoMuestraNoBorarra(){
    System.out.println("holla creando coneccion");
//    con = new conectate();
}
    

 public void insertarUsuario(ConexionDb conn, Usuario usuario){
      
      int codigo = usuario.getCodigo();
      String nombre = usuario.getNombre();
      String apellido = usuario.getApellido();
      int rol = usuario.getRol();
      String password = usuario.getPassword();
      
      System.out.println("xxxxxxxxxxxxxxxx codigo: "+codigo);
     
     try {
      
        PreparedStatement pstm = conn.getConnection().prepareStatement("insert into " + "usuario(codigo, nombre, apellido, rol, passwd) " + " values(?,?,?,?,?)");            

        pstm.setInt(1, codigo);
        pstm.setString(2, nombre);
        pstm.setString(3, apellido);
        pstm.setInt(4, rol);
        pstm.setString(5, password);
        System.out.println("consulta :" + pstm);
        pstm.execute();
        pstm.close();            
            System.out.println("error2 :" + pstm);
         }catch(SQLException e){
         System.out.println(e);
      }
   }
    /*obtenemos todos los datos de la tabla*/
 public Object [][] getUsuarios(ConexionDb conn){
      int x = 0;
          
     //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = conn.getConnection().prepareStatement("SELECT count(1) as total FROM usuario ");
         ResultSet res = pstm.executeQuery();
         res.next();
         x = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }  
      
    Object[][] s = new String[x][5];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = conn.getConnection().prepareStatement("SELECT " +
            " codigo, nombre, apellido, rol, passwd " +
            " FROM usuario");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estCodigo = res.getString("codigo");
            String estNombre = res.getString("nombre");
            String estApellido = res.getString("apellido");
            String estRol = res.getString("rol");
            String estPasswd = res.getString("passwd");
            s[i][0] = estCodigo;
            s[i][1] = estNombre;
            s[i][2] = estApellido;
            s[i][3] = estRol;
            s[i][4] = estPasswd;
            
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return s;
 }   
 
 public void borrarUsuario(ConexionDb conn, int codigo){  
            try {                
                
                PreparedStatement pstm = conn.getConnection().prepareStatement("delete from usuario where codigo = ?");            
                pstm.setInt(1, codigo);                   
                pstm.execute();
                System.out.println("registro eliminado");
                //vlidar que el codigo si exista primero
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }
 
 public void updateUsuario(ConexionDb conn, Usuario usuario){
       try {            
           
           String nombre = usuario.getNombre();
           String apellido = usuario.getApellido();
           int rol = usuario.getRol();
           String password = usuario.getPassword();
           int codigo = usuario.getCodigo();          
           
           System.out.println("valores obtenidos a editar: "+ codigo + " " + nombre + " " + apellido + " " + password);
            PreparedStatement pstm = conn.getConnection().prepareStatement("update usuario " +
            "set nombre = ? ," +
            "apellido = ? ," +
            "rol = ? ," +                    
            "passwd = ? " +                    
            "where codigo = ? ");            
            pstm.setString(1, nombre);                   
            pstm.setString(2, apellido);
            pstm.setInt(3, rol);
            pstm.setString(4, password);
            pstm.setInt(5, codigo);
            pstm.execute();
            System.out.println("validar que exista");
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
 
 

//public static Grupo getGrupoPorCodigo(Grupo gru){
//   int codigo = Grupo.codigo;
    //String sql = "select * from Grupo where codigo = codigo;";
//    System.out.println("holla llegue");
//    System.out.println("grupo: "+gru.getMateria());
//    return gru;
//}

//public getGruposPorMateria(Materia){return ListGrupo;}
//public getUsuarioPorCodigo(Usuario){return ListUsuario;}
//public getUsuarioPorPass(Usuario){return ListUsuario;}
//public getUsuariosPorApellido(Usuario){return ListUsuario;}
//public getUsuariosPorCodigo(Usuario){return ListUsuario;}
//public getUsuariosPorNombre(Usuario){return ListUsuario;}
//public getUsuariosPorRol(Usuario){return ListUsuario;}
//public boulean registrarRol(Rol){return true;}
//public boulean registrarUsuario(Usuario){return true;}

 
 //prueba insertgar usuario
//  public static void main(String[] args) {        
//        
//        Usuario usu = new Usuario();
//        usu.setApellido("agudelo");
//        usu.setNombre("edwin");
//        usu.setCodigo(1);
//        usu.setPassword("12345");
//        usu.setRol(2);
//        System.out.println("holla llegue");
//        conectate conn;
//        conn = new ConexionDb();
//        System.out.println("creada la coneccion");
//        //DAOUsuario.insertarUsuario(con, usu);
//  
//        daoMuestraNoBorarra odaousuario = new daoMuestraNoBorarra();
//        odaousuario.insertarUsuario(conn, usu);
//                
//    }
 //prueba listar usuarios
// public static void main(String[] args) {        
//        Usuario p = new Usuario();               
//        Object [][] sc ;
//        //sc = p.getDatos();
//        ConexionDb conn;
//        conn = new ConexionDb();
//        daoMuestraNoBorarra odaousuario = new daoMuestraNoBorarra();
//        odaousuario.getDatos(conn);
////        for(int i=0;i<sc.length ;i++){
////            System.out.println("> " + sc[i][0] + " - " + sc[i][1]);            
////        }         
//        int x = 2;//dos registros que hay en db
//        Object[][] s = new String[x][2];  
//        s = odaousuario.getUsuarios(conn);
//        for(int i=0;i<s.length ;i++){
//            System.out.println("> " + s[i][0] + " - " + s[i][1] + " - " + s[i][2] + " - " + s[i][3] + " - " + s[i][4]);            
//        }     
//    }
        
 //prueba eliminar usuario
// public static void main (String[] args){
// 
//     int codigo = 2;
//     ConexionDb conn = new ConexionDb();
//     Usuario usu = new Usuario();
//     daoMuestraNoBorarra odaousuario = new daoMuestraNoBorarra();
//     odaousuario.borrarUsuario(conn, codigo);
//     
//     
//     
// } 
// prueba uppdate usuario
//    public static void main (String[] args){
//    
//    ConexionDb conn = new ConexionDb();
//    Usuario user = new Usuario();
//    user.setCodigo(3);
//    user.setNombre("aaaaaa");
//    user.setApellido("aguuuuuuuuuu");
//    user.setPassword("121211212211212");
//    user.setRol(1);
//    daoMuestraNoBorarra daousuario = new daoMuestraNoBorarra();
//    daousuario.updateUsuario(conn, user);
//    
//    }
 
}
      
    

