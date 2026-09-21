interface Notifier
{
    void send(String message);
}

interface Urgent
{
}

class EmailSender implements Urgent
{
    void sendEmail(String message)
    {
        System.out.println("Email: "+message);
    }
}

class SMSSender
{
    void sendSMS(String message)
    {
        System.out.println("SMS: "+message);
    }
}

public class P6_PartA_2
{
    public static void main(String[] args)
    {
        EmailSender email=new EmailSender();
        SMSSender sms=new SMSSender();

        Notifier[] senders={
            message->email.sendEmail(message),
            message->sms.sendSMS(message)
        };

        String message="Emergency notification";

        for(Notifier sender:senders)
        {
            sender.send(message);
        }

        email.sendEmail(message);
    }
}