package xero;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class _Env {
	public WebDriver driver;
	public WebDriverWait waiting;
	public Actions builder;
	public _PageElements xero = new _PageElements();
	public List<_UserCfg> cfgArray = new ArrayList<_UserCfg>();
	
	_Log log;
	
    public void setDriver (WebDriver testDriver) {
    	driver = testDriver;
    	waiting = new WebDriverWait(driver, 1);
    	builder = new Actions(driver);
    } // public void setDriver
    
    public void setLog (_Log testLog) {
    	log = testLog;
    } // public void setLog
	
	public void gotoUrl (String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
	} // public void gotoUrl

	public void maximizeWindow () {
		driver.manage().window().maximize();
	} // public void maximizeWindow
	
	public void refresh () {
		driver.navigate().refresh();
	} // public void refresh
	
	public void addDelay (int iteration) throws Exception {
		int i = 0;
		for (i = 0; i < iteration; i++) {
			try {
				waitUntilVisible("id=ADD_DELAY");
			} catch (Exception e) {}
		}
	} // public void addDelay

	public void waitUntilVisible (String elementName) throws Exception {
		waiting.until(ExpectedConditions.elementToBeClickable(findElement(elementName)));
	} // public void waitUntilVisible
	
	public WebElement findElement(String elementName) {
		WebElement we = null;
		String[] selector = elementName.split("=", 2);
		switch (selector[0]) {
		case "css"	: we = driver.findElement(By.cssSelector(selector[1])); break;
		case "id"	: we = driver.findElement(By.id(selector[1])); break;
		case "text"	: we = driver.findElement(By.linkText(selector[1])); break;
		default		: assertFail("[ERROR] " + selector[0] + " selector not found.."); break;
		}
		return we;
	} // public WebElement findElement
	
	public List<WebElement> findElements (String elementName) {
		List<WebElement> we = new ArrayList<WebElement>();
		String[] selector = elementName.split("=", 2);
		switch (selector[0]) {
		case "css"	: we = driver.findElements(By.cssSelector(selector[1])); break;
		case "id"	: we = driver.findElements(By.id(selector[1])); break;
		case "text"	: we = driver.findElements(By.linkText(selector[1])); break;
		default		: assertFail("[ERROR] " + selector[0] + " selector not found.."); break;
		}
		return we;
	} // public List<WebElement> findElements
	
	public void waitForElement (String elementName) throws Exception {
		int timeout = 0;
		while (!elementIsPresent(elementName)) {
			addDelay(1);
			timeout++;
			if (timeout > 30) {
				assertFail("[ERROR] waitForElement() timeout reached. element: " + elementName);
			}
		}
	} // public void waitForElement
	
	public void waitForElementToVanish (String elementName) throws Exception {
		int timeout = 0;
		while (elementIsPresent(elementName)) {
			addDelay(1);
			timeout++;
			if (timeout > 10) {
				assertFail("[ERROR] waitForElementToVanish() timeout reached. element: " + elementName);
			}
		}
	} // public void waitForElementToVanish
	
	public boolean elementIsPresent (String elementName) throws Exception {
		if (findElements(elementName).size() == 0) {
			return false;
		} else {
			return true;
		}
	} // public boolean elementIsPresent 
	
	public void verifyElementIsPresent (String elementName) throws Exception {
		if (!elementIsPresent(elementName)) {
			assertFail("[ERROR] element not found: " + elementName);
		}
	} // public void verifyElementIsPresent
	
	public void sendKeys (String elementName, Keys keys) {
		findElement(elementName).sendKeys(keys);
	} // public void sendKeys
	
	public void sendText (String elementName, String value, String description) throws Exception {
		log.debug(">> setting " + description + " = " + value);
		findElement(elementName).sendKeys(value);
	} // public void sendText
	
	public void sendTextToFrame (String frameName, String frameTextArea, String value, String description) throws Exception {
		driver.switchTo().frame(findElement(frameName));
		sendText(frameTextArea, value, description);
		sendKeys(frameTextArea, Keys.ENTER);
		driver.switchTo().defaultContent();
	} // public void sendTextToFrame

	public void inputText (String elementName, String value, String description) throws Exception {
		waitUntilVisible(elementName);
		if (!findElement(elementName).getAttribute("value").equals(value)) {
			if (!(description.equals(""))) {
				log.debug(">> setting " + description + " = " + value);
			}
			findElement(elementName).clear();
			findElement(elementName).sendKeys(value);
		}
	} // public void inputText

	public void selectValue (String elementName, String value, String description) throws Exception {
		waitUntilVisible(elementName);
		if (!findElement(elementName).getAttribute("value").equals(value)) {
			log.debug(">> setting " + description + " = " + value);
			findElement(elementName).clear();
			findElement(elementName).sendKeys(value);
			addDelay(4);
			findElement(elementName).sendKeys(Keys.ENTER);
		}
	} // public void selectValue
	
	public void selectFromDropdown (String elementName, String value, String description) throws Exception {
		waitUntilVisible(elementName);
		Select droplist = new Select(findElement(elementName));
		addDelay(2);
		if (!droplist.getFirstSelectedOption().getText().equals(value)) {
			log.debug(">> setting " + description + " = " + value);
			droplist.selectByVisibleText(value);
		}
	} // public void selectFromDropdown
	
	public void click (String elementName) throws Exception {
		findElement(elementName).click();
		addDelay(2);
	} // public void click
	
	public void assertFail (String errorMessage) {
		Assert.fail(errorMessage);
	} // public void assertFail

	public void assertTitle (String value, String errorMessage) throws Exception {
		Assert.assertEquals(driver.getTitle(), value, errorMessage +
				"\n[Error] Wrong page: expected [" + value + "]\tactual [" + driver.getTitle() +"]\n");
	} // public void assertTitle
	
	public void assertValue (String elementName, String expectedValue) throws Exception {
		Assert.assertEquals(findElement(elementName).getAttribute("value"), expectedValue,
				"[Error] Miscompare: expected [" + expectedValue + "]\tactual [" + findElement(elementName).getAttribute("value") + "]\n");
	} // public void assertValue
	
	public void assertText (String elementName, String expectedValue) throws Exception {
		Assert.assertEquals(findElement(elementName).getText(), expectedValue, "[Error] Miscompare: expected [" + expectedValue + "]\tactual [" + findElement(elementName).getText() + "]\n");
	} // public void assertText
	
	public String getText (String elementName) throws Exception {
		String value = "";

		if (findElements(elementName).size() > 0) {
			value = findElement(elementName).getText();
		}
		return value;
	} // public String getText
	
	public void verifyElementValue (String field, String elementName, String description) throws Exception {
		if (findElement(elementName).getText().contains(field)) {
			log.debug("Verified value of " + description + " = " + field);
		} else {
			assertFail("[ERROR] error value of " + description + ": expected (" + field + ") actual (" + findElement(elementName).getText() + ")");
		}
	} // public void verifyElementValue

	public void login (String email, String password) throws Exception {
		gotoUrl(xero.url_login);
		maximizeWindow();
		assertTitle("Login | Xero Accounting Software", "[ERROR] Login failed.");
		log.step("Logging in to Xero Accounting Software using email: " + email);
		inputText(xero.login_email, email, "");
		inputText(xero.login_password, password, "");
		findElement(xero.login_password).submit();
		assertTitle("Xero | Dashboard | Demo Company (Global)", "[ERROR] Login failed: Check if your username and password are correct");
		log.result("Login successful");
	} // public void login
	
	public void logout () throws Exception {
		log.step("Logging out..");
		click(xero.home_user);
		waitForElement(xero.home_user_logout);
		click(xero.home_user_logout);
		waitForElement("id=welldone-day");
		assertTitle("Logged Out | Xero", "[ERROR] Logout failed.");
		log.result("Logout successful");
	} // public void logout
	
	public void createRepeatingInvoice (_UserCfg cfg) throws Exception {
		log.step("Creating Repeating Invoice [" + cfg.id + "]");
		inputText(xero.nri_periodUnit, cfg.nri_periodUnit, "Period Unit");
		selectValue(xero.nri_timeUnitValue, cfg.nri_timeUnitValue, "Time Unit Value");
		inputText(xero.nri_startDate, cfg.nri_startDate, "Invoice Date");
		inputText(xero.nri_dueDateDay, cfg.nri_dueDateDay, "Due Date Day");
		addDelay(2);
		selectValue(xero.nri_dueDateTypeValue, cfg.nri_dueDateTypeValue, "Due Date Type Value");
		inputText(xero.nri_endDate, cfg.nri_endDate, "End Date");
		switch(cfg.nri_status) {
			case "Saved as Draft" :
				click(xero.nri_saveAsDraft);
				break;
			case "Approved" :
				click(xero.nri_approve);
				break;
			case "Approved & Sent" :
				click(xero.nri_approveForSending);
				waitForElement(xero.nri_editMessage);
				waitForElement(xero.nri_editMessage_to);
				inputText(xero.nri_editMessage_to, "rurgena@gmail.com", "");
				click(xero.nri_editMessage_save);
				waitForElementToVanish(xero.nri_editMessage);
				break;
			default: break;
		}
		inputText(xero.nri_invoiceTo, cfg.nri_invoiceTo, "Invoice To");
		inputText(xero.nri_reference, cfg.nri_reference, "Reference");
		selectValue(xero.nri_branding, cfg.nri_branding, "Branding");
		selectValue(xero.nri_currency, cfg.nri_currency, "Currency");
		for(int i = 0; i < cfg.nri_table_items.size(); i++) {
			findElements(xero.nri_table_items).get(i).click();
			addDelay(2);
			selectValue(xero.nri_table_item, cfg.nri_table_items.get(i), "Item " + i);
		}
		
		cfg.set_nri_total(findElement(xero.nri_table_total).getAttribute("value"));

		click(xero.nri_save);
		addDelay(6);
		assertTitle("Xero | Invoices | Demo Company (Global)", "[ERROR] Failed to create a Repeating Invoice");

		cfg.set_nri_invoiceDataId(findElement("text=Click to view.").getAttribute("href").substring(59, 95));
		String dataId =	findElement("css=td[data-id=\"" + cfg.nri_invoiceDataId + "\"]").getAttribute("id");
		xero.set_invoicesElementsPath(dataId);
		log.result("Successfully created Repeating Invoice [" + cfg.id + "] with Invoice ID = " + cfg.nri_invoiceDataId);
	} // public void createRepeatingInvoice
	
	public void verifyRepeatingInvoiceDetails (_UserCfg cfg) throws Exception {
		log.step("Verifying Repeating Invoice [" + cfg.id + "] details..");
		if (elementIsPresent(xero.invoice_itemPerPage)) {
			selectFromDropdown(xero.invoice_itemPerPage, "200", "");
		}
		verifyElementValue(cfg.nri_invoiceTo, xero.invoice_name, "Name");
		verifyElementValue(cfg.nri_reference, xero.invoice_reference, "Reference");
		verifyElementValue(cfg.nri_total, xero.invoice_amount, "Amount");
		verifyElementValue(cfg.nri_currencyAbbr, xero.invoice_currency, "Currency");
		verifyElementValue(cfg.nri_repeats, xero.invoice_repeats, "Repeats");
		verifyElementValue(cfg.nri_startDate, xero.invoice_nextInvoiceDate, "Next Invoice Date");
		verifyElementValue(cfg.nri_endDate, xero.invoice_endDate, "End Date");
		verifyElementValue(cfg.nri_status, xero.invoice_invoiceWillBe, "Invoice Will Be");
		log.result("Repeating Invoice [" + cfg.id + "] details are correct");
	} // public void verifyRepeatingInvoiceDetails
	
	public void randomize (int numRequests) throws Exception {
		log.step("Randomizing " + numRequests + " Repeating Invoice(s)");
		for (int i=0; i < numRequests; i++) {
			_UserCfg cfg = new _UserCfg();
			cfg.id = i;
			cfg.randomize(); 
			cfgArray.add(cfg);
		}
	} // public void randomize
	
	public void createRandomizedRepeatingInvoices () throws Exception {
		for (_UserCfg item: cfgArray) {
			log.step("Go to New Repeating Invoice page");
			gotoUrl(xero.url_newRepeatingInvoice);
			assertTitle("Xero | New Repeating Invoice | Demo Company (Global)", "[ERROR] Wrong page");
			log.step("Displaying the details for Repeating Invoice [" + item.id + "]");
			item.displayDetails();
			createRepeatingInvoice(item);
			verifyRepeatingInvoiceDetails(item);
			log.step("Opening the newly created Repeating Invoice [" + item.id + "] to verify if it exists..");
			waitForElement("text=Click to view.");
			click("text=Click to view.");
			assertTitle("Xero | Edit Repeating Invoice | Demo Company (Global)", "[ERROR] Wrong page");
			log.result("Successfully opened the newly created Repeating Invoice [" + item.id + "]");
			addDelay(6);
		}
	} // public void createRandomizedRepeatingInvoices
	
	public void getRepeatingInvoicesDetails () throws Exception {
		log.step("Go to Invoices page");
		gotoUrl(xero.url_invoices);
		assertTitle("Xero | Invoices | Demo Company (Global)", "[ERROR] Wrong page");
		log.step("Getting the details of the Repeating Invoices in the list..");
		int numOfRepeatingInvoice = findElements("css=td[data-id]").size();
		for (int i = 0; i < numOfRepeatingInvoice; i++) {
			_UserCfg cfg = new _UserCfg();
			cfg.nri_invoiceDataId	= findElements("css=td[data-id]").get(i).getAttribute("data-id");
			String dataId =	findElement("css=td[data-id=\"" + cfg.nri_invoiceDataId + "\"]").getAttribute("id");
			xero.set_invoicesElementsPath(dataId);
			cfg.id = i;
			cfg.nri_invoiceTo 		= getText(xero.invoice_name);
			cfg.nri_reference 		= getText(xero.invoice_reference);
			cfg.nri_total 			= getText(xero.invoice_amount);
			cfg.nri_currencyAbbr 	= getText(xero.invoice_currency).trim();
			cfg.nri_repeats 		= getText(xero.invoice_repeats);
			cfg.nri_startDate 		= getText(xero.invoice_nextInvoiceDate);
			cfg.nri_endDate 		= getText(xero.invoice_endDate);
			cfg.nri_status 			= getText(xero.invoice_invoiceWillBe);
			cfgArray.add(cfg);
		}
		log.result("There are " + numOfRepeatingInvoice + " Repeating Invoices currently listed.");
	} // public void getRepeatingInvoicesDetails
	
	public void updateStatusOfRepeatingInvoice (int cfgArrayId, String operation) throws Exception {
		log.step("Performing operation <" + operation + "> to Repeating Invoice [" + cfgArrayId + "]");
		cfgArray.get(cfgArrayId).id = cfgArrayId;
		cfgArray.get(cfgArrayId).displayDetails_type2();
		log.debug("Current status = " + cfgArray.get(cfgArrayId).nri_status);
		String invoiceId = cfgArray.get(cfgArrayId).nri_invoiceDataId;
		String dataId =	findElement("css=td[data-id=\"" + invoiceId + "\"]").getAttribute("id");
		xero.set_invoicesElementsPath(dataId);
		click(xero.invoice_checkbox);
		switch(operation) {
			case "Save as Draft" :
				click(xero.invoice_saveAsDraft);
				waitForElement(xero.confirm);
				click(xero.confirm_ok);
				waitForElementToVanish(xero.confirm);
				cfgArray.get(cfgArrayId).nri_status = "Saved as Draft";
				cfgArray.get(cfgArrayId).displayDetails_type2();
				verifyElementValue(cfgArray.get(cfgArrayId).nri_status, xero.invoice_invoiceWillBe, "new status");
				break;
			case "Approve" :
				click(xero.invoice_approve);
				waitForElement(xero.confirm);
				click(xero.confirm_ok);
				waitForElementToVanish(xero.confirm);
				cfgArray.get(cfgArrayId).nri_status = "Approved";
				cfgArray.get(cfgArrayId).displayDetails_type2();
				verifyElementValue(cfgArray.get(cfgArrayId).nri_status, xero.invoice_invoiceWillBe, "new status");
				break;
			case "Approve for Sending" :
				click(xero.invoice_approveForSending);
				waitForElement(xero.editMessage);
				waitForElement(xero.editMessage_to);
				inputText(xero.editMessage_to, "rurgena@gmail.com", "");
				click(xero.editMessage_save);
				waitForElementToVanish(xero.editMessage);
				cfgArray.get(cfgArrayId).nri_status = "Approved & Sent";
				cfgArray.get(cfgArrayId).displayDetails_type2();
				verifyElementValue(cfgArray.get(cfgArrayId).nri_status, xero.invoice_invoiceWillBe, "new status");
				break;
			case "Delete" :
				click(xero.invoice_delete);
				waitForElement(xero.confirm);
				click(xero.confirm_ok);
				waitForElementToVanish(xero.confirm);
				cfgArray.remove(cfgArrayId);
				if (elementIsPresent("css=td[data-id=\"" + invoiceId + "\"]")) {
					assertFail("[ERROR] Failed to delete Repeating Invoice [" + cfgArrayId + "]");
				} else {
					log.debug("Repeating Invoice [" + cfgArrayId + "] sucessfully deleted");
				}
				break;
			default: break;
		}
		log.result("Successfully performed operation");
	} // public void updateStatusOfRepeatingInvoice

} // public class _Env