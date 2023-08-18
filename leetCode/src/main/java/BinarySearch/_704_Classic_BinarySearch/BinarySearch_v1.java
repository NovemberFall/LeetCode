package BinarySearch._704_Classic_BinarySearch;

class BinarySearch_v1 {
    public int binarySearch(int[] array, int target){
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch_v1 search = new BinarySearch_v1();
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(search.binarySearch(nums, 9));
    }
}
