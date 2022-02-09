package com.guxu.algorithm.hashmap;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/*
leetcode 299. 猜数字游戏
 */
public class BullsAndCows {
    private Map<Character, Integer> map = new HashMap<>();
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        for (char c: secret.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < guess.length(); i++) {
            char c1 = secret.charAt(i), c2 = guess.charAt(i);
            if (c1 == c2) {
                bull++;
                if (!map.containsKey(c1)) {
                    cow--;
                    continue;
                }
                if (map.get(c1) == 1) map.remove(c1);
                else map.put(c1, map.get(c1) - 1);
            } else {
                if (map.containsKey(c2)) {
                    cow++;
                    if (map.get(c2) == 1) map.remove(c2);
                    else map.put(c2, map.get(c2) - 1);
                }
            }
        }
        return bull + "A" + cow + "B";
    }

    @Test
    public void test() {
        String secret = "1122", guess = "1222";
        System.out.println(getHint(secret, guess));
    }
}
