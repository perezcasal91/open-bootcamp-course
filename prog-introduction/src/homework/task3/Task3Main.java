package homework.task3;

/**
 * Class which objective is to answer the Task 3
 */
public class Task3Main {
    public static void main(String[] args) {
        Person cPerson = new Person();
        cPerson.setAge(30);
        cPerson.setName("Klee");
        cPerson.setPhone("561-275-3058");
        System.out.println("Person");
        System.out.println(cPerson.getAge());
        System.out.println(cPerson.getName());
        System.out.println(cPerson.getPhone());
    }
}
class Person {
    private int age;
    private String name;
    private String phone;
    public Person() {}
    public int getAge() {
        return age;
    }
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public void setAge(int age) {this.age = age;}
    public void setName(String name) {this.name = name;}
    public void setPhone(String phone) {this.phone = phone;}
}