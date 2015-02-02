//=================================================================================================
// Test Name: Test_updateStatusOfRepeatingInvoice
// Description:
//      Test for updating the status of existing repeating invoices
//      Operations performed are randomized (Save as Draft, Approve, Approve for Sending, Delete)
//      New statuses of repeating invoices are verified
//      The number of operations to perform is set using the variable 'numOfOperations'
// Assumption:
//      There are existing repeating invoices listed in the Invoices page
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_updateStatusOfRepeatingInvoice {
	public static void main(String[] args) throws Exception {
		_Env env = new _Env();
		_Log log = new _Log ();
	    WebDriver driver = new FirefoxDriver();
		env.setDriver(driver);
		env.setLog(log);
		Random generator = new Random();
		int randno = 0;

		// Edit this variable to set the number of operations to perform
		int numOfOperations = 10;

		// Display test description
		log.disp(log.dividerS);
		log.disp("Test Name  : Test_updateStatusOfRepeatingInvoice");
		log.disp("Description: Test for updating the status of existing repeating invoices");
		log.disp("             Operations performed are randomized (Save as Draft, Approve, Approve for Sending, Delete)");
		log.disp("             New statuses of repeating invoices are verified");
		log.disp("             10 different operations are performed on randomly selected repeating invoices");
		log.disp(log.dividerM);
		
		// Log in to Xero Accounting Software
		env.login(env.xero.email, env.xero.password);
		
		// Get the details of existing Repeating Invoices in the Invoices page
		env.getRepeatingInvoicesDetails();
		
		// Perform a randomized operation on a Repeating Invoice selected randomly
		for (int i = 0; i < numOfOperations; i++) {
			if (env.cfgArray.size() > 1) {
				// select the Repeating Invoice randomly
				randno = generator.nextInt(env.cfgArray.size() - 1);
				log.step("Repeating Invoice [" + randno + "] randomly selected from the list");
				env.updateStatusOfRepeatingInvoice(randno, randomize_operation());
			}
		}
		
		// Log out
		env.logout();
		
		// Closing driver instance
		driver.close();
		
		// If the test got this far, it means no errors are encountered 
		log.disp(log.dividerM);
		log.disp("TEST PASSED");
		log.disp(log.dividerE);
	} // public static void main
	
	public static String randomize_operation () {
		Random generator = new Random();
		int randno = 0;
		List<String> list = new ArrayList<String>();

		list.add("Save as Draft");
		list.add("Approve");
		list.add("Approve for Sending");
		list.add("Delete");
		randno = generator.nextInt(list.size());
		return list.get(randno);
	} // public void randomize_operation
}
