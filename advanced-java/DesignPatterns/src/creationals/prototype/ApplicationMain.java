package creational_patterns.prototype;

public class ApplicationMain {
    public static void main(String[] args) {
        // Rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setWeight(10);
        rectangle.setHeight(5);
        Rectangle rectangleClone = rectangle.clone();
        System.out.println("W:" + rectangleClone.getWeight()
                + " H: " + rectangleClone.getHeight());
        // Circle
        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(10);
        circle.setRadius(20);
        Circle circleClone = circle.clone();
        System.out.println("X: " + circleClone.getX()
                + " Y: " + circleClone.getY()
                + " R: " + circleClone.getRadius());
    }
}

abstract class Shape {
    protected int x;
    protected int y;
    protected String color;
    public Shape() {}
    public Shape(Shape shape) {
        this();
        this.x = shape.x;
        this.y = shape.y;
        this.color = shape.color;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public abstract Shape clone();
}
class Rectangle extends Shape {
    private int weight;
    private int height;
    public Rectangle() {}
    public Rectangle(Rectangle rectangle) {
        super(rectangle);
        this.weight = rectangle.weight;
        this.height = rectangle.height;
    }
    public int getWeight() {return weight;}
    public void setWeight(int weight) {this.weight = weight;}
    public int getHeight() {return height;}
    public void setHeight(int height) {this.height = height;}
    @Override
    public Rectangle clone() {return new Rectangle(this);}
}
class Circle extends Shape {
    private int radius;
    public Circle() {}
    public Circle(Circle circle) {super(circle);this.radius = circle.radius;}
    public int getRadius() {return radius;}
    public void setRadius(int radius) {this.radius = radius;}
    @Override
    public Circle clone() {return new Circle(this);}
}