package com.atguigu.java;

/**
 * @author: guxu
 * @create: 2021/11/9
 * @description:
 * 使用enum关键字来定义
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 s1 = Season1.SPRING;
        System.out.println(s1.getSeasonName());
        System.out.println(Season1.class.getSuperclass());

        System.out.println("**********************");

        // values()
        Season1[] ss = Season1.values();
        for (Season1 s: ss) {
            System.out.println(s);
        }
        System.out.println("**********************");

        //valueOf(String objName)
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}
// 自定义枚举类
enum Season1{
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "大雪纷飞");
    // 1. 声明Season对象的属性，用private final修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 提供当前枚举类的多个对象


    // 4. 其他诉求
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}