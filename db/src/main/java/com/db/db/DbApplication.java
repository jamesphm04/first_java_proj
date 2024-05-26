package com.db.db;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DbApplication {

	public static void main(String[] args) throws SQLException {
		String sql = "SELECT * FROM job_postings_fact";
		String url = "jdbc:postgresql://localhost:5432/sql_course";
		String username = "postgres";
		String password = "12341234";
		Connection con = DriverManager.getConnection(url, username, password);

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		// Get metadata to retrieve column information
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		// Print column names
		for (int i = 1; i <= columnCount; i++) {
			System.out.print(rsmd.getColumnName(i) + "\t");
		}
		System.out.println();

		int j = 0;
		// Print rows
		while (rs.next() && j <= 100) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			j++;
			System.out.println();
		}

		// Close resources
		rs.close();
		st.close();
		con.close();
	}

}
