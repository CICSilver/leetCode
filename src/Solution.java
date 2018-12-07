import java.util.Arrays;

public class Solution {
    /**
     * 删除有序数组中的重复值
     */
    public int removeDuplicates(int[] nums) {
        int[] temp=new int[nums.length];
        int N=0;
        for(int i=0;i<nums.length;i++) {
            if (i != nums.length - 1) {
                if (nums[i] != nums[i + 1])
                    temp[N++] = nums[i];
            } else temp[N++] = nums[i];
        }
        /*for(int i=0;i<N;i++) {
            nums[i]=temp[i];
        }*/
        return N;
    }

    /**
     *
     * @param prices 当天股票价格
     * @return
     */
    public int maxprofit(int[] prices) {
        int difference=0;
        int sum=0;
        for(int i=prices.length-1;i>0;i--) {
            difference=prices[i]-prices[i-1];
            if(difference>0)
                sum+=difference;
        }
        return sum;
    }

    //快速排序
    public int[] quickSort(int[] a) {
        if(a.length==0) throw new ArrayIndexOutOfBoundsException("无意义数组");
        if(a.length==1) return a;
        sort(a,0,a.length-1);
        return a;
    }
    private void exch(int[] a,int i,int j) {
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private void sort(int[] items,int left,int right) {
        if(left>=right) {insertSort(items,left,right);return;}
        int i=left;
        int j=right;
        int privot=items[(left+right)/2];
        do{
            while(items[i]<privot&&i<right)
                i++;
            while(items[j]>privot&&j>left)
                j--;
            if(i<=j) {
                exch(items, i, j);
                i++;
                j--;
            }
        }while(i<=j);
        if(i<right)
            sort(items,i,right);
        if(j>left)
            sort(items,left,j);
    }
    //插入排序
    private void insertSort(int[] nums) {
    insertSort(nums,0,nums.length-1);
    }

    private void insertSort(int[] nums,int left,int right) {
        int N=right-left+1;
        for(int i=0;i<N;i++) {
            for(int j=i;j>0&&nums[j]<nums[j-1];j--){
                exch(nums, j, j - 1);
            }
        }

    }
    //判断数组中是否存在重复的数据，需要用到上面的快速排序
    public boolean containsDuplicate(int[] nums){
        if(nums.length==0) return false;
        int temp=nums.length;
        quickSort(nums);
        int N=removeDuplicates(nums);
        return temp != N;
    }
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        quickSort(nums);
        int t=0;
        if(nums[0] !=nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
        for(int i=1;i<nums.length-2;i++) {
        if(nums[i] != nums[i+1])
            if(nums[i+1] != nums[i+2] )
                t=nums[i+1];

        }
    return t;
    }
    //求两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0) return null;
        int count=0;
        nums1=quickSort(nums1);
        nums2=quickSort(nums2);
        if(nums1.length>nums2.length) count=nums2.length;
        else count=nums1.length;
        int temp[]=new int[count];
        int N=0;
        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
                boolean flag=false;
                /*if(j!=nums2.length-1) {
                    if ((nums2[j] ^ nums2[j + 1]) == 0)
                        continue;
                }*/
                if((nums1[i]^nums2[j])==0) {
                    for (int t = 0; t < temp.length; t++) {
                        if (temp[t] == nums1[i]) {
                            flag = true;
                            continue;
                        }
                    }
                    if(flag == false)
                        temp[N++] = nums1[i];
                }
                continue;
            }
        }
        temp=removeZero(temp);
        return temp;
    }
    private int[] removeZero(int[] nums) {
        int[] temp;
        int count=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0)
                count++;
        }
        temp=new int[count];
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0)
                temp[i]=nums[i];
        }
        return temp;
    }
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        boolean flag=false;
        if(n%3==0)
            flag=true;
        return flag;

    }
    public static void main(String[] args) {
        int n=10;
        Solution so=new Solution();
        boolean flag= so.isPowerOfThree(n);
        System.out.println(flag);
    }
}

