import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run{}

class TestClass
{
    @Run
    void test1()
    {
        System.out.println("Test 1 executed");
    }

    @Run
    void test2()
    {
        System.out.println("Test 2 executed");
    }

    void test3()
    {
        System.out.println("Test 3 executed");
    }

    @Run
    void test4()
    {
        System.out.println("Test 4 executed");
    }
}

public class P7_partA_2
{
    public static void main(String[] args) throws Exception
    {
        TestClass obj=new TestClass();
        int count=0;

        for(Method method:TestClass.class.getDeclaredMethods())
        {
            if(method.isAnnotationPresent(Run.class))
            {
                method.invoke(obj);
                count++;
            }
        }

        System.out.println("Total tests ran: "+count);
    }
}