import java.text.DateFormat;

import BankApp.*;

public class Main {

	static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
	static BankService service = new BankService();

	public static void main(String[] args) {

		System.out.println("*** Test account resume ***");

		CurrentAccount currentA = new CurrentAccount("CurrentAccountA", 1000);

		SavingsAccount savingsA = new SavingsAccount("SavingsAccountA", 100);
		System.out.println(currentA.resume());
		System.out.println(savingsA.resume());

		CurrentAccount currentB = new CurrentAccount("CurrentAccountB", 3000);
		SavingsAccount savingsB = new SavingsAccount("SavingsAccountB", 300);
		System.out.println(currentB.resume());
		System.out.println(savingsB.resume());

		System.out.println("\n*** Test bank ***");

		Bank bankA = new Bank("BankA", "AddressA", df);
		service.addBank(bankA);
		Bank bankB = new Bank("BankB", "AddressB", df);
		service.addBank(bankB);

		Client clientA = new Client("TrucA", "BobA");
		Client clientB = new Client("TrucB", "BobB");

		CurrentAccount currentC = new CurrentAccount("CurrentAccountC", 5000);
		SavingsAccount savingsC = new SavingsAccount("SavingsAccountC", 500);

		currentA.setOwner(clientB);
		savingsA.setOwner(clientB);

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

		System.out.println("\n*** Test registre ***");

		service.transfert(currentA, currentB, 150);
		service.transfert(currentC, savingsA, 150);
		service.transfert(savingsB, savingsC, 150);

		service.displayRegistre();

		System.out.println("\n*** Test sum accounts ***");

		System.out.println(service.sumClientAccounts(clientA));

		System.out.println("\n*** Test compareTo Client ***");

		System.out.println(clientA.calculTotalAccount(clientA));
		System.out.println(clientB.calculTotalAccount(clientB));

		System.out.println(clientB.compareTo(clientA));

		System.out.println("\n*** Test compareTo Account ***");

		System.out.println(currentA.compareTo(currentB));
		System.out.println(currentB.compareTo(currentA));

		//! Menu
		Menu.menu();

	}
}
