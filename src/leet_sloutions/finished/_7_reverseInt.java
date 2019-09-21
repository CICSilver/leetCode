package leet_sloutions.finished;

public class _7_reverseInt {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     */
    public int reverse(int x) {
        StringBuffer sb=new StringBuffer();
        String s=String.valueOf(x);
        int result =0;

        if(x<0) {
            sb.append(s.charAt(0));
        }
        for (int i = s.length()-1; i > 0; i--) {
            sb.append(s.charAt(i));
        }
        if(x>0) {
            sb.append(s.charAt(0));
        }
        s=sb.toString();

        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }


        return result;
    }
}
