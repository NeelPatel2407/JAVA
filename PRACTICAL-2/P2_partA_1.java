class Thermostat{

private String location;
private int temperature;
private static final int MIN=16;
private static final int MAX=30;
private static int activeCount=0;

    Thermostat(String location, int startTemp)
    {
        this.location=location;

        if(startTemp>=MIN && startTemp<=MAX)
        {
            temperature=startTemp;
        }
        else
        {
            temperature=22;
        }
        activeCount++;
    }

    Thermostat(String location)
    {
        this(location,22);
    }

    void raise(){
        if(temperature < MAX)
        {
            temperature++;
        }
        else
        {
            System.out.println("Already at maximum(30)");
        }
    }


    void lower(){
        if(temperature > MIN)
        {
            temperature--;
        }
        else
        {
            System.out.println("Already at minimum(16)");
        }
    }

    int getTemperature(){
        return temperature;
    }   

    static int getActiveCount(){
        return activeCount;
    }
}


public class P2_partA_1{
    public static void main(String[] args){

        Thermostat t=new Thermostat("BEDROOOM",24);
        Thermostat t1=new Thermostat("LIVING_ROOM");

        System.out.println("Raising Temperature:");

        for(int i=1;i<=10;i++)
        {
            t.raise();
            System.out.println("Temperature: "+ t.getTemperature());
        }

        System.out.println("Lowering Temperature:");

        for(int i=1;i<=20;i++)
        {
            t.lower();
            System.out.println("Temperature: "+ t.getTemperature());
        }

        System.out.println("Active Thermostats: "+ Thermostat.getActiveCount());
    }
}