package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CsvParsingController {

	// Version 1 (completed Friday night)
	
	@RequestMapping(value = "/parse", method = RequestMethod.POST)
	@ResponseBody
	public String parseCsvString(@RequestBody String csvData) {
		return parseCsv(csvData);
	}

	
	// Because this controller only has a single purpose, I left the parsing method in here
	private String parseCsv(String csvData) {
		if (csvData == null) {
			return "";
		}
		String returnString = "";

		// Replace all relevant instances of separators to "|" and remove all other quotation marks
		csvData = csvData.replace("\r\n", "|\n").replace("\n", "|\n").replace(",\"", "|").replace("\",", "|").replace("\"", "").trim() + "|";

		// NOTE: I didn't use String.split(), because my auto-fill says it takes a regex, which is off-limits.

		// Build the new string
		int index = 0;
		for (int i = 0; i < csvData.length(); i++) {
			// Create a new item at each "|" and add it to the returnString
			if (csvData.charAt(i) == '|') {
				returnString += "[" + csvData.substring(index, i).trim() + "]";
				index = i + 1;
			}
			// Add the newline character here
			if (csvData.charAt(i) == '\n') {
				returnString += "\n";
			}
		}
		System.out.print(returnString);

		// Return new String
		return returnString;
	}
	
	// version 2 (Thought of this and added it Sunday morning)
	
	@RequestMapping(value = "/parse2", method = RequestMethod.POST)
	@ResponseBody
	public String parseCsvString2(@RequestBody String csvData) {
		return parseCsv2(csvData);
	}

	
	private String parseCsv2(String csvData) {
		if (csvData == null) {
			return "";
		}
		String returnString = "";

		csvData = csvData.replace("\r\n", "\n").trim() + ",";
		
		int index = 0;
		for (int i = 0; i < csvData.length(); i++) {
			if (csvData.charAt(i) == ',' || csvData.charAt(i) == '\n') {
				String segment = csvData.substring(index, i);
				if (segment.startsWith("\"") && segment.endsWith("\"")) {
					returnString += "[" + segment + "]";
					index = i + 1;
				} else if (isInt(segment)) {
					returnString += "[" + segment + "]";
					index = i + 1;
				}

			}
			// Add the newline character here
			if (csvData.charAt(i) == '\n') {
				returnString += "\n";
			}
		}
		returnString = returnString.replace("\"", "");
		return returnString;
	 }
	 
	 private boolean isInt(String s) {
	    if (s == null) {
	        return false;
	    }
	    try {
	        Integer.parseInt(s);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}


}