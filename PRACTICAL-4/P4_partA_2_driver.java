import java.util.Scanner;

public class P4_partA_2_driver {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String[] logs={
            "10:05 Neel Hello..!! there..",
            "10:10 Kavy How are you?",
            "10:15",
            "10:20 Neel Good morning"
        };

        System.out.print("Enter keyword: ");
        String key=sc.nextLine();

        P4_partA_2_chatfilter.filter(logs,key);
    }
}