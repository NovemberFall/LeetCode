package TwoPointers._151_ReverseWordsInAString;

class reverseWordsInAString_trim {
    public String reverseWords(String s) {
        s = s.trim();
        String cleanStr = removeBeginEndDuplicateSpace(s);
        char[] chars = cleanStr.toCharArray();
        int left = 0, right = chars.length - 1;

        // reverse the whole sentence
        reverse(chars, left, right);

        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ' && (fast == 0 || chars[fast - 1] == ' ')) {
                // "the sky is blue", 比如第一个词，或者第二个词的begin的index
                slow = fast;
            }
            if (chars[fast] != ' ' && (fast == right || chars[fast + 1] == ' ')) {
                // "the sky is blue", 比如倒数第二个词，或者最后一个词的end的index
                // reverse every word
                reverse(chars, slow, fast);
            }
        }
        return new String(chars);
    }

    // remove the leading, tailing space, duplicate space
    private String removeBeginEndDuplicateSpace(String s) {
        char[] arr = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            // remove duplicate space
            if (arr[fast] == ' ' && (fast == 0 || arr[fast - 1] == ' ')) {
                continue;
            }
            arr[slow] = arr[fast];
            slow++;
        }
        return new String(arr, 0, slow);
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
