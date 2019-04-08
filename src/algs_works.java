import java.util.*;

public class algs_works {

    /**
     * 字符串转中缀
     */
    private ArrayList<String> stringToList(String str) {
        ArrayList<String> infix=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<str.length();i++) {
            if((int)str.charAt(i)>47&&(int)str.charAt(i)<58) {
                stringBuilder.append(str.charAt(i));
                if(i==str.length()-1) {
                    infix.add(stringBuilder.toString());
                }
            } else {
                if("".equals(stringBuilder.toString())) {
                    infix.add(Character.toString(str.charAt(i)));
                    continue;

                }
                infix.add(stringBuilder.toString());
                stringBuilder.delete(0,stringBuilder.length());
                infix.add(Character.toString(str.charAt(i)));
            }
        }
        for(int i=0;i<infix.size();i++) {
            if(" ".equals(infix.get(i))) {
                infix.remove(i);
            }
        }
        return infix;
    }

    /**
     * 中缀表达式转后缀表达式符号
     * @param str 中缀表达式
     * @return 后缀表达式
     */
    private ArrayList<String> infixToPostfix(String str) {
        ArrayList<String> infix=stringToList(str);
        System.out.println(infix);
        Stack<Character> symbol=new Stack<>();
        StringBuilder result=new StringBuilder();
        HashMap<Character,Integer> priority=new HashMap<>(6);
        priority.put('+',0);
        priority.put('-',0);
        priority.put('*',1);
        priority.put('/',1);
        priority.put('(',-1);
        priority.put(')',-1);
        char curSymbol;
        for (String infix1 : infix) {
            if (infix1.toCharArray().length == 1) {
                curSymbol = infix1.toCharArray()[0];
                if (priority.containsKey(curSymbol)) {
                    if (symbol.size() == 0) {
                        symbol.push(curSymbol);
                    } else if (curSymbol == '(') {
                        symbol.push(curSymbol);
                    } else if (curSymbol == ')') {
                        while (symbol.peek() != '(') {
                            result.append(symbol.pop());
                        }
                        symbol.pop();
                    } else if (priority.get(curSymbol) < priority.get(symbol.peek())) {
                        while (symbol.size() != 0 && symbol.peek() != '(') {
                            result.append(symbol.pop());
                        }
                        symbol.push(curSymbol);
                    } else {
                        symbol.push(curSymbol);
                    }

                } else {
                    result.append(infix1);
                    result.append(" ");
                }
            } else {
                result.append(infix1);
                result.append(" ");
            }
        }

        while(symbol.size()!=0) {
            result.append(symbol.pop());
        }
        return stringToList(result.toString());
    }

    /**
     * 计算后缀表达式
     * @param post 后缀表达式
     * @return 计算结果
     */
    public int calPostfix(String post) {
        ArrayList<String> listPost=infixToPostfix(post);
        System.out.println(this.toString(listPost));
        Stack<Integer> num=new Stack<>();
        Stack<Character> symbol=new Stack<>();
        int first,last;
        for (String s : listPost) {
            char curSymbol = s.toCharArray()[0];
            switch (curSymbol) {
                case '+':
                    last = num.pop();
                    first = num.pop();
                    num.push(first + last);
                    break;
                case '-':
                    last = num.pop();
                    first = num.pop();
                    num.push(first - last);
                    break;
                case '*':
                    last = num.pop();
                    first = num.pop();
                    num.push(first * last);
                    break;
                case '/':
                    last = num.pop();
                    first = num.pop();
                    num.push(first / last);
                    break;
                default:
                    num.push(Integer.parseInt(s));
            }
        }

        return num.pop();
    }


    public String toString(ArrayList post) {
        StringBuilder stringBuilder=new StringBuilder();
        String[] temp=post.toString().split(",");
        for (String s : temp) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String test="10-(3*5)/6";
        algs_works algsWorks=new algs_works();
        System.out.println(algsWorks.calPostfix(test));
    }
}
