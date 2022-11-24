package task4.module;

public class Employee extends Person{
    private double salary;
    public Employee(){
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
    public double getSalary() {
        return salary;
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
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
