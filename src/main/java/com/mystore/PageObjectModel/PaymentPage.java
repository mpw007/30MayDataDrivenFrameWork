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
public class PaymentPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummary clickOnPaymentMethod() throws Throwable {
		action.click(driver, bankWireMethod);
		Thread.sleep(2000);
		return new OrderSummary();
	}

}
