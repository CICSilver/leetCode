package leet_sloutions.finished;

import mytools.node.ListNode;

public class _206_reverseList {
    /**
     * 反转一个单向链表
     * 5-4-3-2-1-null
     * 1-2-3-4-5-null
     * @param head 链表头
     * @return 返回链表头
     */
    public ListNode reverseList(ListNode head) {
        if(head==null) {
            return head;
        }
        if(reverseListItera(head)) {
            return head;
        }
        return head;
    }
    private boolean reverseListItera(ListNode head) {
        if(head.next==null) {
            return true;
        }
        ListNode tempHead=head;
        ListNode prevVal=new ListNode(head.val);
        ListNode nextVal=new ListNode(head.val);
        while(head.next!=null) {
            prevVal.val=nextVal.val;
            nextVal.val=head.next.val;
            head.next.val=prevVal.val;
            head=head.next;
        }
        head.val=prevVal.val;
        tempHead.val=nextVal.val;
        reverseListItera(tempHead.next);
        return false;
    }
}
