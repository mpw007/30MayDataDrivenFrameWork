/**
 * 
 */
package com.mystore.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.PageObjectModel.AddToCartPage;
import com.mystore.PageObjectModel.AddressPage;
import com.mystore.PageObjectModel.IndexPage;
import com.mystore.PageObjectModel.LoginPage;
import com.mystore.PageObjectModel.OrderConfirmationPage;
import com.mystore.PageObjectModel.OrderPage;
import com.mystore.PageObjectModel.OrderSummary;
import com.mystore.PageObjectModel.PaymentPage;
import com.mystore.PageObjectModel.SearchResultPage;
import com.mystore.PageObjectModel.ShippingPage;
import com.mystore.base.BaseClass;

/**
 * @author Baliraj
 *
 */
public class EndToEndTest extends BaseClass {
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummary orderSummary;
	private OrderConfirmationPage orderConfirmationPage;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(groups="sanity")
	public void endToEndTest() throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		//addToCartPage.enterQuantity(qty);
		//addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
	}

}
