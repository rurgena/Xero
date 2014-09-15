package xero;

public class _Log {
	// divider
	public String dividerS				= "============================================ START TEST ============================================";
	public String dividerE				= "============================================= END TEST =============================================\n\n";
	public String dividerM				= "----------------------------------------------------------------------------------------------------";
	
	public void disp (String message) throws Exception {
		System.out.println(message);
	}
	
	public void debug (String message) throws Exception {
		disp("\t" + message);
	}
	
	public void step (String message) throws Exception {
		disp("\n[STEP] " + message);
	}
	
	public void result (String message) throws Exception {
		disp("[RESULT] " + message);
	}
}
