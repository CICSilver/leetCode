public class compareVersionClass {
    /**
     * 比较两个版本号 version1 和 version2。
     * 你可以假设版本字符串
     * 非空，并且只包含数字和 . 字符。
     * @param version1 版本1
     * @param version2 版本2
     * @return 如果 version1 > version2 返回 1，如果 version1 < version2 返回
     * -1，除此之外返回 0。
     */
    public int compareVersion(String version1,String version2) {
        String[] versionOne=version1.split("\\.");
        String[] versionTwo=version2.split("\\.");
        boolean isShort=false,equal=false;
        int len1,len2,len,result;
        versionOne=deleteZeroInTail(versionOne);
        versionTwo=deleteZeroInTail(versionTwo);
        len1=versionOne.length;
        len2=versionTwo.length;
        if(len1<len2) {
            len=len1;
            isShort=true;
        }
        else if(len1>len2) {
            len=len2;
        }
        else {
            len=len1;
            equal=true;
        }
            result=compareVersion(versionOne,versionTwo,len);
            if(result==0) {
                if(isShort) {
                    return  -1;
                }
                else {
                    if(equal) {
                        return 0;
                    }
                    return 1;
                }
            }
        return result;
    }
    private int compareVersion(String[] versionOne,String[] versionTwo,int len) {
        for(int i=0;i<len;i++) {
                //version1长度大于version2
                if (!versionOne[i].equals(versionTwo[i])) {
                    if (Integer.parseInt(versionOne[i]) > Integer.parseInt(versionTwo[i])) {
                        return 1;
                    } else if (Integer.parseInt(versionOne[i]) < Integer.parseInt(versionTwo[i])) {
                        return -1;
                    }
                }
        }
        return 0;

    }
    public String[] deleteZeroInTail(String[] str) {
        int len=str.length;
        if(len==1) {
            return str;
        }
        String[] temp=new String[len];
        String[] result;
        int count=len;
        for(int i=len-1;i>=0;i--) {
            if((str[i].split("0")).length!=0&&i==len-1) {
                return str;
            }
            if((str[i].split("0")).length==0) {
                count--;
            } else {
                break;
            }
        }
        System.arraycopy(str,0,temp,0,count);
        result=new String[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }
    public static void main(String[] args) {
        String str1="1.0000000.0000000.000000.00000000";
        String str2="1.1.0000.0.0.0.0.0.0.0000000000000";
        String str="000000";
        compareVersionClass cvc=new compareVersionClass();
        int result=cvc.compareVersion(str1,str2);
        System.out.println(result);
    }
}
