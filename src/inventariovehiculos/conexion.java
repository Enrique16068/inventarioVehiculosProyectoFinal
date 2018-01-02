package inventariovehiculos;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class conexion {
    private String Url="jdbc:mysql://localhost:3306/Inventario";
    private String User="root";
    private String Password="josselyn";
    private Statement sttm=null;
    private Connection conexion=null;
    private ResultSet resultado=null;
    
    public void UID(String sql){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(Url,User,Password);
            sttm=conexion.createStatement();
            sttm.executeUpdate(sql);
        }catch(ClassNotFoundException c){
            JOptionPane.showMessageDialog(null,"Error "+c.getMessage());
            System.exit(1);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error "+ e.getMessage());
            System.exit(1);
        }
    }
    public ResultSet getValores (String sql){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conexion=DriverManager.getConnection(Url,User,Password);
                sttm=conexion.createStatement();
                resultado=sttm.executeQuery(sql);
                
            }catch(ClassNotFoundException c){
                JOptionPane.showMessageDialog(null,"Error "+ c.getMessage());
                System.exit(1);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Error "+ e.getMessage());
                System.exit(1);
            }
            return resultado;
        }
}
