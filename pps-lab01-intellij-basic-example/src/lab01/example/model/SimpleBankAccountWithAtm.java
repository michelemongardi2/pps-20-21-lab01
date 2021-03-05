package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account With Atm allows the deposit and the withdraw using also the ATM.
 * Each transaction done with the ATM implies paying a fee
 */

public class SimpleBankAccountWithAtm extends AbstractSimpleBankAccount {

    private static final int DEPOSIT_ATM_FEE = 1;
    private static final int WITHDRAW_ATM_FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    public void depositeWithAtm(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.setBalance(this.getBalance() + getDepositAmountWithFee(amount));
        }
    }

    public void withdrawWithAtm(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.setBalance(this.getBalance() - getWithdrawAmountWithFee(amount));
        }
    }

    private double getWithdrawAmountWithFee(double amount){
        return amount + WITHDRAW_ATM_FEE;
    }

    private double getDepositAmountWithFee(double amount){
        return amount - DEPOSIT_ATM_FEE;
    }

    @Override
    boolean isWithdrawAllowed(double amount) {
        return this.getBalance() >= amount + WITHDRAW_ATM_FEE;
    }
}
