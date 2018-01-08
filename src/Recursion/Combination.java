package Recursion;
import java.util.*;
public class Combination {
    public Combination(){}
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();

        if (n <= 0 || k <= 0) {
            return lists;
        }

        if (n <= k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            lists.add(list);
            return lists;
        }

        dfs(1, n, k, lists, new ArrayList<Integer>());

        return lists;

    }

    private void dfs (int start, int n, int k, List<List<Integer>> lists, List<Integer> list) {
        if (list.size() == k) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(i+1, n,k,lists,list);
            list.remove(list.size() - 1);
        }
    }
}
