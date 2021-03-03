package cn.me.Reflection2;

@SuppressWarnings("unused")
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface{


    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;
    int age;
    public int id;

    public Person(){}

    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    public String display(String interests, int age) {
        return interests + age;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    public static void showDest() {
        System.out.println("我是一个可爱的静态方法");
    }

}
