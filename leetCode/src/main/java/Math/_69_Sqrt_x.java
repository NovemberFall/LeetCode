package Math;

/*
y1 = (y0 + x / y0) / 2

In other words, we take the average of `y0` and `x / y0` as the new approximation `y1`.
We can repeat this process, using `y1` as the new initial guess, to obtain a sequence of approximations:

y2 = (y1 + x / y1) / 2
y3 = (y2 + x / y2) / 2
y4 = (y3 + x / y3) / 2
 */


//class _69_Sqrt_x {
//    public int mySqrt(int x) {
//        long r = x;
//        while (r * r > x) {
//            r = (r + x / r) / 2;
//        }
//        return (int) r;
//    }
//}










class _69_Sqrt_x {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = x;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if ((long) mid * mid == x ) {
                return mid;
            } else if ((long) mid * mid < x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}