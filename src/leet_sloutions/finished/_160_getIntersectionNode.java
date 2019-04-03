package leet_sloutions.finished;

import mytools.node.ListNode;

public class _160_getIntersectionNode {
    /**
     * 查找两个相交结点的起始节点
     * @param headA 链表A的头结点
     * @param headB 链表B的头结点
     * @return 起始相交结点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        for(ListNode x = headA; x!=null; x=x.next) {
            for(ListNode y = headB; y!=null; y=y.next) {
                if(x.equals(y)) {
                    return y;
                }
            }
        }
        return null;
    }
}
