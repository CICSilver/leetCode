package leet_sloutions.finished;


import java.util.HashMap;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class _62_uniqePaths {
    private class Node {
        int x;
        int y;
        private Node(int x,int y) {
            this.x=x;
            this.y=y;
        }

        private Node down() {
            return new Node(x,y+1);
        }

        private Node right(){
            return new Node(x+1,y);
        }

        private boolean equals(Node node) {
            return this.x == node.x && this.y ==node.y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj.getClass()!=this.getClass()) {
                return false;
            }
            return equals((Node)obj);
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(this.x)+Integer.hashCode(this.y);
        }
    }
    public int uniquePaths(int m, int n) {
        HashMap<Node,Integer> map=new HashMap<>(m*n);
        Node end=new Node(n-1,m-1);
        Node start=new Node(0,0);
        int sumPaths=0;
        return uniquePaths(start,end,sumPaths,map);
    }

    private int uniquePaths(Node cur,Node end,int sumPaths,HashMap<Node,Integer> map) {
        if(cur.equals(end)) {
            return sumPaths+1;
        }
        if(cur.x==end.x||cur.y == end.y) {
            map.put(cur, sumPaths + 1);
            return map.get(cur);
        } else if(!map.containsKey(cur)){
            if(map.containsKey(cur.right())) {
                return uniquePaths(cur.down(), end, sumPaths, map)+map.get(cur.right());
            }else if(map.containsKey(cur.down())) {
                return uniquePaths(cur.right(), end, sumPaths, map)+map.get(cur.down());
            }else {
                map.put(cur, uniquePaths(cur.down(), end, sumPaths, map) + uniquePaths(cur.right(), end, sumPaths, map));
            }
        }
            return map.get(cur);

    }
    //193536720
    public static void main(String[] args) {
        _62_uniqePaths test=new _62_uniqePaths();
        System.out.println(test.uniquePaths(99,99));
    }
}
