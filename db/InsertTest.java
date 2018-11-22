//package from S
package db;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class InsertTest {
    public static void main(String[] args) {
    // student ���̺��� ����
	// id, name, stu_num, major, email, pw
        insert("sallycool", "������", "20160835", "��������", "sallycool27@naver.com", "magitionofdrip");
    }
   
    public static void insert(String number, String name, String major,
                			String id, String email, String pw) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
     
    	try {
    		// 1. ����̹� �ε�
    		Class.forName("com.mysql.cj.jdbc.Driver");
       
    		// 2. �����ϱ�
    		String url = "jdbc:mysql://localhost/student_db?serverTimezone=Asia/Seoul";
    		conn = DriverManager.getConnection(url, "root", "project339");
       
    		// 3. SQL ���� �غ�
    		// �߰��Ϸ��� �������� ���� ���޵� ���ڸ� ���� �������� �Ҵ�Ǵ� ���̴�.
    		// �� � ���� ���޵��� �𸣹Ƿ� Select �� ���� �޸�
    		// stmt = conn.createStatement(); �� �ۼ����� �ʰ�
    		// pstmt = conn.prepareStatement(sql); �� �ۼ��Ͽ� �����͸� �߰��� ������ �˸��ϴ�.
    		// ���� sql ���� ������ + �����ڷ� �� �ٷ� �ۼ��� �� ������ �������� �ʹ� �������� �ǹǷ�
    		// �� ����� ���մϴ�.
    		String sql = "INSERT INTO student VALUES (?,?,?,?,?,?)";
    		pstmt = conn.prepareStatement(sql);
       
       
    		// 4. ������ binding
    		pstmt.setString(1, number);
    		pstmt.setString(2, name);
    		pstmt.setString(3, major);
    		pstmt.setString(4, id);
    		pstmt.setString(5, email);
    		pstmt.setString(6, pw);
       
    		// 5. ���� ���� �� ��� ó��
    		// SELECT�� �޸� INSERT�� ��ȯ�Ǵ� �����͵��� �����Ƿ�
    		// ResultSet ��ü�� �ʿ� ����, �ٷ� pstmt.executeUpdate()�޼��带 ȣ���ϸ� �˴ϴ�.
    		// INSERT, UPDATE, DELETE ������ �̿� ���� �޼��带 ȣ���ϸ�
    		// SELECT������ stmt.executeQuery(sql); �޼��带 ����߾����ϴ�.
    		// @return  int - �� ���� row�� ������ ���ƴ����� ��ȯ
    		int count = pstmt.executeUpdate();
    		if( count == 0 ){
    			System.out.println("������ �Է� ����");
    		} else {
    			System.out.println("������ �Է� ����");
    		}
    	} catch( ClassNotFoundException e){
    		System.out.println("����̹� �ε� ����");
    	} catch( SQLException e){
    		System.out.println("���� " + e);
    	}
    	finally {
    		try {
    			if( conn != null && !conn.isClosed()){
    				conn.close();
    			}
    			if( pstmt != null && !pstmt.isClosed()){
    				pstmt.close();
    			}
    		}
    		catch( SQLException e){
    			e.printStackTrace();
    		}
    	}
    }
}