package leet_sloutions.finished;

import mytools.node.ListNode;

import java.util.Stack;

public class _445_addTwoNumbers {
    /**
     * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将
     * 这两数相加会返回一个新的链表。
     *

     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * 进阶:
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
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
        while(!num1.isEmpty()||!num2.isEmpty()) {
            int temp=0;
            if(!num1.isEmpty()) {
                temp+=num1.pop();
            }
            if(!num2.isEmpty()) {
                temp+=num2.pop();
            }
            temp+=co;
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
        char[] chars=stringBuilder.toString().toCharArray();
        int[] resNum=new int[chars.length];
        for(int i=0;i<chars.length;i++) {
            resNum[i]=(int) chars[i]-48 ;
        }
        return arrayToList(resNum);
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
        int[] num1={1,8};
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
