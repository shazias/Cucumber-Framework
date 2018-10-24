/* Author - Saira Akram
 * Creation Date - May 2018
 * Last Modified Date - August 2018
 */

package com.sdc.automation.backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

import com.sdc.automation.utilities.FileUtils;
import com.sdc.automation.utilities.MariaDbConnection;

public class DruidConnection {
	private static String jsonPath;
	private static String druidUrl;
	private static String fileName;
	private static Connection globalMariaConn;
	private static String globalMariaTable;

	public static void DruidDataCheckNull() throws Exception {
		final Map<String, Integer> nullMap = FileUtils.hasNullData(fileName);
		if (!nullMap.isEmpty()) {
			throw new Exception("NULL VALUES PRESENT for columns " + nullMap.keySet());
		}
	}

	public static void DruidDataDumpedtoMariaTable(String tableName) throws Exception {
		globalMariaTable=tableName;

		final BufferedReader rd =getDruidData(druidUrl, DruidConnection.jsonPath);
		final StringBuffer resultBuffer = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			resultBuffer.append(line);
		}
		//System.out.println("resultBuffer="+resultBuffer);
		String tempString=resultBuffer.toString().replaceAll("\"\"", "\"");
		resultBuffer.setLength(0);
		resultBuffer.append(tempString);
		tempString=null;

		final JSONArray output = new JSONArray(resultBuffer.toString());
		final Statement mariaStmt = globalMariaConn.createStatement();
		for (final Object eachDay : output) {
			final JSONObject eachDayJsonObj=(JSONObject)eachDay;
			final String timeStamp = eachDayJsonObj.getString("timestamp");
			final JSONArray result = eachDayJsonObj.getJSONArray("result");
			//System.out.println("timeStamp==" + timeStamp);
			//System.out.println("result==" + result);
			for(final Object eachDevice : result) {
				final JSONObject eachDeviceJsonObj=(JSONObject)eachDevice;
				//System.out.println(timeStamp+"--"+eachDeviceJsonObj.getString("device_devicename")+"------"+eachDeviceJsonObj.getLong("sum__used"));
				mariaStmt.executeUpdate("INSERT INTO "+tableName+" (table_name, device_name, datetime, capacity) "
						+"VALUES ('DRUID_BLOCK_CAPACITY','"+ eachDeviceJsonObj.getString("device_devicename")+"','"+  timeStamp.substring(0, 10)+"','"+ eachDeviceJsonObj.getLong("sum__used")+"')");
			}
		}




	}

	public static void DruidNumberVariation(int druidNumberVariation) throws Exception {
		final Statement mariaStmt = globalMariaConn.createStatement();
		final String query="SELECT distinct a.table_name,a.device_name ,a.datetime,  (a.capacity-COALESCE(b.capacity,0))/a.capacity*100.0 as capacity_difference FROM "+globalMariaTable+" a , "+globalMariaTable+" b	where a.datetime-1  =b.datetime  and a.datetime in (select max(datetime) from "+globalMariaTable+")";
		final ResultSet rs = mariaStmt.executeQuery(query);
		while (rs.next()) {
			if( Math.abs(rs.getInt(4))>=druidNumberVariation) {
				throw new Exception("Variation is "+rs.getInt(4)+" greater than threshold for "+rs.getString(1)+" AND "+rs.getString(2)+" DATE "+rs.getString(4));
			}

		}
	}

	public static void DruidVariationForLastTwoDays(int variationTreshold) throws Exception {
		final Statement mariaStmt = globalMariaConn.createStatement();
		final String query="SELECT distinct a.table_name,a.device_name ,a.datetime,  (a.capacity-COALESCE(b.capacity,0))/a.capacity*100.0 as capacity_difference FROM "+globalMariaTable+" a , "+globalMariaTable+" b	where a.datetime-1  =b.datetime  and a.datetime in (select max(datetime) from "+globalMariaTable+")";
		final ResultSet rs = mariaStmt.executeQuery(query);
		while (rs.next()) {
			if( Math.abs(rs.getInt(4))>=variationTreshold) {
				throw new Exception("Variation is "+rs.getInt(4)+" greater than threshold for "+rs.getString(1)+" AND "+rs.getString(2)+" DATE "+rs.getString(4));
			}

		}
	}
	public static void dumpData() throws Exception {
		System.out.println("connectionURl:" + druidUrl + "jsonPath" + jsonPath);
		final BufferedReader rd =getDruidData(druidUrl, DruidConnection.jsonPath);

		StringBuffer resultBuffer = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			resultBuffer.append(line);
		}

		String tempString=resultBuffer.toString().replaceAll("\"\"", "\"");
		if(tempString.contains("[")&&tempString.contains("]")) {
			tempString=tempString.substring(tempString.indexOf("[")+1, tempString.lastIndexOf("]"));
		}
		resultBuffer=resultBuffer.insert(0, tempString);
		tempString=null;

		final JSONObject output = new JSONObject(resultBuffer.toString());

		output.getString("timestamp");
		final JSONObject result = output.getJSONObject("result");
		final JSONArray events = result.getJSONArray("events");

		final JSONArray eventArray = new JSONArray();
		for (final Object eventObj : events) {
			final JSONObject event = (JSONObject) eventObj;

			eventArray.put(event.getJSONObject("event"));
		}

		final PrintWriter out = new PrintWriter(DruidConnection.fileName);
		out.println(CDL.toString(eventArray));
		out.close();

		final Pattern p = Pattern.compile("event");
		final Matcher m = p.matcher(result.toString());
		int count = 0;
		while (m.find()) {
			count += 1;
		}
		if (count != 0) {
			System.out.println("The data is NOT NULL because row count = " + count);
		} else {
			System.out.println("The data is NULL because row count = " + count);
		}

	}

	private static BufferedReader getDruidData(String url,String jsonPath) throws Exception {
		final String content = new String(Files.readAllBytes(Paths.get(jsonPath)));

		final HttpClient client = HttpClientBuilder.create().build();

		final HttpPost post = new HttpPost(url);

		post.addHeader("Accept", "application/json");
		post.addHeader("charset", "UTF-8");
		post.addHeader("Content-Type", "application/json");
		post.setEntity(new StringEntity(content));

		final HttpResponse response = client.execute(post);

		return new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	}

	public static void maridDBConnectionEstablished(String mariaDbUrl) throws Exception {
		globalMariaConn=MariaDbConnection.getConnection(mariaDbUrl)		;
	}

	public static void setDruidUrl(String druidUrl) {
		DruidConnection.druidUrl = druidUrl;
	}

	public static void setFileLocation(String fileLocation) {
		DruidConnection.fileName = FileUtils.getDynamicFileName(fileLocation, "DRUID");
	}
	public static void setJsonPath(String jsonPath) {
		DruidConnection.jsonPath = jsonPath;
	}
}
