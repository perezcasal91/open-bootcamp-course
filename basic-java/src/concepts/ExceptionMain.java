package concepts;

/**
 * Init with the Exceptions.
 */
public class ExceptionMain {
    public static void main(String[] args) {
        try {
            int iResult = 1 / 0;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("The program has completed");
        }
        try {
            numberException(1,0);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private static void numberException(int a, int b) throws Exception {
        if (b == 0){
            throw new Exception("The number b can't be 0");
        }
    }
}
