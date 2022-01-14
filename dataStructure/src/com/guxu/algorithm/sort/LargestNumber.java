package com.guxu.algorithm.sort;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] newNums = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(newNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String newNum: newNums) {
            sb.append(newNum);
        }
        int idx = 0;
        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) != '0') break;
            else if (sb.charAt(j) == '0' && j < sb.length() - 1) idx++;
        }

        return sb.substring(idx);
    }

    @Test
    public void test() {
        int[] nums = {0,0};
        System.out.println(largestNumber(nums));

    }
}
