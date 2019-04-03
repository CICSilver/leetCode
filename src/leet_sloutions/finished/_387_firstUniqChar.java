package leet_sloutions.finished;

public class _387_firstUniqChar {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在
     * ，则返回 -1。
     */
    public int firstUniqChar(String s) {
        int len=s.length();
        if(len==0) {return -1;}
        if(len==1) {return 0;}
        int id=0;
        char s1,s2;
        int[] muilteCharId=new int[len];
        int startId=0;
        int endId=len-1;
        while(startId!=len-1) {
            for(;endId>startId;endId--) {
                if(startId!=0&&muilteCharId[startId]!=0) {
                    break;
                }
                s1=s.charAt(startId);
                s2=s.charAt(endId);
                if(muilteCharId[endId]!=0) {
                    if(s1==s2) {
                        break;
                    }
                }
                if (s1!= s2) {
                    if(endId-1==startId) {
                        return startId;
                    }
                }
                else {
                    muilteCharId[endId]=endId;
                    break;
                }
            }
            startId++;
            if(startId==len-1&&muilteCharId[startId]==0) {
                return startId;
            }
            endId=len-1;

        }
        return -1;
    }
}
