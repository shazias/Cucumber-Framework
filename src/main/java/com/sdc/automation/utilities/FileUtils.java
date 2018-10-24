/* Author - Saira Akram
 * Creation Date - May 2018
 * Last Modified Date - August 2018
 */
package com.sdc.automation.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author asaira
 *
 */
public class FileUtils {

	public static String getDynamicFileName(String path, String filePrefix)
	{
		return path + filePrefix +'_'+ new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".csv";
	}
	public static Map<String,Integer> hasNullData(String fileLocation) throws IOException {

		String line = "";
		final String cvsSplitBy = ",";
		final BufferedReader br = new BufferedReader(new FileReader(fileLocation));
		int lineNumber = 0;
		final List<String> headers = new ArrayList<>();
		final Map<String, Integer> nullCountMap = new HashMap<>();
		while ((line = br.readLine()) != null) {
			if (lineNumber == 0) {
				final String[] columns = line.split(cvsSplitBy);
				for (final String column : columns) {
					headers.add(column);
				}
				lineNumber++;
			} else if(line.contains(cvsSplitBy)) {
				final String[] columns = line.split(cvsSplitBy,-1);

				for (int i =0; i < columns.length; i++) {
					if (columns[i].equalsIgnoreCase("null")||columns[i].equalsIgnoreCase("\"null\"") || columns[i] == null ||columns[i].equals("")) {

						if (nullCountMap.containsKey(headers.get(i))) {
							nullCountMap.put(headers.get(i), nullCountMap.get(headers.get(i)) + 1);
						} else {
							nullCountMap.put(headers.get(i), 1);
						}

					}
				}

			}
			br.close();
		}
		System.out.println("NULL MAP" + nullCountMap.toString());
		System.out.println("NULL MAP SIZE" + nullCountMap.size());

		return nullCountMap;

	}

	public FileUtils() {

	}
}
