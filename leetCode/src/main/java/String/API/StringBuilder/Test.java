package String.API.StringBuilder;

class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        System.out.println(sb);

        sb.deleteCharAt(0);
        System.out.println(sb);

        sb = new StringBuilder("0123456789");
        System.out.println(sb.charAt(3));
    }
}
