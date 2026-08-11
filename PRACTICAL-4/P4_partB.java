import java.util.regex.Pattern;

enum TransactionType 
{
    DEPOSIT,
    WITHDRAW,
    TRANSFER
}

record Command(TransactionType type,String accountNumber,long amount){}

public class P4_partB {

    static class Validator 
    {
        static Pattern mobile=Pattern.compile("^[6-9][0-9]{9}$");
        static Pattern email=Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        static Pattern pan=Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");
        static Pattern ifsc=Pattern.compile("^[A-Z]{4}0[A-Z0-9]{6}$");

        public static boolean isValidMobile(String s) 
        {
            return mobile.matcher(s).matches();
        }

        public static boolean isValidEmail(String s) 
        {
            return email.matcher(s).matches();
        }

        public static boolean isValidPan(String s) 
        {
            return pan.matcher(s).matches();
        }

        public static boolean isValidIfsc(String s) 
        {
            return ifsc.matcher(s).matches();
        }
    }


    static class CommandParser 
    {
        public static Command parse(String line) 
        {
            String[] a=line.split(" ");

            TransactionType type=TransactionType.valueOf(a[0]);
            String acc=a[1];
            long amount=Long.parseLong(a[2]);

            return new Command(type,acc,amount);
        }
    }

    static class Account 
    {
        String acc;
        String name;
        long balance;

        Account(String acc,String name,long balance)
        {
            this.acc=acc;
            this.name=name;
            this.balance=balance;
        }
    }

    static class StatementFormatter 
    {
        public static String buildStatement(Account ac) 
        {
            StringBuilder s=new StringBuilder();

            s.append("Account Statement\n");
            s.append("Account Number: "+ac.acc+"\n");
            s.append("Name: "+ac.name+"\n");
            s.append("Balance: "+ac.balance+"\n");

            return s.toString();
        }
    }

    public static void main(String[] args) 
    {

        System.out.println("Mobile:");
        System.out.println(Validator.isValidMobile("9726137865"));
        System.out.println(Validator.isValidMobile("12345"));

        System.out.println("Email:");
        System.out.println(Validator.isValidEmail("neelpatel00@gmail.com"));
        System.out.println(Validator.isValidEmail("abc@"));

        System.out.println("PAN:");
        System.out.println(Validator.isValidPan("VYNEE2405S"));
        System.out.println(Validator.isValidPan("PQR303"));

        System.out.println("IFSC:");
        System.out.println(Validator.isValidIfsc("UBIN0204671"));
        System.out.println(Validator.isValidIfsc("UBIN543"));

        Command c=CommandParser.parse("DEPOSIT AC0001 500");

        System.out.println("\nCommand:");
        System.out.println("Type: "+c.type());
        System.out.println("Account: "+c.accountNumber());
        System.out.println("Amount: "+c.amount());

        Account ac=new Account("AC001","Neel",20000);

        System.out.println();
        System.out.print(StatementFormatter.buildStatement(ac));
    }
}