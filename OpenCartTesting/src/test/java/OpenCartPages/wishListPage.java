package OpenCartPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class wishListPage {
	WebDriver driver=null;
	By wishList = By.id("wishlist-total");
	By WishButton =By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[2]");
	
	


public wishListPage(WebDriver driver) {
	this.driver=driver;
}
public void ClickwishList() {
	driver.findElement(wishList).click();
	
}
public void findButton() {
	//Method to scroll down usingJavascript
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	//This will scroll the page till the element is found		
     js.executeScript("arguments[0].scrollIntoView();", WishButton);
}

public void ClickWishButton() {
	//findButton();
	driver.findElement(WishButton).click();
}
}