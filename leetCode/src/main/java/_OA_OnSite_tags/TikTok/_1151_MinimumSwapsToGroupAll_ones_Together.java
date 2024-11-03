package _OA_OnSite_tags.TikTok;

class _1151_MinimumSwapsToGroupAll_ones_Together {
    public int minSwaps(int[] data) {
        if (data.length < 3) {
            return 0;
        }

        // count the total number of 1
        int oneCnt = 0;
        for (int num : data) {
            oneCnt += num;
        }
        int maxOneCnt = 0;
        int curOneCnt = 0;
        int slow = 0, fast = 0;
        while (fast < data.length) {
            // check sliding window size
            // before adding fast, i.e. if the existing number of elements is samller than oneCnt
            if (fast - slow < oneCnt) {
                curOneCnt += data[fast];
            } else {
                // add data[fast], remove data[left]
                curOneCnt += data[fast];
                curOneCnt += data[slow];
                slow++;
            }

            // if the sliding window is full, update maxOneCnt
            if (fast - slow + 1 == oneCnt) {
                maxOneCnt = Math.max(maxOneCnt, curOneCnt);
            }
            fast++;
        }
        return oneCnt - maxOneCnt;
    }
}
