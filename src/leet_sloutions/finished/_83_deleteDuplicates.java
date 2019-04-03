package leet_sloutions.finished;

import mytools.node.ListNode;

public class _83_deleteDuplicates {
    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元
     * 素只出现一次。
     * @param head 头节点
     * @return 去重后的链表节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
            return null;
        }
        if(head.next==null) {
            return head;
        }
        ListNode temp=head;
        while(temp.next!=null) {
            if(temp.next.val==temp.val) {
                if(temp.next.next==null) {
                    temp.next=null;
                    break;
                }
                temp.next=temp.next.next;
                continue;
            }
            temp=temp.next;
        }
        return head;
    }
}
