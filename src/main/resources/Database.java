package main.resources;

import main.resources.Admin;
import main.resources.Course;
import main.resources.Student;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Passive object representing the Database where all courses and users are stored.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add private fields and methods to this class as you see fit.
 */
public class Database {


	//to prevent user from creating new Database

	private Database() {
		// TODO: implement
	}
	private static Database singleton;

	private HashMap<Integer,Course> courselist;
	private HashMap<String,Admin> adminsList;
	private HashMap<String,Student> studentsList;


	/**
	 * Retrieves the single instance of this class.
	 */
	public static Database getInstance() {
		if (singleton==null)
			singleton= new Database();
		return singleton;
	}
	
	/**
	 * loades the courses from the file path specified 
	 * into the Database, returns true if successful.
	 */
	boolean initialize(String coursesFilePath) {
		courselist = new HashMap<Integer, Course>();
		adminsList = new HashMap<String, Admin>();
		studentsList = new HashMap<String, Student>();

		// TODO: implement
		// admin
		// students
		// courses
		return false;
	}

	public void RegisterAdmin (String username, String password)
	{
		if (adminsList.containsKey(username) | studentsList.containsKey(username))
			throw new IllegalArgumentException("username is already registered");
		adminsList.put(username,new Admin(username,password));

	}
	public void StudentRegister(String username, String password) {
		if (adminsList.containsKey(username) | studentsList.containsKey(username))
			throw new IllegalArgumentException("username is already registered");
		studentsList.put(username,new Student(username,password));

	}

	public void login(String username, String password) {
		// no such a user
		if (!adminsList.containsKey(username) & !studentsList.containsKey(username))
			throw new IllegalArgumentException("there is no such an user");
		User user=null;
		if (adminsList.containsKey(username))
			user = adminsList.get(username);
		if (studentsList.containsKey(username))
			user = studentsList.get(username);
		// wrong password
		if (user.getPassword()!=password)
			throw new IllegalArgumentException("wrong password");
		// already login
		if (user.getStatus())
			throw new IllegalArgumentException("the user is already logged in");
		// login
		user.login();
	}

	public void logout(String username, String password) {
		// no such a user
		if (!adminsList.containsKey(username) & !studentsList.containsKey(username))
			throw new IllegalArgumentException("there is no such an user");
		User user=null;
		if (adminsList.containsKey(username))
			user = adminsList.get(username);
		if (studentsList.containsKey(username))
			user = studentsList.get(username);
		// wrong password
		if (user.getPassword()!=password)
			throw new IllegalArgumentException("wrong password");
		// already login
		if (!user.getStatus())
			throw new IllegalArgumentException("the user is not logged in");
		// logout
		user.logout();
	}
	public void registerToCourse(int courseNumber)
	{
		// no such a course
		if (!courselist.containsKey(courseNumber))
			throw new IllegalArgumentException("no such a course");
		// no seats available
		Course course = courselist.get(courseNumber);
		if (course.getSeatsAvailable()==0)
			throw new IllegalArgumentException("no seats available");
		// student doesnt complete kdamCourse
		// the student isnt login
		if
		// admin cant register to course
	}
	public void kdamCourse(int courseNumber) {
		if (!courselist.containsKey(courseNumber))
			throw new IllegalArgumentException("there is not such a course");
		courselist.get(courseNumber).getKdam();

	}

	public void CourseStat(int courseNumber) {


	}

	public void studentStat(String username) {

	}

	public void isRegisterd(int courseNumber) {
	}

	public void unregister(int courseNumber) {
	}

	public void myCourses(int courseNumber) {
	}

}
