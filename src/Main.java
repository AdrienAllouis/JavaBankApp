import java.text.DateFormat;
import java.util.Scanner;

import BankApp.Bank;
import BankApp.BankGestion;
import BankApp.Client;
import BankApp.CurrentAccount;
import BankApp.SavingsAccount;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
	static BankGestion gestion = new BankGestion();

	public static void main(String[] args) {
		
		System.out.println("*** Test account resume ***");
		
		CurrentAccount currentA = new CurrentAccount("CurrentAccountA", 1000);
		
		SavingsAccount savingsA = new SavingsAccount("SavingsAccountA", 100);
		System.out.println(currentA.resume());
		System.out.println(savingsA.resume());
		
		CurrentAccount currentB = new CurrentAccount("CurrentAccountB", 5000);
		SavingsAccount savingsB = new SavingsAccount("SavingsAccountB", 500);
		System.out.println(currentB.resume());
		System.out.println(savingsB.resume());
		
		System.out.println("\n*** Test bank ***"); 
		
		Bank bankA = new Bank("BankA", "AddressA", df);
		gestion.addBank(bankA);
		Bank bankB = new Bank("BankB", "AddressB", df);
		gestion.addBank(bankB);
		
		Client clientA = new Client("TrucA", "BobA");
		Client clientB = new Client("TrucB", "BobB");
		
		CurrentAccount currentC = new CurrentAccount("CurrentAccountC", 5000);
		SavingsAccount savingsC = new SavingsAccount("SavingsAccountC", 500);
		
		currentC.setOwner(clientA);
		savingsC.setOwner(clientA);
		
		bankA.addClient(clientA);
		bankA.addClient(clientB);
		
		bankB.addAccount(currentA);
		bankA.addAccount(currentB);
		bankB.addAccount(currentC);
		bankA.addAccount(savingsA);
		bankB.addAccount(savingsB);
		bankB.addAccount(savingsC);
		
		System.out.println("***** List client bank A ***");
		bankA.displayClients();
		System.out.println("***** List account bank A ***");
		bankA.displayAccounts();
		System.out.println("***** List account bank B ***");
		bankB.displayAccounts();
		
		//! Menu
		
		System.out.println("\n*** Menu ***");
		
		System.out.println("1- Création d'une banque");
		System.out.println("2- Gérer une banque");
		System.out.println("3- Voir mes banques");
		System.out.println("4- Quitter");
		
		boolean out;
		int userSelection;
		
		do {
			out = true;
			userSelection = sc.nextInt();
			
			if (userSelection < 0 || userSelection > 4) {
				out = false;
				System.out.println("Erreur, Choix entre 1 et 4");
			}
		} while (!out);
		
		switch (userSelection) {
			case(1): {
				bankCreation();
				break;
			}
			case(2): {
				bankGestion();
				break;
			}
			case(3): {
				gestion.displayBanks();
				break;
			}
			case(4): {
				System.out.println("Bye bye !");
				break;
			}
		}
	}
	
	public static void bankCreation() {
		String bankName;
		String bankAddress;
		
		
		System.out.println("Nom de la banque :");
		bankName = sc.next();
		
		System.out.println("Adresse de la banque :");
		bankAddress = sc.next();
		
		Bank newBank = new Bank(bankName, bankAddress, df);
		System.out.println("Création de : " + newBank.getName());
	}
	
	public static void bankGestion() {
		System.out.println("\nMenu de gestion de banque");
		System.out.println("1- Ajouter un compte");
		System.out.println("2- Faire un transfert");
		System.out.println("3- Voir les comptes");
		System.out.println("4- Rechercher un compte");
		System.out.println("5- Rechercher un client");
		System.out.println("6- Retour");
		
		boolean out;
		int userSelection;
		
		do {
			out = true;
			userSelection = sc.nextInt();
			
			if (userSelection < 0 || userSelection > 6) {
				out = false;
				System.out.println("Erreur, Choix entre 1 et 6");
			}
		} while (!out);
		
		switch (userSelection) {
			case(1): {
				accountCreation();
				break;
			}
			case(2): {
				// TODO : transfert entre deux compte
			}
			case(3): {
				gestion.displayAllAccount();
				break;
			}
			case(4): {
				gestion.searchAnAccount(userSelection);;
				break;
			}
			case(5): {
				// TODO : Recherche client
			}
			case(6): {
				// TODO : Retour
			}
		}
	}
	
	public static void accountCreation() {
		String accountName;
		float cash;
		int type;
		
		System.out.println("Dépot :");
		cash = sc.nextFloat();
		
		System.out.println("Nom du compte :");
		accountName = sc.next();
		
		System.out.println("Type de compte");
		System.out.println("1- Courant");
		System.out.println("2- Epargne");
		type = sc.nextInt();
		
		if (type == 1) {
			CurrentAccount newAccount = new CurrentAccount(accountName, cash);
			System.out.println(newAccount.resume());
		} else if (type == 2){
			SavingsAccount newAccount = new SavingsAccount(accountName, cash);
			System.out.println(newAccount.resume());
		} else {
			System.out.println("Erreur");
		}
	}

}
