//=================================================================================================
// Test Name: Test_createRepeatingInvoice
// Description:
//      Test for creating a number of repeating invoices with randomized values
//      Details of newly created repeating invoices are verified for correctness
//      The number of repeating invoices is set using the variable 'numOfRepeatingInvoices'
//-------------------------------------------------------------------------------------------------
// Author : Ramil Urgena
// Prerequisites:
//      selenium-java-2.43.0
//      FireFox version 32.0.1
// Notes: Successfully executed using:
//      Eclipse IDE for Java Developers
//      Version: Juno Service Release 1
//      Build id: 20120920-0800
//=================================================================================================
package xero;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_createRepeatingInvoice {
	public static void main(String[] args) throws Exception {
		_Env env = new _Env();
		_Log log = new _Log ();
	    WebDriver driver = new FirefoxDriver();
		env.setDriver(driver);
		env.setLog(log);
		
		// Edit this variable to set the number of repeating invoices to be created
		// Current limitation: Maximum is 200 which is the maximum number of items per page of the Invoices page  
		int numOfRepeatingInvoices = 10;
		
		// Display test description
		log.disp(log.dividerS);
		log.disp("Test Name  : Test_createRepeatingInvoice");
		log.disp("Description: Test for creating 10 repeating invoices with randomized values");
		log.disp("             Details of newly created repeating invoices are verified for correctness");
		log.disp(log.dividerM);

		// Log in to Xero Accounting Software
		env.login(env.xero.email, env.xero.password);

		// Randomize values of repeating invoices
		env.randomize(numOfRepeatingInvoices);
		
		// Create repeating invoices
		env.createRandomizedRepeatingInvoices();

		// Log out
		env.logout();
		
		// Closing driver instance
		driver.close();
		
		// If the test got this far, it means no errors are encountered 
		log.disp(log.dividerM);
		log.disp("TEST PASSED");
		log.disp(log.dividerE);
	}
} // public class Test_createRepeatingInvoice
