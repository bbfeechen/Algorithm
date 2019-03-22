package multithread_designpattern.two_phase_termination;

public class CountupThread extends Thread {

    private long counter;
    private volatile boolean shutdownRequested;

    public void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    @Override
    public void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (Exception e) {

        } finally {
            doShutdown();
        }
    }

    private void doWork() throws InterruptedException {
        counter--;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
