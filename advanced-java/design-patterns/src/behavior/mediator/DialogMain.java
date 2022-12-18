package behavior.mediator;

public class DialogMain {
    public static void main(String[] args) {
        CheckBox loginOrRegisterChkBx = new CheckBox();
        TextBox loginUsername = new TextBox();
        TextBox registrationUsername = new TextBox();
        Button okBtn = new Button();
        Dialog dialog = new DialogBuilder()
                .setTitle("Log-in")
                .setLoginOrRegisterChkBx(loginOrRegisterChkBx)
                .setLoginUsername(loginUsername)
                .setRegistrationUsername(registrationUsername)
                .setOkBtn(okBtn)
                .build();
        dialog.notifyComponent(loginOrRegisterChkBx, "check");
        okBtn.click();
        okBtn.keyPress();
    }
}
class DialogBuilder {
    private final Dialog dialog;
    public DialogBuilder() {this.dialog = new Dialog();}
    public DialogBuilder setTitle(String title) {
        this.dialog.setTitle(title);return this;}
    public DialogBuilder setLoginOrRegisterChkBx(CheckBox loginOrRegisterChkBx) {
        this.dialog.setLoginOrRegisterChkBx(loginOrRegisterChkBx);return this;}
    public DialogBuilder setLoginUsername(TextBox loginUsername) {
        this.dialog.setLoginUsername(loginUsername);return this;}
    public DialogBuilder setRegistrationUsername(TextBox registrationUsername) {
        this.dialog.setRegistrationUsername(registrationUsername);return this;}
    public DialogBuilder setOkBtn(Button okBtn) {
        this.dialog.setOkBtn(okBtn);return this;}
    public Dialog build() {
        this.dialog.initMediator();return dialog;}
}
class Dialog implements ComponentMediator {
    private String title;
    private CheckBox loginOrRegisterChkBx;
    private TextBox loginUsername;
    private TextBox registrationUsername;
    private Button okBtn;
    public Dialog() {}
    public void initMediator() {
        if (this.loginOrRegisterChkBx != null){
            this.loginOrRegisterChkBx.setMediator(this);}
        if (this.loginUsername != null) {
            this.loginUsername.setMediator(this);}
        if (this.registrationUsername != null) {
            this.registrationUsername.setMediator(this);}
        if (this.okBtn != null) {
            this.okBtn.setMediator(this);}
    }
    public void setTitle(String title) {this.title = title;}
    public void setLoginOrRegisterChkBx(CheckBox loginOrRegisterChkBx) {
        this.loginOrRegisterChkBx = loginOrRegisterChkBx;}
    public void setLoginUsername(TextBox loginUsername) {
        this.loginUsername = loginUsername;}
    public void setRegistrationUsername(TextBox registrationUsername) {
        this.registrationUsername = registrationUsername;}
    public void setOkBtn(Button okBtn) {this.okBtn = okBtn;}
    @Override
    public void notifyComponent(Component component, String event) {
        switch (event){
            case "check" -> {
                if (component.equals(loginOrRegisterChkBx)) {
                    if (!title.isBlank()) {
                        setTitle("Log-in or Register");
                    }
                    System.out.println(title);
                }
            }
            case "click"-> componentClick(component);
            case "button" -> componentButton(component);
            case "text" -> componentText(component);
            case "key-press" -> componentKeyPress(component);
            default -> System.out.println("No event");
        }
    }
    private void componentClick(Component component) {
        if (loginOrRegisterChkBx.equals(component)) {
            System.out.println("Log-in");
            loginOrRegisterChkBx.action();
        } else if (loginUsername.equals(component)) {
            System.out.println("Enter the Username:");
            loginUsername.action();
        }else if (registrationUsername.equals(component)) {
            System.out.println("You have to Register:");
            registrationUsername.action();
        }else if (okBtn.equals(component)) {
            System.out.println("Is OK");
            okBtn.action();
        }
    }
    private void componentButton(Component component) {
        if (okBtn.equals(component)) {
            System.out.println("Enter to the site");
        }
    }
    private void componentText(Component component) {
        if (okBtn.equals(component)) {
            System.out.println("Everything Ready");
        }
    }
    private void componentKeyPress(Component component) {
        if (loginOrRegisterChkBx.equals(component)) {
            System.out.println("Hi you press a key for Log-in");
        } else if (loginUsername.equals(component)) {
            System.out.println("Hi you press a key for the username");
        }else if (registrationUsername.equals(component)) {
            System.out.println("Hi you press a key for registration");
        }else if (okBtn.equals(component)) {
            System.out.println("Hi you press a key for enter to the app");
        }
    }
}
interface ComponentMediator {
    void notifyComponent(Component component, String event);
}
class Component {
    private ComponentMediator mediator;
    public Component() {}
    void click(){mediator.notifyComponent(this, "click");}
    void keyPress() {mediator.notifyComponent(this, "key-press");}
    public void setMediator(ComponentMediator mediator) {this.mediator = mediator;}
    public ComponentMediator getMediator() {return mediator;}
}
class Button extends Component {
    public void action() {getMediator().notifyComponent(this, "button");}
}
class TextBox extends Component {
    public void action() {getMediator().notifyComponent(this, "text");}
}
class CheckBox extends Component {
    public void action() {getMediator().notifyComponent(this, "check");}
}

