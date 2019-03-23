package mytools.list;

public class MyHashSet {

    private int size;

    private static final int DEFAULT_CAPACITY=10000;

    private static final float DEFAULT_LOAD_FACTOR=0.75f;

    float loadFactor;

    /**
     * 存储散列单元
     */
    Node[] nodes;

    static class Node {
       int hash;
       int key;
       Node next;
       Node(int key,int hash,Node next) {
           this.hash=hash;
           this.key=key;
           this.next=next;
       }
       public int getKey() {return this.key;}
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.loadFactor=DEFAULT_LOAD_FACTOR;
        this.size=0;
        nodes=new Node[DEFAULT_CAPACITY];
    }

    public void add(int key) {
        int hash=hash(key);
        if(!contains(key)) {
            nodes[hash] = new Node(key, hash, nodes[hash]);
            size++;
        }
    }

    public void remove(int key) {
        int hash=hash(key);
        if(contains(key)) {
            Node oldNode = nodes[hash];
            nodes[hash] = oldNode.next;
            oldNode.next = null;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash=hash(key);
        if(nodes[hash]==null) {
            return false;
        }
        Node targetNode=nodes[hash];
        while(targetNode!=null) {
            if(targetNode.key==key) {
                return true;
            }
        }
        return false;
    }


    public int size() { return size; }

    public boolean isEmpty() {return size==0;}

    private int hash(int key) {
        return key%10008;
    }

    /**
     * ["MyHashSet","add", "remove","add", "remove","remove"," add","add","add","add","remove"]
     * [[],[9],[19],[14],[19],[9],[0],[3],[4],[0],[9]]
     */
    public static void main(String[] s) {
        MyHashSet myHashSet=new MyHashSet();
        myHashSet.add(9);
        myHashSet.remove(19);
        myHashSet.add(14);

        myHashSet.remove(19);
        myHashSet.remove(9);

        myHashSet.add(0);
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(0);

        myHashSet.remove(9);
    }
}
