package Recursion.IntegerToEnglishWords;

class _273_IntegerToEnglishWords_II {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    public String helper(int num) {
        String[] words = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        StringBuilder res = new StringBuilder();

        if (num >= 1000000000) {
            res.append(helper(num / 1000000000)).append(" Billion ");
            num %= 1000000000;
        }
        if (num >= 1000000) {
            res.append(helper(num / 1000000)).append(" Million ");
            num %= 1000000;
        }
        if (num >= 1000) {
            res.append(helper(num / 1000)).append(" Thousand ");
            num %= 1000;
        }
        if (num >= 100) {
            res.append(helper(num / 100)).append(" Hundred ");
            num %= 100;
        }
        if (num >= 20) res.append(words[(num - 20) / 10 + 20]).append(" ").append(words[num % 10]);
        else res.append(words[num]);

        return res.toString().trim();
    }
}
