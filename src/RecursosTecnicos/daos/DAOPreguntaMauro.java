package RecursosTecnicos.daos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import RecursosTecnicos.dbUtilConeccionDB.ConexionDb;
import java.sql.ResultSet;
import beans.*;
import java.io.IOException;
import java.util.Date;
/**
 * @author FelipeWin
 * @version 1.0
 */
public class DAOPreguntaMauro {

	public DAOPreguntaMauro(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param contexto
	 */
	public Contexto buscarContexto(Contexto c, ConexionDb conn){
            String sentencia = "SELECT * FROM contexto c  WHERE codigo = ? OR "
                + "enunciado = ? OR imagen = ? OR fecha_creacion = ? OR autor = ? OR titulo = ?";

        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (c.getCodigo()!= 0) {
                pstm.setInt(numAtrib, c.getCodigo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");  
                numAtrib++;
            }

            if (c.getEnunciado() != null ) {
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

            if (c.getFecha_creacion()!= null) {
                pstm.setDate(numAtrib, c.getFecha_creacion());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (c.getAutor()!= 0) {
                pstm.setInt(numAtrib, c.getAutor());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }
            
            
            if (c.getTitulo()!= null) {
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
	public void guardarAreaDeConocimiento(AreaDeConocimiento area, ConexionDb conn){
            String sentencia =  "INSERT INTO `area_conocimiento` (`codigo`, `nombre`, `descripcion`, `area_padre` ) VALUES (?,?,?,?)";
               int cod_area = area.getCodigo();
               String nombre = area.getNombre();
               String descripcion = area.getDescripcion();
               int area_padre = area.getArea_padre();
            try {
      
                PreparedStatement pstm = conn.getConnection().prepareStatement(sentencia);            

                pstm.setInt(1, cod_area);
                pstm.setString(2, nombre);
                pstm.setString(3, descripcion);
                pstm.setInt(4, area_padre);
                
        System.out.println("consulta :" + pstm);
        pstm.execute();
        pstm.close();            
            System.out.println("error2 :" + pstm);
         }catch(SQLException e){
         System.out.println(e);
      }
            
            

	}

	/**
	 * 
	 * @param area
	 * @param pregunta
	 */
	public void guardarAreaDeConocimientoDePregunta(AreaDeConocimiento area, Pregunta pregunta, ConexionDb conn){
            String sentencia =  "INSERT INTO `area_conocimiento_x_pregunta` (`area_conocimiento`, `pregunta`) VALUES (?,?)";
               int cod_area = area.getCodigo();
               int cod_pregunta = pregunta.getCodigo();
            try {
      
                PreparedStatement pstm = conn.getConnection().prepareStatement(sentencia);            

                pstm.setInt(1, cod_area);
                pstm.setInt(2, cod_pregunta);
                
                
        System.out.println("consulta :" + pstm);
        pstm.execute();
        pstm.close();            
            System.out.println("error2 :" + pstm);
         }catch(SQLException e){
         System.out.println(e);
      }
            
	}
//
//	/**
//	 * 
//	 * @param pregunta
//	 */
	public void guardarPregunta(Pregunta p, ConexionDb conn){
            p.setCodigo(10);
            p.setEnunciado("El enunciado 3");
            p.setTipo(1);
            p.setMateria(1);
            p.setHabilitado(true);
            p.setFecha_creacion(java.sql.Date.valueOf("2015-10-25"));
            p.setContexto(1);
            p.setAutor(1055831540);
            p.setGradoDificultad(1);
            p.setImagen(null);
            p.setNivelEvaluativo(1);
            
            
            int codigo =p.getCodigo();
            String enunciado =p.getEnunciado();
            int tipo = p.getTipo();
            int materia = p.getMateria();
            boolean habilitado = p.isHabilitado();
            Date fecha_creacion = p.getFecha_creacion();
            int contexto = p.getContexto();
            int autor =p.getAutor();
            int grado_dificultad=p.getGradoDificultad();
            String imagen =p.getImagen();
            int nivel_evaluativo =p.getNivelEvaluativo();
            
          String sentencia =  "INSERT INTO `pregunta` (`codigo`, `enunciado`, `tipo`, `materia`, `habilitado`, `fecha_creacion`, `contexto`, `autor`, `grado_dificultad`, `imagen`, `nivel_evaluativo`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
               
            try {
      
                PreparedStatement pstm = conn.getConnection().prepareStatement(sentencia);            

                pstm.setInt(1, codigo);
                pstm.setString(2, enunciado);
                pstm.setInt(3, tipo);
                pstm.setInt(4, materia);
                pstm.setBoolean(5, habilitado);
                pstm.setDate(6, (java.sql.Date)fecha_creacion);
                pstm.setInt(7, contexto);
                pstm.setInt(8, autor);
                pstm.setInt(9, grado_dificultad);
                pstm.setString(10, imagen);
                pstm.setInt(11, nivel_evaluativo);
                
        System.out.println("consulta :" + pstm);
        pstm.execute();
        pstm.close();            
            System.out.println("error2 :" + pstm);
         }catch(SQLException e){
         System.out.println(e);
      }
   }



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
	 * @param pregunta
	 */
	public <Collection>Pregunta listarPreguntasOr(Pregunta p, String param, ConexionDb c){
		//return null;
	      String sentencia = "SELECT * FROM pregunta p WHERE fecha_creacion = ? OR "
                + "tipo = ? OR contexto = ? OR grado_dificultad = ? OR habilitado = ?";
//En el modulo 1 segun el prototipo tambien pueden buscar por area del conocimiento campo o valor que no esta actualmente en las preguntas
        try {
            PreparedStatement pstm = c.getConnection().prepareStatement(sentencia);
            int numAtrib = 1;

            if (p.getFecha_creacion()!= null) {
                pstm.setDate(numAtrib, p.getFecha_creacion());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");  //al ser fecha no se puede convertira Date a sTRING
                numAtrib++;
            }

            if (p.getTipo() != 0 ) {
                pstm.setInt(numAtrib, p.getTipo());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (p.getContexto() != 0 ) {
                pstm.setInt(numAtrib, p.getContexto());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (p.getGradoDificultad()!= 0) {
                pstm.setInt(numAtrib, p.getGradoDificultad());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }

            if (p.isHabilitado()!= false) {
                pstm.setInt(numAtrib, p.getGradoDificultad());
                numAtrib++;
            } else {
                pstm.setString(numAtrib, "%");
                numAtrib++;
            }
            
            System.out.println("consulta :" + pstm);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                System.out.println("fecha de creacion: " + res.getString("fecha_creacion"));
                System.out.println("Tipo: " + res.getString("tipo"));
                System.out.println("Contexto: " + res.getString("contexto"));
                System.out.println("Enunciado: " + res.getString("enunciado"));
                System.out.println("Grado de Dificultad: " + res.getString("grado_dificultad"));
                System.out.println("Estado: " + res.getString("habilitado"));
            }
            pstm.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return null;
        }

    public static void main(String[] args) throws IOException {
        Pregunta p = new Pregunta();
        Contexto c = new Contexto();
        AreaDeConocimiento a = new AreaDeConocimiento();
        p.setCodigo(10);
        a.setCodigo(1);
        c.setCodigo(1);
        DAOPreguntaMauro dao = new DAOPreguntaMauro();
        ConexionDb con = new ConexionDb();
        dao.buscarContexto(c, con);

    }
}

        
        

