package creationals.factory;

public class FactoryMain {
    public static void main(String[] args) {
        FactoryPrice factoryPriceUS = new FactoryPrice("us");
        System.out.println("US Price: " + factoryPriceUS.getPrice().getPrice());
        FactoryPrice factoryPriceEU = new FactoryPrice("eu");
        System.out.println("EU Price: " + factoryPriceEU.getPrice().getPrice());
        FactoryPrice factoryPriceUK = new FactoryPrice("uk");
        System.out.println("UK Price: " + factoryPriceUK.getPrice().getPrice());
    }
}
class FactoryPrice {
    private Price price;
    private FactoryPrice(){}
    public FactoryPrice(String country){
        switch (country.toLowerCase()) {
            case "us" -> price = new PriceUSD();
            case "eu" -> price = new PriceEUR();
            case "uk" -> price = new PriceGBR();
            default -> System.out.println("Not such exist country");
        }
    }
    public Price getPrice() {return price;}
}
interface Price {
    double getPrice();
}
class PriceUSD implements Price {
    @Override
    public double getPrice() {return 1;}
}
class PriceEUR implements Price {
    @Override
    public double getPrice() {return 0.9;}
}
class PriceGBR implements Price {
    @Override
    public double getPrice() {return 1.1;}
}
