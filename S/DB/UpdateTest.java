import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class UpdateTest {
	 public static void main(String[] args) {
		    update("C+");
		  }
		   
	public static void update (String grade) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null ;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/student_db?useSSL=false";
		    conn = DriverManager.getConnection(url, "root", "duksung");
		    
		    System.out.println("DB ���� ����");
		    
		    String sql = "UPDATE grade set grade='"+grade+"'";
		    stmt = conn.createStatement();
		    int result = stmt.executeUpdate(sql);
		    
		    System.out.println("ó���� ���ڵ��� ���� : "+result);
		    System.out.println();
		    
		    stmt.close();
		    conn.close();
		    
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
	      }
	      catch( SQLException e){
	        e.printStackTrace();
	      }
	    }
	  }
	}