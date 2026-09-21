import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength
{
    int value();
}

class SignupForm
{
    @NotBlank
    String name;

    @NotBlank
    @MaxLength(10)
    String username;

    SignupForm(String name,String username)
    {
        this.name=name;
        this.username=username;
    }
}

public class P7_partA_1
{
    static List<String> check(Object obj)
    {
        List<String> errors=new ArrayList<>();

        for(Field f:obj.getClass().getDeclaredFields())
        {
            try
            {
                f.setAccessible(true);
                String value=(String)f.get(obj);

                if(f.isAnnotationPresent(NotBlank.class)&&
                   (value==null||value.trim().isEmpty()))
                {
                    errors.add(f.getName()+" is blank");
                }

                if(f.isAnnotationPresent(MaxLength.class)&&
                   value!=null&&
                   value.length()>f.getAnnotation(MaxLength.class).value())
                {
                    errors.add(f.getName()+" is too long");
                }
            }
            catch(Exception e)
            {
                System.out.println("Error");
            }
        }

        return errors;
    }

    public static void main(String[] args)
    {
        SignupForm form=new SignupForm("","abcdefghijkl");

        List<String> errors=check(form);

        for(String error:errors)
        {
            System.out.println(error);
        }
    }
}