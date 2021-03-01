import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest <SimpleBankAccountWithAtm>{

    @Override
    protected SimpleBankAccountWithAtm getBankAccount(AccountHolder accountHolder, double balance) {
        return new SimpleBankAccountWithAtm(accountHolder, balance);
    }

    @Test
    void testDepositWithAtm(){
        bankAccount.depositeWithAtm(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.depositeWithAtm(accountHolder.getId(), 100);
        bankAccount.depositeWithAtm(2, 50);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm(){
        bankAccount.depositeWithAtm(accountHolder.getId(), 100);
        bankAccount.withdrawWithAtm(accountHolder.getId(), 70);
        assertEquals(28, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.depositeWithAtm(accountHolder.getId(), 100);
        bankAccount.withdrawWithAtm(2, 70);
        assertEquals(99, bankAccount.getBalance());
    }
}
