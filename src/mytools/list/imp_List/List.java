package mytools.list.imp_List;

public interface List<E> {
    /**
     * 获取集合大小，如果集合中的元素大于{@code Integer.MAX_VALUE} ，则返回{@code Integer.MAX_VALUE}
     * @return 获取集合大小，如果集合中的元素大于{@code Integer.MAX_VALUE} ，则返回{@code Integer.MAX_VALUE}
     */
    int size();

    /**
     * 当集合中没有任何元素时返回{@code true}
     * @return 当集合中没有任何元素时返回{@code true}
     */
    boolean isEmpty();

    /**
     * 若集合中包含指定元素时，返回{@code true}
     * @param o 指定元素
     * @return 若集合中包含指定元素时，返回{@code true}
     */
    boolean contains(Object o);

    Object[] toArray();

    void add(int index,E element);

    void add(E element);

    E remove(int index);

    boolean remove(Object o);

    void clean();

    E get(int index);

    E set(int index, E element);




}
