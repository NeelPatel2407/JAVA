abstract class Account{
    protected String name;
    protected long accountNumber;
    protected long balance;

    public Account(String name,long accountNumber,long balance){
        this.name=name;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);
}

class SavingsAccount extends Account{
    private long minBalance;

    public SavingsAccount(String name,long accountNumber,long balance,long minBalance){
        super(name,accountNumber,balance);
        this.minBalance=minBalance;
    }

    public double interestRate(){
        return 4.0;
    }

    public boolean canWithdraw(long amount){
        return balance-amount>=minBalance;
    }
}

class CurrentAccount extends Account{
    private long overdraftLimit;

    public CurrentAccount(String name,long accountNumber,long balance,long overdraftLimit){
        super(name,accountNumber,balance);
        this.overdraftLimit=overdraftLimit;
    }

    public double interestRate(){
        return 0.0;
    }

    public boolean canWithdraw(long amount){
        return balance-amount>=-overdraftLimit;
    }
}

class FixedDepositAccount extends Account{

    public FixedDepositAccount(String name,long accountNumber,long balance){
        super(name,accountNumber,balance);
    }

    public double interestRate(){
        return 7.0;
    }

    public boolean canWithdraw(long amount){
        return false;
    }
}

public class P5_partB{
    public static void main(String[] args){
        Account[] accounts={
            new SavingsAccount("Neel",101,5000,100),
            new CurrentAccount("Selvy",102,6000,1500),
            new FixedDepositAccount("Kavy",103,3000)
        };

        for(Account account:accounts){
            System.out.println("Account Holder: "+account.name);
            System.out.println("Interest Rate: "+account.interestRate()+"%");

            if(account instanceof FixedDepositAccount){
                System.out.println("Note: Fixed Deposit is locked.");
            }

            System.out.println();
        }
    }
}