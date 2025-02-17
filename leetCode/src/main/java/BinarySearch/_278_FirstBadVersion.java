package BinarySearch;


/*
    The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version);
*/


//class _278_FirstBadVersion {
//    public int firstBadVersion(int n) {
//        int left = 0, right = n - 1;
//        while (left < right - 1) {
//            int mid = left + (right - left) / 2;
//            if (isBadVersion(mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        if (isBadVersion(left)) {
//            return left;
//        }
//        if (isBadVersion(right)) {
//            return right;
//        }
//        return -1;
//    }
//}
