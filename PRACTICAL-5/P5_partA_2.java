abstract class Employee{
    protected String name;
    protected int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    public abstract double monthlySalary();
}

class FullTime extends Employee{
    private double salary;

    public FullTime(String name,int id,double salary){
        super(name,id);
        this.salary=salary;
    }

    public double monthlySalary(){
        return salary;
    }
}

class PartTime extends Employee{
    private double hours;
    private double rate;

    public PartTime(String name,int id,double hours,double rate){
        super(name,id);
        this.hours=hours;
        this.rate=rate;
    }

    public double monthlySalary(){
        return hours*rate;
    }
}

class Intern extends Employee{
    private double stipend;

    public Intern(String name,int id,double stipend){
        super(name,id);
        this.stipend=stipend;
    }

    public double monthlySalary(){
        return stipend;
    }
}

public class P5_partA_2{
    public static void main(String[] args){
        Employee[] employees={
            new FullTime("Neel",101,50000),
            new PartTime("Selvy",102,80,300),
            new Intern("Kavy",103,15000),
        };

        double total=0;

        for(Employee employee:employees){
            double salary=employee.monthlySalary();
            total+=salary;

            System.out.printf("%s Salary: %.2f\n",employee.name,salary);

            if(employee instanceof Intern){
                System.out.println("Note: This employee is an Intern.");
            }
        }

        System.out.printf("Total Payroll: %.2f\n",total);
    }
}