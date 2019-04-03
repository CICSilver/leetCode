package leet_sloutions.finished;

import mytools.node.ListNode;

public class _21_mergeTwoLists {
    /**
     *
     将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * List1:1-2-3
     * List2:4-5-6
     * Result: 1-4-2-5-3
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode cur=head;
        while(l1!=null&&l2!=null) {
            if(l1.val<l2.val) {
                cur.next=l1;
                cur=cur.next;
                l1=l1.next;
            }else {
                cur.next=l2;
                cur=cur.next;
                l2=l2.next;
            }
        }
        if(l1==null) {
            cur.next=l2;
        }else {
            cur.next=l1;
        }
        return head.next;
    }
}
