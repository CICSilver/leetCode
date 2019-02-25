import java.util.concurrent.Callable;

/**
 * @author CIC_Silver
 * 利用多线程加速的快速排序算法
 */
public class ThreadAcclerateQuickSort implements Callable<Item>,Runnable {
    Item item;

    @Override
    public Item call() throws Exception {
        return null;
    }

    @Override
    public void run() {

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
