import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest <SimpleBankAccountWithAtm>{

    public static final int DEPOSIT_AMOUNT_WITH_ATM = 100;
    public static final int WITHDRAW_AMOUNT_WITH_ATM = 70;
    public static final int DEPOSIT_ATM_FEE = 1;
    public static final int WITHDRAW_ATM_FEE = 1;

    @Override
    protected SimpleBankAccountWithAtm setTestedTypeBankAccount(AccountHolder accountHolder, double initialBalance) {
        return new SimpleBankAccountWithAtm(accountHolder, initialBalance);
    }

    @Test
    void testDepositWithAtm(){
        bankAccount.depositeWithAtm(accountHolder.getId(), DEPOSIT_AMOUNT_WITH_ATM);
        assertEquals(DEPOSIT_AMOUNT_WITH_ATM - DEPOSIT_ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.depositeWithAtm(accountHolder.getId(), DEPOSIT_AMOUNT_WITH_ATM);
        bankAccount.depositeWithAtm(WRONG_ID_ACCOUNT_HOLDER, WRONG_DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT_WITH_ATM - DEPOSIT_ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm(){
        bankAccount.depositeWithAtm(accountHolder.getId(), DEPOSIT_AMOUNT_WITH_ATM);
        bankAccount.withdrawWithAtm(accountHolder.getId(), WITHDRAW_AMOUNT_WITH_ATM);
        assertEquals(DEPOSIT_AMOUNT_WITH_ATM - WITHDRAW_AMOUNT_WITH_ATM - DEPOSIT_ATM_FEE - WITHDRAW_ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.depositeWithAtm(accountHolder.getId(), DEPOSIT_AMOUNT_WITH_ATM);
        bankAccount.withdrawWithAtm(WRONG_ID_ACCOUNT_HOLDER, WITHDRAW_AMOUNT_WITH_ATM);
        assertEquals(DEPOSIT_AMOUNT_WITH_ATM - WITHDRAW_ATM_FEE, bankAccount.getBalance());
    }
}
