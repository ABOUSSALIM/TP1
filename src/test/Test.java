package test;
import ma.projet.connexion.Connexion;
import beans.Site;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Test { 
    public static void save(Site s){
        Statement st=null;
            try{
                String req ="INSERT INTO site VALUES(NULL,'"+s.getNom()+"')";
                st = Connexion.getCn().createStatement();
                st.executeUpdate(req);
                
             
            }catch (SQLException e) {
                System.out.println("erreur SQL");
        }finally{
                try{
                   st.close();
                   Connexion.getCn();
            } catch(SQLException e){
              System.out.println("Erreur lors de la fermeture des ressources");
            }
            }
        }
 public static void load() {
    Statement st = null;
    ResultSet rs = null;
    try {
        String req = "SELECT * FROM site";
        st = Connexion.getCn().createStatement();
        rs = st.executeQuery(req);

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }
    } catch (SQLException e) {
        System.out.println("erreur SQL");
    } finally {
        try {
            if (st != null) st.close();
             Connexion.closeCn();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture des ressources");
        }
       
    }
}


    public static void main(String[] args) {
        
        //save(new Site("Avito"));
        //save(new Site("ENSAJ"));
        //save(new Site("ELJADIDA"));
        
        load();
        
        
       
    }
    
}
