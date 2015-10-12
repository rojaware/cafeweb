package com.rojaware.member.dao;


	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class ConnectionFactory
	{
	 String driverClassName="com.mysql.jdbc.Driver";
	 String uniCode = "?useUnicode=true&characterEncoding=euc_kr";
	 String connectionUrl="jdbc:mysql://localhost:3306/mapleedu"+uniCode;
	 String dbUser="root";
	 String dbPwd="";
	 
	 private static ConnectionFactory connectionFactory=null;
	 
	 private ConnectionFactory()
	 {
	  try
	  {
	   Class.forName(driverClassName);
	  }
	  catch(ClassNotFoundException e)
	  {
	   e.printStackTrace();
	  }
	 }
	 
	 public Connection getConnection() throws SQLException
	 {
	  Connection conn=null;
	  conn=DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
	  return conn;
	 }
	 
	 public static ConnectionFactory getInstance()
	 {
	  if(connectionFactory==null)
	  {
	   connectionFactory=new ConnectionFactory();
	  }
	  return connectionFactory;
	 }
	}
	/*
	 * quick_view` AS
    select 
        `g4_write_appclientforscott`.`wr_subject` AS `name`,
        `g4_write_appclientforscott`.`wr_email` AS `email`,

        `g4_write_appclientforscott`.`wr_phone` AS `phone`,
        `g4_write_appclientforscott`.`wr_2` AS `wr_2`,
        `g4_write_appclientforscott`.`wr_3` AS `wr_3`,
        `g4_write_appclientforscott`.`wr_10` AS `wr_10`,
        `g4_write_appclientforscott`.`wr_content` AS `comment`,        
`g4_write_appclientforscott`.`wr_latitude` AS `expiry`
    from
        `g4_write_appclientforscott`
        */
