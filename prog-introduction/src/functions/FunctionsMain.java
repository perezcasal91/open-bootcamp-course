package functions;

/**
 * Init with Java Functions
 */
public class FunctionsMain {
    public static void main(String[] args) {
        Function cFunction = new Function();
        cFunction.sum(1,2);
        cFunction.recursiveSum(1,2);
        System.out.println();
        Potato cPotato = new Potato();
        cPotato.deleteArms();
        cPotato.deleteArms();
        cPotato.deleteArms();
        System.out.println(cPotato.getArmsCount());
    }
}
/**
 * Class with two examples of functions
 */
class Function {
    public void sum(int a, int b) {
        System.out.println(a + b);
    }
    public void recursiveSum(int a, int b) {
        int iResult = a + b;
        System.out.print(iResult + " ");
        if (iResult > 10) {
            return;
        }
        recursiveSum(iResult, b);
    }
}
/**
 * Potato a class with a function example: Delete Arms
 */
class Potato {
    private int armsCount;
    public Potato() {
        this.armsCount = 0;
    }
    public void deleteArms() {
        this.armsCount--;
    }
    public int getArmsCount() {
        return armsCount;
    }
}
