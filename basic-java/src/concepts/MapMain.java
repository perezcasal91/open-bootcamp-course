package concepts;

import java.util.HashMap;
import java.util.Map;

/**
 * Init with Maps.
 */
public class MapMain {
    public static void main(String[] args) {
        Map<String, String> mpStrings = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            mpStrings.put(""+ i + 1, "V" + i + 1);
        }
        mpStrings.forEach((key, value) -> System.out.println(key));
    }
}
