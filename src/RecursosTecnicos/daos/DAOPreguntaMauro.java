package RecursosTecnicos.daos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import RecursosTecnicos.dbUtilConeccionDB.ConexionDb;
import java.sql.ResultSet;
import beans.*;
import java.io.IOException;
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
	public Contexto buscarContexto(Contexto contexto){
		return null;
	}

//	/**
//	 * 
//	 * @param area
//	 */
//	public guardarAreaDeConocimiento(AreaDeConocimiento area){
//
//	}
//
//	/**
//	 * 
//	 * @param area
//	 * @param pregunta
//	 */
//	public guardarAreaDeConocimientoDePregunta(AreaDeConocimiento area, Pregunta pregunta){
//
//	}
//
//	/**
//	 * 
//	 * @param pregunta
//	 */
//	public guardarPregunta(Pregunta pregunta){
//
//	}
//
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
// Falta este en la BD y en los metodos de las preguntas
//            if (p.gethabilitado()!= 0) {
//                pstm.setInt(numAtrib, p.getGradoDificultad());
//                numAtrib++;
//            } else {
//                pstm.setString(numAtrib, "%");
//                numAtrib++;
//            }
            
            System.out.println("consulta :" + pstm);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                System.out.println("fecha de creacion: " + res.getString("fecha_creacion"));
                System.out.println("Tipo: " + res.getString("tipo"));
                System.out.println("Contexto: " + res.getString("contexto"));
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
        //u.setCodigo(2);
        p.setContexto(1);
        DAOPreguntaMauro dao = new DAOPreguntaMauro();
        ConexionDb con = new ConexionDb();
        dao.listarPreguntasOr(p, null, con);

    }
}

        
        

