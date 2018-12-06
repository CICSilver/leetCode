import java.util.Arrays;

public class rotate {
    public int[] rotate(int[] nums, int k) {
        int temp[];
        int N=0;
        int t=0;
        temp=new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            N=(i+k)%(nums.length);
            temp[N]=nums[i];
        }
        return temp;
    }
    public static  void  main(String[] args) {
        rotate ro=new rotate();
        int[] nums={1,2,3,4,5,6,7};
        nums=ro.rotate(nums,3);
        System.out.println(Arrays.toString(nums));

    }
}
