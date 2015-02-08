/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursosTecnicos.dbUtilConeccionDB;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Descripcion de PoolConexion
 *
 * @author mateo1235
 * @version 1.0.
 */
public class PoolConexion {

    /**
     * Descripcion de login: usuario de la base de datos
     */
    private String login;

    /**
     * Descripcion de password: password de la base de datos
     */
    private String password;

    /**
     * Descripcion de url: direccion de la base de datos
     */
    private String url;

    /**
     * Descripcion de basicDataSur: objeto que crea el pool de conexiones
     */
    private BasicDataSource basicDataSource;

    /**
     * Descripcion de instancia: instancia de la clase (que es de tipo
     * singleton)
     */
    private static PoolConexion instancia;

    /**
     * Descripcion de PoolConexion() carga los parametros y crear un objeto que
     * establece la conexion con la base de datos y ofrece un pool de conexiones
     */
    private PoolConexion() {
        cargarParametros();
        crearPool();
    }

    /** Descripcion de cargarParametros() abre el archivo de parametros y lo
     * carga su respectivo campo en la clase
     * @version 1.0
     * @param [ninguno] ningun parametro
     * @return ningun retorno 
     */
    private void cargarParametros() {

        Properties prop = new Properties();
        String propFileName = "RecursosTecnicos/configuracion/configuracion.properties";

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            }
        } catch (Exception e) {
            System.out.println("Hacer lo propio con la exception");
        }

        setLogin(prop.getProperty("login"));
        setPassword(prop.getProperty("password"));
        setUrl(prop.getProperty("url"));
    }

    private void crearPool() {

        setBasicDataSource(new BasicDataSource());
        getBasicDataSource().setDriverClassName("com.mysql.jdbc.Driver");
        getBasicDataSource().setUsername(getLogin());
        getBasicDataSource().setPassword(getPassword());
        getBasicDataSource().setUrl(getUrl());
    }

    /** Descripcion de getInstancia() metodo que retorna el la instancia de este
     * singleton, si esta no existe primero la crea invcando el constructor
     * privado
     * @version 1.0
     * @return Objeto PoolConexion instancia unica de esta clase que contiene el
     * metodo que entrega objetos de tipo conexion desde un pool de conexiones
     */
    public static PoolConexion getInstancia() {
        if (instancia == null) {
            instancia = new PoolConexion();
        }
        return instancia;
    }

    /** Descripcion de getInstancia() metodo que retorna el la instancia de este
     * singleton, si esta no existe primero la crea invcando el constructor
     * privado
     * @version 1.0
     * @return Objeto PoolConexion instancia unica de esta clase que contiene el
     * metodo que entrega objetos de tipo conexion desde un pool de conexiones
     */
    public Connection getConexion() {
        try {
            return getInstancia().getBasicDataSource().getConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * @return the login
     */
    private String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    private void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    private String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    private void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the url
     */
    private String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    private void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the basicDataSource
     */
    private BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }

    /**
     * @param basicDataSource the basicDataSource to set
     */
    private void setBasicDataSource(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

}