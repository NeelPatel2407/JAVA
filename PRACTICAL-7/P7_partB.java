import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Positive
{
    String message() default "must be > 0";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength
{
    int value();
}

@FunctionalInterface
interface WithdrawRule
{
    boolean allow(Account account,long amount);
}

class Account
{
    @Id
    private long accountNumber;

    @Positive
    private long balance;

    private double rate;

    Account(long accountNumber,long balance,double rate)
    {
        this.accountNumber=accountNumber;
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

    public long getBalance()
    {
        return balance;
    }

    @Override
    public String toString()
    {
        return "Account: "+accountNumber+" Balance: "+balance;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;

        if(obj==null||getClass()!=obj.getClass())
            return false;

        Account a=(Account)obj;
        return accountNumber==a.accountNumber;
    }

    @Override
    public int hashCode()
    {
        return Long.hashCode(accountNumber);
    }
}

class AnnotationValidator
{
    public static String[] validate(Object obj)
    {
        String[] errors=new String[10];
        int count=0;

        try
        {
            Field[] fields=obj.getClass().getDeclaredFields();

            for(Field field:fields)
            {
                field.setAccessible(true);
                Object value=field.get(obj);

                if(field.isAnnotationPresent(Positive.class))
                {
                    if(value instanceof Number&&((Number)value).doubleValue()<=0)
                    {
                        Positive p=field.getAnnotation(Positive.class);
                        errors[count++]=field.getName()+" "+p.message();
                    }
                }

                if(field.isAnnotationPresent(MaxLength.class))
                {
                    MaxLength m=field.getAnnotation(MaxLength.class);

                    if(value!=null&&value.toString().length()>m.value())
                    {
                        errors[count++]=field.getName()+" must have maximum "+m.value()+" characters";
                    }
                }
            }
        }
        catch(Exception e)
        {
            errors[count++]="Validation error";
        }

        String[] result=new String[count];

        for(int i=0;i<count;i++)
        {
            result[i]=errors[i];
        }

        return result;
    }
}

public class P7_partB
{
    public static void main(String[] args)
    {
        Account account=new Account(101,-5000,5);

        String[] errors=AnnotationValidator.validate(account);

        for(String error:errors)
        {
            System.out.println(error);
        }
    }
}