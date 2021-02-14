package leetcode.to600;

import java.util.HashMap;
import java.util.Random;


public class _535_EncodeAndDecodeTinyURL {

    HashMap<String, String> map = new HashMap<>();
    String mapping = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";


    public String encode(String longUrl) {
        Random random = new Random();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(mapping.length());
            res.append(mapping.charAt(index));
        }
        String url = "https://tinyurl.com/" + res.toString();
        if (!map.containsKey(url)) {
            map.put(url, longUrl);
        }
        return url;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
