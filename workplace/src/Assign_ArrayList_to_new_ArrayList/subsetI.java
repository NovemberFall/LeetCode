package Assign_ArrayList_to_new_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class subsetI {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>>result){
        if(index == nums.length){
//            List<Integer> temp = path;
//            result.add(path);
            List<Integer> temp = new ArrayList<>(path);
            result.add(temp);
            System.out.println(temp);
            return;
        }
        path.add(nums[index]); //吃
        dfs(nums, index+1, path, result);
        path.remove(path.size() - 1); //🤮
        dfs(nums, index+1, path, result);
    }


    public static void main(String[] args) {
        subsetI sb = new subsetI();
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = sb.subsets(arr);
        System.out.println(result);// [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
    }
}
