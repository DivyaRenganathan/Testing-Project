package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class components {
	WebDriver driver =null;
	By Components =By.linkText("Components");
	By MiceandTrackballs =By.partialLinkText("Mice and Trackballs");
	By Monitors=By.partialLinkText("Monitors");
	By Printers=By.partialLinkText("Printers");
	By Scanners=By.partialLinkText("Scanners");
	By WebCameras=By.partialLinkText("WebCameras");
 public components(WebDriver driver) {
	 this.driver=driver;
 }
public void ClickComponent() {
	driver.findElement(Components).click();
}
public void ClickMiceandTrack() {
	driver.findElement(MiceandTrackballs).click();
}
public void ClickMonitors() {
	driver.findElement(Monitors).click();
}
public void ClickScanners() {
	driver.findElement(Scanners).click();
}
public void ClickWebCamers() {
	driver.findElement(WebCameras).click();
}
}
 