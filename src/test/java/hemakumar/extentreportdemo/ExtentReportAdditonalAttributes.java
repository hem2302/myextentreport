package hemakumar.extentreportdemo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportAdditonalAttributes {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReport = new ExtentSparkReporter("D:\\Selenium\\myextentreport\\reports\\report.html");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Report Name");
		sparkReport.config().setDocumentTitle("Document Title");
		sparkReport.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		sparkReport.config().setCss(".badge-primary{background-color:#da0b2b}");
		// This is to remove the extent report logo
		sparkReport.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");

		//**** the below code is to rearrange the order of tabs****
		/*
		 * sparkReport.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.TEST,
		 * ViewName.EXCEPTION, ViewName.CATEGORY, ViewName.DEVICE, ViewName.DASHBOARD
		 * 
		 * }).apply();
		 */

		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Browser name", "os name");
		extentReports.setSystemInfo("Browser version", "browser name");
		extentReports.setSystemInfo("Browser url", "https://google.com");
		extentReports.setSystemInfo("user name", "hemakumar");

		// System.out.println(System.getProperties()); this gets all the system
		// properties

		extentReports.attachReporter(sparkReport);

		// send text based info
		extentReports.createTest("This is the test 1", "Test description").assignAuthor("hema").assignCategory("chrome")
				.assignDevice("chrome").pass("Passed");

		extentReports.createTest("This is the test 2", "Test2 description").assignAuthor("kumar")
				.assignCategory("sanity").assignDevice("edge").pass("Passed");

		extentReports.createTest("This is the test 3", "Test2 description").assignAuthor("hemakumar")
				.assignCategory("regression").assignDevice("firefox").fail("fail");

		extentReports.createTest("This is the test 3", "Test3 description").assignAuthor("hemakumar")
				.assignCategory("regression").assignCategory("sanity");

		extentReports.createTest("This is the test 4", "Test4 description")
				.assignAuthor(new String[] { "hemakumar", "kumar", "hema", "hemanth" })
				.assignCategory(new String[] { "sanity", "smoke", "regression" })
				.assignDevice(new String[] { "chrome", "firefox", "edge" }).pass("pass");
		// flush the report
		extentReports.flush();

		// to open the html report automaticcally after report is flushed
		Desktop.getDesktop().browse(new File("D:\\Selenium\\myextentreport\\reports\\report.html").toURI());
	}
}
