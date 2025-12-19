package com.snowflake.util;

import static com.snowflake.snowpark.functions.col;
import static com.snowflake.snowpark.functions.lit;

import com.snowflake.snowpark.Column;
import com.snowflake.snowpark.Session;

public class SnowflakeDataFrame {

    public static void main(String[] args) {

        Session session = SnowparkSessionUtil.createSession();

        /* =========================
           READ ENTIRE TABLE
        ========================== */
        System.out.println("\n===== ALL EMPLOYEES =====");
        session.table("EMPLOYEE").show();

     // Filter by ID
   //     session.table("EMPLOYEE")
//               .filter(col("ID").equal_to(lit(1)))
//               .select(col("ID"), (Seq<Column>) col("NAME"))
//               .show();
        session.table("EMPLOYEE")
        .select(new Column[]{ col("ID"), col("NAME") })
        .show();
        

        // Java Developers
        session.table("EMPLOYEE")
               .filter(col("DEPARTMENT").equal_to(lit("Java Developer")))
               .show();

        // Not HR
        session.table("EMPLOYEE")
               .filter(col("DEPARTMENT").not_equal(lit("HR")))
               .show();

        // Name starts with S
//        session.table("EMPLOYEE")
//               .filter(col("NAME").like("S%"))
//               .show();
        session.sql("SELECT * FROM EMPLOYEE WHERE NAME LIKE 'S%'").show();

        // HR or Finance
        session.table("EMPLOYEE")
               .filter(col("DEPARTMENT").equal_to(lit("HR"))
                       .or(col("DEPARTMENT").equal_to(lit("Finance"))))
               .show();

        // ID in (1,2,3)
//        session.table("EMPLOYEE")
//               .filter(col("ID").in(1, 2, 3))
//               .show();
        
        session.sql("SELECT * FROM EMPLOYEE WHERE ID IN (1,2,3)").show();

        /* =========================
           COUNT PER DEPARTMENT (SQL)
        ========================== */
        System.out.println("\n===== EMPLOYEE COUNT PER DEPARTMENT =====");
        session.sql(
            "SELECT DEPARTMENT, COUNT(*) AS EMP_COUNT " +
            "FROM EMPLOYEE GROUP BY DEPARTMENT"
        ).show();

        /* =========================
           UPDATE USING SQL
        ========================== */
        session.sql(
            "UPDATE EMPLOYEE SET NAME = 'Amit Kumar' WHERE ID = 2"
        ).collect();

        /* =========================
           DELETE USING SQL
        ========================== */
        session.sql(
            "DELETE FROM EMPLOYEE WHERE ID = 3"
        ).collect();

        /* =========================
           FINAL DATA
        ========================== */
        System.out.println("\n===== FINAL EMPLOYEE DATA =====");
        session.table("EMPLOYEE").show();

        session.close();
        System.out.println("\n===== SESSION CLOSED =====");
    }
}
