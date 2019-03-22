package multithread_designpattern.active_object;

public class SchedulerThread extends Thread {
    private final ActiveObjectQueue queue;

    public SchedulerThread(ActiveObjectQueue queue) {
        this.queue = queue;
    }

    public void invoke(MethodRequest request) {
        queue.putRequest(request);
    }

    @Override
    public void run() {
        while (true) {
            MethodRequest request = queue.takeRequest();
            request.execute();
        }
    }
}
