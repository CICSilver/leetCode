package leet_sloutions.finished;

public class _242_isAnagram {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     * 即两个字符串中字母是否完全相同
     * 例如：s="art",t="rat",返回"true"
     * 可以假设字符串只包含小写字母
     * @param s 标准字符串
     * @param t 判断字符串
     * @return true or false
     */
    public boolean isAnagram(String s, String t) {
        int lenS=s.length(),lenT=t.length();
        if(lenS==0&&lenT==0) {
            return true;
        }
        if(lenS==1&&lenT==1) {
            return s.equals(t);
        }
        if(lenS!=lenT) {
            return false;
        }
        String temp;
        int i=0;
        while(!"".equals(s)) {
            StringBuilder strS=new StringBuilder();
            StringBuilder strT=new StringBuilder();
            temp=Character.toString(s.charAt(i));
            for(String string:s.split(temp)) {
                strS.append(string);
            }
            s=strS.toString();
            lenS=s.length();
            for(String string:t.split(temp)) {
                strT.append(string);
            }
            t=strT.toString();
            lenT=t.length();
            if(lenS!=lenT) {
                return false;
            }
            if(s.equals(t)) {
                return true;
            }
        }
        return false;
    }
}
