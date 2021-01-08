import java.util.List;

/**
 * @description:
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * @author: zww
 * @date: 2021/1/3
 * @version: V1.0
 */
public class Partition {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head = partition(head,3);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode smallTail = small;
        ListNode big = new ListNode();
        ListNode bigTail = big;
        while (head != null){
            if(head.val < x){
                smallTail.next = head;
                head = head.next;
                smallTail = smallTail.next;
                smallTail.next = null;
            }else {
                bigTail.next = head;
                head = head.next;
                bigTail = bigTail.next;
                bigTail.next = null;
            }

        }
        smallTail.next =big.next;
        return small.next;
    }
}
