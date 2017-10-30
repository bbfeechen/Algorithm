package designpattern.singleton;

public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton() {
        System.out.println("instance is created.");
    }
    public static Singleton getInstance() {
        return singleton;
    }
}
