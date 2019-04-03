package leet_sloutions.finished;

import mytools.node.ListNode;

public class _237_deleteNode {
    /**
     * 删除某个链表中给定的（非末尾）节点
     * @param node 需要删除的结点
     */
    public void deleteNode(ListNode node) {
        ListNode tempNode=node.next;
        while(tempNode.next!=null) {
            node.val = tempNode.val;
            node=tempNode;
            tempNode = tempNode.next;
        }
        node.val=tempNode.val;
        node.next=null;
    }
}
