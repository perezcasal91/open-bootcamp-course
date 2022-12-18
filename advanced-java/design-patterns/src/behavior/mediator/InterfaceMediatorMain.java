package behavior.mediator;

import java.util.ArrayList;

public class InterfaceMediatorMain {
    public static void main(String[] args) {
        ConcreteInterfaceMediator concreteInterfaceMediator = new ConcreteInterfaceMediator();
        InterfaceMediatorA interfaceMediatorA = new InterfaceMediatorA();
        InterfaceMediatorB interfaceMediatorB = new InterfaceMediatorB();
        concreteInterfaceMediator.add(interfaceMediatorA);
        concreteInterfaceMediator.add(interfaceMediatorB);
        interfaceMediatorA.send();
        concreteInterfaceMediator.resend(interfaceMediatorA);
    }
}
interface InterfaceMediator {
      void receive();
      void send();
      void setMediator(ConcreteInterfaceMediator mediator);
}
class ConcreteInterfaceMediator {
    private final ArrayList<InterfaceMediator> mediators;
    public ConcreteInterfaceMediator() {this.mediators = new ArrayList<>();}
    void add(InterfaceMediator mediator) {
        if (!mediators.contains(mediator)){
            this.mediators.add(mediator);
            mediator.setMediator(this);
        }
    }
    void resend(InterfaceMediator mediator) {
        mediators.forEach(c -> {
            if (!c.equals(mediator)) {
                c.receive();
            }
        });
    }
}
class InterfaceMediatorA implements InterfaceMediator{
    private ConcreteInterfaceMediator mediator;
    @Override
    public void receive() {
        System.out.println(this.getClass().getSimpleName() + " Hey, I got your message.");
    }
    @Override
    public void send() {
        System.out.println(this.getClass().getSimpleName() + " is sending a message");
        this.mediator.resend(this);
    }

    @Override
    public void setMediator(ConcreteInterfaceMediator concreteMediator) {
        this.mediator =  concreteMediator;
    }
}
class InterfaceMediatorB implements InterfaceMediator{
    private ConcreteInterfaceMediator mediator;
    @Override
    public void receive() {
        System.out.println(this.getClass().getSimpleName() + " Hey, I got your message.");
    }
    @Override
    public void send() {
        System.out.println(this.getClass().getSimpleName() + " is sending a message");
        this.mediator.resend(this);
    }
    @Override
    public void setMediator(ConcreteInterfaceMediator concreteMediator) {
        this.mediator =  concreteMediator;
    }
}