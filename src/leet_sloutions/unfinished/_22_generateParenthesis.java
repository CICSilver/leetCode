package leet_sloutions.unfinished;

import com.sun.jdi.event.StepEvent;

import java.util.*;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class _22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        HashMap<Integer,List<String>> map=new HashMap<>();
        if(n==0) {
            return new ArrayList<>();
        }
        return generateParenthesis(n,map);
    }

    private List<String> generateParenthesis(int n,HashMap<Integer,List<String>> map) {
        HashSet<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        if(map.containsKey(n)) {
            return map.get(n);
        }
        if(n==0) {
            map.put(0,new ArrayList<>());
            return new ArrayList<>();
        }
        if(n==1) {
            List<String> list=new ArrayList<>();
            list.add("()");
            return list;
        }
        int count=1;
        if(n>2) {
            while (count <= 2) {
                for (String s : generateParenthesis(n - count, map)) {
                    set.add(sb.append("(").append(s).append(")").toString());
                    sb.delete(0, sb.length());
                    set.add(sb.append("()").append(s).toString());
                    sb.delete(0, sb.length());
                    set.add(sb.append(s).append("()").toString());
                    sb.delete(0, sb.length());
                }
                map.put(n, new ArrayList<>(set));
                count++;
            }
        }else {
            for (String s : generateParenthesis(n - 1, map)) {
                set.add(sb.append("(").append(s).append(")").toString());
                sb.delete(0, sb.length());
                set.add(sb.append("()").append(s).toString());
                sb.delete(0, sb.length());
                set.add(sb.append(s).append("()").toString());
                sb.delete(0, sb.length());
            }
            map.put(n, new ArrayList<>(set));
        }
            return map.get(n);
    }


    public static void main(String[] s){
        _22_generateParenthesis test=new _22_generateParenthesis();
        String[] s2={"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
        String[] s1={"()()()()","(()())()","(()(()))","()()(())","((()))","(())()","(((())))","(())()()","()((()))","()()()","()(())()","(()())","()(())","()(()())","(()()())","((()()))","((()))()","((())())"};
        /*String[] res=new String[5];
        for(int i=0;i<s1.length;i++) {
            for (int j=0;j<s2.length;j++) {
                if(s1[i].equals(s2[j])) {
                    s1[i]=null;
                    break;
                }
            }
        }
        for (String st:s1) {
            if(st!=null) {
                System.out.println(st);
            }

        }*/
        System.out.println(Arrays.toString(test.generateParenthesis(4).toArray()));
    }
}
