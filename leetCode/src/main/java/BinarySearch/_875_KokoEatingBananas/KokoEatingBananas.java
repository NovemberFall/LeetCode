package BinarySearch._875_KokoEatingBananas;

class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPile(piles);
        int res = right;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canEatAll(int[] piles, int speed, int H) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / speed;
            if (pile % speed != 0) {
                hours++;
            }
        }
        return hours <= H;
    }

    private int getMaxPile(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }
}
