package tp.ejbCompte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;

public class ConnexionBD {
	private static Connection maconnexion;
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			maconnexion = DriverManager.getConnection("jdbc:mysql://localhost/compte", "root", "");
		}catch(ClassNotFoundException e){
			}catch (SQLException e){
			}
		}
	public static Connection getConnection() {
		return maconnexion;
		}
	public static void init( ServletContext context ) {
		try {
			Class.forName(context.getInitParameter("JDBC_DRIVER" ));
			String dbURL = context.getInitParameter("JDBC_URL" );
			String dbLogin = context.getInitParameter("JDBC_LOGIN" );
			String dbPassword = context.getInitParameter("JDBC_PASSWORD" );
			maconnexion = DriverManager.getConnection(dbURL, dbLogin, dbPassword);
			System.out.println("Connecté à BD avec succés");
			} catch (SQLException e1){
		
				System.out.println("SQLException"+e1.getMessage());
				System.out.println("non connecté");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("non connecté");
			}
	}
}
