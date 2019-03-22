package multithread_designpattern.two_phase_termination;

public class Main {

    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            CountupThread t = new CountupThread();
            t.start();

            Thread.sleep(10000);

            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            System.out.println("main: join");
            t.join();
        } catch (InterruptedException e) {

        }

        System.out.println("main: END");
    }
}
