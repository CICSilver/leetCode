import mytools.node.ListNode;
import mytools.sort.Sort;

import java.io.*;
import java.util.*;

public class Solution {

    /**
     * 在char数组中查找重复
     */
    public boolean isCharArrayHasRepeatition(char[] c) {
        boolean isCharArrayHasRepeatition = false;
        if (c.length == 0) {
            return isCharArrayHasRepeatition;
        }
        for (char c1 : c) {
            if (c1 >= 47 && c1 <= 58) {
                for (char c2 : c) {
                    if (c1 == c2) {
                        isCharArrayHasRepeatition = true;
                    }
                }
            }
        }
        return isCharArrayHasRepeatition;
    }

    /**
     * @param x 有符号整数
     * @param unit 要计算的位数，如十位就填2
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
     * 测最远距离，每次走出前一次最远覆盖距离时
     * 用当前最大覆盖距离取代前一次的存储值，并判断是否已经抵达终点。
     */
    public int jump1(int[] nums) {

        int current = 0;
        int maxDis = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > current) {
                current = maxDis;
                step++;
                if(maxDis>=nums.length-1) {
                    break;
                }
            }
            maxDis = Math.max(maxDis, i + nums[i]);

        }
        return step;
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
     * 备忘录法递归运算斐波那契数列，降低递归次数
     * 自顶向下的动态规划
     * @param a 某个斐波那契数列数值的序号
     * @return 斐波那契数列第a个数
     */
    private int fib(int a) {
        if(a<=0) {
            return 0;
        }
        int[] memo=new int[a+1];
        for(int i=0;i<a+1;i++) {
            memo[i]=-1;
        }
        return fib(a,memo);
    }
    private int fib(int n,int[] memo) {
        //若记录数组中有值则直接返回，否则将求出的值保存在数组中
        if(memo[n]!=-1) {
            return memo[n];
        }
        if(n<=2) {
            memo[n]=1;
        }
        else {
            return fib(n - 1, memo) + fib(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * 备忘录法实现钢材价格计算问题
     * @param p 钢材价格
     * @return 钢材最大价值
     */
    private int cut(int[] p,int n) {
        int[] memo=new int[p.length+1];
        for(int i=0;i<=memo.length;i++) {
            memo[i]=-1;
        }
        return cut(p,memo,n);

    }
    private int cut(int[] p,int[] memo,int n) {
        if(n==0) {
            memo[0]=0;
        }
        if(memo[n]!=-1) {
            return memo[n];
        }
        int result=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            result=Math.max(result,cut(p,memo,n-i));
        }
        memo[n]=result;
        return result;
    }


    public static void main(String[] args) throws IOException {
        Solution so=new Solution();
        int test=-2;
        int[] n1={-4,-1,0,3,10};
        String str="abc";
        char[] c={'a','b'};
        String string="";
        HashMap<Character,Character> hashMap=new HashMap<>();
        hashMap.put(')','(');
        System.out.println((int)'0'+","+(int)'9');

    }

}

