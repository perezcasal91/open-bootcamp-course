package homework.task2;

public class Theme2Main {
    public static void main(String[] args) {
        double dPrice = 10.5D;
        double dIvaPercent = 16D;
        double dResultPrice = getPrice(dPrice, dIvaPercent);
        System.out.println(dResultPrice);
    }
    private static double getPrice(double price, double ivaPercent) {
        double dIva =  (ivaPercent / 100) * price;
        return dIva + price;
    }
}
