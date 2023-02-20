package BankApp;

public final class Registre {

    Operation operations[] = new Operation[1000];
    int nbrOperation;

    public void addOperation(Operation newOperation) {
        operations[nbrOperation] = newOperation;
        nbrOperation++;
    }

    public void displayOperations() {
        for (Operation operation : operations) {
            if (operation != null) {
                System.out.println(operation.operationResume());
            }
        }
    }

}
