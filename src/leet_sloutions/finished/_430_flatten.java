package leet_sloutions.finished;

import java.util.Stack;

public class _430_flatten {
    class Node {
        public int val;
        Node prev;
        public Node next;
        Node child;


        public Node() {}

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    /**
     * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向
     * 单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据
     * 结构，如下面的示例所示。
     *
     *输入:
     *  1---2---3---4---5---6--NULL
     *          |
     *          7---8---9---10--NULL
     *              |
     *              11--12--NULL
     *
     * 输出:
     * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
     *
     * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
     */
    public Node flatten(Node head) {
        Stack<Node> nodeStack=new Stack<>();
        flatten(head,nodeStack);
        return head;
    }
    private void flatten(Node head, Stack<Node> nodeStack) {
        //不在末尾的结点，循环结束时结点位于子链最末尾
        while(head.next!=null) {
            //不在末尾且有子链的结点
            if(head.child!=null) {
                //子链头部与父链结点的扁平化操作
                //将拥有子链的结点的后一个结点推入栈中
                nodeStack.add(head.next);
                head.next=head.child;
                head.child.prev=head;
                head.child=null;
                head=head.next;
            }
            //不在末尾且没有子链的结点,即普通结点
            else {
                head=head.next;
            }
        }
        //处于末尾但连接子链的结点
        if(head.child!=null) {
            head.next=head.child;
            head.child.prev=head;
            head.child=null;
            flatten(head.next,nodeStack);
        }
        //对子链末尾结点操作，与上一级后续链拼接
        if(!nodeStack.isEmpty()) {
            Node temp=nodeStack.pop();
            head.next=temp;
            temp.prev=head;
            flatten(head.next,nodeStack);
        }
    }
}
