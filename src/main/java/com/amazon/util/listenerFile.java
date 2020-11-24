package com.amazon.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazon.basefile.BaseFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listenerFile extends screenShotFile implements ITestListener{

	ExtentReports Report=ReportFile.report();
	ExtentTest Test;
	
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		Test=Report.createTest(result.getMethod().getMethodName());
		takescreenshotMethod(result.getMethod().getMethodName());
		Test.log(Status.PASS, "TestCase Passed ");
	}

	public void onTestFailure(ITestResult result) {
		takescreenshotMethod(result.getMethod().getMethodName());
		Test.log(Status.FAIL, "TestCase Failed");
		Test.fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		Report.flush();
	}
	

}
