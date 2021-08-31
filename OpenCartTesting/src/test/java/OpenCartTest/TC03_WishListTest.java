package OpenCartTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import OpenCartPages.DesktopPage;
import OpenCartPages.LoginPage;
import OpenCartPages.wishListPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC03_WishListTest {
	private static WebDriver driver=null;
	private static String AssertWish="My Wish List";
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	private static String title;
  @SuppressWarnings("deprecation")
@Test(priority=1)
  public void WishListTest() {
	  ExtentTest test31 = extent.createTest("WishList Test", "WishList Test case");
			//Object for LoginPage-OrangeHRLoginPage
			wishListPage WishObj=new wishListPage(driver);
			driver.get("https://demo.opencart.com/");	
			driver.manage().window().maximize();
			LoginToTest();
			WishObj.ClickwishList();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			title=driver.getTitle();
			Assert.assertEquals(title, AssertWish);
			test31.pass("WishList Page displayed successfully");
  }
  @Test(priority=2)
  public void AddProductToWish() {
	  ExtentTest test32 = extent.createTest("Add to WishList Test", "WishList Test case");
	  //Method to scroll down usingJavascript
	 // JavascriptExecutor js = (JavascriptExecutor) driver;
			
	  //Object for wishListPage
			wishListPage WishObj=new wishListPage(driver);
			driver.get("https://demo.opencart.com/");	
			driver.manage().window().maximize();
			AddMactoWish();
			WishObj.ClickWishButton();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WishObj.ClickwishList();
			title=driver.getTitle();
			Assert.assertEquals(title, AssertWish);
			test32.pass("WishList Page displayed successfully");
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
	  AccountLogout();
	  System.out.println("Test completed");
		// calling flush writes everything to the log file
		extent.flush();
		driver.close();
		driver.quit();
		} 
 // ------------------------------------------------------------------------------------------------------------------------------
 //Other Functions
  
  //To Login to the User Account
  public  void LoginToTest() {
		//Object for LoginPage
		LoginPage LoginPageobj=new LoginPage(driver);

		//driver.get("https://demo.opencart.com/");	

		LoginPageobj.ClickMyAccount();
		LoginPageobj.ClickLogin();
		LoginPageobj.EnterEmailid("Tester@WebTesting.com");
		LoginPageobj.EnterPassword("Tester@123");
		LoginPageobj.ClickButton();
	}
  
  // To select a product to add to the wish list
  public void AddMactoWish() {
	  
		DesktopPage MacObj =new DesktopPage(driver);
		String AssertMac="Mac";
		MacObj.ClickDesktop();
		MacObj.ClickMAC();
		title=driver.getTitle();
		Assert.assertEquals(AssertMac, title);
		
		
	
  }
  public void AccountLogout() {
	  LoginPage Logoutobj=new LoginPage(driver);
	  Logoutobj.ClickLogout();
	  
  }


}
