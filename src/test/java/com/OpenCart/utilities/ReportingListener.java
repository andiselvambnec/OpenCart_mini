package com.OpenCart.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.OpenCart.testCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingListener extends BaseClass implements ITestListener {
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd-hh.mm.ss").format(new Date());
		String reportname = "MyReport" + timestamp + ".html";
		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/extent-report/"+reportname);
		htmlreport.config().setDocumentTitle("OpenCart Automation");
		htmlreport.config().setReportName("OpenCart-mini");
		htmlreport.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setSystemInfo("Tester", "AS");
		test=extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed is " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed is " + result.getName());
		test.log(Status.FAIL, "Test Failed is " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped is " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
