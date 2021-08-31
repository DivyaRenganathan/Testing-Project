package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class lapandNotePage {
	WebDriver driver =null;
	By LapandNote =By.linkText("Laptops & Notebooks");
	By Macs =By.partialLinkText("Macs");
	By Windows=By.partialLinkText("Windows");

 public lapandNotePage(WebDriver driver) {
	 this.driver=driver;
 }
public void ClickLapandNote() {
	driver.findElement(LapandNote).click();
}
public void ClickMacs() {
	driver.findElement(Macs).click();
}
public void ClickWindows() {
	driver.findElement(Windows).click();
}
}
 