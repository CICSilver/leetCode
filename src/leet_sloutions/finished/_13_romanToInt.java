package leet_sloutions.finished;

public class _13_romanToInt {
    /**
     * 罗马数字转整型数
     */
    public int romanToInt(String s) {
        if(s==null) {
            return 0;
        }
        s=s.toUpperCase();
        int[] temp=new int[s.length()];
        int result=0;
        for(int i=0;i<s.length();i++) {
            switch (s.charAt(i)) {
                case 'I':temp[i]=1;break;
                case 'V':temp[i]=5;break;
                case 'X':temp[i]=10;break;
                case 'L':temp[i]=50;break;
                case 'C':temp[i]=100;break;
                case 'D':temp[i]=500;break;
                case 'M':temp[i]=1000;break;
                default:
            }
        }
        for(int i=0;i<temp.length-1;i++) {
            if(temp[i]<temp[i+1]) {
                result-=temp[i];
            } else {
                result+=temp[i];
            }
        }
        result+=temp[temp.length-1];
        return result;
    }
}
