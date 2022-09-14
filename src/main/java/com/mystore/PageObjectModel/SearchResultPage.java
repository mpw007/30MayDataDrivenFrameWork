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
public class SearchResultPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		Thread.sleep(2000);
		return action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		//Thread.sleep(3000);
		action.click(driver, productResult);
		//action.JSClick(driver, productResult);
		Thread.sleep(5000);
		return new AddToCartPage();
	}
	
}
