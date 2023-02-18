package BankApp;

public abstract class Account {

	int idNbr;
	float cash;
	String accountName;
	
	static int nbOpenAccount = 0;
	
	Client owner;
	
	public Account(String accountName, float cash) {
		this.accountName = accountName;
		this.cash = cash;
		
		this.idNbr = getNbAccount();
		
		addNewAccount();
	}

	public int getIdNbr() {
		return idNbr;
	}

	public void setIdNbr(int idNbr) {
		this.idNbr = idNbr;
	}

	public float getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	// *** methods ***

	private static void addNewAccount() {
		nbOpenAccount++;
	}
	
	private static int getNbAccount() {
		return nbOpenAccount;
	}
	
	public abstract String resume();
	
}
