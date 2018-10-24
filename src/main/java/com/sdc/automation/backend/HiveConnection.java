/* Author - Saira Akram
 * Creation Date - May 2018
 * Last Modified Date - August 2018
 */
package com.sdc.automation.backend;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.sdc.automation.utilities.FileUtils;
import com.sdc.automation.utilities.MariaDbConnection;

/**
 * @author Saira Akram
 *
 */
public class HiveConnection {


	private static final String driverName = "org.apache.hive.jdbc.HiveDriver";
	private static String databaseURl;
	private static String userId;
	private static String password;
	private static Connection globalHiveConn;
	private static String fileName;
	private static String extractHiveQuery;
	private static Connection globalMariaConn;
	private static String globalMariaTable;


	public static void ConnectHive() throws Exception {

		try {
			Class.forName(driverName);

			final Connection localHiveConn = DriverManager.getConnection("jdbc:hive2://" + HiveConnection.databaseURl,HiveConnection.userId, HiveConnection.password);

			HiveConnection.globalHiveConn = localHiveConn;
		} catch (final Exception e) {
			throw e;
		}

	}

	public static void HiveDataCheckNull() throws Exception {
		final Map<String, Integer> nullMap = FileUtils.hasNullData(fileName);
		if (!nullMap.isEmpty()) {
			throw new Exception("NULL VALUES PRESENT for columns " + nullMap.keySet());
		}
	}

	public static void HiveDataDumpedtoMariaTable(String tableName) throws Exception {
		globalMariaTable=tableName;
		final Statement hiveStmt = HiveConnection.globalHiveConn.createStatement();
		final ResultSet rs = hiveStmt.executeQuery(HiveConnection.extractHiveQuery);
		rs.getMetaData();
		final Statement mariaStmt = globalMariaConn.createStatement();
		while (rs.next()) {
			mariaStmt.executeUpdate("INSERT INTO "+tableName+" (table_name, device_name, datetime, capacity) "
					+"VALUES ('"+rs.getString(1)+"','"+ rs.getString(2)+"','"+  rs.getString(3)+"','"+ rs.getDouble(4)+"')");
		}
	}

	public static void HiveExtractData(String HiveFilelocation) throws FileNotFoundException, SQLException {

		fileName = FileUtils.getDynamicFileName(HiveFilelocation,"HIVE");
		final PrintWriter csvWriter = new PrintWriter(new File(fileName));
		final Statement stmt = HiveConnection.globalHiveConn.createStatement();
		final ResultSet rs = stmt.executeQuery(HiveConnection.extractHiveQuery);
		final ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("Rs is"+rs);
		final StringBuilder sb = new StringBuilder();
		final int columnsNumber = rsmd.getColumnCount();
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

		globalHiveConn.close();
	}

	public static void HiveNumberVariation(int numberVariationTreshold) throws Exception {
		final Statement mariaStmt = globalMariaConn.createStatement();
		final String query="SELECT distinct a.table_name,a.device_name ,a.datetime,  (a.capacity-COALESCE(b.capacity,0))/a.capacity*100.0 as capacity_difference FROM "+globalMariaTable+" a , "+globalMariaTable+" b	where a.datetime-1  =b.datetime  and a.datetime in (select max(datetime) from "+globalMariaTable+")";
		final ResultSet rs = mariaStmt.executeQuery(query);
		while (rs.next()) {
			if( Math.abs(rs.getInt(4))>=numberVariationTreshold) {
				throw new Exception("Variation is "+rs.getInt(4)+" greater than threshold for "+rs.getString(1)+" AND "+rs.getString(2)+" DATE "+rs.getString(4));
			}

		}
	}

	public static void HiveVariationForLastTwoDays(int variationTreshold) throws Exception {
		final Statement mariaStmt = globalMariaConn.createStatement();
		final String query="SELECT distinct a.table_name,a.device_name ,a.datetime,  (a.capacity-COALESCE(b.capacity,0))/a.capacity*100.0 as capacity_difference FROM "+globalMariaTable+" a , "+globalMariaTable+" b	where a.datetime-1  =b.datetime  and a.datetime in (select max(datetime) from "+globalMariaTable+")";
		final ResultSet rs = mariaStmt.executeQuery(query);
		while (rs.next()) {
			if( Math.abs(rs.getInt(4))>=variationTreshold) {
				throw new Exception("Variation is "+rs.getInt(4)+" greater than threshold for "+rs.getString(1)+" AND "+rs.getString(2)+" DATE "+rs.getString(4));
			}

		}
	}


	public static void maridDBConnectionEstablished(String mariaDbUrl) throws Exception {
		globalMariaConn=MariaDbConnection.getConnection(mariaDbUrl);
	}

	public static void setDatabaseURl(String databaseURl) {
		HiveConnection.databaseURl = databaseURl;
	}

	public static void setHiveExtractQuery(String extractHiveQuery) {
		HiveConnection.extractHiveQuery = extractHiveQuery;
	}

	public static void setPassword(String password) {
		HiveConnection.password = password;
	}

	public static void setQuery(String query) {
	}
	public static void setUserId(String userId) {
		HiveConnection.userId = userId;
	}

}
