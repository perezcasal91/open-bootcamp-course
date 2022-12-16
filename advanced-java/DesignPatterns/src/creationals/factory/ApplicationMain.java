package creational_patterns.factory;

public class ApplicationMain {
    public static void main(String[] args) {
      Application applicationD = new Application("desktop");
      applicationD.getDialog().render();
        Application applicationW = new Application("web");
        applicationW.getDialog().render();
    }
}
class Application {
    private Dialog dialog;
    private Application() {}
    public Application(String op) {
        switch (op.toLowerCase()) {
            case "desktop" -> dialog = new DesktopDialog();
            case "web" -> dialog = new WebDialog();
            default -> System.out.println("Not such exist operative system");
        }
    }
    public Dialog getDialog() {return dialog;}
}
abstract class Dialog {
    public abstract Button createButton();
    public void render() {
        Button button = createButton();
        button.onClick("close");
        button.render();
    }
}
interface Button {
    void render();
    void onClick(String file);
}
class DesktopDialog extends Dialog {
    @Override
    public Button createButton() {return new DesktopButton();}
}
class WebDialog extends Dialog {
    @Override
    public Button createButton() {return new WebButton();}
}
class DesktopButton implements Button {
    @Override
    public void onClick(String file) {System.out.println(file);}
    @Override
    public void render() {System.out.println("Desktop Button is rendered");}
}
class WebButton implements Button {
    @Override
    public void onClick(String file) {System.out.println(file);}
    @Override
    public void render() {System.out.println("Web Button is rendered");}
}