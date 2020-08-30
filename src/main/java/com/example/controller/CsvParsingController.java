package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CsvParsingController {

	
	@RequestMapping(value = "/parsePatient", method = RequestMethod.POST)
	@ResponseBody
	public String parsePatientCsvString(@RequestBody String csvData) {
		return parsePatientCsv(csvData);
	}

	
	private String parsePatientCsv(String csvData) {
		if (csvData == null) {
			return "";
		}
		String returnString = "";

		// Replace '\r\n newLineCharacters with '\n' and trim off extra whitespace
		csvData = csvData.replace("\r\n", "\n").trim() + ",";
		
		// Build new String
		int characterIndex = 0;
		for (int i = 0; i < csvData.length(); i++) {
			if (csvData.charAt(i) == ',' || csvData.charAt(i) == '\n') {
				// Create temporary String
				String segment = csvData.substring(characterIndex, i).trim();
				if (segment.startsWith("\"") && segment.endsWith("\"")) {
					returnString += "[" + segment + "]";
					characterIndex = i + 1;
				} else if (isInteger(segment)) {
					returnString += "[" + segment + "]";
					characterIndex = i + 1;
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
	 
	 private boolean isInteger(String s) {
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