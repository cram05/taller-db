
package ventanas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import postgresql.PostgreSQLDataBase;

/**
 *
 * @author Carlos Ramos
 */
class VerificadorUsuario {
    static int idSesion = 1;

    public boolean comprobar(String user, char[] pass) {
        String contraseña = String.copyValueOf(pass);
        boolean existe = false;
        String sql;
        try {
            Connection  conn = new PostgreSQLDataBase().conectar();
            Statement stmt = conn.createStatement();
            sql = "SELECT idUser, NOMBRE, CONTRASENA FROM USUARIO WHERE NOMBRE='"+user+"' AND"
                    + " CONTRASENA='"+contraseña+"';";
            ResultSet rs = stmt.executeQuery(sql);
            int idUser=0;
            while ( rs.next() ) {
                idUser = rs.getInt("idUser");
                String  name = rs.getString("nombre");
                //int age  = rs.getInt("age");
                String  passw = rs.getString("contrasena");
                //float salary = rs.getFloat("salary");
                if(!name.equals(""))
                    existe = true;
            }
            if(existe){
                //colocamos activo la tabla usuario
                sql = "update usuario SET activo = true where iduser="+idUser+";";
                stmt.executeUpdate(sql);
                insertarSesion(idUser, stmt, rs, conn);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(VerificadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println( ex.getClass().getName()+": "+ ex.getMessage() );
        }
        return existe;
    }
    
    public void insertarSesion(int idUser, Statement stmt, ResultSet rs, Connection conn){
        String sql;
        try {
            //obtenemos el pid
            rs = stmt.executeQuery("SELECT pg_backend_pid() as pid;");
            int pid = 0;
            while(rs.next()){
                pid = rs.getInt("pid");
                //System.out.println("pid: "+pid);
            }
            //obtenemos el ultimo idsesion
            rs = stmt.executeQuery("select idsesion from sesion");
            while(rs.next()){
                int aux = rs.getInt("idsesion");
                if(aux > idSesion)
                    idSesion = aux;
            }
            //insertamos valores a la tabla sesion
            sql = "insert into sesion values ("+(idSesion+1)+", "+idUser+", "+pid+", '01/01/02017', null, true);";
            stmt.executeUpdate(sql);
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(VerificadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
