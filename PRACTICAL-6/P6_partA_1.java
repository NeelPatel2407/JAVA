interface Switchable
{
    void on();
    void off();

    default void toggle()
    {
        System.out.println("Device toggled");
    }
}

class Fan implements Switchable
{
    public void on()
    {
        System.out.println("Fan ON");
    }

    public void off()
    {
        System.out.println("Fan OFF");
    }
}

class Light implements Switchable
{
    public void on()
    {
        System.out.println("Light ON");
    }

    public void off()
    {
        System.out.println("Light OFF");
    }
}

@FunctionalInterface
interface SwitchRule
{
    boolean canSwitchOn(Switchable device,int hour);
}

public class P6_PartA_1
{
    public static void main(String[] args)
    {
        Switchable fan=new Fan();
        Switchable light=new Light();

        Switchable[] devices={fan,light};

        for(Switchable device:devices)
        {
            device.toggle();
        }

        SwitchRule rule1=new SwitchRule()
        {
            public boolean canSwitchOn(Switchable device,int hour)
            {
                return hour>=6&&hour<=22;
            }
        };

        System.out.println("Anonymous Class: "+rule1.canSwitchOn(fan,10));

        SwitchRule rule2=(device,hour)->hour>=6&&hour<=22;

        System.out.println("Lambda: "+rule2.canSwitchOn(light,23));
    }
}