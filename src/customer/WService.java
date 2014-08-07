package customer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;

@WebService
public class WService {
  
  @WebMethod
  public ArrayList<Customer> customerSearch(@param ) {
    
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    final String DB_URL = "jdbc:mysql://localhost/db_name";
    final String USER = "yggy";
    final String PASS = "xxx";
    
    Connection conn = null;
    PreparedStatement stmt = null;
    try{ 
       Class.forName("com.mysql.jdbc.Driver");

       conn = DriverManager.getConnection(DB_URL,USER,PASS);
       
       String sql = "Select c.first_name, c.middle_name, c.last_name, c.customer_phone,"
       +"c.customer_email, c.other_customer_details, a.line_1 " +
       "from customers c, addresses a";
       //"where c.customer_id = a.address_id"
       sql = "SELECT id, first, last, age FROM Employees";
       ResultSet rs = stmt.executeQuery(sql);

       
       //+"WHERE id=?";
       stmt = conn.prepareStatement(sql);
//
//       stmt.setString(1, 35);  // This would set age
//       stmt.setString(2, 102); // This would set ID
//       stmt.setString(3, 35);  // This would set age
//       stmt.setString(4, 102); // This would set ID       
//       stmt.setString(5, 35);  // This would set age
//       stmt.setString(6, 102); // This would set ID
//       
       
      
       // Let us select all the records and display them.
    
       //STEP 5: Extract data from result set
       while(rs.next()){
          //Retrieve by column name
          int id  = rs.getInt("id");
          int age = rs.getInt("age");
          String first = rs.getString("first");
          String last = rs.getString("last");

          //Display values
          System.out.print("ID: " + id);
          System.out.print(", Age: " + age);
          System.out.print(", First: " + first);
          System.out.println(", Last: " + last);
       }
       //STEP 6: Clean-up environment
       rs.close();
       stmt.close();
       conn.close();
    }catch(SQLException se){
       //Handle errors for JDBC
       se.printStackTrace();
    }catch(Exception e){
       //Handle errors for Class.forName
       e.printStackTrace();
    }finally{
       //finally block used to close resources
       try{
          if(stmt!=null)
             stmt.close();
       }catch(SQLException se2){
       }// nothing we can do
       try{
          if(conn!=null)
             conn.close();
       }catch(SQLException se){
          se.printStackTrace();
       }//end finally try
    }//end try
    System.out.println("Goodbye!");
    return null;
    
      
  }
//  @WebMethod
//  public String customerOrder(String name) {
//     
//  }
//  @WebMethod
//  public String createProduct(String name) {
//      
//  }
//  @WebMethod
//  public String updateInfo(String name) {
//    
//  }

}
