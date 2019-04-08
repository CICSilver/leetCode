package leet_sloutions.finished;

public class _53_maximumSubarray {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int sum=0;
        for (int num:nums) {
            if(sum>0) {
                //判断当前子序列的和是否对后续子序列有利
                sum+=num;
            } else  {
                //当前子序列之和若为负数，则舍弃当前子序列
                sum=num;
            }
            res=res>sum?res:sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test={-2,1,-3,4,-1,2,1,-5,4};
        _53_maximumSubarray subarray=new _53_maximumSubarray();
        System.out.println(subarray.maxSubArray(test));
    }
}
