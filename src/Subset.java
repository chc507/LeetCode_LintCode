import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Subset {
    public Subset(){}
    //The iterative way
    public List<List<Integer>> getSubsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>()); //The empty set

        Arrays.sort(nums);
        for (int i: nums){
        List<List<Integer>> temp = new ArrayList<>();
        for(List<Integer> sub : res){
            List<Integer> a = new ArrayList<>(sub);
            a.add(i);
            temp.add(a);
        }
        res.addAll(temp);
    }
        return res;

    }
    //The recursive way
    public List<List<Integer>> getSubsetsRecursive(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0); //empty set
        return list;
    }
    //body of recursion
    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));//add previous set
        System.out.println("list" + list);
        System.out.println("index is: " + start);
        for(int i = start; i < nums.length; i++){
            System.out.println("index in loop: " + i);
            tempList.add(nums[i]);
            System.out.println("tempList:" + tempList);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size()-1);
        }
    }
}
