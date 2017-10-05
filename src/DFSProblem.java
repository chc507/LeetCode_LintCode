public class DFSProblem {
    public DFSProblem() {}
    public int[] nextPermutation(int[] nums) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return nums;
        }

        //check if the array is in descendant order
        int[] result = new int[nums.length];
        clone(nums, result);

        int p = nums.length - 2;
        while (p >=0  && nums[p] >= nums[p + 1]) {
            p--;
        }


        if (p < 0) {
            swapArray(0, nums.length - 1, result);
            return result;
        }

        int q = nums.length - 1;

        //find the
        while (q >= 0 && nums[q] <= nums[p]) {
            q--;
        }

        swapNumber(p,q,result);

        swapArray(p + 1, nums.length - 1,result);

        return result;
    }

    private void clone(int[] source, int[] destination) {
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    private void swapNumber(int source, int destination, int[] arr) {
        int temp;
        temp = arr[source];
        arr[source] = arr[destination];
        arr[destination] = temp;
    }
    private void swapArray(int start , int end, int[] arr) {
        while (start < end) {
            swapNumber(start, end, arr);
            start++;
            end--;
        }
    }
 }
