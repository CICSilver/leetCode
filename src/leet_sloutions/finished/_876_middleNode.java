package leet_sloutions.finished;

import mytools.node.ListNode;

public class _876_middleNode {
    /**
     * 返回单向链表的中间结点
     * 若节点为偶数个，则返回第二个
     * 输入[1,2,3,4,5],输出val=3的结点
     * 输入[1,2,3,4,5,6],输出val=4的结点
     * 结点个数区间为[1,100]
     * @param head 头节点
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        if(head.next==null) {
            return head;
        }
        if(head.next.next==null) {
            return head.next;
        }
        ListNode fast,low;
        low=head.next;
        fast=head.next.next;
        while(fast!=null&&fast.next!=null) {
            low=low.next;

            fast=fast.next.next;
        }
        return low;
    }
}
