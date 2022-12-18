package behavior.observer;

import java.util.ArrayList;

public class ObserverMain {
    public static void main(String[] args) {
        Station station = new Station();
        RadioReceptor radioReceptor = new RadioReceptor();
        SatelliteReceptor satelliteReceptor = new SatelliteReceptor();
        TVReceptor tvReceptor = new TVReceptor();
        station.addReceptor(radioReceptor);
        station.addReceptor(satelliteReceptor);
        station.addReceptor(tvReceptor);
        station.broadcast();
    }
}
interface Receptor {
    void receive();
}
class Station {
    private ArrayList<Receptor> receptors;
    public Station(){
        this.receptors = new ArrayList<>();
    }
    public void addReceptor(Receptor receptor) {
        receptors.add(receptor);
    }
    public void broadcast(){
        receptors.forEach(Receptor::receive);
    }
}
class RadioReceptor implements Receptor {
    @Override
    public void receive() {
        System.out.println(this.getClass().getSimpleName() + " :I get the message.");
    }
}
class SatelliteReceptor implements Receptor {
    @Override
    public void receive() {
        System.out.println(this.getClass().getSimpleName() + " :I get the message.");
    }
}
class TVReceptor implements Receptor {
    @Override
    public void receive() {
        System.out.println(this.getClass().getSimpleName() + " :I get the message.");
    }
}
