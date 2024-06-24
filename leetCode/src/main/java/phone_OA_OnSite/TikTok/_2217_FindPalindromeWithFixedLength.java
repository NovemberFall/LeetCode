package phone_OA_OnSite.TikTok;

import java.util.ArrayList;
import java.util.List;

class _2217_FindPalindromeWithFixedLength {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int halfLength = (intLength + 1) / 2; // contains both odd and even
                                              // half for 3 =2, half for 4 = 2
        long start = (long) Math.pow(10, halfLength - 1);
        long end = (long) Math.pow(10, halfLength) - 1;

        List<Long> res = new ArrayList<>();

        for (int query : queries) {
            long half = start + query - 1;
            if (half > end) {
                res.add(-1L);
            } else {
                String halfStr = Long.toString(half);
                StringBuilder fullStr = new StringBuilder(halfStr);
                if (intLength % 2 == 1) {
                    halfStr = halfStr.substring(0, halfStr.length() - 1);
                }
                fullStr.append(new StringBuilder(halfStr).reverse());
                res.add(Long.parseLong(fullStr.toString()));
            }
        }
        return res.stream().mapToLong(l -> l).toArray();
    }
}
