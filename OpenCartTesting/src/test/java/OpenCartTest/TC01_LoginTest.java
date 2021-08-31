package OpenCartTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import OpenCartPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_LoginTest {

		private static WebDriver driver=null;
		ExtentHtmlReporter htmlReporter;
		ExtentReports extent;
		private static String title;
		private static String AssertAccount="My Account";
		private static String AssertLogout="Account Logout";

		@BeforeTest
		public  void setUpTest() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			htmlReporter = new ExtentHtmlReporter("extent.html");
			extent =new ExtentReports();
			extent.attachReporter(htmlReporter);
		}

		@Test(priority=1)
		public  void LoginTest() {
			ExtentTest test1 = extent.createTest("Login", "LoginTest case");
			//Object for LoginPage-OrangeHRLoginPage
			LoginPage LoginPageobj=new LoginPage(driver);

			driver.get("https://demo.opencart.com/");	
			driver.manage().window().maximize();

		
			LoginPageobj.ClickMyAccount();
			test1.pass("MyAccount Button clicked successfully");
			LoginPageobj.ClickLogin();
			test1.pass("Login Button clicked successfully");
			LoginPageobj.EnterEmailid("Tester@WebTesting.com");
			test1.pass("EmailID enterd successfully");
			LoginPageobj.EnterPassword("Tester@123");
			test1.pass("Password entered successfully");
			LoginPageobj.ClickButton();
			test1.pass("Submit button clicked successfully");
			title=driver.getTitle();
			Assert.assertEquals(title, AssertAccount);
			test1.pass("Login Test case passed successfully");
			
		}
		@Test(priority=2)
		 public void LogoutTest() {
			 
			 ExtentTest test2 = extent.createTest("Logout", "LogoutTest case");
			  LoginPage Logoutobj=new LoginPage(driver);
				Logoutobj.ClickLogout();
				test2.pass("Logout button clicked successfully");
				title=driver.getTitle();
				Assert.assertEquals(title,AssertLogout);
				test2.pass("Login Test case passed successfully");
		
		 }
		@AfterTest
		public  void tearDownTest() {
			System.out.println("Test completed");
			// calling flush writes everything to the log file
			extent.flush();
		}
	}


