import java.util.*;
public class P1_partA_1 {
    enum Coin{
        ONE,
        TWO,
        FIVE,
        TEN
    }
    public static void main(String []args){
        int snackprice=15;
        int Total=0;
        Scanner sc=new Scanner(System.in);

        while(Total<snackprice){
            System.out.println("Enter Coin(ONE,TWO,FIVE,TEN):");
            Coin coin=Coin.valueOf(sc.next().toUpperCase());

            int value=switch(coin){
                case ONE -> 1;
                case TWO -> 2;
                case FIVE -> 5;
                case TEN -> 10;
            };

            Total=Total+value;
            System.out.println("Your total is:" + Total);
        }
        System.out.println("Your Change is:"+(Total-snackprice));
        sc.close();
    }
}
