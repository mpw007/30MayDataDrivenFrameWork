/**
 * 
 */
package com.mystore.TestCase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.PageObjectModel.IndexPage;
import com.mystore.base.BaseClass;


/**
 * @author Baliraj
 *
 */
public class IndexPageTest extends BaseClass {
   IndexPage indexPage;
    
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="smoke")
	public void verifyLogo() throws Throwable {
		indexPage= new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups="smoke")
	public void verifyTitle() {
		
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store1");
		
	}

	
}
