package string.StringBuilder;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb = new StringBuilder();
        sb.append("World");
        System.out.println(sb);
    }
}
