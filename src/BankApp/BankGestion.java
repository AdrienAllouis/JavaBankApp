package BankApp;

public class BankGestion {
	
	static Bank banks[] = new Bank[1000];
	static int nbBanks;
	
	public void addBank(Bank bank) {
		banks[nbBanks] = bank;
		nbBanks++;
	}
	
	public void displayBanks() {
		for (Bank bank : banks) {
			if (bank != null) System.out.println(bank.name);
		}
	}
	
	public void displayAllAccount() {
		for (Bank bank : banks) {
			if (bank != null) bank.displayAccounts();
		}
	}
	
	public void searchAnAccount(int userSelection) {
		for (Bank bank : banks) {
			if (bank == null) continue; // <- ca c'est cool !
			
			for (Account account : bank.accounts) {
				if (account != null && account.idNbr == userSelection) {
					System.out.println(account.resume());
				}
			}
			
		}
	}
}
