package cn.me.Lambda;

public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        System.out.println("myname is " + name);
        return name;
    }
    
}
