package mytools.helper;


import java.util.List;

public class intListToArray {
    public static int[] toArray(List<Integer> list) {
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
