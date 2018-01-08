package Recursion;
import java.util.*;

public class WordBreakII {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] words = new String[]{"cat", "cats", "and", "sand", "dog"};
        List<String> dict = new ArrayList<>();
        for (String word: words) {
            dict.add(word);
        }

        System.out.println(wordBreak(s,dict));
    }
    public static List<String> wordBreak(String s, List<String> dict) {
        if (s == null || s.length() == 0 || dict == null) {
            return new ArrayList<String>();
        }

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, dict, map);
    }

    private static List<String> dfs(String s, List<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> list = new ArrayList<String>();
        int len = s.length();

        if (len == 0) {
            list.add("");
        } else {
            //i is the len of string on the left side
            for (int i = 0; i <= len; i++) {
                String sub = s.substring(0, i);
                if (!dict.contains(sub)) {
                    System.out.println("not exist " + i);
                    continue;
                }

                //the string on the right will be calculated

                List<String> right = dfs(s.substring(i,len), dict, map);
                System.out.println("right " + right);
                //if there is nothing on the right;
                //if (right.size() == 0) {
                //    continue;
                //}
                for (String r  : right) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sub);
                    if (i != 0 && i != len) {
                        //if left side is empty or right side is empty, no need to add space
                        sb.append(" ");
                    }
                    sb.append(r);
                    list.add(sb.toString());
                }
            }
        }

        map.put(s, list);
        return list;
    }
}
