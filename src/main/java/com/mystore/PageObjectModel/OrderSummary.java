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
public class OrderSummary extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummary() {
		PageFactory.initElements(driver, this);
	}

	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		action.click(driver, confirmOrderBtn);
		Thread.sleep(2000);
		return new OrderConfirmationPage();
	}
	
}
