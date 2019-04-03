package leet_sloutions.finished;

public class _26_removeDuplicates {
    /**
     * 删除有序数组中的重复值
     */
    public int removeDuplicates(int[] nums) {
        int[] temp=new int[nums.length];
        int N=0;
        for(int i=0;i<nums.length;i++) {
            if (i != nums.length - 1) {
                if (nums[i] != nums[i + 1]) {
                    temp[N++] = nums[i];
                }
            } else {
                temp[N++] = nums[i];
            }
        }
        /*for(int i=0;i<N;i++) {
            nums[i]=temp[i];
        }*/
        return N;
    }
}
