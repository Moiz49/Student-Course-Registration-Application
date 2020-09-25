package database;

import java.sql.*;

/**
 * This class makes a database on SQL. 
 * ONLY RUN ONCE.
 * 
 * @author Mohammad Moshirpour (from d2l).
 * @version 1.0
 * @since 6/04/2020
 * 
 */
public class MySQLJDBC implements IDBCredentials {
	/**
	 * SQL connection.
	 */
	private Connection conn;

	/**
	 * Method to connect to SQL.
	 */
	public void initializeConnection() {
		try {
			// Register JDBC driver
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Problem");
			e.printStackTrace();
		}

	}

	/**
	 * Disconnect connection. 
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Makes a table for students.
	 */
	public void createStudentTable() {
		String sql = "CREATE TABLE STUDENT " + "(id INTEGER not NULL, " + " name VARCHAR(255), "
				+ " PRIMARY KEY ( id ))";

		try {
			Statement stmt = conn.createStatement(); 
			stmt.executeUpdate(sql); 
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Student table not created!");
		}
		System.out.println("Student table created.");
	}

	/**
	 * Makes a table for courses.
	 */
	public void createCourseTable() {
		String sql = "CREATE TABLE COURSE " + "(id INTEGER not NULL, " + " course_name VARCHAR(255), "
				+ " course_number INTEGER, " + " PRIMARY KEY ( id ))";

		try {
			Statement stmt = conn.createStatement(); 
			stmt.executeUpdate(sql); 
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Course table not created!");
		}
		System.out.println("Course table created.");
	}

	/**
	 * Inserts a student in the table.
	 * @param id Student ID.
	 * @param name Student name.
	 */
	public void insertStudent(int id, String name) {
		try {
			String query1 = "INSERT INTO STUDENT (ID , name) values(?,?)";
			PreparedStatement pStat = conn.prepareStatement(query1);
			pStat.setInt(1, id);
			pStat.setString(2, name);
			pStat.executeUpdate();
			pStat.close();
		} catch (SQLException e) {
			System.out.println("Unable to insert user");
			e.printStackTrace();
		}
	}
	
	/**
	 * Inserts a course in the table.
	 * @param id Course ID.
	 * @param courseName Course Name.
	 * @param courseNumber Course Number.
	 */
	public void insertCourse(int id, String courseName, int courseNumber) {
		try {
			String query2 = "INSERT INTO COURSE (ID, course_name , course_number) values(?,?,?)";
			PreparedStatement pStat = conn.prepareStatement(query2);
			pStat.setInt(1, id);
			pStat.setString(2, courseName);
			pStat.setInt(3, courseNumber);
			pStat.executeUpdate();
			pStat.close();
		} catch (SQLException e) {
			System.out.println("Unable to insert course");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Main method to make a database
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		MySQLJDBC myApp = new MySQLJDBC();
		myApp.initializeConnection();
		myApp.createStudentTable();
		myApp.createCourseTable();
	
		//Inserting student
		myApp.insertStudent(1001, "Sara");
		myApp.insertStudent(1002, "Moiz");
		myApp.insertStudent(1003, "Tom");
		myApp.insertStudent(1004, "David");
		myApp.insertStudent(1005, "Adam");
		myApp.insertStudent(1006, "John");
		
		//Inserting courses and their offerings
		myApp.insertCourse(1, "ENGG", 233);
		myApp.insertCourse(2, "ENSF", 409);
		myApp.insertCourse(3, "PHYS", 259);
		myApp.insertCourse(4, "MATH", 271);
		myApp.insertCourse(5, "ENCM", 275);
		myApp.insertCourse(6, "CPSC", 332);
		
		myApp.close();

	}

}
