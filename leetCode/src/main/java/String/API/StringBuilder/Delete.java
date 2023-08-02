package String.API.StringBuilder;

class Delete {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("0123456789");
        sb.delete(0, 5);
        System.out.println(sb); // 5 6 7 8 9

        sb = new StringBuilder("0123456789");
        sb.delete(3, 7);
        System.out.println(sb); // 0 1 2 7 8 9
    }
}
