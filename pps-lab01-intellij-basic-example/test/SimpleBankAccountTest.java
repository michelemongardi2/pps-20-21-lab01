import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractSimpleBankAccountTest <SimpleBankAccount> {

    @Override
    protected SimpleBankAccount setTestedTypeBankAccount(AccountHolder accountHolder, double initialBalance) {
        return new SimpleBankAccount(accountHolder, initialBalance);
    }
}
