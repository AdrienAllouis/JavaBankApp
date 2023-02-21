package BankApp;

import java.text.DateFormat;
import java.util.ArrayList;

public class Bank {

	String name;
	String address;
	DateFormat creationDate;
	
	ArrayList<Client> clients;
	ArrayList<Account> accounts;
	
	int nbClients;
	int nbAccounts;
	
	public Bank(String name, String address, DateFormat creationDate) {
		this.name = name;
		this.address = address;
		this.creationDate = creationDate;
		
		this.clients = new ArrayList<>();
		this.accounts = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	// *** methods ***
	
	public void addClient(Client client) {
		this.clients.add(client);
		nbClients++;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
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
				System.out.println(account.accountName + " | " + account.getCash());
			} else {
				return;
			}
		}
	}
}
