import java.util.regex.Pattern;

enum TransactionType {
    DEPOSIT, WITHDRAW, TRANSFER
}

record Command(TransactionType type,String acc,long amount) {}

public class P4_partB {

    static class Validator {

        static Pattern mobile=Pattern.compile("^[6-9][0-9]{9}$");
        static Pattern email=Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        static Pattern pan=Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");
        static Pattern ifsc=Pattern.compile("^[A-Z]{4}0[A-Z0-9]{6}$");

        static boolean mobile(String s) {
            return mobile.matcher(s).matches();
        }

        static boolean email(String s) {
            return email.matcher(s).matches();
        }

        static boolean pan(String s) {
            return pan.matcher(s).matches();
        }

        static boolean ifsc(String s) {
            return ifsc.matcher(s).matches();
        }
    }

    static Command parse(String s) {
        String[] a=s.split(" ");

        TransactionType type=TransactionType.valueOf(a[0]);
        String acc=a[1];
        long amount=Long.parseLong(a[2]);

        return new Command(type,acc,amount);
    }

    static class Account {
        String acc;
        String name;
        long balance;

        Account(String acc,String name,long balance) {
            this.acc=acc;
            this.name=name;
            this.balance=balance;
        }
    }

    static String statement(Account a) {
        return "Account Statement\n"+
               "Account Number: "+a.acc+"\n"+
               "Name: "+a.name+"\n"+
               "Balance: "+a.balance;
    }

    public static void main(String[] args) {

        System.out.println("Mobile:");
        System.out.println(Validator.mobile("9726137865"));
        System.out.println(Validator.mobile("12345"));

        System.out.println("Email:");
        System.out.println(Validator.email("neelpatel00@gmail.com"));
        System.out.println(Validator.email("abc@"));

        System.out.println("PAN:");
        System.out.println(Validator.pan("VYNEE2405S"));
        System.out.println(Validator.pan("PQR303"));

        System.out.println("IFSC:");
        System.out.println(Validator.ifsc("UBIN0204671"));
        System.out.println(Validator.ifsc("UBIN543"));

        Command c=parse("DEPOSIT AC0001 500");

        System.out.println("\nCommand:");
        System.out.println("Type: "+c.type());
        System.out.println("Account: "+c.acc());
        System.out.println("Amount: "+c.amount());

        Account a=new Account("AC001","Neel",20000);

        System.out.println("\n"+statement(a));
    }
}