interface Transactable
{
    void deposit(long amount);
    boolean withdraw(long amount);
}

interface InterestBearing
{
    double interestRate();
    double balance();

    default double yearlyInterest()
    {
        return balance()*interestRate()/100;
    }
}

@FunctionalInterface
interface WithdrawRule
{
    boolean allow(Account account,long amount);
}

interface Premium
{
}

class Account implements Transactable,InterestBearing,Premium
{
    private long balance;
    private double rate;

    public Account(long balance,double rate)
    {
        this.balance=balance;
        this.rate=rate;
    }

    public void deposit(long amount)
    {
        balance+=amount;
    }

    public boolean withdraw(long amount)
    {
        if(amount<=balance)
        {
            balance-=amount;
            return true;
        }

        return false;
    }

    public double interestRate()
    {
        return rate;
    }

    public double balance()
    {
        return balance;
    }

    public long getBalance()
    {
        return balance;
    }
}

public class P6_partB
{
    public static void main(String[] args)
    {
        Account account=new Account(10000,5);

        account.deposit(5000);

        WithdrawRule rule1=new WithdrawRule()
        {
            public boolean allow(Account account,long amount)
            {
                return amount<=account.getBalance();
            }
        };

        WithdrawRule rule2=(acc,amount)->amount<=acc.getBalance();

        System.out.println("Balance: "+account.getBalance());
        System.out.println("Anonymous Class: "+rule1.allow(account,3000));
        System.out.println("Lambda: "+rule2.allow(account,12000));

        if(rule1.allow(account,3000))
        {
            account.withdraw(3000);
            System.out.println("Withdrawal successful");
        }
        else
        {
            System.out.println("Withdrawal denied");
        }

        System.out.println("New Balance: "+account.getBalance());
        System.out.println("Yearly Interest: "+account.yearlyInterest());
        System.out.println("Premium Account: "+(account instanceof Premium));
    }
}