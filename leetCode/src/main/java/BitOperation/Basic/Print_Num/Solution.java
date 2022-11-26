package BitOperation.Basic.Print_Num;

class Solution {
    private static void print(int num) {
        String ans = "";
        for (int i = 31; i >= 0; i--) {
            ans = (num & (1 << i)) == 0 ? "0" : "1";
            System.out.print(ans + " ");
        }
    }

    public static void main(String[] args) {
//        System.out.println(1 << 3);
        print(8);
    }
}
