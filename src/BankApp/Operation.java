package BankApp;

import java.text.DateFormat;
import java.time.LocalDateTime;

public final class Operation {

    int accountANbr;
    int accountBNbr;
    float cashTransfered;
    LocalDateTime operationDate;

    //! Constructor
    public Operation(int accountANbr, int accountBNbr, float cashTransfered, LocalDateTime operationDate) {
        this.accountANbr = accountANbr;
        this.accountBNbr = accountBNbr;
        this.cashTransfered = cashTransfered;
        this.operationDate = operationDate;
    }

    public String operationResume() {
        return "Compte " + accountANbr + " -> compte " + accountBNbr + " | montant " + cashTransfered + " | date " + operationDate;
    }


}
