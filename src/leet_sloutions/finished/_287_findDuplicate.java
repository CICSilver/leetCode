package leet_sloutions.finished;

public class _287_findDuplicate {
    /**
     *  给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一
     *  个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     * @param nums 数组
     * @return 重复数
     */
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        while(true) {
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow == fast) {
                slow=0;
                while( slow!=fast) {
                    slow=nums[slow];
                    fast=nums[fast];
                }
                return fast;
            }
        }
    }
}
