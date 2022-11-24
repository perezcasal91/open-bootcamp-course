package task4.module;

public class Client extends Person{
    private double credit;
    public Client(){
        super();
    }
    @Override
    public int getAge() {
        return super.getAge();
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public String getPhone() {
        return super.getPhone();
    }
    public double getCredit() {
        return credit;
    }
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }
    @Override
    public void setPhone(String phone) {
        super.setPhone(phone);
    }
    public void setCredit(double credit) {
        this.credit = credit;
    }
}
