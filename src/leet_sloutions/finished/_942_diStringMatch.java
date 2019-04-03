package leet_sloutions.finished;

public class _942_diStringMatch {
    /**
     * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
     *
     * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
     *
     * 如果 S[i] == "I"，那么 A[i] < A[i+1]
     * 如果 S[i] == "D"，那么 A[i] > A[i+1]
     * 输入"IDID"
     * 输出"0,4,2,3,1"
     *      0,4,1,3,2
     *      0,1,2,3,4
     * 输入"DIDI"
     * 输出 4,0,3,1,2
     * "DDII"
     *  4,0
     * @param S 由"I"和"D"组成的字符串
     * @return 满足上述条件的数组，范围为[0,S.length()]
     */
    public int[] diStringMatch(String S) {
        if(S.length() == 0) {
            return null;
        }
        S=S.toUpperCase();
        int min=0,max=S.length();
        int[] result=new int[S.length()+1];
        for(int i=0;i<S.length();i++) {
            switch (S.charAt(i)) {
                case 'I':if(i==0) {
                    result[i]=min++;
                    result[i+1]=max--;
                } else
                if(result[i]>max) {
                    result[i]=min++;
                    max++;
                    result[i+1]=max--;
                } else {
                    result[i+1]=max--;
                }
                    break;
                case 'D':if(i==0) {
                    result[i]=max--;
                    result[i+1]=min++;
                } else
                if(result[i]<min) {
                    result[i]=max--;
                    min--;
                    result[i+1]=min++;
                } else {
                    result[i+1]=min++;
                }

                    break;
                default:
            }
        }
        return result;
    }
}
