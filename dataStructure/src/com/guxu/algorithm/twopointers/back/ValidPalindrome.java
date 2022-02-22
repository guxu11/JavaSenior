package com.guxu.algorithm.twopointers.back;

import org.testng.annotations.Test;

/*
leetcode 125. 验证回文串
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            char l = s.charAt(left), r = s.charAt(right);
//            if (!Character.isAlphabetic(l) && !Character.isDigit(l)) {
            if (!((l >= 'a' && l <= 'z') || (l >= 'A' && l <= 'Z') || (l >= '0' && l <= '9'))){
                left++;
                continue;
            }
//            if (!Character.isAlphabetic(r) && !Character.isDigit(r)) {
            if (!((r >= 'a' && r <= 'z') || (r >= 'A' && r <= 'Z') || (r >= '0' && r <= '9'))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "0Q";
        System.out.println(Character.toLowerCase('0'));
        System.out.println(isPalindrome(s));
    }
}
