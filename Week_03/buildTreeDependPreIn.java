//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 560 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



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
    //time O(n)
    //space O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int p_start, int p_end, int i_start, int i_end) {
        //终止条件
        if (p_start == p_end) {
            return null;
        }
        
        //当前层逻辑，创建根节点，定位根节点在中序位置
        int x = preorder[p_start];
        TreeNode root = new TreeNode(x);

        int iRootIndex = 0;
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == x) {
                iRootIndex = i;
                break;
            }
        }
        
        //左子树节点个数
        int numOfLeftTree = iRootIndex - i_start;
        
        //探索下一层
        root.left = buildTreeHelper(preorder, inorder, p_start + 1, p_start + numOfLeftTree + 1, i_start, iRootIndex);
        root.right = buildTreeHelper(preorder, inorder, p_start + numOfLeftTree + 1, p_end, iRootIndex + 1, i_end);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
