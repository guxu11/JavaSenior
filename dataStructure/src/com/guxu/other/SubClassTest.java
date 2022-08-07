package com.guxu.other;

import org.testng.annotations.Test;

import javax.crypto.spec.PSource;

public class SubClassTest {
    public  class SubClass {
        public void print() {
            System.out.println("123");
        }
    }

}

class Test1 {
    public static void main(String[] args) {
        SubClassTest subClassTest = new SubClassTest();
        SubClassTest.SubClass subClass = subClassTest. new SubClass();
        subClass.print();
    }
}
