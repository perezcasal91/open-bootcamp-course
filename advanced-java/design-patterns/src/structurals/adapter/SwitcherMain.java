package structurals.adapter;

public class SwitcherMain {
    public static void main(String[] args) {
        Oven oven = new Oven();
        oven.turnON();
        System.out.println(oven.isTurnON());
        CellingLamp cellingLamp = new CellingLamp();
        cellingLamp.turnON();
        System.out.println(cellingLamp.isTurnON());
        MicrowaveAdapter microwaveAdapter = new MicrowaveAdapter();
        microwaveAdapter.turnON();
        System.out.println(microwaveAdapter.isTurnON());

    }
}
interface Switcher {
    void turnON();
    void turnOFF();
    String isTurnON();
}
class Oven implements Switcher{
    private boolean on;
    @Override
    public void turnON() {
        this.on = true;
        System.out.println("The " + this.getClass().getSimpleName() + " is turn on");
    }
    @Override
    public void turnOFF() {
        this.on = false;
        System.out.println("The " + this.getClass().getSimpleName() + " is turn off");
    }

    @Override
    public String isTurnON() {
        if (on){
            return "The " + this.getClass().getSimpleName() + " is on";
        }
        return "The " + this.getClass().getSimpleName() + " is off";
    }
}
class CellingLamp implements Switcher{
    private boolean on;
    @Override
    public void turnON() {
        this.on = true;
        System.out.println("The " + this.getClass().getSimpleName() + " is turn on");
    }
    @Override
    public void turnOFF() {
        this.on = false;
        System.out.println("The " + this.getClass().getSimpleName() + " is turn off");
    }

    @Override
    public String isTurnON() {
        if (on){
            return "The " + this.getClass().getSimpleName() + " is on";
        }
        return "The " + this.getClass().getSimpleName() + " is off";
    }
}
class Microwave {
    private boolean on;
    public void turnON(int volt) {
        if (volt == 220) {
            this.on = true;
            System.out.println("The " + this.getClass().getSimpleName() + " is turn on");
        }
    }
    public void turnOFF(boolean stuffInside) {
        if (!stuffInside) {
            this.on = false;
            System.out.println("The " + this.getClass().getSimpleName() + " is turn off");
        }
    }
    public String isTurnON() {
        if (on){
            return "The " + this.getClass().getSimpleName() + " is on";
        }
        return "The " + this.getClass().getSimpleName() + " is off";
    }
}
class MicrowaveAdapter implements Switcher {
    private final Microwave microwave;
    public MicrowaveAdapter(){
        this.microwave = new Microwave();
    }
    @Override
    public void turnON() {
        this.microwave.turnON(220);
    }
    @Override
    public void turnOFF() {
        this.microwave.turnOFF(false);
    }
    @Override
    public String isTurnON() {
        return this.microwave.isTurnON();
    }
}

