import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    public BinaryTree(){}
    private List<Integer> preorderTraversal (TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }

        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left == null) {
                stack.push(node.left);
            }
        }
        return preorder;
    }

    public List<Integer> inorderTraversal (TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) { // traverse throught left
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val); //pop the left sub
            current = current.right; //traversal through the right
        }
        return result;
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        //populate the queue with BFS
        for (int i = 0; i < queue.size(); i++) {
            TreeNode focusNode = queue.get(i);
            if(focusNode == null) {
                continue;
            }
            queue.add(focusNode.left);
            queue.add(focusNode.right);
        }

        //remove the null value from the back
        while(queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        String result = "{";
        result += Integer.toString(root.val);

        for (int i = 1; i < queue.size(); i++) {
            TreeNode currentNode = queue.get(i);
            if(currentNode != null) {
                result += ",";
                result += Integer.toString(currentNode.val);
            } else {
                result += ",";
                result += "#";
            }
        }

        result += "}";
        return result;
    }

    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }

        String[] serial = data.substring(1, data.length() -1).split(",");

        //Create nodes base on the pointer of array serial (the focusNode),
        //put focusNode into queue,
        //base on queue, check the following two nodes in the array serial
        //determine if they are the child of nodes in queue
        //

        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode (Integer.parseInt(serial[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < serial.length; i++) {
            if (!serial[i].equals("#")) {
                TreeNode focusNode = new TreeNode(Integer.parseInt(serial[i]));
                if (isLeftChild) {
                    queue.get(index).left = focusNode;

                } else {
                    queue.get(index).right = focusNode;
                }
                queue.add(focusNode);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return queue.get(0);
    }
}
