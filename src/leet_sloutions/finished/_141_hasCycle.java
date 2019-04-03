package leet_sloutions.finished;

import mytools.node.ListNode;

public class _141_hasCycle {
    /**
     * 判断链表是否有环
     * @param head 头结点
     * @return true or false
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        //快慢指针判断是否有重合点
        while(fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
