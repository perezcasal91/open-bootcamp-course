package homework.task4;

public class Theme4Main {
    public static void main(String[] args) {
        // SmartDevice Objects
        // Phone
        SmartDevice smartPhoneA = new SmartPhone("Samsung", "S21", "Black",
                "Samsung Electronics", "Android 13", true, "5.5in",
                true, "5G", true, true);
        SmartDevice smartPhoneI = new SmartPhone("Iphone", "14", "Gray",
                "Apple", "IOS 16", true, "6.7in",
                true, "5G", true, true);
        System.out.println("Smarts Phone");
        System.out.println(smartPhoneA);
        System.out.println(smartPhoneI);
        // Watch
        SmartDevice smartWatchA = new SmartWatch("Samsung", "GW3", "Silver",
                "Samsung Electronics","Tizen 4.0",  true, "40mm",
                "Circle","Silicone");
        SmartDevice smartWatchI = new SmartWatch("Apple Watch", "Series 8", "Midnight Aluminium",
                "Apple", "", true, "41mm",
                "Square", "Silicone");
        System.out.println("Smarts Watch");
        System.out.println(smartWatchA);
        System.out.println(smartWatchI);
    }


}
