import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // traversal method to perform level order (first order traversal) traversal on the binary search tree (BST)
    public static Queue<TreeNode> traverseTree(TreeNode node) {

        if(node == null) return null;

        // Declare two queues (que, fot)
        // one to help perform first order traversal (level order traversal) of the tree
        Queue<TreeNode> que = new LinkedList<>();

        // one to store all the nodes in level order and return as a result
        Queue<TreeNode> lot = new LinkedList<>();

        // add root node of BST to que
        que.add(node);

        // while loop to begin traversing the tree
        while(!que.isEmpty()) {

            // poll the present head of the queue
            TreeNode tempNode = que.poll();

            // add the node to the fot
            lot.add(tempNode);

            // Enqueue the left child node
            if(tempNode.left != null) {
                que.add(tempNode.left);
            }
            // Enqueue the right child node
            if(tempNode.right != null) {
                que.add(tempNode.right);
            }
        }
        // return fot queue (level order tree)
        return lot;
    }
}
