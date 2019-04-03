package leet_sloutions.finished;

import mytools.node.ListNode;

public class _82_deleteDuplicatesII {
    /**
     * 保留单向链表中未重复过的结点
     * fakeNode->1->1->2->2
     * @param head 头结点
     * @return 操作后的头结点
     */
    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode dummyHead = new ListNode(head);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        // 标识当前节点是否需要删除
        boolean curIsDelete = false;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                // 出现重复节点, 将当前cur标记为需要删除
                curIsDelete = true;
            } else {
                if (curIsDelete) {
                    pre.next = cur.next;
                    cur = pre.next;

                    // 新的cur节点,所以需要重置curIsDelete
                    curIsDelete = false;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
        }

        if (curIsDelete) {
            pre.next = cur.next;
            cur = pre.next;
            // 新的cur节点,所以需要重置curIsDelete
            curIsDelete = false;
        }

        return dummyHead.next;
    }
}
