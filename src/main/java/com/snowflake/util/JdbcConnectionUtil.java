package com.snowflake.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcConnectionUtil {

	public static Connection getConnection() throws Exception {

        Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");

        String url = "jdbc:snowflake://vuxbtlk-iv14475.snowflakecomputing.com";

        Properties props = new Properties();
        props.put("user", "prashantdolnar");
        props.put("password", "Prashantdolnar@123");
        props.put("role", "SYSADMIN");
        props.put("warehouse", "JAVA_WH");
        props.put("db", "JAVA_DB");
        props.put("schema", "PUBLIC");


        return DriverManager.getConnection(url, props);
    }
}
