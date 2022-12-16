package structurals.decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        BasicPhone basicPhone = new BasicPhone();
        basicPhone.create();
        SmartPhone smartPhone = new SmartPhone(new BasicPhone());
        smartPhone.create();
        NextGenPhone nextGenPhone = new NextGenPhone(new SmartPhone(new BasicPhone()));
        nextGenPhone.create();
    }
}
interface Phone {
    void create();
}
class BasicPhone implements Phone {
    @Override
    public void create(){
        System.out.println("Basic Phone: ");
        gsmBand();
        smsProtocol();
    }
    private void gsmBand(){
        System.out.println(" -> GSM");
    }
    private void smsProtocol(){
        System.out.println(" -> SMS");
    }
}
class DecoratorPhone implements Phone {
    private final Phone phone;
    public DecoratorPhone(Phone phone) {
        this.phone = phone;
    }
    @Override
    public void create() {
        this.phone.create();
    }
}
class SmartPhone extends DecoratorPhone {
    public SmartPhone(Phone phone) {
        super(phone);
    }
    @Override
    public void create() {
        super.create();
        System.out.println("Smart Phone:");
        System.out.println("  -> LTE");
    }
}
class NextGenPhone extends DecoratorPhone {
    public NextGenPhone(Phone phone) {
        super(phone);
    }
    @Override
    public void create() {
        super.create();
        System.out.println("Next Gen Phone:");
        System.out.println("   -> 5G");
        System.out.println("   -> VoLTE");
    }
}