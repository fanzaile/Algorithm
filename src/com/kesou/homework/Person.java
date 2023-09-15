package com.kesou.homework;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String introduce() {
        return "我叫" + name + "，今年" + age + "岁。";
    }

    public void celebrateBirthday() {
        age++;
        System.out.println(name + "过生日了，现在" + age + "岁了。");
    }
}

