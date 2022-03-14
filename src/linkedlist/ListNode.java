package linkedlist;

/**
 * @description:
 * @author: zww
 * @date: 2020/11/17
 * @version: V1.0
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
