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

        List<Integer> output;
            public List<Integer> inorderTraversal(TreeNode root) {
                        output = new ArrayList<>();

                                    inorder(root);

                                                return output;

                                                        
                                                            }

                                                                public void inorder(TreeNode root)
                                                                    {
                                                                            if(root == null)
                                                                                    return;

                                                                                            inorder(root.left);
                                                                                                    output.add(root.val);
                                                                                                            inorder(root.right);



                                                                                                                }
                                                                                                                }
