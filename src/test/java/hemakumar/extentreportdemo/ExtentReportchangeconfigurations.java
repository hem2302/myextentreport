package hemakumar.extentreportdemo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportchangeconfigurations {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter report = new ExtentSparkReporter("D:\\Selenium\\myextentreport\\reports\\report.html");
		extentReports.attachReporter(report);

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
