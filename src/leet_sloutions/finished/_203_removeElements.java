package leet_sloutions.finished;

import mytools.node.ListNode;

public class _203_removeElements {
    /**
     * 删除链表中等于给定值 val 的所有节点。
     * @param head 头结点
     * @param val 结点值
     * @return 头结点值
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) {
            return head;
        }

        ListNode dummyHead=new ListNode(head);
        ListNode prev=dummyHead;
        ListNode curNode=head;
        while(curNode!=null) {
            if(curNode.val==val) {
                prev.next=curNode.next;
            }
            curNode=curNode.next;
            if(prev.next!=curNode) {
                prev=prev.next;
            }
        }
        return dummyHead.next;
    }
}
