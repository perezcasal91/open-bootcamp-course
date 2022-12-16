package structurals.decorator;


public class NotifierMain {
    public static void main(String[] args) {
        SlackDecorator slackDecorator = new SlackDecorator(
                new SMSDecorator(
                        new FacebookDecorator(new BaseDecorator(new BaseNotifier()))));
        slackDecorator.send("Hi for everyone", "");
    }
}
interface Notifier {
    void send(String message, String decorator);
}
class BaseNotifier implements Notifier{
    public void send(String message, String decorator) {
        System.out.println(message + " from " + decorator);
    }
}
class BaseDecorator implements Notifier {
    private final Notifier notifier;
    public BaseDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    @Override
    public void send(String message, String decorator) {
        this.notifier.send(message, decorator);
    }
}
class SMSDecorator extends BaseDecorator {
    public SMSDecorator(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message, String decorator) {
        if (decorator.isBlank()){
            decorator = this.getClass().getSimpleName();
        }
        super.send(message, decorator);
    }
}
class FacebookDecorator extends BaseDecorator {
    public FacebookDecorator(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message, String decorator) {
        if (decorator.isBlank()){
            decorator = this.getClass().getSimpleName();
        }
        super.send(message, decorator);
    }
}
class SlackDecorator extends BaseDecorator {
    public SlackDecorator(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message, String decorator) {
        if (decorator.isBlank()){
            decorator = this.getClass().getSimpleName();
        }
        super.send(message, decorator);
    }
}