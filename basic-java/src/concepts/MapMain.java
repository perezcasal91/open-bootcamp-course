package concepts;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(""+ i + 1, "V" + i + 1);
        }
        map.forEach((key, value) -> System.out.println(key));
    }
}
