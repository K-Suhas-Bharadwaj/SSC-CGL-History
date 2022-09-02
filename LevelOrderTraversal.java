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

class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> levels = new ArraList<List<Integer>>();
        
        if(root == null)
        {
            return levels;
        }
        
        List<TreeNode> currentLevel = new ArrayList<TreeNode>();
        currentLevel.add(root);
        
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        if(root.left != null)
        {
            nextLevel.add(root.left);
        }
        if(root.right != null)
        {
            nextLevel.add(root.right);
        }
        
        while(!nextLevel.isEmpty())
        {
            if(currentLevel.isEmpty())
            {
                
            }
        }
        
        
        

    }
}
