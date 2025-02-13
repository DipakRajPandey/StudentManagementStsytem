 
package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConn {
        private static Connection conn;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","");
      // JOptionPane.showMessageDialog(null, "Connection Opened Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver Class not loade","Driver Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in opening Connection","DB Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
        
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
           JOptionPane.showMessageDialog(null, "Close Connection ","Close",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in opening Connection","DB Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
