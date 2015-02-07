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
 *
 * @author dx
 */
public class PoolConexion {

    /**
     * @param aInstancia the instancia to set
     */
    private static void setInstancia(PoolConexion aInstancia) {
        instancia = aInstancia;
    }

    private String login;
    private String password;
    private String url;
    private BasicDataSource basicDataSource;
    private static PoolConexion instancia;

    private PoolConexion() {
        cargarParametros();
        crearPool();
    }

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

    public PoolConexion getInstancia() {
        if (instancia == null) {
            instancia = new PoolConexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        try {
            return getInstancia().getBasicDataSource().getConnection();
        } catch (SQLException ex) {
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
