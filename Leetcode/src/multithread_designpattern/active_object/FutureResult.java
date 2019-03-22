package multithread_designpattern.active_object;

public class FutureResult<T> extends Result<T> {
    private Result<T> result;
    private boolean ready;

    public synchronized void setResult(Result<T> result) {
        this.result = result;
        this.ready = true;
        notifyAll();
    }

    public synchronized T getResult() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return result.getResult();
    }
}
