
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author carlitos
 */
public class ConexionPostgresql {
    private static final String user = "postgres";
    private static final String pass = "carlitos";
    private static final String url = "jdbc:postgresql://localhost:5432/tienda_online_DB";
    
    public static Connection conectar(){
        Connection c = null;
        try {
        Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        //System.out.println("Operation done successfully");
        return c;
    }
    
}
