import edu.princeton.cs.algs4.In;
import myTools.List.MyArrayList;
import myTools.Node.ListNode;

import java.io.IOException;
import java.util.*;


/**
 * @author 10385
 */
public class betterSolution extends Solution {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个
     * 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * @param nums 整数数组
     * @param target 目标值
     * @return 符合条件的下标
     */
    @Override
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap=new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++) {
            //判断map中是否存在与差值相同的key
            if(hashMap.containsKey(nums[i])) {
                //若存在，即当前值的下标符合条件，map中key为当前值所对应的val及对应值的下标
                return new int[]{hashMap.get(nums[i]),i};
            }
            //没有则将target与当前值的差值作为key,下标作为val存入map
            hashMap.put(target-nums[i],i);
        }
        return null;
    }

    public void sort(int left, int right, int[] str) {
        int i,j,pos;
        if(left>=right)
        {
            return;
        }
        i=left;
        j=right;
        pos=str[i];
        while(i<j)
        {
            while(i<j && pos<=str[j])
            {
                j--;
            }
            if(i<j)
            {
                str[i]=str[j];
            }

            while(i<j && pos>=str[i])
            {
                i++;
            }
            if(i<j)
            {
                str[j] = str[i];
            }
            str[i]=pos;
            sort(left,i-1,str);
            sort(i+1,right,str);
        }

    }

    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null|headB==null) {
            return null;
        }
        ListNode last=headB;
        while(last.next!=null) {
            last=last.next;
        }
        //构造链表B为环形链表
        last.next=headB;

        ListNode slow=headA;
        ListNode fast=headA;

        //定义:A,B共有长度为 commonSize;各自总长度为 allSizeA,allSizeB;各自的剩余长度为singleSizeA,singleSizeB;

        //即，allSizeA = singleSizeA + commonSize ,
        //    allSizeB = singleSizeB + commonSize ;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            //第一次循环，快慢结点都由headA出发，在环形链表B中相交时，移动次数等于链表B的总长度；该重合结点与目标结点的长度即为 singleSizeA
            if(slow==fast) {
                slow=headA;
                while(slow!=fast) {
                    //第二次循环，此时两结点移动速度相同，再次重合的位置即为目标结点
                    slow=slow.next;
                    fast=fast.next;
                }
                last.next=null;
                return fast;
            }
        }
        last.next=null;
        return null;
    }

    public static void main(String[] args) throws IOException {
        int len=10;
        int[] test={1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> arrayList=new ArrayList<>(20);
        MyArrayList<Integer> arrayList1=new MyArrayList<Integer>(10);
        for(int i=0;i<len;i++) {
            arrayList1.add(i);
        }
        arrayList1.remove(3);
        for(int i=0;i<arrayList1.size();i++) {
            if(arrayList1.get(i)==null) {
                System.out.println(i);
            }
        }


    }
}
