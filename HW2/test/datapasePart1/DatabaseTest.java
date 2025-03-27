package datapasePart1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.User;
import databasePart1.DatabaseHelper;

public class DatabaseTest {
	
	/**
	 * Method that initiates database tests!
	 * 
	 * @param args
	 * @throws SQLException
	 */
	
	public static void main(String[] args) throws SQLException {
		
		
		performTests();
		
	}
	/**
	 * Class designated to execute database test cases
	 * and display results in console 
	 * 
	 * 
	 * @throws SQLException
	 */
	
	private static void performTests() throws SQLException {
		String testResults = "\nDatabase Test \n";
		
		
		// Create database reference
		DatabaseHelper databaseHelper = new DatabaseHelper();
        databaseHelper.connectToDatabase(); // Connects to the database
		
        // Tests
        testResults += performGeneralTests(databaseHelper);
     
        testResults += performListExistingUsersTests(databaseHelper);
		
		System.out.println(testResults);
		
		// Deletes database at the end (for testing purposes only)
		databaseHelper.deleteDatabase();
		/**
		 * This method was created to help clear the database for future testing
		 * 
		 * @throws SQLException
		 * @param
		 */
	}
	
	private static String performGeneralTests(DatabaseHelper databaseHelper) throws SQLException {
		String testResults = "\nGeneral Tests:\n";
		
		// Tests
		testResults += resetDatabaseTest(databaseHelper);
		
		return testResults;
	}
	
	private static String performListExistingUsersTests(DatabaseHelper databaseHelper) throws SQLException {
		String testResults = "\nList Existing Users Tests:\n";
		
		// Delete database and reconnect
		databaseHelper.deleteDatabase();
        databaseHelper.connectToDatabase();
		
		// Tests
		testResults += listEmptyDatabase(databaseHelper);
		
		// Add admin
		ArrayList<String> adminList = new ArrayList<String>();
    	adminList.add("admin");
		User admin = new User("admin", "password", "admin", "admin@example.com", adminList);
		databaseHelper.register(admin);
		testResults += listJustAdmin(databaseHelper);
		
		// Add user with single role
		ArrayList<String> user1List = new ArrayList<String>();
    	user1List.add("student");
		User user1 = new User("user1", "Valid_123", "User One", "userone@gmail.com", user1List);
		databaseHelper.register(user1);
		testResults += listUserSingleRole(databaseHelper);
		
		// Add user with multiple roles
		ArrayList<String> user2List = new ArrayList<String>();
    	user2List.add("student");
    	user2List.add("instructor");
    	user2List.add("staff");
    	user2List.add("reviewer");
		User user2 = new User("user2", "Valid_123FOUR", "User Two", "usertwo@gmail.com", user2List);
		databaseHelper.register(user2);
		testResults += listUserMultipleRoles(databaseHelper);
		
		return testResults;
	}
	
	private static String resetDatabaseTest(DatabaseHelper databaseHelper) throws SQLException {
		// Delete database and reconnect
		databaseHelper.deleteDatabase();
        databaseHelper.connectToDatabase();
		
		if (databaseHelper.isDatabaseEmpty()) {
			return "Reset database: PASSED\n";
		}
		
		return "Reset database: FAILED\n ";
	}
	
	private static String listEmptyDatabase(DatabaseHelper databaseHelper) throws SQLException {
		
		if (databaseHelper.getAllUsersList().isEmpty()) {
			return "List Empty Database: PASSED\n";
		}
		
		return "List Empty Database: FAILED\n";
	}
	
	private static String listJustAdmin(DatabaseHelper databaseHelper) throws SQLException {
		
		List<User> userList = databaseHelper.getAllUsersList();
		if (userList.size() == 1 && userList.get(0).getUserName().equals("admin")
				&& userList.get(0).getRole().get(0).equals("admin")) {
			return "Just Admin in List: PASSED\n";
		}
		
		return "Just Admin in List: FAILED\n";
	}
	
	private static String listUserSingleRole(DatabaseHelper databaseHelper) throws SQLException {
		
		List<User> userList = databaseHelper.getAllUsersList();
		if (userList.size() == 2 && userList.get(1).getUserName().equals("user1")
				&& userList.get(1).getRoleString().equals("student")) {
			return "User with Single Role: PASSED\n";
		}
		
		return "User with Single Role: FAILED\n";
	}
	
	private static String listUserMultipleRoles(DatabaseHelper databaseHelper) throws SQLException {
		
		List<User> userList = databaseHelper.getAllUsersList();
		if (userList.size() == 3 && userList.get(2).getUserName().equals("user2")
				&& userList.get(2).getRoleString().equals("student, instructor, staff, reviewer")) {
			return "User with Multiple Roles: PASSED\n";
		}
		
		return "User with Multiple Roles: FAILED\n";
	}
	
}