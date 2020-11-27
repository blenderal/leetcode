/**
 * @description:
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * @author: zww
 * @date: 2020/11/20
 * @version: V1.0
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
//        head.next.next.next.next.next = new ListNode(6);
        head = insertionSortList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode insertionSortList(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;
        ListNode p = head;
        ListNode end = sentinel;
        while (p != null) {
            ListNode next = p.next;
            if (p.val >= end.val) {
                end.next = p;
                end = p;
                end.next = null;
            }else {
                ListNode temp = sentinel;
                while (true) {
                    if (p.val <= temp.next.val) {
                        p.next = temp.next;
                        temp.next = p;
                        break;
                    }
                    temp = temp.next;
                }
            }
            p = next;
        }
        return sentinel.next;

//        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
//        ListNode p = head;
//        while (p != null) {
//            ListNode next = p.next;
//            ListNode temp = sentinel;
//            while (true) {
//                if (temp.next == null || p.val <= temp.next.val ) {
//                    p.next = temp.next;
//                    temp.next = p;
//                    break;
//                }
//                temp = temp.next;
//            }
//            p = next;
//        }
//        return sentinel.next;
    }
}
