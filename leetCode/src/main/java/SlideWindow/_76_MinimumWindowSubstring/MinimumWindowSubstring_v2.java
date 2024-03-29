package SlideWindow._76_MinimumWindowSubstring;

class MinimumWindowSubstring_v2 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        //维护两个数组，记录已有字符串指定字符的出现次数，和目标字符串指定字符的出现次数
        //ASCII表总长128,    0 ~ 127
        // ascii('z') = 122
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        //将目标字符串指定字符的出现次数记录
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        //分别为左指针，右指针，最小长度(初始值为一定不可达到的长度)
        //已有字符串中目标字符串指定字符的出现总频次以及最小覆盖子串在原字符串中的起始位置
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;

        // matchingCharsCount 表示滑动窗口内部包含`T`中字符的个数,(也可以说包含T的size)
        int matchingCharsCount = 0;
        int start = 0;

        // [left, right)
        while (right < s.length()) {

            if (tFreq[s.charAt(right)] == 0) {
                right++;
                continue;
            }

            /*    s = F F A D D B A C C D E N C        t = A A B
                  when it was first time that meet 'A'
                  winFreq[A] = 0,  tFreq[A] = 2   =>      winFreq[s[right]] <  tFreq[s[right]]
            */
            //当右边界向右滑动时，且 winFreq[s[right]] < tFreq[s[right]] 时, matchingCharsCount + 1
            if (winFreq[s.charAt(right)] < tFreq[s.charAt(right)]) {
                matchingCharsCount++;
            }

            //已有字符串中目标字符出现的次数+1
            winFreq[s.charAt(right)]++;

            //当且仅当已有字符串已经包含了所有目标字符串的字符的个数，且出现频次一定大于或等于指定频次
            while (matchingCharsCount == t.length()) {

                //当窗口的长度比已有的最短值小时，更改最小值，并记录起始位置
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                //如果左边即将要去掉的字符不被目标字符串需要，那么不需要多余判断，直接可以移动左指针
                if (tFreq[s.charAt(left)] == 0) {
                    left++;
                    continue;
                }

                //当左边界向右滑动时，且 winFreq[s[left]] == tFreq[s[left]] 时, matchingCharsCount-1
                if (winFreq[s.charAt(left)] == tFreq[s.charAt(left)]) {
                    matchingCharsCount--;
                }

                //已有字符串中目标字符出现的次数-1
                winFreq[s.charAt(left)]--;
                //移动左指针
                left++;
            }

            //移动右指针
            right++;
        }

        //如果最小长度还为初始值，说明没有符合条件的子串
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}
