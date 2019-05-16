package leet_sloutions.finished;

public class _8_myAtoi {
    public int myAtoi(String str) {
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        boolean negative=false;
        int res=0;
        int first=0;
        StringBuilder num=new StringBuilder();
        if(str.length()==0) {
            return res;
        }
        else
        if(str.length()==1) {
            if(str.charAt(0)>='0'&&str.charAt(0)<='9' ){
                return Integer.parseInt(str);
            } else {
                return res;
            }
        }
        else {
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) != ' ') {
                    if (str.charAt(i) == '-') {
                        negative = true;
                        first = i+1;
                        break;
                    }else if(str.charAt(i)=='+') {
                        first=i+1;
                        break;
                    } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                        return res;
                    } else {
                        first = i;
                        break;
                    }
                }
            }
            int j=first;
            while(j<str.length()) {
                char cur=str.charAt(j);
                if(cur<'0' || cur>'9') {
                    break;
                }else {
                    num.append(cur);
                }
                j++;
            }
            if("".equals(num.toString())) {
                return res;
            }
            try{
                res=Integer.parseInt(num.toString());
            }catch(NumberFormatException e) {
                if(negative) {
                    return min;
                } else {
                    return max;
                }
            }
        }

        return negative? -res : res;
    }
    //-tsa43
    public static void main(String[] args) {
        _8_myAtoi test=new _8_myAtoi();
        System.out.println(test.myAtoi("  "));
    }
}
