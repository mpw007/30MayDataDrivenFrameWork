/**
 * 
 */
package com.mystore.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.PageObjectModel.HomePage;
import com.mystore.PageObjectModel.IndexPage;
import com.mystore.PageObjectModel.LoginPage;
import com.mystore.base.BaseClass;

/**
 * @author Baliraj
 *
 */
public class HomePageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
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
	public void wishListTest() throws Throwable {
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
	    homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage);
		//homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
	}
	
	@Test(groups="sanity")
	public void orderHistoryandDetailsTest() throws Throwable {
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
	    homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage);
		//homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
	}
	
}
