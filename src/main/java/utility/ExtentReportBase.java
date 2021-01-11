package utility;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportBase {
	  private static ExtentReports extent;
	  

	    public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    } 
	  
	    
	    public static ExtentReports createInstance() {
	    	 	
	    	String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html", false);
	    	return extent;
	    }
}
