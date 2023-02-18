package BankApp;

public class CurrentAccount extends Account {

	float maxOverdraft;
	TypeCard typeCard;
	
	public CurrentAccount(String accountName, float cash) {
		super(accountName, cash);
		
		updateMaxOverdraft();
	}

	public float getMaxOverdraft() {
		return maxOverdraft;
	}



	public void setMaxOverdraft(float maxOverdraft) {
		this.maxOverdraft = maxOverdraft;
	}



	public void updateMaxOverdraft() {
		this.maxOverdraft = this.cash / 2;
	}
	
	@Override
	public String resume() {
		return "Account n°" + idNbr + " named " + accountName + " cash " + cash + " overload " + maxOverdraft;
	}
	
	
	
}
