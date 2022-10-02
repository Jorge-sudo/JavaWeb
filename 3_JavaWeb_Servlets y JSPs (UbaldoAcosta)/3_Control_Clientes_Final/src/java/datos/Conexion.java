package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class Conexion {

    //Este es para la base de datos remota
    //private static final String JDBC_URL = "jdbc:mysql://node105361-env-5373449.jelastic.saveincloud.net:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "danay hija";
    
    //Este es para la base de datos remota HBdEzM4dhF
    //private static final String JDBC_PASSWORD = "HBdEzM4dhF";
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            //Esto es para la Pool de Conexiones, por el momento inicializaremos con un valor de 50 conexiones
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection cn) {
        try {
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
