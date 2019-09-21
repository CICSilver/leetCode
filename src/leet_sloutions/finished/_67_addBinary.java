package leet_sloutions.finished;

/**
 * 二进制求和
 */
public class _67_addBinary {
    public String addBinary(String a, String b) {
        char[] longNum;
        String shortNum;
        if(a==null||"".equals(a)) {
            return b;
        }
        if(b==null||"".equals(b)){
            return a;
        }
        if(a.length()>b.length()) {
            longNum=a.toCharArray();
            shortNum=b;
        }else {
            longNum=b.toCharArray();
            shortNum=a;
        }
        for(int i=shortNum.length()-1;i>=0;i--) {
            if(shortNum.charAt(i)=='1') {
                //对齐
                for(int j=longNum.length-shortNum.length()+i;j>=0;j--) {
                    if(longNum[j]=='1'){
                        longNum[j]='0';
                        if(j==0){
                            char[] res=new char[longNum.length+1];
                            System.arraycopy(longNum,0,res,1,longNum.length);
                            res[0]='1';
                            longNum=res;
                        }
                    }else {
                        longNum[j]='1';
                        break;
                    }
                }
            }
        }
        StringBuilder res=new StringBuilder();
        for (char c:longNum) {
            res.append(c);
        }
        return res.toString();

    }

    public static void main(String[] s){
        _67_addBinary test=new _67_addBinary();
        String a="";
        String b="1";
        System.out.println(test.addBinary(a,b));
    }
}
