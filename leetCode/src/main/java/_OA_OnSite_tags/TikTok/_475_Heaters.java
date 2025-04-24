package _OA_OnSite_tags.TikTok;


import java.util.Arrays;

class _475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        int res = 0;
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int curDistance = Math.min(leftDistance, rightDistance);
            res = Math.max(res, curDistance);
        }
        return res;
    }

    private int binarySearch(int[] heaters, int target) {
        int left = 0, right = heaters.length - 1;
        if (heaters[left] > target) {
            return -1;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] == target) {
                return mid;
            } else if (heaters[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return heaters[right] <= target ? right : left;
    }
}
