package com.snowflake.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.snowflake.util.JdbcConnectionUtil;
@Service
public class SnowflakeDao {

	public String getVersion() throws Exception {
		try {
			Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
			 Connection conn = JdbcConnectionUtil.getConnection();
		        System.out.println("Connection Successful while getVersion..!");
		        Statement stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT CURRENT_VERSION()");
		        boolean next = rs.next();
		        String version = rs.getString(1);
		        System.out.println("Snowflake Version: " + version);
		        conn.close();
		        return version;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public List<Object> getEmployeeList() throws Exception {
    	List<Object> list = new ArrayList<>();
        Connection conn = JdbcConnectionUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from Employee;");
       while(rs.next()) {
    	   String obj=rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3);
    	   list.add(obj);
		}
        conn.close();
        return list;
    }

    public boolean updateNameById(String name) throws Exception {

    	System.out.println("employee Name: " + name);
        boolean status = false;
        String sql = "UPDATE EMPLOYEE SET NAME = ? WHERE ID = ?";
        try (Connection conn = JdbcConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, 1);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
