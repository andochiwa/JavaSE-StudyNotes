package cn.me.Reflection;

@SuppressWarnings("unused")
public class Person {
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
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
    
    public void show() {
        System.out.println("hello, i'm a person");
    }

    private String showNation(String nation) {
        System.out.println("my nation is:" + nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }
}
