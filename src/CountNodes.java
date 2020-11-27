import java.util.Stack;

/**
 * @description: 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 *      1
 *     / \
 *    2   3
 *   / \  /
 *  4  5 6
 * <p>
 * 输出: 6
 * @author: zww
 * @date: 2020/11/24
 * @version: V1.0
 */
public class CountNodes {
    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.right = new TreeNode(3);
//        treeNode.left = new TreeNode(2);
//        treeNode.left.left = new TreeNode(4);
//        treeNode.left.right = new TreeNode(5);
//        treeNode.right.left = new TreeNode(6);
//        System.out.println(countNodes(treeNode));
    }
//
//    public static int countNodes(TreeNode root) {
//        int result = 0;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.empty()) {
//            result += visitAlongLeftBranch(stack);
//        }
//        return result;
//    }

    public static int visitAlongLeftBranch(Stack<TreeNode> stack) {
        int num = 0;
        TreeNode current = stack.pop();
        while (current != null) {
            num++;
            stack.push(current.right);
            current = current.left;
        }
        return num;
    }

//    public static int countNodes(TreeNode root){
//        if (root == null) {
//            return 0;
//        }
//        return countNodes(root.left) + countNodes(root.right) + 1;
//    }


    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int h = 0;
        TreeNode node = root;
        while (node.left != null) {
            h++;
            node = node.left;
        }
        int low = 1 << h;
        int high = (1 << h + 1) - 1;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (exist(h, root, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static boolean exist(int h, TreeNode root, int k) {
        TreeNode node = root;
        int compare = 1 << (h - 1);
        while (node != null && compare > 0) {
            if ((k & compare) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            compare = compare >> 1;
        }
        return node != null;
    }
}
