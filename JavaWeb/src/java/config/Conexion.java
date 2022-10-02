package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;
import modeloDAO.ClienteDAO;
import modelos.Cliente;

/*
 * @author JORGE
 */
public class Conexion {

    public static Connection getConection() {
        Connection con = null;
        try {

            String JDBC_URL = "jdbc:mysql://node101452-env-7253334.jelastic.saveincloud.net:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String JDBC_USER = "root";
            String JDBC_PASSWORD = "a1T7P07amI";

            //En este caso ya no encerramos en un try y catch sinos reportamos la Exception "throws SQLException"
            con = (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("CONECTADO");
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return con;
    }

    public static void main(String[] args) {

        ClienteDAO dao = new ClienteDAO();
        dao.delete(11);
        
//        list.forEach((persona) -> {
//            System.out.println("persona = " + persona);
//        });
//        System.out.println("");

    }

}
