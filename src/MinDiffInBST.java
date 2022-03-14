/**
 * @description:
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 * @author: zww
 * @date: 2021/4/13
 * @version: V1.0
 */
public class MinDiffInBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
//        treeNode.right.left = new TreeNode(6);
        MinDiffInBST minDiffInBST = new MinDiffInBST();
        System.out.println(minDiffInBST.minDiffInBST(treeNode));
    }
    private int min = Integer.MAX_VALUE;
    private int left = -1;
    public int minDiffInBST(TreeNode root) {
        find(root);
        return min;
    }
    public void find(TreeNode node){
        if (node.left != null) {
            find(node.left);
        }
        if (left != -1) {
            min = Math.min(min, node.val - left);
        }
        left = node.val;
        if (node.right != null) {
            find(node.right);
        }
    }
}
