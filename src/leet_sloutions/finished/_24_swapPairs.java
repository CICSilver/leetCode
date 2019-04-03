package leet_sloutions.finished;

import mytools.node.ListNode;

public class _24_swapPairs {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * @param head
     * 头结点
     * @return
     * 交换后的头结点
     */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        ListNode nex=head.next;
        head.next=swapPairs(nex.next);
        nex.next=head;
        return head;
    }
}
