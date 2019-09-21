import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.MinPQ;
import org.jetbrains.annotations.NotNull;

public class algs_huffman {
    private static class Node implements Comparable<Node>{
        private int freq;
        private char ch;
        private final Node left,right;
        private Node(char ch,int freq,Node left,Node right) {
            this.ch=ch;
            this.freq=freq;
            this.left=left;
            this.right=right;
        }

        private boolean isLeaf() {
            assert (left ==null && right==null)||(left!=null&&right!=null);
            return left == null && right == null;
        }

        @Override
        public int compareTo(@NotNull  Node that) {
            return this.freq-that.freq;
        }
    }

    public Node buildTrie(Node[] nodes){
        MinPQ<Node> pq= new MinPQ<>(nodes);
        while (pq.size()>1) {
            Node left=pq.delMin();
            Node right=pq.delMin();
            Node parent=new Node('\0',left.freq+right.freq,left,right);
            pq.insert(parent);
        }
        return pq.min();
    }

    public String[] buildCode(Node root) {
        String[] st=new String[256];
        buildCode(st,root,"");
        return st;
    }

    private void buildCode(String[] st,Node x,String s){
        if(x.isLeaf()) {
            st[x.ch]=s;
        }else {
            buildCode(st,x.left,s+'0');
            buildCode(st,x.right,s+'1');
        }

    }

    public static void main(String[] args) {
        algs_huffman test=new algs_huffman();
        Node node1=new Node('A',19,null,null);
        Node node2=new Node('B',2,null,null);
        Node node3=new Node('C',13,null,null);
        Node node4=new Node('D',5,null,null);
        Node node5=new Node('E',11,null,null);
        Node node6=new Node('F',7,null,null);
        Node node7=new Node('G',3,null,null);
        Node node8=new Node('H',17,null,null);
        Node[] nodes={node1,node2,node3,node4,node5,node6,node7,node8};
        Node root=test.buildTrie(nodes);
        String[] code=test.buildCode(root);
        for(int i=0;i<code.length;i++) {
            if(code[i]!=null) {
                System.out.println((char)i+","+code[i]);
            }
        }
    }
}
