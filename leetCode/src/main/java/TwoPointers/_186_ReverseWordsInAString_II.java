package TwoPointers;

class _186_ReverseWordsInAString_II {
    public void reverseWords(char[] s) {
        // 1. reverse the whole sentence
        reverse(s, 0, s.length - 1);

        int slow = 0;
        for (int fast = 0; fast < s.length; fast++) {
            // "the sky is blue", 比如第一个词，或者第二个词的begin的index
            if (s[fast] != ' ' && (fast == 0 || s[fast - 1] == ' ')) {
                slow = fast;
            }

            // "the sky is blue", 比如倒数第二个词，或者最后一个词的end的index
            // reverse every word
            if (s[fast] != ' ' && (fast == s.length - 1 || s[fast + 1] == ' ')) {
                reverse(s, slow, fast);
            }
        }
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
