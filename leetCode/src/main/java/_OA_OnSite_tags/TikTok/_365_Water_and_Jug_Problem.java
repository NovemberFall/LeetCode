package _OA_OnSite_tags.TikTok;

class _365_Water_and_Jug_Problem {
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target) {
            return false;
        }
        if (x == target || y == target || x + y == target) {
            return true;
        }

        if (x > y) {
            return target % gcd(x, y) == 0;
        } else {
            return target % gcd(y, x) == 0;
        }
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
