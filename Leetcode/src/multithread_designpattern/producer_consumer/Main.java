package multithread_designpattern.producer_consumer;

public class Main {

    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-1", table, 92653).start();
        new MakerThread("MakerThread-1", table, 58979).start();
        new EaterThread("MakerThread-1", table, 32384).start();
        new EaterThread("MakerThread-1", table, 62643).start();
        new EaterThread("MakerThread-1", table, 38327).start();
    }
}
