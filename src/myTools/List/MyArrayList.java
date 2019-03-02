package myTools.List;

import myTools.List.imp_List.List;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> implements List<E> {

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

    public MyArrayList(int initialCapacity) {
        if(initialCapacity>0) {
            this.elementData=new Object[initialCapacity];
        } else
        if(initialCapacity==0) {
            this.elementData=EMPTY_ELEMENTDATA;
        }else {
            throw new IndexOutOfBoundsException("不合法的容量大小"+initialCapacity);
        }
    }

    public MyArrayList() { this.elementData=DEFAULT_CAPACITY_ELEMENTDATA; }


    /**
     * 获取集合元素个数
     * @return 元素个数
     */
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
        return indexOf(o)>=0;
    }

    public int indexOf(Object o) {
        return indexOfRange(o,0,size);
    }

    private int indexOfRange(Object o,int start,int end) {
        Object[] ed=elementData;
        int i=start;
        if(o == null) {
            for (;i<end;i++) {
                if(ed[i]==null) {
                    return i;
                }
            }
        }else{
            for(;i<end;i++) {
                if(o.equals(ed[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(elementData,0,size);
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
        @SuppressWarnings("unchecked") E oldValue= (E) ed[index];
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

    /**
     * 调用该方法将清空所有元素，保留内存空间。
     */
    @Override
    public void clean() {
        Object[] ed=elementData;
        for(int i=0;i<size;i++) {
            ed[i]=null;
        }
    }

    /**
     * 不返回被删除元素的remove方法
     * @param index 要删除的元素下标
     */
    private void fastRemove(Object[] ed,int index) {
        final int newSize;
        if((newSize = size - 1)>index) {
            System.arraycopy(elementData,index+1, elementData,index,newSize-index);
        }
        size=newSize;
        ed[size-1] = null;
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index) { return  (E) elementData[index]; }

    /**
     * 获取指定下标处的元素
     * @param index 指定下标
     * @return 特定元素
     */
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
    @SuppressWarnings("unchecked")
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
     * 判断集合是否为初始容量的空集合
     * @param o list
     * @return false or true
     */
    private boolean isDefaultEmpty(Object[] o) {
        return o == DEFAULT_CAPACITY_ELEMENTDATA;
    }

    /**
     * 返回一个初始容量集合
     * @return 初始容量集合
     */
    private Object[] initialElementData() {
        return new Object[DEFAULT_CAPACITY];
    }

    /**
     * add方法的辅助方法，检测集合容量
     * @param index 需要插入的位置(下标)
     */
    private void rangeCheckForAdd(int index) {
        if(index>size||index<0) {
            throw new IndexOutOfBoundsException("非法范围: "+index);
        }
    }

    /**
     * 若超过当前集合容量限制，扩充容量至当前的1.5倍
     */
    private Object[] expansionCapacity(int minCapacity) {
        return elementData= Arrays.copyOf(elementData,newCapacity(minCapacity));
    }

    private Object[] expansionCapacity(){
        return expansionCapacity(size+1);
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity=elementData.length;
        int newCapacity=oldCapacity+(oldCapacity>>1);

        if(newCapacity<=minCapacity) {
            if(elementData==DEFAULT_CAPACITY_ELEMENTDATA) {
                return Math.max(minCapacity,DEFAULT_CAPACITY);
            }
            return minCapacity;
        }
        return newCapacity;
    }

    /**
     * 在{@code index}处插入{@code element}，从{@code index}处往后的元素依次后移
     * 一位
     * @param index 插入位置
     * @param element 插入元素
     */
    @Override
    public void add(int index, E element) {
        if(isDefaultEmpty(this.elementData)) {
            this.elementData=initialElementData();
        }
        rangeCheckForAdd(index);
        int curSize=this.size;
        Object[] elementData=this.elementData;
        if(curSize==elementData.length) {
            elementData=expansionCapacity();
        }
        System.arraycopy(elementData,index,
                elementData,index+1,curSize-index);
        elementData[index]=element;
        size=curSize+1;
    }

    @Override
    public void add(E element) {
        if(isDefaultEmpty(this.elementData)) {
            this.elementData=initialElementData();
        }
        rangeCheckForAdd(size);
        final int curSize=this.size;
        if(curSize==elementData.length) {
            elementData=expansionCapacity();
        }
        elementData[size]=element;
        size=curSize+1;
    }


}
