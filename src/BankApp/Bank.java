package BankApp;

import java.text.DateFormat;

public class Bank {

	String name;
	String adress;
	DateFormat creationDate;
	
	Client clients[];
	Account accounts[];
	
	int nbClients;
	int nbAccounts;
	
	public Bank(String name, String adress, DateFormat creationDate) {
		this.name = name;
		this.adress = adress;
		this.creationDate = creationDate;
		
		this.clients = new Client[1000];
		this.accounts = new Account[1000];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client[] getClients() {
		return clients;
	}

	public void setClients(Client[] clients) {
		this.clients = clients;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	// *** methods ***
	
	public void addClient(Client client) {
		this.clients[nbClients] = client;
		nbClients++;
	}
	
	public void addAccount(Account account) {
		this.accounts[nbAccounts] = account;
		nbAccounts++;
	}
	
	public void displayClients() {
		for (Client client : clients) {
			if (client != null) {
				System.out.println(client.firstName + " " + client.lastName);
			} else {
				return;
			}
		}
	}
	
	public void displayAccounts() {
		for (Account account : accounts) {
			if (account != null) {
				System.out.println(account.accountName);
			} else {
				return;
			}
		}
	}
}
