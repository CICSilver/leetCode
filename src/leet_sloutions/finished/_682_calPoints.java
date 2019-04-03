package leet_sloutions.finished;

import java.util.Stack;

public class _682_calPoints {
    /**
     * 你现在是棒球比赛记录员。
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效
     * 回合的分数是无效的，应该被移除。
     *
     * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
     * 你需要返回你在所有回合中得分的总和。
     */
    public int calPoints(String[] ops) {
        Stack<Integer> count=new Stack<>();
        int min=-30000;
        int max=30000;
        int sum=0;

        int temp=0;
        for (String s: ops) {
            if((int)s.charAt(0)==67) {
                //当前位为C
                count.pop();
                continue;
            } else if((int)s.charAt(0)==68) {
                //当前位为D
                count.add(count.peek()*2);
                continue;
            } else if((int)s.charAt(0)==43) {
                //当前位为+
                if(count.size()<2) {
                    count.add(count.peek());
                    continue;
                } else {
                    count.add(count.peek() + count.elementAt(count.size() - 2));
                    continue;
                }
            }

            try {
                Integer.parseInt(s);
            } catch (Exception e) {
                continue;
            }
            temp= Integer.parseInt(s);
            if(temp>min&&temp<max) {
                //当前位为整数
                count.add(temp);
            } else {
                throw new OutOfMemoryError();
            }
        }
        while(count.size()!=0) {
            sum+=count.pop();
        }
        return sum;
    }
}
