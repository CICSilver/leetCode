package leet_sloutions.finished;

public class _66_plusOne {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public int[] plusOne(int[] digits) {
        if(digits.length != 1&&digits[0]==0) {
            return digits;
        }

        if(digits[digits.length-1]==9){

            if(digits[0]==9) {
                int[] temp=new int[digits.length+1];
                temp[0]=1;
                for(int i=1;i<temp.length;i++) {
                    temp[i]=0;
                }
                return temp;
            }
            else {
                for (int i = digits.length-1; i >=0; i--) {
                    if (digits[i] != 9) {
                        digits[i] += 1;
                        for (int j = i+1; j <digits.length; j++) {
                            digits[j] = 0;
                        }
                        break;
                    }
                }
                return digits;
            }
        }
        else {
            digits[digits.length - 1] += 1;
            return digits;
        }


    }
}
