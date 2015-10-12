package com.rojaware.member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

public class BaseDao {

	public Connection con = null;
	public PreparedStatement ptmt = null;
	public ResultSet rs = null;
	
	public BaseDao() {
		super();
	}

	
	protected Connection getConnection() throws SQLException {
		 con = ConnectionFactory.getInstance().getConnection();
		return con;
	}
	
	private String convetBlobToString(Blob blob) {
			
			
			StringBuffer buffer = new StringBuffer();
			InputStream byteStream = null;
	
			try {
	
			byteStream = blob.getBinaryStream();
			byte[] byteArray = new byte[2048];
			int numOfByteRead = 0;
			int bytesRead = -1;
			while((bytesRead = byteStream.read(byteArray))!=-1){
	//		buffer.append(new String(byteArray,0,bytesRead,"euc-kr"));
			buffer.append(new String(byteArray,0,bytesRead,"UTF-8"));
			numOfByteRead += bytesRead;
			}
			}
			catch (Exception e) {
			e.printStackTrace();
			}finally{
			if(byteStream!=null){
			try {
			byteStream.close();
			}
			catch (IOException e) {
			e.printStackTrace();
			}
			}
	
			}
	
			String blobString = buffer.toString(); 
			return blobString;
		}
		//http://blog.daum.net/sadest/15853468
	//	public String convertStringToBlob(String inString){
	//		Connection conn = getConnection();
	//		 try{
	//		  byte[] blobDataWritten = null;
	//		  PreparedStatement pstmt = conn.prepareStatement("insert into " + TABLE_NAME + " values (?, null, ?)");
	//		  StringBuffer myStrBuf = new StringBuffer();
	//		  for (int i = 0; i <= 1024; i++) {
	//		   myStrBuf.append(inString.valueOf(i));
	//		  }
	//		  String myString = myStrBuf.toString();
	//		  blobDataWritten = myString.getBytes();
	//		  System.out.println("Length of Blob to be inserted: " + blobDataWritten.length);
	//		  pstmt.setLong(1, 1);
	//
	//		  ByteArrayInputStream bais = new ByteArrayInputStream(blobDataWritten);
	//		  pstmt.setBinaryStream(2, bais, blobDataWritten.length);
	//		  int insertstatus= pstmt.executeUpdate();
	//
	//		  System.out.println("\nBlob successfully inserted. Num Rows Inserted: " + insertstatus + " \n");
	//		  pstmt.close();
	//		  bais.close();
	//		  conn.close();
	//		 } catch (Throwable t) {
	//		  t.printStackTrace();
	//		 }
	// 	}
	//	
		/*
		 * http://stackoverflow.com/questions/5398133/jdbc-how-to-insert-mysql-set-type
		 * create table clt (id bigint not null, sources set('A1', 'empty', 'A2', 'A3'), text varchar(50));
	
	java.sql.PreparedStatement stmt = null;
	String query = "insert into clt (id, sources, text) values (?, ?, ?)";
	stmt = conn.prepareStatement(query);
	int it = 0;
	stmt.setLong(++it, 25);
	stmt.setString(++it, "A1, A2");
	stmt.setString(++it, "some text data");
	stmt.executeUpdate();
	
		 */
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


	public static String  removeEmptylines (String text)
	{

		String adjusted = text.replaceAll("(?m)^[ \t]*\r?\n", "");
		return adjusted;
	}
}