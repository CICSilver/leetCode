import java.util.Arrays;

public class quickSort {
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
    public static void main(String[] args) {
        int[] test={1,45,5,874,5,488,54,4,56,54,66,48,964,65,468,4156,456,43,2156};
        quickSort qs=new quickSort();
        qs.quickSort(test);
        System.out.println(Arrays.toString(test));
        System.out.println(test.length);
    }
}
