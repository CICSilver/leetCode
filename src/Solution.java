import myTools.Node.ListNode;
import myTools.sort.Sort;

import java.io.*;
import java.util.*;

    public class Solution {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        //指向一个子链
        public Node child;


        public Node() {}

        public Node(int val,Node prev,Node next,Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }
    public Node flatten(Node head) {
        Stack<Node> nodeStack=new Stack();
        flatten(head,nodeStack);
        return head;
    }
    public void flatten(Node head,Stack<Node> nodeStack) {
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
    /**
     * 删除有序数组中的重复值
     */
    public int removeDuplicates(int[] nums) {
        int[] temp=new int[nums.length];
        int N=0;
        for(int i=0;i<nums.length;i++) {
            if (i != nums.length - 1) {
                if (nums[i] != nums[i + 1])
                    temp[N++] = nums[i];
            } else temp[N++] = nums[i];
        }
        /*for(int i=0;i<N;i++) {
            nums[i]=temp[i];
        }*/
        return N;
    }

        /**
         * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
         * @param head 头节点
         * @param n 倒数序数
         * @return 头节点
         */
    public ListNode removeNthFromEnd(ListNode head, int n) {
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
        deleteNode(temp);
        return head;
    }

    /**
     *
     * @param prices 当天股票价格
     * @return
     */
    public int maxprofit(int[] prices) {
        int difference=0;
        int sum=0;
        for(int i=prices.length-1;i>0;i--) {
            difference=prices[i]-prices[i-1];
            if(difference>0) {
                sum += difference;
            }
        }
        return sum;
    }

        /**
         * 5-4-1-9
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

        /**
         * 判断数组中是否存在重复的数据，需要用到上面的快速排序
          * @param nums 原数组
         * @return true or false
         */
    public boolean containsDuplicate(int[] nums){
        if(nums.length==0) return false;
        int temp=nums.length;
        Sort.quickSort(nums);
        int N=removeDuplicates(nums);
        return temp != N;
    }
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Sort.quickSort(nums);
        int t=0;
        if(nums[0] !=nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
        for(int i=1;i<nums.length-2;i++) {
        if(nums[i] != nums[i+1])
            if(nums[i+1] != nums[i+2] )
                t=nums[i+1];

        }
    return t;
    }
    //求两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] error={};
        if(nums1.length==0||nums2.length==0) return error;
        int[] temp;
        if(nums1.length>nums2.length)
            temp=getRepitionPart(nums2,nums1);
        else
            temp=getRepitionPart(nums1,nums2);



        return temp;
    }
    private int[] getRepitionPart(int[] nums1,int[] nums2) {
        int count=0;
        int N=0;
        int t=-1;
        if(nums1.length>nums2.length)
                count=nums2.length;
        else    count=nums1.length;

        int[] temp = new int[count];
        for(int i=0;i<nums1.length;i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (N == count)
                    break;
                if ((nums1[i] ^ nums2[j]) == 0) {
                    if(t!=j) {
                        t = j;
                        temp[N++] = nums1[i];
                        break;
                    }
                    else continue;
                }
            }
        }
        temp=removeZero(temp,N);
        return temp;
    }
    private int[] removeZero(int[] nums,int N) {
        int[] temp;
        temp=new int[N];
        for(int i=0;i<N;i++) {
            if(nums[i]!=0)
                temp[i]=nums[i];
        }
        return temp;
    }
    //判断n是否为3的幂次方
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467%n == 0;

    }
    //把非负整数按位加入数组并在末位加一
    public int[] plusOne(int[] digits) {
        if(digits.length != 1&&digits[0]==0) return digits;

        if(digits[digits.length-1]==9){

            if(digits[0]==9) {
                int[] temp=new int[digits.length+1];
                temp[0]=1;
                for(int i=1;i<temp.length;i++) {
                    temp[i]=0;
                }
                return temp;
            }
            else {
                for (int i = digits.length-1; i >=0; i--) {
                    if (digits[i] != 9) {
                        digits[i] += 1;
                        for (int j = i+1; j <digits.length; j++) {
                            digits[j] = 0;
                        }
                        break;
                    }
                }
                return digits;
            }
        }
        else {
            digits[digits.length - 1] += 1;
            return digits;
        }


    }
    //移动0到数组末尾并保留原有的非零元素顺序且不适用额外内存
    public void moveZeroes(int[] nums) {
    int N=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[N++]=nums[i];
            }
        }
        while(N<nums.length) {
        nums[N++]=0;
        }

    }

        /**
         * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个
         * 整数，并返回他们的数组下标。
         * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
         * @param nums 整数数组
         * @param target 目标值
         * @return
         */
    public int[] twoSum(int[] nums, int target) {
        int[] id=new int[nums.length];
        int[] returnId=new int[2];
        int n=0;
        boolean isNegative=false;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0) {isNegative=true;}
        }
        for(int i=0;i<nums.length;i++) {
            if(!isNegative) {
                if (nums[i] <= target) {
                    nums[n] = nums[i];
                    id[n++] = i;
                }
            }
            else {
                id[n++]=i;
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(nums[i]>0) {
                    if (nums[i] <= target / 2) {
                        if (nums[j] >= target / 2) {
                            if (nums[i] + nums[j] == target) {
                                returnId[0] = id[i];
                                returnId[1] = id[j];
                                break;
                            }
                        }
                        continue;
                    }
                    if (nums[i] >= target / 2) {
                        if (nums[j] <= target / 2) {
                            if (nums[i] + nums[j] == target) {
                                returnId[0] = id[i];
                                returnId[1] = id[j];
                                break;
                            }
                        }
                        continue;
                    }
                }
                else {
                    if(nums[j]>=target) {
                        if(nums[i]+nums[j]==target) {
                            returnId[0] = id[i];
                            returnId[1] = id[j];
                            break;
                        }
                    }
                }
            }

        }
        return  returnId;
    }

    //判断9X9矩阵是否为一个有效数独
    public boolean isValidSudoku(char[][] board) {
        if(board.length!=9) return false;
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') continue;
                for(int k=8;k>=0;k--) {
                    if(board[i][j]==board[i][k])
                        return false;
                }
                for(int k=8;k>=0;k--) {
                    if(board[i][j] == board[k][j])
                        return false;
                }
                for(int k=i+1;k%3!=0;k++) {
                    for(int h=j/3*3;h<j/3*3+3;h++) {
                        if(board[i][j]==board[k][h])
                            return false;
                    }
                }
            }
        }

        return true;
    }

    //在char数组中查找重复
    public boolean isCharArrayHasRepeatition(char[] c) {
        boolean isCharArrayHasRepeatition = false;
        if (c.length == 0) return isCharArrayHasRepeatition;
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 47 && c[i] <= 58) {
                for (int j = 0; j < c.length; j++) {
                    if (c[i] == c[j])
                        isCharArrayHasRepeatition = true;
                }
            }
        }
        return isCharArrayHasRepeatition;
    }
    //交换等长数组
    public void exchaArray(int[] a,int[] b){
        if(a.length!=b.length) return;
        int[] temp;
        temp=a.clone();
        for(int i=0;i<a.length;i++) {
            a[i]=b[i];
            b[i]=temp[i];
        }
    }
    //交换二维数组数据
    public void exchDoubleArray(int[][] a,int i1,int j1,int i2,int j2) {
        int temp=0;
        temp=a[i1][j1];
        a[i1][j1]=a[i2][j2];
        a[i2][j2]=temp;
    }
    //不适用额外空间沿顺时针方向90°旋转一个正方矩阵
    public void rotate(int[][] matrix) {
        if(!isSquare(matrix))
            return;
        int len=matrix.length;
        if(len==1) return;
        int col=len-1;
        int row=0;
            //降序排行，确定对角线位置
            while (row<(len/2)) {
                exchaArray(matrix[row], matrix[col]);
                row++;
                col--;
            }
            for (col = 0; col < len-1; col++) {
                for (row = col+1; row < len; row++) {
                    exchDoubleArray(matrix, col, row, row, col);
                }
            }
    }
    public boolean isSquare(int[][] matrix) {
        int sum=0;
        for(int i=0;i<matrix.length;i++) {
            if (matrix[i].length != matrix.length)
                return false;
            sum^=matrix[i].length;
        }
        return sum == 0 || sum == matrix[0].length;
    }
    public String reverseString(String s) {
        if(s==null) return s;
        char[] c=s.toCharArray();
        int len=c.length;
        for(int i=0;i<len/2;i++) {
            char temp=c[i];
            c[i]=c[len-1-i];
            c[len-1-i]=temp;
        }
        return String.valueOf(c);
    }
    //反转一个32位有符号整数，
    public int reverse(int x) {
        StringBuffer sb=new StringBuffer();
        String s=String.valueOf(x);
        int result =0;

        if(x<0) sb.append(s.charAt(0));
            for (int i = s.length()-1; i > 0; i--) {
                sb.append(s.charAt(i));
            }
            if(x>0) sb.append(s.charAt(0));
            s=sb.toString();
            try {
                result = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return 0;
            }


        return result;
    }
    //计算一个有符号整数的某一位
    /**
     *
     * @param x 有符号整数
     * @param unit 要计算的位数，如十位就填2
     * @return
     */
    public int calculateUnitOfSignedInt(int x,int unit) {
        int n=0;
        int count=1;
        int temp=unit;
        if(x<0) x=0-x;
        while(unit > 0) {
                x-=n;
                 count*=10;
                n=x%count;
                unit--;
        }
        return n/(count/10);
    }

    /**
     *
     * @param nums
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length==1) {
                return true;
        }
        else {
            if (nums[0] == 0) {
                return false;
            }
        }
        int len=nums.length-1;
        int temp=nums[0];
        int tempId=0;
        int t=0;
            for(int id=0;id<=tempId+temp;id++) {
                if(nums[id]<0) {
                    return false;
                }

                if(nums[id]>=temp) {
                    temp=nums[id];
                    tempId=id;
                }
                if(nums[id]>=len-id) {
                    return true;
                }
                if(id==len) {
                    return true;
                }
                if(id==len-1) {
                    if(nums[id]!=0) {
                        return true;
                    }
                }
                if(id==tempId+temp && nums[id]!=0) {
                    temp=nums[id];
                    tempId=id;
                }
                t=id;
            }
        return false;
    }
    public boolean isBigger(int n1,int n2) {
        return n1 > n2;
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * @param nums 非负整数数组
     * @return
     */
    public int jump(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int steps=0;
        while(end!=0) {
            if (nums[start] + start >= end) {
                end=start;
                start=0;
                steps++;
            }
            else {start++;}
        }

        return steps;
    }
    //测最远距离，每次走出前一次最远覆盖距离时
    // 用当前最大覆盖距离取代前一次的存储值，并判断是否已经抵达终点。
    public int jump1(int[] nums) {

        int current = 0;
        int maxDis = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > current) {
                current = maxDis;
                step++;
                if(maxDis>=nums.length-1) break;
            }
            maxDis = Math.max(maxDis, i + nums[i]);

        }
        return step;
    }
    //给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    public int firstUniqChar(String s) {
        int len=s.length();
        if(len==0) {return -1;}
        if(len==1) {return 0;}
        int id=0;
        char s1,s2;
        int[] muilteCharId=new int[len];
        int startId=0;
        int endId=len-1;
        while(startId!=len-1) {
            for(;endId>startId;endId--) {
                if(startId!=0&&muilteCharId[startId]!=0) {
                    break;
                }
                s1=s.charAt(startId);
                s2=s.charAt(endId);
                if(muilteCharId[endId]!=0) {
                    if(s1==s2) {
                        break;
                    }
                }
                if (s1!= s2) {
                    if(endId-1==startId) {
                        return startId;
                    }
                }
                else {
                    muilteCharId[endId]=endId;
                    break;
                }
            }
            startId++;
            if(startId==len-1&&muilteCharId[startId]==0) {
                return startId;
            }
            endId=len-1;

        }
        return -1;
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s
     *         长度最大为1000的字符串
     *         ababd,jkkjijkljlhjik,jpki ikoj ikpj
     *         jkiu uikj
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length()<=0||s.length()>1000) {return null;}
        char[] arrayS=s.toCharArray();
        int start=0,end=1;
        List<Integer> len=new ArrayList();
        int[] id=new int[s.length()];
        for(int i=0;i<s.length();i++) {
            id[i]=i;
        }
        for(;start<s.length();start++) {
            if(arrayS[start]==arrayS[end])
            {
                len.add(end-start);
            }
        }
        return s;
    }

    /**
     * 获得一个三级双向链表的表头
     * 11->12->13
     *         |
     *        21->22->23
     *            |
     *            31->32
     * @return 返回头节点
     *
     */
    public Node getHead() {

        Node first=new Node(11,null,null,null);
        Node second=new Node(12,first,null,null);
        Node third=new Node(13,second,null,null);
        Node secFirst=new Node(21,null,null,null);
        Node secSecond=new Node(22,secFirst,null,null);
        Node secThird=new Node(23,secSecond,null,null);
        Node thiFirst=new Node(31,null,null,null);
        Node thiSecond=new Node(32,thiFirst,null,null);
        first.next=second;
        second.next=third;
        third.child=secFirst;
        secFirst.next=secSecond;
        secSecond.next=secThird;
        secSecond.child=thiFirst;
        thiFirst.next=thiSecond;
        return first;
    }

        private void writeFile(String text) throws IOException {
            File file=new File("D://output.txt");
            file.createNewFile();
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(text);
            bufferedWriter.flush();
            bufferedWriter.close();
        }

        /**
         * 用于读取txt文件
         * @param fileName 文件名
         * @return txt文件内容
         * @throws Exception 文件未找到
         */
        private String readFile(String fileName) throws Exception {
            File file=new File(fileName);
            InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String str=bufferedReader.readLine();
            StringBuilder stringBuilder=new StringBuilder();
            while(str!=null) {
                stringBuilder.append(str);
                str=bufferedReader.readLine();
            }
            return stringBuilder.toString();
        }

        public int sensetiveCount(String fileName, String sensetiveWord) throws Exception {
            if(sensetiveWord==null||fileName==null) {
                return 0;
            }
            String source=readFile(fileName);
            String[] perWord=source.split(" ");
            int count=0;
            for (String s : perWord) {
                if (s.equals(sensetiveWord)) {
                    count++;
                }
            }
            return count;
        }

        /**
         *  你想知道你拥有的石头中有多少是宝石。
         * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
         * @param J 石头中宝石的类型
         * @param S 代表你拥有的石头，个字符代表了一种你拥有的石头的类型
         * @return 宝石个数
         */
        public int numJewelsInStones(String J, String S) {
            int lenJ=J.length();
            int lenS=S.length();
            int count=0;
            for(int i=0;i<lenS;i++) {
                for(int j=0;j<lenJ;j++) {
                    if(S.charAt(i)==J.charAt(j)) {
                        count++;
                    }
                }
            }
            return count;
        }

        /**
         * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
         * 即两个字符串中字母是否完全相同
         * 例如：s="art",t="rat",返回"true"
         * 可以假设字符串只包含小写字母
         * @param s 标准字符串
         * @param t 判断字符串
         * @return true or false
         */
        public boolean isAnagram(String s, String t) {
            int lenS=s.length(),lenT=t.length();
            if(lenS==0&&lenT==0) {
                return true;
            }
            if(lenS==1&&lenT==1) {
                return s.equals(t);
            }
            if(lenS!=lenT) {
                return false;
            }
            String temp;
            int i=0;
            while(!"".equals(s)) {
                StringBuilder strS=new StringBuilder();
                StringBuilder strT=new StringBuilder();
                temp=Character.toString(s.charAt(i));
                for(String string:s.split(temp)) {
                    strS.append(string);
                }
                s=strS.toString();
                lenS=s.length();
                for(String string:t.split(temp)) {
                    strT.append(string);
                }
                t=strT.toString();
                lenT=t.length();
                if(lenS!=lenT) {
                    return false;
                }
                if(s.equals(t)) {
                    return true;
                }
            }
            return false;
        }
    public static void main(String[] args) {
        Solution so=new Solution();
        //int[] n={2,1,4,2,1,3,3,2,4};
        //String s="cc";
       /* Node head=so.getHead();

        head=so.flatten(head);
        while(head.next!=null) {
            System.out.println(head.val);
            head=head.next;
        }*/
       //System.out.println(t);
        ListNode node0=new ListNode(0);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
       // so.deleteNode(node2);
        ListNode head=node0;
        so.removeNthFromEnd(head,1);
        do{
            System.out.println(head.val);
            head=head.next;
        }while(head.next!=null);
        System.out.println(head.val);
       // System.out.println(so.isAnagram(s,t));
    }

}

