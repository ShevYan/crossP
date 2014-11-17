package com.crossp.jdbc.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppJDBCService {

	private Log log = LogFactory.getLog(getClass());
	
	private final String JOIN_CP = "insert into application_application(application_id, applications_id) values(?,?)";
	private final String BREAK_CP = "delete from application_application where application_id =? and applications_id =?";
	private final String SELECT_USER_APPS = "select * from application where user_id = ?";
	private final String MSG_READ_ONE = "update app_message set status = 1 where cid = ? and id = ?";
	private final String MSG_READ_ALL = "update app_message set status = 1 where cid = ?";

	@Autowired
	private DataSource dataSource;
	
	public void excuteUpdate(String sql) throws SQLException{
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		conn.close();
	}
	
	public void readMsgOne(long uid, long mid){
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(MSG_READ_ONE);
			pstmt.setLong(1, uid);
			pstmt.setLong(2, mid);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			log.error("SQL failed:", e);
		}		
	}
	
	public void readMsgALL(long uid){
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(MSG_READ_ALL);
			pstmt.setLong(1, uid);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			log.error("SQL failed:", e);
		}		
	}
		
	public void joinCP(int wid, int rid){
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(JOIN_CP);
			pstmt.setInt(1, wid);
			pstmt.setInt(2, rid);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			log.error("SQL CP failed:", e);
		}		
	}
	
	public void breakCP(int wid, int rid){
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(BREAK_CP);
			pstmt.setInt(1, wid);
			pstmt.setInt(2, rid);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			log.error("SQL CP failed:", e);
		}		
	}
}
