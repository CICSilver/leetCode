package leet_sloutions.finished;

import mytools.helper.intListToArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 1<<1 + 9<<1 = 82
 * 8<<1 + 2<<1 = 68
 * 6<<1 + 8<<1 = 100
 * 1<<1 + 0<<1 + 0<<1 = 1
 */
public class _202_happyNum {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        return isHAPPY(n,set);
    }

    private boolean isHAPPY(int n,HashSet<Integer> set) {
        int res=calculateEachUnit(getUnit(n));
        if(res == 1) {
            return true;
        } else if(set.contains(res)) {
            return false;
        }else {
            set.add(res);
           return isHAPPY(res,set);
        }
    }

    private int[] getUnit(int n) {
        List<Integer> list=new ArrayList<>();
        while(n/10!=0) {
            list.add(n%10);
            n=n/10;
        }
        list.add(n);
        return intListToArray.toArray(list);
    }

    private int calculateEachUnit(int[] n) {
        int sum=0;
        for(int i:n) {
            sum+=Math.pow(i,2);
        }
        return sum;
    }

    public static void main(String[] s){
        _202_happyNum test=new _202_happyNum();
        System.out.println(test.isHappy(2));
    }
}
