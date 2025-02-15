package BinarySearch._69_Sqrt_x;

class sqrt_x_t2 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1, right = x;
        while (left < right - 1) {
            int mid = (left + right) >>> 1;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (left * left < x) {
            return left;
        }
        return right;
    }
}
