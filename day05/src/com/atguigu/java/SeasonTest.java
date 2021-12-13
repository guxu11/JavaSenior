package com.atguigu.java;

/**
 * @author: guxu
 * @create: 2021/11/9
 * @description: 如何定义枚举类
 * 一：jdk5.0之前，自定义枚举类
 * 二： jdk5.0，使用enum关键字
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring.toString());
    }
}

// 自定义枚举类
class Season{
    // 1. 声明Season对象的属性，用private final修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "大雪纷飞");

    // 4. 其他诉求
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}