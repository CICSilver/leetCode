import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.util.HashMap;

public class diEdgeWeightedGraph {
    /**
     * 顶点个数
     */
    public final int V;
    /**边的个数
     * */
    public int E;
    /**邻接矩阵
     **/
    private Bag<diEdge>[] adj;
    /**
     * indegree[v] = 顶点v的入度
     */
    private int[] indegree;

    /**
     * 输入顶点个数以初始化一个无边图
     * @param V 点的个数
     */
    public diEdgeWeightedGraph(int V){
        if(V<0) {
            throw new IllegalArgumentException("顶点个数必须大于0");
        }
        this.V = V;
        this.E=0;
        this.indegree=new int[V];
        adj= (Bag<diEdge>[]) new Bag[V];
        for(int v=0;v<V;v++) {
            adj[v]=new Bag<diEdge>();
        }
    }

    public int getV(){
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(diEdge edge) {
        int start=edge.from();
        int end=edge.to();
        validateV(start);
        validateV(end);
        adj[start].add(edge);
        indegree[end]++;
        E++;
    }

    private void validateV(int v) {
        if(v<0 || v>V) {
            throw new IllegalArgumentException(v + "不在有效顶点范围内");
        }
    }

    public int outDegree(int v) {
        validateV(v);
        return adj[v].size();
    }

    public int inDegree(int v) {
        validateV(v);
        return indegree[v];
    }

    /**
     * 以V为起点的深度优先遍历
     * @param v 指定起点
     * @return 遍历结果序列
     */
    public int[] deepTraversal(int v) {
        return new int[0];
    }

    public static void main(String[] args) {
        diEdgeWeightedGraph graph8=new diEdgeWeightedGraph(5);

        //以下为第8,9题图
        diEdge edge1=new diEdge(0,4,99);
        diEdge edge2=new diEdge(1,1,10);
        diEdge edge3=new diEdge(0,2,50);
        diEdge edge4=new diEdge(3,2,20);
        diEdge edge5=new diEdge(2,4,10);
        diEdge edge6=new diEdge(1,3,40);
        diEdge edge7=new diEdge(3,4,60);
        diEdge edge8=new diEdge(0,3,30);
        graph8.addEdge(edge1);
        graph8.addEdge(edge2);
        graph8.addEdge(edge3);
        graph8.addEdge(edge4);
        graph8.addEdge(edge5);
        graph8.addEdge(edge6);
        graph8.addEdge(edge7);
        graph8.addEdge(edge8);
        System.out.println("D点的出度和入度分别为："+graph8.outDegree(3)+","+graph8.inDegree(3));

    }
}
