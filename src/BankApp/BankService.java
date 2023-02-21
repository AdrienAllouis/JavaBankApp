package BankApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankService {
	
	static List<Bank> banks = new ArrayList<>();
	static int nbBanks;
	Registre registre = new Registre();
	
	public void addBank(Bank bank) {
		banks.add(bank);
		nbBanks++;
	}
	
	public void displayBanks() {
		for (Bank bank : banks) {
			if (bank != null) System.out.println(bank.name);
		}
	}
	
	public void displayAllAccount() {
		for (Bank bank : banks) {
			Collections.sort(bank.accounts);
			if (bank != null) bank.displayAccounts();
		}
	}

	public void searchClient(String userSelection) {
		for (Bank bank : banks) {
			if (bank == null) continue; // <- ca c'est cool !

			for (Client client : bank.clients) {
				if (client != null && client.getLastName().equals(userSelection)) {
					System.out.println(client.lastName + " " + client.firstName);
				}
			}
		}
	}

	public float sumClientAccounts(Client client) {
		float total = 0;
		for (Bank bank : banks) {
			if (bank == null) continue; // <- ca c'est cool !

			for (Account account : bank.accounts) {
				if (account != null && account.getOwner() == client) {
					total = total + account.cash;
				}
			}
		}
		return total;
	}

	public void searchClientAccounts(Client userSelection) {
		for (Bank bank : banks) {
			if (bank == null) continue; // <- ca c'est cool !

			for (Account account : bank.accounts) {
				if (account != null && account.getOwner() == userSelection) {
					System.out.println(account.resume());
				}
			}
		}
	}

	public Client selectClient(String userSelection) {
		Client clientSelected = null;

		for (Bank bank : banks) {
			if (bank == null) continue; // <- ca c'est cool !

			for (Client client : bank.clients) {
				if (client != null && client.getLastName().equals(userSelection)) {
					clientSelected = client;
				}
			}
		}
		return clientSelected;
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

	public Account selectAnAccount(int userSelection) {
		Account accountFound = null;
		for (Bank bank : banks) {
			if (bank == null) continue; // <- ca c'est cool !

			for (Account account : bank.accounts) {
				if (account != null && account.idNbr == userSelection) {
					accountFound = account;
				}
			}

		} return accountFound;
	}
	
	public void transfert(Account accountA, Account accountB, float cashToTransfert) {
		System.out.println("Transfert");
		LocalDateTime df = LocalDateTime.now();
		
		if (accountA instanceof CurrentAccount && accountB instanceof CurrentAccount) { // 2 current account
			if (cashToTransfert > 0) {
				if (accountA.getCash() + ((CurrentAccount) accountA).getMaxOverdraft() >= cashToTransfert) {
					accountA.setCash(accountA.getCash() - cashToTransfert);
					accountB.setCash(accountB.getCash() + cashToTransfert);

					((CurrentAccount) accountA).updateMaxOverdraft();
					((CurrentAccount) accountB).updateMaxOverdraft();

					Operation newOperation = new Operation(accountA.idNbr, accountB.idNbr, cashToTransfert, df);
					registre.addOperation(newOperation);
				} else {
					System.out.println("Transfert impossible");
				}
			} else if (cashToTransfert > 0) {
				cashToTransfert = cashToTransfert * -1;

				if (accountB.getCash() + ((CurrentAccount) accountB).getMaxOverdraft() >= cashToTransfert) {
					accountB.setCash(accountB.getCash() - cashToTransfert);
					accountA.setCash(accountA.getCash() + cashToTransfert);

					((CurrentAccount) accountA).updateMaxOverdraft();
					((CurrentAccount) accountB).updateMaxOverdraft();

					Operation newOperation = new Operation(accountA.idNbr, accountB.idNbr, cashToTransfert, df);
					registre.addOperation(newOperation);
				} else {
					System.out.println("Transfert impossible");
				}
			} else {
				return;
			}

		} else if (accountA instanceof CurrentAccount && accountB instanceof SavingsAccount) {
			if (cashToTransfert > 0) {
				if (accountA.getCash() + ((CurrentAccount) accountA).getMaxOverdraft() >= cashToTransfert) {
					accountA.setCash(accountA.getCash() - cashToTransfert);
					accountB.setCash(accountB.getCash() + cashToTransfert);

					((CurrentAccount) accountA).updateMaxOverdraft();

					Operation newOperation = new Operation(accountA.idNbr, accountB.idNbr, cashToTransfert, df);
					registre.addOperation(newOperation);
				} else {
					System.out.println("Transfert impossible");
					return;
				}
			} else if (cashToTransfert > 0) {
				cashToTransfert = cashToTransfert * -1;

				if (accountB.getCash() >= cashToTransfert) {
					accountB.setCash(accountB.getCash() - cashToTransfert);
					accountA.setCash(accountA.getCash() + cashToTransfert);

					((CurrentAccount) accountA).updateMaxOverdraft();

					Operation newOperation = new Operation(accountA.idNbr, accountB.idNbr, cashToTransfert, df);
					registre.addOperation(newOperation);
				} else {
					System.out.println("Transfert impossible");
					return;
				}
			} else {
				return;
			}

		} else if (accountA instanceof SavingsAccount && accountB instanceof CurrentAccount) {
			if (cashToTransfert > 0) {
				if (accountA.getCash() >= cashToTransfert) {
					accountA.setCash(accountA.getCash() - cashToTransfert);
					accountB.setCash(accountB.getCash() + cashToTransfert);

					((CurrentAccount) accountB).updateMaxOverdraft();

					Operation newOperation = new Operation(accountA.idNbr, accountB.idNbr, cashToTransfert, df);
					registre.addOperation(newOperation);
				} else {
					System.out.println("Transfert impossible");
					return;
				}
			} else if (cashToTransfert > 0) {
				cashToTransfert = cashToTransfert * -1;

				if (accountB.getCash() + ((CurrentAccount) accountB).getMaxOverdraft() >= cashToTransfert) {
					accountB.setCash(accountB.getCash() - cashToTransfert);
					accountA.setCash(accountA.getCash() + cashToTransfert);

					((CurrentAccount) accountB).updateMaxOverdraft();

					Operation newOperation = new Operation(accountA.idNbr, accountB.idNbr, cashToTransfert, df);
					registre.addOperation(newOperation);
				} else {
					System.out.println("Transfert impossible");
					return;
				}
			} else {
				return;
			}

		} else if (accountA instanceof SavingsAccount && accountB instanceof SavingsAccount) {
			if (cashToTransfert > 0) {
				if (accountA.getCash() >= cashToTransfert) {
					accountA.setCash(accountA.getCash() - cashToTransfert);
					accountB.setCash(accountB.getCash() + cashToTransfert);

					Operation newOperation = new Operation(accountA.idNbr, accountB.idNbr, cashToTransfert, df);
					registre.addOperation(newOperation);
				} else {
					System.out.println("Transfert impossible");
					return;
				}
			} else if (cashToTransfert > 0) {
				cashToTransfert = cashToTransfert * -1;

				if (accountB.getCash() >= cashToTransfert) {
					accountB.setCash(accountB.getCash() - cashToTransfert);
					accountA.setCash(accountA.getCash() + cashToTransfert);

					Operation newOperation = new Operation(accountA.idNbr, accountB.idNbr, cashToTransfert, df);
					registre.addOperation(newOperation);
				} else {
					System.out.println("Transfert impossible");
					return;
				}
			} else {
				return;
			}
		}
	}

	public void displayRegistre() {
		registre.displayOperations();
	}
}
