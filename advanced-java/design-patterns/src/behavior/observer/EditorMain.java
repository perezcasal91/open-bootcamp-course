package behavior.observer;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class EditorMain {
    public static void main(String[] args) {
        Editor editor = new Editor();
        EmailAlertListener emailAlertListener =
                new EmailAlertListener("perezcasal91@gmail.com"
                        , "New email");
        LoggingListener loggingListener =
                new LoggingListener("observer_file.txt"
                        , "Logging");
        editor.getEventManagers().
                add(new EventManager().subscribe("save", emailAlertListener));
        editor.getEventManagers().
                add(new EventManager().subscribe("open", loggingListener));
        editor.openFile("src/resources/doc/observer_file.txt");
        editor.saveFile("src/resources/doc/observer_file.txt");
    }
}
class Editor {
    private final ArrayList<EventManager> eventManagers;
    private File file;
    public Editor() {
        this.eventManagers = new ArrayList<>();
    }
    public void openFile(String path) {
        this.file = new File(path);
        eventManagers.forEach(eventManager ->
                eventManager.notify("open", file.getName()));
    }
    public void saveFile(String path) {
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        eventManagers.forEach(eventManager ->
                eventManager.notify("save", file.getName()));
    }

    public ArrayList<EventManager> getEventManagers() {
        return eventManagers;
    }
}
class EventManager {
    private HashMap<String,EventListener> eventListeners;
    public EventManager() {
        this.eventListeners = new HashMap<>();
    }
    public EventManager subscribe(String eventType, EventListener eventListener) {
        this.eventListeners.put(eventType, eventListener);
        return this;
    }
    public EventManager unsubscribe(String eventType, EventListener eventListener) {
        this.eventListeners.remove(eventType, eventListener);
        return this;
    }
    public void notify(String eventType, String data) {
        eventListeners.forEach((type,event)-> {
            if (type.equals(eventType)) {
                event.update(data);
            }
        });
    }
}
interface EventListener {
    void update(String fileName);
}
class EmailAlertListener implements EventListener {
    private String email;
    private String message;
    public EmailAlertListener(String email, String message) {
        this.email = email;
        this.message = message;
    }
    @Override
    public void update(String fileName) {
        System.out.println("File: " + fileName);
        System.out.println("Email: " + email);
        System.out.println("Message: " + message);
    }
}
class LoggingListener implements EventListener {
    private File file;
    private String message;
    public LoggingListener(String logFileName, String message) {
        this.file = new File(logFileName);
        this.message = message;
    }
    @Override
    public void update(String fileName) {
        System.out.println("File: " + fileName);
        System.out.println("Message: " + message);
    }
}
