public class P4_partA_1_driver {
    public static void main(String[] args) {
        String[] passwords={
            "abc",
            "abcdefghi",
            "Abcd1234",
            "Abcd1234!"
        };

        for(String pw:passwords) {
            String result=P4_partA_1_PasswordChecker.strength(pw);
            System.out.println("Strength: " + result);
            System.out.println();
        }
    }
}