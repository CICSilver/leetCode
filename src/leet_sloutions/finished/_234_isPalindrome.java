package leet_sloutions.finished;

public class _234_isPalindrome {
    /**
     * 判断字符串是否为回文串
     */
    public boolean isPalindrome(String s) {
        if(s.length()==0|| s.length()==1) {
            return true;
        }
        s=s.toLowerCase();
        int left=0;
        int right=s.length()-1;
        while(left<right) {
            while((s.charAt(left)<'a' || s.charAt(left)>'z') &&(s.charAt(left)<'0' || s.charAt(left)>'9') && left<right ) {
                left++;
            }
            while((s.charAt(right)<'a' || s.charAt(right)>'z') &&(s.charAt(right)<'0' || s.charAt(right)>'9') && left<right ) {
                right--;
            }
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
