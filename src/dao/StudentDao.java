
package dao;

import dbconn.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pojo.Student;


public class StudentDao {
         public static boolean addStudent(Student e)throws SQLException{
        Connection conn= DBConn.getConnection();
        
          PreparedStatement ps=conn.prepareStatement("insert into students(id,name,FatherName,Blood,Phone,City,class) values(?,?,?,?,?,?,?)");
            ps.setInt(1,e.getStdId());
            ps.setString(2,e.getStdName());
            ps.setString(3,e.getStdFather());
            ps.setString(4,e.getStdBlood());
            ps.setLong(5,e.getStdPhone());
            ps.setString(6,e.getStdCity());
            ps.setInt(7,e.getStdclass());
         //   JOptionPane.showMessageDialog(null,e.getStdId()+"\n"+e.getStdName()+"\n"+e.getStdFather()+"\n"+e.getStdBlood()+"\n"+e.getStdPhone()+"\n"+e.getStdCity()+"\n"+e.getStdclass(),"Fail",JOptionPane.ERROR_MESSAGE);
            int ans= ps.executeUpdate();

 // JOptionPane.showMessageDialog(null,e.getStdId()+"\n"+e.getStdName()+"\n"+e.getStdFather()+"\n"+e.getStdBlood()+"\n"+e.getStdPhone()+"\n"+e.getStdCity()+"\n"+e.getStdclass(),"Fail",JOptionPane.ERROR_MESSAGE);
//              Statement   stmt=conn.createStatement();
//           String sql="Insert into students(id,name,fatherName,blood,phone,city,class) values('"+e.getStdId()+"', '"+e.getStdName()+"' ,'"+e.getStdFather()+"' ,'"+e.getStdBlood()+"','"+e.getStdPhone()+"', '"+e.getStdCity()+"' ,'"+e.getStdclass()+"' )";
//           int ans= stmt.executeUpdate(sql);
//             
          
            return  ans==1;
    }
     public static boolean updateStudent(Student e) throws SQLException{
         
         Connection conn=DBConn.getConnection();
                 int x=e.getStdId();
            PreparedStatement ps=conn.prepareStatement("UPDATE students  set  Name=?,FatherName=?,Blood=?,Phone=?,City=?,Class=? where id='"+x+"' ");
         
            
            ps.setString(1, e.getStdName());
            ps.setString(2,e.getStdFather());
            ps.setString(3,e.getStdBlood());
            ps.setLong(4,e.getStdPhone());
            ps.setString(5, e.getStdCity());
            ps.setInt(6, e.getStdclass());
            // JOptionPane.showMessageDialog(null,e.getNewId()+"\n"+e.getStdId()+"\n"+e.getStdName()+"\n"+e.getStdFather()+"\n"+e.getStdBlood()+"\n"+e.getStdPhone()+"\n"+e.getStdCity()+"\n"+e.getStdclass(),"Fail",JOptionPane.ERROR_MESSAGE);
            int ans=ps.executeUpdate();
             return ans==1;
         
         }
      public static boolean deleteStudent(Student e) throws SQLException{
           Connection conn=DBConn.getConnection();
        Statement   stmt=conn.createStatement();
      //  JOptionPane.showMessageDialog(null,e.getStdId(),"Success",JOptionPane.INFORMATION_MESSAGE);
            String sql=" DELETE   FROM Students WHERE id='"+e.getStdId()+"'";
          int ans= stmt.executeUpdate(sql);
            
          return ans==1;
           
      }
            public static Student findStudentById(int stdId) throws SQLException{
      Connection conn=DBConn.getConnection();
         PreparedStatement ps=conn.prepareStatement("select * from Students where id=?");
         ps.setInt(1, stdId);
        ResultSet rs= ps.executeQuery();
        Student e=null;
        if(rs.next()){
           e=new Student();
           e.setStdId(rs.getInt(1));
           e.setStdName(rs.getString(2));
           e.setStdFather(rs.getString(3));
           e.setStdBlood(rs.getString(4));
           e.setStdPhone(rs.getLong(5));
           e.setStdCity(rs.getString(6));
           e.setStdclass(rs.getInt(7));
       
       }
       return e;
       
    
      }
            //show Student Datails
        public static ArrayList<Student> getAllAdmin()throws SQLException{
         Connection conn=DBConn.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from Students ORDER BY name ASC;");
                ArrayList<Student> empList=new ArrayList();
                while(rs.next()){
                    Student e=new Student();
                     e.setStdId(rs.getInt(1));
                     e.setStdName(rs.getString(2));
                     e.setStdFather(rs.getString(3));
                     e.setStdBlood(rs.getString(4));
                     e.setStdPhone(rs.getLong(5));
                     e.setStdCity(rs.getString(6));
                     e.setStdclass(rs.getInt(7));
                       empList.add(e);    
                  }
        
        return empList;
        }
}
