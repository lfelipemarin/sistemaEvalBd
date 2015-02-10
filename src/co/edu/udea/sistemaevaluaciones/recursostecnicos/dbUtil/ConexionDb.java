/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.sistemaevaluaciones.recursostecnicos.dbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConexionDb {

    private Connection conn = null;
    private static ConexionDb instancia;

    private ConexionDb() {

        try {

            Properties prop = new Properties();
            String propFileName = "co/edu/udea/sistemaevaluaciones/recursostecnicos/configuracion/configuracion.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                System.out.println("inputStream null");
            }

            String login = prop.getProperty("login");
            String password = prop.getProperty("password");
            String url = prop.getProperty("url");

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            System.out.println("como esta la conexion: " + conn);
            if (conn != null) {
                System.out.println("conexion ok");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;
    }

    public static ConexionDb getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDb();
        }
        return instancia;
    }
}
