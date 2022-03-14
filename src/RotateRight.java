/**
 * @description:
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 *
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * @author: zww
 * @date: 2021/3/27
 * @version: V1.0
 */
public class RotateRight {
    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head = rotateRight.rotateRight(head,12);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode curr = new ListNode();
        curr.next = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        if (n <= 1 || (k %= n) == 0) {
            return head;
        }
        ListNode tail = curr;
        ListNode temp = head;
        for (int i = 0; i < n - k - 1; i++) {
            temp = temp.next;
        }
        ListNode result = temp.next;
        temp.next = null;
        tail.next = head;
        return result;
    }
}
