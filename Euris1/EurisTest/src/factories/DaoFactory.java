package factories;

import dao.DaoMySQL;
import dao.IDao;

public interface DaoFactory {
	
	String DB_ADDRESS = "jdbc:mysql://localhost:3306/euristest";
	String USER = "root";
	String PASSWORD = "Georges01@";
	
	static IDao make() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new DaoMySQL(DB_ADDRESS, USER, PASSWORD);
	}

}
