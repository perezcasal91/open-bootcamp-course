package behavior.strategy;

public class ApplicationMain {
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.executeStrategy(1,2, "add"));
        System.out.println(context.executeStrategy(8,2, "subtract"));
        System.out.println(context.executeStrategy(3,3, "multiply"));
    }


}
interface Strategy {
    int execute(int a, int b);
}
class ConcreteStrategyAdd implements Strategy {
    @Override
    public int execute(int a, int b) {return a + b;}
}
class ConcreteStrategySubtract implements Strategy {
    @Override
    public int execute(int a, int b) {return a - b;}
}
class ConcreteStrategyMultiply implements Strategy {
    @Override
    public int execute(int a, int b) {return a * b;}
}
class Context {
    private Strategy strategy;
    private void setStrategy(Strategy strategy) {this.strategy = strategy;}
    public int executeStrategy(int a, int b, String action){
        switch (action){
            case "add" -> setStrategy(new ConcreteStrategyAdd());
            case "subtract" -> setStrategy(new ConcreteStrategySubtract());
            case "multiply" -> setStrategy(new ConcreteStrategyMultiply());
            default -> System.out.println("There is not such action.");
        }
        return strategy.execute(a, b);
    }
}
