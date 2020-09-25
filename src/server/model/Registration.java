package server.model;
/**
 * This class deals with registering a student into a class.
 * 
 * @author Bhavdeep Purba, Moiz Abdullah, Rifat Haque
 * @version 1.0
 * @since 6/04/2020
 * 
 */
public class Registration {
	/**
	 * Student Name.
	 */
	private Student theStudent;
	/**
	 * The course.
	 */
	private CourseOffering theOffering;
	/**
	 * Student Grade.
	 */
	private char grade;
	
	/**
	 * Constructor for Registration.
	 * @param st Student name.
	 * @param of Course Offering.
	 */
	public Registration(Student st, CourseOffering of) {
		completeRegistration (st, of);
	}
	
	/**
	 * Complete Registration.
	 * @param st Student name.
	 * @param of Course Offering.
	 */
	public void completeRegistration (Student st, CourseOffering of) {
		theStudent = st;
		theOffering = of;
		addRegistration ();
	}
	
	/**
	 * Add Registration.
	 */
	private void addRegistration () {
		theOffering.addRegistration(this);
	}

	/**
	 * ToString method for registration.
	 */
	@Override
	public String toString () {
		String st = "\n";
		st += "Student Name: " + getTheStudent() + "\n";
		st += "The Offering: " + getTheOffering () + "\n";
		st += "Grade: " + getGrade();
		st += "\n-----------\n";
		return st;
		
	}

	/**
	 * View All Courses Taken By Student.
	 * @return All courses taken by student.
	 */
	public String viewAllCoursesTakenByStudent() {
		return theOffering.viewAllCoursesTakenByStudent();
	}

	/**
	 * Remove Registration.
	 */
	public void terminate() {
		theOffering.removeRegistration(this);
	}
	
	//Setters and Getters.
	public Student getTheStudent() {
		return theStudent;
	}
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
}
