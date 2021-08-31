package OpenCartTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import OpenCartPages.DesktopPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


public class TC02_DesktopTest {
	private static WebDriver driver=null;
	private static String AssertPC="PC";
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	private static String title;
	
  @Test(priority=1)
  public void DesktopTest() {
	  ExtentTest test2 = extent.createTest("Desktops Test", "Desktop Test case");
		
		DesktopPage PcObj =new DesktopPage(driver);

		driver.get("https://demo.opencart.com/");	
		PcObj.ClickDesktop();
		title=driver.getTitle();
		test2.pass("Desktop Option selected successfully");
		
		PcObj.ClickPC();
		title=driver.getTitle();
		Assert.assertEquals(title, AssertPC);
		test2.pass("PC Option selected successfully");
		
		
  }
  @Test(priority=2)
  public void MacTest() {
	  ExtentTest test3 = extent.createTest("Desktops Test", "Desktop Test case");
		
		DesktopPage MacObj =new DesktopPage(driver);
		String AssertMac="Mac";
		driver.get("https://demo.opencart.com/");	
		MacObj.ClickDesktop();
		MacObj.ClickMAC();
		title=driver.getTitle();
		Assert.assertEquals(AssertMac, title);
		test3.pass("MAC Option selected successfully.");
		
		
  }
  @BeforeTest
  public void setUpTest() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent =new ExtentReports();
		extent.attachReporter(htmlReporter);
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test completed");
		// calling flush writes everything to the log file
		extent.flush();
		driver.close();
		driver.quit();
  }

}
