/**
 * @description:
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 *
 *
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 *
 * 提示：
 *
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 *
 * @author: zww
 * @date: 2021/4/25
 * @version: V1.0
 */
public class IncreasingBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        IncreasingBST increasingBST = new IncreasingBST();
        System.out.println(increasingBST.increasingBST(treeNode));
    }
    private TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        curr = new TreeNode(0);
        TreeNode head = curr;
        inorder(root);
        curr.left = null;
        curr.right = null;
        return head.right;
    }
    public void inorder(TreeNode node){
        if (node.left != null) {
            inorder(node.left);
        }
        curr.right = node;
        node.left = null;
        curr = node;
        if (node.right != null) {
            inorder(node.right);
        }
    }
}
