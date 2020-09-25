package server.model;

import database.IDBCredentials;
import java.util.ArrayList;
import java.sql.*;

/**
 * This class is simulating a database for our program
 * 
 * @author Bhavdeep Purba, Moiz Abdullah, Rifat Haque
 * @version 1.0
 * @since 6/04/2020
 * 
 */
public class DBManager implements IDBCredentials {
	/**
	 * ArrayList of Courses.
	 */
	ArrayList<Course> courseList;
	/**
	 * ArrayList of Students.
	 */
	ArrayList<Student> students;

	/**
	 * Reads courses from the database.
	 * @return ArrayList of Courses.
	 */
	public ArrayList<Course> readFromDataBase() {
		courseList = new ArrayList<Course>();
		try {
			// get connection to database
			Connection myCon = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// create a statement
			Statement myStmt = myCon.createStatement();

			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from course");

			// Process the result set
			while (myRs.next()) {
				courseList.add(new Course(myRs.getString("course_name"), myRs.getInt("course_number")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	/**
	 * Reads students from the database.
	 * @return ArrayList of Students.
	 */
	public ArrayList<Student> readFromDataBase2() {
		students = new ArrayList<Student>();
		try {
			// get connection to database
			Connection myCon = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// create a statement
			Statement myStmt = myCon.createStatement();

			// Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from student");

			// Process the result set
			while (myRs.next()) {
				students.add(new Student(myRs.getString("name"), myRs.getInt("id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}

}
