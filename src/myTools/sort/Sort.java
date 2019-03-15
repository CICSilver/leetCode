package myTools.sort;


import java.util.Arrays;

/**
 * @author XYR
 */
public class Sort {

    //快速排序
    public static int[] quickSort(int[] a) {
        if(a.length==0) {
            throw new ArrayIndexOutOfBoundsException("");
        }

        if(a.length==1) {
            return a;
        }
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
        if(i<right) {
            sort(items, i, right);
        }
        if(j>left) {
            sort(items, left, j);
        }
    }

    //插入排序
    private static void insertSort(int[] nums, int left, int right) {
        int N=right-left+1;
        for(int i=0;i<N;i++) {
            for(int j=i;j>0&&nums[j]<nums[j-1];j--){
                exch(nums, j, j - 1);
            }
        }

    }


}
