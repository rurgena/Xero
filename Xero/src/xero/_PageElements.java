package xero;

public class _PageElements {
	//URLs
	public String url_login					= "https://login.xero.com";
	public String url_base					= "https://go.xero.com";
	public String url_dashboard				= url_base.concat("/Dashboard/");
	public String url_sales					= url_base.concat("/Accounts/Receivable/Dashboard/");
	public String url_invoices				= url_base.concat("/AccountsReceivable/SearchRepeating.aspx");
	public String url_newRepeatingInvoice	= url_base.concat("/RepeatTransactions/Edit.aspx?type=AR");

	//Login page
	public String login_email 		= "id=email";
	public String login_password 	= "id=password";
	public String login_login		= "id=submitButton";
	
	//Home page
	public String home_user 		= "css=div.xn-h-user";
	public String home_user_logout	= "css=a[data-js=logout]";
	
	//Logout dialog box
	public String logout 			= "css=div.x-window[id*=ext-comp-]";
	public String logout_logout		= "css=div.x-window-body[id*=ext-gen] div a:first-child";
	public String logout_cancel		= "css=div.x-window-body[id*=ext-gen] div a:nth-child(2)";
	
	//New Repeating Invoice
	public String nri_periodUnit		= "id=PeriodUnit";
	public String nri_timeUnitValue		= "id=TimeUnit_value";
	public String nri_TimeUnitToggle	= "id=TimeUnit_toggle";
	public String nri_startDate			= "id=StartDate";
	public String nri_dueDateDay		= "id=DueDateDay";
	public String nri_dueDateTypeValue	= "id=DueDateType_value";
	public String nri_dueDateTypeToggle	= "id=DueDateType_toggle";
	public String nri_endDate			= "id=EndDate";
	public String nri_saveAsDraft		= "id=saveAsDraft";
	public String nri_approve			= "id=saveAsAutoApproved";
	public String nri_approveForSending	= "id=saveAsAutoApprovedAndEmail";
	public String nri_invoiceTo			= "css=div.invoicing-details div div div input[id*=PaidToName_]";
	public String nri_reference			= "css=div.invoicing-details div div input[id*=Reference_]";
	public String nri_branding			= "id=TemplateDropDown_value";
	public String nri_amountsAre		= "css=div.taxAmount div div input[id*=ext-gen][type=text]";
	public String nri_currency			= "css=div.currency div div input[id*=Currency_]";
	public String nri_table_item			= "id=ext-comp-1001";
	public String nri_table_items			= "css=div.x-grid3-col-colPriceList";
	public String nri_table_description		= "id=ext-comp-1002";
	public String nri_table_descriptions	= "css=div.x-grid3-col-colDescription";
	public String nri_table_qty				= "id=ext-comp-1004";
	public String nri_table_qtys			= "css=div.x-grid3-col-colQuantity";
	public String nri_table_unitPrice		= "id=ext-comp-1005";
	public String nri_table_unitPrices		= "css=div.x-grid3-col-colUnitPrice";
	public String nri_table_disc			= "id=ext-comp-1006";
	public String nri_table_discs			= "css=div.x-grid3-col-colDiscount";
	public String nri_table_account			= "id=ext-comp-1011";
	public String nri_table_accounts		= "css=div.x-grid3-col-colAccount";
	public String nri_table_taxRate			= "id=ext-comp-1012";
	public String nri_table_taxRates		= "css=div.x-grid3-col-colGST";
	public String nri_table_total		= "id=invoiceTotal";
	public String nri_save				= "css=button[onclick*=\"Invoice.save\"]";
	public String nri_cancel			= "id=TimeUnit_value";
	//	Edit Message dialog box
	public String nri_editMessage		= "id=EmailSettings";
	public String nri_editMessage_to	= "css=form#frmEmailStatements div div div div div input[id*=MessageTo]";
	public String nri_editMessage_save	= "css=tr td:nth-child(1) em[id*=ext-gen]";
	
	//Invoices
	public String invoice_itemPerPage		= "id=mainPagerItemPerPageDropDown";
	public String invoice_saveAsDraft		= "css=div.document.collection.forms div.action-bar div:nth-child(1).button a";
	public String invoice_approve			= "css=div.document.collection.forms div.action-bar div:nth-child(2).button a";
	public String invoice_approveForSending	= "css=div.document.collection.forms div.action-bar div:nth-child(3).button a";
	public String invoice_delete			= "css=div.document.collection.forms div.action-bar div:nth-child(4).button a";
	public String invoice_search			= "css=div.document.collection.forms div.action-bar div:nth-child(6).button a";
	public String invoice_checkbox			= "css=table tbody tr td:nth-child(1)";
	public String invoice_name				= "css=table tbody tr td:nth-child(2)";
	public String invoice_reference			= "css=table tbody tr td:nth-child(3)";
	public String invoice_amount			= "css=table tbody tr td:nth-child(4)";
	public String invoice_currency			= "css=table tbody tr td:nth-child(5)";
	public String invoice_repeats			= "css=table tbody tr td:nth-child(6)";
	public String invoice_nextInvoiceDate	= "css=table tbody tr td:nth-child(7)";
	public String invoice_endDate			= "css=table tbody tr td:nth-child(8)";
	public String invoice_invoiceWillBe		= "css=table tbody tr td:nth-child(9)";
	
	//Edit Message dialog box
	public String editMessage			= "id=__emailWindow";
	public String editMessage_to		= "id=ContactEmail";
	public String editMessage_save		= "id=popupSend";
	
	//Confirm dialog box
	public String confirm				= "id=__popupSpin";
	public String confirm_ok			= "css=div#create02 a";

	public String email																																		= "rurgena@gmail.com";
	public String password																																	= "P@ssw0rdxero";
	
	public void set_invoicesElementsPath (String dataId) {
		invoice_checkbox		= "css=input#ext-gen" + Integer.toString(Integer.parseInt(dataId.substring(7)) - 9);
		invoice_name			= "css=td#ext-gen" + Integer.toString(Integer.parseInt(dataId.substring(7)) - 8);
		invoice_reference		= "css=td#ext-gen" + Integer.toString(Integer.parseInt(dataId.substring(7)) - 7);
		invoice_amount			= "css=td#ext-gen" + Integer.toString(Integer.parseInt(dataId.substring(7)) - 6);
		invoice_currency		= "css=td#ext-gen" + Integer.toString(Integer.parseInt(dataId.substring(7)) - 5);
		invoice_repeats			= "css=td#ext-gen" + Integer.toString(Integer.parseInt(dataId.substring(7)) - 4);
		invoice_nextInvoiceDate	= "css=td#ext-gen" + Integer.toString(Integer.parseInt(dataId.substring(7)) - 3);
		invoice_endDate			= "css=td#ext-gen" + Integer.toString(Integer.parseInt(dataId.substring(7)) - 2);
		invoice_invoiceWillBe	= "css=td#ext-gen" + Integer.toString(Integer.parseInt(dataId.substring(7)) - 1);
	}
}