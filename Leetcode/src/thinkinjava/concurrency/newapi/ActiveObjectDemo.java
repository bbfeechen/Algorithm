package thinkinjava.concurrency.newapi;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ActiveObjectDemo {
    private ExecutorService exec = Executors.newCachedThreadPool();
    private Random rand = new Random(47);

    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public Future<Integer> calculateInt(final int x, final int y) {
        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("starting " + x + " + " + y);
                pause(500);
                return x + y;
            }
        });
    }

    public Future<Float> calculateFloat(final float x, final float y) {
        return exec.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.println("starting " + x + " + " + y);
                pause(2000);
                return x + y;
            }
        });
    }

    public void shutdown() {
        exec.shutdown();
    }

    public static void main(String[] args) {
        ActiveObjectDemo d1 = new ActiveObjectDemo();
        List<Future<?>> results = new CopyOnWriteArrayList<>();
        for (float f = 0.0f; f < 1.0f; f += 0.2f) {
            results.add(d1.calculateFloat(f, f));
        }
        for (int i = 0; i < 5; i++) {
            results.add(d1.calculateInt(i, i));
        }

        System.out.println("All asynch calls made");
        while (results.size() > 0) {
            for (Future<?> f : results) {
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    results.remove(f);
                }
            }
        }
        d1.shutdown();
    }
}
