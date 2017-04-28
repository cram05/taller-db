package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Ramos
 */
public class ConsultasSQL {
    private static Connection conn;

    public static void activarUsuario(int idUser) {
        try {
            conn = ConexionPostgresql.conectar();
            Statement stmt = conn.createStatement();
            String sql = "update usuario SET activo = true where iduser="+idUser+";";
            stmt.executeUpdate(sql);
            conn.commit();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int crearSesion(int idUser) {
        int idSesion = -1;
        try {
            conn = ConexionPostgresql.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            //obtenemos el pid=================================
            rs = stmt.executeQuery("SELECT pg_backend_pid() as pid;");
            int pid = 0;
            while(rs.next()){
                pid = rs.getInt("pid");
            }
            //insertamos una tupla en sesion===========================
            String sql = "insert into sesion values (DEFAULT, "+idUser+", "+pid+", '01/01/02017', null, true);";
            stmt.executeUpdate(sql);
            conn.commit();
            //obtenmos la idsesion actual===probarrrrrrrr
            sql = "SELECT currval(pg_get_serial_sequence('sesion', 'idsesion')) as idsesion;";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                idSesion = rs.getInt("idsesion");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idSesion;
    }

    public static int obtenerIdUsuario(String user, String pass) {
        int idUsuario = -1;
        try {
            String sql;
            conn = ConexionPostgresql.conectar();
            Statement stmt = conn.createStatement();
            sql = "SELECT iduser FROM USUARIO WHERE NOMBRE='"+user+"' AND"
                    + " CONTRASENA='"+pass+"';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                idUsuario = rs.getInt("idUser");
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println( ex.getClass().getName()+": "+ ex.getMessage() );
        }
        return idUsuario;
    }
    
    public static ArrayList<String> obtenerIUs(int idUser) {
        ArrayList<String> id_ius = new ArrayList<>();
        String sql = "select distinct iu_idiu, iu.nombre " +
                    "from(" +
                    "	select funcion_idfuncion " +
                    "	from (" +
                    "		select user_rol.rol_idrol " +
                    "		from user_rol, usuario " +
                    "		where user_rol.usuario_iduser="+idUser+
                    "	)uno, rol_funcion" +
                    "	where uno.rol_idrol=rol_funcion.rol_idrol " +
                    ")dos, funcion_iu, iu " +
                    "where dos.funcion_idfuncion=funcion_iu.funcion_idfuncion and iu_idiu=iu.idiu;";
        try {
            conn = ConexionPostgresql.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String nombreIU = rs.getString("nombre");
                id_ius.add(nombreIU);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_ius;
    }

    static void desactivarSesion(int idSesion) {
        try {
            Connection  conn = new ConexionPostgresql().conectar();
            Statement stmt = conn.createStatement();
            //colocamos activo=false (inactivo) la tabla sesion
            String sql = "update sesion SET activo = false where idsesion="+idSesion+";";
            stmt.executeUpdate(sql);
            conn.commit();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println( ex.getClass().getName()+": "+ ex.getMessage() );
        }
    }
}
