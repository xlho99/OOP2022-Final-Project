


public class ATM_Exception extends Exception{
	
	public enum ExceptionTYPE {
		
		BALANCE_NOT_ENOUGH,
		AMOUNT_INVALID;
		
	};
	
	private ExceptionTYPE exceptionCondition = null; 
		
	public ATM_Exception(ExceptionTYPE errmessage) {
		//super(errmessage);
		if (errmessage ==  ExceptionTYPE.BALANCE_NOT_ENOUGH) {
			exceptionCondition = ExceptionTYPE.BALANCE_NOT_ENOUGH;
		}
		else {
			exceptionCondition = ExceptionTYPE.AMOUNT_INVALID;
		}
	}
	
	public String getMessage() {
		String output = null;
		output = exceptionCondition.toString();
		return output;
	}

}
