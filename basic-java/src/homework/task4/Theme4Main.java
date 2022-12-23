package homework.task4;

public class Theme4Main {
    public static void main(String[] args) {
        // SmartDevice Objects
        // Phone
        SmartDevice cSmartPhoneA = new SmartPhone("Samsung", "S21", "Black",
                "Samsung Electronics", "Android 13", true, "5.5in",
                true, "5G", true, true);
        SmartDevice cSmartPhoneI = new SmartPhone("Iphone", "14", "Gray",
                "Apple", "IOS 16", true, "6.7in",
                true, "5G", true, true);
        System.out.println("Smarts Phone");
        System.out.println(cSmartPhoneA);
        System.out.println(cSmartPhoneI);
        // Watch
        SmartDevice cSmartWatchA = new SmartWatch("Samsung", "GW3", "Silver",
                "Samsung Electronics","Tizen 4.0",  true, "40mm",
                "Circle","Silicone");
        SmartDevice cSmartWatchI = new SmartWatch("Apple Watch", "Series 8", "Midnight Aluminium",
                "Apple", "", true, "41mm",
                "Square", "Silicone");
        System.out.println("Smarts Watch");
        System.out.println(cSmartWatchA);
        System.out.println(cSmartWatchI);
    }
}
