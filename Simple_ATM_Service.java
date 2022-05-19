
/**
 * 
 * @author yuhanchiang
 * @version 2022/5/17
 */

public class Simple_ATM_Service implements ATM_Service{
	
	public boolean throwE1 = false;			// ensures for only one exception

	@Override
	public boolean checkBalance(Account account, int money) throws ATM_Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (account.getBalance() >= money) {
			flag = true;
		} else {
			throwE1 = true;
			
			throw new ATM_Exception(ATM_Exception.ExceptionTYPE.BALANCE_NOT_ENOUGH);
		}
		return flag;
	}

	@Override
	public boolean isValidAmount(int money) throws ATM_Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (money % 1000 == 0) {
			flag = true;
		} else {
			
			throw new ATM_Exception(ATM_Exception.ExceptionTYPE.AMOUNT_INVALID);
			
		}
		return flag;
	}

	@Override
	public void withdraw(Account account, int money) {
		boolean flag1 = false;
		boolean flag2 = false;
		int before = account.getBalance();
		int after = 0;
		
		// TODO Auto-generated method stub
		try {
			flag1 = checkBalance(account, money);
			if (throwE1 == false) {		// ensures for only one exception 
				flag2 = isValidAmount(money);
			}
		// might throw two exceptions
		}
		catch (ATM_Exception e){
			System.out.println(e.getMessage());
		}
		if (flag1 && flag2) {
			after = before - money;
			account.setBalance(after);
			before = after;
			
		}
		System.out.println("updated balance : " + before);
		
		
	}

}
