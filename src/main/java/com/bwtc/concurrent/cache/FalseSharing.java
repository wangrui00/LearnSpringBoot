package com.bwtc.concurrent.cache;

/**
 * @Author wangrui
 * @Description:
 * @Date:Created in 18:11 2018/6/11
 **/
public class FalseSharing implements Runnable{

    public final static int NUM_THREADS=8;//change

    public final static long INTERATONS=500L*1000L*1000L;

    private final int arrayIndex;

    private static VolatileLong[] longs=new VolatileLong[NUM_THREADS];

    static{
        for(int i=0;i<longs.length;i++){
            longs[i]=new VolatileLong();
        }
    }

    public FalseSharing(final int arrayIndex){
        this.arrayIndex=arrayIndex;
    }

    public static void main(String[] args)throws Exception{
        final long start=System.currentTimeMillis();
        runTest();
        System.out.println("duration = "+(System.currentTimeMillis()-start));
    }

    private static void runTest() throws InterruptedException{

        Thread[] threads=new Thread[NUM_THREADS];

        for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(new FalseSharing(i));
        }

        for(Thread t:threads){
            t.start();
        }

        for(Thread t:threads){
            t.join();
        }
    }

    public void run(){
        long i=INTERATONS+1;
        while(0!=--i){
            longs[arrayIndex].value=i;
        }
    }

    public final static class VolatileLong{

        public volatile long value=0L;

        public long p1,p2,p3,p4,p5,p6,p7;//comment out
    }
}
//测试结果
//duration = 19046  8核
//duration = 29975