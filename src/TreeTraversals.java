import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversals {

    // Binary Tree Inorder Traversal (Depth First Search)
    // Given the root of a binary tree, return the inorder traversal of its nodes' values.
    public static List<Integer> inorderTraversal(TreeNode root) {

        // Stack to help perform the inorder traversal
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        TreeNode currentNode = root;
        while(currentNode != null || !stk.isEmpty()) {
            // left traversal
            while(currentNode != null) {
                // add currentNode to the stack (root node)
                stk.push(currentNode);
                currentNode = currentNode.left;
            }

            // pop the stack and add to the current node value to the result list (root node if left is null)
            currentNode = stk.pop();
            result.add(currentNode.val);

            // then right traversal
            currentNode = currentNode.right;
        }
        return result;
    }
}
