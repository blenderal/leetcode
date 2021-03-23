import java.util.List;

/**
 * @description:
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @author: zww
 * @date: 2021/3/18
 * @version: V1.0
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode listNode = reverseBetween.reverseBetween(head,5,6);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode pre = sentinel;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next;
        for (int i = 0; i < n-m; i++) {
            next = curr.next;
            curr.next=next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return sentinel.next;
    }
}
