package behavior.mediator;

import java.util.ArrayList;

public class AbstractMediatorMain {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        College collegeA = new ConcreteCollegeA();
        College collegeB = new ConcreteCollegeB();
        mediator.add(collegeA);
        mediator.add(collegeB);
        mediator.add(collegeB);
        collegeA.send();
        collegeB.send();
        mediator.resend(collegeA);
    }
}
abstract class College {
    private Mediator mediator;
    public void setMediator(Mediator mediator) {this.mediator = mediator;}
    public Mediator getMediator() {return mediator;}
    abstract public void receive();
    abstract public void send();
}
interface Iterator {
    College next(College college);
    College next();
    boolean hasNext();
    void reset();
}
class CollegeIterator implements Iterator {
    private final ArrayList<College> iterators;
    private int index;
    public CollegeIterator() {
        this.iterators = new ArrayList<>();
        this.index = 0;
    }
    public void add(College college, ConcreteMediator mediator) {
        if (!iterators.contains(college)) {
            iterators.add(college);
            college.setMediator(mediator);
        }
    }
    @Override
    public College next(College newCollege) {
        College college = iterators.get(index);
        index++;
        if (college.equals(newCollege)){
            college = iterators.get(index);
            index++;
        }
        return college;
    }
    @Override
    public College next() {
        College college = iterators.get(index);
        index++;
        return college;
    }
    @Override
    public boolean hasNext() {
        return index < iterators.size();
    }
    @Override
    public void reset() {
        this.index = 0;
    }
}
abstract class Mediator {
    abstract void add(College college);
    abstract void resend(College college);
}
class ConcreteMediator extends Mediator {
    private final CollegeIterator colleges;
    public ConcreteMediator() {this.colleges = new CollegeIterator();}
    @Override
    void add(College college) {
       colleges.add(college, this);
    }
    @Override
    void resend(College college) {
      while (colleges.hasNext()){
          colleges.next(college).receive();
      }
    }
}
class ConcreteCollegeA extends College{
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
class ConcreteCollegeB extends College{
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