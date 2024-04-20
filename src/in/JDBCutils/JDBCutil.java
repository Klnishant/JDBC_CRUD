package in.JDBCutils;
import java.beans.Statement;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutil {
	
	public static Connection getJdbcConnection() throws IOException, SQLException {
			
		FileInputStream FIS = new FileInputStream("Application.properties");
		Properties p = new Properties();
		p.load(FIS);
		
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		return connection;
	}
	
	public static void CloseResource(Connection connection,Statement statement) throws SQLException, IOException {
		if(connection != null) {
			connection.close();
		}
		if (statement != null) {
			((Closeable) statement).close();
		}
	}
}