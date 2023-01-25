package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * This class provides implementation to all the methods in ITestListener Interface of TESTNG
 * @author ASHWINI
 *
 */

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenersImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		test.log(Status.INFO,"Test Excecution started-"+methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "Test script Passed-"+methodName);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "Test Script Failed-"+methodName);
        test.log(Status.FAIL, result.getThrowable());		
		String screenshotName = methodName+"-"+jUtil.getSystemDateInFormat();
		
			try {
				String path = wUtil.takeScreenShot(BaseClass.sdriver,screenshotName );
				test.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "Test script Skipped-"+methodName);
		test.log(Status.SKIP, result.getThrowable());
		System.out.println(result.getThrowable());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReports/Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Excecution Report");
		htmlReport.config().setReportName("Vtiger Excecution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Reporter Name","Ashwini");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==========Suite Excecution Finished======= ");
		report.flush();
	}

}
