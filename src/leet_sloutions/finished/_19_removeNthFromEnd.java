package leet_sloutions.finished;

import mytools.node.ListNode;

public class _19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        _237_deleteNode de=new _237_deleteNode();
        if(head.next==null) {
            return null;
        }
        int len=0;
        ListNode temp=head;
        while(temp.next!=null) {
            len++;
            temp=temp.next;
        }
        temp=head;
        len++;
        int realNumber=len-n+1;
        if(n==1) {
            while (realNumber > 2) {
                temp=temp.next;
                realNumber--;
            }
            temp.next=null;
            return head;
        }
        for(;realNumber>1;realNumber--) {
            temp=temp.next;
        }
        de.deleteNode(temp);
        return head;
    }
}
