/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
     int maxDiameter =0;
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
        return 0;

        int leftheight = maxheight(root.left);
        int rightheight = maxheight(root.right);

        int diameter = leftheight + rightheight;

        int leftdiameter = diameterOfBinaryTree(root.left);
        int rightdiameter = diameterOfBinaryTree(root.right);

      int sub  = Math.max(leftdiameter,rightdiameter);

        return Math.max(diameter,sub);
        
    }

    public int maxheight(TreeNode root)
    {
        if(root==null)
        return 0;

        int left = maxheight(root.left);
        int right = maxheight(root.right);

        return 1 + Math.max(left,right);
    }
}
