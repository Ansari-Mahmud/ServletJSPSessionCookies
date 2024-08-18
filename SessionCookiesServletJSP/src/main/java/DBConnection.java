import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con = null;
	public static Connection connectdb() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "admin");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
