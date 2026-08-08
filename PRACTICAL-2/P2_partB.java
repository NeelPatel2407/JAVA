class Customer{
    private String name;
    private String email;
    private String mobile;
    private final String customerId;

    private static long customerCounter=101;

    private static String generateCustomerId(){
        return "CUST"+customerCounter++;
    }

    public Customer(String name,String email,String mobile){
        this.name=name;
        this.email=email;
        this.mobile=mobile;
        customerId=generateCustomerId();
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getMobile(){
        return mobile;
    }

    public String getCustomerId(){
        return customerId;
    }
}

class Account{
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    private static int accountCounter=1;

    private static String generateAccountNumber(){
        return String.format("AC%04d",accountCounter++);
    }

    public Account(String ownerName,long balance){
        accountNumber=generateAccountNumber();
        this.ownerName=ownerName;
        this.balance=balance;
        active=true;
    }

    public Account(String ownerName){
        this(ownerName,0);
    }

    public void deposit(long amount){
        balance+=amount;
    }

    public boolean withdraw(long amount){
        if(balance>=amount){
            balance-=amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public long getBalance(){
        return balance;
    }

    public boolean isActive(){
        return active;
    }
}

public class P2_partB{
    public static void main(String[]args){

        Customer c1=new Customer("Neel","neeupatel07@gmail.com","9726138766");
        Customer c2=new Customer("Selvy","selvymodi5@gmail.com","8866677336");

        Account[]accounts=new Account[3];

        accounts[0]=new Account(c1.getName(),1000);
        accounts[1]=new Account(c2.getName());
        accounts[2]=new Account("Kavy",500);

        accounts[0].deposit(25000);
        accounts[0].withdraw(100);

        accounts[1].deposit(3500);
        accounts[1].withdraw(150);

        accounts[2].deposit(200);
        accounts[2].withdraw(500);

        for(int i=0;i<accounts.length;i++){
            System.out.println("Account Number: "+accounts[i].getAccountNumber());
            System.out.println("Owner Name: "+accounts[i].getOwnerName());
            System.out.println("Balance: Rs."+accounts[i].getBalance());
            System.out.println();
        }
    }
}