package Sliding_Window._76_MinimumWindowSubstring;

class final_version {
    public String minWindow(String s, String t) {
        char[] sArr = s.toCharArray();
        int m = sArr.length;
        int resLeft = -1, resRight = m;
        int[] s_count = new int[128];
        int[] t_count = new int[128];
        for (char c : t.toCharArray()) {
            t_count[c]++;
        }
        int left = 0;
        for (int right = 0; right < m; right++) {
            s_count[sArr[right]]++;
            while (isCovered(s_count, t_count)) {
                if (right - left + 1 < resRight - resLeft + 1) {
                    resLeft = left;
                    resRight = right;
                }
                s_count[sArr[left]]--;
                left++;
            }
        }
        return resLeft == -1 ? "" : s.substring(resLeft, resRight + 1);
    }

    // optimized space
    private boolean isCovered(int[] s_count, int[] t_count) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (s_count[i] < t_count[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (s_count[i] < t_count[i]) {
                return false;
            }
        }
        return true;
    }

    // easy way
//    private boolean isCovered(int[] s_count, int[] t_count) {
//        for (int i = 0; i < 128; i++) {
//            if (s_count[i] < t_count[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
}
