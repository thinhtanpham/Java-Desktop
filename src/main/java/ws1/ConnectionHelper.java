package ws1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

	private String user = "";
	private String password = "";
	private String url = "jdbc:sqlserver://localhost;databaseName=FULib";

	public ConnectionHelper(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
