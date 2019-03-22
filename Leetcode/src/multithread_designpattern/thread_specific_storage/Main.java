package multithread_designpattern.thread_specific_storage;

public class Main {

    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bob").start();
        new ClientThread("Chris").start();
    }
}
