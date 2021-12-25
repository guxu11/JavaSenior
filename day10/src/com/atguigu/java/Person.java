package com.atguigu.java;

import java.io.Serializable;

public class Person implements Serializable {
    public static final long serialVersionUID = 412L;
    int age;
    static String name;
    transient Account account;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", account=" + account +
                '}';
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public Person(int age, String name, Account account) {
        this.age = age;
        this.name = name;
        this.account = account;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Account implements Serializable {
    public static final long serialVersionUID = 412233L;
    int id;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account(int id) {
        this.id = id;
    }
}