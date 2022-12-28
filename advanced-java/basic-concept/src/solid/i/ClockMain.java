package solid.i;

public class ClockMain {
    public static void main(String[] args) {
        Watch watch = new Watch();
        System.out.println(watch.currentHour());
        System.out.println(watch.currentMinute());
        System.out.println(watch.currentSecond());
        System.out.println();
        SmartWatch smartWatch = new SmartWatch();
        System.out.println(smartWatch.currentHour());
        System.out.println(smartWatch.currentMinute());
        System.out.println(smartWatch.currentSecond());
        smartWatch.sendMessage();
        smartWatch.getEmails();
    }
}
interface WatchInterface {
    String currentHour();
    String currentMinute();
    String currentSecond();
}
interface SmartWatchInterface {
    void sendMessage();
    void getEmails();
}
class Watch implements WatchInterface {

    @Override
    public String currentHour() {
        return "10";
    }

    @Override
    public String currentMinute() {
        return "30";
    }

    @Override
    public String currentSecond() {
        return "15";
    }
}
class SmartWatch implements WatchInterface, SmartWatchInterface {

    @Override
    public String currentHour() {
        return "12";
    }

    @Override
    public String currentMinute() {
        return "25";
    }

    @Override
    public String currentSecond() {
        return "50";
    }

    @Override
    public void sendMessage() {
        System.out.println("The message was send.");
    }

    @Override
    public void getEmails() {
        System.out.println("The emails has just get it.");
    }
}