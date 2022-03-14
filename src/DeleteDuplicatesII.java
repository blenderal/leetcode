/**
 * @description:
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * @author: zww
 * @date: 2021/3/26
 * @version: V1.0
 */
public class DeleteDuplicatesII {
    public static void main(String[] args) {
        DeleteDuplicatesII deleteDuplicatesII = new DeleteDuplicatesII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        head = deleteDuplicatesII.deleteDuplicates(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode curr = head;
        while (curr.next != null){
            if(curr.next.val == curr.val){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }
}
