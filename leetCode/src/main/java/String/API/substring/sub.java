package String.API.substring;

public class sub {
    public static void main(String[] args) {
        String str = "0123456789";
        System.out.println(str.substring(0, 1)); // 0
        System.out.println(str.substring(0, 3)); // 012
        System.out.println(str.substring(0, 4)); // 0123
        System.out.println(str.substring(0, 5)); // 01234
        System.out.println(str.substring(0, 9)); // 012345678
        System.out.println(str.substring(2)); // 23456789

        System.out.println(str.substring(0, 0)); // ""
    }
}
