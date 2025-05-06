package String._616_Add_Bold_Tag_in_String;

public class without_KMP {
    public String addBoldTag(String s, String[] words) {
        // bold[i] is true if s[i] is part of a word from the list
        boolean[] bold = new boolean[s.length()];

        for (String word : words) {
            // Find all occurrences of the current word in s
            int start = s.indexOf(word);
            while (start != -1) {
                // Mark all characters of the found occurrence as true in the bold array
                for (int i = start; i < start + word.length(); i++) {
                    bold[i] = true;
                }
                // Search for the next occurrence starting from the next position
                start = s.indexOf(word, start + 1);
            }
        }

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            // If the current character should be bolded
            if (bold[i]) {
                // Append the opening bold tag
                res.append("<b>");
                // Append all consecutive characters that should be bolded
                while (i < s.length() && bold[i]) {
                    res.append(s.charAt(i));
                    i++;
                }
                // Append the closing bold tag
                res.append("</b>");
            } else {
                // if the current character should not be boled, just append it
                res.append(s.charAt(i));
                i++;
            }
        }

        return res.toString();
    }
}
