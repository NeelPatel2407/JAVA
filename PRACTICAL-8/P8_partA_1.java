import java.util.Scanner;

class DivideByZeroException extends Exception
{
    DivideByZeroException(String message)
    {
        super(message);
    }
}

public class P8_partA_1
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        boolean success=false;

        while(!success)
        {
            try
            {
                System.out.print("Enter first number: ");
                double a=sc.nextDouble();

                System.out.print("Enter second number: ");
                double b=sc.nextDouble();

                System.out.print("Enter operator (+,-,*,/): ");
                char op=sc.next().charAt(0);

                double result;

                switch(op)
                {
                    case '+':
                        result=a+b;
                        break;

                    case '-':
                        result=a-b;
                        break;

                    case '*':
                        result=a*b;
                        break;

                    case '/':
                        if(b==0)
                            throw new DivideByZeroException("Cannot divide by zero");
                        result=a/b;
                        break;

                    default:
                        System.out.println("Invalid operator");
                        continue;
                }

                System.out.println("Result: "+result);
                success=true;
            }
            catch(DivideByZeroException e)
            {
                System.out.println("Error: "+e.getMessage());
            }
            catch(Exception e)
            {
                System.out.println("Error: Invalid number input");
                sc.nextLine();
            }
            finally
            {
                System.out.println("Attempt completed");
            }
        }

        sc.close();
    }
}