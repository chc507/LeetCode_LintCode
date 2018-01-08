package LinkedList;

public class PalindromeLinkedList {
    PalindromeLinkedList(){};
    public boolean isPalindrome(ListNode head) {
        //recursive approach
        int length = findLength(head);
        ResultType res = helper(head, length);
        return res.result;
    }

    private ResultType helper(ListNode head, int length) {
        //recursion
        if (head == null || length <= 0) { //even number of nodes
            return new ResultType (head, true);
        } else if (length == 1) {
            return new ResultType(head.next, true);
        }

        //Recursive on the sublist
        ResultType res  = helper(head.next, length - 2);

        //if child calls are not palindrome, pass it back uop
        if ( !res.result || res.node == null) {
            return res;
        }

        //check if it matches the nodes on the other side
        res.result = (head.val == res.node.val);
        res.node = res.node.next;
        return res;
    }

    private int findLength(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}

class ResultType {
    ListNode node;
    boolean result;
    ResultType(ListNode node, boolean result) {
        this.node = node;
        this.result = result;
    }
}
