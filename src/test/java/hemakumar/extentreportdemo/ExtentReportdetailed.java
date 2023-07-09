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

public class ExtentReportdetailed {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter report = new ExtentSparkReporter("D:\\Selenium\\myextentreport\\reports\\report.html");
		extentReports.attachReporter(report);

		// send text based info
		extentReports.createTest("Text based test").log(Status.INFO, "info1").log(Status.INFO, "<b>info2</b>")
				.log(Status.INFO, "<i>info3</i>").log(Status.INFO, "<b><i>info3</b></i>");

		String xmlData = "<menu id=\"file\" value=\"File\">\r\n" + "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n" + "  </popup>\r\n" + "</menu>";

		String jsonData = "{\"menu\": {\r\n" + "  \"id\": \"file\",\r\n" + "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n" + "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n" + "    ]\r\n" + "  }\r\n" + "}}";

		// can pass list,set and map data as well

		// Send xml based info
		extentReports.createTest("xml based test").log(Status.INFO, xmlData).log(Status.INFO,
				MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		// send json based info
		extentReports.createTest("json based test").log(Status.INFO, jsonData).log(Status.INFO,
				MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));

		// This is to highlight the text using color
		extentReports.createTest("This is the highlighted text").info("this is the not highlighted text")
				.info(MarkupHelper.createLabel("highlighted text", ExtentColor.BLUE));

		// throwable exception
		try {
			int i = 5 / 0;
		} catch (Exception e) {
			extentReports.createTest("Exception test 1").fail(e);
		}
		// customised throwable exception
		Throwable t = new RuntimeException("This is the customise exception");
		extentReports.createTest("Exception test 2").fail(t);
		extentReports.createTest("Exception test 3").fail(t);
		// flush the report
		extentReports.flush();

		// to open the html report automaticcally after report is flushed
		Desktop.getDesktop().browse(new File("D:\\Selenium\\myextentreport\\reports\\report.html").toURI());
	}
}
