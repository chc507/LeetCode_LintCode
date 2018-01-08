package String;

import java.util.ArrayList;
import java.util.List;

public class PalindromePart {
    public PalindromePart() {
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        helper(result, current, s, 0);
        return result;
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left == right) return true;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }


    //all the palinfrom partition from the starting point
    private void helper(List<List<String>> result, List<String> current, String s, int start) {
        if (current.size() > 0 && start == s.length()) {
            result.add(new ArrayList<>(current));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                if (i == start) {
                    current.add(String.valueOf(s.charAt(start)));
                } else {
                    current.add(s.substring(start, i+1));
                }
                helper(result, current, s, start + 1);
                current.remove(current.size() - 1);
            }

        }
    }
}




