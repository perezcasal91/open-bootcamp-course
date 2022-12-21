package homework.task4;

/**
 * Class which objective is to answer the Task 4
 */
public class Task4Main {
    public static void main(String[] args) {
        exe1();
        exe2();
        exe3();
    }
    private static void exe1() {
        Person cPerson = new Person();
        cPerson.setName("Elio");
        cPerson.setAge(31);
        cPerson.setPhone("345-565-565");
        System.out.println("Person");
        System.out.print("Name:" + cPerson.getName() + " ");
        System.out.print("Age:" + cPerson.getAge() + " ");
        System.out.print("Phone:" + cPerson.getPhone());
        System.out.println();
    }
    private static void exe2() {
        Client cClient = new Client();
        cClient.setAge(30);
        cClient.setName("Klee");
        cClient.setPhone("561-275-3058");
        cClient.setCredit(720);
        System.out.println("Client");
        System.out.print("Name:" + cClient.getAge() + " ");
        System.out.print("Age:" + cClient.getName() + " ");
        System.out.print("Phone:" + cClient.getPhone() + " ");
        System.out.print("Credit:" + cClient.getCredit());
        System.out.println();
    }
    private static void exe3() {
        Employee cEmployee = new Employee();
        cEmployee.setAge(34);
        cEmployee.setName("Ross");
        cEmployee.setPhone("561-456-3078");
        cEmployee.setSalary(2000);
        System.out.println("Employee");
        System.out.print("Name:" + cEmployee.getAge() + " ");
        System.out.print("Age:" + cEmployee.getName() + " ");
        System.out.print("Phone:" + cEmployee.getPhone() + " ");
        System.out.print("Salary:" + cEmployee.getSalary());
    }
}
class Person {
    private int age;
    private String name;
    private String phone;
    public Person(){}
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
class Client extends Person{
    private double credit;
    public Client(){
        super();
    }
    public double getCredit() {return credit;}
    public void setCredit(double credit) {
        this.credit = credit;
    }
}
class Employee extends Person{
    private double salary;
    public Employee(){
        super();
    }
    public double getSalary() {return salary;}
    public void setSalary(double salary) {
        this.salary = salary;
    }
}