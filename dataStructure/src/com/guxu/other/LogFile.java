package com.guxu.other;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LogFile {
    //outer class variable:
    int counter = 17;
    //inner class
    public class LogFileDetail {
        //inner class counter
        int counter = 25;
        public void hello() {
            System.out.println("Outer: " + LogFile.this.counter);
            System.out.println("Inner: " + this.counter);
        }
    }

    public static void main(String[] args) {
        LogFile logFile = new LogFile();
        LogFile.LogFileDetail logFileDetail = logFile.new LogFileDetail();
        logFileDetail.hello();

    }
    @Test
    public void test() {
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        System.out.println(Arrays.equals(a, b));
    }

    @Test
    public void test2() {
        int[] a = {1,2,3};
        int[] b = a;
        b[0] = 100;
        for (int i = 0; i < b.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        Queue<Integer> queue = new LinkedList<>();

    }

}