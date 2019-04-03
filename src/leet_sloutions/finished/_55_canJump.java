package leet_sloutions.finished;

public class _55_canJump {
    /**
     *
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
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
}
