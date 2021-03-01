import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractSimpleBankAccountTest {

    @Override
    protected BankAccount getBankAccount(AccountHolder accountHolder, double balance) {
        return new SimpleBankAccount(accountHolder, balance);
    }

}
