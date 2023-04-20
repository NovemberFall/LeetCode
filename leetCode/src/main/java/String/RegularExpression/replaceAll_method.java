package String.RegularExpression;

class replaceAll_method {
    public static void main(String[] args) {
//        String s = "A man, 153a plan, a 44canal: Panama";
//        String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        String lettersOnly = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(lettersOnly); // Output: AmanaplanacanalPanama
    }
}
