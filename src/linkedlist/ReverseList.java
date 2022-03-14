package linkedlist;

/**
 * @description:
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author: zww
 * @date: 2021/4/1
 * @version: V1.0
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode p1 = head;
//        ListNode p2 = head.next;
//        ListNode p3 = null;
//        while (p2 != null){
//            p3 = p2.next;
//            p2.next = p1;
//            p1 = p2;
//            p2 = p3;
//        }
//        head.next = null;
//        return p1;
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
