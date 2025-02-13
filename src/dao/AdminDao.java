
package dao;

import dbconn.DBConn;
import java.sql.Connection;
import java.sql.SQLException;
import pojo.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
   
public class AdminDao {
  
    
        public static boolean addAdmin(Admin e) throws SQLException{
            Connection conn=DBConn.getConnection();
            PreparedStatement ps=conn.prepareStatement("Insert into admins(id,name,mail,password) values(?,?,?,?)");
            ps.setInt(1,e.getStdId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getMail());
            ps.setString(4,e.getPass());
          
            int ans= ps.executeUpdate();
//          
//          Statement   stmt=conn.createStatement();
//           String sql=" Insert into admins(id,name,mail,password) values('"+e.getStdId()+"', '"+e.getName()+"' ,'"+e.getMail()+"' ,'"+e.getPass()+"')";
//          int ans= stmt.executeUpdate(sql);
             
            return ans==1;
        }
        
      public static boolean updateAdmin(Admin e) throws SQLException{
        
         Connection conn=DBConn.getConnection();
      PreparedStatement ps=conn.prepareStatement("UPDATE admins set  name=?,mail=?,password=?  WHERE id=?" );
    //   ps.setInt(1, e.getNewId());
        ps.setString(1,e.getName());
           ps.setString(2,e.getMail());
            ps.setString(3,e.getPass());
            ps.setInt(4, e.getStdId());
//JOptionPane.showMessageDialog(null,e.getNewId()+"\n"+e.getStdId()+"\n"+e.getName()+"\n"+e.getMail()+"\n"+e.getPass(),"Success",JOptionPane.INFORMATION_MESSAGE);

          int ans=ps.executeUpdate();
        
//     Statement   stmt=conn.createStatement();
//     String sql="UPDATE admins set (id='"+e.getNewId()+"', name='"+e.getName()+"',mail='"+e.getMail()+"',password='"+e.getPass()+"'  WHERE id='"+e.getStdId()+"' )";
//           int ans= stmt.executeUpdate(sql);
       
       return ans==1;
         
         }
      
     public static boolean deleteAdmin(Admin e) throws SQLException{
          Connection conn=DBConn.getConnection();
        Statement   stmt=conn.createStatement();
      //  JOptionPane.showMessageDialog(null,e.getStdId(),"Success",JOptionPane.INFORMATION_MESSAGE);
            String sql=" DELETE   FROM ADMINS WHERE id='"+e.getStdId()+"'";
          int ans= stmt.executeUpdate(sql);
            
          return ans==1;

}
     
     public static Admin findAdminById(int adminId) throws SQLException{
 Connection conn=DBConn.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from Admins where id=?");
       ps.setInt(1, adminId);
      ResultSet rs= ps.executeQuery();
      Admin e=null;
      if(rs.next()){
         e=new Admin();
       e.setStdId(rs.getInt(1));
         e.setName(rs.getString(2));
        e.setMail(rs.getString(3));
        e.setPass(rs.getString(4));
     
      }
      return e;
     }
   
   //show data
    public static ArrayList<Admin> getAllAdmin()throws SQLException{
      Connection conn=DBConn.getConnection();
     Statement st=conn.createStatement();
     ResultSet rs=st.executeQuery("select * from Admins ORDER BY name ASC;");
                ArrayList<Admin> empList=new ArrayList();
                while(rs.next()){
                    Admin e=new Admin();
                         e.setStdId(rs.getInt(1));
                        e.setName(rs.getString(2));
                         e.setMail(rs.getString(3));
                        
                         empList.add(e);
                }
        
        return empList;
   }
      
}
