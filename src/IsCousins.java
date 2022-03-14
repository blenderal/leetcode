/**
 * @description:
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * @author: niwei
 * @since: 2021/5/17
 */
public class IsCousins {
    private int[] level = new int[]{-1, -1};
    private int[] p = new int[]{-1, -1};

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        findDeep(root, x, y, 0, root.val);
        return level[0] == level[1] && p[0] != p[1];
    }

    public void findDeep(TreeNode root, int x, int y, int deep, int pV) {
        if (root == null || (level[0] != -1 && level[1] != -1)) {
            return;
        }
        if (root.val == x) {
            level[0] = deep;
            p[0] = pV;
        }
        if (root.val == y) {
            level[1] = deep;
            p[1] = pV;
        }
        findDeep(root.left, x, y, deep + 1, root.val);
        findDeep(root.right, x, y, deep + 1, root.val);
    }
}
