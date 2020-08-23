# henry-schein-test

Because the app is so small, I didn't bother to create proper MVC directories.
I didn't use String.split(), because my auto-fill says it takes a regex parameter, which is off-limits.
I'm certain there are other and better ways to do this, but because I couldn't use regex, this was the simplest solution I came up with during my short time tonight.

post this body into postman using this url: http://localHost:8080/parse

    "Patient Name","SSN","Age","Phone Number","Status"
    "Prescott, Zeke","542-51-6641",21,"801-555-2134","Opratory=2,PCP=1"
    "Goldstein, Bucky","635-45-1254",42,"435-555-1541","Opratory=1,PCP=1"
    "Vox, Bono","414-45-1475",51,"801-555-2100","Opratory=3,PCP=2"

Thanks!


Edit:
I completed this challenge Friday night and didn't give it another thought throughout Saturday, then this morning (Sunday), I woke up thinking about this problem and realized another solution might have been to simply parse by commas in the loop, then check if what was between the commas either started and ended with quotes, or could parse into an int. 

So, a second solution would look somethin like this:

    private String parseCsv(String csvData) {
		if (csvData == null) {
			return "";
		}
		String returnString = "";

		csvData = csvData.replace("\r\n", "\n").trim() + ",";
		
		String returnString = "";
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
     }
     
     private boolean isInt(String s) {
	    if (s == null) {
	        return false;
	    }
	    try {
	        int i = Integer.parseInt(s);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
    
    Anyhow. Either solution should work, but the second would be better than the first.
    
    Thanks again!
