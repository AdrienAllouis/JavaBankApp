package BankApp;

import java.util.ArrayList;

public final class Registre {

    private ArrayList<Operation> operations = new ArrayList<>();
    int nbrOperation;

    public void addOperation(Operation newOperation) {
        operations.add(newOperation);
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
