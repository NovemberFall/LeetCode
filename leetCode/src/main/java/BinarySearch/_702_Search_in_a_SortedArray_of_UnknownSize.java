package BinarySearch;

class _702_Search_in_a_SortedArray_of_UnknownSize {
    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     *     public int get(int index) {}
     * }
     */

    class Solution {
//        public int search(ArrayReader reader, int target) {
//            int left = 0;
//            int right = 1;
//            while (reader.get(right) < target) {
//                left = right;
//                right *= 2;
//            }
//            return binarySearch(reader, target, left, right);
//        }
//
//        private int binarySearch(ArrayReader reader, int target, int left, int right) {
//            while (left <= right) {
//                int mid = (left + right) >>> 1;
//                if (reader.get(mid) == target) {
//                    return mid;
//                } else if (reader.get(mid) < target) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
//            return -1;
//        }
    }
}
