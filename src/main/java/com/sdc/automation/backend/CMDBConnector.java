/* Author - Saira Akram
 * Creation Date - May 2018
 * Last Modified Date - August 2018
 */

package com.sdc.automation.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.sdc.automation.utilities.FileUtils;

public class CMDBConnector {

	private static String databaseURl;
	private static String userId;
	private static String password;
	public static String extractCmdbQuery;
	public static Connection globalCmdbConn;
	public static String CMDBCsvFile;
	public static FileWriter fw;

	public static void CmdbDataCheckNull() throws Exception {
		final Map<String, Integer> nullMap = FileUtils.hasNullData(CMDBCsvFile);
		if (!nullMap.isEmpty()) {
			throw new Exception("NULL VALUES PRESENT for columns " + nullMap.keySet());
		}
	}

	public static void extractData(String CMDBfileLocation) throws SQLException, InstantiationException,
	IllegalAccessException, ClassNotFoundException, IOException, FileNotFoundException {
		final String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		CMDBCsvFile = CMDBfileLocation + "CMDB_" + timeStamp + ".csv";
		final PrintWriter csvWriter = new PrintWriter(new File(CMDBCsvFile));
		final Statement stmt = CMDBConnector.globalCmdbConn.createStatement();
		final ResultSet rs = stmt.executeQuery(CMDBConnector.extractCmdbQuery);
		final ResultSetMetaData rsmd = rs.getMetaData();
		final StringBuilder sb = new StringBuilder();
		System.out.println("this is extractCMDBquery:" + extractCmdbQuery);
		final int columnsNumber = rsmd.getColumnCount();
		System.out.println("Total columns = " + columnsNumber);

		sb.append("\"" + rsmd.getColumnName(1) + "\"");
		for (int i = 2; i < columnsNumber + 1; i++) {

			sb.append(",\"" + rsmd.getColumnName(i).replaceAll("\"", "\\\"") + "\"");
		}
		sb.append('\n');

		while (rs.next()) {

			if (rs.getString(1) != null) {
				sb.append("\"" + rs.getString(1).replaceAll("\"", "\\\"") + "\"");
			} else {
				sb.append("" + null);
			}
			for (int i = 2; i <= columnsNumber; i++) {
				System.out.println("EACH ROW ==>" + rs.getString(i));
				if (rs.getString(i) != null) {
					sb.append(",\"" + rs.getString(i).replaceAll("\"", "\\\"") + "\"");
				} else {
					sb.append("," + null);
				}

			}

			sb.append('\n');
		}
		csvWriter.println(sb.toString());
		csvWriter.close();

		globalCmdbConn.close();

	}

	public static void setDatabaseURl(String databaseURl) {
		CMDBConnector.databaseURl = databaseURl;
	}

	public static void setExtractQuery(String extractCmdbQuery) {
		CMDBConnector.extractCmdbQuery = extractCmdbQuery;
	}

	public static void setPassword(String password) {
		CMDBConnector.password = password;
	}

	public static void setQuery(String query) {
	}

	public static void setUserId(String userId) {
		CMDBConnector.userId = userId;
	}

	public static void validateConnection()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		try {
			final Connection localCmdbConn = DriverManager.getConnection("jdbc:mariadb://" + CMDBConnector.databaseURl,
					CMDBConnector.userId, CMDBConnector.password);

			System.out.println("Connected to CMDB Database" + localCmdbConn);
			CMDBConnector.globalCmdbConn = localCmdbConn;
		} catch (final Exception e) {
			throw e;
		}
	}

}
