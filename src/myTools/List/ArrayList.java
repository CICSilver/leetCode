package myTools.List;

import myTools.List.imp_List.List;

import javax.management.ObjectName;
import java.util.Objects;

public class ArrayList<E> implements List<E> {

    /**
     * 默认容量大小
     */
    private static final int DEFAULT_CAPACITY=10;
    /**
     * 初始空集合
     */
    private static final Object[] EMPTY_ELEMENTDATA={};
    /**
     * 长度为默认容量的空集合
     */
    private static final Object[] DEFAULT_CAPACITY_ELEMENTDATA={};

    private int size;

    private Object[] elementData;


    public ArrayList(int initialCapacity) {
        if(initialCapacity>0) {
            this.elementData=new Object[initialCapacity];
        }
        if(initialCapacity==0) {
            this.elementData=EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("不合法的容量大小"+initialCapacity);
        }
    }

    public ArrayList() {
        this.elementData=DEFAULT_CAPACITY_ELEMENTDATA;

    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeAll() {

    }

    E elementData(int index) { return (E) elementData[index]; }

    @Override
    public E get(int index) {
        Objects.checkIndex(index,size);
        return elementData(index);
    }

    @Override
    public E set(int index) {

        return null;
    }

    /**
     * add方法的辅助方法，用于检测集合容量是否需要扩容
     * @param index 需要插入的位置
     */
    private void rangeCheckForAdd(int index) {
        if(index<0) {
            throw new IllegalArgumentException("非法的位置"+index);
        }
        if(index>size&&index<(size*1.5)) {
            expansionCapacity();
        }
        else {
            throw new IllegalArgumentException("非法位置："+"超出容量限制范围过大");
        }
    }

    /**
     * 若超过当前集合容量限制，扩充容量至当前的1.5倍
     */
    private void expansionCapacity() {
        int curLen=size+(size/2);
        Object[] nowElement=new Object[curLen];
        if (size >= 0) {
            System.arraycopy(elementData, 0, nowElement, 0, size);
        }
        elementData=nowElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

    }


}
