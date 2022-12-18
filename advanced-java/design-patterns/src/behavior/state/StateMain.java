package behavior.state;

public class StateMain {
    public static void main(String[] args) {
        Phone phone = new Phone();
        System.out.println(phone.getState().unlock());
        System.out.println();
        System.out.println(phone.getState().openCamera());
        System.out.println();
        System.out.println(phone.getState().makePhoto());
        System.out.println();
        System.out.println(phone.getState().savePhoto());
        System.out.println();
        System.out.println(phone.getState().lock());
    }
}
class Phone {
    private State state;
    public Phone(){
        this.state = new LockedState(this);
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        System.out.println("Actual State: " + this.state.getClass().getSimpleName());
        this.state = state;
        System.out.println("Current State: " + this.state.getClass().getSimpleName());
    }
}
abstract class State {
    private final Phone phone;
    public State(Phone phone) {
        this.phone = phone;
    }
    public Phone getPhone() {return phone;}
    abstract public String lock();
    abstract public String unlock();
    abstract public String openCamera();
    abstract public String makePhoto();
    abstract public String savePhoto();
}
class LockedState extends State{
    public LockedState(Phone phone) {super(phone);}
    @Override
    public String lock() {
        return "The phone is already locked.";
    }
    @Override
    public String unlock() {
        getPhone().setState(new UnBlockState(getPhone()));
        return "Unlocked Phone";
    }
    @Override
    public String openCamera() {
        return "You have to unlock the Phone first.";
    }
    @Override
    public String makePhoto() {
        return "You have to open the camera first and verify if the phone is unlocked.";
    }
    public String savePhoto() {
        return "You have to take the Photo first.";
    }
}
class UnBlockState extends State{
    public UnBlockState(Phone phone) {
        super(phone);
    }
    @Override
    public String lock() {
        getPhone().setState(new LockedState(getPhone()));
        return "Locked Phone";
    }
    @Override
    public String unlock() {
        return "The phone is already unlock.";
    }
    @Override
    public String openCamera() {
        getPhone().setState(new OpenCameraState(getPhone()));
        return "The camera is ready.";
    }
    @Override
    public String makePhoto() {
        return "You have to open the camera first.";
    }
    public String savePhoto() {
        return "You have to take the Photo first.";
    }
}
class OpenCameraState extends State {
    public OpenCameraState(Phone phone) {
        super(phone);
    }
    @Override
    public String lock() {
        getPhone().setState(new LockedState(getPhone()));
        return "Locked Phone";
    }
    @Override
    public String unlock()  {
        return "The phone is already unlock.";
    }
    @Override
    public String openCamera() {
        return "The camera is already open.";
    }
    @Override
    public String makePhoto() {
        getPhone().setState(new SavePhotoState(getPhone()));
        return "The Photo was take.";
    }
    public String savePhoto() {
        return "You have to take the Photo first.";
    }
}
class SavePhotoState extends State{
    public SavePhotoState(Phone phone) {
        super(phone);
    }
    @Override
    public String lock() {
        getPhone().setState(new LockedState(getPhone()));
        return "Locked Phone";
    }
    @Override
    public String unlock()  {
        return "The phone is already unlock.";
    }
    @Override
    public String openCamera() {
        return "The camera is already open.";
    }
    @Override
    public String makePhoto() {
        return "The Photo was take.";
    }
    public String savePhoto() {
        return "The photo was saved successfully";
    }
}

