package DFS;

class _395_LongestSubstringWithAtLeast_K_RepeatingCharacters {
    public int longestSubstring(String s, int k) {
        return dfs(s.toCharArray(), 0, s.length(), k);
    }

    private int dfs(char[] chars, int start, int end, int k) {
        // 停止条件：字符串长度小于 k
        if (end - start < k) {
            return 0;
        }

        int[] count = new int[26];

        // count the frequencies of current substring
        for (int i = start; i < end; i++) {
            int index = chars[i] - 'a';
            count[index]++;
        }

        for (int i = 0; i < 26; i++) {
            // 下面这个是不满足要求的字符，它不能出现在任何有效的子字符串中
            if (count[i] < k && count[i] > 0) {
                // 需要找到这个字符的位置，然后分别求解它的左半部分和右半部分
                for (int j = start; j < end; j++) {
                    System.out.println("start: " + start + "  " + "end: " + end);
                    if (chars[j] == i + 'a') {
                        System.out.println("chars[j] : "+ chars[j]);
                        int left = dfs(chars, start, j, k);
                        int right = dfs(chars, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        System.out.println("end - start: " + "=>" + " "+ (end - start));
        return end - start;
    }
}
