package hemakumar.extentreportdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportsDemo {
	@BeforeTest
	public void config() {
		// ExtentReports, ExtentSparkReporter
		ExtentReports rep = new ExtentReports();

	}

	@Test
	public void extentReports() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());

	}
}
