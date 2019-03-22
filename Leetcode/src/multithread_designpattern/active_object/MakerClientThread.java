package multithread_designpattern.active_object;

public class MakerClientThread extends Thread {

    private final ActiveObject activeObject;
    private final char filechar;

    public MakerClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.filechar = name.charAt(0);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Result<String> result = activeObject.makeString(i, filechar);
                Thread.sleep(10);
                String value = result.getResult();
                System.out.println(Thread.currentThread().getName() + ": value = " + value);
            }
        } catch (InterruptedException e) {

        }
    }
}
