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
            //int mid = ( lp + rp ) / 2; //bad idea as lp + rp will over flow easily;
            int mid = lp + (rp - lp)/2;
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

    public int binarySearchRecursion(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int res = recursiveBody(nums, 0, nums.length - 1, target);
        return res;
    }

    public int recursiveBody(int[] nums, int lp, int rp, int target){
        if(lp <= rp){
            int mid = lp + (rp - lp)/2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target){
                return recursiveBody(nums,lp, mid-1, target);
            } else {
                return recursiveBody(nums,mid+1, rp, target);
            }
        }
        return -1;
    }

    public int binarySearchFirst(int [] nums, int target){
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int result = -1;
        int lp = 0;
        int rp = nums.length - 1;

        while(lp + 1 < rp){
            //int mid = ( lp + rp ) / 2; //bad idea as lp + rp will over flow easily;
            int mid = lp + (rp - lp)/2;
            if (nums[mid] == target) {
                rp = mid;
                //result = mid;
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

    public int binarySearchLast(int [] nums, int target){
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int result = -1;
        int lp = 0;
        int rp = nums.length - 1;

        while(lp + 1 < rp){
            int mid = lp + (rp - lp)/2;
            if ( nums[mid] == target) {
                if(nums[mid + 1] != target) {
                    rp = mid;
                } else {
                    lp = mid;
                }
                //result = mid;
            }else if (nums[mid] > target) {
                rp = mid;
            }else if (nums[mid] < target) {
                lp = mid;
            }
        }

        if(nums[rp] == target){
            return rp;
        }

        if (nums[lp] == target) {
            return lp;
        }
        return -1;

    }

    public int maxNumberInMountain(int[] nums){
        if (nums == null || nums.length == 0) {
            return -1;
        }

        //search the number using binary search,
        int lp = 0;
        int rp = nums.length - 1;

        while(lp + 1 < rp) {
            int mid = lp + (rp - lp) / 2;
            if (mid + 1 < nums.length && nums[mid] <= nums[mid + 1]) { //The sequence is incresing
                lp = mid;
            } else if (mid + 1 < nums.length && nums[mid] >= nums[mid + 1]) { //The sequence is decreasing
                rp = mid;
            }
        }

        if(nums[lp] >= nums[rp]){
            return nums[lp];
        }else{
            return nums[rp];
        }
    }
    public int findPeak(int[] nums){
        int lp = 1;
        int rp = nums.length - 2;

        while (lp + 1 < rp){
            int mid = lp + (rp - lp) / 2;
            if(nums[mid] < nums[mid - 1]){
                rp = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                lp = mid;
            } else {
                rp = mid;
            }
        }

        if(nums[lp] >= nums[rp]) {
            return lp;
        } else {
            return rp;
        }
    }

    public int rotateSortedArray(int[] nums, int target){
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int lp = 0;
        int rp = nums.length - 1;

        while (lp + 1 < rp) {
            int mid = lp + (rp - lp) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[lp] < nums[mid] ) { //on the left of the pivot
                if (target >= nums[lp] && target <= nums[mid]){ // target is located between mid and lp
                    rp = mid;
                } else {
                    lp = mid;
                }
            } else { //pivot is included.
                if (target <= nums[rp] && target >= nums[mid]){ // target on the right of the pivot, to rp
                    lp = mid;
                } else { // target on the left of the pivot
                    rp = mid;
                }
            }
        }

        if (nums[lp] == target) {
            return lp;
        }
        if(nums[rp] == target) {
            return rp;
        }

        return -1;
    }

    public boolean search2DMatrix(int[][] matrix, int target){
        // write your code here
        //started from the bottom left corner
        if (matrix == null || matrix.length== 0){
            return false;
        }


        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1; // row pointer
        int j = 0; // col pointer
        int count = 0;

        //start from the bottom corner
        while( i >= 0 && j < n){
            if(matrix[i][j] < target){
                j++;
            } else if (matrix[i][j] > target){
                i--;
            } else if (matrix[i][j] == target){
                count++;
                i--;
                j++;
            }
        }

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }
}
