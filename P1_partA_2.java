import java.util.*;

record Vehicle(String number,String type){}

public class P1_partA_2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int total=0;
        int bike=0;
        int car=0;
        int truck=0;

        while(true){
            System.out.print("Enter vehicle number (done to stop):");
            String number=sc.next();

            if(number.equalsIgnoreCase("done")){
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck):");
            String type=sc.next().toLowerCase();

            Vehicle v=new Vehicle(number,type);

            int toll=switch(type){
                case "bike"->20;
                case "car"->50;
                case "truck"->150;
                default->0;
            };

            total+=toll;

            if(type.equals("bike")){
                bike++;
            }else if(type.equals("car")){
                car++;
            }else if(type.equals("truck")){
                truck++;
            }
        }

        System.out.println("Total toll: "+ total);

        if(bike>car&&bike>truck)
            {
            System.out.println("Most frequent: bike");
            }
        else if(car>bike&&car>truck)
            {
            System.out.println("Most frequent: car");
            }
        else
            {
            System.out.println("Most frequent: truck");
            }
        sc.close();
    }
}