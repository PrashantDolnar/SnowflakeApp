package com.snowflake.util;
import java.sql.Connection;
import java.sql.Statement;

public class EmployeeJsonJdbcLoader {

    public static void main(String[] args) {

    	String jsonFilePath =
    		    "C:/Users/Prashant Dolnar/Desktop/snowflake_file_json/test.json";

       System.out.println("JSON File Path: " + jsonFilePath);
 	   try (Connection conn = JdbcConnectionUtil.getConnection();
             Statement stmt = conn.createStatement()) {


 				String putSql =
 				    "PUT 'file://" + jsonFilePath + "' @employee_json_stage AUTO_COMPRESS=TRUE";

 				System.out.println("PUT SQL => " + putSql);

 				stmt.execute(putSql);

 				String copySql =
 						" COPY INTO employee_raw (raw_json, file_name) "+
 								" FROM ( "+
 								" SELECT "+
 								" $1, "+
 								" METADATA$FILENAME "+
 								" FROM @employee_json_stage "+
 								" ) "+
 								" FILE_FORMAT = (FORMAT_NAME = json_ff) "+
 								" FORCE = TRUE; ";

 					stmt.execute(copySql);
 					System.out.println("JSON loaded into RAW table");
            System.out.println("JSON loaded into RAW table");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
