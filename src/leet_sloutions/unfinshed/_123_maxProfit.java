package leet_sloutions.unfinshed;

import mytools.codeanalyze.Stopwatch;

import java.util.Random;


/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class _123_maxProfit {

    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length+1][2][3];
        for(int i=prices.length-1;i>=0;i--) {
            for(int j=1;j>=0;j--) {
                for(int k=2;k>=0;k--) {
                    if(k == 2 && j == 0) {
                        continue;
                    }
                    if(j>0) {
                        dp[i][j][k]=Math.max(dp[i+1][0][k]+prices[i],dp[i+1][1][k]);
                    }else {
                        dp[i][j][k]=Math.max(dp[i+1][1][k+1]-prices[i],dp[i+1][0][k]);
                    }
                }
            }
        }
        return dp[0][0][0];
    }

    public int maxProfitV2(int[] prices) {
        int fstBuy=Integer.MIN_VALUE,fstSell=0;
        int secBuy=Integer.MIN_VALUE,secSell=0;
        for (int p:prices) {
            fstBuy=Math.max(fstBuy,-p);
            fstSell=Math.max(fstSell,fstBuy+p);
            secBuy=Math.max(secBuy,fstSell-p);
            secSell=Math.max(secSell,secBuy+p);
        }
        return secSell;
    }

    /**
     * @param prices 价格
     * @param count 已交易次数
     * @param startDate 本次交易日期
     * @param hasStock 是否拥有股票
     * @return 最大利润
     */

    private int maxProfit(int[] prices,int count,int startDate,boolean hasStock) {
        if(startDate>=prices.length || (count>=2 && !hasStock)) {
            return 0;
        }
        if(hasStock) {
            //拥有股票，判断是否卖出
            return Math.max(maxProfit(prices,count,startDate+1,false)+prices[startDate],maxProfit(prices,count,startDate+1,true));
        }else {
            //没有股票，判断是否买入
            return Math.max(-prices[startDate]+maxProfit(prices,count+1,startDate+1,true),maxProfit(prices,count,startDate+1,false));
        }
    }



    public static void main(String[] args) {
        int[] temp=new int[10000000];
        Random random=new Random();
        for(int i=0;i<temp.length;i++) {
            temp[i]= random.nextInt();
        }

        //int[] temp={3,3,5,0,0,3,1,4};


        _123_maxProfit test=new _123_maxProfit();
        Stopwatch timer=new Stopwatch();
        //3,15,3,0,10,9,6,8,15,0
        System.out.println(test.maxProfit(temp));
        System.out.println(timer.elapsedTime());

        Stopwatch timer2=new Stopwatch();
        System.out.println(test.maxProfitV2(temp));
        System.out.println(timer2.elapsedTime());
    }
}
