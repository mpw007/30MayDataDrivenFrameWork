/**
 * 
 */
package com.mystore.PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionDriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Baliraj
 *
 */
public class HomePage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	public boolean validateMyWishList() throws Throwable {
		return action.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return action.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrURL() throws Throwable {
		Thread.sleep(2000);
		String homePageURL=action.getCurrentURL(driver);
		return homePageURL;
	}
}
