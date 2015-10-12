package com.rojaware.members;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;  
import java.util.Properties;  
import java.io.InputStream;  
  
public  class DBManager  
{  
    private  static Connection connection = null;  
    private static DBManager dbmanager;  
      
   private DBManager()throws Exception  
   {  
        if (connection == null)  
        {  
            //System.out.println("MySQL Connect Example.");  
  
            String CONFIG_FILE_NAME = "mysql.properties";  
            Properties dbProperties;  
            try  
            {  
                dbProperties = new Properties();  
                Class thisClass = Class.forName("dbapps.DBManager");  
                InputStream is = thisClass.getResourceAsStream(CONFIG_FILE_NAME);  
                dbProperties.load(is);  
  
                String url = "jdbc:mysql://"+dbProperties.getProperty("host")+":"+dbProperties.getProperty("port")+"/";  
                String dbName = dbProperties.getProperty("schema")+"?useUnicode=yes&characterEncoding=UTF-8";  
                String driver = "com.mysql.jdbc.Driver";  
                String userName = dbProperties.getProperty("username");  
                String password = dbProperties.getProperty("password");  
  
                Class.forName(driver).newInstance();  
                connection = DriverManager.getConnection(url + dbName, userName, password);  
               // System.out.println("Connected to the database");  
            }  
            catch (Exception e)  
            {  
                e.printStackTrace();  
                connection = null;  
                throw e;  
            }  
        }         
   }  
  
    public static Connection openDBConnection() throws Exception  
    {  
        dbmanager = new DBManager();  
     return connection;  
    }  
}  