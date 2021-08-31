package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver  driver=null;
	By MyAccount =By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i");
	By Login =By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
	By email = By.id("input-email");
	By Password = By.id("input-password");
	By SubmitButton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	By Account=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
	By Logout =By.partialLinkText("Logout");

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void ClickMyAccount(){
		driver.findElement(MyAccount).click();
	}
	public void ClickLogin() {
		driver.findElement(Login).click();
	}
	public void EnterEmailid(String useremail) {
		driver.findElement(email).sendKeys(useremail);
	}
	public void EnterPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}
	public void ClickButton() {
		driver.findElement(SubmitButton).click();
	}
public void ClickLogout() {
	driver.findElement(Account).click();
	driver.findElement(Logout).click();
}
}
