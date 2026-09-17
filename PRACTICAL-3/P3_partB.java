public class P3_partB {

    static class Account {
        private String ac;
        private String name;
        private double balance;

        Account(String ac,String name,double balance) {
            this.ac=ac;
            this.name=name;
            this.balance=balance;
        }

        public String toString() {
            return ac + " " + name + " " + balance;
        }

        public boolean equals(Object o) {
            if(!(o instanceof Account))
                return false;

            Account a=(Account)o;
            return ac.equals(a.ac);
        }

        public int hashCode() {
            return ac.hashCode();
        }
    }

    static class Customer implements Cloneable {
        private String name;
        private String email;
        private String mobile;
        private Address addr;

        Customer(String name,String email,String mobile,Address addr) {
            this.name=name;
            this.email=email;
            this.mobile=mobile;
            this.addr=addr;
        }

        public Address getAddress() {
            return addr;
        }

        public Customer clone() {
            try {
                return (Customer)super.clone();
            }
            catch(CloneNotSupportedException e) {
                return null;
            }
        }

        static class Address {
            private String line;
            private String city;
            private String pin;

            Address(String line,String city,String pin) {
                this.line=line;
                this.city=city;
                this.pin=pin;
            }

            public String getLine() {
                return line;
            }

            public String getCity() {
                return city;
            }

            public String getPincode() {
                return pin;
            }
        }
    }

    public static void main(String[] args) {
        Account a1=new Account("A101","Neel",5000);
        Account a2=new Account("A102","Selvy",7000);
        Account a3=new Account("A101","Neel",5000);
        System.out.println(a1);
        System.out.println(a2);

        System.out.println(a1.equals(a2));
        System.out.println(a1.equals(a3));

        Customer.Address addr=new Customer.Address("Sanskardham","Ankleshwar","393001");

        Customer c1=new Customer("Neel","neenpatel00@gmail.com","9726138765",addr);
        Customer c2=c1.clone();

        System.out.println(c2.getAddress().getCity());

        Object o=a1;

        if(o instanceof Account)
            System.out.println("It is an Account");
    }
}