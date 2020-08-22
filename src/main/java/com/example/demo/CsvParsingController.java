package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CsvParsingController {

	@RequestMapping(value = "/parse", method = RequestMethod.POST)
	@ResponseBody
	public String angularServicePostCall(@RequestBody String csvData) {
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

}
