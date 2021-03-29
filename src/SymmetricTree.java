public class SymmetricTree {

    // Symmetric Tree
    // Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    public static boolean isSymmetric(TreeNode root) {
        /** Iterative Solution */
//        // Declare a queue to store the mirrored nodes
//        Queue<TreeNode> q = new LinkedList<>();
//        // add the root node twice initially
//        q.add(root);
//        q.add(root);
//
//        // loop through the tree to check for symmetry
//        while(!q.isEmpty()) {
//            // declare local TreeNode objects (pointers) to reference the nodes from the queue
//            TreeNode t1 = q.poll();
//            TreeNode t2 = q.poll();
//
//            // check if the tree1 node and tree2 node are null
//            if(t1 == null && t2 == null) continue;
//            // check if either t1 or t2 is null
//            if(t1 == null || t2 == null) return false;
//            // if two node values are equal
//            if(t1.val != t2.val) return false;
//
//            // add left subtree's left node and right subtree's right node into the queue
//            q.add(t1.left);
//            q.add(t2.right)
//            // add left subtree's right node and right subtree's left node into the queue
//            q.add(t1.right);
//            q.add(t2.left);
//        }
//        return true;

        /** Recursive Solution */
        return testSymmetry(root, root);
    }

    public static boolean testSymmetry(TreeNode t1, TreeNode t2) {
        // check if the tree1 node and tree2 node are null
        if(t1 == null && t2 == null) return true;
        // check if either t1 or t2 is null
        if(t1 == null || t2 == null) return false;
        // if the node values are equal
        // test if the left subtree's left node(s) and right subtree's right node(s) mirror each other
        // then check if the left subtree's (each of it's subtrees) right node(s)
        // and the right subtree's (each of it's subtrees) left node(s) mirror each other
        return (t1.val == t2.val)
                && testSymmetry(t1.left, t2.right)
                && testSymmetry(t1.right, t2.left);

    }
}
