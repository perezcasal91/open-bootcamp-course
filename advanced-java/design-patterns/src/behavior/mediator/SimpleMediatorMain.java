package behavior.mediator;

import java.util.ArrayList;

public class SimpleMediatorMain {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        College collegeA = new ConcreteCollegeA();
        College collegeB = new ConcreteCollegeB();
        mediator.add(collegeA);
        mediator.add(collegeB);
        collegeA.send();
        mediator.resend(collegeA);
    }
}
abstract class SimpleCollege {
    private Mediator mediator;
    public void setMediator(Mediator mediator) {this.mediator = mediator;}
    public Mediator getMediator() {return mediator;}
    abstract public void receive();
    abstract public void send();
}
abstract class SimpleMediator {
    abstract void add(College college);
    abstract void resend(College college);
}
class SimpleConcreteMediator extends Mediator {
    private final ArrayList<College> colleges;
    public SimpleConcreteMediator() {this.colleges = new ArrayList<>();}
    @Override
    void add(College college) {
        if (!colleges.contains(college)){
            this.colleges.add(college);
            college.setMediator(this);
        }
    }
    @Override
    void resend(College college) {
        colleges.forEach(c -> {
            if (!c.equals(college)) {
                c.receive();
            }
        });
    }
}
class SimpleConcreteCollegeA extends College{
    @Override
    public void receive() {
        System.out.println(this.getClass().getSimpleName() + " Hey, I got your message.");
    }
    @Override
    public void send() {
        System.out.println(this.getClass().getSimpleName() + " is sending a message");
        getMediator().resend(this);
    }
}
class SimpleConcreteCollegeB extends College{
    @Override
    public void receive() {
        System.out.println(this.getClass().getSimpleName() + " Hey, I got your message.");
    }
    @Override
    public void send() {
        System.out.println(this.getClass().getSimpleName() + " is sending a message");
        getMediator().resend(this);
    }
}
