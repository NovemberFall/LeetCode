package JavaAPI.Static_Final;

public class Student {
    public int age;
    private final String name;
    private static String school; // (static) field
    private static final String GREETINGS = "Hello"; // (static constant) field

    public Student(String name) {
        this.name = name;
    }

    // Unlike C++, Java has no destructor (relying on GC)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void sayHello() {
        System.out.println(GREETINGS + "! I am " + name + ". I am " + age);
    }
}

