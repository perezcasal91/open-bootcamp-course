package solid.i;

public class AnimalMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.talk());
        System.out.println(dog.eat());
        System.out.println();
        Bird bird = new Bird();
        System.out.println(bird.talk());
        System.out.println(bird.eat());
        System.out.println(bird.fly());
    }
}
interface Animal {
    String talk();
    String eat();
}
interface FlyAnimal {
    String fly();
}
class Dog implements Animal {

    @Override
    public String talk() {
        return "Jau";
    }

    @Override
    public String eat() {
        return "meat";
    }
}
class Bird implements Animal, FlyAnimal {

    @Override
    public String talk() {
        return "Ajay";
    }

    @Override
    public String eat() {
        return "fruit";
    }

    @Override
    public String fly() {
        return "sky";
    }

}