import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetwDup{
    public SubsetwDup(){}
    public List<List<Integer>> getSubsetsRecursive(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0); //empty set
        return list;
    }
    //recursive way
    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));//add previous set
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i - 1] == nums[i]) continue;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size()-1);
        }
    }
}
