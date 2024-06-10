package phone_OA_OnSite.Walmart._767_ReorganizeString;

class reorganizeString_bucketsort {
    public String reorganizeString(String s) {
        if (s == null || s.length() < 2) return s;
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > bucket[max]) {
                max = i;
            }
        }
        if (bucket[max] > (s.length() + 1) / 2) return "";

        char[] ans = new char[s.length()];
        int start = 0;
        for (int i = 0; i < ans.length; i = i + 2) {
            if (bucket[max] > 0) {
                ans[i] = (char) ('a' + max);
                bucket[max]--;
            } else {
                while (bucket[start] == 0) {
                    start++;
                }
                ans[i] = (char) ('a' + start);
                bucket[start]--;
            }
        }
        for (int i = 1; i < ans.length; i = i + 2) {
            while (bucket[start] == 0) {
                start++;
            }
            ans[i] = (char) ('a' + start);
            bucket[start]--;
        }
        return new String(ans);
    }
}
