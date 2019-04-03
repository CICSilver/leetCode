package leet_sloutions.unfinshed;

import mytools.node.ListNode;

public class _445_addTwoNumbers {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序
     * 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @param l1 输入链表1
     * @param l2 输入链表2
     * @return 一个新链表，表示它们的和
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) {
            return null;
        }
        //记录进位
        int carryBit=0;
        ListNode result=new ListNode(0);
        ListNode dummyhead=result;
        while(l1!=null && l2!=null) {
            result.next=new ListNode((l1.val+l2.val+carryBit)/10);
            result=result.next;
            carryBit=(l1.val+l2.val)%10;


            l1=l1.next;
            l2=l2.next;
        }
        if(l1 == null) {
            if(l2!=null){
                result.next=l2;
            }
        } else {
            if(l2 ==null) {
                result.next=l1;
            }
        }

        return dummyhead.next;
    }
}
