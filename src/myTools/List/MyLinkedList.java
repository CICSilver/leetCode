package myTools.List;

import myTools.List.imp_List.List;

public class MyLinkedList<E> implements List<E> {

    public int size=0;
    public Node<E> first;

    private class Node<E> {
        E item;
        Node<E> first;
        Node<E> last;

        Node<E> prev,next;
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
    public void add(int index, E element) {

    }

    @Override
    public void add(E element) {

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
