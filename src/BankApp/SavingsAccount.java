package BankApp;

public class SavingsAccount extends Account {

	public SavingsAccount(String accountName, float cash) {
		super(accountName, cash);
	}
	
	@Override
	public String resume() {
		return "Account n°" + idNbr + " named " + accountName + " cash " + cash;
	}
	
	
}
