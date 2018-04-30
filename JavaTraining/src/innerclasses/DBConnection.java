package innerclasses;

/* Example of how you can use a static nested class as a cache for a Database Connection */

class DBConnection {
	
	public DBConnection(String username, String password, String URL) {
		// code to establish a Database connection
	}
	
	public DBConnection MyDBConnection(String username, String password, String URL) {
		DBConnection conn = DBConnectionCache.getDefaultMyDBConnection();
		if (conn != null) {
			return conn;
		}
		else {
			//establish and return new DBconnection using method parameters
		}
		return conn;
	}
	
   /*
	* Static nested class that stores DB connections in a static array.
	*/
	static class DBConnectionCache {
		static DBConnection connections[];
		static {
			connections = new DBConnection[3];
			connections[0] = new DBConnection("user1", "pass1", "mydb.com");
			connections[1] = new DBConnection("user2", "pass2", "otherdb.com");
		}
		static DBConnection getDefaultMyDBConnection() {
			return connections[0];
		}
		static DBConnection getDefaultOtherDBConnection() {
			return connections[1];
		}
	}
}
