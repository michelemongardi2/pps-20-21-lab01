import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest{

    @Override
    protected BankAccount getBankAccount(AccountHolder accountHolder, double balance) {
        return new SimpleBankAccountWithAtm(accountHolder, balance);
    }

}
