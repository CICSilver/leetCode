import myTools.sort.Sort;

import java.util.Arrays;
import java.util.HashMap;

public class betterSolution {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个
     * 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * @param nums 整数数组
     * @param target 目标值
     * @return 符合条件的下标
     */
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
    public static void main(String[] args) {
        int[] test={7,4,2,6,5};
        Sort.quickSort(test);

    }
}
