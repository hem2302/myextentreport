package hemakumar.extentreportdemo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportdetailed {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter report = new ExtentSparkReporter("D:\\Selenium\\myextentreport\\reports\\report.html");
		extentReports.attachReporter(report);

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
		extentReports.createTest("xml based test").log(Status.INFO, xmlData).log(Status.INFO,
				MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		extentReports.createTest("json based test").log(Status.INFO, jsonData).log(Status.INFO,
				MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));

		extentReports.flush();
		Desktop.getDesktop().browse(new File("D:\\Selenium\\myextentreport\\reports\\report.html").toURI());
	}
}
