public class removeDoubleElementsInArray {
    public int removeDuplicates(int[] nums) {
        int[] temp=new int[nums.length];
        int N=0;
        for(int i=0;i<nums.length;i++) {
            if (i != nums.length - 1) {
                if (nums[i] != nums[i + 1])
                    temp[N++] = nums[i];
            } else temp[N++] = nums[i];
        }
        for(int i=0;i<N;i++) {
            nums[i]=temp[i];
        }
        return N;

        }
        public static void main(String[] args) {
        int[] nums={0,0,2,3,4,5};
        removeDoubleElementsInArray so=new removeDoubleElementsInArray();
        int N=so.removeDuplicates(nums);
        System.out.println(N);
            for (int i:nums
                 ) {
                System.out.print(i+" ");
            }
            System.out.println();

        }
}
