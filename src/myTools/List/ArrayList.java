package myTools.List;

import myTools.List.imp_List.List;

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
            throw new IndexOutOfBoundsException("不合法的容量大小"+initialCapacity);
        }
    }

    public ArrayList() { this.elementData=DEFAULT_CAPACITY_ELEMENTDATA; }
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
        //TODO
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * 按下标删除某个元素
     * @param index 元素下标
     * @return 被删除的元素
     */
    @Override
    public E remove(int index) {
        Objects.checkIndex(index,size);
        final Object[] ed=elementData;
        @SuppressWarnings("Unchecked") E oldValue=(E) ed[index];
        fastRemove(ed,index);
        return oldValue;
    }

    @Override
    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found: {
            if (o == null) {
                for (; i < size; i++) {
                    if (es[i] == null) {
                        break found;
                    }
                }
            } else {
                for (; i < size; i++) {
                    if (o == es[i]) {
                        break found;
                    }
                }
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    @Override
    public void removeAll() {
        //TODO
    }

    /**
     *
     * @param index
     */
    private void fastRemove(Object[] ed,int index) {
        final int newSize;
        if((newSize=size+1)>index) {

        }

    }

    private E elementData(int index) { return  (E) elementData[index]; }

    @Override
    public E get(int index) {
        Objects.checkIndex(index,size);
        return elementData(index);
    }

    /**
     * 将特定位置的值替换为特定值
     * @param index 指定下标
     * @param element 指定值
     * @return 原来的值
     */
    @Override
    public E set(int index, E element) {
        if(index<0||index>size) {
            throw new IndexOutOfBoundsException("下标"+index+"超出范围");
        }
        Object oldVal=elementData[index];
        final Object[] ed=elementData;
        ed[index]=element;
        return (E) oldVal;
    }

    /**
     * add方法的辅助方法，用于检测集合容量是否需要扩容
     * @param index 需要插入的位置
     */
    private void rangeCheckForAdd(int index) {
        final double coefficient=1.5;
        if(index<0) { throw new IndexOutOfBoundsException("位置参数出错:"+index);}
        if(index>size&&index<(size*coefficient)) {
            expansionCapacity();
        }
        else {
            throw new IndexOutOfBoundsException("非法位置:超出容量限制范围过大");
        }
    }

    /**
     * 若超过当前集合容量限制，扩充容量至当前的1.5倍
     */
    private void expansionCapacity() {
        int curLen=size+(size>>2);
        Object[] nowElement=new Object[curLen];
        if (size >= 0) {
            System.arraycopy(elementData, 0, nowElement, 0, size);
        }
        elementData=nowElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //TODO
    }

    @Override
    public void add(E element) {
        //TODO
    }


}
