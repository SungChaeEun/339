//package from K
package db;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class SelectTest {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
     
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
       
      String url = "jdbc:mysql://localhost/student_db?serverTimezone=Asia/Seoul";
      conn = DriverManager.getConnection(url, "root", "project339");
      stmt = conn.createStatement();
       
      String sql = "SELECT name, major, id from student";
              
      // 5. ���� ����
      // ���ڵ���� ResultSet ��ü�� �߰��ȴ�.
      rs = stmt.executeQuery(sql);
       
      // 6. ������ ����ϱ�
      while(rs.next()){
        // ���ڵ��� Į���� �迭�� �޸� 0���� �������� �ʰ� 1���� �����Ѵ�.
        // �����ͺ��̽����� �������� �������� Ÿ�Կ� �°� getString �Ǵ� getInt ���� ȣ���Ѵ�.
        String name = rs.getString(1);
        String major = rs.getString(2);
        String id = rs.getString(3);
         
        System.out.println(name + " " + major + " " + id);
      }
    }
    catch( ClassNotFoundException e){
      System.out.println("����̹� �ε� ����");
    }
    catch( SQLException e){
      System.out.println("���� " + e);
    }
    finally{
      try{
        if( conn != null && !conn.isClosed()){
          conn.close();
        }
        if( stmt != null && !stmt.isClosed()){
          stmt.close();
        }
        if( rs != null && !rs.isClosed()){
          rs.close();
        }
      }
      catch(SQLException e){
        e.printStackTrace();
      }
    }
  }
}