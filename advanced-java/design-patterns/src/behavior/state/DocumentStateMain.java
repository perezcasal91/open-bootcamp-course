package behavior.state;

import java.util.ArrayList;

public class DocumentStateMain {
    public static void main(String[] args) {
        User userU = new User();
        userU.setName("user");
        User userP = new User();
        userP.setName("publisher");
        Document document = new Document();
        document.setUser(userU);
        document.getState().create();
        document.setText("Hi");
        document.getState().draft();
        document.getState().save();
        document.setUser(userP);
        document.getState().publish();
    }
}
class User {
    private String name;
    public User() {}
    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}
}
class Document {
    private String text;
    private final ArrayList<String> textList;
    private DocumentState state;
    private User user;
    public Document() {
        this.state = new CreateDocument(this);
        this.textList = new ArrayList<>();
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        if (state instanceof CreateDocument){
            System.out.println("The document is not created, you must created first.");
        } else {
            this.text = text;
        }
    }
    public DocumentState getState() {return state;}
    public void setState(DocumentState state) {
        System.out.println("Actual State: " + this.state.getClass().getSimpleName());
        this.state = state;
        System.out.println("Current State: " + this.state.getClass().getSimpleName());
    }
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public ArrayList<String> getTextList() {return textList;}
}
abstract class DocumentState {
    private final Document document;
    public DocumentState(Document document){
        this.document = document;
    }
    public Document getDocument() {
        return document;
    }
    abstract void create();
    abstract void draft();
    abstract void save();
    abstract void publish();
}
class CreateDocument extends DocumentState{
    public CreateDocument(Document document) {super(document);}
    @Override
    public void create() {
        getDocument().setState(new DraftDocument(getDocument()));
        System.out.println("Document Created, now is in draft");
    }
    @Override
    public void draft() {System.out.println("The document is not created");}
    @Override
    public void save() {
        System.out.println("The document is not created");
    }
    @Override
    public void publish() {
        if (!getDocument().getUser().getName().equals("publisher")) {
            System.out.println("Only the publisher can publish");
        } else {
            System.out.println("The document is not created");
        }
    }
}
class DraftDocument extends DocumentState {
    public DraftDocument(Document document) {super(document);}
    @Override
    public void create() {
        System.out.println("Document is already created, is in draft now.");
    }
    @Override
    public void draft() {System.out.println("The document is already in draft, you should save it.");}
    @Override
    public void save() {
        String text = getDocument().getText();
        if (text != null) {
            getDocument().getTextList().add(text);
            getDocument().setState(new PublishDocument(getDocument()));
            System.out.println("The document was saved successfully, is ready to be published.");
        } else {
            System.out.println("The document is empty, you should add some text before save it.");
        }
    }
    @Override
    public void publish() {
        if (!getDocument().getUser().getName().equals("publisher")) {
            System.out.println("Only the publisher can publish");
        } else {
            System.out.println("The document is in draft, is not saved yet.");
        }
    }
}
class PublishDocument extends DocumentState {
    public PublishDocument(Document document) {
        super(document);
    }
    @Override
    public void create() {
        System.out.println("Document is already created.");
    }
    @Override
    public void save() {System.out.println("Document is already saved.");}
    @Override
    public void draft() {System.out.println("The document is not in draft, is ready to publish.");}
    @Override
    public void publish() {
        if (!getDocument().getUser().getName().equals("publisher")) {
            System.out.println("Only the publisher can publish");
        } else {
            System.out.println("The document was published successfully");
        }
    }
}