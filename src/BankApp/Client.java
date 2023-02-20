package BankApp;

import java.time.LocalDateTime;

public class Client {

	String lastName;
	String firstName;
	LocalDateTime birthDate;
	LocalDateTime openAccountDate;

	float totalAccounts;
	
	public Client(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDateTime getOpenAccountDate() {
		return openAccountDate;
	}

	public void setOpenAccountDate(LocalDateTime openAccountDate) {
		this.openAccountDate = openAccountDate;
	}

	public float getTotalAccounts() {
		return totalAccounts;
	}

	public void setTotalAccounts(float totalAccounts) {
		this.totalAccounts = totalAccounts;
	}

	public float calculTotalAccount(Client client) {
		BankService service= new BankService();
		return totalAccounts = service.sumClientAccounts(client);
	}


	public int compareTo(Object compareTo) {

		Client compareToCli = (Client)compareTo;

		// Les trois comparaisons
		if (totalAccounts == compareToCli.totalAccounts) return 0;
		if (totalAccounts > compareToCli.totalAccounts) return 1;
		return -1;
	}
}
