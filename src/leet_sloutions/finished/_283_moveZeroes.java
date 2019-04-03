package leet_sloutions.finished;

public class _283_moveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的
     * 相对顺序。
     */
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
}
