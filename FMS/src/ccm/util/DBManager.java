package ccm.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/***************************
 * 
 * 
 * 디비매니저(연결과 해제를 하는 기능으로 구성된 클래스이다)
 * 
 * 작성자 : 
 * 
 * 수정자 : 
 * 
 * 수정일 : 
 *
 *
 ***************************/

public class DBManager
{
	public static Connection getConnection()
	{
		Connection conn = null;

		try
		{
//			 Context initContext = new InitialContext();
//			 Context envContext = (Context) initContext.lookup("java:/comp/env");

			// jdbc/myoracle이란 이름의 객체를 찾아서 DataSource가 받는다.
//			 DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");

			// ds가 생성되었으므로 Connection을 구합니다.
//			conn = ds.getConnection();
			Class.forName("org.gjt.mm.mysql.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://ccmfmsmysqlserver.mysql.database.azure.com:3306/fms?useSSL=true&requireSSL=false", 
	                                    "ccmadmin@ccmfmsmysqlserver", "ccmfmsmysqladmin1234!");
	         System.out.println("DB 연결 성공 :  " + conn);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	// select를 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt, ResultSet... rs)
	{
		try
		{
			stmt.close();
			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// DML(insert, update, delete)을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt)
	{
		try
		{
			stmt.close();
			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}