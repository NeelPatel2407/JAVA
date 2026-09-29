import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {

    @NotBlank
    @MaxLength(20)
    String name;

    @NotBlank
    @MaxLength(30)
    String email;

    @NotBlank
    @MaxLength(15)
    String password;

    SignupForm(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

public class P7_partA_1 {

    public static List<String> validate(Object obj) {

        List<String> errors = new ArrayList<>();

        Class<?> cls = obj.getClass();

        for (Field field : cls.getDeclaredFields())
             {

            field.setAccessible(true);

            try {
                String value = (String) field.get(obj);

                if (field.isAnnotationPresent(NotBlank.class)) 
                    
                    {

                    if (value == null || value.trim().isEmpty()) {
                        errors.add(field.getName() + " cannot be blank");
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength annotation =
                            field.getAnnotation(MaxLength.class);

                    int max = annotation.value();

                    if (value != null && value.length() > max) {
                        errors.add(field.getName()
                                + " must be at most "
                                + max + " characters");
                    }
                }

            } catch (Exception e) {
                errors.add("Error checking " + field.getName());
            }
        }

        return errors;
    }

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
                "",
                "verylongemailaddress123456789@example.com",
                "12345678901234567890"
        );

        List<String> errors = validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}