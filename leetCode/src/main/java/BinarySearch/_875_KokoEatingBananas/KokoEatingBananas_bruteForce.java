package BinarySearch._875_KokoEatingBananas;

class KokoEatingBananas_bruteForce {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 1;

        while (true) {
            int hours = 0;
            for (int pile : piles) {
                hours += pile / speed;

                if (pile % speed != 0) {
                    hours++;
                }
            }

            if (hours <= h) {
                break;
            }
            speed++;
        }
        return speed;
    }
}
