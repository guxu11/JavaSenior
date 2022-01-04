package com.guxu.algorithm.backtrack;

import org.testng.annotations.Test;

public class DecideString {
    /*
    StringBuilder res = new StringBuilder();
    public String decodeString(String s) {
        StringBuilder track = new StringBuilder();
        dfs(s, 0, track, 0);
        return res.toString();
    }

    private String dfs(String s, int time, int startIndex) {
        if (startIndex == s.length()) return "";
        StringBuilder sb = new StringBuilder();
        if (s.charAt(startIndex) == ']') {
            for (int i = 0; i < time; i++) {

            }
            time = 0;
        } else if (Character.isDigit(s.charAt(startIndex))) {
            time = time * 10 + s.charAt(startIndex) - '0';
            System.out.println(time);
        } else if (s.charAt(startIndex) == '[') {
            track = new StringBuilder();
        } else {
            track.append(s.charAt(startIndex));
        }
        dfs(s, time, track, startIndex + 1);

    }

    @Test
    public void test() {
        String s = "3[a2[c]]";
        decodeString(s);
        System.out.println(res);

        char c = '1';
        System.out.println(c - '0');
    }
    */

}
