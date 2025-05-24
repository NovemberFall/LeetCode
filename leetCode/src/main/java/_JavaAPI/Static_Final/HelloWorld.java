package _JavaAPI.Static_Final;

public class HelloWorld {
    public static void main(String[] args) {
        Student firstStudent = new Student("Tom");
        Student secondStudent = new Student("Jerry");
        Student thirdStudent = null;
        firstStudent.setAge(18);
        secondStudent.sayHello();
        Student fourthStudent = null;
        try {
            thirdStudent.sayHello();
        } catch (NullPointerException e) {
            System.out.println("Expected error occurred! - " + e.toString());
        }
    }
}
