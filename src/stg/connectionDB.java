package stg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class connectionDB {
	public static Connection getConnection() {
		Connection connection=null;
		try {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/stageonda", "root", "");
		} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Connection Failed");
		}
		return connection;
		}

}
