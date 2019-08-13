/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return sum(t1, t2);
    }
    
    public TreeNode sum(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
	// 하나의 node 존재 할 경우 
	// 자식 노드들를 추가로 확인 하고 더해 줄 필요없이
	// 해당 노드를 return 해 주면 됨
        else if (t1 == null)
            return t2;
        else if (t2 == null)
            return t1;

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = sum(t1.left, t2.left);
        node.right = sum(t1.right, t2.right);
        return node;
    }
}
