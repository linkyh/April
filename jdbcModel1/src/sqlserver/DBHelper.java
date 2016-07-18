package sqlserver;

import java.sql.*;


public class DBHelper {
	private static final String DiverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=test";
	private static final String userName="sa";
	private static final String passWord="lhy12345";
	
	private static Connection conn=null;
	
	static{
		try{
			Class.forName(DiverName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection()throws Exception{
		if(conn==null){
			conn=DriverManager.getConnection(DBURL, userName, passWord);
			return conn;
		}
		else
			return conn;
		
	}
	public static void main(String[] args){
		try{
			Connection conn=DBHelper.getConnection();
			if(conn!=null){
				System.out.print("连接正常！");
			}
			else{
				System.out.print("连接异常！");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
