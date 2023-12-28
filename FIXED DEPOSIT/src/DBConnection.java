import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{

	static Connection con;
	static {
    try{
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3307/fixed_deposit","root","1234");
	   }
       catch(Exception e1){
	 
      }
	} 
    public static Connection getConnection() {
    	return con;
    }
    
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
