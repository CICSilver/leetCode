public class Solution {
    public int maxprofit(int[] prices) {
        int difference=0;
        int sum=0;
        for(int i=prices.length-1;i>0;i--) {
            difference=prices[i]-prices[i-1];
            if(difference>0)
                sum+=difference;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] price={7,1,5,3,6,4};
        Solution max=new Solution();
        int t=max.maxprofit(price);
        System.out.println(t);
    }
}

