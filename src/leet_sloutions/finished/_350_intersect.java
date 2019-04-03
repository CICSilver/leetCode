package leet_sloutions.finished;

public class _350_intersect {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     *
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] error={};
        if(nums1.length==0||nums2.length==0) {
            return error;
        }
        int[] temp;
        if(nums1.length>nums2.length){
            temp=getRepitionPart(nums2,nums1);
        }
        else{
            temp=getRepitionPart(nums1,nums2);
        }



        return temp;
    }
    private int[] getRepitionPart(int[] nums1,int[] nums2) {
        int count;
        int N=0;
        int t=-1;
        if(nums1.length>nums2.length) {
            count = nums2.length;
        }
        else    {
            count=nums1.length;
        }

        int[] temp = new int[count];
        for (int i1 : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if (N == count) {
                    break;
                }
                if ((i1 ^ nums2[j]) == 0) {
                    if (t != j) {
                        t = j;
                        temp[N++] = i1;
                        break;
                    }
                }
            }
        }
        temp=removeZero(temp,N);
        return temp;
    }
    private int[] removeZero(int[] nums,int N) {
        int[] temp;
        temp=new int[N];
        for(int i=0;i<N;i++) {
            if(nums[i]!=0) {
                temp[i] = nums[i];
            }
        }
        return temp;
    }
}
