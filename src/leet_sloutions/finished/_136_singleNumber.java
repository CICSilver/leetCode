package leet_sloutions.finished;

import mytools.sort.Sort;

public class _136_singleNumber {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Sort.quickSort(nums);
        int t=0;
        if(nums[0] !=nums[1]){
            return nums[0];
        }
        if(nums[nums.length-1] != nums[nums.length-2]){
            return nums[nums.length-1];
        }
        for(int i=1;i<nums.length-2;i++) {
            if(nums[i] != nums[i+1])
                if(nums[i+1] != nums[i+2] )
                    t=nums[i+1];

        }
        return t;
    }
}
