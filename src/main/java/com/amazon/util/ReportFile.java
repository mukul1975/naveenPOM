package com.amazon.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportFile {
	
	public static ExtentReports Report;
	
	public static ExtentReports report()
	{
		String path=System.getProperty("user.dir")+"\\Report\\index.html";
		ExtentSparkReporter Reporter=new ExtentSparkReporter(path);
		Reporter.config().setDocumentTitle("Amazon Page Test");
		Reporter.config().setReportName("Automation");
		Report=new ExtentReports();
		Report.attachReporter(Reporter);
		Report.setSystemInfo("Tester", "Mukul");
		Report.setSystemInfo("Tester", "Saiful");
		return Report;
	}

}
