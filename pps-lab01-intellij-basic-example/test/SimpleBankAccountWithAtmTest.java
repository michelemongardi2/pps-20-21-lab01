import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest <SimpleBankAccountWithAtm>{

    @Override
    protected SimpleBankAccountWithAtm getBankAccount(AccountHolder accountHolder, double balance) {
        return new SimpleBankAccountWithAtm(accountHolder, balance);
    }
}
