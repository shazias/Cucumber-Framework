/* Author - Saira Akram
 * Creation Date - July 2018
 * Last Modified Date - August 2018
 */
package com.sdc.automation.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.sdc.automation.utilities.FileUtils;

public class HDCAConnector {
	private static String connectionURl;
	private static String authorisation;
	private static String resource;
	private static String query;
	private static String startTime;
	private static String endTime;
	private static String filePath;
	private static StringBuffer HdcaContent;

	public static void checkNull() throws Exception {

		if (HDCAConnector.HdcaContent.toString().contains("null")
				|| HDCAConnector.HdcaContent.toString().contains("NULL")) {
			throw new Exception("NULL VALUE Present in " + HDCAConnector.filePath);
		}

	}

	public static void connect() throws Exception {

		try {
			System.out.println("HDCA Connection Starts");
			setIgnoreCerts();

			final URL url = new URL(HDCAConnector.connectionURl);
			final HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Authorization", HDCAConnector.authorisation);
			con.setRequestMethod("POST");
			con.setDoOutput(true);

			con.setRequestProperty("Content-Type", "Content-Type:application/json");
			con.connect();
			final String HDCAquery = "{\"query\":\"" + HDCAConnector.resource + " " + HDCAConnector.query
					+ "\",\"startTime\":\"" + HDCAConnector.startTime + "\",\"endTime\":\"" + HDCAConnector.endTime
					+ "\"}";

			final OutputStream os = con.getOutputStream();
			os.write(HDCAquery.getBytes());
			os.flush();
			readResponse(con);

		} catch (final Exception e) {
			throw e;
		}
	}

	private static void readResponse(HttpURLConnection con) throws Exception {
		try {
			final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			final StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			HdcaContent = content;
			in.close();
		} catch (final Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void setAuthorisation(String authorisation) {
		HDCAConnector.authorisation = authorisation;
	}

	public static void setConnectionURl(String connectionURl) {
		HDCAConnector.connectionURl = connectionURl;
	}

	public static void setEndTime(String endTime) {
		HDCAConnector.endTime = endTime;
	}

	public static void setFilePath(String filePath) throws Exception {
		HDCAConnector.filePath = FileUtils.getDynamicFileName(filePath, HDCAConnector.resource);
		System.out.println("filePath===" + HDCAConnector.filePath);
		PrintWriter csvWriter = null;
		try {
			csvWriter = new PrintWriter(new File(HDCAConnector.filePath));
			csvWriter.println(HdcaContent.toString());

		} catch (final Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			csvWriter.close();
		}

	}

	private static void setIgnoreCerts() throws Exception {

		try {
			final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}

				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			} };

			final SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			final HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (final Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	public static void setQuery(String query) {
		HDCAConnector.query = query;
	}

	public static void setResource(String resource) {
		HDCAConnector.resource = resource;
	}

	public static void setStartTime(String startTime) {
		HDCAConnector.startTime = startTime;
	}

}
