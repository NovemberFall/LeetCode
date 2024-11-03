package _OA_OnSite_tags.TikTok;

class _1802_MaximumValueAt_a_GivenIndex_in_a_BoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        int leftCount = index, rightCount = n - index - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;

            long  leftSum = getSum(leftCount, mid - 1);
            long  rightSum = getSum(rightCount, mid - 1);
            long  totalSum = leftSum + mid + rightSum;

            if (totalSum > maxSum) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    private long calc(long n) { //sum of numbers from [1 to n]
        return (n * (n + 1)) / 2;
    }

    private long getSum(int totalLen, int val) {
        long totalSum = 0;
        int decreasingLen = val; //count of decreasing elements [val, val - 1, .., 1]

        //[val, val - 1, val - 2, ... 1, 1, 1, 1]
        if (totalLen >= decreasingLen)
        {
            long currSum = calc(val);
            int remainingSum = totalLen - decreasingLen; //all 1's, the reamining all 1's
            totalSum = currSum + remainingSum;
        }
        else //[val, val - 1, val - 2]
        {
            long lastVal = decreasingLen - totalLen;
            totalSum = calc(val) - calc(lastVal);
        }
        return totalSum;
    }
}
