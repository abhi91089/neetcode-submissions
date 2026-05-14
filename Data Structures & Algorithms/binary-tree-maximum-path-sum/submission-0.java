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
     int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        

        maxheight(root);
     return res;

        
    }

    public int maxheight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int maxleft = Math.max(0, maxheight(root.left));

        int maxright = Math.max(0, maxheight(root.right));

        res = Math.max(res, maxleft + root.val + maxright);

        return root.val + Math.max(maxleft,maxright);
    }
}
