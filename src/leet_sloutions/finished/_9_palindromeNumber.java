package leet_sloutions.finished;

public class _9_palindromeNumber {

    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        int[] num=new int[Integer.toString(x).length()];
        for(int i=0;i<num.length;i++) {
            num[i]=x%10;
            x=(x-num[i])/10;
        }

        for(int i=0;i<num.length/2;i++) {
            if(num[i]!=num[num.length-1-i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _9_palindromeNumber test=new _9_palindromeNumber();
        System.out.println(test.isPalindrome(Integer.parseInt("1000000000000000000000000000000000000000000")));
    }
}
