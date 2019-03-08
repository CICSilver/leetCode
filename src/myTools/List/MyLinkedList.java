package myTools.List;

import myTools.List.imp_List.List;

public class MyLinkedList<E> implements List<E> {

    public int size=0;

    public Node<E> first;

    public Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev,E element,Node<E> next) {
            this.item=element;
            this.prev=prev;
            this.next=next;
        }
    }

    public MyLinkedList(){}
    /**
     * 在头结点前插入
     * @param element 待插入的元素
     */
    private void linkFirst(E element) {
        final Node<E> oldFirst=first;
        final Node<E> newFirst=new Node<>(null,element,oldFirst);
        first=newFirst;
        if(oldFirst == null) {
            last=newFirst;
        } else {
            oldFirst.prev=newFirst;
        }
        size++;
    }

    /**
     * 在尾节点后插入元素
     * @param element 待插入元素
     */
    private void linkLast(E element) {
        final Node<E> oldLast=last;
        final Node<E> newLast=new Node<>(oldLast,element,null);
        last=newLast;
        if(oldLast == null) {
            first=newLast;
        } else {
            oldLast.next=newLast;
        }
        size++;
    }

    /**
     * 在指定结点前插入元素
     * @param element 待插入元素
     * @param target 指定结点
     */
    private void linkBefore(E element,Node<E> target) {
        Node<E> targetPrev=target.prev;
        Node<E> node=new Node<>(targetPrev,element,target);
        target.prev=node;
        if(targetPrev == null) {
            first=node;
        } else {
            targetPrev.next=node;
        }
        size++;
    }

    /**
     * 获取第 {@code index}个结点，内部方法，无越界排查
     * @param index 指定位置
     * @return 特定位置的结点
     */
    private Node<E> node(int index) {
        Node<E> node;
        if(index < (size>>1)) {
            node=first;
            for(int i=0;i<index;i++) {
                node=node.next;
            }
        }else  {
            node=last;
            for(int i=size-1;i>index;i--) {
                node=node.prev;
            }
        }
        return node;
    }

    private boolean isIndexLegal(int index) {
        return index>0 && index<size;
    }

    private void checkIndex(int index) {
        if(!isIndexLegal(index)) {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 检测链表中是否存在指定元素{@code o}
     * @param o 指定元素
     * @return true or false
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o)>=0;
    }

    /**
     * 返回指定元素{@code o}第一次出现时的下标
     * @param o 指定元素
     * @return 下标
     */
    private int indexOf(Object o) {
        int index=0;
        if(o == null) {
            for(Node<E> x=first;x!=null;x=x.next) {
                if(x.item == null) {
                    return index;
                }
                index++;
            }
        }else {
            for(Node<E> x=first;x!=null;x=x.next) {
                if(o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * 将链表中的所有元素转化为数组输出
     * @return 包含链表所有元素的数组
     */
    @Override
    public Object[] toArray() {
        Object[] result=new Object[size];
        int i=0;
        for(Node<E> x=first;x!=null;x=x.next) {
            result[i++]=x.item;
        }
        return result;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if(index==size) {
            linkLast(element);
        } else {
            linkBefore(element,node(index));
        }
    }

    @Override
    public void add(E element) {
        linkLast(element);
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clean() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }
}
