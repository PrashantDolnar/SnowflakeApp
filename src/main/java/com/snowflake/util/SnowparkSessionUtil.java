package com.snowflake.util;

import java.util.HashMap;
import java.util.Map;

import com.snowflake.snowpark.Session;

public class SnowparkSessionUtil {

	    public static Session createSession() {
	        Map<String, String> config = new HashMap<>();
	        config.put("URL", "https://vuxbtlk-iv14475.snowflakecomputing.com");
	        config.put("USER", "prashantdolnar");
	        config.put("PASSWORD", "Prashantdolnar@123");
	        config.put("ROLE", "SYSADMIN");
	        config.put("WAREHOUSE", "JAVA_WH");
	        config.put("DB", "JAVA_DB");
	        config.put("SCHEMA", "PUBLIC");
	
	        return Session.builder().configs(config).create();
	    }

}
