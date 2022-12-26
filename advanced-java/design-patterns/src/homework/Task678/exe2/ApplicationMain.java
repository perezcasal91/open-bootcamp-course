package homework.Task678.exe2;

public class ApplicationMain {
    public static void main(String []args){
        Application application = Application.getInstance();
        application.run();
        Application applicationInstance = Application.getInstance();
        applicationInstance.run();
    }
}
class Application {
    private boolean isRunning;
    private static Application application;
    private Application(){}
    public static Application getInstance(){
        if (application == null){
            application = new Application();
        }
        return application;
    }
    public void run(){
        if (!isRunning){
            isRunning = true;
            System.out.println("Start running");
        }else {
            System.out.println("It's already running");
        }
    }
}