package multithread_designpattern.future;

public class FutureData implements Data {
    private RealData realData;
    private boolean ready;

    public synchronized void setRealData(RealData realData) {
        if (ready) {
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.getContent();
    }
}
