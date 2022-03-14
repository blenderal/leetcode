/**
 * @description:
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * @author: zww
 * @date: 2021/3/25
 * @version: V1.0
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        head = deleteDuplicates.deleteDuplicates(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode curr = sentinel;
        while (curr != null) {
            ListNode start = curr.next;
            if (start != null) {
                while (start.next != null && start.next.val == curr.next.val) {
                    start = start.next;
                }
                if(start!=curr.next && start.val == curr.next.val){
                    start = start.next;
                    curr.next = start;
                    continue;
                }
            }
            curr.next = start;
            curr = curr.next;
        }
        return sentinel.next;
    }
}
