package leet_sloutions.finished;

import java.util.HashMap;
import java.util.Stack;

public class _20_isValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']
     * 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     * {()} true
     * {([)]}  false
     * 0,1,2,3,4,5
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    public boolean isValid(String s) {
        if(s.length()==0) {
            return true;
        }
        HashMap<Character,Character> hashMap=new HashMap<>(3);
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
        Stack<Character> stack=new Stack<>();
        char c;
        for(int i=0;i<s.length();i++) {
            c=s.charAt(i);
            if(hashMap.containsKey(c)) {
                char top=stack.empty()?'#':stack.pop();
                if(top!=hashMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
