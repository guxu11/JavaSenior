package com.guxu.algorithm.hashmap;

import org.testng.annotations.Test;

import java.util.*;

/*
leetocde 49. 字母异位词分组
 */
public class GroupAnagrams {

    private List<List<String>> res = new ArrayList<>();
    private Map<String, List<String>> map = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        for (String s: strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String newS = new String(cs);
            if (map.containsKey(newS)) map.get(newS).add(s);
            else map.put(newS, new ArrayList<String>(){{add(s);}});
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    @Test
    public void test() {
        String[] ss = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(ss);
        System.out.println(res.toString());
    }

}

