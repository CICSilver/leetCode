package leet_sloutions.finished;

import mytools.node.ListNode;

public class _142_detectCycle {
    /**
     * 给定一个链表，返回链表开始入环的第一个节点。
     * 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表
     * 中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 说明：不允许修改给定的链表。
     * @param head 头结点
     * @return 入环起始点
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast= fast.next.next;
            if(slow == fast) {
                slow=head;
                while(slow != fast) {
                    slow=slow.next;
                    fast=fast.next;
                }
                return  fast;
            }
        }
        return null;
    }
}
