package Recursion;
import java.util.*;
public class BinaryWatch {
    public BinaryWatch(){}
        int[] hours = new int[]{8, 4,2,1};
        int[] mins = new int[]{32, 16, 8, 2,1};
        public List<String> readBinaryWatch(int num) {
            List<String>  res = new ArrayList<>();
            if (num <= 0) {
                return res;
            }

            for(int i = 0; i <= num; i++) {
                List<Integer> hour = generateDigits(i, hours);
                List<Integer> min = generateDigits(num - i, mins);
                for (int h : hour) {
                    if (h >= 12) {
                        continue;
                    }
                    for (int m : min) {
                        if (m >= 60) {
                            continue;
                        }
                        res.add(h+":" + ((m < 10) ? "0" +  m : m));
                    }
                }
            }

            return res;
        }

        //Generate all the possible comb with certain count;
        private List<Integer> generateDigits(int count, int[] nums) {
            List<Integer> list = new ArrayList<>();
            dfs (list, nums, count,0,0);
            return list;
        }

        //all the possible combination starting with nums[start]
        private void dfs (List<Integer> list, int[] nums, int count, int start, int sum) {
            if (count == 0) {
                list.add(sum);
            }

            for (int i = start; i < nums.length; i++) {
                sum += nums[i];
                count--;
                dfs (list, nums,count, i+1, sum);
                //backtracking
                sum -= nums[i];
                count++;
            }
        }
}
