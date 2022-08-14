package Recursion._273_IntegerToEnglishWords;

public class _273_IntegerToEnglishWords {
    private final String[] ones = {"", "One", "Two",
            "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final String[] tens = {"", "Ten", "Twenty", "Thirty",
            "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return helper(num).trim();
    }

    private String helper(int num) {
        if (num >= 1000000000) {
            return helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }
        if (num >= 1000000) {
            return helper(num / 1000000) + " Million " + helper(num % 1000000);
        }
        if (num >= 1000) {
            return helper(num / 1000) + " Thousand " + helper(num % 1000);
        }
        if (num >= 100) {
            return (helper(num / 100) + " Hundred " + helper(num % 100)).trim();
        }
        if (num >= 20) {
            return (tens[num / 10] + " " + helper(num % 10)).trim();
        }
        return ones[num];
    }

    public static void main(String[] args) {
        _273_IntegerToEnglishWords ite = new _273_IntegerToEnglishWords();
        int num = 1234567;
        String res = ite.numberToWords(num);
        System.out.println(res);
    }
}
