/* Author - Saira Akram
 * Creation Date - May 2018
 * Last Modified Date - August 2018
 */
package com.sdc.automation.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author asaira
 *
 */
public class MariaDbConnection {
	private static Connection connection = null;


	private static Connection createDatabaseConnection(String databaseUrl) throws Exception {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			return DriverManager.getConnection(databaseUrl);

		} catch (final Exception e) {
			throw e;
		}
	}

	public static Connection getConnection(String databaseUrl) throws Exception {
		if (connection == null) {
			synchronized (MariaDbConnection.class) {
				if (connection == null) {
					connection = createDatabaseConnection(databaseUrl);
				}
			}
		}
		return connection;
	}

}
