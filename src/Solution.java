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

    /**
     * 快速排序
     *
     */
    public int[] quickSort(int[] a) {
        sort(a,0,a.length-1);
        return a;
    }
    private void exch(int[] a,int i,int j) {
        /*a[i]=a[i]^a[j];
        a[j]=a[i]^a[j];
        a[i]=a[i]^a[j];*/
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private void sort(int[] items,int left,int right) {
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

    public boolean containsDuplicate(int[] nums){
        if(nums.length==0) return false;
        int temp=nums.length;
        quickSort(nums);
        int N=removeDuplicates(nums);
        return temp != N;
    }
    public static void main(String[] args) {
        int[] temp={};
        Solution so=new Solution();
        Boolean flag=so.containsDuplicate(temp);
        System.out.println(flag);
    }
}

