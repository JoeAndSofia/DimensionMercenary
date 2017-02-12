package util.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBUtilSqlite {
	private String databaseName = null;
	public Connection con = null;
	
public static int instanceCount = 0;
	
	private static Map<String, DBUtilSqlite> utils = new HashMap<String, DBUtilSqlite>();
	
	private DBUtilSqlite(String databaseName){
		this.databaseName = databaseName;
		con();
		instanceCount++;
	}
	
	public static DBUtilSqlite getInstance(String databaseName){
		if(utils.get(databaseName)!=null){
			return utils.get(databaseName);
		}else{
			DBUtilSqlite util = new DBUtilSqlite(databaseName);
			utils.put(databaseName, util);
			return util;
		}
	}
	
	private void con(){
		try{
			if(con==null || !(con instanceof Connection)){
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:./db/" + this.databaseName + ".db");
				System.out.println(this.databaseName+" connected");
			}			
		}catch(Exception e){
			throw new RuntimeException("DBUtil: " + e.getMessage());
		}finally{
			
		}
	}
	
}
