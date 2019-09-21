package mytools.sort;


import java.util.Arrays;

/**
 * @author CICSilver
 */
public class Sort {
    private static int sortCount;
    //快速排序
    public static int[] quickSort(int[] a) {
        if(a.length==0) {
            throw new ArrayIndexOutOfBoundsException("");
        }

        if(a.length==1) {
            return a;
        }
        sortCount=0;
        sort(a,0,a.length-1);
        return a;
    }
    public static void exch(int[] a, int i, int j) {
        int temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private static void sort(int[] items, int left, int right) {
        if(left>=right) {insertSort(items,left,right);return;}
        //递归出口
        int i=left;
        int j=right;
        int privot=items[(left+right)/2];
        sortCount++;
        do{
            //将数组依据标记值privot分为两部分，左侧找比标记值大的，右侧找比标记值小的，然后互换位置
            while(items[i]<privot&&i<right) {
                i++;
            }
            while(items[j]>privot&&j>left) {
                j--;
            }
            if(i<=j) {
                exch(items, i, j);
                i++;
                j--;
            }
        }while(i<=j);
        System.out.println(Arrays.toString(items)+", 标记值为："+privot+" ,排序次数为:"+sortCount);
        if(i<right) {
            sort(items, i, right);
        }
        if(j>left) {
            sort(items, left, j);
        }
    }

    //辅助插入排序
    private static void insertSort(int[] nums, int left, int right) {
        int length=right-left+1;
        for(int i=0;i<length;i++) {
            for(int j=i;j>0&&nums[j]<nums[j-1];j--){
                exch(nums, j, j - 1);
            }
        }
    }

    public static void insertSort(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            int temp=nums[i],j;
            for(j=i-1;j>=0&&temp<nums[j];j--) {
                nums[j+1]=nums[j];
            }
            nums[j+1]=temp;
        }
    }

    public static void shellSort(int[] nums) {
        for(int delta=nums.length/2;delta>=1;delta/=2) {
            for(int i=delta;i<nums.length;i++) {
                int temp=nums[i],j;
                for(j=i-delta;j>=0&&temp<nums[j];j-=delta) {
                    nums[j+delta]=nums[j];
                }
                nums[j+delta]=temp;
                System.out.println(Arrays.toString(nums));
            }
        }
    }


    public static void main(String[] s){
        int[] nums={93,17,56,42,78,15,42,25,19};
        shellSort(nums);
        //System.out.println(Arrays.toString(nums));
    }

}
