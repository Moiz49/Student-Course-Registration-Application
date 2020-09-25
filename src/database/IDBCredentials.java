package database;

/**
 * This interface provides constant for the database.
 * This class NEEDS TO BE CHANGED for the computer before running the program.
 * 
 * @author Mohammad Moshirpour (from d2l).
 * @version 1.0
 * @since 6/04/2020
 *
 */
public interface IDBCredentials {
	
	   /**
	    * JDBC driver name 
	    */
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   /**
	    * database URL (change it to your URL)
	    */
	   static final String DB_URL = "jdbc:mysql://localhost/mydb";
	   /**
	    * Database user name (change it to your user name)
	    */
	   static final String USERNAME = "root";
	   /**
	    * Database password (change it to your password)
	    */
	   static final String PASSWORD = "friedchicken007";

}
