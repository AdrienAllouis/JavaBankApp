package BankApp;

import java.text.DateFormat;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    static BankService service = new BankService();

    public static void menu() {

        while (true) {

            System.out.println("\n*** Menu ***");

            System.out.println("1- Création d'une banque");
            System.out.println("2- Gérer une banque");
            System.out.println("3- Voir mes banques");
            System.out.println("4- Quitter");

            int userSelection;

            userSelection = sc.nextInt();


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
                    service.displayBanks();
                    break;
                }
                case(4): {
                    System.out.println("Bye bye !");
                    System.exit(0);
                }
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

        while (true) {

            System.out.println("\n*** Menu de gestion de banque ***");
            System.out.println("1- Ajouter un compte");
            System.out.println("2- Faire un transfert");
            System.out.println("3- Voir les comptes");
            System.out.println("4- Rechercher un compte");
            System.out.println("5- Rechercher un client");
            System.out.println("6- Retour");

            int userSelection;

            userSelection = sc.nextInt();

            switch (userSelection) {
                case(1): {
                    accountCreation();
                    break;
                }
                case(2): {
                    int userSelectionFirstAccount;
                    int userSelectionSecondAccount;
                    int cashToTransfert;

                    Account accountA;
                    Account accountB;

                    System.out.println("Numero du compte 1 :");
                    userSelectionFirstAccount = sc.nextInt();

                    accountA = service.selectAnAccount(userSelectionFirstAccount);

                    System.out.println("Numero du compte 2 :");
                    userSelectionSecondAccount = sc.nextInt();

                    accountB = service.selectAnAccount(userSelectionSecondAccount);

                    System.out.println("Montant :");
                    cashToTransfert = sc.nextInt();

                    service.transfert(accountA, accountB, cashToTransfert);

                    System.out.println(accountA.resume());
                    System.out.println(accountB.resume());

                    break;
                }
                case(3): {
                    service.displayAllAccount();
                    break;
                }
                case(4): {
                    int userSelectionAccount;

                    System.out.println("Numero du compte :");
                    userSelectionAccount = sc.nextInt();

                    service.searchAnAccount(userSelectionAccount);

                    break;
                }
                case(5): {
                    String userSelectionClient;
                    Client client;

                    System.out.println("Nom du client :");
                    userSelectionClient = sc.next();

                    service.searchClient(userSelectionClient);

                    client = service.selectClient(userSelectionClient);

                    service.searchClientAccounts(client);
                }
                case(6): {
                    return;
                }
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
