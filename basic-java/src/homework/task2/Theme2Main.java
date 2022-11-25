package homework.task2;

public class Theme2Main {
    public static void main(String[] args) {
        double price = 10.5d;
        float ivaPercent = 16f;
        double resultPrice = getPrice(price, ivaPercent);
        System.out.println(resultPrice);
    }
    private static double getPrice(double price, float ivaPercent) {
        double iva =  (ivaPercent / 100) * price;
        return iva + price;
    }
}
