package mytools.list;

public class MyHashSet {

    private int size;

    private static final int DEFAULT_CAPACITY=10000;

    private static final float DEFAULT_LOAD_FACTOR=0.75f;

    /*
    装在因子，表示hash表满的程度，实时装载因子用size/capacity计算
     */
    float loadFactor;

    private int hashFactor;

    private static final int DEFAULT_HASH_FACTOR = 1000;

    /**
     * 存储散列单元
     */
    Node[] nodes;

    static class Node {
       int hash;
       int key;
       Node next;
       int floor;
       Node(int key,int hash,Node prev,int floor) {
           this.hash=hash;
           this.key=key;
           this.floor=floor;
           if(prev!=null) {
               prev.next = this;
           }
       }
       public int getKey() {return this.key;}
    }

    /** 初始化一个空的散列表. */
    public MyHashSet() {
        this.loadFactor=DEFAULT_LOAD_FACTOR;
        this.size=0;
        nodes=new Node[DEFAULT_CAPACITY];
    }

    /**
     * 使用指定的数组构造一个散列表
     * @param nums 指定数组
     */
    public MyHashSet(int[] nums) {
        this.hashFactor=nums.length;
        nodes=new Node[nums.length];
        for (int i:nums) {
            add(i);
        }
    }

    public void add(int key) {
        int hash=hash(key);
        int floor=1;
        if(!contains(key)) {
            if(nodes[hash]==null) {
                nodes[hash]=new Node(key,hash,null,floor);
            }else {
                floor++;
                Node tail=nodes[hash];
                while(tail.next!=null) {
                    tail=tail.next;
                    floor++;
                }
                new Node(key,hash,tail,floor);
            }
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
            targetNode=targetNode.next;
        }
        return false;
    }


    public int size() { return size; }

    public boolean isEmpty() {return size==0;}

    public double ASL() {
        double sumFloor=0;
        double count=0;
        for (Node root:nodes) {
            while(root!=null) {
                sumFloor+=root.floor;
                count++;
                root=root.next;
            }
        }
        return sumFloor/count;
    }

    private int hash(int key) {
        if(hashFactor !=0) {
            return key% hashFactor;
        }
        return key%DEFAULT_HASH_FACTOR;
    }

    public void toView() {
        for(int i=0;i<nodes.length;i++) {
            System.out.print(i+":");
            Node root=nodes[i];
            while(root!=null) {
                System.out.print(root.key+",");
                root=root.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] s) {
        int[] nums={9,4,12,14,74,6,16,96};
        MyHashSet myHashSet=new MyHashSet(nums);
        myHashSet.toView();
        System.out.println();
        System.out.println("当前元素个数为:"+myHashSet.size);
        System.out.println("平均搜索长度为:"+myHashSet.ASL());

    }
}
