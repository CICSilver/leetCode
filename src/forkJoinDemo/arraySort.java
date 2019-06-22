package forkJoinDemo;


import mytools.codeanalyze.Stopwatch;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class arraySort {
    public static void main(String[] s) {
        List<Integer> list=new ArrayList<>();
        ForkJoinPool pool=new ForkJoinPool();
        Random random=new Random();
        for(int i=0;i<10000000;i++) {
            list.add(random.nextInt(200000));
        }
        long[] nums=new long[list.size()];
        for(int i=0;i<nums.length;i++){
            nums[i]=Long.parseLong(list.get(i).toString());
        }

        Stopwatch timer=new Stopwatch();
        Collections.sort(list);
        System.out.println(list.get(500000));
        System.out.println("串行排序耗时："+timer.elapsedTime()+"秒");
        System.out.println("=================================================="+"数据量:"+list.size()+"==================================================");

        FastSort fastSort=new FastSort(nums);
        timer.reset();
        pool.execute(fastSort);
        while (!fastSort.isDone()) {}
        System.out.println("并发排序耗时："+timer.elapsedTime()+"秒");
        System.out.println(nums[500000]);
    }


}

class FastSort extends RecursiveAction {
    /**
     * 子任务阈值
     */
    private int THRESHOLD=12000;
    private int lo,hi;
    private long[] nums;



    FastSort(long[] nums,int lo,int hi){
        this.nums=nums;
        this.hi=hi;
        this.lo=lo;
        //1,250,000‬
        //this.THRESHOLD=nums.length/Runtime.getRuntime().availableProcessors();
    }

    FastSort(long[] nums) {
        this.nums=nums;
        //this.THRESHOLD=nums.length/Runtime.getRuntime().availableProcessors();
        this.lo=0;
        this.hi=nums.length-1;
    }


    @Override
    protected void compute() {
        if(hi-lo<THRESHOLD) {
            sequentiallySort(nums,lo,hi);
        }else {
            int priviot=partition(nums,lo,hi);
            FastSort left=new FastSort(nums,lo,priviot-1);
            FastSort right=new FastSort(nums,priviot+1,hi);
            invokeAll(left,right);
        }
    }

    private int partition(long[] nums,int lo,int hi) {
        long t=nums[hi];
        int i=lo-1;
        for(int j=lo;j<hi;j++) {
            if(nums[j]<=t) {
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,hi);
        return i+1;
    }

    private void swap(long[] nums,int i,int j) {
        if(i!=j) {
            long temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    private void sequentiallySort(long[] nums,int lo,int hi) {
        Arrays.sort(nums,lo,hi+1);
    }
}
