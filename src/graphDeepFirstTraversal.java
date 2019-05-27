import edu.princeton.cs.algs4.Queue;

import java.util.Stack;

public class graphDeepFirstTraversal {
    private int[] pre;
    private int[] post;
    private boolean[] marked;
    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private int preCounter;
    private int postCounter;

    public graphDeepFirstTraversal(diEdgeWeightedGraph graph) {
        marked=new boolean[graph.V()];
        pre=new int[graph.V()];
        post=new int[graph.V()];
        preOrder=new Queue<Integer>();
        postOrder=new Queue<Integer>();
        for(int v=0;v<graph.V();v++){
            if(!marked[v]) {
                deepfirstTraversal(graph,v);
            }
        }
    }

    private void deepfirstTraversal(diEdgeWeightedGraph G,int v) {
        marked[v]=true;
        preOrder.enqueue(v);
        pre[v]=preCounter++;
        for(diEdge edge:G.adj(v)) {
            int w=edge.to();
            if(!marked[w]){
                deepfirstTraversal(G,w);
            }
        }
        postOrder.enqueue(v);
        post[v]=postCounter++;
    }

    private void validateV(int v) {
        int V=marked.length;
        if(v<0 || v>V) {
            throw new IllegalArgumentException(v + "不在有效顶点范围内");
        }
    }

    public int pre(int v){
        validateV(v);
        return pre[v];
    }

    public int post(int v){
        validateV(v);
        return post[v];
    }

    public Iterable<Integer> pre(){
        return preOrder;
    }

    public Iterable<Integer> post(){
        return postOrder;
    }

    public static void main(String[] args){

    }
}
