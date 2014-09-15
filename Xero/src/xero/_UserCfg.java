package xero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _UserCfg {
	int id = 0;
	
	public String nri_invoiceDataId = "";
	
	public String nri_periodUnit		= "";
	public String nri_timeUnitValue		= "";
	public String nri_repeats			= "";
	public String nri_TimeUnitToggle	= "";
	public String nri_startDate			= "";
	public String nri_dueDateDay		= "";
	public String nri_dueDateTypeValue	= "";
	public String nri_dueDateTypeToggle	= "";
	public String nri_endDate			= "";
	public String nri_status			= "";
	public String nri_invoiceTo			= "";
	public String nri_branding			= "";
	public String nri_reference			= "";
	public String nri_currency			= "";
	public String nri_currencyAbbr		= "";
	public String nri_amountsAre		= "";
	public List<String> nri_table_items = new ArrayList<String>();
	public String nri_total				= "";
	
	public void set_nri_invoiceDataId (String value) {
		nri_invoiceDataId = value;
	}
	
	public void set_nri_total (String value) {
		nri_total = value;
	}
	
	public void randomize_nri_periodUnit () {
		if (nri_periodUnit.equals("")) {
			Random generator = new Random();
			int randno = 0;
			
			randno = generator.nextInt(36) + 1;
			nri_periodUnit = Integer.toString(randno);
		}
	}
	
	public void randomize_nri_timeUnitValue () {
		if (nri_timeUnitValue.equals("")) {
			Random generator = new Random();
			int randno = 0;
			List<String> list = new ArrayList<String>();

			list.add("Month(s)");
			list.add("Week(s)");
			randno = generator.nextInt(list.size());
			nri_timeUnitValue = list.get(randno);
		}
	}
	
	public void randomize_nri_repeats () {
		switch (nri_timeUnitValue) {
			case "Month(s)" :
				nri_repeats = "Every " + nri_periodUnit + " Month";
				break;
			case "Week(s)" :
				nri_repeats = "Every " + nri_periodUnit + " Week";
				break;
			default: break;
		}
		if (!nri_periodUnit.equals("1")) {
			nri_repeats = nri_repeats.concat("s");
		}
	}
	
	public void randomize_nri_startDate () {
		if (nri_startDate.equals("")) {
			Random generator = new Random();
			int randno1 = 0;
			int randno2 = 0;
			List<String> list = new ArrayList<String>();

			list.add(" Oct 2014");
			list.add(" Nov 2014");
			list.add(" Dec 2014");
			list.add(" Jan 2015");
			list.add(" Feb 2015");
			list.add(" Mar 2015");
			list.add(" Apr 2015");
			list.add(" May 2015");
			list.add(" Jun 2015");
			list.add(" Jul 2015");
			list.add(" Aug 2015");
			list.add(" Sep 2015");
			randno1 = generator.nextInt(list.size());
			nri_startDate = list.get(randno1);
			if (nri_startDate.contains("Feb")) {
				randno2 = generator.nextInt(28) + 1;
			} else if ((nri_startDate.contains("Apr")) || (nri_startDate.contains("Jun")) || (nri_startDate.contains("Sep")) || (nri_startDate.contains("Nov"))) {
				randno2 = generator.nextInt(30) + 1;
			} else {
				randno2 = generator.nextInt(31) + 1;
			}
			nri_startDate = Integer.toString(randno2).concat(nri_startDate);
		}
	}
	
	public void randomize_nri_dueDateDay () {
		if (nri_dueDateDay.equals("")) {
			Random generator = new Random();
			int randno = 0;
			
			randno = generator.nextInt(30) + 1;
			nri_dueDateDay = Integer.toString(randno);
		}
	}
	
	public void randomize_nri_dueDateTypeValue () {
		if (nri_dueDateTypeValue.equals("")) {
			Random generator = new Random();
			int randno = 0;
			List<String> list = new ArrayList<String>();
			
			if (nri_timeUnitValue.equals("Month(s)")) {
				list.add("of the following month");
				list.add("day(s) after the invoice date");
				list.add("day(s) after the end of the invoice month");
//				list.add("of the current month");
			} else {
				list.add("of the following month");
				list.add("day(s) after the invoice date");
			}
			randno = generator.nextInt(list.size());
			nri_dueDateTypeValue = list.get(randno);
		}
	}
	
	public void randomize_nri_endDate () {
		if (nri_endDate.equals("")) {
			Random generator = new Random();
			int randno1 = 0;
			int randno2 = 0;
			List<String> list = new ArrayList<String>();

			list.add("");
			list.add(" Oct 2015");
			list.add(" Nov 2015");
			list.add(" Dec 2015");
			list.add(" Jan 2016");
			list.add(" Feb 2016");
			list.add(" Mar 2016");
			list.add(" Apr 2016");
			list.add(" May 2016");
			list.add(" Jun 2016");
			list.add(" Jul 2016");
			list.add(" Aug 2016");
			list.add(" Sep 2016");
			list.add(" Oct 2016");
			list.add(" Nov 2016");
			list.add(" Dec 2016");
			randno1 = generator.nextInt(list.size());
			nri_endDate = list.get(randno1);
			if (!nri_endDate.equals("")) {
				if (nri_endDate.contains("Feb")) {
					randno2 = generator.nextInt(28) + 1;
				} else if ((nri_endDate.contains("Apr")) || (nri_endDate.contains("Jun")) || (nri_endDate.contains("Sep")) || (nri_endDate.contains("Nov"))) {
					randno2 = generator.nextInt(30) + 1;
				} else {
					randno2 = generator.nextInt(31) + 1;
				}
				nri_endDate = Integer.toString(randno2).concat(nri_endDate);
			}
		}
	}
	
	public void randomize_nri_status () {
		if (nri_status.equals("")) {
			Random generator = new Random();
			int randno = 0;
			List<String> list = new ArrayList<String>();

			list.add("Saved as Draft");
			list.add("Approved");
			list.add("Approved & Sent");
			randno = generator.nextInt(list.size());
			nri_status = list.get(randno);
		}
	}
	
	public void randomize_nri_invoiceTo () {
		if (nri_invoiceTo.equals("")) {
			Random generator = new Random();
			int randno = 0;
			List<String> list = new ArrayList<String>();

			list.add("University 0");
			list.add("University 1");
			list.add("University 2");
			list.add("University 3");
			list.add("University 4");
			list.add("University 5");
			list.add("University 6");
			list.add("University 7");
			list.add("University 8");
			list.add("University 9");
			randno = generator.nextInt(list.size());
			nri_invoiceTo = list.get(randno);
		}
	}
	
	public void randomize_nri_reference () {
		if (nri_reference.equals("")) {
			Random generator = new Random();
			int randno = 0;
			List<String> list = new ArrayList<String>();

			list.add("RPT200-X");
			list.add("RPT200-Y");
			list.add("RPT200-Z");
			randno = generator.nextInt(list.size());
			nri_reference = list.get(randno);
		}
	}
	
	public void randomize_nri_branding () {
		if (nri_branding.equals("")) {
			Random generator = new Random();
			int randno = 0;
			List<String> list = new ArrayList<String>();

			list.add("Standard");
			list.add("Special Projects");
			list.add("Very orange invoice!");
			randno = generator.nextInt(list.size());
			nri_branding = list.get(randno);
		}
	}
	
	public void randomize_nri_currency () {
		if (nri_currency.equals("")) {
			Random generator = new Random();
			int randno = 0;
			List<String> list = new ArrayList<String>();

			list.add("AUD Australian Dollar");
			list.add("CAD Canadian Dollar");
			list.add("EUR Euro");
			list.add("GBP British Pound");
			list.add("INR Indian Rupee");
			list.add("JPY Japanese Yen");
			list.add("NZD New Zealand Dollar");
			list.add("USD United States Dollar");
			randno = generator.nextInt(list.size());
			nri_currency = list.get(randno);
			
			switch (nri_currency) {
				case "AUD Australian Dollar" :
					nri_currencyAbbr = "AUD";
					break;
				case "CAD Canadian Dollar" :
					nri_currencyAbbr = "CAD";
					break;
				case "EUR Euro" :
					nri_currencyAbbr = "EUR";
					break;
				case "GBP British Pound" :
					nri_currencyAbbr = "GBP";
					break;
				case "INR Indian Rupee" :
					nri_currencyAbbr = "INR";
					break;
				case "JPY Japanese Yen" :
					nri_currencyAbbr = "JPY";
					break;
				case "NZD New Zealand Dollar" :
					nri_currencyAbbr = " ";
					break;
				case "USD United States Dollar" :
					nri_currencyAbbr = "USD";
					break;
				default: break;
			}
		}
	}
	
	public void randomize_nri_amountsAre () {
		if (nri_amountsAre.equals("")) {
			Random generator = new Random();
			int randno = 0;
			List<String> list = new ArrayList<String>();

			list.add("Tax Exclusive");
			list.add("Tax Inclusive");
			list.add("No Tax");
			randno = generator.nextInt(list.size());
			nri_amountsAre = list.get(randno);
		}
	}
	
	public void randomize_nri_table_items () {
		Random generator = new Random();
		int randno = 0;
		List<String> list = new ArrayList<String>();
		int numberOfItems = generator.nextInt(5) + 1;
		
		list.add("BOOK");
		list.add("GB1-White: Golf balls - white single");
		list.add("GB3-White: Golf balls - white 3-pack");
		list.add("GB6-White: Golf balls - white 6-pack");
		list.add("GB9-White: Golf balls - white 9 pack");
		list.add("PR-BR");
		list.add("Support-M");
		list.add("Train-MS");
		
		for (int i = 0; i < numberOfItems; i++) {
			randno = generator.nextInt(list.size());
			nri_table_items.add(list.get(randno));
			list.remove(randno);
		}
	}
	
	public void randomize () {
		randomize_nri_periodUnit();
		randomize_nri_timeUnitValue();
		randomize_nri_repeats();
		randomize_nri_startDate();
		randomize_nri_dueDateDay();
		randomize_nri_dueDateTypeValue ();
		randomize_nri_endDate ();
		randomize_nri_status();
		randomize_nri_amountsAre();
		randomize_nri_invoiceTo();
		randomize_nri_reference();
		randomize_nri_branding();
		randomize_nri_currency();
		randomize_nri_table_items();
	}
	
	public void displayDetails () {
		System.out.println("\t-----------------------------------------------------------------");
		System.out.println("\tRepeating Invoice [" + id + "] :");
		System.out.println("\t  Period Unit         = " + nri_periodUnit);
		System.out.println("\t  Time Unit Value     = " + nri_timeUnitValue);
		System.out.println("\t  Invoice Date        = " + nri_startDate);
		System.out.println("\t  Due Date Day        = " + nri_dueDateDay);
		System.out.println("\t  Due Date Type Value = " + nri_dueDateTypeValue);
		System.out.println("\t  End Date            = " + nri_endDate);
		System.out.println("\t  Status              = " + nri_status);
		System.out.println("\t  Invoice To          = " + nri_invoiceTo);
		System.out.println("\t  Branding            = " + nri_branding);
		System.out.println("\t  Reference           = " + nri_reference);
		System.out.println("\t  Currency            = " + nri_currency);
		System.out.println("\t  Amounts Are         = " + nri_amountsAre);
		System.out.println("\t  Item(s)");
		for (String item : nri_table_items) {
			System.out.println("\t\t" + item);
		}
		System.out.println("\t-----------------------------------------------------------------");
	}
	
	public void displayDetails_type2 () {
		System.out.println("\t-----------------------------------------------------------------");
		System.out.println("\tRepeating Invoice [" + id + "] :");
		System.out.println("\t  Name                = " + nri_invoiceTo);
		System.out.println("\t  Reference           = " + nri_reference);
		System.out.println("\t  Amount              = " + nri_total);
		System.out.println("\t  Currency            = " + nri_currencyAbbr);
		System.out.println("\t  Repeats             = " + nri_repeats);
		System.out.println("\t  Next Invoice Data   = " + nri_startDate);
		System.out.println("\t  End Date            = " + nri_endDate);
		System.out.println("\t  Invoice Will Be     = " + nri_status);
		System.out.println("\t  Invoice ID          = " + nri_invoiceDataId);
		System.out.println("\t-----------------------------------------------------------------");
	}
	
}