package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DesktopPage {
	WebDriver  driver=null;
	By Desktops =By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a");
	By PCOption =By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[1]/a");
	By email = By.id("input-email");
	By Password = By.id("input-password");
	By SubmitButton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	//Finding element using partialLink Method
	By MacOption =By.partialLinkText("Mac");
    
	public DesktopPage(WebDriver driver) {
		this.driver=driver;
	}
	public void ClickDesktop(){
		driver.findElement(Desktops).click();
	}
	public void ClickPC() {
		driver.findElement(PCOption).click();
	}
	public void ClickMAC() {
		driver.findElement(MacOption).click();
	
		
	}
}
