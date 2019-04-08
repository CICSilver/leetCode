package leet_sloutions.finished;

import mytools.node.ListNode;

import java.util.Stack;

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
        StringBuilder stringBuilder=new StringBuilder();
        //记录进位
        int co = 0;
        Stack<Integer> num1=new Stack<>();
        while(l1!=null) {
            num1.push(l1.val);
            l1=l1.next;
        }
        Stack<Integer> num2=new Stack<>();
        while (l2!=null) {
            num2.push(l2.val);
            l2=l2.next;
        }
        while(!num1.isEmpty()&&num2.size()!=0) {
            int temp=num1.pop()+num2.pop()+co;
            if(temp>9) {
                co=1;
                temp%=10;
            } else {
                co=0;
            }
            stringBuilder.append(temp);
        }
        while(num1.size()!=0) {
            int temp=num1.pop()+co;
            if(temp>9) {
                co=1;
                temp%=10;
            } else {
                co=0;
            }
            stringBuilder.append(temp);
        }
        while(num2.size()!=0) {
            int temp=num2.pop()+co;
            if(temp>9) {
                co=1;
                temp%=10;
            } else {
                co=0;
            }
            stringBuilder.append(temp);
        }
        if(co!=0) {
            stringBuilder.append(co);
            co=0;
        }
        char[] chars=stringBuilder.reverse().toString().toCharArray();
        int[] resNum=new int[chars.length];
        for(int i=0;i<chars.length;i++) {
            resNum[i]=(int) chars[i]-48 ;
        }
        ListNode head=arrayToList(resNum);
        return head;
    }

    private ListNode arrayToList(int[] num) {
        ListNode head1=new ListNode(0);
        ListNode dummyHead=head1;
        for(int i=0;i<num.length;i++){
            head1.next=new ListNode(num[i]);
            head1=head1.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] num1={7,2,4,3};
        int[] num2={0};
        _445_addTwoNumbers addTwoNumbers=new _445_addTwoNumbers();
        ListNode head1=addTwoNumbers.arrayToList(num1);
        ListNode head2=addTwoNumbers.arrayToList(num2);

        ListNode result=addTwoNumbers.addTwoNumbers(head1,head2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
