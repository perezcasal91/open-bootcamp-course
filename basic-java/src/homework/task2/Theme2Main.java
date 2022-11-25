package homework.task2;

public class Theme2Main {
    public static void main(String[] args) {
        double price = 10.5d;
        double ivaPercent = 16d;
        double resultPrice = getPrice(price, ivaPercent);
        System.out.println(resultPrice);
    }
    private static double getPrice(double price, double ivaPercent) {
        double iva =  (ivaPercent / 100) * price;
        return iva + price;
    }
}
