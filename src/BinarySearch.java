import java.util.Arrays;

public class BinarySearch {
    public BinarySearch(){}
    public int binarySearchIterative(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int lp = 0;
        int rp = nums.length - 1;

        while(lp + 1 < rp){
            int mid = ( lp + rp ) / 2; //bad idea as lp + rp will over flow easily;
            if (nums[mid] == target) {
                rp = mid;
            }else if (nums[mid] > target) {
                rp = mid;
            }else if (nums[mid] < target) {
                lp = mid;
            }
        }

        if (nums[lp] == target) {
            return lp;
        }

        if(nums[rp] == target){
            return rp;
        }

        return -1;
    }


}
