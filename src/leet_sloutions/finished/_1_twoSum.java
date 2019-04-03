package leet_sloutions.finished;

public class _1_twoSum {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个
     * 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * @param nums 整数数组
     * @param target 目标值
     */
    public int[] twoSum(int[] nums, int target) {
        int[] id=new int[nums.length];
        int[] returnId=new int[2];
        int n=0;
        boolean isNegative=false;
        for (int num : nums) {
            if (num < 0) {
                isNegative = true;
            }
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
}
