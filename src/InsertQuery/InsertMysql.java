package InsertQuery;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import in.JDBCutils.JDBCutil;

public class InsertMysql {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = JDBCutil.getJdbcConnection();
			
			if(connection != null) {
				statement = (Statement) connection.createStatement();
				
				String myInsertQuery = "INSERT INTO STUDENT(name,roll,result) VALUES(nishant,123,pass)";
				
				int rowEffected = ((java.sql.Statement) statement).executeUpdate(myInsertQuery);
				
				if(rowEffected == 1) {
					System.out.println("Data inserted");
				}else System.out.println("Data not inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
