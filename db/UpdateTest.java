//package from K
package db;
     
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
     
public class UpdateTest {
       
    private Connection con;
    private Statement st; //DB�� ��������ϴ� ��ü
    private ResultSet rs;
          
    //�⺻������
    public UpdateTest(String name, String id, String email){ 
        try {           
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost/student_db?serverTimezone=Asia/Seoul";
            String db_id ="root";
            String db_pw ="project339";
               
            con = DriverManager.getConnection(url, db_id, db_pw);
               
            System.out.println("DB ���� ����");
               
            String sql= "update student set id='"+id+"', email='"+email+"' where name='"+name+"';";
           
            st = con.createStatement();   
            int result = st.executeUpdate(sql); //ó���� ���ڵ��� ������ int������ ��ȯ
            //select�� ������ update, insert, delete�� executeUpdate()�޼ҵ带 �����.
               
     
            System.out.print("ó���� ���ڵ��� ����: "+ result);
            System.out.println();
                           
            st.close();
            con.close();
               
        } catch(ClassNotFoundException e){
            System.out.println(e + "=> ����̹� �ε� ����");
        } catch(SQLException e){
            System.out.println(e+ "=> Sql ���� ");
        } catch(Exception e){
            System.out.println(e + "=> �Ϲ� ����");
               
        }
    }
        
    public static void main(String args[]){
            new UpdateTest("�����", "davenport33", "davenport33@duksung.ac.kr");
           
        }
       
    }