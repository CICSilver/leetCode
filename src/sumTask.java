import mytools.codeanalyze.Stopwatch;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class sumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD=10000;
    private long start;
    private long end;

    public sumTask(long start,long end) {
        this.start=start;
        this.end=end;
    }
    @Override
    protected Long compute() {
        long sum=0;
        boolean canCompute=(end-start)<THRESHOLD;
        //判断是否需要划分任务
        if(canCompute){
            for (long i=start;i<end;i++){
                sum+=i;
            }
        }else {
            //划分成100个小任务
            long step=(start+end)/90000;
            ArrayList<sumTask> subTasks=new ArrayList<>();
            long pos=start;
            for(int i=0;i<90000;i++) {
                long lastOne=pos+step;
                lastOne=lastOne>end?end:lastOne;
                sumTask subTask=new sumTask(pos,lastOne);
                pos+=step+1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for(sumTask t:subTasks){
                sum+=t.join();
            }
        }
        return sum;
    }


    public static void main(String[] s){
        long start=0,end=10000000L;
        Random random=new Random();
        long[] nums=new long[(int)end+1];
        for(int i=0;i<nums.length;i++){
            nums[i]=random.nextLong();
        }
        long sum=0;
        Stopwatch timer=new Stopwatch();
        for(long li:nums){
            sum+=li;
        }
        timer.elapsedTime();
        System.out.println(timer.elapsedTime());
        ForkJoinPool pool=new ForkJoinPool();
        sumTask sumTask=new sumTask(start,end);
        ForkJoinTask<Long> res=pool.submit(sumTask);
            try {
                timer.reset();
                long result=res.get();
                System.out.println(timer.elapsedTime());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
    }
}
