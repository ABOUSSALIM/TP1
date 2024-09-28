
package ma.projet.connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connexion {
    private static String url="jdbc:mysql://localhost:3306/osm";
    private static String username="root";
    private static String password="";
    private static Connection cn = null ;    
    public static Connection getCn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introvable");
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
    public static void closeCn() {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                cn = null;
            }
        }
    }
    
}
