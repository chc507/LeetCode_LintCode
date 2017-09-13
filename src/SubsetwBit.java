import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetwBit {
    public SubsetwBit(){}
    //The iterative way
    public List<List<Integer>> getSubsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < (1 << n); i++){
            List<Integer> subset = new ArrayList<Integer>();
            for(int j = 0; j < n; j++){
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            System.out.println("Subset is: " + subset );
            res.add(subset);
        }
        return res;
    }
}
