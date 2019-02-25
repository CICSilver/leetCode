import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author CIC_Silver
 * 利用多线程加速的快速排序算法
 */
public class ThreadAcclerateQuickSort implements Callable<Item> {
    public static Item item;

    @Override
    public Item call() throws Exception {
        
        return null;
    }
    public static void main(String[] args) {
        Callable<Item> callable=new ThreadAcclerateQuickSort();
        FutureTask<Item> task=new FutureTask<>(callable);
        int[] testArray={2,3,1,5,6,4};
        item=new Item(testArray[0], testArray[testArray.length],testArray.length/2,testArray);
        new Thread(task).start();
    }

}


class Item {
    private int left;
    private int right;
    private int mid;
    private int[] array;

    public Item(int left, int right, int mid, int[] array) {
        this.left=left;
        this.right=right;
        this.mid=(left+right)/2;
        this.array=array;
    }

    public int getLeft() {
        return left;
    }

    public int getMid() {
        return mid;
    }

    public int getRight() {
        return right;
    }

    public int[] getArray() {
        return array;
    }

    public boolean cmpLeftMiddle() {
        return left<mid;
    }

    public boolean cmpRightMiddle() {
        return right>mid;
    }

}
