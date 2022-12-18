package behavior.observer;

import java.util.ArrayList;

public class PublisherMain {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        YoutubeSubscriber youtubeSubscriber = new YoutubeSubscriber();
        publisher.addSubscriber(youtubeSubscriber);
        publisher.subscribe();
        publisher.unSubscribe();
    }
}
interface Subscriber {
    void update(boolean value);
}
class YoutubeSubscriber implements Subscriber {
    @Override
    public void update(boolean value) {
        if (value){
            System.out.println("I already subscribe!!!");
        } else {
            System.out.println("I'm not subscribe it");
        }
    }
}
class Publisher {
    private final ArrayList<Subscriber> subscribers;
    public Publisher() {
        this.subscribers = new ArrayList<>();
    }
    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }
    public void subscribe() {
        subscribers.forEach(subscriber -> subscriber.update(true));
    }
    public void unSubscribe() {
        subscribers.forEach(subscriber -> subscriber.update(false));
    }
}