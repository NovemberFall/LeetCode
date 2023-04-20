package String.RegularExpression;

public class split_method {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String[] words = s.split("[^a-zA-Z]");

        // Join the alphabetic characters back into a string
        String result = String.join("", words);
        System.out.println(result);// AmanaplanacanalPanama
    }
}
